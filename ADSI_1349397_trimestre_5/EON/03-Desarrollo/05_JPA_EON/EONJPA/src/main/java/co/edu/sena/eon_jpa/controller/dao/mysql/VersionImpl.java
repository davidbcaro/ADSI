/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.VersionDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Version;
import co.edu.sena.eon_jpa.model.jpa.entities.VersionPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author SOPORTE
 */
public class VersionImpl extends AbstractDao<Version> implements VersionDao<Version> {

    public VersionImpl(Class<Version> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Version> findByIdCurrentQuarter(String idCurrentQuarter) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findByIdCurrentQuarter");
            query.setParameter("idCurrentQuarter", idCurrentQuarter);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Version> findByIdVersion(int idVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findByIdVersion");
            query.setParameter("idVersion", idVersion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Version> findByActive(Boolean active) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findByActive");
            query.setParameter("active", active);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Version> findByLikeIdCurrentQuarter(String idCurrentQuarter) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findByLikeIdCurrentQuarter");
            query.setParameter("idCurrentQuarter", idCurrentQuarter);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Version> findByLikeIdVersion(int idVersion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findByLikeIdVersion");
            query.setParameter("idVersion", idVersion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(VersionPK llavevieja, VersionPK llavenueva) {
        try {
            this.getEntityManager();

            if (this.find(llavevieja) != null) {

                Query query = this.em.createNamedQuery("Version.updatePrimaryKey");
                query.setParameter("nuevoIdCurrentQuarter", llavenueva.getIdCurrentQuarter());
                query.setParameter("viejoIdCurrentQuarter", llavevieja.getIdCurrentQuarter());
                query.setParameter("nuevoIdVersion", llavenueva.getIdVersion());
                query.setParameter("viejoIdVersion", llavevieja.getIdVersion());
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
