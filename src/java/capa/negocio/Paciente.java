/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

import capa.datos.dPaciente;
import capa.entidad.ePaciente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
@Named(value = "paciente")
@SessionScoped
public class Paciente implements Serializable {

    private ePaciente Entidad = new ePaciente();
    private dPaciente Dato = new dPaciente();
    private List<ePaciente> listadoPacientes;
    
    public Paciente(){
        
    }

    public ePaciente getEntidad() {
        return Entidad;
    }

    public void setEntidad(ePaciente Entidad) {
        this.Entidad = Entidad;
    }

    public dPaciente getDato() {
        return Dato;
    }

    public void setDato(dPaciente Dato) {
        this.Dato = Dato;
    }

    public List<ePaciente> getListadoPacientes() {
        return listadoPacientes;
    }

    public void setListadoPacientes(List<ePaciente> listadoPacientes) {
        this.listadoPacientes = listadoPacientes;
    }
    
    public void of_Guardar(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            this.Dato.of_Guardar(Entidad);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    Entidad.getApellidos(), "Guardado Correctamente"));
        } catch (SQLException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    Entidad.getApellidos(), e.getMessage()));
            e.printStackTrace();
        }
    }
    
    public void of_ListarPacientes(){
        this.listadoPacientes = this.Dato.of_Listar();
    }
    
    
    
}
