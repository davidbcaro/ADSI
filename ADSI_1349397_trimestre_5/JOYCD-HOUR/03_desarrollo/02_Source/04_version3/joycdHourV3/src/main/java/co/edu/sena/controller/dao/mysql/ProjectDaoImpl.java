/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;
import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.dao.mysql.AbstractDao;
import co.edu.sena.controller.dao.mysql.AbstractDao;
import co.edu.sena.model.jpa.entities.Project;

import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ProjectDaoImpl extends AbstractDao <Project> implements ProjectDAO<Project>{
    public ProjectDaoImpl(Class<Project> entityClass) {
        super(entityClass);
    }

  
    @Override
    public List<Project> findByCodeProject(String codeProject) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByCodeProject");
            query.setParameter("codeProject",codeProject);
            return query.getResultList();   
        } catch (PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<Project> findByNameProject(String nameProject) {
        try {
         this.getEntityManager();
         Query query = this.em.createNamedQuery("Project.findByNameProject");
         query.setParameter("nameProject", nameProject);
         return query.getResultList(); 
        }catch (PersistenceException e){
            System.out.println("Exception:"+ e.getMessage());   
        }
        return null;
    }

    @Override
    public List<Project> findByStatusProject(boolean statusProject) {
       try { 
         this.getEntityManager();
         Query query = this.em.createNamedQuery("Project.findByStatusProject");
         query.setParameter("statusProject", statusProject);
         return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());   
       }
        return null;
    }

    @Override
    public List<Project> findByLikeCodeProject(String codeProject) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeCodeProject");
            query.setParameter("codeProject", codeProject);
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
            
            Query query = this.em.createNamedQuery("Project.updatePrimaryKey");
            query.setParameter("codigoNuevo", llaveNueva );
            query.setParameter("codigoAntiguo", llaveVieja );
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
    public List<Project> findByLikeNameProject(String nameProject) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeNameProject");
            query.setParameter("nameProject", nameProject);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
        }
    }
    
    
    
        
        
    
  
    


