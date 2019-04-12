/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.CompetitionDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Competition;
import co.edu.sena.eon_jpa.model.jpa.entities.CompetitionPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class CompetitionDaoImpl extends AbstractDao<Competition> implements CompetitionDao<Competition>{
    public CompetitionDaoImpl(Class entityClass){
        super(entityClass);
    }
    
    @Override
    public List<Competition> findByCode(String Competition_code){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByCode");
            query.setParameter("CompetitionCode", Competition_code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Competition> findByDescription(String description){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByDescription");
            query.setParameter("Description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Competition> findByProgramCode(String Program_Code){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByProgramCode");
            query.setParameter("ProgramCode", Program_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Competition> findByProgramVersion(String Version){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByProgramVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
     
    @Override
    public List<Competition> findByLikeCode(String Competition_code){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeCode");
            query.setParameter("CompetitionCode", Competition_code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Competition> findByLikeDescription(String description){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeDescription");
            query.setParameter("Description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Competition> findByLikeProgramCode(String Program_Code){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeProgramCode");
            query.setParameter("ProgramCode", Program_Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
   
    @Override
    public List<Competition> findByLikeProgramVersion(String Version){
        try{
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeProgramVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
   
    @Override
    public int updatePrimaryKey(CompetitionPK llaveNueva, CompetitionPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Competition.updatePrimaryKey");
                query.setParameter("CompetitionNuevo", llaveNueva.getCompetitioncode());
                query.setParameter("CodeNuevo", llaveNueva.getProgramCode());
                query.setParameter("VersionNuevo", llaveNueva.getVersion());
                query.setParameter("CompetitionViejo", llaveVieja.getCompetitioncode());
                query.setParameter("CodeViejo", llaveVieja.getProgramCode());
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

