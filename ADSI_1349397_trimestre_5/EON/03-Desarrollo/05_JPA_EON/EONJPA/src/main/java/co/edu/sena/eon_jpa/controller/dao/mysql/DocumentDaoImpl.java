/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.DocumentDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Document;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DocumentDaoImpl  extends AbstractDao<Document>implements DocumentDao<Document> {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> findBylikeidDocument(String idDocument) {
     try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findBylikeidDocument");
            query.setParameter("idDocument",idDocument );
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Document> findBylikename(String name) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikename");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
      
    }

    @Override
    public List<Document> findBystatus(boolean status) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findBystatus");
            query.setParameter("status", status);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    
    }

    @Override
    public List<Document> findByidDocument(String idDocument) {
         try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByidDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    
        
    }

    @Override
    public List<Document> findByname(String name) {
        
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByname");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
         try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Document.updatePrimaryKey");
            query.setParameter("idDocumentNuevo", llaveNueva );
            query.setParameter("idDocumentViejo", llaveVieja );
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
