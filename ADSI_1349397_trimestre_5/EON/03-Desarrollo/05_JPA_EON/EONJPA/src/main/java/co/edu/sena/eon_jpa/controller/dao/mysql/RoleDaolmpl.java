
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.RoleDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Role;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class RoleDaolmpl  extends AbstractDao<Role>implements RoleDao<Role> {

    public RoleDaolmpl(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Role> findBylikeIdRole(String idRole) {
       try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findBylikeIdRole");
            query.setParameter("idRole", idRole);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    public List<Role> findBydescription(String description) {
         try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByName");
            query.setParameter("description", description);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
      public List<Role> findByLikeDescription(String descripcion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByLikeDescription");
            query.setParameter("description", descripcion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
      }
    @Override
    public List<Role> findByStatus(boolean status) {
         try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    
    }
    
    @Override
    public List<Role> findByIdRole(String idRole) {
         try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByIdRole");
            query.setParameter("idRole", idRole);
            return query.getResultList();
        }catch(PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    
    }

    @Override
    
    public int updatePrimaryKey(String llaveNueva, String llaveVieja){
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Role.updatePrimaryKey");
            query.setParameter("idRoleNuevo", llaveNueva );
            query.setParameter("idRoleViejo", llaveVieja );
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
    public List<Role> findBylikeDescription(String description) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Role.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }


  


    
   
}
