/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterDao;
import co.edu.sena.cot.modelo.dto.Trimester;
import co.edu.sena.cot.modelo.dto.TrimesterPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
public class TrimesterImpl extends AbstractDao<Trimester> implements TrimesterDao<Trimester> {

    public TrimesterImpl(Class<Trimester> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Trimester> findByNumber(int number) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByNumber");
            query.setParameter("number", number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Trimester> findByInitials(String initials) {
          try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    
    }

    @Override
    public List<Trimester> findByCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    
    }

    @Override
    public List<Trimester> findByLikeNumber(String number) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.trimester t WHERE number LIKE ?;", Trimester.class) ;
            query.setParameter(1, number);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Trimester> findByLikeInitials(String initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public List<Trimester> findByLikeCode(String code) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Trimester.findByLikeCode");
            query.setParameter("code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }

    @Override
    public int updatePrimaryKey(TrimesterPK llaveNueva, TrimesterPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Trimester.updatePK");
                query.setParameter("NumberNew", llaveNueva.getNumber());
                query.setParameter("InitialsNew", llaveNueva.getInitials());
                query.setParameter("CodeNew", llaveNueva.getCode());
                
                query.setParameter("NumberOld", llaveVieja.getNumber());
                query.setParameter("InitialsOld", llaveVieja.getInitials());
                query.setParameter("CodeOld", llaveVieja.getCode());
                
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
