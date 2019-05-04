/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.WorkingDayDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.WorkingDay;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class WorkingDayDaoImpl extends AbstractDao<WorkingDay> implements WorkingDayDao<WorkingDay> {

    public WorkingDayDaoImpl(Class<WorkingDay> entityClass) {
        super(entityClass);

    }

    @Override
    public List<WorkingDay> findByLikeInitials(String initials) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByInitials(String initials) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
       @Override
    public List<WorkingDay> findByLikeName(String name) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
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
    public List<WorkingDay> findByLikeDescription(String description) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeDescription");
            query.setParameter("description", description);
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
        public int updatePrimaryKey(String newKey, String oldKey) {
            try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("WorkingDay.updatePrimaryKey");
            query.setParameter("newInitials", newKey );
            query.setParameter("oldInitials", oldKey );
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
    
        return 0;
    
    }

    @Override
    public List<WorkingDay> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

}
