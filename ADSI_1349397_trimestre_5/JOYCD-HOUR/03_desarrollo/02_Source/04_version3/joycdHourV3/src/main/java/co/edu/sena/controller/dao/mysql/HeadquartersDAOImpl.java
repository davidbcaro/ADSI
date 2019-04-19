/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.HeadquartersDAO;
import co.edu.sena.model.jpa.entities.Headquarters;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class HeadquartersDAOImpl extends AbstractDao<Headquarters> implements HeadquartersDAO<Headquarters> {

    public HeadquartersDAOImpl(Class<Headquarters> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Headquarters> findByNameHeadquarters(String nameHeadquarters) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByNameHeadquarters");
            query.setParameter("nameHeadquarters", nameHeadquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByDirection(String direction) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByDirection");
            query.setParameter("direction", direction);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByLikeHeadquarters(String nameHeadquarters) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByLikeNameHeadquarters");
            query.setParameter("nameHeadquarters", nameHeadquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquarters> findByLikeDirection(String direction) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquarters.findByLikeDirection");
            query.setParameter("direction", direction);
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
                query.setParameter("headquartersNew", llaveNueva);
                query.setParameter("headquartersOld", llaveVieja);
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
