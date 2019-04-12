/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.LogErrorDao;
import co.edu.sena.eon_jpa.model.jpa.entities.LogError;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LogErrorDaoImpl extends AbstractDao<LogError> implements LogErrorDao<LogError> {

    public LogErrorDaoImpl(Class<LogError> entityClass) {
        super(entityClass);
    }

    
    @Override
    public List<LogError> findByLevel(String Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLevel");
            query.setParameter("Level", Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
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
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByMessage(String Message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByMessage");
            query.setParameter("Message", Message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByDate(Date Date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByDate");
            query.setParameter("Date", Date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByUser(String User) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByUser");
            query.setParameter("User", User);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeLevel(String Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeLevel");
            query.setParameter("Level", Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
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
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeMessage(String Message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeMessage");
            query.setParameter("Message", Message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeUser(String User) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeUser");
            query.setParameter("User", User);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(long llaveNueva, long llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("LogError.updatePrimaryKey");
                query.setParameter("LogNuevo", llaveNueva);
                query.setParameter("LogViejo", llaveVieja);
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
            } else {
                return 0;
            }
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
}
