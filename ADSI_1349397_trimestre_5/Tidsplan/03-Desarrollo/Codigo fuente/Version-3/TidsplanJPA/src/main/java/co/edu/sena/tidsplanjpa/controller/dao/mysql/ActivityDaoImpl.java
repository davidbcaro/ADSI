/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;


import co.edu.sena.tidsplanjpa.controller.dao.ActivityDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Activity;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ActivityPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ActivityDaoImpl extends AbstractDao<Activity> implements ActivityDao<Activity> {

    public ActivityDaoImpl(Class<Activity> entityClass) {
        super(entityClass);

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
            Query query = this.em.createNamedQuery("Activity.findByProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<Activity> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Activity.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(ActivityPK newKey, ActivityPK oldKey) {
       try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Activity.updatePrimaryKey");
                query.setParameter("newIdActivity", newKey.getIdActivity());
                query.setParameter("oldIdActivity", oldKey.getIdActivity());
                query.setParameter("newNamePhase", newKey.getNamePhase());
                query.setParameter("oldNamePhase", oldKey.getNamePhase());
                query.setParameter("newProjectCode", newKey.getProjectCode());
                query.setParameter("oldProjectCode", oldKey.getProjectCode());
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
