/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author root
 */
@Named(value = "paciente")
@SessionScoped
public class Paciente implements Serializable {

    
    private String apellidos;
    private String nombres;
    private String direccion;
    private String dni;
    private String telf_fijo;
    private Date fecha_nac;
    
    public Paciente(String apellidos, String nombres, String direccion, String dni, String telf_fijo, Date fecha_nac) {
        
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.dni = dni;
        this.telf_fijo = telf_fijo;
        this.fecha_nac = fecha_nac;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelf_fijo() {
        return telf_fijo;
    }

    public void setTelf_fijo(String telf_fijo) {
        this.telf_fijo = telf_fijo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    
    
}
