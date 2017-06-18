/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author robertrook
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.rest.AccountFacadeREST.class);
        resources.add(com.mycompany.rest.AccountypeFacadeREST.class);
        resources.add(com.mycompany.rest.AdresFacadeREST.class);
        resources.add(com.mycompany.rest.AdresTypeFacadeREST.class);
        resources.add(com.mycompany.rest.ArtikelFacadeREST.class);
        resources.add(com.mycompany.rest.BestelArtikelFacadeREST.class);
        resources.add(com.mycompany.rest.BestellingFacadeREST.class);
        resources.add(com.mycompany.rest.KlantFacadeREST.class);
        resources.add(com.mycompany.rest.KlantHeeftAdresFacadeREST.class);
    }
    
}
