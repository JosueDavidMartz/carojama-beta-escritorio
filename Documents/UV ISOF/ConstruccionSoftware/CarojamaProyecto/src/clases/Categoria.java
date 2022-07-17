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
public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int idArticulo;
    private int idGrupo;
    private int idColeccion;

    public Categoria(){
        this.idCategoria = 0;
        this.nombre = "";
        this.descripcion = "";
        this.idArticulo = 0;
        this.idGrupo = 0;
        this.idColeccion = 0;
    }
    
    
    public Categoria(int idCategoria, String nombre, String descripcion, int idArticulo, int idGrupo, int idColeccion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idArticulo = idArticulo;
        this.idGrupo = idGrupo;
        this.idColeccion = idColeccion;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
