/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.DisponibilityDao;
import co.edu.sena.cot.modelo.dto.Disponibility;
import co.edu.sena.cot.modelo.dto.DisponibilityPK;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class DisponiblityDaoImpl extends AbstractDao <Disponibility> implements DisponibilityDao <Disponibility>{

    public DisponiblityDaoImpl(Class<Disponibility> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Disponibility> findByStartDate(Date start) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByStartDate");
            query.setParameter("startDate", start);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByEndDate(Date end) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByEndDate");
            query.setParameter("endDate", end);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByNumberDocument(int number) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByNumberDocument");
            query.setParameter("numberDocument",number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<Disponibility> findByDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByWorkDInitiasl(String initials) {
     try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByWorkInitials");
            query.setParameter("workInitials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Disponibility> findByNameDayi(String name) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByNameDayi");
            query.setParameter("nameDayi", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

  

    @Override
    public List<Disponibility> findByLikeNumberDocument(String number) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.disponibility d WHERE number_document LIKE ?;", Disponibility.class);
            query.setParameter(1, number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Disponibility> findByLikeDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Disponibility> findByLikeWorkDInitiasl(String initials) {
     try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibilityt.findByLikeWorkDInitiasl");
            query.setParameter("workInitials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<Disponibility> findByLikeNameDayi(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeNameDayi");
            query.setParameter("nameDayi", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public int updatePK(DisponibilityPK llaveNueva, DisponibilityPK llaveVieja) {
       try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Disponibility.updatePK");
                query.setParameter("DocumentNew", llaveNueva.getDocument());
                query.setParameter("NameDayiNew", llaveNueva.getNameDayi());
                query.setParameter("NumberDocumentNew", llaveNueva.getNumberDocument());
                query.setParameter("StartDateNew", llaveNueva.getStartDate());
                query.setParameter("WorkInitialsNew", llaveNueva.getWorkInitials());
               
                
                query.setParameter("DocumentOld", llaveVieja.getDocument());
                query.setParameter("NameDayiOld", llaveVieja.getNameDayi());
                query.setParameter("NumberDocumentOld", llaveVieja.getNumberDocument());
                query.setParameter("StartDateOld", llaveVieja.getStartDate());
                query.setParameter("WorkInitialsOld", llaveVieja.getWorkInitials());
                
              
                
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
