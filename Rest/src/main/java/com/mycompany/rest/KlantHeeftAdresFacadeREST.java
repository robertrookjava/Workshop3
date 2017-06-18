/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author robertrook
 */
@Stateless
@Path("com.mycompany.rest.klantheeftadres")
public class KlantHeeftAdresFacadeREST extends AbstractFacade<KlantHeeftAdres> {

    @PersistenceContext(unitName = "com.mycompany_Rest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private KlantHeeftAdresPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idKlant=idKlantValue;idAdres=idAdresValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.rest.KlantHeeftAdresPK key = new com.mycompany.rest.KlantHeeftAdresPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idKlant = map.get("idKlant");
        if (idKlant != null && !idKlant.isEmpty()) {
            key.setIdKlant(new java.lang.Integer(idKlant.get(0)));
        }
        java.util.List<String> idAdres = map.get("idAdres");
        if (idAdres != null && !idAdres.isEmpty()) {
            key.setIdAdres(new java.lang.Integer(idAdres.get(0)));
        }
        return key;
    }

    public KlantHeeftAdresFacadeREST() {
        super(KlantHeeftAdres.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(KlantHeeftAdres entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, KlantHeeftAdres entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.rest.KlantHeeftAdresPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public KlantHeeftAdres find(@PathParam("id") PathSegment id) {
        com.mycompany.rest.KlantHeeftAdresPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<KlantHeeftAdres> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<KlantHeeftAdres> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
