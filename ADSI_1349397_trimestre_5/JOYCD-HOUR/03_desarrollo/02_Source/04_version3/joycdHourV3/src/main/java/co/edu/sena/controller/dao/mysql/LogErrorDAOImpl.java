/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.LogErrorDAO;
import co.edu.sena.model.jpa.entities.LogError;
import java.sql.Clob;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class LogErrorDAOImpl extends AbstractDao<LogError> implements LogErrorDAO<LogError> {

    public LogErrorDAOImpl(Class<LogError> entityClass) {
        super(entityClass);
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
    public List<LogError> findByLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLevel");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByMessage(Clob menssage) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_error l WHERE message LIKE ?;", LogError.class);
            query.setParameter("menssage", menssage);
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
    public List<LogError> findByUser(String user) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByUser");
            query.setParameter("user", user);
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
    public List<LogError> findByLikeLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_error l WHERE message LIKE ?;", LogError.class);
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeMessage(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_error l WHERE message LIKE ?;", LogError.class);
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeDate(String date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_error l WHERE date LIKE ?;", LogError.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeUser(String user) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeUser");
            query.setParameter("user", user);
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

                Query query = this.em.createNamedQuery("LogError.updatePrimaryKey");
                query.setParameter("logErrorNew", llaveNueva);
                query.setParameter("logErrorOld", llaveVieja);
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

    @Override
    public List<LogError> findByLikeLogError(String logError) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLikeLevel");
            query.setParameter("logError", logError);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLogError(long logError) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLogError");
            query.setParameter("logError", logError);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

}
