/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.entidad;

import java.util.Date;

/**
 *
 * @author CHRISTHIAN
 */
public class eCita {
    
    private Integer id_paciente;
    private Integer id_medico;
    private Date fechacita;
    private Date horacita;

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
    }

    public Date getHoracita() {
        return horacita;
    }

    public void setHoracita(Date horacita) {
        this.horacita = horacita;
    }
    
    
    
}
