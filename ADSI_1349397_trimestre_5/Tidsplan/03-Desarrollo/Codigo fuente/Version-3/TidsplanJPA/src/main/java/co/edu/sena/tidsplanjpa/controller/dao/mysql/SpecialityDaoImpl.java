/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.SpecialityDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Speciality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class SpecialityDaoImpl extends AbstractDao<Speciality> implements SpecialityDao<Speciality> {

    public SpecialityDaoImpl(Class<Speciality> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Speciality> findByNameSpeciality(String nameSpeciality) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Speciality.findByNameSpeciality");
            que.setParameter("nameSpeciality", nameSpeciality);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Speciality> findByLikeNameSpeciality(String nameSpeciality) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByLikeNameSpeciality");
            query.setParameter("nameSpeciality", nameSpeciality);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Speciality> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Speciality> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
        try {
            this.getEntityManager();

            if (this.find(oldKey) != null) {

                Query query = this.em.createNamedQuery("Speciality.updatePrimaryKey");
                query.setParameter("newNameSpeciality", newKey);
                query.setParameter("oldNameSpeciality", oldKey);
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
