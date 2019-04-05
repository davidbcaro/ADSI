/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterHasLearningResultDao;
import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResult;
import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResultPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
public class TrimesterHasLearningResultImpl  extends AbstractDao<TrimesterHasLearningResult> implements TrimesterHasLearningResultDao<TrimesterHasLearningResult>{

    public TrimesterHasLearningResultImpl(Class<TrimesterHasLearningResult> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TrimesterHasLearningResult> findByTrimesterNumber(int trimesterNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByTrimesterNumber");
            query.setParameter("trimesterNumber", trimesterNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByTriWorkInitials(String triWorkInitials) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByTriWorkInitials");
            query.setParameter("triWorkInitials", triWorkInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLeveltCode(String leveltCode) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLeveltCode");
            query.setParameter("leveltCode", leveltCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLearningrCode(String learningrCode) {
           try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLearningrCode");
            query.setParameter("learningrCode", learningrCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByCompetenceCode(int competenceCode) {
           try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByCompetenceCode");
            query.setParameter("competenceCode", competenceCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    

    @Override
    public List<TrimesterHasLearningResult> findByProgramCode(int ProgramCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByProgramCode");
            query.setParameter("programCode", ProgramCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLearningEdition(String learningEdition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLearningEdition");
            query.setParameter("learningEdition", learningEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeTrimesterNumber(String trimesterNumber) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.trimester_has_learning_result t WHERE trimester_number LIKE ?;");
            query.setParameter(1, trimesterNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeTriWorkInitials(String triWorkInitials) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLikeTriWorkInitials");
            query.setParameter("triWorkInitials", triWorkInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeLeveltCode(String leveltCode) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLikeLeveltCode");
            query.setParameter("leveltCode", leveltCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeLearningrCode(String learningrCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLikeLearningrCode");
            query.setParameter("learningrCode", learningrCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeCompetenceCode(String competenceCode) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.trimester_has_learning_result t WHERE competence_code LIKE ?;");
            query.setParameter(1, competenceCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeProgramCode(String programCode) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.trimester_has_learning_result t WHERE program_code LIKE ?;");
            query.setParameter(1, programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrimesterHasLearningResult> findByLikeLearningEdition(String learningEdition) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrimesterHasLearningResult.findByLikeLearningEdition");
            query.setParameter("learningEdition", learningEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(TrimesterHasLearningResultPK llaveNueva, TrimesterHasLearningResultPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("TrimesterHasLearningResult.updatePK");
                query.setParameter("TrimesterNumberNew", llaveNueva.getTrimesterNumber());
                query.setParameter("TriWorkInitialsNew", llaveNueva.getTriWorkInitials());
                query.setParameter("LeveltCodeNew", llaveNueva.getLeveltCode());
                query.setParameter("LearningrCodeNew", llaveNueva.getLearningrCode());
                query.setParameter("CompetenceCodeNew", llaveNueva.getCompetenceCode());
                query.setParameter("ProgramCodeNew", llaveNueva.getProgramCode());
                query.setParameter("LearningEditionNew", llaveNueva.getLearningEdition());
                
                query.setParameter("TrimesterNumberOld", llaveVieja.getTrimesterNumber());
                query.setParameter("TriWorkInitialsOld", llaveVieja.getTriWorkInitials());
                query.setParameter("LeveltCodeNewOld", llaveVieja.getLeveltCode());
                query.setParameter("LearningrCodeNewOld", llaveVieja.getLearningrCode());
                query.setParameter("CompetenceCodeNewOld", llaveVieja.getCompetenceCode());
                query.setParameter("ProgramCodeNewOld", llaveVieja.getProgramCode());
                query.setParameter("LearningEditionNewOld", llaveVieja.getLearningEdition());
                
              
                
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
