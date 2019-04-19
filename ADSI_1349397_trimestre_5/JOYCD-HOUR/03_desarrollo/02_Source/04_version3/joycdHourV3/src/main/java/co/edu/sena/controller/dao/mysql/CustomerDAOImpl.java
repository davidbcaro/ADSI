/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.CustomerDAO;
import co.edu.sena.model.jpa.entities.Customer;
import co.edu.sena.model.jpa.entities.CustomerPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Usser
 */
 public class CustomerDAOImpl extends AbstractDao<Customer> implements CustomerDAO<Customer>{
    public CustomerDAOImpl (Class<Customer> entityClass) {
        super(entityClass); 
    }

    @Override
    public List<Customer> findByDocumentType(String documentType) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByFirstName");
            query.setParameter("firstName", firstName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;  
    }

    @Override
    public List<Customer> findBySecondName(String secondName) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findBySecondName");
            query.setParameter("secondName", secondName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null; 
    }

    @Override
    public List<Customer> findByFirstLastName(String firstLastName) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByFirstLastName");
            query.setParameter("firstLastName", firstLastName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null; 
    }

    @Override
    public List<Customer> findBySecondLastName(String secondLastName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findBySecondLastName");
            query.setParameter("secondLastName", secondLastName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByIdentificationCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeDocumentType(String documentType) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeFirstName(String firstName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeFirstName");
            query.setParameter("firstName", firstName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeSecondName(String secondName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeSecondName");
            query.setParameter("secondName", secondName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeFirstLastName(String firstLastName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeFirstLastName");
            query.setParameter("firstLastName", firstLastName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeSecondLastName(String secondLastName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeSecondLastName");
            query.setParameter("secondLastName", secondLastName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Customer> findByLikeIdentificationCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Customer.findByLikeIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public int updatePrimaryKey(CustomerPK llaveNueva, CustomerPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Customer.UpdatePK");
                query.setParameter("documentoNuevo", llaveNueva.getDocumentType());
                query.setParameter("TarjetadeIdentificaciónNuevo", llaveNueva.getIdentificationCardNumber());
                query.setParameter("documentoViejo", llaveVieja.getDocumentType());
                query.setParameter ("TarjetadeIdentificaciónViejo", llaveVieja.getIdentificationCardNumber());
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
