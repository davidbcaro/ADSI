/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.FormationLevelDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class FormationLevelDaoImpl extends AbstractDao<FormationLevel> implements FormationLevelDao<FormationLevel> {

    public FormationLevelDaoImpl(Class<FormationLevel> entityClass) {
        super(entityClass);

    }

    @Override
    public List<FormationLevel> findByLikeLevelFormation(String levelFormation) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("FormationLevel.findByLikeLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<FormationLevel> findByLevelFormation(String levelFormation) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("FormationLevel.findByLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<FormationLevel> findByStatus(boolean status) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("FormationLevel.findByStatus");
            query.setParameter("status", status);
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
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("FormationLevel.updatePrimaryKey");
            query.setParameter("lfNew", newKey );
            query.setParameter("lfOld", oldKey );
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
    public List<FormationLevel> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("FormationLevel.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

}
