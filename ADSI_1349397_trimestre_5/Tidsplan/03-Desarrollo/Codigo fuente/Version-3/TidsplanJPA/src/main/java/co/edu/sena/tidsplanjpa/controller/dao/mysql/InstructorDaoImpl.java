/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.InstructorDao;
import static co.edu.sena.tidsplanjpa.model.jpa.entities.Customer_.instructor;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Instructor;
import co.edu.sena.tidsplanjpa.model.jpa.entities.InstructorPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;



/**
 *
 * @author MIHOGAR
 */
public class InstructorDaoImpl extends AbstractDao<Instructor> implements InstructorDao<Instructor>{

    public InstructorDaoImpl(Class<Instructor> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Instructor> findByTypeEmploymentRelationship(String typeEmploymentRelationship) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByTypeEmploymentRelationship");
            query.setParameter("typeEmploymentRelationship", typeEmploymentRelationship);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Instructor> findByLikeTypeEmploymentRelationship(String typeEmploymentRelationship) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeTypeEmploymentRelationship");
            query.setParameter("typeEmploymentRelationship", typeEmploymentRelationship);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Instructor> findByNameSpeciality(String nameSpeciality) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByNameSpeciality");
            query.setParameter("nameSpeciality", nameSpeciality);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<Instructor> findByLikeNameSpeciality(String nameSpeciality) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByLikeNameSpeciality");
            query.setParameter("nameSpeciality", nameSpeciality);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<Instructor> findByDocumentNumber(String documentNumber) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();

        } catch (Exception e) {
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
        } catch (Exception e) {
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

        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(InstructorPK newKey, InstructorPK oldKey) {
 try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Instructor.updatePrimaryKey");
                query.setParameter("newDocumentNumber", newKey.getDocumentNumber());
                query.setParameter("newDocument", newKey.getDocument());
                query.setParameter("oldDocumentNumber", oldKey.getDocumentNumber());
                query.setParameter("oldDocument", oldKey.getDocument());
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
        return 0;    }

    @Override
    public List<Instructor> findAll() {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Instructor.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }
    
   
    

    
}
