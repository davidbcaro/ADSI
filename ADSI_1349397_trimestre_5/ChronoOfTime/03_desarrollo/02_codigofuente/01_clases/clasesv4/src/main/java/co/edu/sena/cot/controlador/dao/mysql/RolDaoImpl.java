/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.RolDao;
import co.edu.sena.cot.modelo.dto.Rol;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class RolDaoImpl extends AbstractDao<Rol>  implements RolDao<Rol>{

    public RolDaoImpl(Class<Rol> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Rol> findByIdRol(String idRol) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Rol.findByIdRol");
            query.setParameter("idRol", idRol);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Rol> findByDescription(String description) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Rol.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Rol> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Rol.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Rol> findByLikeIdRol(String idRol) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Rol.findByLikeIdRol");
            query.setParameter("idRol", idRol);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Rol> findByLikeDescription(String description) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Rol.findByLikeDescription");
            query.setParameter("description", description);
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
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("Rol.updatePK");
                query.setParameter("llaveVieja", llaveVieja);
                query.setParameter("llaveNueva", llaveNueva);
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
                
            }else{
                return 0;
            }
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return 0;
    }

   
}
