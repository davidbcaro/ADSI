/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ProjectDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao<Project> {

    public ProjectDaoImpl(Class<Project> entityClass) {
        super(entityClass);

    }

    @Override
    public List<Project> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Project> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeCode");
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





    @Override
        public List<Project> findByStatus(boolean status) {
            try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
        public int updatePrimaryKey(String newKey, String oldKey) {
            try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("Project.updatePrimaryKey");
            query.setParameter("codeNew", newKey );
            query.setParameter("codeOld", oldKey );
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
    public List<Project> findByCode(String code) {
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
}
    
            
    
