/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

import static carojamaproyecto.MiPerfilController.getConnection;
import static carojamaproyecto.MiPerfilController.usuarioR;
import casos_uso.Usuarios;
import clases.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author WIN 10
 */
public class PerfilVisitaController implements Initializable {

    @FXML
    private Pane paneMenuTop;
    @FXML
    private Button btnBuscar;
    @FXML
    private Label lbMiPerfil;
    @FXML
    private TextField tfBuscar;
    @FXML
    private Pane paneCabecera;
    @FXML
    private Label lbNombrePerfil;
    @FXML
    private Label lbSobreMi;
    @FXML
    private Label lbCorreo;
    @FXML
    private TextArea taFotoPerfil;
    @FXML
    private Label lbValorNombrePerfil;
    @FXML
    private Label lbValorSobreMi;
    @FXML
    private Label lbValorCorreo;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEnviarMensaje;
    @FXML
    private Button btnSeguir;
    @FXML
    private ScrollPane paneScrollPrincipal;
    @FXML
    private AnchorPane scrollPaneSecundario;
    @FXML
    private Pane paneBotonVentas;
    @FXML
    private Button btnVentas;
    @FXML
    private Pane paneTextoColecciones;
    @FXML
    private Label lbColecciones;
    @FXML
    private Pane paneMenuBar;
    @FXML
    private MenuBar menuBarCategorias;
     private boolean ban=false;
    @FXML
    private Label lbAmigos;
    
    private Usuario[] amigos;
    
    private Pane paneChat;
    @FXML
    private VBox vbChat;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarElementos();
        
    }    
    
    public void inicializarElementos(){
        MiPerfilController usuario = new MiPerfilController();
        Usuario usuarioR = usuario.usuarioR;       
        lbValorCorreo.setText(usuarioR.getCorreo());
        lbValorNombrePerfil.setText(usuarioR.getNombre());
        lbValorSobreMi.setText(usuarioR.getDescripcion());
        
        actualizarContactos();
        vbChat.setVisible(ban);

    }

    @FXML
    private void clicBuscar(ActionEvent event) {
        Usuarios buscarUs = new Usuarios(getConnection());
        usuarioR = buscarUs.buscarUsuario(tfBuscar.getText());
       
        
        if(usuarioR.getIdUsuario()!=0){
            try{
            Parent cargaFXML = FXMLLoader.load(getClass().getResource("PerfilVisita.fxml"));
            Scene sceneFeed = new Scene(cargaFXML);
            Stage stage = new Stage();
            stage.setScene(sceneFeed);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
          
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar a la pantalla <PerfilVisita> " +e.getMessage());
        }
        }
    }

    @FXML
    private void clicMiPerfil(MouseEvent event) {
        try{
            Parent cargaFXML = FXMLLoader.load(getClass().getResource("MiPerfil.fxml"));
            Scene sceneFeed = new Scene(cargaFXML);
            Stage stage = new Stage();
            stage.setScene(sceneFeed);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
          
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar a la pantalla <MiPerfil> " +e.getMessage());
        }
    }


    @FXML
    private void clicFeed(MouseEvent event) {
        try{
            Parent cargaFXML = FXMLLoader.load(getClass().getResource("Feed.fxml"));
            Scene sceneFeed = new Scene(cargaFXML);
            Stage stage = new Stage();
            stage.setScene(sceneFeed);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
          
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar a la pantalla <Feed> " +e.getMessage());
        }
    }

    @FXML
    private void clicAgregarAmigo(ActionEvent event) {
        LoginController iniciarLogin = new LoginController();
        Usuario usuarioR = iniciarLogin.usuarioR;
        Usuarios agregarAmigo = new Usuarios(getConnection());
      
        boolean resultado = agregarAmigo.AñadirAmigo(lbValorNombrePerfil.getText(), usuarioR.getIdUsuario());
        
        actualizarContactos();
        
    }
    
    private void actualizarContactos(){
        LoginController iniciarLogin = new LoginController();
        Usuario usuarioR = iniciarLogin.usuarioR;
        Usuarios actualizarChat = new Usuarios(getConnection());
        String arregloAmigos[] = actualizarChat.actualizarContactos(usuarioR.getIdUsuario());  

        for(int i=0; i<=arregloAmigos.length-1; i++){
            if(arregloAmigos[i]!=null){
                vbChat.getChildren().add(new Label(arregloAmigos[i]));        
            }
            
        }   
    }


    @FXML
    private void clicEnviarMensaje(ActionEvent event) {
    }

    @FXML
    private void clicSeguirUsuario(ActionEvent event) {
    }

    @FXML
    private void clicBotonVentas(ActionEvent event) {
    }

    @FXML
    private void clicAmigos(MouseEvent event) {
         if(ban==false){
        vbChat.setVisible(true);
        ban=true;
        } else{
           vbChat.setVisible(false);
           ban=false;
        }
    }
    
}
