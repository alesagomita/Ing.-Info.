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
    public Menu() {
    }
    
}
