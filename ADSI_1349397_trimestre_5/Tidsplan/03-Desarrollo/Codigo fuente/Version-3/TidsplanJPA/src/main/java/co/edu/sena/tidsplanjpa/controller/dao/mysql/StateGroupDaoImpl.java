/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.StateGroupDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.StateGroup;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class StateGroupDaoImpl extends AbstractDao<StateGroup> implements StateGroupDao<StateGroup> {

    public StateGroupDaoImpl(Class<StateGroup> entityClass) {
        super(entityClass);

    }

    @Override
    public List<StateGroup> findByLikeNameState(String nameState) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateGroup.findByLikeNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<StateGroup> findByNameState(String nameState) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateGroup.findByNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<StateGroup> findByStatus(boolean status) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateGroup.findByStatus");
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
            
            Query query = this.em.createNamedQuery("StateGroup.updatePrimaryKey");
            query.setParameter("nsNew", newKey );
            query.setParameter("nsOld", oldKey );
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
    public List<StateGroup> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StateGroup.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

}
