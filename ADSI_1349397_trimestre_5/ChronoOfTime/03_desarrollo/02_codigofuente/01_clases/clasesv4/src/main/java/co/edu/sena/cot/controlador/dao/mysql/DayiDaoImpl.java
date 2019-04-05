/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.DayIDao;
import co.edu.sena.cot.modelo.dto.Dayi;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class DayiDaoImpl  extends AbstractDao<Dayi> implements DayIDao<Dayi> {

    public DayiDaoImpl(Class<Dayi> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Dayi> findByNameDayi(String name) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Dayi.findByName");
            query.setParameter("nameDayi", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }    
    

    @Override
    public List<Dayi> findByState(boolean state) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Dayi.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<Dayi> findByLikeName(String name) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Dayi.findByLikeName");
            query.setParameter("name", name);
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

                Query query = this.em.createNamedQuery("Dayi.updatePK");
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
