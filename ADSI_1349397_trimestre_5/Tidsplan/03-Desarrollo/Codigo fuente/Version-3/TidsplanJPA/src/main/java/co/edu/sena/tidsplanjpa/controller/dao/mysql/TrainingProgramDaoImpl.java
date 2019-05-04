/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.TrainingProgramDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgram;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgramPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class TrainingProgramDaoImpl extends AbstractDao<TrainingProgram> implements TrainingProgramDao<TrainingProgram> {

    public TrainingProgramDaoImpl(Class<TrainingProgram> entityClass) {
        super(entityClass);

    }

    @Override
    public int updatePrimaryKey(TrainingProgramPK newKey, TrainingProgramPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("TrainingProgram.updatePrimaryKey");
                query.setParameter("newIdCode", newKey.getIdCode());
                query.setParameter("newVersion", newKey.getVersion());
                query.setParameter("oldIdCode", oldKey.getIdCode());
                query.setParameter("oldVersion", oldKey.getVersion());
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

    @Override
    public List<TrainingProgram> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByIdCode(String idCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByIdCode");
            query.setParameter("idCode", idCode);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLikeIdCode(String idCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLikeIdCode");
            query.setParameter("idCode", idCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLikeName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLikeVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLikeVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByInitials(String initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLikeInitials(String initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLikeInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TrainingProgram> findByLikeLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TrainingProgram.findByLikeLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
}
