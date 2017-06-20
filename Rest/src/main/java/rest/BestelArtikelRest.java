/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dao.BestelArtikelDao;
import pojo.BestelArtikel;
import pojo.BestelArtikelPK;
import java.util.List;
import javax.ejb.EJB;
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
@Path("bestelartikel")
public class BestelArtikelRest  {
    
    @EJB
    private BestelArtikelDao bestelArtikelDao;

    

    private BestelArtikelPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idBestelling=idBestellingValue;idArtikel=idArtikelValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        pojo.BestelArtikelPK key = new pojo.BestelArtikelPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idBestelling = map.get("idBestelling");
        if (idBestelling != null && !idBestelling.isEmpty()) {
            key.setIdBestelling(new java.lang.Integer(idBestelling.get(0)));
        }
        java.util.List<String> idArtikel = map.get("idArtikel");
        if (idArtikel != null && !idArtikel.isEmpty()) {
            key.setIdArtikel(new java.lang.Integer(idArtikel.get(0)));
        }
        return key;
    }

   

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(BestelArtikel entity) {
        bestelArtikelDao.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, BestelArtikel entity) {
        bestelArtikelDao.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        pojo.BestelArtikelPK key = getPrimaryKey(id);
        bestelArtikelDao.remove(bestelArtikelDao.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public BestelArtikel find(@PathParam("id") PathSegment id) {
        pojo.BestelArtikelPK key = getPrimaryKey(id);
        return bestelArtikelDao.find(key);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BestelArtikel> findAll() {
        return bestelArtikelDao.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BestelArtikel> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return bestelArtikelDao.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(bestelArtikelDao.count());
    }

   
}
