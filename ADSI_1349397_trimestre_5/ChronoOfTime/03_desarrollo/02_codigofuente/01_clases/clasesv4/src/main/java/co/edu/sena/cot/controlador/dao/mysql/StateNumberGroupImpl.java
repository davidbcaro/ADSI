/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.StateNumberGroupDao;
import co.edu.sena.cot.modelo.dto.StateNumberGroup;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class StateNumberGroupImpl extends AbstractDao<StateNumberGroup> implements StateNumberGroupDao<StateNumberGroup>{
    
    public StateNumberGroupImpl(Class<StateNumberGroup> entityClass) {
        super(entityClass);
    }

    @Override
    public List<StateNumberGroup> findByState(boolean state) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateNumberGroup.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePrimaryKey(boolean llaveNueva, boolean llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("StateNumberGroup.updatePk");
            query.setParameter("GroupNew", llaveNueva );
            query.setParameter("GroupOld", llaveVieja );
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
