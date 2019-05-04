/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.EnvironmentDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Environment;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EnvironmentPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author JulianC
 */
public class EnvironmentDaoImpl extends AbstractDao<Environment> implements EnvironmentDao<Environment> {

    public EnvironmentDaoImpl(Class<Environment> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Environment> findByNumberEnvironment(String numberEnvironment) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByNumberEnvironment");
            que.setParameter("numberEnvironment", numberEnvironment);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeNumberEnvironment(String numberEnvironment) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByLikeNumberEnvironment");
            que.setParameter("numberEnvironment", numberEnvironment);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByDescription");
            que.setParameter("description", description);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeDescription(String description) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByLikeDescription");
            que.setParameter("description", description);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByStatus");
            que.setParameter("status", status);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(EnvironmentPK newKey, EnvironmentPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Environment.updatePrimaryKey");
                query.setParameter("newNumberEnvironment", newKey.getNumberEnvironment());
                query.setParameter("newNameHeadquartes", newKey.getNameHeadquartes());
                query.setParameter("oldNumberEnvironment", oldKey.getNumberEnvironment());
                query.setParameter("oldNameHeadquartes", oldKey.getNameHeadquartes());
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
    public List<Environment> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByNameHeadquartes(String nameHeadquartes) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByNameHeadquartes");
            que.setParameter("nameHeadquartes", nameHeadquartes);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeNameHeadquartes(String nameHeadquartes) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Environment.findByLikeNameHeadquartes");
            que.setParameter("nameHeadquartes", nameHeadquartes);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

}
