/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.LogAuditDAO;
import co.edu.sena.model.jpa.entities.LogAudit;
import java.sql.Clob;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class LogAuditDAOImpl extends AbstractDao<LogAudit> implements LogAuditDAO<LogAudit> {

    public LogAuditDAOImpl(Class<LogAudit> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LogAudit> findByLogAudit(long logAudit) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLogAudit");
            query.setParameter("logAudit", logAudit);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLevel(String level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLevel");
            query.setParameter("level", level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByMessage(Clob message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_audit l WHERE message LIKE ?;", LogAudit.class);
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByDate(Date date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByDate");
            query.setParameter("date", date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByUser(String user) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByUser");
            query.setParameter("user", user);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeLogAudit(String logAudit) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeLogAudit");
            query.setParameter("logAudit", logAudit);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeLevel(String level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeLevel");
            query.setParameter("level", level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeLevel");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeMessage(String message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_audit l WHERE message LIKE ?;", LogAudit.class);
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeDate(String date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.log_audit l WHERE date LIKE ?;", LogAudit.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeUser(String user) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeUser");
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
                query.setParameter("LogErrorNew", llaveNueva);
                query.setParameter("LogErrorOld", llaveVieja);
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
