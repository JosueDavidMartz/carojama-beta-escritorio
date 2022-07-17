/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author WIN 10
 */
public class Articulo {
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private String calidad;
    private int cantidad;
    private String condicionVenta;
    private String condicionIntercambio;
    private float precio;
    private int idColeccion;
    private int idGrupo;
    private int idCategoria;
    private int idSubcategoria;

    public Articulo(){
        this.idArticulo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.calidad = "";
        this.cantidad = 0;
        this.condicionVenta = "";
        this.condicionIntercambio = "";
        this.precio = 0;
        this.idColeccion = 0;
        this.idGrupo = 0;
        this.idCategoria = 0;
        this.idSubcategoria = 0;
    }
    
    
    public Articulo(int idArticulo, String nombre, String descripcion, String calidad, int cantidad, String condicionVenta, String condicionIntercambio, float precio, int idColeccion, int idGrupo, int idCategoria, int idSubcategoria) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calidad = calidad;
        this.cantidad = cantidad;
        this.condicionVenta = condicionVenta;
        this.condicionIntercambio = condicionIntercambio;
        this.precio = precio;
        this.idColeccion = idColeccion;
        this.idGrupo = idGrupo;
        this.idCategoria = idCategoria;
        this.idSubcategoria = idSubcategoria;
    }

    
    
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(String condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public String getCondicionIntercambio() {
        return condicionIntercambio;
    }

    public void setCondicionIntercambio(String condicionIntercambio) {
        this.condicionIntercambio = condicionIntercambio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
