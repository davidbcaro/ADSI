/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LearningResultDao;
import co.edu.sena.cot.modelo.dto.LearningResult;
import co.edu.sena.cot.modelo.dto.LearningResultPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LearningResultImpl extends AbstractDao<LearningResult> implements LearningResultDao<LearningResult> {

    public LearningResultImpl(Class<LearningResult> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LearningResult> findByCode(String code) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCode");
            query.setParameter("code", code);
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
    public List<LearningResult> findByCodeCompetence(int codeCompetence) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCodeCompetence");
            query.setParameter("codeCompetence", codeCompetence);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    
    }

    @Override
    public List<LearningResult> findByCodeProgram(int codeProgram) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByCodeProgram");
            query.setParameter("codeProgram", codeProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    
    }

    @Override
    public List<LearningResult> findByEdition(String edition) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByEdition");
            query.setParameter("edition", edition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    
    }

    @Override
    public List<LearningResult> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.learning_result l  WHERE l.code LIKE ? ", LearningResult.class);
            query.setParameter(1, code);
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
    public List<LearningResult> findByLikeCodeCompetence(String codeCompetence) {
       try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.learning_result l  WHERE l.code_Competence LIKE ?;", LearningResult.class);
            query.setParameter(1, codeCompetence);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<LearningResult> findByLikeCodeProgram(String codeProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.learning_result l  WHERE l.code_Program LIKE ?;", LearningResult.class);
            query.setParameter(1, codeProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<LearningResult> findByLikeEdition(String edition) {
             try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("LearningResult.findByLikeEdition");
            query.setParameter("edition", edition);
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

                Query query = this.em.createNamedQuery("LearningResult.updatePK");
                query.setParameter("codeNew", llaveNueva.getCode());
                query.setParameter("competenceNew", llaveNueva.getCodeCompetence());
                query.setParameter("programNew", llaveNueva.getCodeProgram());
                query.setParameter("editionNew", llaveNueva.getEdition());
                
                query.setParameter("code", llaveVieja.getCode());
                query.setParameter("competence", llaveVieja.getCodeCompetence());
                query.setParameter("program", llaveVieja.getCodeProgram());
                query.setParameter("edition", llaveVieja.getEdition());
                
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
