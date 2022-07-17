package carojamaproyecto;

import casos_uso.Usuarios;
import clases.Categoria;
import clases.Coleccion;
import clases.Elemento;
import clases.Grupo;
import clases.Subcategoria;
import java.awt.Choice;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBuilder;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author WIN 10
 */
public class NuevaColeccionController extends Pane{
        //elementos contenedor principal
        String[] etiquetasColeccion = new String[30];
        String[] etiquetasGrupo = new String[30];
        String[] etiquetasCategoria = new String[30];
        String[] etiquetasSubcategoria = new String[30];
        Pane contenidoPrincipal,contenidoGeneralDerecha;
        VBox contenidoEstatico, contenidoGrafico;
        GridPane contenidoCondiciones;
        TextField valorNombreColeccion; 
        Label lbTitulo, lbIntercambio, lbVenta, lbPrecio, lbTipo;
        Button addGrupo, addCategoria, addSubCategoria, guardar, cancelar, coleccionInicio;
        MenuButton mbIntercambio, mbVenta, mbTipo;
        MenuItem siInter, noInter, siVenta, noVenta, fisico, virtual;
        TextField tfVenta, tfVenta2;
        Separator separadorVert, separadorHor;
        TextArea taDescripcionColeccion;
        TextField valorAtributo;
        Button añadir, volver, aceptar;
        Label descripcionAtributo;
        TilePane elementosAñadidos;
        public static int numeroMaxEtiquetas = 1;
        Label alertaEtiquetas;
        ArrayList<Coleccion> arrayColeccion = new ArrayList();
        ArrayList<Elemento> arrayElementoColeccion= new ArrayList();
        
        //CONTENEDOR GRUPO
        Pane contenidoGrupo;
        Label lbTituloGrupo, alertaEtiquetasGrupo;
        TextField valorNombreGrupo, valorNombreElementoGrupo;
        Button añadirElementosGrupo, cancelarGrupo, aceptarGrupo;
        TilePane elementosGrupo;
        TextArea descripcionGrupo;
        public static int numeroMaxEtiquetasGrupo = 1;
        int indiceGrupo=0;
        TextField t1, t2, t3, t4, t5, t6, t7;
        int contadorGrupo = 0;
        
        ArrayList<Grupo> arrayGrupo = new ArrayList();
        ArrayList<Elemento> arrayElementoGrupo = new ArrayList();
        
        //CONTENEDOR CATEGORIA
        Pane contenidoCategoria;
        Label lbTituloCategoria, alertaEtiquetasCategoria;
        TextField valorNombreCategoria, valorNombreElementoCategoria;
        Button añadirElementosCategoria, cancelarCategoria, aceptarCategoria;
        TilePane elementosCategoria;
        TextArea descripcionCategoria;
        public static int numeroMaxEtiquetasCategoria = 1;
        int indiceCategoria = 0;
        int contadorCategoria = 0;
        ArrayList<Categoria> arrayCategoria = new ArrayList();
        ArrayList<Elemento> arrayElementoCategoria = new ArrayList();
        
        //CONTENEDOR SUBCATEGORIA
        Pane contenidoSubcategoria;
        Label lbTituloSubcategoria, alertaEtiquetasSubcategoria;
        TextField valorNombreSubcategoria, valorNombreElementoSubcategoria;
        Button añadirElementosSubcategoria, cancelarSubcategoria, aceptarSubcategoria;
        TilePane elementosSubcategoria;
        TextArea descripcionSubcategoria;
        public static int numeroMaxEtiquetasSubcategoria = 1;
        int indiceSubcategoria = 0;
        int contadorSubcategoria = 0;
        MenuButton categoriasExistentes;
        ArrayList<Subcategoria> arraySubcategoria = new ArrayList();
        ArrayList<Elemento> arrayElementoSubcategoria = new ArrayList();
        //CONTENEDOR SUBCATEGORÍA VACIO
        Pane contenidoSubcategoriaVacio;
        TextArea noHayCategoria;
        

        public NuevaColeccionController(){
            //CONTENEDORES CREADOS
            contenidoPrincipal = new Pane();  
            contenidoEstatico = new VBox(5);
            contenidoEstatico.setLayoutX(10);
            contenidoEstatico.setLayoutY(5);
            contenidoCondiciones = new GridPane();
            contenidoCondiciones.setLayoutX(10);
            contenidoCondiciones.setLayoutY(100);
            contenidoCondiciones.setHgap(10);
            contenidoCondiciones.setVgap(10);
            contenidoGrafico = new VBox();
            contenidoGrafico.setLayoutX(20);;
            contenidoGrafico.setLayoutY(250);
            separadorVert = new Separator(Orientation.VERTICAL);
            separadorVert.setLayoutX(185);
            separadorVert.setLayoutY(10);
            separadorVert.setPrefSize(5, 460);
            separadorHor = new Separator(Orientation.HORIZONTAL);
            separadorHor.setLayoutX(10);
            separadorHor.setLayoutY(240);
            separadorHor.setMinWidth(170);
       

            //CONTENIDO ESTATICO (VBox)
            addGrupo = new Button("Crear grupo");
            addCategoria = new Button("Crear categoría");
            addSubCategoria = new Button("Crear subcategoría");
            addGrupo.setTooltip(new Tooltip("Puedes agregar grupos si tu colección lo requiere,\ncada uno heredará los atributos de forma jerárquica Colección>grupo>categoría>subcategoría"));
            addCategoria.setTooltip(new Tooltip("Puedes agregar gategorías, si tu colección lo requiere,\ncada uno heredará los atributos de forma jerárquica Colección>grupo>categoría>subcategoría"));
            addSubCategoria.setTooltip(new Tooltip("Puedes agregar subcategorías, si tu colección lo requiere,\ncada uno heredará los atributos de forma jerárquica Colección>grupo>categoría>subcategoría\nPARA CREAR UNA SUBCATEGORÍA DEBE EXISTIR UNA CATEGORÍA PRIMERO"));
            
            contenidoEstatico.getChildren().addAll(addGrupo,addCategoria,addSubCategoria);
            
            //CONTENIDO CONDICIONES (GridePane)
            lbIntercambio = new Label("Intercambiable");
            lbVenta = new Label("En venta");
            lbPrecio = new Label("Precio MXN");
            mbIntercambio = new MenuButton();
            mbIntercambio.setMinSize(50, 0);
            mbVenta = new MenuButton();
            mbVenta.setMinSize(50, 0);
            siInter = new MenuItem("Si");
            noInter = new MenuItem("No");
            siVenta = new MenuItem("Si");
            noVenta = new MenuItem("No");
            tfVenta = new TextField();
            tfVenta.setMaxHeight(50);
            tfVenta.setPrefWidth(50);
            lbTipo = new Label("Tipo");
            mbTipo = new MenuButton();
            mbTipo.setMinSize(50, 0);
            fisico = new MenuItem("Físico");
            virtual = new MenuItem("Virtual");
            mbTipo.getItems().addAll(fisico,virtual);
            
      
            
            mbIntercambio.getItems().addAll(siInter, noInter);
            mbVenta.getItems().addAll(siVenta,noVenta);
            
            contenidoCondiciones.add(lbTipo, 0, 0);
            contenidoCondiciones.add(lbIntercambio, 0, 1);
            contenidoCondiciones.add(lbVenta, 0, 2);
            contenidoCondiciones.add(lbPrecio, 0, 3);
            contenidoCondiciones.add(mbTipo, 1, 0);       
            contenidoCondiciones.add(mbIntercambio, 1, 1);
            contenidoCondiciones.add(mbVenta,1,2);
            contenidoCondiciones.add(tfVenta, 1, 3);
            
           
            //CONTENIDO GRAFICO (VBox)
            
            t1 = new TextField("Colección");
            t1.setStyle("-fx-background-color: #7A8CDD;");
            t1.setAlignment(Pos.CENTER);
            t1.setEditable(false);
            t2 = new TextField("↓");
            t2.setAlignment(Pos.CENTER);
            t2.setEditable(false);
            t3 = new TextField();
            t3.setAlignment(Pos.CENTER);
            t3.setEditable(false);
            t4 = new TextField();
            t4.setAlignment(Pos.CENTER);
            t4.setEditable(false);
            t5 = new TextField();
            t5.setAlignment(Pos.CENTER);
            t5.setEditable(false);
            t6 = new TextField();
            t6.setAlignment(Pos.CENTER);
            t6.setEditable(false);
            t7 = new TextField();
            t7.setAlignment(Pos.CENTER);
            t7.setEditable(false);
            
            coleccionInicio = new Button("COLECCION");
            coleccionInicio.setLayoutX(35);
            coleccionInicio.setLayoutY(430);
            coleccionInicio.setMinSize(120, 40);
            
            
            contenidoGrafico.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7);
            
            //CONTENIDO DESCRIPTIVO PANTALLA PRINCIPAL
            contenidoGeneralDerecha = new Pane();
            contenidoGeneralDerecha.setLayoutX(190);
            contenidoGeneralDerecha.setLayoutY(0);
            contenidoGeneralDerecha.setPrefSize(360, 480);
            contenidoGeneralDerecha.setStyle("-fx-background-color: #587180");
            contenidoGeneralDerecha.setVisible(true);
            
            lbTitulo = new Label();
            lbTitulo.setText("CREANDO MI COLECCIÓN");
            lbTitulo.setLayoutX(100);
            lbTitulo.setLayoutY(10);
            valorNombreColeccion = new TextField();
            valorNombreColeccion.setLayoutX(110);
            valorNombreColeccion.setLayoutY(40);
            valorNombreColeccion.setPromptText("Nombre de tu colección...");
            taDescripcionColeccion = new TextArea();
            taDescripcionColeccion.setLayoutX(35);;
            taDescripcionColeccion.setLayoutY(80);;
            taDescripcionColeccion.setMaxSize(285, 60);
            taDescripcionColeccion.setPromptText("¿De qué es tu colección?...");
            valorAtributo = new TextField();
            valorAtributo.setPromptText("Denominación, color, etc...");
            valorAtributo.setLayoutX(112);
            valorAtributo.setLayoutY(160);
            añadir = new Button("Añadir atributo");
            añadir.setLayoutX(140);
            añadir.setLayoutY(190);
            descripcionAtributo = new Label();
            descripcionAtributo.setText("Son las caracteristicas que llevará TODA la colección\nincluyendo grupos, categorías y subcategorías\nYa existen atributos obligatorios predefinidos que se enlistan en color anaranjado");
            descripcionAtributo.setLayoutX(40);
            descripcionAtributo.setLayoutY(220);
            descripcionAtributo.setStyle("-fx-font: 10 arial;");
   
            guardar = new Button("Guardar");
            guardar.setLayoutX(270);
            guardar.setLayoutY(440);
            cancelar = new Button("Cancelar");
            cancelar.setLayoutX(190);
            cancelar.setLayoutY(440);
            
            alertaEtiquetas = new Label();
            alertaEtiquetas.setLayoutX(10);
            alertaEtiquetas.setLayoutY(440);
            
            elementosAñadidos = new TilePane(); //etiquetas
            elementosAñadidos.setHgap(10);
            elementosAñadidos.setVgap(10);
            elementosAñadidos.setPrefColumns(10);
            elementosAñadidos.setLayoutX(10);
            elementosAñadidos.setLayoutY(290);
            
            //GRUPO
            
            elementosGrupo = new TilePane(); //etiquetas
            elementosGrupo.setHgap(10);
            elementosGrupo.setVgap(10);
            elementosGrupo.setPrefColumns(10);
            elementosGrupo.setLayoutX(10);
            elementosGrupo.setLayoutY(290);
      
            contenidoGrupo = new Pane();
            contenidoGrupo.setLayoutX(190);
            contenidoGrupo.setLayoutY(0);
            contenidoGrupo.setPrefSize(360, 480);
            contenidoGrupo.setStyle("-fx-background-color: #587180");
            contenidoGrupo.setVisible(false);
            
            lbTituloGrupo = new Label("NUEVO GRUPO");
            lbTituloGrupo.setLayoutX(140);
            lbTituloGrupo.setLayoutY(10);
            valorNombreGrupo = new TextField();
            valorNombreGrupo.setLayoutX(110);
            valorNombreGrupo.setLayoutY(40);
            valorNombreGrupo.setPromptText("Nombre...");
            
            descripcionGrupo = new TextArea();
            descripcionGrupo.setPromptText("Descripción del grupo...");
            descripcionGrupo.setLayoutX(35);
            descripcionGrupo.setLayoutY(80);
            descripcionGrupo.setMaxSize(285, 60);
            
            valorNombreElementoGrupo = new TextField();
            valorNombreElementoGrupo.setLayoutX(112);
            valorNombreElementoGrupo.setLayoutY(160);
            valorNombreElementoGrupo.setPromptText("Antigüos...");
            
            añadirElementosGrupo = new Button("Añadir atributo al grupo");
            añadirElementosGrupo.setLayoutX(115);
            añadirElementosGrupo.setLayoutY(190);
            
            cancelarGrupo = new Button("Cancelar");
            cancelarGrupo.setLayoutX(190);
            cancelarGrupo.setLayoutY(440);
            
            aceptarGrupo = new Button("Aceptar");
            aceptarGrupo.setLayoutX(270);
            aceptarGrupo.setLayoutY(440);
            
            alertaEtiquetasGrupo = new Label();
            alertaEtiquetasGrupo.setLayoutX(10);
            alertaEtiquetasGrupo.setLayoutY(440);
            
            
            
            //CATEGORIA
            
            elementosCategoria = new TilePane(); //etiquetas
            elementosCategoria.setHgap(10);
            elementosCategoria.setVgap(10);
            elementosCategoria.setPrefColumns(10);
            elementosCategoria.setLayoutX(10);
            elementosCategoria.setLayoutY(290);
      
            contenidoCategoria = new Pane();
            contenidoCategoria.setLayoutX(190);
            contenidoCategoria.setLayoutY(0);
            contenidoCategoria.setPrefSize(360, 480);
            contenidoCategoria.setStyle("-fx-background-color: #587180");
            contenidoCategoria.setVisible(false);
            
            lbTituloCategoria = new Label("NUEVA CATEGORIA");
            lbTituloCategoria.setLayoutX(125);
            lbTituloCategoria.setLayoutY(10);
            valorNombreCategoria = new TextField();
            valorNombreCategoria.setLayoutX(110);
            valorNombreCategoria.setLayoutY(40);
            valorNombreCategoria.setPromptText("Nombre...");
            
            descripcionCategoria = new TextArea();
            descripcionCategoria.setPromptText("Descripción de la categoría...");
            descripcionCategoria.setLayoutX(35);
            descripcionCategoria.setLayoutY(80);
            descripcionCategoria.setMaxSize(285, 60);
            
            valorNombreElementoCategoria = new TextField();
            valorNombreElementoCategoria.setLayoutX(112);
            valorNombreElementoCategoria.setLayoutY(160);
            valorNombreElementoCategoria.setPromptText("Antigüos...");
            
            añadirElementosCategoria = new Button("Añadir atributo a la categoría");
            añadirElementosCategoria.setLayoutX(100);
            añadirElementosCategoria.setLayoutY(190);
            
            cancelarCategoria = new Button("Cancelar");
            cancelarCategoria.setLayoutX(190);
            cancelarCategoria.setLayoutY(440);
            
            aceptarCategoria = new Button("Aceptar");
            aceptarCategoria.setLayoutX(270);
            aceptarCategoria.setLayoutY(440);
            
            alertaEtiquetasCategoria = new Label();
            alertaEtiquetasCategoria.setLayoutX(10);
            alertaEtiquetasCategoria.setLayoutY(440);
            
            
            //SUBCATEGORÍA
            elementosSubcategoria = new TilePane(); //etiquetas
            elementosSubcategoria.setHgap(10);
            elementosSubcategoria.setVgap(10);
            elementosSubcategoria.setPrefColumns(10);
            elementosSubcategoria.setLayoutX(10);
            elementosSubcategoria.setLayoutY(290);
      
            contenidoSubcategoria = new Pane();
            contenidoSubcategoria.setLayoutX(190);
            contenidoSubcategoria.setLayoutY(0);
            contenidoSubcategoria.setPrefSize(360, 480);
            contenidoSubcategoria.setStyle("-fx-background-color: #587180");
            contenidoSubcategoria.setVisible(false);
            
            lbTituloSubcategoria = new Label("NUEVA SUBCATEGORIA");
            lbTituloSubcategoria.setLayoutX(120);
            lbTituloSubcategoria.setLayoutY(10);
            valorNombreSubcategoria = new TextField();
            valorNombreSubcategoria.setLayoutX(110);
            valorNombreSubcategoria.setLayoutY(40);
            valorNombreSubcategoria.setPromptText("Nombre...");
            
            descripcionSubcategoria = new TextArea();
            descripcionSubcategoria.setPromptText("Descripción de la subcategoría...");
            descripcionSubcategoria.setLayoutX(35);
            descripcionSubcategoria.setLayoutY(80);
            descripcionSubcategoria.setMaxSize(285, 60);
            
            valorNombreElementoSubcategoria = new TextField();
            valorNombreElementoSubcategoria.setLayoutX(112);
            valorNombreElementoSubcategoria.setLayoutY(160);
            valorNombreElementoSubcategoria.setPromptText("Antigüos...");
            
            añadirElementosSubcategoria = new Button("Añadir atributo a la subcategoría");
            añadirElementosSubcategoria.setLayoutX(90);
            añadirElementosSubcategoria.setLayoutY(190);
            
            categoriasExistentes = new MenuButton("Categorías..."); 
            categoriasExistentes.setTooltip(new Tooltip("Selecciona a qué categoría\nva a pertenecer tu subcategoría"));
            categoriasExistentes.setLayoutX(125);
            categoriasExistentes.setLayoutY(220);
            categoriasExistentes.setMinSize(120, 0);
            
            cancelarSubcategoria = new Button("Cancelar");
            cancelarSubcategoria.setLayoutX(190);
            cancelarSubcategoria.setLayoutY(440);
            
            aceptarSubcategoria = new Button("Aceptar");
            aceptarSubcategoria.setLayoutX(270);
            aceptarSubcategoria.setLayoutY(440);
            
            alertaEtiquetasSubcategoria = new Label();
            alertaEtiquetasSubcategoria.setLayoutX(10);
            alertaEtiquetasSubcategoria.setLayoutY(440);
            
            //SUBCATEGORÍA VACÍO
            
            contenidoSubcategoriaVacio = new Pane();
            contenidoSubcategoriaVacio.setLayoutX(190);
            contenidoSubcategoriaVacio.setLayoutY(0);
            contenidoSubcategoriaVacio.setPrefSize(360, 480);
            contenidoSubcategoriaVacio.setStyle("-fx-background-color: #587180");
            contenidoSubcategoriaVacio.setVisible(false);
            
            noHayCategoria = new TextArea();
            noHayCategoria.setText("ES NECESARIO CREAR UNA CATEGORÍA PRIMERO");
            noHayCategoria.setMaxSize(285, 40);
            noHayCategoria.setLayoutX(35);
            noHayCategoria.setLayoutY(80);
            
            tfVenta.setEditable(false);
            tfVenta.setStyle("-fx-background-color: #E0E0E0");
            
            contenidoSubcategoriaVacio.getChildren().addAll(noHayCategoria);
            
            contenidoSubcategoria.getChildren().addAll(categoriasExistentes,alertaEtiquetasSubcategoria, lbTituloSubcategoria, valorNombreSubcategoria, descripcionSubcategoria, elementosSubcategoria, valorNombreElementoSubcategoria, añadirElementosSubcategoria, cancelarSubcategoria, aceptarSubcategoria);
            
            contenidoCategoria.getChildren().addAll(alertaEtiquetasCategoria, lbTituloCategoria, valorNombreCategoria, descripcionCategoria, elementosCategoria, valorNombreElementoCategoria, añadirElementosCategoria, cancelarCategoria, aceptarCategoria);
            
            contenidoGrupo.getChildren().addAll(alertaEtiquetasGrupo, lbTituloGrupo, valorNombreGrupo, descripcionGrupo, elementosGrupo, valorNombreElementoGrupo, añadirElementosGrupo, cancelarGrupo, aceptarGrupo);
          
            contenidoGeneralDerecha.getChildren().addAll(lbTitulo,valorNombreColeccion, taDescripcionColeccion, valorAtributo,añadir, descripcionAtributo);
            contenidoGeneralDerecha.getChildren().addAll(elementosAñadidos, guardar, cancelar, alertaEtiquetas);
            
            contenidoPrincipal.getChildren().addAll(contenidoEstatico, contenidoCondiciones, contenidoGrafico, contenidoGeneralDerecha, contenidoGrupo, contenidoCategoria, contenidoSubcategoria, contenidoSubcategoriaVacio);
            contenidoPrincipal.getChildren().addAll(separadorVert, separadorHor, coleccionInicio);
                   
            
            ///////////////////////////////////////////////////////////////////////////////////////////////
            
            
            aceptarGrupo.setOnMouseClicked(evento ->
                    aceptarGrupo()
            );
            
            addGrupo.setOnMouseClicked(evento ->
                    agregarGrupo()
            );
            
            addCategoria.setOnMouseClicked(evento ->
                    agregarCategoria()
            );
            
            guardar.setOnMouseClicked(evento -> //principal
            {
                if(valorNombreColeccion.getText().isEmpty()){
                     mostrarAlertError(null, "Es necesario asignar nombre a la colección");
                }
                boolean ban = false;
                
                Usuarios usuarioHelper_ = new Usuarios(getConnection());
                ban=usuarioHelper_.buscarNombreColeccion(valorNombreColeccion.getText());
                if(ban==true){
                     mostrarAlertError(null, "Ya existe una colección con el mismo nombre");
                
                }
                else if(mbTipo.getText().isEmpty() || mbTipo.getText() == null){
                    mostrarAlertError(null, "Es necesario asignar tipo a la colección");
                }
                else if(mbIntercambio.getText().isEmpty() || mbIntercambio.getText() == null){
                    mostrarAlertError(null, "Por favor coloca si tu colección recibe oferta de intercambio");
                }
                
                else if(mbVenta.getText().isEmpty() || mbVenta.getText() == null){
                    mostrarAlertError(null, "Por favor coloca si tu colección recibe ofertas de compra");
                        
                
                }
                else if(mbVenta.getText() == "Si" && tfVenta.getText().isEmpty()){
                        mostrarAlertError(null, "Ingresa la oferta de tu colección");
                                           
                }
                
                else{
                    System.out.println("nombre de coleccion es "+valorNombreColeccion.getText());
                    //guardarColeccion();
                    
                    
                    //
                        Optional<ButtonType> action;
                        if(etiquetasColeccion[0]==null){
                            action = alertaConfirmacion("Confirmación", "La coleccion"+valorNombreColeccion.getText()+" no tiene elementos ¿Deseas guardar?");
                        }else{
                            action = alertaConfirmacion("Confirmación", "¿Guardar nueva colección "+valorNombreColeccion.getText()+"?");
                        }

                        if (action.get() == ButtonType.OK) {

                           /* Coleccion nuevaColeccion = new Coleccion();
                            nuevaColeccion.setNombre(valorNombreColeccion.getText());
                            arrayColeccion.add(nuevaColeccion);
                            */
                            for(int i=0; i<=etiquetasColeccion.length-1; i++){
                                if(etiquetasColeccion[i]!=null){
                                    Elemento nuevoElemento = new Elemento();
                                    nuevoElemento.setNombre(etiquetasColeccion[i]);
                                    arrayElementoColeccion.add(nuevoElemento);
                                }
                            }


                        for(int i=0; i<=etiquetasColeccion.length-1; i++){
                           etiquetasColeccion[i]=null;
                        }
                        numeroMaxEtiquetas = 1;
                        elementosAñadidos.getChildren().clear();
                        
                        
                        Usuarios usuarioHelper = new Usuarios(getConnection());
                        Coleccion nuevaColeccion = new Coleccion();
                        System.out.println("valor de precio "+nuevaColeccion.getPrecio());
                        nuevaColeccion.setNombre(valorNombreColeccion.getText());
                        nuevaColeccion.setTipoColeccion(mbTipo.getText());
                        nuevaColeccion.setCondicionVenta(mbVenta.getText());
                        nuevaColeccion.setCondicionInter(mbIntercambio.getText());
                        if(nuevaColeccion.getCondicionVenta()=="Si"){
                            nuevaColeccion.setPrecio( Integer.parseInt(tfVenta.getText()));
                        }
                        nuevaColeccion.setDescripcion(taDescripcionColeccion.getText());


                        boolean res=usuarioHelper.registrarColeccion(nuevaColeccion, arrayElementoColeccion, arrayGrupo, arrayElementoGrupo,arrayCategoria, arrayElementoCategoria, arraySubcategoria, arrayElementoSubcategoria);

                        if(res){
                            mostrarAlertInfo(null, "Colección creada", "Se guardó correctamente");
                            valorNombreColeccion.clear();
                            valorAtributo.clear();
                            taDescripcionColeccion.clear();  
                            mbTipo.setText(null);
                            mbVenta.setText(null);
                            tfVenta.clear();
                            mbIntercambio.setText(null);
                        }

                        } else {  

                            System.out.println("Puedes seguir agregando elementos de la coleccion...");
                        }      


                    for(int i=0; i<=arrayElementoColeccion.size()-1; i++){
                        System.out.println("elementos acumulados "+arrayElementoColeccion.get(i).getNombre());
                    }
                    //
                    
                   
                    }           
            }
            );
            
            cancelar.setOnMouseClicked(evento -> //principal
                    System.out.println("cancelar")
            );

            añadir.setOnMouseClicked(evento ->  //principal
                    btnAñadir()
            );
            añadirElementosGrupo.setOnMouseClicked(evento -> 
                    btnAñadirElementoGrupo()
            );
            coleccionInicio.setOnMouseClicked(evento ->
                inicioColeccion()
            );
            
            aceptarCategoria.setOnMouseClicked(evento ->
                aceptarCategoría()
            );
            
            añadirElementosCategoria.setOnMouseClicked(evento ->
                    btnAñadirElementoCategoria()
            );
            cancelarCategoria.setOnMouseClicked(valor ->
                    cancelarCategoria()
            );
            
            addSubCategoria.setOnMouseClicked(evento ->
                    agregarSubcategoria()
            );
           
    
            añadirElementosSubcategoria.setOnMouseClicked(evento ->
                    btnAñadirElementoSubcategoria()
            );
            
            aceptarSubcategoria.setOnMouseClicked(evento ->
                    aceptarSubcategoria()
            );
            
            siInter.setOnAction(evento ->
                    mbIntercambio.setText(siInter.getText())
            );
            
            noInter.setOnAction(evento ->
                    mbIntercambio.setText(noInter.getText())
            );
            
            siVenta.setOnAction(evento ->{
                    mbVenta.setText(siVenta.getText());
                    opcionVenta();
            });
            
            noVenta.setOnAction(evento ->{
                    mbVenta.setText(noVenta.getText());
                    opcionVenta();
            });
            fisico.setOnAction(evento ->{
                mbTipo.setText(fisico.getText());
            
            });
            virtual.setOnAction(evento ->{
                mbTipo.setText(virtual.getText());
            });
            
            cancelarGrupo.setOnAction(evento ->
                    cancelarGrupo()
            );
            //categoriasExistentes.getItems().get();
            
            /*for(int i=0; i<=arrayCategoria.size()-1; i++){
                    System.out.println(categoriasExistentes.getItems().get(i)); ************************************************************************
                }
             */
            
         
            getChildren().add(contenidoPrincipal);
        }
        
        public void opcionVenta(){
            if(mbVenta.getText()=="No"){
                tfVenta.setEditable(false);
                tfVenta.setStyle("-fx-background-color: #E0E0E0");
            }else{
                tfVenta.setEditable(true);
                tfVenta.setStyle(null);
            }
        }
        
        public void indiceParaGrupo(){ //PARA SABER DESDE DONDE ME QUEDE EN EL ARREGLO DEL GRUPO LA ULTIMA VEZ
            for(int i=0; i<=etiquetasGrupo.length-1; i++){
                if(etiquetasGrupo[i]==null){
                    indiceGrupo=i;
                    break;
                }
            }
            numeroMaxEtiquetas = indiceGrupo+1;
             System.out.println("indice: "+indiceGrupo);
           
        }
        
        public void btnVolverGrupo(){   //PARA CANCELAR ETIQUETAS DEL GRUPO
           
            contenidoGeneralDerecha.setVisible(true);
            contenidoGrupo.setVisible(false);
            System.out.println("indice: "+indiceGrupo);
            
            for(int i=indiceGrupo; i<=etiquetasGrupo.length-1; i++){
                etiquetasGrupo[i]=null;
            }
            
            for(int i=0; i<=etiquetasGrupo.length-1; i++){
                System.out.println("valor boton volver: "+etiquetasGrupo[i]);
                
            }
            System.out.println("________________________________");
            
        }
        
        public void btnAñadir(){ //el de coleccion
            if(numeroMaxEtiquetas>10){
                  alertaEtiquetas.setText("El número máximo de elementos es 10");
                  alertaEtiquetas.setStyle("-fx-text-fill: red;");
            }else{
                if(valorAtributo.getText().isEmpty()){
                    alertaEtiquetas.setText("Crea un elemento para añadir");
                }else{
                    //boolean bandera = false;
                    for(int i=0; i<=etiquetasColeccion.length-1; i++){ //NO ENTRA A ESTA CONDICION **********************************
                        if(etiquetasColeccion[i]==valorAtributo.getText()){
                            alertaEtiquetas.setText("Ya existe un elemento con el mismo nombre");
                            
                            return;
                        }
                    }
                   // bandera = true;
                    if(alertaEtiquetas.getText()!="Ya existe un elemento con el mismo nombre"){
                        for(int i=0; i<=etiquetasColeccion.length-1; i++){
                            if(etiquetasColeccion[i]==null){
                                elementosAñadidos.getChildren().add(new Button(valorAtributo.getText()));  //COLOCAR EVENTO PARA ELIMINAR EL BOTON (ETIQUETA) ****
                                //etiquetas[numeroMaxEtiquetas-1]=valorAtributo.getText();
                                etiquetasColeccion[numeroMaxEtiquetas-1]=valorAtributo.getText();
                                valorAtributo.setText("");
                                alertaEtiquetas.setText("");
                                numeroMaxEtiquetas++;
                                break;
                            }
                        }
                    }   
                }
            } 
            for(int i=0; i<=etiquetasColeccion.length-1; i++){
                System.out.println("valo de etiqueta: "+etiquetasColeccion[i]);
                
            }
            System.out.println("________________________________");
        }   

        public void btnAñadirElementoGrupo(){ 
            if(numeroMaxEtiquetasGrupo>10){
                  alertaEtiquetasGrupo.setText("El número máximo de elementos es 10");
                  alertaEtiquetasGrupo.setStyle("-fx-text-fill: red;");
            }else{
                if(valorNombreElementoGrupo.getText().isEmpty()){
                    alertaEtiquetasGrupo.setText("Crea un elemento para añadir");
                }else{
                    //boolean bandera = false;
                    for(int i=0; i<=etiquetasGrupo.length-1; i++){ //NO ENTRA A ESTA CONDICION **********************************
                        if(etiquetasGrupo[i]==valorNombreElementoGrupo.getText()){
                            alertaEtiquetasGrupo.setText("Ya existe un elemento con el mismo nombre");
                            
                            return;
                        }
                    }
                   // bandera = true;
                   System.out.println("entrando...");
                    if(alertaEtiquetasGrupo.getText()!="Ya existe un elemento con el mismo nombre"){
                        System.out.println("entrando2...");
                        for(int i=0; i<=etiquetasGrupo.length-1; i++){
                            System.out.println("entrando2...");
                            if(etiquetasGrupo[i]==null){
                                elementosGrupo.getChildren().add(new Button(valorNombreElementoGrupo.getText()));  //COLOCAR EVENTO PARA ELIMINAR EL BOTON (ETIQUETA) ****
                                //etiquetas[numeroMaxEtiquetas-1]=valorAtributo.getText();
                                etiquetasGrupo[numeroMaxEtiquetasGrupo-1]=valorNombreElementoGrupo.getText();
                                valorNombreElementoGrupo.setText("");
                                alertaEtiquetasGrupo.setText("");
                                numeroMaxEtiquetasGrupo++;
                                break;
                            }
                           
                        }
                    }    
                }
                
            } 
            for(int i=0; i<=etiquetasGrupo.length-1; i++){
                System.out.println("valo de etiqueta: "+etiquetasGrupo[i]);
                
            }
            System.out.println("*********************************************");
        }  
        
        public void btnAñadirElementoCategoria(){ 
            if(numeroMaxEtiquetasCategoria>10){
                  alertaEtiquetasCategoria.setText("El número máximo de elementos es 10");
                  alertaEtiquetasCategoria.setStyle("-fx-text-fill: red;");
            }else{
                if(valorNombreElementoCategoria.getText().isEmpty()){
                    alertaEtiquetasCategoria.setText("Crea un elemento para añadir");
                }else{
                    //boolean bandera = false;
                    for(int i=0; i<=etiquetasCategoria.length-1; i++){ //NO ENTRA A ESTA CONDICION **********************************
                        if(etiquetasCategoria[i]==valorNombreElementoCategoria.getText()){
                            alertaEtiquetasCategoria.setText("Ya existe un elemento con el mismo nombre");
                            
                            return;
                        }
                    }
                   // bandera = true;
             
                    if(alertaEtiquetasCategoria.getText()!="Ya existe un elemento con el mismo nombre"){
                       
                        for(int i=0; i<=etiquetasCategoria.length-1; i++){
                            
                            if(etiquetasCategoria[i]==null){
                                elementosCategoria.getChildren().add(new Button(valorNombreElementoCategoria.getText()));  //COLOCAR EVENTO PARA ELIMINAR EL BOTON (ETIQUETA) ****
                                //etiquetas[numeroMaxEtiquetas-1]=valorAtributo.getText();
                                etiquetasCategoria[numeroMaxEtiquetasCategoria-1]=valorNombreElementoCategoria.getText();
                                valorNombreElementoCategoria.setText("");
                                alertaEtiquetasCategoria.setText("");
                                numeroMaxEtiquetasCategoria++;
                                break;
                            }
                           
                        }
                    }    
                }
                
            } 
            for(int i=0; i<=etiquetasCategoria.length-1; i++){
                System.out.println("valo de etiqueta categoria: "+etiquetasCategoria[i]);
                
            }
            System.out.println("////////////////////////////////////////////");
        }  
        
        
        public void btnAñadirElementoSubcategoria(){ 
            if(numeroMaxEtiquetasSubcategoria>10){
                  alertaEtiquetasSubcategoria.setText("El número máximo de elementos es 10");
                  alertaEtiquetasSubcategoria.setStyle("-fx-text-fill: red;");
            }else{
                if(valorNombreElementoSubcategoria.getText().isEmpty()){
                    alertaEtiquetasSubcategoria.setText("Crea un elemento para añadir");
                }else{
                    //boolean bandera = false;
                    for(int i=0; i<=etiquetasSubcategoria.length-1; i++){ //NO ENTRA A ESTA CONDICION **********************************
                        if(etiquetasSubcategoria[i]==valorNombreElementoSubcategoria.getText()){
                            alertaEtiquetasSubcategoria.setText("Ya existe un elemento con el mismo nombre");
                            
                            return;
                        }
                    }
                   // bandera = true;
             
                    if(alertaEtiquetasSubcategoria.getText()!="Ya existe un elemento con el mismo nombre"){
                       
                        for(int i=0; i<=etiquetasSubcategoria.length-1; i++){
                            
                            if(etiquetasSubcategoria[i]==null){
                                elementosSubcategoria.getChildren().add(new Button(valorNombreElementoSubcategoria.getText()));  //COLOCAR EVENTO PARA ELIMINAR EL BOTON (ETIQUETA) ****
                                //etiquetas[numeroMaxEtiquetas-1]=valorAtributo.getText();
                                etiquetasSubcategoria[numeroMaxEtiquetasSubcategoria-1]=valorNombreElementoSubcategoria.getText();
                                valorNombreElementoSubcategoria.setText("");
                                alertaEtiquetasSubcategoria.setText("");
                                numeroMaxEtiquetasSubcategoria++;
                                break;
                            }
                           
                        }
                    }    
                }
                
            } 
            for(int i=0; i<=etiquetasSubcategoria.length-1; i++){
                System.out.println("valo de etiqueta subcategoria: "+etiquetasSubcategoria[i]);
                
            }
            System.out.println("////////////////////////////////////////////");
        }  
        
        public void actualizarEtiquetas(){
            //recorrer el arreglo cuando se elimine una etiqueta ********************************************************
            String[] aux = new String[etiquetasColeccion.length];
            for(int i=0; i<=etiquetasColeccion.length-1; i++){
                if(etiquetasColeccion[i]!=""){
                    for(int j=0; j<=aux.length-1; j++){
                        if(aux[j].isEmpty()){
                            aux[j]=etiquetasColeccion[i];
                            etiquetasColeccion[i]="";
                            break;
                        }
                    }
                }
            }
            
            for(int i=0; i<=aux.length-1; i++){
                if(aux[i].isEmpty()){
                    return;
                }else{
                    etiquetasColeccion[i]=aux[i];
                }
            }   
        }
        
        public void eliminarEtiqueta(){
            
        }
   
        public void aceptarGrupo(){
           
            if(valorNombreGrupo.getText().isEmpty()){
                alertaConfirmacion("Faltan datos", "Agrega un nombre al grupo");
            }else{
                boolean ban=false;
                for(int i=0; i<=arrayGrupo.size()-1;i++){
                    if(arrayGrupo.get(i).getNombre().equals(valorNombreGrupo.getText())){
                        alertaEtiquetasGrupo.setText("Ya existe un grupo con el mismo nombre");
                        System.out.println("entrando al for "+arrayGrupo.get(i).getNombre());
                        ban=true;
                    }
                }
                if(ban==false){
                    Optional<ButtonType> action;
                    if(etiquetasGrupo[0]==null){
                        action = alertaConfirmacion("Confirmación", "El grupo "+valorNombreGrupo.getText()+" no tiene elementos ¿Deseas guardar?");
                    }else{
                        action = alertaConfirmacion("Confirmación", "¿Guardar nuevo grupo "+valorNombreGrupo.getText()+"?");
                    }

                    if (action.get() == ButtonType.OK) {
                        contadorGrupo++;

                        t3.setText("Grupo" +" x"+contadorGrupo);
                        t3.setStyle("-fx-background-color: #96A2DC;");
                        Grupo nuevoGrupo = new Grupo();
                        nuevoGrupo.setNombre(valorNombreGrupo.getText());
                        nuevoGrupo.setDescripcion(descripcionGrupo.getText());
                        arrayGrupo.add(nuevoGrupo);
                        for(int i=0; i<=etiquetasGrupo.length-1; i++){
                            if(etiquetasGrupo[i]!=null){
                                Elemento nuevoElemento = new Elemento();
                                nuevoElemento.setNombre(etiquetasGrupo[i]);
                                nuevoElemento.setPerteneceA(valorNombreGrupo.getText());
                                arrayElementoGrupo.add(nuevoElemento);
                            }
                        }
                        //guardar en arrayListGrupo los elementos del tilePane


                    for(int i=0; i<=etiquetasGrupo.length-1; i++){
                       etiquetasGrupo[i]=null;
                    }
                    numeroMaxEtiquetasGrupo = 1;
                    elementosGrupo.getChildren().clear();
                    t4.setText("↓");
                    valorNombreGrupo.setText("");
                    valorNombreElementoGrupo.setText("");
                    } else {      
                        System.out.println("Puedes seguir agregando elementos del grupo...");
                    }   
                }
            }
            
            for(int i=0; i<=arrayElementoGrupo.size()-1; i++){
                System.out.println("elementos acumulados "+arrayElementoGrupo.get(i).getNombre());
            }
        }
        
        public void agregarGrupo(){
            contenidoCondiciones.setVisible(false);
            
            
            contenidoGrupo.setVisible(true);
            contenidoGeneralDerecha.setVisible(false);
            contenidoCategoria.setVisible(false);
            contenidoSubcategoria.setVisible(false);
            contenidoSubcategoriaVacio.setVisible(false);
        }
        
        public Optional alertaConfirmacion(String titulo, String mensaje){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle(titulo);
            alert.setContentText(mensaje);
            Optional<ButtonType> action = alert.showAndWait();
            return action;
        }
        
        public void inicioColeccion(){
            contenidoCondiciones.setVisible(true);
            contenidoGeneralDerecha.setVisible(true);
            contenidoGrupo.setVisible(false);
            contenidoCategoria.setVisible(false);
            contenidoSubcategoria.setVisible(false);
            contenidoSubcategoriaVacio.setVisible(false);
        }
        
        public void agregarCategoria(){
            contenidoCondiciones.setVisible(false);
            
            contenidoSubcategoriaVacio.setVisible(false);
            contenidoGeneralDerecha.setVisible(false);
            contenidoSubcategoria.setVisible(false);
            contenidoGrupo.setVisible(false);
            contenidoCategoria.setVisible(true);
        }
        
        public void aceptarCategoría(){ //COMPLETA
           
            if(valorNombreCategoria.getText().isEmpty()){
                alertaConfirmacion("Faltan datos", "Agrega un nombre al grupo");
            }else{
                Optional<ButtonType> action;
                if(etiquetasCategoria[0]==null){
                    action = alertaConfirmacion("Confirmación", "La categoria "+valorNombreCategoria.getText()+" no tiene elementos ¿Deseas guardar?");
                }else{
                    action = alertaConfirmacion("Confirmación", "¿Guardar nueva categoría "+valorNombreCategoria.getText()+"?");
                }
              
                if (action.get() == ButtonType.OK) {
                    contadorCategoria++;
                    
                    t5.setText("Categoría" +" x"+contadorCategoria);
                    t5.setStyle("-fx-background-color: #BFC4DB;");
                    Categoria nuevaCategoria = new Categoria();
                    nuevaCategoria.setNombre(valorNombreCategoria.getText());
                    nuevaCategoria.setDescripcion(descripcionCategoria.getText());
                    arrayCategoria.add(nuevaCategoria);
                    for(int i=0; i<=etiquetasCategoria.length-1; i++){
                        if(etiquetasCategoria[i]!=null){
                            
                            Elemento nuevoElemento = new Elemento();
                            nuevoElemento.setNombre(etiquetasCategoria[i]);
                            arrayElementoCategoria.add(nuevoElemento);
                        }
                    }
                    //guardar en arrayListGrupo los elementos del tilePane
                    
                
                    for(int i=0; i<=etiquetasCategoria.length-1; i++){
                    etiquetasCategoria[i]=null;
                    }
                    numeroMaxEtiquetasCategoria = 1;
                    elementosCategoria.getChildren().clear();
                    valorNombreCategoria.setText("");
                    valorNombreElementoCategoria.setText("");

                    for(int i=0; i<=arrayCategoria.size()-1;i++){
                        System.out.println("blablam "+arrayCategoria.get(i).getNombre());
                    }

                    } else{
                        System.out.println("puedes continuar agregando elementos de categoria...");
                    }  
                }
                for(int i=0; i<=arrayElementoCategoria.size()-1; i++){ //SOLO PARA SABER COMO SE VAN GUARDANDO, SE BORRA ESTAS DOS LINEAS
                    System.out.println("elementos acumulados "+arrayElementoCategoria.get(i).getNombre());
            }
        }
        
        
        public void cancelarCategoria(){
            
        }
        
        public void cancelarGrupo(){
            
            Optional<ButtonType> action = alertaConfirmacion("Cancelar grupo", "¿Deseas cancelar la creación del grupo?");
            if (action.get() == ButtonType.OK) {
                for(int i=0; i<=etiquetasGrupo.length-1; i++){
                    etiquetasGrupo[i]=null;
                }
                valorNombreGrupo.setText("");
                valorNombreElementoGrupo.setText("");
            }

        }
        
        public void agregarSubcategoria(){
            contenidoCondiciones.setVisible(false);
            
            
            if(arrayCategoria.isEmpty()){
                contenidoSubcategoriaVacio.setVisible(true);
                contenidoGeneralDerecha.setVisible(false);
                contenidoSubcategoria.setVisible(false);
                contenidoCategoria.setVisible(false);
                contenidoGrupo.setVisible(false);
            }else{
                categoriasExistentes.getItems().clear();
                for(int i=0; i<=arrayCategoria.size()-1; i++){                                     
                    categoriasExistentes.getItems().add(new MenuItem(arrayCategoria.get(i).getNombre()));
                    
                }
                    
                contenidoSubcategoriaVacio.setVisible(false);
                contenidoGeneralDerecha.setVisible(false);
                contenidoSubcategoria.setVisible(true);
                contenidoCategoria.setVisible(false);
                contenidoGrupo.setVisible(false);
            }
        }
        
        public void aceptarSubcategoria(){
          if(valorNombreSubcategoria.getText().isEmpty()){
                alertaConfirmacion("Faltan datos", "Agrega un nombre a la subcategoría");
            }else{
                Optional<ButtonType> action;
                if(etiquetasSubcategoria[0]==null){
                    action = alertaConfirmacion("Confirmación", "La subcategoria "+valorNombreSubcategoria.getText()+" no tiene elementos ¿Deseas guardar?");
                }else{
                    action = alertaConfirmacion("Confirmación", "¿Guardar nueva subcategoría "+valorNombreSubcategoria.getText()+"?");
                }
              
                if (action.get() == ButtonType.OK) {
                    contadorSubcategoria++;
                    
                    t7.setText("Subcategoría" +" x"+contadorSubcategoria);
                    t7.setStyle("-fx-background-color: #DADADE;");
                    Subcategoria nuevaSubcategoria = new Subcategoria();
                    nuevaSubcategoria.setNombre(valorNombreSubcategoria.getText());
                    nuevaSubcategoria.setDescripcion(descripcionSubcategoria.getText());
                    arraySubcategoria.add(nuevaSubcategoria);
                    for(int i=0; i<=etiquetasSubcategoria.length-1; i++){
                        if(etiquetasSubcategoria[i]!=null){
                            
                            Elemento nuevoElemento = new Elemento();
                            nuevoElemento.setNombre(etiquetasSubcategoria[i]);
                            arrayElementoSubcategoria.add(nuevoElemento);
                        }
                    }
                    //guardar en arrayListGrupo los elementos del tilePane
                    
                
                for(int i=0; i<=etiquetasSubcategoria.length-1; i++){
                etiquetasSubcategoria[i]=null;
                }
                numeroMaxEtiquetasSubcategoria = 1;
                elementosSubcategoria.getChildren().clear();
                
                valorNombreSubcategoria.setText("");
                valorNombreElementoSubcategoria.setText("");
                
                } else{
                    System.out.println("puedes continuar agregando elementos de Subcategoria...");
                }  
            }
            for(int i=0; i<=arrayElementoSubcategoria.size()-1; i++){ //SOLO PARA SABER COMO SE VAN GUARDANDO, SE BORRA ESTAS DOS LINEAS
                System.out.println("elementos acumulados "+arrayElementoSubcategoria.get(i).getNombre());
            }    
        }
        
        public void guardarColeccion(){
           
                Optional<ButtonType> action;
                if(etiquetasColeccion[0]==null){
                    action = alertaConfirmacion("Confirmación", "La coleccion"+valorNombreColeccion.getText()+" no tiene elementos ¿Deseas guardar?");
                }else{
                    action = alertaConfirmacion("Confirmación", "¿Guardar nueva colección "+valorNombreColeccion.getText()+"?");
                }

                if (action.get() == ButtonType.OK) {
     
                   /* Coleccion nuevaColeccion = new Coleccion();
                    nuevaColeccion.setNombre(valorNombreColeccion.getText());
                    arrayColeccion.add(nuevaColeccion);
                    */
                    for(int i=0; i<=etiquetasColeccion.length-1; i++){
                        if(etiquetasColeccion[i]!=null){
                            Elemento nuevoElemento = new Elemento();
                            nuevoElemento.setNombre(etiquetasColeccion[i]);
                            arrayElementoColeccion.add(nuevoElemento);
                        }
                    }
                                       
                    
                for(int i=0; i<=etiquetasColeccion.length-1; i++){
                   etiquetasColeccion[i]=null;
                }
                numeroMaxEtiquetas = 1;
                elementosAñadidos.getChildren().clear();
                
                } else {      
                    System.out.println("Puedes seguir agregando elementos de la coleccion...");
                }      
            
            
            for(int i=0; i<=arrayElementoColeccion.size()-1; i++){
                System.out.println("elementos acumulados "+arrayElementoColeccion.get(i).getNombre());
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
         
        
    private void mostrarAlertError(ActionEvent event, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private void mostrarAlertInfo(ActionEvent event,String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
        
}
