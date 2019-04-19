/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ModalityDAO;
import co.edu.sena.model.jpa.entities.Modality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class ModalityDAOImpl extends AbstractDao<Modality> implements ModalityDAO<Modality> {

    public ModalityDAOImpl(Class<Modality> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Modality> findByNameModality(String nameModality) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Modality.findByNameModality");
            query.setParameter("nameModality", nameModality);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Modality> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Modality.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Modality> findByLikeNameModality(String nameModality) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Modality.findByLikeNameModality");
            query.setParameter("nameModality", nameModality);
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

                Query query = this.em.createNamedQuery("Modality.updatePrimaryKey");
                query.setParameter("modalityNew", llaveNueva);
                query.setParameter("modalityOld", llaveVieja);
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


