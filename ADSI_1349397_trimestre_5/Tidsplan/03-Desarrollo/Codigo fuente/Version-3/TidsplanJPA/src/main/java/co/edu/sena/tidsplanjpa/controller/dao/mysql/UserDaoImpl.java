/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.UserDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.User;
import co.edu.sena.tidsplanjpa.model.jpa.entities.UserPK;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDao<User> {

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> findByMail(String mail) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("User.findByMail");
            que.setParameter("mail", mail);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeMail(String mail) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("User.findByLikeMail");
            que.setParameter("mail", mail);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByPassword(String password) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("User.findByPassword");
            que.setParameter("password", password);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikePassword(String password) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("User.findByLikePassword");
            que.setParameter("password", password);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByEndDate(Date endDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByDocumentNumber(String documentNumber) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(UserPK newKey, UserPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Customer.updatePrimaryKey");
                query.setParameter("newDocument", newKey.getDocument());
                query.setParameter("newDocumentNumber", newKey.getDocumentNumber());
                query.setParameter("oldDocument", oldKey.getDocument());
                query.setParameter("oldDocumentNumber", oldKey.getDocumentNumber());
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
    public List<User> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
