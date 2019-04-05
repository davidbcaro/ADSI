/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LogAuditDao;
import co.edu.sena.cot.modelo.dto.LogAudit;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 *
 * @author 1349397
 */
public class LogAuditDaoImpl extends AbstractDao<LogAudit> implements LogAuditDao<LogAudit>{

    public LogAuditDaoImpl(Class<LogAudit> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LogAudit> findByLogAudit(Long logAu) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLogAudit");
            query.setParameter("logAudit", logAu);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption: "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByMessage(String message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByMessage");
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(Long llaveNueva, Long llaveVieja) {
        try {
            this.getEntityManager();
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("LogAudit.updatePK");
                query.setParameter("llaveVieja", llaveVieja);
                query.setParameter("llaveNueva", llaveNueva);
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
                
            }else{
                return 0;
            }
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return 0;
    }

    @Override
    public List<LogAudit> findByLikeLogAudit(String logAu) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.log_audit l WHERE log_audit LIKE ?;", LogAudit.class) ;
            query.setParameter(1, logAu);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeMessage(String message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeMessage");
            query.setParameter("message", message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogAudit> findByLikeDate(String date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogAudit.findByLikeDate");
            query.setParameter("date", date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    
    
}
