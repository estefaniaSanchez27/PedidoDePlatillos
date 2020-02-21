/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.Persona;
import com.dominio.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@Named(value = "personaBean")
@ManagedBean
@SessionScoped
public class PersonaBean implements Serializable {

    private long id;
    private String nombre;
    private String telefono;
    private String direccion;
    
    @EJB
    private PersonaFacade personaFacade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public List<Persona> getPersonas(){
        return this.personaFacade.findAll();
    }
    
    public String guarduar(){
        Persona pe = new Persona();
        pe.setNombre(nombre);
        pe.setTelefono(telefono);
        pe.setDireccion(direccion);
        this.personaFacade.create(pe);
        this.id=pe.getId();
        return "index";
    }
    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
    }
    
}
