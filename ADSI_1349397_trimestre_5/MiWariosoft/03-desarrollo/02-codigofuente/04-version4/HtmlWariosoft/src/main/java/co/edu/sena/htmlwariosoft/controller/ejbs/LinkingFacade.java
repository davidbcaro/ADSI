/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.controller.ejbs;

import co.edu.sena.htmlwariosoft.model.entities.Linking;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 1349397
 */
@Stateless
public class LinkingFacade extends AbstractFacade<Linking> {

    @PersistenceContext(unitName = "co.edu.sena_HtmlWariosoft_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LinkingFacade() {
        super(Linking.class);
    }
    
}
