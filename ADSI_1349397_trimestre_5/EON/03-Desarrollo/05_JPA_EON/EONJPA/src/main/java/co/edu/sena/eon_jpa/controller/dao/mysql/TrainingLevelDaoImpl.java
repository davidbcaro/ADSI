/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.TrainingLevelDao;
import co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class TrainingLevelDaoImpl extends AbstractDao<TrainingLevel> implements TrainingLevelDao<TrainingLevel>{
    public TrainingLevelDaoImpl(Class entityClass) {
        super(entityClass);
    }
    
    public List<TrainingLevel> findByTrainingLevel(String training_Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByTrainingLevel");
            query.setParameter("trainingLevel", training_Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<TrainingLevel> findByState(boolean State) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByState");
            query.setParameter("State", State);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<TrainingLevel> findByLikeTrainingLevel(String training_Level) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByLikeTrainingLevel");
            query.setParameter("trainingLevel", training_Level);
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
            
            Query query = this.em.createNamedQuery("TrainingLevel.updatePrimaryKey");
            query.setParameter("TrainingLevelNuevo", llaveNueva );
            query.setParameter("TrainingLevelViejo", llaveVieja );
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
