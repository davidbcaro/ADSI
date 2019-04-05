/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LinkUpDao;
import co.edu.sena.cot.modelo.dto.Headquaters;
import co.edu.sena.cot.modelo.dto.LinkUp;
import co.edu.sena.cot.modelo.dto.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class LinkUpDaoImpl extends AbstractDao<LinkUp> implements LinkUpDao<LinkUp> {

    public LinkUpDaoImpl(Class<LinkUp> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LinkUp> findByTypeLink(String type) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LinkUp.findByTypeLink");
            query.setParameter("typeLink", type);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LinkUp> findByHours(int hours) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LinkUp.findByHours");
            query.setParameter("hours", hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LinkUp> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LinkUp.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LinkUp> findByLikeTypeLink(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LinkUp.findByLikeTypeLink");
            query.setParameter("typeLink", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null; 
    }

    @Override
    public List<LinkUp> findByLikeHours(String hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM linkUp l  WHERE l.hours LIKE ? ", LinkUp.class);
            query.setParameter(1, hours);
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
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("LinkUp.updatePK");
            query.setParameter("LinkUpNew", llaveNueva );
            query.setParameter("LinkUpOld", llaveVieja );
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
