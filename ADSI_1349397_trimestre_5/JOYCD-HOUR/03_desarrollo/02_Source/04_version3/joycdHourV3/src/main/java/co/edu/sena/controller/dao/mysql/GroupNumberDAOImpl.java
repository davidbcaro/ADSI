/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.GroupNumberDAO;
import co.edu.sena.model.jpa.entities.GroupNumber;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class GroupNumberDAOImpl extends AbstractDao<GroupNumber> implements GroupNumberDAO<GroupNumber> {

    public GroupNumberDAOImpl(Class<GroupNumber> entityClass) {
        super(entityClass);
    }

    @Override
    public List<GroupNumber> findByGroupsNumber(String groupsNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByGroupsNumber");
            query.setParameter("groupsNumber", groupsNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<GroupNumber> findByStartDate(Date startDate) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByFinishDate(Date finishDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByFinishDate");
            query.setParameter("finishDate", finishDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByRoute(char route) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByRoute");
            query.setParameter("route", route);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByVersionCode(String versionCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByVersionCode");
            query.setParameter("versionCode", versionCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByStatusGroupNumber(String statusGroupNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByStatusGroupNumber");
            query.setParameter("statusGroupNumber", statusGroupNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByLikeGroupsNumber(String groupsNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByLikeGroupsNumber");
            query.setParameter("groupsNumber", groupsNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByLikeVersionCode(String versionCode) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByLikeVersionCode");
            query.setParameter("versionCode", versionCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupNumber> findByLikeStatusGroupNumber(String statusGroupNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupNumber.findByLikeStatusGroupNumber");
            query.setParameter("statusGroupNumber", statusGroupNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {

        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("GroupNumber.updatePrimaryKey");
                query.setParameter("groupsNumberNew",llaveNueva);
                query.setParameter("groupsNumberOld",llaveVieja);

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
