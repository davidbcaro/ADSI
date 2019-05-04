/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.FichaDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Ficha;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class FichaDaoImpl extends AbstractDao<Ficha> implements FichaDao<Ficha> {

    public FichaDaoImpl(Class<Ficha> entityClass) {
        super(entityClass);

    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Ficha.updatePrimaryKey");
                query.setParameter("newNumberGroup", newKey);
                query.setParameter("oldNumberGroup", oldKey);

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

    @Override
    public List<Ficha> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByLikeNumberGroup(String numberGroup) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByLikeNumberGroup");
            query.setParameter("numberGroup", numberGroup);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByNumberGroup(String numberGroup) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByNumberGroup");
            query.setParameter("numberGroup", numberGroup);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByStartDate(Date startDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByEndDate(Date endDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByLikeRoute(String route) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByLikeRoute");
            query.setParameter("route", route);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByRoute(String route) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByRoute");
            query.setParameter("route", route);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByNameState(String nameState) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByLikeNameState(String nameState) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByLikeNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByLikeVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByLikeVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ficha> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Ficha.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
 
    
   
}
