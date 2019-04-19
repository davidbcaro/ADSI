/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.dao.StatusGroupNumberDAO;
import co.edu.sena.model.jpa.entities.Project;
import co.edu.sena.model.jpa.entities.StatusGroupNumber;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class StatusGroupNumberDAOImpl extends AbstractDao <StatusGroupNumber> implements StatusGroupNumberDAO<StatusGroupNumber>{
    public StatusGroupNumberDAOImpl (Class<StatusGroupNumber> entityClass) {
        super(entityClass); {
    
}
        
    }

    @Override
    public List<StatusGroupNumber> findByStatusName(String statusName) {
        try{
         this.getEntityManager();
         Query query = this.em.createNamedQuery("StatusGroupNumber.findByStatusName");
         query.setParameter("statusName",statusName);
         return query.getResultList();
         
        }catch (PersistenceException e ){
            System.out.println("Exception"+ e.getMessage());    
            
        
        }
        return null;
    }

    @Override
    public List<StatusGroupNumber> findByStatus(boolean status) {
        try{
         this.getEntityManager();
         Query query = this.em.createNamedQuery("StatusGroupNumber.findByStatus");
         query.setParameter("status", status);
         return query.getResultList();
         
        }catch (PersistenceException e ){
            System.out.println("Exception"+ e.getMessage());    
            
        
        }
        return null;
    }

    @Override
    public List<StatusGroupNumber> findByLikeStatusName(String statusName) {
  
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StatusGroupNumber.findByLikeStatusName");
            query.setParameter("statusName", statusName);
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
            
            Query query = this.em.createNamedQuery("StatusGroupNumber.updatePrimaryKey");
            query.setParameter("estadoNuevo", llaveNueva );
            query.setParameter("estadoAntiguo", llaveVieja );
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