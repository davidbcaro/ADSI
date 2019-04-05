/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EnviromentDao;
import co.edu.sena.cot.modelo.dto.Environment;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class EnviromentDaoImpl extends AbstractDao<Environment> implements EnviromentDao<Environment> {

    public EnviromentDaoImpl(Class<Environment> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Environment> findbyNumberEnviroment(int number) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByName");
            query.setParameter("number", number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findByState(boolean state) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByName");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Environment> findByDescription(String description) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByName");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environment> findbyLikeNumberEnviroment(int number) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("SELECT * FROM environment e  WHERE e.numEnvironment LIKE ? ", Environment.class);
            query.setParameter("number", number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Environment> findByLikeState(boolean state) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByLikeName");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;   
    }

    @Override
    public List<Environment> findByLikeDescription(String description) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Environment.findByLikeName");
            query.setParameter("description", description);
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
            
            Query query = this.em.createNamedQuery("Environment.updatePk");
            query.setParameter("EnvironmentNew", llaveNueva );
            query.setParameter("EnvironmentOld", llaveVieja );
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
