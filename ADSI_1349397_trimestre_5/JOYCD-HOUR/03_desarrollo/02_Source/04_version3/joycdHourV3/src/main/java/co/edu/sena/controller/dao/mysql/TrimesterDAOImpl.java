/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.TrimesterDAO;
import co.edu.sena.model.jpa.entities.Trimester;
import co.edu.sena.model.jpa.entities.TrimesterPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class TrimesterDAOImpl extends AbstractDao<Trimester> implements TrimesterDAO<Trimester> {

    public TrimesterDAOImpl(Class<Trimester> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Trimester> findByTrimesterName(String trimesterName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByTrimesterName");
            query.setParameter("trimesterName", trimesterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByLikeTrimesterName(String trimesterName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeTrimesterName");
            query.setParameter("trimesterName", trimesterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByLikeWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByLikeLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(TrimesterPK llaveNueva, TrimesterPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Trimester.updatePrimaryKey");
                query.setParameter("trimesterNameNew", llaveNueva.getTrimesterName());
                query.setParameter("workingDayInitialsNew", llaveNueva.getWorkingDayInitials());
                query.setParameter("levelFormationNew", llaveNueva.getLevelFormation());
                query.setParameter("trimesterNameOld", llaveVieja.getTrimesterName());
                query.setParameter("workingDayInitialsOld", llaveVieja.getWorkingDayInitials());
                query.setParameter("levelFormationOld", llaveVieja.getLevelFormation());
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
