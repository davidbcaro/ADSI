/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.MailServerDao;
import co.edu.sena.eon_jpa.model.jpa.entities.MailServer;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class MailServerDaoImpl extends AbstractDao<MailServer> implements MailServerDao<MailServer> {

    public MailServerDaoImpl(Class<MailServer> entityClass) {
        super(entityClass);
    }

    @Override
    public List<MailServer> findByMail(int Mail) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByMail");
            query.setParameter("Mail", Mail);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByPassword(String Password) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByPassword");
            query.setParameter("Password", Password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findBySmtpHost(String SmtpHost) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findBySmtpHost");
            query.setParameter("SmtpHost", SmtpHost);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findBySmtpPort(int SmtpPort) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findBySmtpPort");
            query.setParameter("SmtpPort", SmtpPort);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findBySmtpStartTlsEnable(boolean SmtpStartTlsEnable) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findBySmtpStartTlsEnable");
            query.setParameter("SmtpStartTlsEnable", SmtpStartTlsEnable);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findBySmtpAuth(boolean SmtpAuth) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findBySmtpAuth");
            query.setParameter("SmtpAuth", SmtpAuth);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByRecoveryCase(String recoveryCase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByRecoveryCase");
            query.setParameter("recoveryCase", recoveryCase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByMessageRecovery(String messageRecovery) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByMessageRecovery");
            query.setParameter("messageRecovery", messageRecovery);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikePassword(String Password) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikePassword");
            query.setParameter("Password", Password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeSmtpHost(String SmtpHost) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeSmtpHost");
            query.setParameter("SmtpHost", SmtpHost);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeSmtpPort(int SmtpPort) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeSmtpPort");
            query.setParameter("SmtpPort", SmtpPort);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeSmtpStartTlsEnable(boolean SmtpStartTlsEnable) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeSmtpStartTlsEnable");
            query.setParameter("SmtpStartTlsEnable", SmtpStartTlsEnable);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeSmtpAuth(boolean SmtpAuth) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeSmtpAuth");
            query.setParameter("SmtpAuth", SmtpAuth);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeRecoveryCase(String recoveryCase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeRecoveryCase");
            query.setParameter("recoveryCase", recoveryCase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<MailServer> findByLikeMessageRecovery(String messageRecovery) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("MailServer.findByLikeMessageRecovery");
            query.setParameter("messageRecovery", messageRecovery);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(int llaveNueva, int llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("MailServer.updatePrimaryKey");
                query.setParameter("mailNuevo", llaveNueva);
                query.setParameter("mailViejo", llaveVieja);
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
