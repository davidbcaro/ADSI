/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.CustomerHasRoleDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRole;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRolePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class CustomerHasRoleDaoImpl extends AbstractDao<CustomerHasRole> implements CustomerHasRoleDao<CustomerHasRole> {

    public CustomerHasRoleDaoImpl(Class<CustomerHasRole> entityClass) {
        super(entityClass);
    }

   
    @Override
    public List<CustomerHasRole> findByDocumentNumber(String documentNumber) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<CustomerHasRole> findByLikeDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<CustomerHasRole> findByDocument(String document) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<CustomerHasRole> findByLikeDocument(String document) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<CustomerHasRole> findByIdRol(String idRol) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByIdRol");
            query.setParameter("idRol", idRol);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<CustomerHasRole> findByLikeIdRol(String idRol) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByLikeIdRol");
            query.setParameter("idRol", idRol);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     }

    @Override
    public int updatePrimaryKey(CustomerHasRolePK newKey, CustomerHasRolePK oldKey) {
try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("CustomerHasRole.updatePrimaryKey");
                query.setParameter("newDocument", newKey.getDocument());
                query.setParameter("newDocumentNumber", newKey.getDocumentNumber());
                query.setParameter("newIdRol", newKey.getIdrol());
                query.setParameter("oldDocument", oldKey.getDocument());
                query.setParameter("oldDocumentNumber", oldKey.getDocumentNumber());
                query.setParameter("oldIdRol", oldKey.getIdrol());
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
    public List<CustomerHasRole> findAll() {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<CustomerHasRole> findByStatus(boolean status) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CustomerHasRole.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }
    
}
