/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import javafx.scene.image.ImageView;

/**
 *
 * @author WIN 10
 */
public class FotoUsuario {
    private int idFotoUsuario;
    private byte[] fotoPerfil;
    private int idUsuario;

    public FotoUsuario(){
        this.idFotoUsuario = 0;
        this.fotoPerfil = null;
        this.idUsuario = 0;
    }
    
    public FotoUsuario(int idFotoUsuario, byte[] fotoPerfil, int idUsuario) {
        this.idFotoUsuario = idFotoUsuario;
        this.fotoPerfil = fotoPerfil;
        this.idUsuario = idUsuario;
    }

    public int getIdFotoUsuario() {
        return idFotoUsuario;
    }

    public void setIdFotoUsuario(int idFotoUsuario) {
        this.idFotoUsuario = idFotoUsuario;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
