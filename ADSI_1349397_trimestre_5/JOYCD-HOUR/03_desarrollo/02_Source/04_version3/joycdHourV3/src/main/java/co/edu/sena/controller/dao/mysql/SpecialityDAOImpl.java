/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.SpecialityDAO;
import co.edu.sena.model.jpa.entities.Speciality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class SpecialityDAOImpl extends AbstractDao<Speciality> implements SpecialityDAO<Speciality> {
    
    public SpecialityDAOImpl(Class<Speciality> entityClass) {
        super(entityClass);   
    }
    
    
    @Override
    public List<Speciality> findByNameSpeciality(String nameSpeciality) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByNameSpeciality");
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
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Speciality.updatePrimaryKey");
                query.setParameter("specialityNew", llaveNueva);
                query.setParameter("specialityOld", llaveVieja);
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
