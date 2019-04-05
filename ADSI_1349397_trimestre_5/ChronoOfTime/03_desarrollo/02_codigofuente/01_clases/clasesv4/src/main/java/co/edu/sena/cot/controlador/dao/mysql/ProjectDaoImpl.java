/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ProjectDao;
import co.edu.sena.cot.modelo.dto.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao<Project> {
    
    public ProjectDaoImpl(Class entityClass){
        super (entityClass);
    } 

    @Override
    public List<Project> findByName(String name) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Project> findByState(boolean state) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    
    @Override
    public List<Project> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Project p WHERE p.code LIKE ? ");
            query.setParameter(1, code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePrimaryKey(Integer llaveNueva, Integer llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Project.updatePk");
            query.setParameter("ProjectNew", llaveNueva );
            query.setParameter("ProjectOld", llaveVieja );
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
    public List<Project> findByCode(int code) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Project> findByLikeName(String name) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    
}
