
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.BondingDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Bonding;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Liliana Narvaez
 */
public class BondingDaoImpl extends AbstractDao<Bonding> implements BondingDao<Bonding> {

    public BondingDaoImpl(Class<Bonding> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Bonding> findByLiketypeLinkage(String typeLinkage) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByliketypeLinkage");
            query.setParameter("typeLinkage", typeLinkage);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Bonding> findBytypeLinkage(String typeLinkage) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByTypeLinkage");
            query.setParameter("typeLinkage", typeLinkage);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Bonding> findByHours(int hours) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByHours");
            query.setParameter("hours", hours);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Bonding> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Bonding.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;

    }

    @Override
    public int updatePrimaryKey(String specialityNuevo, String specialityViejo) {
        try {
            this.getEntityManager();

            if (this.find(specialityViejo) != null) {

                Query query = this.em.createNamedQuery("Bonding.updatePrimaryKey");
                query.setParameter("typeLinkageNuevo", specialityNuevo);
                query.setParameter("typeLinkageViejo", specialityViejo);
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
