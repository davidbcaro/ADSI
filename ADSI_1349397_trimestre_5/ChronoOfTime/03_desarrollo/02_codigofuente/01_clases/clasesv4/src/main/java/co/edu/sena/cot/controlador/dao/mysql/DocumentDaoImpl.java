/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.DocumentDao;
import co.edu.sena.cot.modelo.dto.Document;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class DocumentDaoImpl extends AbstractDao<Document> implements DocumentDao<Document> {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> findByDocument(String document) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Document> findByName(String name) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Document> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Document> findByLikeDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Document> findByLikeName(String name) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public int updatePK(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("Document.updatePK");
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
