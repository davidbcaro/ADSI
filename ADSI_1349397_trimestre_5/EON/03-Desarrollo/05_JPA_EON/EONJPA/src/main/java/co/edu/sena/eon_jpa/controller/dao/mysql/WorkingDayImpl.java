/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.WorkingDayDao;
import co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Telegrafia01
 */
public class WorkingDayImpl extends AbstractDao<WorkingDay> implements WorkingDayDao<WorkingDay>{
    
    public WorkingDayImpl(Class<WorkingDay> entityClass) {
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
    public List<WorkingDay> findByLikeName(String name) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

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
        return null;    }

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
        return null;    }

    @Override
    public List<WorkingDay> findByState(Boolean state) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

    @Override
    public List<WorkingDay> findByAcronymsWorkingDay(String acronymsWorkingDay) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

    @Override
    public List<WorkingDay> findByLikeAcronymsWorkingDay(String acronymsWorkingDay) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

    @Override
    public int updatePrimaryKey(String NuevoAcronim, String ViejoAcronim) {
      try {
            this.getEntityManager();

            if (this.find(ViejoAcronim) != null) {

                Query query = this.em.createNamedQuery("WorkingDay.updatePrimaryKey");
                query.setParameter("NuevoAcronim", NuevoAcronim);
                query.setParameter("ViejoAcronim", ViejoAcronim );
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
