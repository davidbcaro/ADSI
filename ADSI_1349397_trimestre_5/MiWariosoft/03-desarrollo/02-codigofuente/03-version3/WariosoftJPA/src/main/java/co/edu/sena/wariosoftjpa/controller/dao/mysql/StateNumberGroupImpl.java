/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.StateNumberGroupDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class StateNumberGroupImpl extends AbstractDAO<StateNumberGroup> implements StateNumberGroupDAO<StateNumberGroup>{
     
    public StateNumberGroupImpl(Class  entityClass) {
        super(entityClass);
    }

    @Override
    public List<StateNumberGroup> findByNameState(String nameState) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateNumberGroup.findByNameState");
            query.setParameter("NameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    
     @Override
    public List<StateNumberGroup> findByLikeNameState(String nameState) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateNumberGroup.findByLikeNameState");
            query.setParameter("NameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;    }
    

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
    public int updatePk(String llaveNueva, String llaveVieja) {
    try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("StateNumberGroup.updatePk");
            query.setParameter("documentoNuevo", llaveNueva );
            query.setParameter("documentoViejo", llaveVieja );
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
