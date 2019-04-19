/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.EmailServerDAO;
import co.edu.sena.model.jpa.entities.EmailServer;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class EmailServerDAOImpl extends AbstractDao<EmailServer> implements EmailServerDAO<EmailServer> {

    public EmailServerDAOImpl(Class<EmailServer> entityClass) {
        super(entityClass);
    }

    @Override
    public List<EmailServer> findByEmail(String email) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByEmail");
            query.setParameter("email", email);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByPassword(String password) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByPassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findBySmtpHost(String smtpHost) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpHost");
            query.setParameter("smtpHost", smtpHost);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findBySmtpPort(int smtpPort) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpPort");
            query.setParameter("smtpPort", smtpPort);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findBySmtpStartTlsEnable(boolean startTls) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpStartTlsEnable");
            query.setParameter("smtpStartTlsEnable", startTls);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<EmailServer> findBySmtpAuth(boolean smtpAuth) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpAuth");
            query.setParameter("smtpAuth", smtpAuth);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByRecoveryOrder(String recoveryOrder) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryOrder");
            query.setParameter("recoveryOrder", recoveryOrder);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByRecoveryMessage(String recoveryMessage) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryMessage");
            query.setParameter("recoveryMessage", recoveryMessage);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeEmail(String email) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeEmail");
            query.setParameter("email", email);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikePassword(String password) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikePassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeSmtpHost(String smtpHost) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeSmtpHost");
            query.setParameter("smtpHost", smtpHost);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeSmtpPort(String smtpPort) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeSmtpPort");
            query.setParameter("smtpPort", smtpPort);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeRecoveryOrder(String recoveryOrder) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryOrder");
            query.setParameter("recoveryOrder", recoveryOrder);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeRecoveryMessage(String recoveryMessage) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryMessage");
            query.setParameter("recoveryMessage", recoveryMessage);
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

                Query query = this.em.createNamedQuery("EmailServer.updatePrimaryKey");
                query.setParameter("emailNew", llaveNueva);
                query.setParameter("emailOld", llaveVieja);
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
