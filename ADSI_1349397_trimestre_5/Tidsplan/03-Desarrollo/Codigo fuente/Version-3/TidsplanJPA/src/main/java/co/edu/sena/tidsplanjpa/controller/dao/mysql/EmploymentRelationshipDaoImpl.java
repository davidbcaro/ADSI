/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.EmploymentRelationshipDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EmploymentRelationship;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class EmploymentRelationshipDaoImpl extends AbstractDao<EmploymentRelationship> implements EmploymentRelationshipDao<EmploymentRelationship> {

    public EmploymentRelationshipDaoImpl(Class<EmploymentRelationship> entityClass) {
        super(entityClass);
    }

    @Override
    public List<EmploymentRelationship> findByTypeEmploymentRelationShip(String typeEmploymentRelationShip) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("EmploymentRelationship.findByTypeEmploymentRelationship");
            que.setParameter("typeEmploymentRelationship", typeEmploymentRelationShip);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmploymentRelationship> findByLikeTypeEmploymentRelationShip(String typeEmploymentRelationShip) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("EmploymentRelationship.findByLikeTypeEmploymentRelationship");
            que.setParameter("typeEmploymentRelationship", typeEmploymentRelationShip);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmploymentRelationship> findByHours(int hours) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("EmploymentRelationship.findByHours");
            que.setParameter("hours", hours);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmploymentRelationship> findByLikeHours(String hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM tidsplan.employment_relationship  where tidsplan.employment_relationship.hours  like '%2%'",EmploymentRelationship.class);
            query.setParameter(2, hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EmploymentRelationship> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("EmploymentRelationship.findByStatus");
            que.setParameter("status", status);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("EmploymentRelationship.updatePrimaryKey");
                query.setParameter("newRela", newKey);
                query.setParameter("oldRela", oldKey);
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
    public List<EmploymentRelationship> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("EmploymentRelationship.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

}
