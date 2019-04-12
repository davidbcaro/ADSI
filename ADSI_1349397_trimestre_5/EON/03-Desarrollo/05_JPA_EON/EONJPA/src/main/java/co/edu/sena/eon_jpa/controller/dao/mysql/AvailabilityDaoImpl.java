package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AvailabilityDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Availability;
import co.edu.sena.eon_jpa.model.jpa.entities.AvailabilityPK;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class AvailabilityDaoImpl extends AbstractDao<Availability> implements AvailabilityDao<Availability> {

    public AvailabilityDaoImpl(Class<Availability> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Availability> findByStartTime(Date startTime) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByStartTime");
            query.setParameter("startTime", startTime);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findByEndTime(Date endTime) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByEndTime");
            query.setParameter("endTime", endTime);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Availability> findByIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Availability> findByDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Availability> findByAcronymsWorkingDay(String acronymsWorkingDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Availability> findByNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Availability> findByLikeStartTime(Date startTime) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByLikeStarTime");
            query.setParameter("startTime", startTime);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findByLikeEndTime(Date endTime) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByLikeEndTime");
            query.setParameter("endTime", endTime);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findByLikeIdDocument(String idDocument) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByLikeIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findBylikeDocumentNumber(String documentNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findBylikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findByLikeAcronymsWorkingDay(String acronymsWorkingDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByLikeAcronymsWorkingDay");
            query.setParameter("acronymsWorkingDay", acronymsWorkingDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Availability> findByLikeNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Availability.findByLikeNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public int UpdatePrimaryKey(AvailabilityPK newKey, AvailabilityPK oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {
                Query query = this.em.createNamedQuery("Availability.UpdatePrimaryKey");
               query.setParameter("newstartTime", newKey.getStartTime());
                query.setParameter("oldstartTime", oldKey.getStartTime());
                query.setParameter("newidDocument", newKey.getIdDocument());
                query.setParameter("oldidDocument", oldKey.getIdDocument());
                query.setParameter("newdocumentNumber", newKey.getDocumentNumber());
                query.setParameter("olddocumentNumber", oldKey.getDocumentNumber());
                query.setParameter("newacronymsWorkingDay", newKey.getAcronymsWorkingDay());
                query.setParameter("oldacronymsWorkingDay", oldKey.getAcronymsWorkingDay());
                query.setParameter("newnameDay", newKey.getNameDay());
                query.setParameter("oldnameDay", oldKey.getNameDay());
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

