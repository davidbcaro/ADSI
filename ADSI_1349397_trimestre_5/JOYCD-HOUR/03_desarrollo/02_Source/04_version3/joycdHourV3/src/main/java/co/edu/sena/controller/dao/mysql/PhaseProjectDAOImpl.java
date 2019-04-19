/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.PhaseProjectDAO;
import co.edu.sena.model.jpa.entities.PhaseProject;
import co.edu.sena.model.jpa.entities.PhaseProjectPK;
import co.edu.sena.model.jpa.entities.StatusGroupNumber;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class PhaseProjectDAOImpl extends AbstractDao<PhaseProject> implements PhaseProjectDAO<PhaseProject>{
    public PhaseProjectDAOImpl (Class<PhaseProject> entityClass) {
        super(entityClass); 
        
    }

    @Override
    public List<PhaseProject> findByNamePhase(String namePhase) {
       try{
        this.getEntityManager();
        Query query = this.em.createNamedQuery("PhaseProject.findByNamePhase");
        query.setParameter("namePhase",namePhase );
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception:"+ e.getMessage());
           
       }
       return null;
    }

    @Override
    public List<PhaseProject> findByStatusPhase(String statusPhase) {
           try {
              this.getEntityManager();
              Query query = this.em.createNamedQuery("PhaseProject.findByStatusPhase");
              query.setParameter("statusPhase",statusPhase );
              return query.getResultList();
             }catch (PersistenceException e){
               System.out.println("Exception"+ e.getMessage());   
           }
           return null;
           }

    @Override
    public List<PhaseProject> findByProjectCode(String projectCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("PhaseProject.findByProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception" + e.getMessage());
        }
        return null;
    }
    @Override
    public List<PhaseProject> findByLikeNamePhase(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("PhaseProject.findByLikeNamePhase");
            query.setParameter ("namePhase", namePhase);
            return query.getResultList();
            
        }catch (PersistenceException e){
            System.out.println("Exception"+ e.getMessage());
            
        }
        return null;
    }

    @Override
    public List<PhaseProject> findByLikeStatusPhase(String statusPhase) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("PhaseProject.findByLikeStatusPhase");
            query.setParameter ("statusPhase", statusPhase);
            return query.getResultList();
            
        }catch (PersistenceException e){
            System.out.println("Exception"+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<PhaseProject> findByLikeProjectCode(String projectCode) {
        try{
         this.getEntityManager();
         Query query = this.em.createNamedQuery("PhaseProject.findByLikeProjectCode");
         query.setParameter("projectCode", projectCode);
         return query.getResultList();
        }catch (PersistenceException e){
            System.out.println("Exception"+ e.getMessage());
            
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(PhaseProjectPK llaveNueva, PhaseProjectPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("PhaseProject.UpdatePK");
                query.setParameter("nombreFaseNuevo", llaveNueva.getNamePhase());
                query.setParameter("codigoProjectNuevo", llaveNueva.getProjectCode());
                query.setParameter("viejoNombreFase", llaveVieja.getNamePhase());
                query.setParameter ("viejoCodigoProyecto", llaveVieja.getProjectCode());
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
    
    
    
    
    
    
    
    
    
    

