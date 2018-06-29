/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author root
 */
@Named(value = "cita")
@SessionScoped
public class Cita implements Serializable {

    private Medico medico;
    private Paciente paciente;
    private Date fecha_cita;
    private Time hora_cita;

    public Cita(Medico medico, Paciente paciente, Date fecha_cita, Time hora_cita) {
        this.medico = medico;
        this.paciente = paciente;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Time getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(Time hora_cita) {
        this.hora_cita = hora_cita;
    }
            
    
    
}
