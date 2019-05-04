/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.TrimesterCurrentDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterCurrent;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 *
 * @author 1349397
 */
public class TrimesterCurrentDaoImpl extends AbstractDao<TrimesterCurrent> implements TrimesterCurrentDao<TrimesterCurrent>{

    public TrimesterCurrentDaoImpl(Class<TrimesterCurrent> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TrimesterCurrent> findByIdTrimester(String idTrimester) {
  try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("TrimesterCurrent.findByIdTrimester");
            que.setParameter("idTrimester", idTrimester);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterCurrent> findByLikeIdTrimester(String idTrimester) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("TrimesterCurrent.findByLikeIdTrimester");
            que.setParameter("idTrimester", idTrimester);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    }

    @Override
    public List<TrimesterCurrent> findByStartDate(Date startDate) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterCurrent.findByStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterCurrent> findByLikeStartDate(Date startDate) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterCurrent.findByLikeStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<TrimesterCurrent> findByEndDate(Date endDate) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterCurrent.findByEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterCurrent> findByLikeEndDate(Date endDate) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterCurrent.findByLikeEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

    @Override
    public List<TrimesterCurrent> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterCurrent.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }
    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
         try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("TrimesterCurrent.updatePrimaryKey");
            query.setParameter("newTrimesterCurrent", newKey );
            query.setParameter("oldTrimesterCurrent", oldKey );
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
