/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DisponibilityDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Disponibility;
import co.edu.sena.tidsplanjpa.model.jpa.entities.DisponibilityPK;
import java.sql.Time;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author JulianC
 */
public class DisponibilityDaoImpl extends AbstractDao<Disponibility> implements DisponibilityDao<Disponibility> {

    public DisponibilityDaoImpl(Class<Disponibility> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Disponibility> findByStartHour(Time startHour) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByStartHour");
            query.setParameter("startHour", startHour);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByWorkindDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeWorkindDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeDocument(String document) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeDocument");
            query.setParameter("document", document);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(DisponibilityPK newKey, DisponibilityPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Disponibility.updatePrimaryKey");
                query.setParameter("newStartHour", newKey.getStartHour());
                query.setParameter("oldStartHour", oldKey.getStartHour());
                query.setParameter("newNameDay", newKey.getNameDay());
                query.setParameter("oldNameDay", oldKey.getNameDay());
                query.setParameter("newWorkingDayInitials", newKey.getWorkingDayInitials());
                query.setParameter("oldWorkingDayInitials", oldKey.getWorkingDayInitials());
                query.setParameter("newDocument", newKey.getDocument());
                query.setParameter("oldDocument", oldKey.getDocument());
                query.setParameter("newDocumentNumber", newKey.getDocumentNumber());
                query.setParameter("oldDocumentNumber", oldKey.getDocumentNumber());
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
    public List<Disponibility> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeStartHour(Time startHour) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeStartHour");
            query.setParameter("startHour", startHour);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByEndHour(Time endHour) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByEndHour");
            query.setParameter("endHour", endHour);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disponibility> findByLikeEndHour(Time endHour) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Disponibility.findByLikeEndHour");
            query.setParameter("endHour", endHour);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

}
