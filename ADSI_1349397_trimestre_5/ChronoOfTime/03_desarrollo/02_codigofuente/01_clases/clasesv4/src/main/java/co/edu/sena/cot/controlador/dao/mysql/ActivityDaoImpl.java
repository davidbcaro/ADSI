/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ActivityDao;
import co.edu.sena.cot.modelo.dto.Activity;
import co.edu.sena.cot.modelo.dto.ActivityPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ActivityDaoImpl extends AbstractDao<Activity> implements ActivityDao<Activity> {
    
    public ActivityDaoImpl (Class<Activity> entityClass) {
        super(entityClass);
        
    }

    @Override
    public List<Activity> findByName(String name) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Activity> findByIdActivity(String activity) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByIdActivity");
            query.setParameter("idActivity", activity);
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
            query.setParameter("phaseNamePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Activity> findByCodeProject(int codeProject) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByCodeProject");
            query.setParameter("phaseProjectCode", codeProject);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Activity> findByLikeName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByLikeIdActivity(String activity) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findByLikeIdActivity");
            query.setParameter("idActivity", activity);
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
            query.setParameter("phaseNamePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activity> findByLikeCodeProject(String codeProject) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.activity a  WHERE phase_Project_Code LIKE ?;", Activity.class);
            query.setParameter(1, codeProject);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(ActivityPK llaveNueva, ActivityPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Activity.updatePK");
                query.setParameter("IdActivityNew", llaveNueva.getIdActivity());
                query.setParameter("PhaseNamePhaseNew", llaveNueva.getPhaseNamePhase());
                query.setParameter("PhaseProjectCodeNew", llaveNueva.getPhaseProjectCode());
                
                query.setParameter("IdActivityOld", llaveVieja.getIdActivity());
                query.setParameter("PhaseNamePhaseOld", llaveVieja.getPhaseNamePhase());
                query.setParameter("PhaseProjectCodeOld", llaveVieja.getPhaseProjectCode());
                
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
