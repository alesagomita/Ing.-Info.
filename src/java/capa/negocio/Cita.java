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
@Named(value = "cita")
@SessionScoped
public class Cita implements Serializable {

    /**
     * Creates a new instance of Cita
     */
    public Cita() {
    }
    
}
