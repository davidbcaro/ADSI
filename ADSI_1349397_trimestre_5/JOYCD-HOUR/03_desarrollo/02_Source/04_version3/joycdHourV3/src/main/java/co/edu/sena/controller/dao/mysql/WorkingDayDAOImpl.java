/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.WorkingDayDAO;
import co.edu.sena.model.jpa.entities.WorkingDay;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class WorkingDayDAOImpl extends AbstractDao<WorkingDay> implements WorkingDayDAO<WorkingDay> {

    public WorkingDayDAOImpl(Class<WorkingDay> entityClass) {
        super(entityClass);
    }

    @Override
    public List<WorkingDay> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<WorkingDay> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByPicture(byte picture) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByPicture");
            query.setParameter("picture", picture);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }
     
    
        @Override
    public List<WorkingDay> findByInitials(String Initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByInitials");
            query.setParameter("initials", Initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }
    
        
        @Override
    public List<WorkingDay> findByLikeInitials(String Initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeInitials");
            query.setParameter("initials", Initials);
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

                Query query = this.em.createNamedQuery("WorkingDay.updatePrimaryKey");
                query.setParameter("InitialsNew", llaveNueva);
                query.setParameter("InitialsOld", llaveVieja);
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
