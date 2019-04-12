/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;


import co.edu.sena.eon_jpa.controller.dao.InstructorDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.AbstractDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.InstructorPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;



public class InstructorDaoImpl  extends AbstractDao<Instructor> implements InstructorDao<Instructor> {

    public InstructorDaoImpl(Class<Instructor> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Instructor> findByDocumentNumber(String documentNumber) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;

    }

    @Override
    public List<Instructor> findByIdDocument(String idDocument) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;

    }

    @Override
    public List<Instructor> findBySpecialityName(String specialityName) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findBySpecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;

    }

    @Override
    public List<Instructor> findByTypeLinkage(String typeLinkage) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByTypeLinkage");
            query.setParameter("typeLinkage", typeLinkage);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;

    }

    @Override
    public List<Instructor> findByLikeDocumentNumber(String documentNumber) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;  
    }
    
    @Override
    public List<Instructor> findByLikeIdDocument(String idDocument) {
     try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;  
    }

    @Override
    public List<Instructor> findByLikeSpecialityName(String specialityName) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeSpecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;  
    }

    @Override
    
    public List<Instructor> findByLikeTypeLinkage(String typeLinkage) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeTypeLinkage");
            query.setParameter("typeLinkage", typeLinkage);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int UpdatePrimaryKey(InstructorPK newKey, InstructorPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {
                Query query = this.em.createNamedQuery("Instructor.UpdatePrimaryKey");
                query.setParameter("newidDocument", newKey.getIdDocument());
                query.setParameter("oldidDocument", oldKey.getIdDocument());
                query.setParameter("newdocumentNumber", newKey.getDocumentNumber());
                query.setParameter("olddocumentNumber", oldKey.getDocumentNumber());

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