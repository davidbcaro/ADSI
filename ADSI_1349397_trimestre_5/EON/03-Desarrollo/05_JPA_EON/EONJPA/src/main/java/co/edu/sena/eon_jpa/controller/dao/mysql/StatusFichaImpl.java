/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;




import co.edu.sena.eon_jpa.controller.dao.StatusFichaDao;
import co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author SOPORTE
 */
public class StatusFichaImpl extends AbstractDao<StatusFicha> implements StatusFichaDao<StatusFicha> {

    public StatusFichaImpl(Class<StatusFicha> entityClass) {
        super(entityClass);
    }

    @Override
    public List<StatusFicha> findByNameState(String nameState) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StatusFicha.findByNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<StatusFicha> findByState(boolean State) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StatusFicha.findByState");
            query.setParameter("state", State);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<StatusFicha> findByLikeNameState(String nameState) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("StatusFicha.findByLikeNameState");
            query.setParameter("nameState", nameState);
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

                Query query = this.em.createNamedQuery("StatusFicha.updatePrimaryKey");
                query.setParameter("nameStateNuevo", llaveNueva);
                query.setParameter("nameStateViejo", llaveVieja);
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
