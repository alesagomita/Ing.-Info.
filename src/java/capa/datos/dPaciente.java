/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;

import capa.entidad.ePaciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  *
 * @author CHRISTHIAN
 */
public class dPaciente {

    private Conexion miDB;

    public void of_Guardar(ePaciente xObj) {

        PreparedStatement psmt;
        ResultSet rs;
        String SQL;

        this.miDB = new Conexion();
        this.miDB.ConectaJNDI();
        SQL = "Select pa_paciente_insertar(?, ?, ?, ?, ?, ?) as id_paciente";
        try {
            psmt = this.miDB.getCn().prepareStatement(SQL);
            psmt.setString(1, xObj.getApellidos());
            psmt.setString(2, xObj.getNombres());
            psmt.setString(3, xObj.getDni());
            psmt.setString(4, xObj.getDireccion());
            psmt.setString(5, xObj.getTfijo());
            psmt.setDate(6, (Date) xObj.getFnacimiento());
            psmt.executeQuery();
            rs = psmt.getResultSet();
            while (rs.next()) {
                xObj.setId_paciente(rs.getInt("id_paciente"));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.miDB.DesconectarJNDI();
        }

    }

    public List<ePaciente> of_Listar() {

        List<ePaciente> rLista = new ArrayList<>();
        Statement smt;
        String SQL;
        ResultSet rs;
        ePaciente xObj;

        this.miDB = new Conexion();
        this.miDB.ConectaJNDI();
        SQL = "Select * from paciente";

        try {
            smt = this.miDB.getCn().createStatement();
            smt.executeQuery(SQL);
            rs = smt.getResultSet();
            while (rs.next()) {
                xObj = new ePaciente();
                xObj.setId_paciente(rs.getInt("id_paciente"));
                xObj.setApellidos(rs.getString("apellidos"));
                xObj.setNombres(rs.getString("nombres"));
                xObj.setDni(rs.getString("dni"));
                xObj.setDireccion(rs.getString("direccion"));
                xObj.setTfijo(rs.getString("tfijo"));
                xObj.setFnacimiento(rs.getDate("fnacimiento"));
                rLista.add(xObj);
            }
            rs.close();
            smt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.miDB.DesconectarJNDI();
        }
        return rLista;

    }

}
