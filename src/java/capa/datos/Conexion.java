/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author root
 */
public class Conexion {

    //objetos para conectar al pool en glashfish
    private String jndi = "jdbc/taller";
    private Context ctx;
    private DataSource ds;
    //objetos para conectar via jdbc normal
    private String driver = "org.postgresql.Driver";
    private String connectString="jdbc:postgresql://localhost:5432/Taller?Schema=public";
    private String user="Essalud";
    private String password ="sql";
    //objetos comunes
    private Connection Cn;
    
    public Conexion(){
        
    }

   public void ConectaJNDI(){
       try{
           //se carga el contexto inicial para realizar operaciones JNDI
           ctx=new javax.naming.InitialContext();
           //se busca el recurso correspondiente al pool de conexiones
           ds= (DataSource) ctx.lookup(this.jndi);
           Cn=ds.getConnection();
       }catch (SQLException | NamingException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
       }
   }
   public void DesconectarJNDI(){
       try{
           Cn.close();
           ctx.close();
       }catch(SQLException | NamingException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
       }
   }
   public void ConectaJDBC()  {
       try{
           Class.forName(driver);
           Cn=DriverManager.getConnection(connectString,user,password);
       }catch (ClassNotFoundException | SQLException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
       }
   }
   public void DesconectarJDBC(){
       try{
           Cn.close();
       }catch(SQLException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
       }
   }
    public Connection getCn() {
        return Cn;
    }

    public void setCn(Connection Cn) {
        this.Cn = Cn;
    }
    
}
