/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EmailServerDao;
import co.edu.sena.cot.modelo.dto.EmailServer;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
public class EmailServerImpl extends AbstractDao<EmailServer> implements EmailServerDao<EmailServer> {

    public EmailServerImpl(Class<EmailServer> entityClass) {
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
            System.out.println("Exeption " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByPasswordSecurity(String passSec) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByPasswordSecurity");
            query.setParameter("passwordSecurity", passSec);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findBySmtpHost(String host) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpHost");
            query.setParameter("smtpHost", host);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findBySmtpPort(String port) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findBySmtpPort");
            query.setParameter("smtpPort", port);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByRecoveryOrder(String recoOr) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryOrder");
            query.setParameter("recoveryOrder", recoOr);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByRecoveryMessage(String recoMe) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByRecoveryMessage");
            query.setParameter("recoveryMessage", recoMe);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exeption "+e.getMessage());
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
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikePasswordSecurity(String passSec) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikePasswordSecurity");
            query.setParameter("passwordSecurity", passSec);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeSmtpHost(String host) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeSmtpHost");
            query.setParameter("smtpHost", host);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeSmtpPort(String port) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeSmtpPort");
            query.setParameter("smtpPort", port);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeRecoveryOrder(String recoOr) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeRecoveryOrder");
            query.setParameter("recoveryOrder", recoOr);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmailServer> findByLikeRecoveryMessage(String recoMe) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmailServer.findByLikeRecoveryMessage");
            query.setParameter("recoveryMessage", recoMe);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+ e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("EmailServer.updatePK");
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
