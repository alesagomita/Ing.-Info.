/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author root
 */
@Named(value = "menu")
@SessionScoped
public class Menu implements Serializable {

    /**
     * Creates a new instance of Menu
     */
    private String Contenido;
    
    public String getContenido(){
        return Contenido;
    }
    public void setContenido(String Contenido){
        this.Contenido = Contenido;
    }
    public Menu() {
        Contenido = "bienvenido.xhtml";
    }
    public void registrar_medico(){
        this.setContenido("registrar_medico.xhtml");
    }
    public void registrar_paciente(){
        this.setContenido("registrar_paciente.xhtml");
    }
    public void registrar_cita(){
        this.setContenido("registrar_cita.xhtml");
    }
    public Object salir(){
        return "salir";
    }
    
}
