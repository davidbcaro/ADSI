/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ModalityDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Modality;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author JulianC
 */
public class ModalityDaoImpl extends AbstractDao<Modality> implements ModalityDao<Modality> {

    public ModalityDaoImpl(Class<Modality> entityClass) {
        super(entityClass);
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
    public List<Modality> findByNameModality(String nameModality) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Modality.findByNameModality");
            que.setParameter("nameModality", nameModality);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Modality> findByLikeNameModality(String nameModality) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Modality.findByLikeNameModality");
            que.setParameter("nameModality", nameModality);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
         try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("Modality.updatePrimaryKey");
            query.setParameter("newKey", newKey);
            query.setParameter("oldKey", oldKey);
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

    @Override
    public List<Modality> findAll() {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Modality.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

}
