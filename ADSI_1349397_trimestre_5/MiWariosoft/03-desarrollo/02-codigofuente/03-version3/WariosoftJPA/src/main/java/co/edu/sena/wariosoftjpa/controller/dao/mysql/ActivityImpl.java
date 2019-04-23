/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.ActivityDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Activity;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ActivityPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author WINDOWS 8
 */
public class ActivityImpl extends AbstractDAO<Activity> implements ActivityDAO<Activity> {

    public ActivityImpl(Class<Activity> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Activity> findByIdActivity(int idActivity) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByIdActivity");
            query.setParameter("idActivity", idActivity);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<Activity> findByNameActivity(String nameActivity) {
   try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByNameActivity");
            query.setParameter("nameActivity", nameActivity);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 

    }

    @Override
    public List<Activity> findByProjectCode(String projectCode) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Activity> findByLikeIdActivity(int idActivity) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeIdActivity");
            query.setParameter("idActivity", idActivity);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
       }

    @Override
    public List<Activity> findByLikeNameActivity(String nameActivity) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeNameActivity");
            query.setParameter("nameActivity", nameActivity);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public int updatePk(ActivityPK llaveNueva, ActivityPK llaveVieja) {
try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Activity.updatePk");
            query.setParameter("activityNuevo", llaveNueva.getIdActivity());
            query.setParameter("phaseNuevo", llaveNueva.getNamePhase());
            query.setParameter("codeNuevo", llaveNueva.getProjectCode());
            query.setParameter("activityViejo", llaveVieja.getIdActivity());
            query.setParameter("phaseViejo", llaveVieja.getNamePhase());
            query.setParameter("codeViejo", llaveVieja.getProjectCode());
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
