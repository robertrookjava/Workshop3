/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.AdresType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author robertrook
 */
@Stateless
public class AdresTypeFacade extends AbstractFacade<AdresType> {

    @PersistenceContext(unitName = "com.mycompany_Rest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresTypeFacade() {
        super(AdresType.class);
    }
    
}
