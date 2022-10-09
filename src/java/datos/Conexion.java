/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jean Paul
 */

public class Conexion {
    private String USERNAME="root";
    private String PASSWORD="anghello2002";
    //private String PASSWORD="TRPoqh66364";
    //private String HOST="node115050-env-7534928.jelastic.saveincloud.net";
    private String HOST="localhost";
    private String PORT="3306";
    private String DATABASE="tiendaonline";
    private String CLASSNAME="com.mysql.cj.jdbc.Driver";
    private String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?serverTimezone=UTC";
    
    private Connection con;
    
    public Conexion(){
        
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(ClassNotFoundException e){
            System.out.println("Error 1: "+e);
        }catch(SQLException e){
            System.out.println("Error 2: "+e);
        } 
        
    }
    
    public Connection getConexion(){
        return con;
    }
    
    
    public void close(){
        con = null;
    }
}
