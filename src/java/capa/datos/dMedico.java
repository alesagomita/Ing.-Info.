/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;

import capa.entidad.eMedico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHRISTHIAN
 */
public class dMedico {

    private Conexion miDB;

    public void of_Guardar(eMedico xObj) {

        PreparedStatement psmt;
        ResultSet rs;
        String SQL = "Select pa_medico_insertar(?, ?, ?, ?) as id_medico";

        this.miDB = new Conexion();
        this.miDB.ConectaJNDI();

        try {
            psmt = this.miDB.getCn().prepareStatement(SQL);
            psmt.setString(1, xObj.getApellidos());
            psmt.setString(2, xObj.getNombres());
            psmt.setString(3, xObj.getDni());
            psmt.setString(4, xObj.getEmail());
            psmt.executeQuery();

            rs = psmt.getResultSet();
            while (rs.next()) {
                xObj.setId_medico(rs.getInt("id_medico"));
            }
            rs.close();
            psmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dMedico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.miDB.DesconectarJNDI();
        }

    }

    public List<eMedico> of_Listar() {
        List<eMedico> rLista = new ArrayList<>();
        Statement smt;
        String SQL = "select * from medico";
        ResultSet rs;
        eMedico xObj;

        this.miDB = new Conexion();
        this.miDB.ConectaJNDI();

        try {
            smt = this.miDB.getCn().createStatement();
            smt.executeQuery(SQL);
            rs = smt.getResultSet();
            while (rs.next()) {
                xObj = new eMedico();
                xObj.setId_medico(rs.getInt("id_medico"));
                xObj.setApellidos(rs.getString("apellidos"));
                xObj.setNombres(rs.getString("nombres"));
                xObj.setDni(rs.getString("dni"));
                xObj.setEmail(rs.getString("email"));
                rLista.add(xObj);
            }
            rs.close();
            smt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dMedico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.miDB.DesconectarJNDI();
        }

        return rLista;
    }

}
