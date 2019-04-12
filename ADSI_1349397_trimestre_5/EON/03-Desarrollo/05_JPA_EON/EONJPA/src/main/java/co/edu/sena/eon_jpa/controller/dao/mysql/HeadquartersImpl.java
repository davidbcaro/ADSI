/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.HeadquartersDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Headquarters;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Telegrafia01
 */
public class HeadquartersImpl extends AbstractDao<Headquarters> implements HeadquartersDao<Headquarters> {

    public HeadquartersImpl(Class<Headquarters> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Headquarters> findByNameHeadquarters(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByNameHeadquarters");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByLikeNameHeadquarters(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByLikeNameheadquarters");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByAddres(String addres) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByAddres");
            query.setParameter("addres", addres);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByLikeAddres(String addres) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByLikeAddres");
            query.setParameter("addres", addres);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByState(Boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String nuevoHeadquarters, String viejoHeadquarters) {
        try {
            this.getEntityManager();

            if (this.find(viejoHeadquarters) != null) {

                Query query = this.em.createNamedQuery("Headquarters.updatePrimaryKey");
                query.setParameter("nuevoHeadquarters", nuevoHeadquarters);
                query.setParameter("viejoHeadquarters", viejoHeadquarters);
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
