/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.LearningResultDao;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResult;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResultPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class LearningResultDaoImpl extends AbstractDao<LearningResult> implements LearningResultDao<LearningResult>{
    public LearningResultDaoImpl(Class entityClass) {
        super(entityClass);
    }
    
    @Override
    public List<LearningResult> findByCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByDescription(String Description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByDescription");
            query.setParameter("Description", Description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByCompetitionCode(String Competition_Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCompetitionCode");
            query.setParameter("CompetitionCode", Competition_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<LearningResult> findByProgramCode(String Program_Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByProgramCode");
            query.setParameter("ProgramCode", Program_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<LearningResult> findByVersion(String Version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByLikeCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByLikeDescription(String Description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeDescription");
            query.setParameter("Description", Description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByLikeCompetitionCode(String Competition_Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeCompetitionCode");
            query.setParameter("CompetitionCode", Competition_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByLikeProgramCode(String Program_Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeProgramCode");
            query.setParameter("ProgramCode", Program_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
    @Override
    public List<LearningResult> findByLikeVersion(String Version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    
     @Override
    public int updatePrimaryKey(LearningResultPK llaveNueva, LearningResultPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("LearningResult.updatePrimaryKey");
                query.setParameter("CodeNuevo", llaveNueva.getCode());
                query.setParameter("CompetitionNuevo", llaveNueva.getCompetitionCode());
                query.setParameter("ProgramNuevo", llaveNueva.getProgramCode());
                query.setParameter("VersionNuevo", llaveNueva.getVersion());
                query.setParameter("CodeViejo", llaveVieja.getCode());
                query.setParameter("CompetitionViejo", llaveVieja.getCompetitionCode());
                query.setParameter("ProgramViejo", llaveVieja.getProgramCode());
                query.setParameter("VersionViejo", llaveVieja.getVersion());           
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
