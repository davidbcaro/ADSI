/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterTermDao;
import co.edu.sena.cot.modelo.dto.TrimesterTerm;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class TrimesterTermDaoImpl extends AbstractDao<TrimesterTerm> implements TrimesterTermDao<TrimesterTerm> {

    public TrimesterTermDaoImpl(Class<TrimesterTerm> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TrimesterTerm> findByIdTrimester(int trimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterTerm.findByIdTrimester");
            query.setParameter("trimester", trimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterTerm> findByStartDate(Date startDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterTerm.findByStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterTerm> findByEndDate(Date endDate) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterTerm.findByEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<TrimesterTerm> findByLikeIdTrimester(int trimester) {
     try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("SELECT * FROM cot.trimesterTerm t WHERE idTrimester LIKE ?;", TrimesterTerm.class);
            query.setParameter("trismerter", trimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<TrimesterTerm> findByLikeStartDate(Date startDate) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterTerm.findByLikeStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<TrimesterTerm> findByLikeEndDate(Date endDate) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterTerm.findByLikeEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;     
    }
    
}
