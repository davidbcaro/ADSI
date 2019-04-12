/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.PhaseDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Phase;
import co.edu.sena.eon_jpa.model.jpa.entities.PhasePK;
import co.edu.sena.eon_jpa.model.jpa.entities.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class PhaseDaoImpl extends AbstractDao<Phase> implements PhaseDao<Phase> {

    public PhaseDaoImpl(Class entityClass) {
        super(entityClass);
    }

    @Override
    public List<Phase> findByNamePhase(String name_Phase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByNamePhase");
            query.setParameter("namePhase", name_Phase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByState(boolean State) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByState");
            query.setParameter("State", State);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByLikeNamePhase(String name_Phase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByLikeNamePhase");
            query.setParameter("namePhase", name_Phase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByLikeCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByLikeCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(PhasePK llaveNueva, PhasePK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Phase.updatePrimaryKey");
                query.setParameter("nameNuevo", llaveNueva.getNamePhase());
                query.setParameter("CodeNuevo", llaveNueva.getCode());
                query.setParameter("nameViejo", llaveVieja.getNamePhase());
                query.setParameter("CodeViejo", llaveVieja.getCode());
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
