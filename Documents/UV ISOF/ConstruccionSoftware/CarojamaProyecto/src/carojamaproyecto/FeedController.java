/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
public class FeedController implements Initializable {

    @FXML
    private Pane paneMenuTop;
    @FXML
    private Label lbMiPerfil;
    @FXML
    private TextField tfBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Pane paneCentral;
    @FXML
    private Pane panePublicar;
    @FXML
    private TextField tfPublicar;
    @FXML
    private Button btnPublicar;
    @FXML
    private Button btnSubirPublicar;
   
    private boolean ban=false;
    @FXML
    private Label lbAmigos;
    @FXML
    private VBox vbChat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vbChat.setVisible(ban);
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
    private void clicBuscar(ActionEvent event) {
    }

    @FXML
    private void clicPublicar(ActionEvent event) {
    }

    @FXML
    private void clicSubir(ActionEvent event) {
    }

   
    
}
