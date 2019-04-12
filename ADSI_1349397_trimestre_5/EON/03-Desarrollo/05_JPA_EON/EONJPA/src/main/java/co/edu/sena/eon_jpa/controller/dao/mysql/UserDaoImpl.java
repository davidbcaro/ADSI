/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.UserDao;
import co.edu.sena.eon_jpa.model.jpa.entities.User;
import co.edu.sena.eon_jpa.model.jpa.entities.UserPK;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class UserDaoImpl extends AbstractDao<User> implements UserDao<User> {
    
    public UserDaoImpl(Class entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> findByMail(String mail) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByMail");
            query.setParameter("mail", mail);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByPassWord(String password) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByPassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByDocumentNumber(String documentNumber) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByIdDocument(String idDocument) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByDateEndind(Date dateEndind) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDateEndind");
            query.setParameter("dateEndind", dateEndind);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeDateEndind(Date dateEndind) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDateEndind");
            query.setParameter("dateEndind", dateEndind);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeMail(String mail) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeMail");
            query.setParameter("mail", mail);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByLikePassWord(String password) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikePassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public int updatePrimaryKey(UserPK newKey, UserPK oldKey) {
         try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("User.updatePrimaryKey");
            query.setParameter("newNDocument", newKey.getDocumentNumber());
            query.setParameter("newIdDocument", newKey.getIdDocument());
            query.setParameter("oldNDocument", oldKey.getDocumentNumber());
            query.setParameter("oldIdDocument", oldKey.getIdDocument());
            this.em.getTransaction().begin();
            int res = query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return 0;
    }
    }

