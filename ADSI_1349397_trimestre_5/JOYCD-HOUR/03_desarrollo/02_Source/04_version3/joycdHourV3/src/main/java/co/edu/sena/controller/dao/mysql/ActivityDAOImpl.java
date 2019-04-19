/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ActivityDAO;
import co.edu.sena.model.jpa.entities.Activity;
import co.edu.sena.model.jpa.entities.ActivityPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Chritian
 */
public class ActivityDAOImpl extends AbstractDao<Activity> implements ActivityDAO<Activity>{

    public ActivityDAOImpl(Class<Activity> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Activity> findByIdActivity(String idActivity) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByIdActivity");
            query.setParameter("idActivity", idActivity);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<Activity> finByNameActivity(String nameActivity) {
        
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByNameActivity");
            query.setParameter("nameActivity", nameActivity);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByNamePhase(String namePhase) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByNamePhase");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByProjectCode(String projectCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByProjectcode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    
    }

    @Override
    public List<Activity> findByLikeIdActivity(String idActivity) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeIdActivity");
            query.setParameter("idActivity", idActivity);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> finByLikeNameActivity(String nameActivity) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.finByLikeNameActivity");
            query.setParameter("nameActivity", nameActivity);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByLikeNamePhase(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeNamePhase");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByLikeProjectCode(String projectCode) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(ActivityPK llaveNueva, ActivityPK llaveVieja) {
        
         try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Activity.updatePrimaryKey");
            query.setParameter("idActivityNew", llaveNueva.getIdActivity());
            query.setParameter("namePhaseNew", llaveNueva.getNamePhase());
            query.setParameter("projectCodeNew", llaveNueva.getProjectcode());
            query.setParameter("idActivityOld", llaveVieja.getIdActivity());
            query.setParameter("namePhaseOld", llaveVieja.getNamePhase());
            query.setParameter("projectCodeOld", llaveVieja.getProjectcode());              
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
    
}
