/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

import java.sql.*;
import casos_uso.Usuarios;
import clases.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author WIN 10
 */
public class CarojamaProyecto extends Application {
    
    @Override
     public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
      
     
        
        /*try {
            

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sistemacarojama?serverTimezone=UTC", "root", "cisco");
            System.out.println("conectado a la base de datos");
            
            Usuarios usuariosHelper = new  Usuarios(conn);
            
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombre("caracola");
            usuarioNuevo.setEdad("20");
            usuarioNuevo.setCorreo("caracola@outlook.es");
            usuarioNuevo.setDescripcion("error");
            usuariosHelper.Registrar(usuarioNuevo);  //agrega a la base de datos el nuevo usaurio
            
            List<Usuario> listaUsuarios = usuariosHelper.Lista();
            
            for(Usuario usuario : listaUsuarios) {
                System.out.println(usuario.getIdUsuario());
                System.out.println(usuario.getNombre());
                System.out.println(usuario.getEdad());
                System.out.println(usuario.getCorreo());
                System.out.println(usuario.getDescripcion());
            
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
*/
      
    }
    
}
