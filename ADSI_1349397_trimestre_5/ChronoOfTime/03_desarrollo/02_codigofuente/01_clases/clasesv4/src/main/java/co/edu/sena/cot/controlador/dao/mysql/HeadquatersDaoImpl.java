/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.HeadquatersDao;
import co.edu.sena.cot.modelo.dto.Headquaters;
import co.edu.sena.cot.modelo.dto.Phase;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class HeadquatersDaoImpl extends AbstractDao<Headquaters> implements HeadquatersDao<Headquaters> {

    public HeadquatersDaoImpl(Class<Headquaters> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Headquaters> findByNameHead(String name) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findByNameHead");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Headquaters> findByDirection(String direction) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findByDirection");
            query.setParameter("direction", direction);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;      
    }

    @Override
    public List<Headquaters> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findBystate");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Headquaters> findByNumberEnviroment(int numberEnviroment) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findByNumberEnviroment");
            query.setParameter("numberEnviroment", numberEnviroment);
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
            
            if (this.find(llaveVieja)!=null) {
                Query query = this.em.createNamedQuery("Headquarters.updatePK");
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

    @Override
    public List<Headquaters> findByLikeNameHead(String name) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findByLikeNameHead");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null; 
    }

    @Override
    public List<Headquaters> findByLikeDirection(String direction) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquaters.findByLikeDirection");
            query.setParameter("direction", direction);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null; 
    }

    @Override
    public List<Headquaters> findByLikeNumberEnviroment(int numberEnviroment) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Headquaters h  WHERE h.numberEnviroment LIKE ? ", Headquaters.class);
            query.setParameter(1, numberEnviroment);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
}
