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
    
    private String User;
    private String Pass;
    
    public String getUser(){
       return User;
    }
    public void setUser(String User){
        this.User = User;
    }
    public String getPass(){
        return Pass;
    }
    public void setPass(String Pass){
        this.Pass = Pass;
    }
    public Usuario() {
       this.User = "";
        this.Pass = "";
    }
    public Object ValidarAcceso(){
        if (this.User.equals("admin")) {
            return "acceder";
            
        }else{
            this.setUser("");
            this.setPass("");
            return "";
        }
    }
    
}
