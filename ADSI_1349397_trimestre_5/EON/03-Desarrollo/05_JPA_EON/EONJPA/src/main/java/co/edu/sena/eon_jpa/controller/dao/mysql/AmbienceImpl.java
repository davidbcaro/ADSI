/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AmbienceDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Ambience;
import co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author SOPORTE
 */
public class AmbienceImpl extends AbstractDao<Ambience> implements AmbienceDao<Ambience>{

    public AmbienceImpl(Class<Ambience> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Ambience> findByDescription(String description) {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ambience> findByStatus(boolean status) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ambience> findByNumberAmbience(String numberAmbience) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByNumberAmbience");
            query.setParameter("numberAmbience", numberAmbience);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ambience> findByNameHeadquarters(String nameHeadquarters) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByNameHeadquarters");
            query.setParameter("nameHeadquarters", nameHeadquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    }

    @Override
    public List<Ambience> findByLikeDescription(String description) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ambience> findByLikeNumberAmbience(String numberAmbience) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByLikeNumberAmbience");
            query.setParameter("numberAmbience", numberAmbience);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ambience> findByLikeNameHeadquarters(String nameHeadquarters) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ambience.findByLikeNameHeadquarters");
            query.setParameter("nameHeadquarters", nameHeadquarters);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(AmbiencePK nuevoAmbience, AmbiencePK viejoAmbience) {
  try {
            this.getEntityManager();

            if (this.find(viejoAmbience) != null) {

                Query query = this.em.createNamedQuery("Ambience.updatePrimaryKey");
                query.setParameter("nuevoNumber",nuevoAmbience.getNumberAmbience());
                query.setParameter("viejoNumber", viejoAmbience.getNumberAmbience());
                query.setParameter("nuevoHeadquarters",nuevoAmbience.getNameHeadquarters() );
                query.setParameter("viejoHeadquarters", viejoAmbience.getNameHeadquarters());
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
