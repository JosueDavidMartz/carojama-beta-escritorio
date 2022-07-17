/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

import NuevaConexion.Conexion;
import casos_uso.Usuarios;
import clases.FotoUsuario;
import clases.Usuario;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.text.IconView;

/**
 * FXML Controller class
 *
 * @author WIN 10
 */
public class RegistroNuevoUsuarioController implements Initializable {
    
    private TextField prueba;

    @FXML
    private TextField tfNombre;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Button btnSalir;
    @FXML
    private TextField tfDescripcion;
    private MenuButton mbEdad;
    @FXML
    private TextField tfCorreo;
    
    private TextArea taCargarFoto;

    String archivoFoto = "";
    private ScrollPane spFotoPerfil;
    @FXML
    private ScrollPane spFotoDePerfil;
    @FXML
    private AnchorPane anchorPFotoPerfil;
    @FXML
    private TextField tfEdad;
    
    private ImageView fotoCargada = null;
    @FXML
    private Label lbError;
    @FXML
    private PasswordField pfContraseña;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciarElementos();
    }    
    
    public void iniciarElementos(){
      
        
      /*  
        
       // create menuitems
        MenuItem m1 = new MenuItem("15");
        MenuItem m2 = new MenuItem("16");
        MenuItem m3 = new MenuItem("17");
        MenuItem m4 = new MenuItem("18");
        MenuItem m5 = new MenuItem("19");
        MenuItem m6 = new MenuItem("20");
        MenuItem m7 = new MenuItem("21");
        MenuItem m8 = new MenuItem("22");
        MenuItem m9 = new MenuItem("23");
        MenuItem m10 = new MenuItem("24");
        MenuItem m11 = new MenuItem("25");
        MenuItem m12 = new MenuItem("26");
        MenuItem m13 = new MenuItem("27");
        MenuItem m14 = new MenuItem("28");
        MenuItem m15 = new MenuItem("29");
        MenuItem m16 = new MenuItem("30");
        MenuItem m17 = new MenuItem("31");
        MenuItem m18 = new MenuItem("32");
        MenuItem m19 = new MenuItem("33");
        MenuItem m20 = new MenuItem("34");
        MenuItem m21 = new MenuItem("35");
        MenuItem m22 = new MenuItem("36");
        MenuItem m23 = new MenuItem("37");
        MenuItem m24 = new MenuItem("38");
        MenuItem m25 = new MenuItem("39");
        
  
        // add menu items to menu
        mbEdad.getItems().addAll(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24,m25);
       
       */
    }
    

    @FXML
    private void clicSalir(ActionEvent event) {
        
    }
    

    @FXML
    private void clicRegistrar(ActionEvent event) throws FileNotFoundException, IOException { //SIN VALIDAR CARACTERES PERMITIDOS   
        
        if(tfNombre.getText().isEmpty() || tfEdad.getText().isEmpty() || tfCorreo.getText().isEmpty() || pfContraseña.getText().isEmpty()){
            if(tfNombre.getText().isEmpty()){
                tfNombre.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            }else{
                tfNombre.setStyle(null);
            }
            if(tfEdad.getText().isEmpty()){
                tfEdad.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");             
            }else{
                 tfEdad.setStyle(null);
            }
            if(tfCorreo.getText().isEmpty()){
                tfCorreo.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");    
            }else{
                 tfCorreo.setStyle(null);
            }
            if(pfContraseña.getText().isEmpty()){
                pfContraseña.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
            }else{
                pfContraseña.setStyle(null);
            }
            lbError.setText("HAY CAMPOS OBLIGATORIOS VACÍOS");
        }else{       
            Usuarios usuarioHelper = new Usuarios(getConnection());
            if(archivoFoto.length()>0){
               
                File fImagenOriginal = new File(archivoFoto);     
                FileInputStream in = new FileInputStream(fImagenOriginal);
                long size = fImagenOriginal.length();
                byte[] temp = new byte[(int)size];
                in.read(temp);
                in.close();
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./fotoPerfil/"+"output.jpg"))));
                dos.write(temp);
                dos.close();            
            }else{
                System.out.println("No haz cargado una fotografía");
            }
            FotoUsuario nuevafotoPerfil = new FotoUsuario(); //foto perfil
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(tfNombre.getText());
            nuevoUsuario.setEdad(tfEdad.getText());
            nuevoUsuario.setCorreo(tfCorreo.getText());
            nuevoUsuario.setDescripcion(tfDescripcion.getText());
            nuevoUsuario.setContraseña(pfContraseña.getText());

            usuarioHelper.Registrar(nuevoUsuario);
        }
    }  

    @FXML
    private void clicSubirFoto(MouseEvent event) {      
        FileChooser dialogArch = new FileChooser();
        FotoUsuario usuario  = new FotoUsuario();    
        //ImageView fotoCargada = new ImageView();
        fotoCargada = new ImageView();
        fotoCargada.setFitWidth(82);
        fotoCargada.setFitHeight(93);   
        spFotoDePerfil.setContent(fotoCargada);
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imagenes JPEG", "*.jpg; *.jpeg");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("Imagenes PNG", "*.png");
        dialogArch.getExtensionFilters().addAll(extFilter, extFilter2);       
        File archivo = dialogArch.showOpenDialog(null);
        if(archivo!=null){
            Image imagen = new Image(archivo.toURI().toString());
            archivoFoto = archivo.getAbsolutePath(); 
            fotoCargada.setImage(imagen); 
           // usuario.getFotoPerfil().setImage(imagen);
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
