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
@Named(value = "usuario")
@SessionScoped
public class Usuario implements Serializable {

    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
    }
    
}
