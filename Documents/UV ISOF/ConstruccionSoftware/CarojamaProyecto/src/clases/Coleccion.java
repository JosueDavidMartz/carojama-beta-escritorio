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
public class Coleccion {
    private int idColeccion;
    private String nombre;
    private String descripcion;
    private String tipoColeccion;
    private String condicionVenta;
    private String condicionInter;
    private int precio;

    public Coleccion(){
        this.idColeccion = 0;
        this.nombre ="";
        this.descripcion = "";
        this.tipoColeccion = "";
        this.condicionVenta = "";
        this.condicionInter = "";
        this.precio = 0;
    }
    
    public Coleccion(int idColeccion, String nombre, String descripcion, String tipoColeccion, String condicionVenta, String condicionInter, int precio) {
        this.idColeccion = idColeccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoColeccion = tipoColeccion;
        this.condicionVenta = condicionVenta;
        this.condicionInter = condicionInter;
        this.precio = precio = 0;
    }

    
    
    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoColeccion() {
        return tipoColeccion;
    }

    public void setTipoColeccion(String tipoColeccion) {
        this.tipoColeccion = tipoColeccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(String condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public String getCondicionInter() {
        return condicionInter;
    }

    public void setCondicionInter(String condicionInter) {
        this.condicionInter = condicionInter;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
