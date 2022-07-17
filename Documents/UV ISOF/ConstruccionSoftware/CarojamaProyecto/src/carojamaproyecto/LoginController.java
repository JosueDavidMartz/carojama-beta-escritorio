/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

import static carojamaproyecto.RegistroNuevoUsuarioController.getConnection;
import casos_uso.Usuarios;
import clases.Usuario;
import java.awt.Color;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author WIN 10
 */
public class LoginController implements Initializable {

    @FXML
    private Pane paneLogin;
    @FXML
    private TextField tfNombre;
    private TextField tfContraseña;
    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbError;
    @FXML
    private Button btnCrearNuevaCuenta;
    
    public static Usuario usuarioR;
    @FXML
    private PasswordField pfContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void clicIngresar(ActionEvent event) {
        
        int idUsuario = 0;
        Usuarios usuarioHelper = new Usuarios(getConnection());
         
        if(tfNombre.getText().isEmpty() || pfContraseña.getText().isEmpty()){
            if(tfNombre.getText().isEmpty()){
                tfNombre.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            }else{
                tfNombre.setStyle(null);
            }
            if(pfContraseña.getText().isEmpty()){
                pfContraseña.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            }else{
                pfContraseña.setStyle(null);
            }
            lbError.setText("HAY CAMPOS VACÍOS");
        }else{           
            System.out.println(tfNombre.getText());
            System.out.println(pfContraseña.getText());
            idUsuario = usuarioHelper.iniciarSesion(tfNombre.getText(), pfContraseña.getText());
            if(idUsuario!=0){
                usuarioR = usuarioHelper.buscarPorId(idUsuario);
                mostrarPantallaMiPerfil();
            }
        }
    }

    @FXML
    private void clicCrearCuenta(ActionEvent event) {       
        try{
            Parent cargaFXML = FXMLLoader.load(getClass().getResource("RegistroNuevoUsuario.fxml"));
            Scene sceneFeed = new Scene(cargaFXML);
            Stage stage = new Stage();
            stage.setScene(sceneFeed);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();        
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar a la pantalla <RegistroNuevoUsuario> " +e.getMessage());
        }       
    }

    @FXML
    private void clicSalir(ActionEvent event) {
    }
    
    public void mostrarPantallaMiPerfil(){    
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
    
    //CONEXION BD
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
