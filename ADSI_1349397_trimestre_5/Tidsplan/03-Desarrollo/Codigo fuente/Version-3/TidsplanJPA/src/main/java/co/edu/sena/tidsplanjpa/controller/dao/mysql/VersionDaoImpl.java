/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.VersionDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Version;
import co.edu.sena.tidsplanjpa.model.jpa.entities.VersionPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class VersionDaoImpl extends AbstractDao<Version> implements VersionDao<Version>{

    public VersionDaoImpl(Class<Version> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Version> findByIdVersion(int idVersion) {
 try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Version.findByIdVersion");
            que.setParameter("idVersion", idVersion);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Version> findByLikeIdVersion(int idVersion) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Version.findByLikeIdVersion");
            que.setParameter("idVersion", idVersion);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Version> findByIdTrimesterCurrent(String idTrimesterCurrent) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Version.findByIdTrimesterCurrent");
            que.setParameter("idTrimesterCurrent", idTrimesterCurrent);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Version> findByLikeIdTrimesterCurrent(String idTrimesterCurrent) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Version.findByLikeIdTrimesterCurrent");
            que.setParameter("idTrimesterCurrent", idTrimesterCurrent);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;     }

    @Override
    public List<Version> findByStatus(Boolean status) {
try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Version.findByStatus");
            que.setParameter("status", status);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;     }

    @Override
    public int updatePrimaryKey(VersionPK newKey, VersionPK oldKey) {
 try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Version.updatePrimaryKey");
                query.setParameter("newIdVersion", newKey.getIdVersion());
                query.setParameter("newIdTrimesterCurrent", newKey.getIdTrimesterCurrent());
                query.setParameter("oldIdVersion", oldKey.getIdVersion());
                query.setParameter("oldIdTrimesterCurrent", oldKey.getIdTrimesterCurrent());
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
        return 0;    }

    @Override
    public List<Version> findAll() {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Version.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;    }

}
