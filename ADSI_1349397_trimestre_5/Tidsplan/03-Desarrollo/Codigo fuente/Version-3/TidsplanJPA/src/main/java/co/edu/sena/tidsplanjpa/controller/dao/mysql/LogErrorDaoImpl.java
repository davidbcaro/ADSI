/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.LogErrorDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LogError;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class LogErrorDaoImpl extends AbstractDao<LogError> implements LogErrorDao<LogError> {

    public LogErrorDaoImpl(Class<LogError> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LogError> findByIdLog(BigInteger idLog) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByIdLog");
            query.setParameter("idLog", idLog);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByLikeIdLog(BigInteger idLog) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeIdLog");
            query.setParameter("idLog", idLog);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByLevel(String level) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLevel");
            query.setParameter("level", level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByLikeLevel(String level) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeLevel");
            query.setParameter("level", level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<LogError> findByLogName(String logName) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByLikeLogName(String logName) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByMessage(String message) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByMessage");
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<LogError> findByLikeMessage(String message) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeMessage");
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<LogError> findByDate(Date date) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByDate");
            query.setParameter("date", date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }


    @Override
    public int updatePrimaryKey(BigInteger newKey, BigInteger oldKey) {
 try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("LogError.updatePrimaryKey");
            query.setParameter("newLogError", newKey);
            query.setParameter("oldLogError", oldKey);
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

    @Override
    public List<LogError> findAll() {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
}
