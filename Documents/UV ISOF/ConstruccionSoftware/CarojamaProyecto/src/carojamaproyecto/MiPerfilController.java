/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;


import casos_uso.Usuarios;
import clases.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollBar;
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
public class MiPerfilController implements Initializable {

    @FXML
    private Pane paneMenuTop;
    @FXML
    private Button btnBuscar;
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
    private TextArea taFotoPerfil;
    @FXML
    private Label lbValorNombrePerfil;
    @FXML
    private Label lbValorSobreMi;
    @FXML
    private Label lbValorCorreo;
    @FXML
    private ScrollPane paneScrollPrincipal;
    @FXML
    private MenuBar menuBarCategorias;
    @FXML
    private Pane paneTextoColecciones;
    @FXML
    private Label lbColecciones;
    @FXML
    private Pane paneBotonVentas;
    @FXML
    private AnchorPane scrollPaneSecundario;
    @FXML
    private Label lbFeed;
    @FXML
    private Button btnBotonVentas;
    @FXML
    private Pane paneBotonesAgregar;
    @FXML
    private Button btnAddColeccion;
    @FXML
    private Button btnAddArticulo;
    @FXML
    private Label lbFotoPerfil;
    
    public static Usuario usuarioR;
    @FXML
    private Label lbAmigos;
   
    
    private boolean ban=false;
    @FXML
    private VBox vbChat;
    
    public static int idUsuarioActual;

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
        inicializarElementos();
        
    }    
    
    public void inicializarElementos(){
        LoginController iniciarLogin = new LoginController();
        Usuario usuarioR = iniciarLogin.usuarioR;
        
        lbValorCorreo.setText(usuarioR.getCorreo());
        lbValorNombrePerfil.setText(usuarioR.getNombre());
        lbValorSobreMi.setText(usuarioR.getDescripcion());
        
        actualizarContactos();
        vbChat.setVisible(ban);
        
        
        
       
    }
    
    public void inicializarComponentes(){
        //lbValorNombrePerfil.setText("sasasas14");
        
    }

    @FXML
    private void clicBuscar(ActionEvent event) {
        
        Usuarios buscarUs = new Usuarios(getConnection());
        usuarioR = buscarUs.buscarUsuario(tfBuscar.getText());
        //System.out.println("el id de "+tfBuscar.getText()+" es "+id);
        
        if(usuarioR.getIdUsuario()!=0){
            try{
            Parent cargaFXML = FXMLLoader.load(getClass().getResource("PerfilVisita.fxml"));
            Scene sceneFeed = new Scene(cargaFXML);
            Stage stage = new Stage();
            stage.setScene(sceneFeed);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
          
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar a la pantalla <PeriflVisita> " +e.getMessage());
        }
        }
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
    private void clicBotonVentas(ActionEvent event) {
    }

    @FXML
    private void clicAddColeccion(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = new NuevaColeccionController();
        Scene scene = new Scene(root, 550, 480);
        stage.setTitle("Nueva Coleccion");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clicAddArticulo(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = new NuevoArticuloController();
        Scene scene = new Scene(root, 550, 480);
        stage.setTitle("Nuevo Articulo");
        stage.setScene(scene);
        stage.show();
        
      
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
    
    public static Connection getConnection(){ 
         Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sistemacarojama?serverTimezone=UTC", "root", "cisco");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroNuevoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroNuevoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
