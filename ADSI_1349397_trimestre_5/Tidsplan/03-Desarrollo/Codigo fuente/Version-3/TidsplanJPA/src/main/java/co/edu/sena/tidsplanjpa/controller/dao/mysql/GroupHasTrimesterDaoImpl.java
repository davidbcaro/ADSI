/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.GroupHasTrimesterDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimesterPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class GroupHasTrimesterDaoImpl extends AbstractDao<GroupHasTrimester> implements GroupHasTrimesterDao<GroupHasTrimester> {

    public GroupHasTrimesterDaoImpl(Class<GroupHasTrimester> entityClass) {
        super(entityClass);
    }

    @Override
    public List<GroupHasTrimester> findByLikeNumberGroup(String numberGroup) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByLikeNumberGroup");
            que.setParameter("numberGroup", numberGroup);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByLikeNameTrimester(String nameTrimester) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByLikeNameTrimester");
            que.setParameter("nameTrimester", nameTrimester);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByLikeWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByLikeWorkingdayInitials");
            que.setParameter("workingdayInitials", workingDayInitials);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByLikeLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByLikeLevelFormation");
            que.setParameter("levelFormation", levelFormation);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByNumberGroup(String numberGroup) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByNumberGroup");
            que.setParameter("numberGroup", numberGroup);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByNameTrimester(String nameTrimester) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByNameTrimester");
            que.setParameter("nameTrimester", nameTrimester);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByWorkingdayInitials");
            que.setParameter("workingdayInitials", workingDayInitials);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<GroupHasTrimester> findByLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("GroupHasTrimester.findByLevelFormation");
            que.setParameter("levelFormation", levelFormation);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(GroupHasTrimesterPK newKey, GroupHasTrimesterPK oldKey) {
       
        try {
            this.getEntityManager();
            if (this.find(oldKey) != null) {
            Query que = this.em.createNamedQuery("GroupHasTrimester.updatePrimaryKey");
            que.setParameter("newNumberGroup", newKey.getNumberGroup());
            que.setParameter("oldNumberGroup", oldKey.getNumberGroup());
            que.setParameter("newNameTrimester", newKey.getNameTrimester());
            que.setParameter("oldNameTrimester", oldKey.getNameTrimester());
            que.setParameter("newWorkingDayInitials", newKey.getWorkingdayInitials());
            que.setParameter("oldWorkingDayInitials", oldKey.getWorkingdayInitials());
            que.setParameter("newLevelFormation", newKey.getLevelFormation());
            que.setParameter("oldLevelFormation", oldKey.getLevelFormation());
            this.em.getTransaction().begin();
                int res = que.executeUpdate();
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
    public List<GroupHasTrimester> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("GroupHasTrimester.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
