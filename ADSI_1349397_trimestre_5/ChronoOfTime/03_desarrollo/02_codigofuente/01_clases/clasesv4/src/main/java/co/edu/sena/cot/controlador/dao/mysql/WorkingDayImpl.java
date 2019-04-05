/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.WorkingDayDao;
import co.edu.sena.cot.modelo.dto.WorkingDay;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
public class WorkingDayImpl extends AbstractDao<WorkingDay> implements WorkingDayDao<WorkingDay> {

    public WorkingDayImpl(Class<WorkingDay> entityClass) {
        super(entityClass);
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
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
       try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("WorkingDay.updatePK");
            query.setParameter("WorkingNew", llaveNueva );
            query.setParameter("WorkingOld", llaveVieja );
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
