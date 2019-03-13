/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Prophet
 */
public class Usuario {
    
    int dni;
    String nombre;
    String apellido;
    String pass;
    int nivel;

    public Usuario(int dni, String nombre, String apellido, String pass, int nivel) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.nivel = nivel;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
    
}
