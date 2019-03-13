/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

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
    public Usuario ValidarLogin(@WebParam(name = "dni") int dni, @WebParam(name = "nivelID") int nivelID, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return null;
    }
}
