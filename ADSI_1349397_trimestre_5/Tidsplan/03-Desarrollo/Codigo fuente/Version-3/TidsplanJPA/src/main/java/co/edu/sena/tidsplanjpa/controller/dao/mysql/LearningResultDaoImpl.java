/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.LearningResultDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LearningResultDaoImpl extends AbstractDao<LearningResult> implements LearningResultDao<LearningResult> {

    public LearningResultDaoImpl(Class<LearningResult> entityClass) {
        super(entityClass);

    }

    @Override
    public List<LearningResult> findByLikeIdCode(String idCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeIdCode");
            query.setParameter("idCode", idCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByIdCode(String idCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByIdCode");
            query.setParameter("idCode", idCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByLikeDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<LearningResult> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<LearningResult> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByLikeCompetitionCode(String competitionCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeCompetitionCode");
            query.setParameter("competitionCode", competitionCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByCompetitionCode(String competitionCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCompetitionCode");
            query.setParameter("competitionCode", competitionCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByLikeProgramVersion(String programVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeProgramVersion");
            query.setParameter("programVersion", programVersion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningResult> findByProgramVersion(String programVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByProgramVersion");
            query.setParameter("programVersion", programVersion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public int updatePrimaryKey(LearningResultPK newKey, LearningResultPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("LearningResult.updatePrimaryKey");
                query.setParameter("newIdCode", newKey.getIdCode());
                query.setParameter("oldIdCode", oldKey.getIdCode());
                query.setParameter("newProgramCode", newKey.getProgramCode());
                query.setParameter("oldProgramCode", oldKey.getProgramCode());
                query.setParameter("newCompetitionCode", newKey.getCompetitionCode());
                query.setParameter("oldCompetitionCode", oldKey.getCompetitionCode());
                query.setParameter("newProgramVersion", newKey.getProgramVersion());
                query.setParameter("oldProgramVersion", oldKey.getProgramVersion());
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
