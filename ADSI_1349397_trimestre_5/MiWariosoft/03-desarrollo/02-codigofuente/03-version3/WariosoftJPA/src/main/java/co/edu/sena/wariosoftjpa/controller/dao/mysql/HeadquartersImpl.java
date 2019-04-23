/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.HeadquartersDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Headquarters;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Sebastian
 */
public class HeadquartersImpl extends AbstractDAO<Headquarters> implements HeadquartersDAO<Headquarters>{

    public HeadquartersImpl(Class<Headquarters> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Headquarters> findByHeadquarters(String headquarters) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByHeadquarters");
            query.setParameter("Headquarters", headquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByAddress(String address) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByAddress");
            query.setParameter("Address", address);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByLikeHeadquarters(String headquarters) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByLikeHeadquarters");
            query.setParameter("Headquarters", headquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            if (this.find(llaveVieja) != null) {
                Query query = this.em.createNamedQuery("Headquarters.updatePrimaryKey");
                query.setParameter("sedeNueva", llaveNueva);
                query.setParameter("sedeVieja", llaveVieja);
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
            } else {
                return 0;
            }
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return 0;
    }
    
    

    
}
