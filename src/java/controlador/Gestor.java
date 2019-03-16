/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.*;
import java.sql.CallableStatement;
import java.util.ArrayList;
import modelo.Nivel;
import modelo.Usuario;
 
/*
 * @author Prophet
 */

public class Gestor {
     
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pstm;
    CallableStatement cst;
    
    
    public void abrirConexion() {
        try 
        {
            String url = "jdbc:mysql://localhost:3306/WS?zeroDateTimeBehavior=convertToNull";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, "root", "");
        } 
        catch (Exception e) 
        {
            System.out.println("Error en conexión: " + e.getMessage());
        }

    }

    public void cerrarConexion() {
        try 
        {
            con.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
    
    
    public Usuario getUsuario(int nroDni,int nivelID)  
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
          String sql="{call sp_logueo(?,?)}";
          cst = con.prepareCall(sql);
          cst.setInt(1, nroDni);
          cst.setInt(2, nivelID);
          rs= cst.executeQuery();
          
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
            try
            { 
                cerrarConexion();
            }
            catch(Exception e)
            { 
                System.out.println("Error en el cierre de la conexion:" + e.getMessage());
            }
        }
        return nuevo; 
    }
    
    public String addUsuario(Usuario u)
     {
         
        String mensaje = "No se pudo registrar el usuario.";
        
        try 
        {
            abrirConexion();
            String q = "INSERT INTO USUARIOS VALUES (?,?,?,?,?)";
            pstm = con.prepareStatement(q);
            pstm.setInt(1, u.getDni());
            pstm.setString(2,u.getNombre());
            pstm.setString(3,u.getApellido());
            pstm.setInt(4,u.getNivel());
            pstm.setString(5,u.getPass());
            
            int resultado = pstm.executeUpdate();
            
            pstm.close();
            con.close();
            if(resultado>0)
            {
                mensaje = "Usuario registrado con éxito.";
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error al realizar el registro: " +e);
        }
        return mensaje;
        
    }
    
    public ArrayList<Nivel> getListadoNiveles()  
    {  
        ArrayList<Nivel> listado = new ArrayList<>();
        
        Nivel n;
        int id;
        String des;
        
                
        
        try
        { 
          abrirConexion();
       
          String sql="Select * from niveles";
        
          st=con.createStatement();
          rs=st.executeQuery(sql);    
        
          
          
          while(rs.next())
          { 
            id=rs.getInt("id");
            des=rs.getString("descripcion");
            n = new Nivel(id,des);
            listado.add(n);
          }
          
          
        }
        catch(SQLException e)
        { 
            System.out.println("Error en la consulta:" + e.getMessage());
        }
        finally
        { 
            try
            { 
                cerrarConexion();
            }
            catch(Exception e)
            { 
                System.out.println("Error en el cierre de la conexion:" + e.getMessage());
            }
        }
        return listado; 
    }
     
    public ArrayList<Usuario> getListadoUsuarios()  
    {  
        ArrayList<Usuario> listado = new ArrayList<>();
        
        Usuario u;
        int nroDoc;
        String ape;
        String nom;
        int nivelID;
        String pass;
                
        
        try
        { 
          abrirConexion();
       
          String sql="Select * from usuarios";
        
          st=con.createStatement();
          rs=st.executeQuery(sql);    
        
          
          
          while(rs.next())
          { 
            nroDoc=rs.getInt(1);
            nom=rs.getString(2);
            ape=rs.getString(3);
            nivelID = rs.getInt(4);
            pass = rs.getString(5);
            u = new Usuario(nroDoc, nom, ape, pass, nivelID);
            listado.add(u);
          }
          
          
        }
        catch(SQLException e)
        { 
            System.out.println("Error en la consulta:" + e.getMessage());
        }
        finally
        { 
            try
            { 
                cerrarConexion();
            }
            catch(Exception e)
            { 
                System.out.println("Error en el cierre de la conexion:" + e.getMessage());
            }
        }
        return listado; 
    }
}
