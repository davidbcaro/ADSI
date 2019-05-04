/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.FormationLevelDao;
import co.edu.sena.tidsplanjpa.controller.dao.TrimesterDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Trimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class TrimesterDaoImpl extends AbstractDao<Trimester> implements TrimesterDao<Trimester> {

    public TrimesterDaoImpl(Class<Trimester> entityClass) {
        super(entityClass);

    }

    @Override
    public List<Trimester> findByLikeNameTrimester(String nameTrimester) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeNameTrimester");
            query.setParameter("nameTrimester", nameTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByNameTrimester(String nameTrimester) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByNameTrimester");
            query.setParameter("nameTrimester", nameTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findByLikeWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeWorkingdayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
            System.out.println("Exception:" + e.getMessage());
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
            System.out.println("Exception:" + e.getMessage());
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
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Trimester> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(TrimesterPK newKey, TrimesterPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Trimester.updatePrimaryKey");
                query.setParameter("newNameTrimester", newKey.getNameTrimester());
                query.setParameter("oldNameTrimester", oldKey.getNameTrimester());
                query.setParameter("newWorkingdayInitials", newKey.getWorkingdayInitials());
                query.setParameter("oldWorkingdayInitials", oldKey.getWorkingdayInitials());
                query.setParameter("newLevelFormation", newKey.getLevelFormation());
                query.setParameter("oldLevelFormation", oldKey.getLevelFormation());
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
