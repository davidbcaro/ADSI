/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.IdentificationCardDAO;
import co.edu.sena.controller.dao.LearningResultDAO;
import co.edu.sena.model.jpa.entities.IdentificationCard;
import co.edu.sena.model.jpa.entities.LearningResult;
import co.edu.sena.model.jpa.entities.LearningResultPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LearningResultDAOImpl extends AbstractDao <LearningResult> implements LearningResultDAO<LearningResult>{
    public LearningResultDAOImpl(Class<LearningResult> entityClass) {
        super(entityClass);
    }

    @Override
    public List<LearningResult> findByLearningResultCode(String learningResultCode) {
       try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByLearningResultCode");
        query.setParameter("learningResultCode", learningResultCode);
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
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
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    
    }

    @Override
    public List<LearningResult> findByProgramCode(String programcode) {
       try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByProgramcode");
        query.setParameter("programcode",programcode );
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    
    }

    @Override
    public List<LearningResult> findByCompetenceCode(String competenceCode) {
        
    try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByCompetenceCode");
        query.setParameter("competenceCode",competenceCode  );
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    
    }

    @Override
    public List<LearningResult> findByVersion(String version) {
             
    try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByVersion");
        query.setParameter("version" , version );
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    
    
    }

    @Override
    public List<LearningResult> findByLikeLearningCode(String learningResultCode) {
                  
    try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByLikeLearningResultCode");
        query.setParameter("learningResultCode" , learningResultCode);
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
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
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    
    
    }

    @Override
    public List<LearningResult> findByLikeProgramCode(String programcode) {
        try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByLikeProgramCode");
        query.setParameter("programcode", programcode);
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
     
    }

    @Override
    public List<LearningResult> findByLikeCompetenceCode(String competenceCode) {
        try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByLikeCompetenceCode");
        query.setParameter("competenceCode", competenceCode);
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    }

    @Override
    public List<LearningResult> findByLikeVersion(String version) {
        try {
        this.getEntityManager();
        Query query = this.em.createNamedQuery("LearningResult.findByLikeVersion");
        query.setParameter("version", version);
        return query.getResultList();
       }catch (PersistenceException e){
           System.out.println("Exception"+ e.getMessage());
       }
       return null;
    }

    @Override
    public int updatePrimaryKey(LearningResultPK llaveNueva, LearningResultPK llaveVieja) {
         try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("LearningResult.UpdatePK");
                query.setParameter("resultadoNuevo", llaveNueva.getLearningResultCode());
                query.setParameter("codigoProgramNuevo", llaveNueva.getProgramcode());
                query.setParameter ("competenciaNueva", llaveNueva.getCompetenceCode());
                query.setParameter ("versionNueva", llaveNueva.getVersion());
                query.setParameter("resultadoViejo", llaveVieja.getLearningResultCode());
                query.setParameter("codigoProgramViejo", llaveVieja.getProgramcode());
                query.setParameter ("competenciaVieja", llaveVieja.getCompetenceCode());
                query.setParameter ("versionVieja", llaveVieja.getVersion());
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
    

