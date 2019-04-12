/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AuditoryLogDao;
import co.edu.sena.eon_jpa.model.jpa.entities.AuditoryLog;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class AuditoryLogDaoImpl extends AbstractDao<AuditoryLog> implements AuditoryLogDao<AuditoryLog> {
    public AuditoryLogDaoImpl(Class<AuditoryLog> entityClass) {
        super(entityClass);
    }

    
    @Override
    public List<AuditoryLog> findByLevel(String Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLevel");
            query.setParameter("Level", Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByMessage(String Message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByMessage");
            query.setParameter("Message", Message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByDate(Date Date) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByDate");
            query.setParameter("Date", Date);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByUser(String User) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByUser");
            query.setParameter("User", User);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByLikeLevel(String Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLikeLevel");
            query.setParameter("Level", Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByLikeLogName(String logName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLikeLogName");
            query.setParameter("logName", logName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByLikeMessage(String Message) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLikeMessage");
            query.setParameter("Message", Message);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AuditoryLog> findByLikeUser(String User) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("AuditoryLog.findByLikeUser");
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

                Query query = this.em.createNamedQuery("AuditoryLog.updatePrimaryKey");
                query.setParameter("AudiNuevo", llaveNueva);
                query.setParameter("AudiViejo", llaveVieja);
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
