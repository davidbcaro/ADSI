/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LogErrorDao;
import co.edu.sena.cot.modelo.dto.LogError;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LogErrorImpl extends AbstractDao<LogError> implements LogErrorDao<LogError>{

    public LogErrorImpl(Class<LogError> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LogError> findByLogError(int logError) {
        try {
              try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LogError.findByLogError");
            query.setParameter("logError", logError);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption "+e.getMessage());
        }
        return null;
        } catch (Exception e) {
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
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exeption "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<LogError> findByLikeLogError(String logError) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.log_error l WHERE log_error LIKE ?;", LogError.class);
            query.setParameter(1, logError);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(int llaveNueva, int llaveVieja) {
        try {
            this.getEntityManager();
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("LogError.updatePK");
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
    
}
