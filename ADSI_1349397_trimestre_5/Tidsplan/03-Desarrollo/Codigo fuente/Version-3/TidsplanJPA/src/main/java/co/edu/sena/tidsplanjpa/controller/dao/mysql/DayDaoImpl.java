/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DayDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Day;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author MIHOGAR
 */
public class DayDaoImpl extends AbstractDao<Day> implements DayDao<Day>{

    public DayDaoImpl(Class<Day> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Day> findByNameDay(String nameDay) {
    try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Day.findByNameDay");
            que.setParameter("nameDay", nameDay);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Day> findByLikeNameDay(String nameDay) {
    try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Day.findByLikeNameDay");
            que.setParameter("nameDay", nameDay);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Day> findByStatus(Boolean status) {
    try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Day.findByStatus");
            que.setParameter("status", status);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }    

   

    @Override
    public List<Day> findAll() {
 try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Day.findAll");
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
 try {
            this.getEntityManager();
            
            if(this.find(oldKey)!=null){
            
            Query query = this.em.createNamedQuery("Day.updatePrimaryKey");
            query.setParameter("newDay", newKey);
            query.setParameter("oldDay", oldKey);
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
