/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.VersionScheduleDAO;
import co.edu.sena.model.jpa.entities.VersionSchedule;
import co.edu.sena.model.jpa.entities.VersionSchedulePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author PCK
 */
public class VersionScheduleDAOImpl extends AbstractDao<VersionSchedule> implements VersionScheduleDAO<VersionSchedule> {

    public VersionScheduleDAOImpl(Class<VersionSchedule> entityClass) {
        super(entityClass);
    }

    @Override
    public List<VersionSchedule> findByVersion(int version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM version_schedule v WHERE v.version LIKE ?",VersionSchedule.class);
            //Query query = this.em.createNativeQuery("SELECT * FROM Bonding b WHERE b.hours LIKE ?",VersionSchedule.class);
            query.setParameter("version", version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<VersionSchedule> findByStatusVersion(boolean statusVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("VersionSchedule.findByStatusVersion");
            query.setParameter("statusVersion", statusVersion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<VersionSchedule> findByActualityTrimester(String actualityTrimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("VersionSchedule.findByActualityTrimester");
            query.setParameter("actualityTrimester", actualityTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public int updatePrimaryKey(VersionSchedulePK llaveNueva, VersionSchedulePK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("VersionSchedule.UpdatePrimaryKey");
                query.setParameter("versionNueva", llaveNueva.getVersion());

                query.setParameter("actualityTrimesterNueva", llaveNueva.getActualityTrimester());
                query.setParameter("versionVieja", llaveVieja.getVersion());

                query.setParameter("actualityTrimesterVieja", llaveVieja.getActualityTrimester());
                
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


