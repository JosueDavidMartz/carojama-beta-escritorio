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
public class Subcategoria {
    private int idSubcategoria;
    private String nombre;
    private String descripcion;
    private int idArticulo;
    private int idCategoria;
    private int idGrupo;
    private int idColeccion;

    public Subcategoria(){
        this.idSubcategoria = 0;
        this.nombre = "";
        this.descripcion = "";
        this.idArticulo = 0;
        this.idCategoria = 0;
        this.idGrupo = 0;
        this.idColeccion = 0;
    }

    public Subcategoria(int idSubcategoria, String nombre, String descripcion, int idArticulo, int idCategoria, int idGrupo, int idColeccion) {
        this.idSubcategoria = idSubcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idArticulo = idArticulo;
        this.idCategoria = idCategoria;
        this.idGrupo = idGrupo;
        this.idColeccion = idColeccion;
    }
    
    
    
    
    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }
    
    
    
    
}
