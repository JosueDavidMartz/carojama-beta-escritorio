/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carojamaproyecto;

import casos_uso.Usuarios;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WIN 10
 */
public class NuevoArticuloController extends Pane {
    Pane contenidoArticulo;
    Label nombreColecc;
    Label fotoArticulo;
    GridPane contenedorIzquierda, contenedorDerecha;
    Label nombreArticulo ,descripcionArticulo, calidadArticulo, cantidadArticulo, condicionVenta, condicionIntercambio, precio;
    TextField tfNombreArticulo, tfDescripcionArticulo, tfCantidadArticulo, tfPrecio, tfNuevoElemento;
    ChoiceBox cbCalidadArticulo, cbCondicionVenta, cbCondicionIntercambio;
    Button btnNuevoAtributo,btnCancelar, btnAceptar;
    TextField elemento1,elemento2,elemento3,elemento4,elemento5,elemento6,elemento7,elemento8,elemento9,elemento10,elemento11;
    TextField elemento12,elemento13,elemento14,elemento15,elemento16,elemento17,elemento18,elemento19,elemento20,elemento21,elemento22;
    TextField elemento23,elemento24,elemento25,elemento26,elemento27,elemento28,elemento29,elemento30;
   
    //CONTENIDO ELIGE COLECCION
    Pane contenidoEleccion;
    Label tituloEleccion;
    MenuButton coleccion, grupo, categoria, subcategoria;
    Button aceptar, cancelar;
    HBox contenedorMenuButton;
    
    
    public NuevoArticuloController(){
             
        
         
            contenidoArticulo = new Pane();
            
            nombreColecc = new Label();
            nombreColecc.setLayoutX(10);
            nombreColecc.setLayoutY(5);
            fotoArticulo = new Label();
            fotoArticulo.setMinSize(100,100);
            fotoArticulo.setLayoutX(10);
            fotoArticulo.setLayoutY(25);
            fotoArticulo.setText("FOTO");
            
            contenedorIzquierda = new GridPane();
            contenedorIzquierda.setLayoutX(10);
            contenedorIzquierda.setLayoutY(150);
            contenedorIzquierda.setVgap(8);
            contenedorIzquierda.setHgap(10);
            
            nombreArticulo = new Label("Nombre");
            descripcionArticulo = new Label("Descripción");
            calidadArticulo = new Label("Calidad");
            cantidadArticulo = new Label("Cantidad");
            condicionVenta = new Label("Venta");
            condicionIntercambio = new Label("Intercambio");
            precio = new Label("Precio");
           
            tfNombreArticulo = new TextField();
            tfNombreArticulo.setPrefWidth(100);
            tfNombreArticulo.setMaxWidth(100);
            tfDescripcionArticulo = new TextField();
            tfDescripcionArticulo.setPrefWidth(100);
            tfDescripcionArticulo.setMaxWidth(100);
            cbCalidadArticulo = new ChoiceBox();
            tfCantidadArticulo = new TextField();
            tfCantidadArticulo.setPrefWidth(30);
            tfCantidadArticulo.setMaxWidth(30);
            cbCondicionVenta = new ChoiceBox();
            cbCondicionIntercambio = new ChoiceBox();
            tfPrecio = new TextField();
            tfPrecio.setPrefWidth(40);
            tfPrecio.setMaxWidth(40);

            contenedorIzquierda.add(nombreArticulo, 0, 0);
            contenedorIzquierda.add(descripcionArticulo, 0, 1);
            contenedorIzquierda.add(calidadArticulo, 0, 2);
            contenedorIzquierda.add(cantidadArticulo, 0, 3);
            contenedorIzquierda.add(condicionVenta, 0, 4);
            contenedorIzquierda.add(condicionIntercambio, 0, 5);
            contenedorIzquierda.add(precio, 0, 6);

            contenedorIzquierda.add(tfNombreArticulo, 1, 0);
            contenedorIzquierda.add(tfDescripcionArticulo, 1, 1);
            contenedorIzquierda.add(cbCalidadArticulo, 1, 2);
            contenedorIzquierda.add(tfCantidadArticulo, 1, 3);
            contenedorIzquierda.add(cbCondicionVenta, 1, 4);
            contenedorIzquierda.add(cbCondicionIntercambio, 1, 5);
            contenedorIzquierda.add(tfPrecio, 1, 6);
           
            Separator separador = new Separator(Orientation.VERTICAL);
            separador.setLayoutX(150);
            separador.setLayoutY(5);
            separador.setMinSize(100, 470);
            
            contenedorDerecha = new GridPane();
            contenedorDerecha.setLayoutX(210);
            contenedorDerecha.setLayoutY(10);
            contenedorDerecha.setVgap(8);
            contenedorDerecha.setHgap(25);
            
            //ScrollPane scroll = new ScrollPane(contenedorDerecha);
            
            btnNuevoAtributo = new Button("+Elemento propio");
            btnNuevoAtributo.setLayoutX(45);
            btnNuevoAtributo.setLayoutY(430);
            tfNuevoElemento = new TextField();
            tfNuevoElemento.setLayoutX(25);
            tfNuevoElemento.setLayoutY(395);
            tfNuevoElemento.setMaxWidth(150);
            tfNuevoElemento.setPrefWidth(150);
            btnCancelar = new Button("Cancelar");
            btnCancelar.setLayoutX(390);
            btnCancelar.setLayoutY(430);
            btnAceptar = new Button("Aceptar");
            btnAceptar.setLayoutX(470);
            btnAceptar.setLayoutY(430);
            
            //CONTENIDO ELIGE COLECCION
            contenidoEleccion = new Pane();
            
            tituloEleccion = new Label("SELECCIONA A QUÉ COLECCIÓN Y SECCIÓN\nAGREGARÁS EL NUEVO ARTICULO");
            coleccion = new MenuButton("Colección");
            grupo = new MenuButton("Grupo");
            categoria = new MenuButton("Categoría");
            subcategoria = new MenuButton("Subcategoría");
            aceptar = new Button("Aceptar");
            cancelar = new Button("Cancelar");
            
            contenedorMenuButton = new HBox(6);
            contenedorMenuButton.setAlignment(Pos.CENTER);
            contenedorMenuButton.getChildren().addAll(coleccion,grupo,categoria,subcategoria);
            contenedorMenuButton.setLayoutX(100);
            contenedorMenuButton.setLayoutY(140);
            tituloEleccion.setLayoutX(100);
            tituloEleccion.setLayoutY(40);
            tituloEleccion.setFont(new Font("Serif", 15));
            tituloEleccion.setStyle("-fx-text-fill: white;");
            aceptar.setLayoutX(470);
            aceptar.setLayoutY(430);
            cancelar.setLayoutX(390);
            cancelar.setLayoutY(430);
            
            
            
            contenidoEleccion.setLayoutX(0);
            contenidoEleccion.setLayoutY(0);
            contenidoEleccion.setMinSize(550, 480);
            
            
            contenidoEleccion.getChildren().addAll(contenedorMenuButton, tituloEleccion, aceptar, cancelar);
            contenidoEleccion.setStyle("-fx-background-color: #587180");
            
            
            
            
            contenidoArticulo.getChildren().addAll(nombreColecc,fotoArticulo,btnNuevoAtributo, tfNuevoElemento,btnAceptar, btnCancelar);
            contenidoArticulo.getChildren().add(contenedorIzquierda);
            contenidoArticulo.getChildren().add(separador);
            contenidoArticulo.getChildren().add(contenedorDerecha);
            contenidoArticulo.getChildren().add(contenidoEleccion);
            
            Usuarios usuarioHelper = new Usuarios(getConnection());
                ArrayList<String> colecciones = usuarioHelper.recuperarColecciones();
                
                for(int i=0; i<=colecciones.size()-1; i++){      
                    coleccion.getItems().add(new MenuItem(colecciones.get(i)));                  
                }
                
                
                
            
            coleccion.setOnMouseClicked(evento ->{
               
            });
            
            grupo.setOnMouseClicked(evento ->{
                
            });
            categoria.setOnMouseClicked(evento ->{
                
            });
            subcategoria.setOnMouseClicked(evento ->{
                
            });
            
            btnCancelar.setOnMouseClicked(evento ->
            {
                
            }
            );
            btnAceptar.setOnMouseClicked(evento ->
                    obtenerNodoGP()
            );
            
            btnNuevoAtributo.setOnMouseClicked(evento ->
            {}
            );
            aceptar.setOnMouseClicked(evento ->
            {
                contenidoEleccion.setVisible(false);
            } 
            );
            
            cancelar.setOnMouseClicked(evento ->
            {
                
            }
            );
            
            getChildren().add(contenidoArticulo);
    }
       
   
    public void obtenerNodoGP(){
         
         //   System.out.println("el valor escrito es: "+elemento1.getText());
           /* for(Node node : contenedorDerecha.getChildren()) {
                if (GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 0) {
                    System.out.println("el nodo encontrado: "+node.getClass());
                    System.out.println("el id del nodo es: "+node);
                  
                    return node;
                }
            }*/
    
    }
    
    public void arreloElementos(){
        NuevaColeccionController coleccionActual = new NuevaColeccionController();
        String[] etiquetasColeccionCopia = coleccionActual.etiquetasColeccion;
            for(int i=0; i<=etiquetasColeccionCopia.length-1; i++){
                if(etiquetasColeccionCopia[i]!=null){
                    contenedorDerecha.add(new Label(etiquetasColeccionCopia[i]),0,i);
                    //contenedorDerecha.add(new TextField(),1,i);
                    if(i==0){
                        elemento1 = new TextField();
                        contenedorDerecha.add(elemento1,1,i);
                    }
                    if(i==1){
                        elemento2 = new TextField();
                        contenedorDerecha.add(elemento2,1,i);
                    }
                    if(i==2){
                        elemento3 = new TextField();
                        contenedorDerecha.add(elemento3,1,i);
                    }
                    if(i==3){
                        elemento4 = new TextField();
                        contenedorDerecha.add(elemento4,1,i);
                    }
                    if(i==4){
                        elemento5 = new TextField();
                        contenedorDerecha.add(elemento5,1,i);
                    }
                    if(i==5){
                        elemento6 = new TextField();
                        contenedorDerecha.add(elemento6,1,i);
                    }
                    if(i==6){
                        elemento7 = new TextField();
                        contenedorDerecha.add(elemento7,1,i);
                    }
                    if(i==7){
                        elemento8 = new TextField();
                        contenedorDerecha.add(elemento8,1,i);
                    }
                    if(i==8){
                        elemento9 = new TextField();
                        contenedorDerecha.add(elemento9,1,i);
                    }
                    if(i==9){
                        elemento10 = new TextField();
                        contenedorDerecha.add(elemento10,1,i);
                    }
                    if(i==10){
                        elemento11 = new TextField();
                        contenedorDerecha.add(elemento11,1,i);
                    }
                    
                    // elementos para los articulos
                    if(i==11){
                        elemento12 = new TextField();
                        contenedorDerecha.add(elemento12,1,i);
                    }
                    if(i==12){
                        elemento13 = new TextField();
                        contenedorDerecha.add(elemento13,1,i);
                    }
                    if(i==13){
                        elemento14 = new TextField();
                        contenedorDerecha.add(elemento14,1,i);
                    }
                    if(i==14){
                        elemento15 = new TextField();
                        contenedorDerecha.add(elemento15,1,i);
                    }
                    if(i==15){
                        elemento16 = new TextField();
                        contenedorDerecha.add(elemento16,1,i);
                    }
                    //elementos para el grupo
                    if(i==16){
                        elemento17 = new TextField();
                        contenedorDerecha.add(elemento17,1,i);
                    }
                    if(i==17){
                        elemento18 = new TextField();
                        contenedorDerecha.add(elemento18,1,i);
                    }
                    if(i==18){
                        elemento19 = new TextField();
                        contenedorDerecha.add(elemento19,1,i);
                    }
                    if(i==19){
                        elemento20 = new TextField();
                        contenedorDerecha.add(elemento20,1,i);
                    }
                    if(i==20){
                        elemento21 = new TextField();
                        contenedorDerecha.add(elemento21,1,i);
                    }
                    //elementos para categoria
                    if(i==21){
                        elemento22 = new TextField();
                        contenedorDerecha.add(elemento22,1,i);
                    }
                    if(i==22){
                        elemento23 = new TextField();
                        contenedorDerecha.add(elemento23,1,i);
                    }
                    if(i==23){
                        elemento24 = new TextField();
                        contenedorDerecha.add(elemento24,1,i);
                    }
                    if(i==24){
                        elemento25 = new TextField();
                        contenedorDerecha.add(elemento25,1,i);
                    }
                    if(i==25){
                        elemento26 = new TextField();
                        contenedorDerecha.add(elemento26,1,i);
                    }
                    //elementos para subcategoria
                    if(i==26){
                        elemento27 = new TextField();
                        contenedorDerecha.add(elemento28,1,i);
                    }
                    if(i==27){
                        elemento28 = new TextField();
                        contenedorDerecha.add(elemento28,1,i);
                    }
                    if(i==28){
                        elemento29 = new TextField();
                        contenedorDerecha.add(elemento29,1,i);
                    }
                    if(i==29){
                        elemento30 = new TextField();
                        contenedorDerecha.add(elemento30,1,i);
                    }
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
