/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.InstructorDao;
import co.edu.sena.cot.modelo.dto.Instructor;
import co.edu.sena.cot.modelo.dto.InstructorPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class InstructorDaoImpl extends AbstractDao<Instructor> implements InstructorDao<Instructor> {

    public InstructorDaoImpl(Class<Instructor> entityClass) {
        super(entityClass);
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
    public List<Instructor> findByTypeLink(String typeLink) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByTypeLink");
            query.setParameter("typeLink", typeLink);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Instructor> findByNumberDocument(int number) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByNumberDocument");
            query.setParameter("numberDocument", number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Instructor> findByDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByDocument");
            query.setParameter("document", document);
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
    public List<Instructor> findByLikeTypeLink(String typeLink) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeTypeLink");
            query.setParameter("typeLink", typeLink);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null; 
    }

    @Override
    public List<Instructor> findByLikeNumberDocument(String number) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.instructor i WHERE number_document LIKE ?;", Instructor.class);
            query.setParameter(1, number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Instructor> findByLikeDocument(String document) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;  
    }

    @Override
    public int updatePrimaryKey(InstructorPK llaveNueva, InstructorPK llaveVieja) {
        try {
            this.getEntityManager();
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("Instructor.updatePK");
                query.setParameter("DocumentNew", llaveNueva.getDocument());
                query.setParameter("NumberDocumentNew", llaveNueva.getNumberDocument());
                
                query.setParameter("DocumentOld", llaveVieja.getDocument());
                query.setParameter("NumberDocumentOld", llaveVieja.getNumberDocument());
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
