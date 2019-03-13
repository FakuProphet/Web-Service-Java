/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import controlador.Gestor;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Usuario;

/**
 *
 * @author Prophet
 */
@WebService(serviceName = "WebServiceGestionUsuario")
public class WebServiceGestionUsuario {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarLogin")
    public Usuario ValidarLogin(@WebParam(name = "dni") int dni, @WebParam(name = "nivelID") int nivelID) {
       
        Gestor g = new Gestor();
        Usuario nuevo = g.getUsuario(dni, nivelID);
        
        return nuevo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "servicioDeRegistro")
    public String servicioDeRegistro(@WebParam(name = "doc") int doc, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "nivel") int nivel, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return null;
    }
}
