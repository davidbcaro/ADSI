/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.CurrentQuarterDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CurrentQuarter;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class CurrentQuarterImpl extends AbstractDAO<CurrentQuarter> implements CurrentQuarterDAO<CurrentQuarter> {

    public CurrentQuarterImpl(Class entityClass) {
        super(entityClass);
    }

    @Override
    public List<CurrentQuarter> findByIdCurrentQuarter(String idCurrentQuarter) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByIdCurrentQuarter");
            query.setParameter("IdCurrentQuarter", idCurrentQuarter);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByStartDate(Date StartDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByStartDate");
            query.setParameter("StartDate", StartDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<CurrentQuarter> findByEndDate(Date endDate) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("CurrentQuarter.findByEndDate");
            query.setParameter("EndDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<CurrentQuarter> findByLikeIdCurrentQuarter(String idCurrentQuarter) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Current_Quarter s WHERE s.id_Current_Quarter LIKE '2' ",CurrentQuarter.class);
            query.setParameter("IdCurrentQuarter", idCurrentQuarter);
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

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("CurrentQuarter.updatePk");
                query.setParameter("documentoNuevo", llaveNueva);
                query.setParameter("documentoViejo", llaveVieja);
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
