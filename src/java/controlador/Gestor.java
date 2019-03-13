/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.*;
import modelo.Usuario;
 
/*
 * @author Prophet
 */

public class Gestor {
     
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    
    public void abrirConexion(){

    try 
    {   
      String url = "jdbc:mysql://localhost;databaseName=WS";
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
    
    
    
    public Usuario getUsuario(int nroDni,int nivelID,String password)  
    {  
        Usuario nuevo = null;
        int dni;
        String nom;
        String ape;
        String pass;
        int nivel;
                
        
        try
        { 
          abrirConexion();
          st=con.createStatement();
          String sql="Select * from usuarios where dni=" + nroDni + "and nivel=" +nivelID +"and pass= "+password ;
          rs=st.executeQuery(sql);
          if(rs.next())
          { 
            
            nom=rs.getString("nombre");
            ape=rs.getString("apellido");
            dni=rs.getInt("dni");
            nivel=rs.getInt("nivel");
            pass=rs.getString("pass");
          
            nuevo =new Usuario(dni, nom, ape, pass, nivel);
                 
          }
        }
        catch(SQLException e)
        { 
            System.out.println("Error en la consulta:" + e.getMessage());
        }
        finally
        { 
            try{ 
                cerrarConexion();
            }
            catch(Exception e)
            { 
                System.out.println("Error en el cierre de la conexion:" + e.getMessage());
            }
        }
        return nuevo; 
    }
    
    
    
    
}
