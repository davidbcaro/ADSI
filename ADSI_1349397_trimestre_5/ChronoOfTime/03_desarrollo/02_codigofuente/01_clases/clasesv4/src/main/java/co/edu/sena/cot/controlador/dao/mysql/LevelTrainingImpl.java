/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LevelTrainingDao;
import co.edu.sena.cot.modelo.dto.LevelTrainig;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LevelTrainingImpl extends AbstractDao<LevelTrainig> implements LevelTrainingDao<LevelTrainig>{

    public LevelTrainingImpl(Class<LevelTrainig> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LevelTrainig> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LevelTrainig.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LevelTrainig> findByLikeCode(String code) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LevelTrainig.findByLikePK");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("LevelTrainig.updatePK");
            query.setParameter("llaveNueva", llaveNueva );
            query.setParameter("llaveVieja", llaveVieja );
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
