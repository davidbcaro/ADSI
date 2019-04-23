/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.WorkingDayDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class WorkingDayImpl extends AbstractDAO<WorkingDay> implements WorkingDayDAO<WorkingDay>{

    public WorkingDayImpl(Class<WorkingDay> entityClass) {
        super(entityClass);
    }

    @Override
    public List<WorkingDay> findByInitialsWorkingDay(String initialsworkingday) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByInitialsWorkingDay");
            query.setParameter("InitialsWorkingDay", initialsworkingday);
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
            query.setParameter("Name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByDescription(String description) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByDescription");
            query.setParameter("Description", description);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkingDay> findByLikeInitialsWorkingDay(String initialsworkingday) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("WorkingDay.findByLikeInitialsWorkingDay");
            query.setParameter("InitialsWorkingDay", initialsworkingday );
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
                query.setParameter("inicialesDeJornadaLaboralNuevas", llaveNueva);
                query.setParameter("inicialesDeJornadaLaboralViejas", llaveVieja);
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
