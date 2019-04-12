/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author 1349397
 */
public abstract class AbstractDao<T> {

    protected EntityManager em;
    private Class<T> entityClass;

    public void cleanEntity() {
        em.flush();
        em.getEntityManagerFactory().getCache().evictAll();
    }

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eon");
        this.em = emf.createEntityManager();
        return this.em;
    }

    public void insert(T entity) {
        try {
            this.getEntityManager();
            this.em.getTransaction().begin();
            em.persist(entity);
            this.em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void update(T entity) {
        try {
            this.getEntityManager();
            this.em.getTransaction().begin();
            em.merge(entity);
            this.em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void remove(T entity){
        try {
            this.getEntityManager();
            this.em.getTransaction().begin();
            em.remove(em.merge(entity));
            this.em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public T find(Object id){
        try {
            this.getEntityManager();
            return this.em.find(entityClass, id);           
        } catch (PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    public List<T> findAll(){
        try {
            this.getEntityManager();
            javax.persistence.criteria.CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return this.em.createQuery(cq).getResultList();
        } catch (PersistenceException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
