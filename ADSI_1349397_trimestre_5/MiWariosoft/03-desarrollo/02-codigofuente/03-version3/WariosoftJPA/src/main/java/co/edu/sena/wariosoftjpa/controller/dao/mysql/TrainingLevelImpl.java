/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;


import co.edu.sena.wariosoftjpa.controller.dao.TrainingLevelDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class TrainingLevelImpl extends AbstractDAO<TrainingLevel> implements TrainingLevelDAO<TrainingLevel> {

    public TrainingLevelImpl(Class<TrainingLevel> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TrainingLevel> findByTrainingLevel(String traininglevel) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByTrainingLevel");
            query.setParameter("TrainingLevel", traininglevel);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingLevel> findByState(Boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<TrainingLevel> findByLikeTrainingLevel(String traininglevel) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingLevel.findByLikeTrainingLevel");
            query.setParameter("TrainingLevel", traininglevel);
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
            if (this.find(llaveVieja) != null) {
                Query query = this.em.createNamedQuery("TrainingLevel.updatePrimaryKey");
                query.setParameter("nivelDeFormacionNueva", llaveNueva);
                query.setParameter("nivelDeFormacionVieja", llaveVieja);
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
