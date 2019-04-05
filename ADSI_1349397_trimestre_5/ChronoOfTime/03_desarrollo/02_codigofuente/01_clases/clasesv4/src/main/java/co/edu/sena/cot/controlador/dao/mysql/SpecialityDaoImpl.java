/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.SpecialityDao;
import co.edu.sena.cot.modelo.dto.Speciality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class SpecialityDaoImpl extends AbstractDao<Speciality> implements SpecialityDao<Speciality> {

    public SpecialityDaoImpl(Class<Speciality> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Speciality> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Speciality> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Speciality.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Speciality> findByLikeName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("Speciality.findByLikeState");
            query.setParameter(1, name);
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

                Query query = this.em.createNamedQuery("Speciality.updatePK");
                query.setParameter("SpecialityNew", llaveNueva);
                query.setParameter("SpecialityOld", llaveVieja);
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
