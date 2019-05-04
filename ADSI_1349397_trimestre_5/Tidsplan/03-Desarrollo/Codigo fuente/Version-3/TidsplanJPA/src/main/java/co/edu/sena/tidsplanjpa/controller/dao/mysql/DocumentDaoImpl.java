/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DocumentDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Document;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class DocumentDaoImpl extends AbstractDao<Document> implements DocumentDao<Document> {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> findByIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Document.findByIdDocument");
            que.setParameter("idDocument", idDocument);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Document> findByTypeDocument(String typeDocument) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Document.findByTypeDocument");
            que.setParameter("typeDocument", typeDocument);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Document> findByLikeIdDocument(String idDocument){
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Document> findByLikeTypeDocument(String typeDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikeTypeDocument");
            query.setParameter("typeDocument", typeDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
         try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("Document.updatePrimaryKey");
            query.setParameter("newKey", newKey);
            query.setParameter("oldKey", oldKey);
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

    @Override
    public List<Document> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Document> findByStatus(boolean status) {
            try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

}
