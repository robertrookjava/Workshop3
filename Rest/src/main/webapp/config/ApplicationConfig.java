/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

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
        resources.add(rest.AccountFacadeREST.class);
        resources.add(rest.AccountypeFacadeREST.class);
        resources.add(rest.AdresFacadeREST.class);
        resources.add(rest.AdresTypeFacadeREST.class);
        resources.add(rest.ArtikelFacadeREST.class);
        resources.add(rest.BestelArtikelFacadeREST.class);
        resources.add(rest.BestellingFacadeREST.class);
        resources.add(rest.KlantFacadeREST.class);
        resources.add(rest.KlantHeeftAdresFacadeREST.class);
    }
    
}
