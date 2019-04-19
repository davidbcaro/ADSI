/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.IdentificationCardDAO;
import co.edu.sena.model.jpa.entities.IdentificationCard;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class IdentificationCardDAOImpl extends AbstractDao <IdentificationCard> implements IdentificationCardDAO<IdentificationCard>{
    public IdentificationCardDAOImpl(Class<IdentificationCard> entityClass) {
        super(entityClass);
    }
    
     @Override
    public List<IdentificationCard> findByIdIdentificationCardNumber(String idIdentificationCardNumber) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("IdentificationCard.findByIdIdentificationCardNumber");
            query.setParameter("idIdentificationCardNumber", idIdentificationCardNumber);
            return query.getResultList();   
        } catch (PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<IdentificationCard> findByName (String name) {
        try {
         this.getEntityManager();
         Query query = this.em.createNamedQuery("IdentificationCard.findByName");
         query.setParameter("name", name);
          return query.getResultList();
        }catch (PersistenceException e){
            System.out.println("Exception:"+ e.getMessage());   
        }
        return null;
    }

    @Override
    public List<IdentificationCard> findByStatus(boolean status) {
       try { 
         this.getEntityManager();
         Query query = this.em.createNamedQuery("IdentificationCard.findByStatus");
         query.setParameter("status", status);
         return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());   
       }
        return null;
    }

    @Override
    public List<IdentificationCard> findByLikeIdIdentificationCardNumber(String  idIdentificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("IdentificationCard.findByLikeIdIdentificationCardNumber");
            query.setParameter("idIdentificationCardNumber",idIdentificationCardNumber);
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
            Query query = this.em.createNamedQuery("IdentificationCard.updatePrimaryKey");
            query.setParameter("ccNuevo", llaveNueva );
            query.setParameter("ccAntiguo", llaveVieja );
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
    public List<IdentificationCard> findByLikeName(String name) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("IdentificationCard.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
        }
    }

