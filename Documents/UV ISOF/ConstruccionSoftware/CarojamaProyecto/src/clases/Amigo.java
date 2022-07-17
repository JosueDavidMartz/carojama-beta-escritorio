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
public class Amigo {
    private int idAmigo;
    private String nombre;
    private int edad;
    private String correo;
    private String descripcion;
    private String contraseña;
    private int idUsuario;
    
    public Amigo(){
        this.idAmigo = 0;
        this.nombre="";
        this.edad = 0;
        this.correo = "";
        this.descripcion = "";
        this.contraseña = "";
        this.idUsuario = 0;
    }

    public Amigo(int idAmigo, String nombre, int edad, String correo, String descripcion, String contraseña, int idUsuario) {
        this.idAmigo = idAmigo;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.descripcion = descripcion;
        this.contraseña = contraseña;
        this.idUsuario = idUsuario;
    }
    
    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
