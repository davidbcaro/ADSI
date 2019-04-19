/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.UserDAO;
import co.edu.sena.model.jpa.entities.User;
import co.edu.sena.model.jpa.entities.UserPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class UserDAOImpl extends AbstractDao<User> implements UserDAO<User> {

    public UserDAOImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> findByEmail(String email) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByEmail");
            query.setParameter("email", email);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByPassword(String password) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByPassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByDocumenType(String documentType) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByIdentificactionCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByLikeEmail(String email) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeEmail");
            query.setParameter("email", email);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikePassword(String password) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikePassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findByLikeDocumenType(String documentType) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<User> findByLikeIdentificactionCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(UserPK llaveNueva, UserPK llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("User.updatePrimaryKey");
            query.setParameter("documentTypeNew", llaveNueva.getDocumentType() );
            query.setParameter("identificationCardNumberNew", llaveNueva.getIdentificationCardNumber());
            query.setParameter("documentTypeOld", llaveVieja.getDocumentType());
            query.setParameter("identificationCardNumberOld", llaveVieja.getIdentificationCardNumber());
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
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
