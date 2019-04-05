/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.PhaseDao;
import co.edu.sena.cot.modelo.dto.Phase;
import co.edu.sena.cot.modelo.dto.PhasePK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Camargo
 */
public class PhaseDaoImpl extends AbstractDao<Phase> implements PhaseDao<Phase> {

    public PhaseDaoImpl(Class<Phase> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Phase> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByLikeName(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByLikeName");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Phase> findByLikeCode(String codeProject) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM phase p  WHERE p.projectCode LIKE ? ", Phase.class);
            query.setParameter(1, codeProject);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(PhasePK llaveNueva, PhasePK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Phase.updatePK");
                query.setParameter("PhaseNew", llaveNueva.getNamePhase());
                query.setParameter("PhaseNew2", llaveNueva.getProjectCode());
                query.setParameter("PhaseOld", llaveVieja.getNamePhase());
                query.setParameter("PhaseOld2", llaveVieja.getProjectCode());
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

    @Override
    public List<Phase> findByName(String namePhase) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByName");
            query.setParameter("namePhase", namePhase);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
                
            }

    @Override
    public List<Phase> findByCode(int codeProject) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Phase.findByCode");
            query.setParameter("projectCode", codeProject);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
}
