/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.TrimesterDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import co.edu.sena.eon_jpa.model.jpa.entities.TrimesterPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Telegrafia01
 */
public class TrimesterImpl extends AbstractDao<Trimester> implements TrimesterDao<Trimester> {

    public TrimesterImpl(Class<Trimester> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Trimester> findByQuarterName(String quarterName) {
   try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByQuarterName");
            query.setParameter("quarterName", quarterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByAcronymsWorkingDay(String acronymsWorkingDay) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Trimester> findBySpecialityName(String specialityName) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findBySpecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Trimester> findByLikeQuarterName(String quarterName) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeQuarterName");
            query.setParameter("quarterName", quarterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Trimester> findByLikeAcronymsWorkingDay(String acronymsWorkingDay) {
             try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Trimester> findByLikeSpecialityName(String specialityName) {
                try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeSpecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public int updatePrimaryKey(TrimesterPK llaveNueva, TrimesterPK llaveVieja) {
       try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

               Query query = this.em.createNamedQuery("Trimester.updatePrimaryKey");
               query.setParameter("nuevoAcronymsWorkingDay", llaveNueva.getAcronymsWorkingDay());
               query.setParameter("viejoAcronymsWorkingDay", llaveVieja.getAcronymsWorkingDay());
               query.setParameter("nuevoQuarterName", llaveNueva.getQuarterName());
               query.setParameter("viejoQuarterName", llaveVieja.getQuarterName());
               query.setParameter("nuevoSpecialityName", llaveNueva.getSpecialityName());
               query.setParameter("viejoSpecialityName", llaveVieja.getSpecialityName());
               this.em.getTransaction().begin();
               int res = query.executeUpdate();
               this.em.getTransaction().commit();
               return res;
           } else {
               return 0;
           }

        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }

        return 0;
    }
    
}
