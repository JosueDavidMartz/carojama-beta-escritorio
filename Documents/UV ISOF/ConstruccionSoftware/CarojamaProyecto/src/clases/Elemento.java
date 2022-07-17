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
public class Elemento {
    private int idElemento;
    private String nombre;
    private String PerteneceA;
    private int idColeccion;
    private int idArticulo;
    private int idGrupo;
    private int idCategoria;
    private int idSubcategoria;
    
    public Elemento(){
        this.idElemento = 0;
        this.nombre = "";
        this.PerteneceA = "";
        this.idColeccion = 0;
        this.idArticulo = 0;
        this.idGrupo = 0;
        this.idCategoria = 0;
        this.idSubcategoria = 0;
    }
    
    public Elemento(int idElemento, String nombre, String perteneceA, int idColeccion, int idArticulo, int idGrupo, int idCategoria, int idSubcategoria) {
        this.idElemento = idElemento;
        this.nombre = nombre;
        this.PerteneceA = perteneceA;
        this.idColeccion = idColeccion;
        this.idArticulo = idArticulo;
        this.idGrupo = idGrupo;
        this.idCategoria = idCategoria;
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
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

    public String getPerteneceA() {
        return PerteneceA;
    }

    public void setPerteneceA(String PerteneceA) {
        this.PerteneceA = PerteneceA;
    }
    
    
    
}
