/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.model.jpa.entities.Role;
import co.edu.sena.controller.dao.RoleDAO;
import co.edu.sena.controller.dao.mysql.AbstractDao;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Usser
 */
public class RoleDAOImpl extends AbstractDao <Role> implements RoleDAO<Role>{
    public RoleDAOImpl(Class<Role> entityClass) {
        super(entityClass);
    }

     @Override
    public List<Role> findByIdRole(String IdRole) {
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByIdRole");
            query.setParameter("idRole",IdRole);
            return query.getResultList();   
        } catch (PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<Role> findByDescription(String description) {
        try {
         this.getEntityManager();
         Query query = this.em.createNamedQuery("Role.findByDescription");
         query.setParameter("description", description);
          return query.getResultList();
        }catch (PersistenceException e){
            System.out.println("Exception:"+ e.getMessage());   
        }
        return null;
    }

    @Override
    public List<Role> findByStatus(boolean status) {
       try { 
         this.getEntityManager();
         Query query = this.em.createNamedQuery("Role.findByStatus");
         query.setParameter("status", status);
         return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());   
       }
        return null;
    }

    @Override
    public List<Role> findByLikeIdRole(String IdRole) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByLikeIdRole");
            query.setParameter("idRole", IdRole);
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
            
            Query query = this.em.createNamedQuery("Role.updatePrimaryKey");
            query.setParameter("administradorNuevo", llaveNueva );
            query.setParameter("administradorAntiguo", llaveVieja );
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
    public List<Role> findByLikeDescription(String Description) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByLikeDescription");
            query.setParameter("description", Description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
        }
    }
   
    

  

    

