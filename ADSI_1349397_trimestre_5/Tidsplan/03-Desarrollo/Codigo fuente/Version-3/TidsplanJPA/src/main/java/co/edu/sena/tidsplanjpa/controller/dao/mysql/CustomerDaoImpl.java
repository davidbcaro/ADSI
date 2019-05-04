/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.CustomerDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Customer;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao<Customer> {

    public CustomerDaoImpl(Class<Customer> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Customer> findByDocumentNumber(String documentNumber) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByLikeDocumentNumber(String documentNumber) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }


   
       @Override
    public int updatePrimaryKey(CustomerPK newKey, CustomerPK oldKey) {
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
    public List<Customer> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByDocument(String document) {
                try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByLikeDocument(String document) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
 try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findByFirstName");
            que.setParameter("firstName", firstName);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Customer> findByLikeFirstName(String firstName) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findByLikeFirstName");
            que.setParameter("firstName", firstName);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findBySecondName(String secondName) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findBySecondName");
            que.setParameter("secondName", secondName);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByLikeSecondName(String secondName) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findByLikeSecondName");
            que.setParameter("secondName", secondName);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Customer> findBySurname(String surname) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findBySurname");
            que.setParameter("surname", surname);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByLikeSurname(String surname) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findByLikeSurname");
            que.setParameter("surname", surname);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Customer> findBySecondSurname(String secondSurname) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findBySecondSurname");
            que.setParameter("secondSurname", secondSurname);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> findByLikeSecondSurname(String secondSurname) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Customer.findByLikeSecondSurname");
            que.setParameter("secondSurname", secondSurname);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    }

 
}
