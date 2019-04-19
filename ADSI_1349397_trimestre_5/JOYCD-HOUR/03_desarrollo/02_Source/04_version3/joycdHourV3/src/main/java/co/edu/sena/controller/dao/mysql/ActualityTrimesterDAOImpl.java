/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ActualityTrimesterDAO;
import co.edu.sena.model.jpa.entities.ActualityTrimester;
//import static co.edu.sena.model.jpa.entities.GroupNumber_.startDate;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ActualityTrimesterDAOImpl extends AbstractDao<ActualityTrimester> implements ActualityTrimesterDAO<ActualityTrimester> {

    public ActualityTrimesterDAOImpl(Class< ActualityTrimester> entityClass) {
        super(entityClass);
    }

    @Override
    public List<ActualityTrimester> findByActualityTrimester(String ActualityTrimester) {
       try {
                this.getEntityManager();
                Query query = this.em.createNamedQuery("ActualityTrimester.findByActualityTrimester");
                query.setParameter("ActualityTrimester", ActualityTrimester);
                return query.getResultList();
            } catch (PersistenceException e) {
                System.out.println("Exception:" + e.getMessage());
            }
            return null;
    }

//    @Override
//    public List<ActualityTrimester> findByStartDate(Date StartDate) {
//        try {
//                this.getEntityManager();
//                Query query = this.em.createNamedQuery("ActualityTrimester.findByStartDate");
//                query.setParameter("startDate", startDate);
//                return query.getResultList();
//            } catch (PersistenceException e) {
//                System.out.println("Exception:" + e.getMessage());
//            }
//            return null;
//
//        }
    

    @Override
    public List<ActualityTrimester> findByFinishDate(Date FinishDate) {
        try {
                this.getEntityManager();
                Query query = this.em.createNamedQuery("ActualityTrimester.findByEndDate");
                query.setParameter("FinishDate", FinishDate);
                return query.getResultList();
            } catch (PersistenceException e) {
                System.out.println("Exception:" + e.getMessage());
            }
            return null;
        }
   
    @Override
    public List<ActualityTrimester> findByLikeActualityTrimester(String ActualityTrimester) {
         try {
                this.getEntityManager();
                Query query = this.em.createNativeQuery("SELECT * FROM actuality_trimester s WHERE s.actuality_trimester LIKE '2' ", ActualityTrimester.class);
                query.setParameter("ActualityTrimester", ActualityTrimester);
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

    @Override
    public List<ActualityTrimester> findByStartDate(Date startDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
