/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.CompetenceDao;
import co.edu.sena.cot.modelo.dto.Competence;
import co.edu.sena.cot.modelo.dto.CompetencePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CompetenceDaoImpl extends AbstractDao<Competence> implements CompetenceDao<Competence>  {
    
    public CompetenceDaoImpl(Class<Competence> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Competence> findByCodeCompetence(int codeCompetence) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByCodeCompetence");
            query.setParameter("codeCompetence", codeCompetence);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByCodeProgram(int codeProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByCodeProgram");
            query.setParameter("codeProgram", codeProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByEdition(String edition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByEdition");
            query.setParameter("edition", edition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeCodeComptence(String codeCompetence) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeCompetence");
            query.setParameter("codeCompetence", codeCompetence);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeCodeProgram(String codeProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeCodeProgram");
            query.setParameter("codeProgram", codeProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeEdition(String edition) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeEdition");
            query.setParameter("edition", edition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(CompetencePK llaveNueva, CompetencePK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Competence.updatePK");
                query.setParameter("CompetenceNew", llaveNueva.getCodeCompetence());
                query.setParameter("CompetenceNew2", llaveNueva.getCodeProgram());
                query.setParameter("CompetenceNew3", llaveNueva.getEdition());
                
                query.setParameter("CompetenceOld", llaveVieja.getCodeCompetence());
                query.setParameter("CompetenceOld2", llaveVieja.getCodeProgram());
                query.setParameter("CompetenceOld3", llaveVieja.getEdition());
                
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
