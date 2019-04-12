/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ClientDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.ClientPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao<Client> {

    public ClientDaoImpl(Class<Client> entityClass) {
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
        return null;

    }

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
        return null;

    }

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
        return null;

    }

    @Override
    public List<Client> findByLikeFirstName(String firstName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeFirstName");
            query.setParameter("firstName", firstName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

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
        return null;

    }

    @Override
    public int updatePrimaryKey(ClientPK newPK, ClientPK oldPK) {
        try {
            this.getEntityManager();

            if (this.find(oldPK) != null) {

                Query query = this.em.createNamedQuery("Client.updatePrimarykey");
                query.setParameter("newNDocument", newPK.getDocumentNumber());
                query.setParameter("newIdDocument", newPK.getIdDocument());
                query.setParameter("oldNDocument", oldPK.getDocumentNumber());
                query.setParameter("oldIdDocument", oldPK.getIdDocument());
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
    public List<Client> findByFirstLastName(String firstLastname) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByFirstLastName");
            query.setParameter("firstLastname", firstLastname);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> findBySecondLastName(String secondLastname) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findBySecondLastName");
            query.setParameter("secondLastname", secondLastname);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Client> findByLikeFirstLastName(String firstLastname) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeFirstLastName");
            query.setParameter("firstLastname", firstLastname);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> findByLikeSecondLastName(String secondLastname) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeSecondLastName");
            query.setParameter("secondLastname", secondLastname);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Client> findBysecondName(String secondName) {
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
    public List<Client> findByLikeSecondName(String secondName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Client.findByLikeSecondName");
            query.setParameter("secondName", secondName);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

}
