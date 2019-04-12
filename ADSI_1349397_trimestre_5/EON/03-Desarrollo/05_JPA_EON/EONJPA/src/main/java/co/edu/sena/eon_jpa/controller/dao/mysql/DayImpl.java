/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.DayDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Day;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Telegrafia01
 */
public class DayImpl extends AbstractDao<Day> implements DayDao<Day> {

    public DayImpl(Class<Day> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Day> findByNameDay(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByNameDay");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Day> findByLikeNameDay(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByLikeNameDay");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Day> findByState(Boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Day> findByLikeState(Boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByLikeNameDay");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public int UpdatePk(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Day.updatePk");
                query.setParameter("documentoNuevo", llaveNueva);
                query.setParameter("documentoViejo", llaveVieja);
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
