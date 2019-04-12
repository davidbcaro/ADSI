/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.CurrentQuarterDao;
import co.edu.sena.eon_jpa.model.jpa.entities.CurrentQuarter;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Telegrafia01
 */
public class CurrentQuarterImpl extends AbstractDao <CurrentQuarter> implements CurrentQuarterDao<CurrentQuarter>{

    public CurrentQuarterImpl(Class<CurrentQuarter> entityClass) {
        super(entityClass);
    }

    @Override
    public List<CurrentQuarter> findByIdCurrentQuarter(String idCurrentQuarter) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByIdCurrrentQuarter");
            query.setParameter("idCurrentQuarter ", idCurrentQuarter);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByLikeIdCurrentQuarter(String idCurrentQuarter) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByLikeIdCurrentQuarter");
            query.setParameter("idCurrentQuarter", idCurrentQuarter);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByStartDate(String start) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByStart");
            query.setParameter("start", start);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByLikeStarDate(String start) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByLikeStart");
            query.setParameter("start", start);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByEndDate(String end) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByEnd");
            query.setParameter("end", end);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByLikeEndDate(String end) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findByLikeEnd");
            query.setParameter("end", end);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String nuevoidCurrentQuarter, String viejoidCurrentQuarter) {
 try {
            this.getEntityManager();

            if (this.find(viejoidCurrentQuarter) != null) {

                Query query = this.em.createNamedQuery("CurrentQuarter.updatePrimaryKey");
                query.setParameter("nuevoidCurrentQuarter", nuevoidCurrentQuarter);
                query.setParameter("viejoidCurrentQuarter", viejoidCurrentQuarter);
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
