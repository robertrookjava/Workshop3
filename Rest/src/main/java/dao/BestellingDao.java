/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Bestelling;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author robertrook
 */
@Stateless
public class BestellingDao extends AbstractDao<Bestelling> {

    @PersistenceContext(unitName = "com.mycompany_Rest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellingDao() {
        super(Bestelling.class);
    }
    
}
