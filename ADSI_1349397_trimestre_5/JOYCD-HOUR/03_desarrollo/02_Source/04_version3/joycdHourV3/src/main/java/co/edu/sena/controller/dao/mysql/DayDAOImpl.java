/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.DayDAO;
import co.edu.sena.model.jpa.entities.Day;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class DayDAOImpl extends AbstractDao<Day> implements DayDAO<Day> {

    public DayDAOImpl(Class<Day> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Day> findByNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Day> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Day> findByLikeNameDay(String nameDay) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByLikeNameDay");
            query.setParameter("nameDay", nameDay);
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

                Query query = this.em.createNamedQuery("Day.updatePrimaryKey");
                query.setParameter("dayNew", llaveNueva);
                query.setParameter("dayOld", llaveVieja);
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
