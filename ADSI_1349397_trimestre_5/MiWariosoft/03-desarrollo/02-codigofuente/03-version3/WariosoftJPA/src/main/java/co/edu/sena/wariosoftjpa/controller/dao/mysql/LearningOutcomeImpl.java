/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.LearningOutcomeDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcomePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Sebastian
 */
public class LearningOutcomeImpl extends AbstractDAO<LearningOutcome> implements LearningOutcomeDAO<LearningOutcome>{

    public LearningOutcomeImpl(Class<LearningOutcome> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LearningOutcome> findByLearningOutcome(String learningoutcomecode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByLearningOutcome");
            query.setParameter("learningOutcomeCode", learningoutcomecode);
            return query.getResultList();
        } catch (PersistenceException e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningOutcome> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return  null;
    }

    @Override
    public List<LearningOutcome> findByLikeLearningOutcome(String learningoutcomecode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByLikeLearningOutcome");
            query.setParameter("learningOutcomeCode", learningoutcomecode);
            return query.getResultList();
        } catch (PersistenceException e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    

    @Override
    public List<LearningOutcome> findByCompetitionCode(String competitioncode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByCompetitionCode");
            query.setParameter("competitionCode", competitioncode);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningOutcome> findByLikeCompetitionCode(String competitioncode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByLikeCompetitionCode");
            query.setParameter("competitionCode", competitioncode);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningOutcome> findByProgramCode(String programcode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByProgramCode");
            query.setParameter("programCode", programcode);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LearningOutcome> findByLikeProgramCode(String programcode) {
           try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByLikeProgramCode");
            query.setParameter("programCode", programcode);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;      

    }

    @Override
    public List<LearningOutcome> findByVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
        
    }

    @Override
    public List<LearningOutcome> findByLikeVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningOutcome.findByLikeVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
        
    }
    
    @Override
    public int updatePrimaryKey(LearningOutcomePK llaveNueva, LearningOutcomePK llaveVieja) {
        try {
            this.getEntityManager();
            if (this.find(llaveVieja) !=null) {
                Query query = this.em.createNamedQuery("LearningOutcome.updatePrimaryKey");
                query.setParameter("learningOutcomeCodeNuevo", llaveNueva.getLearningOutcomeCode());
                query.setParameter("competitionCodeNuevo",llaveNueva.getCompetitionCode());
                query.setParameter("compProgramCodeNuevo", llaveNueva.getProgramCode());
                query.setParameter("compProgramVersionNuevo", llaveNueva.getVersion());
                query.setParameter("learningOutcomeCodeViejo", llaveVieja.getLearningOutcomeCode());                
                query.setParameter("competitionCodeViejo", llaveVieja.getCompetitionCode());                
                query.setParameter("compProgramCodeViejo", llaveVieja.getProgramCode());                
                query.setParameter("compProgramVersionviejo", llaveVieja.getVersion());
                this.em.getTransaction().begin();
                int res = query.executeUpdate();
                this.em.getTransaction().commit();
                return res;
            } else {
                return 0;
            }
        } catch ( PersistenceException e ) {
            System.out.println("Exception:" + e.getMessage());
        }
        return  0;
    }
    
   
    
    
}
