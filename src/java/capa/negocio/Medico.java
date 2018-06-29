/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

import capa.datos.dMedico;
import capa.entidad.eMedico;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
@Named(value = "medico")
@SessionScoped
public class Medico implements Serializable {

    private eMedico Entidad = new eMedico();
    private dMedico Dato = new dMedico();
    private List<eMedico> listadoMedicos;
    
    public Medico(){
        
    }

    public eMedico getEntidad() {
        return Entidad;
    }

    public void setEntidad(eMedico Entidad) {
        this.Entidad = Entidad;
    }

    public dMedico getDato() {
        return Dato;
    }

    public void setDato(dMedico Dato) {
        this.Dato = Dato;
    }

    public List<eMedico> getListadoMedicos() {
        return listadoMedicos;
    }

    public void setListadoMedicos(List<eMedico> listadoMedicos) {
        this.listadoMedicos = listadoMedicos;
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
    
    public void of_ListarMedicos(){
        this.listadoMedicos = this.Dato.of_Listar();
    }

}
