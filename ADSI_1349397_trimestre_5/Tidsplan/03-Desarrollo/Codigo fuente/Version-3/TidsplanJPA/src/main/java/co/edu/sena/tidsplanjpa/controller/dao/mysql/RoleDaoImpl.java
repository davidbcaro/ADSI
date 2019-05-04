/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.RoleDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Role;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao<Role> {

    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Role> findByIdRol(String idRol) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Role.findByIdRol");
            que.setParameter("idRol", idRol);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Role> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Role.findByDescription");
            que.setParameter("description", description);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Role> findByLikeIdRol(String idRol) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Role.findByLikeIdRol");
            que.setParameter("idRol", idRol);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Role> findByLikeDescription(String description) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Role.findByLikeDescription");
            que.setParameter("description", description);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
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
            
            Query query = this.em.createNamedQuery("Role.updatePrimaryKey");
            query.setParameter("newRol", newKey );
            query.setParameter("oldRol", oldKey );
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
    public List<Role> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

}
