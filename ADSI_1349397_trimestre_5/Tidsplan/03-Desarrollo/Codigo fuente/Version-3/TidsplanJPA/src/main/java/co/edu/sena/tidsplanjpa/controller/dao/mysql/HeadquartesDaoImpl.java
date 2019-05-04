package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.HeadquartesDao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Headquartes;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class HeadquartesDaoImpl extends AbstractDao<Headquartes> implements HeadquartesDao<Headquartes> {

    public HeadquartesDaoImpl(Class<Headquartes> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Headquartes> findByNameHeadquares(String nameHeadquares) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Headquartes.findByNameHeadquartes");
            que.setParameter("nameHeadquartes", nameHeadquares);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquartes> findByAddress(String address) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Headquartes.findByAddress");
            que.setParameter("address", address);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquartes> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquartes.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquartes> findByLikeNameHeadquares(String nameHeadquares) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Headquartes.findByLikeNameHeadquartes");
            que.setParameter("headquartes", nameHeadquares);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Headquartes> findByLikeAddress(String address) {
        try {
            this.getEntityManager();
            Query que = this.em.createNamedQuery("Headquartes.findByLikeAddress");
            que.setParameter("address", address);
            return que.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String newKey, String oldKey) {
        try {
            this.getEntityManager();

            if(this.find(oldKey)!=null){

                Query query = this.em.createNamedQuery("Headquartes.updatePrimaryKey");
                query.setParameter("newName", newKey );
                query.setParameter("oldName", oldKey );
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

    @Override
    public List<Headquartes> findAll() {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Headquartes.findAll");
            return query.getResultList();

        } catch (PersistenceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
