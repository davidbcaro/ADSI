/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.BondingDAO;
import co.edu.sena.model.jpa.entities.Bonding;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class BondingDAOImpl extends AbstractDao<Bonding> implements BondingDAO<Bonding> {

    public BondingDAOImpl(Class<Bonding> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Bonding> findByTypeBonding(String typebonding) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByTypeBonding");
            query.setParameter("typebonding", typebonding);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Bonding> findByHours(int hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByHours");
            query.setParameter("hours", hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Bonding> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Bonding> findByLikeTypeBonding(String typebonding) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByLikeTypeBonding");
            query.setParameter("typeBonding", typebonding);
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

                Query query = this.em.createNamedQuery("Bonding.updatePrimaryKey");
                query.setParameter("bondingNew", llaveNueva);
                query.setParameter("bondingOld", llaveVieja);
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

    @Override
    public List<Bonding> findByLikeHours(String hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Bonding b WHERE b.hours LIKE ?",Bonding.class);
            query.setParameter(1, hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }
}


