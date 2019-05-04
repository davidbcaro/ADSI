/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ProjectPhaseDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhase;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhasePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ProjectPhaseDaoImpl extends AbstractDao<ProjectPhase> implements ProjectPhaseDao<ProjectPhase> {

    public ProjectPhaseDaoImpl(Class<ProjectPhase> entityClass) {
        super(entityClass);

    }

    @Override
    public int updatePrimaryKey(ProjectPhasePK newKey, ProjectPhasePK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("ProjectPhase.updatePrimaryKey");
                query.setParameter("newNamePhase", newKey.getNamePhase());
                query.setParameter("newProjectCode", newKey.getProjectCode());
                query.setParameter("oldNamePhase", oldKey.getNamePhase());
                query.setParameter("oldProjectCode", oldKey.getProjectCode());
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
    public List<ProjectPhase> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectPhase> findByNamePhase(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findByNamePhase");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectPhase> findByLikeNamePhase(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findByLikeNamePhase");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectPhase> findByProjectCode(String projectCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findByProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectPhase> findByLikeProjectCode(String projectCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findByLikeProjectCode");
            query.setParameter("projectCode", projectCode);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectPhase> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("ProjectPhase.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
