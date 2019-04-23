/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.DocumentDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Document;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author WINDOWS 8
 */
public class DocumentImpl extends AbstractDAO<Document> implements DocumentDAO<Document> { 

    public DocumentImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> findByIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
      
    @Override
    public List<Document> findByName(String Name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByName");
            query.setParameter("name", Name);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
      
      
     @Override
    public List<Document> findByLikeIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Document.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public int updatePk(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Document.updatePrimaryKey");
                query.setParameter("documentoNuevo", llaveNueva);
                query.setParameter("documentoViejo", llaveVieja);
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;

            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return 0;
    }
    
}
