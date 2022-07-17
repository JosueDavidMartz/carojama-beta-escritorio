
package clases;

import java.util.ArrayList;

public class Usuario {
   private int idUsuario;
   private String nombre;
   private String edad;
   private String correo;
   private String descripcion;
   private String contraseña;
  // private ArrayList[] amigos;


   public Usuario(){
       this.idUsuario = 0;
       this.nombre = "";
       this.edad = "";
       this.correo = "";
       this.descripcion = "";
       this.contraseña = "";
    //   this.amigos = null;
   }
   
   public Usuario(int idUsuario, String nombre, String edad, String correo, String descripcion, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.descripcion = descripcion;
        this.contraseña = contraseña;
       // this.amigos = amigos;
    }
   public Usuario(String nombre, String edad, String correo, String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.descripcion = descripcion;
    }

   
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
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

    /*public ArrayList[] getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList[] amigos) {
        this.amigos = amigos;
    }
   
    */
  
}
