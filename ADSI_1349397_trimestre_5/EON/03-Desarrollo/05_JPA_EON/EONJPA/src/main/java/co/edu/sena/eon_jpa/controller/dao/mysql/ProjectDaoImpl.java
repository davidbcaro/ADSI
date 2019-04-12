/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ProjectDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao<Project> {

    public ProjectDaoImpl(Class entityClass) {
        super(entityClass);
    }

    @Override
    public List<Project> findByCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Project> findByName(String Name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByName");
            query.setParameter("Name", Name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Project> findByState(boolean State) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByState");
            query.setParameter("State", State);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Project> findByLikeCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    
    @Override
    public List<Project> findByLikeName(String Name){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeName");
            query.setParameter("Name", Name);
            return query.getResultList();
        }catch (PersistenceException e){
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
     public int updatePrimaryKey(String llaveNueva, String llaveVieja){
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Project.updatePrimaryKey");
            query.setParameter("CodeNuevo", llaveNueva );
            query.setParameter("CodeViejo", llaveVieja );
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

