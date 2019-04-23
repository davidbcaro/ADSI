/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.CompetitionDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Competition;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CompetitionPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CompetitionImpl extends AbstractDAO<Competition> implements CompetitionDAO<Competition>{

    public CompetitionImpl(Class<Competition> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Competition> findByCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByDescription(String description) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByProgramVersion(String programVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByProgramVersion");
            query.setParameter("programVersion", programVersion);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByLikeProgramVersion(String programVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeProgramVersion");
            query.setParameter("programVersion", programVersion);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePk(CompetitionPK llaveNueva, CompetitionPK llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Competition.updatePk");
            query.setParameter("competitionNuevo", llaveNueva.getCompetitionCode());
            query.setParameter("codeNuevo", llaveNueva.getProgramCode());
            query.setParameter("versionNueva", llaveVieja.getVersion());
            query.setParameter("competitionViejo", llaveNueva.getCompetitionCode());
            query.setParameter("codeViejo", llaveNueva.getProgramCode());
            query.setParameter("versionViejo", llaveVieja.getVersion());
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return 0;    }
}
