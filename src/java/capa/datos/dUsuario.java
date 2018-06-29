/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;
import capa.entidad.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author root
 */
public class dUsuario {
    private Conexion miBD;
    public dUsuario(){
        
    }
    public eUsuario of_BuscarUsuario(eUsuario sUsuario){
        PreparedStatement pst;
        ResultSet rs;
        eUsuario rUsuario = new eUsuario();
        this.miBD =new Conexion();
        this.miBD.ConectaJNDI();
        try{
            pst= this.miBD.getCn().prepareCall("select * from pa_lusuario(?)");
            pst.setString(1,sUsuario.getUsuario());
            pst.executeQuery();
            rs = pst.getResultSet();
            while(rs.next()){
                rUsuario.setId_usuario(rs.getInt("id_usuario"));
                rUsuario.setUsuario(rs.getString("usuario"));
                rUsuario.setPassword(rs.getString("password"));
            }
        }catch(SQLException ex){
           Logger.getLogger(dUsuario.class.getName()).log(Level.SEVERE,null,ex);
       }
        this.miBD.DesconectarJNDI();
        return rUsuario;
    }
    public List<eUsuario> of_ListarUsuario(){
        List<eUsuario> rListado = new ArrayList<>();
        eUsuario miUsuario;
        Statement st;
        ResultSet rs;
        
        this.miBD = new Conexion();
        this.miBD.ConectaJNDI();
        try{
           st = this.miBD.getCn().createStatement();
           rs = st.executeQuery("select * from pa_usuario_listar()");
           while(rs.next()){
               miUsuario = new eUsuario();
               miUsuario.setId_usuario(rs.getInt("id_usuario"));
                miUsuario.setUsuario(rs.getString("usuario"));
                miUsuario.setPassword(rs.getString("password"));
                rListado.add(miUsuario);
           }
       }catch(SQLException ex){
           Logger.getLogger(dUsuario.class.getName()).log(Level.SEVERE,null,ex);
       }
        this.miBD.DesconectarJNDI();
        return rListado;
    }
}
