/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.EnvironmentDAO;
import co.edu.sena.model.jpa.entities.Environment;
import co.edu.sena.model.jpa.entities.EnvironmentPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class EnvironmentDAOImpl extends AbstractDao<Environment> implements EnvironmentDAO<Environment> {
    
    public EnvironmentDAOImpl(Class<Environment> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Environment> findByNumberEnvironment(String numberEnvironment) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByNumberEnvironment");
            query.setParameter("numberEnvironment", numberEnvironment);
            
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Environment> findByDescription(String description) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByHeadQuartersName(String headQuartersName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByHeadquartersName");
            query.setParameter("headquartersName", headQuartersName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeNumberEnvironment(String numberEnvironment) {
       try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.environment e WHERE number_environment LIKE ?;",Environment.class);
            query.setParameter(1, numberEnvironment);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByLikeHeadQuartersName(String headQuartersName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByLikeHeadQuartersName");
            query.setParameter("headquartersName", headQuartersName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(EnvironmentPK llaveNueva, EnvironmentPK llaveVieja) {
       try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Environment.updatePrimaryKey");
            query.setParameter("headquartersNameNew", llaveNueva.getHeadquartersName());
            query.setParameter("numberEnvironmentNew", llaveNueva.getNumberEnvironment());
            query.setParameter("headquartersNameOld", llaveVieja.getHeadquartersName());
            query.setParameter("numberEnvironmentOld", llaveVieja.getNumberEnvironment());              
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
