/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.RoleDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Role;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Brayan
 */
public class RoleImpl extends AbstractDAO<Role> implements RoleDAO<Role>{

    public RoleImpl(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Role> findByIdRole(String idRole) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByIdRole");
            query.setParameter("idRole", idRole);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Role> findByDescriptionRole(String descriptionRole) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByDescriptionRole");
            query.setParameter("descriptionRole", descriptionRole);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Role> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Role> findByLikeIdRole(String idRole) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByLikeIdRole");
            query.setParameter("idRole", idRole);
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
            
            Query query = this.em.createNamedQuery("Role.updatePk");
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
