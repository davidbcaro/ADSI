/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;


import co.edu.sena.tidsplanjpa.controller.dao.CompetitionDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CompetitionPK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Competition;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CompetitionDaoImpl extends AbstractDao<Competition> implements CompetitionDao<Competition> {

    public CompetitionDaoImpl(Class<Competition> entityClass) {
        super(entityClass);

    }

   
    @Override
    public List<Competition> findByLikeCode(String code) {
           try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competition> findByLikeDescription(String description) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByLikeDescription");
            query.setParameter("description", description);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Competition> findByCode(String code) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findByCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    

    @Override
    public List<Competition> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Competition.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(CompetitionPK newKey, CompetitionPK oldKey) {
       try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Competition.updatePrimaryKey");
                query.setParameter("newProgramVersion", newKey.getProgramVersion());
                query.setParameter("newCode", newKey.getCode());
                query.setParameter("newProgramCode", newKey.getProgramCode());
                query.setParameter("oldProgramVersion", oldKey.getProgramVersion());
                query.setParameter("oldCode", oldKey.getCode());
                query.setParameter("oldProgramCode", oldKey.getProgramCode());
                
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
