/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.*;
 
/*
 * @author Prophet
 */

public class Conexion {
     
    Connection con;
    
    public void abrirConexion(){

    try 
    {   
      String url = "jdbc:mysql://localhost:3306/WS?zeroDateTimeBehavior=convertToNull";
      String us = "root";
      String psw = "";
      con = DriverManager.getConnection(url, us, psw);
    } 
    
    catch (SQLException e) {
            System.out.println("Error en la conexion"+e);
        }
    }
    
    public void cerrarConexion(){
        try 
        {
           con.close();
        } 
        catch (SQLException e) {
            System.out.println("Error al cerrar conexion" +e);
        }
    }
}
