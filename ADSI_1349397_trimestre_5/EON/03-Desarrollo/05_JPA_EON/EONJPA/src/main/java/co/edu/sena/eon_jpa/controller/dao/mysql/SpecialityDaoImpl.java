/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.SpecialityDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Speciality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Liliana Narvaez
 */
public class SpecialityDaoImpl extends AbstractDao<Speciality> implements SpecialityDao<Speciality> {

    public SpecialityDaoImpl(Class<Speciality> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Speciality> findBylikespecialityName(String specialityName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByLikespecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
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
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Speciality> findByspecialityName(String specialityName) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByspecialityName");
            query.setParameter("specialityName", specialityName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Speciality.updatePrimaryKey");
            query.setParameter("specialityNameNuevo", llaveNueva );
            query.setParameter("specialityNameViejo", llaveVieja );
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
    
        return 0;
    }

}
