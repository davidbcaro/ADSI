/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.ClientDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Client;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ClientPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author WINDOWS 8
 */
public class ClientImpl extends AbstractDAO<Client> implements ClientDAO<Client> {

    public ClientImpl(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Client> findByDocumentNumber(String documentNumber) {

 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> findByFirstName(String firstName) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByFirstName");
            query.setParameter("firstName", firstName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    }

    @Override
    public List<Client> findBySecondName(String secondName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findBySecondName");
            query.setParameter("secondName", secondName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> findByFirstLastName(String firstLastName) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByFirstLastName");
            query.setParameter("firstLastName", firstLastName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    }

    @Override
    public List<Client> findBySecondLastName(String secondLastName) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findBySecondLastName");
            query.setParameter("secondLastName", secondLastName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;      }

    @Override
    public List<Client> findByIdDocument(String idDocument) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;        }

    @Override
    public List<Client> findByLikeDocumentNumber(String documentNumber) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;          }

   

    @Override
    public List<Client> findByLikeIdDocument(String idDocument) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;         }

    @Override
    public int updatePk(ClientPK llaveNueva, ClientPK llaveVieja) {
  try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Client.updatePk");
            query.setParameter("documentoNuevo", llaveNueva.getDocumentNumber());
            query.setParameter("idNuevo", llaveNueva.getIdDocument());
            query.setParameter("documentoViejo", llaveVieja.getDocumentNumber());
            query.setParameter("idViejo", llaveVieja.getIdDocument());
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
        return 0;    }

    

 

   
 
    
}
