/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ActivityDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Activity;
import co.edu.sena.eon_jpa.model.jpa.entities.ActivityPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class ActivityDaoImpl extends AbstractDao<Activity> implements ActivityDao<Activity>{
    public ActivityDaoImpl(Class entityClass) {
        super(entityClass);
    }
    
    @Override
    public List<Activity> findByIdActivity(int id_Activity) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByIdActivity");
            query.setParameter("IdActivity", id_Activity);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Activity> findByName(String Name){
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByName");
            query.setParameter("Name", Name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Activity> findByNamePhase(String name_phase){
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByNamePhase");
            query.setParameter("namePhase", name_phase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }
    
    @Override
    public List<Activity> findByCode(String Code){
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }
    
    @Override
    public List<Activity> findByLikeName(String Name){
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeName");
            query.setParameter("Name", Name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Activity> findByLikeNamePhase(String name_phase){
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeNamePhase");
            query.setParameter("namePhase", name_phase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }
    
    @Override
    public List<Activity> findByLikeCode(String Code){
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }
    
    @Override
    public int updatePrimaryKey(ActivityPK llaveNueva, ActivityPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Activity.updatePrimaryKey");
                query.setParameter("idNuevo", llaveNueva.getIdActivity());
                query.setParameter("NamePhaseNuevo", llaveNueva.getNamePhase());
                query.setParameter("CodeNuevo", llaveNueva.getCode());
                query.setParameter("idViejo", llaveVieja.getIdActivity());
                query.setParameter("NamePhaseViejo", llaveVieja.getNamePhase());
                query.setParameter("CodeViejo", llaveVieja.getCode());
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
