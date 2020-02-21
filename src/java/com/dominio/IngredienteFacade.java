/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dominio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@Stateless
public class IngredienteFacade extends AbstractFacade<Ingrediente> {

    @PersistenceContext(unitName = "PedidoDePlatillosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngredienteFacade() {
        super(Ingrediente.class);
    }
    
}
