/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.LinkingDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Linking;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class LinkingImpl extends AbstractDAO<Linking> implements LinkingDAO<Linking>{

    public LinkingImpl(Class<Linking> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Linking> findByTypeLinking(String typeLinking) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Linking.findByTypeLinking");
            query.setParameter("typeLinking", typeLinking);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Linking> findByHours(int hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM wariosoft.linking WHERE hours = '2';",Linking.class);
            query.setParameter("hours", hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Linking> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Linking.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Linking> findByLikeTypeLinking(String typeLinking) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Linking.findByLikeTypeLinking");
            query.setParameter("typeLinking", typeLinking);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePk(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Linking.updatePk");
            query.setParameter("documentoNuevo", llaveNueva );
            query.setParameter("documentoViejo", llaveVieja );
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