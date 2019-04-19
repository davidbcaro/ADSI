/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.CompetenceDAO;
import co.edu.sena.model.jpa.entities.Competence;
import co.edu.sena.model.jpa.entities.CompetencePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CompetenceDAOImpl extends AbstractDao< Competence> implements CompetenceDAO< Competence> {

    public CompetenceDAOImpl(Class<Competence> entityClass) {
        super(entityClass);

    }

    @Override
    public List<Competence> findByCompetenceCode(String competenceCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByCompetenceCode");
            query.setParameter("competenceCode", competenceCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

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
            System.out.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception" + e.getMessage());

        }
        return null;
    }
    ////// LIKE

    @Override
    public List<Competence> findByLikeCompetenceCode(String competenceCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeCompetenceCode");
            query.setParameter("competenceCode", competenceCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

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
            System.out.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> findByLikeVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competence.findByLikeVersion");
            query.setParameter("version", version);
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception" + e.getMessage());

        }
        return null;
    }

    @Override
    public int updatePrimaryKey(CompetencePK llaveNueva, CompetencePK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Competence.UpdatePK");
                query.setParameter("competenciaNueva", llaveNueva.getCompetenceCode());
                query.setParameter("programCodeNueva", llaveNueva.getProgramCode());
                query.setParameter("versionNueva", llaveNueva.getVersion());
                query.setParameter("competenciaVieja", llaveVieja.getCompetenceCode());
                query.setParameter("programCodeVieja", llaveVieja.getProgramCode());
                query.setParameter("versionVieja", llaveVieja.getVersion());
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
