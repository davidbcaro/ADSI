/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EditionDao;
import co.edu.sena.cot.modelo.dto.Edition;
import co.edu.sena.cot.modelo.dto.EditionPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Natsumi
 */
public class EditionDaoImpl extends AbstractDao<Edition> implements EditionDao<Edition> {
    
    public EditionDaoImpl(Class<Edition> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Edition> findByIdEdition(int idEdition) {
      try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Edition.findByIdEdition");
            query.setParameter("ideEdition", idEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;    
    }

    @Override
    public List<Edition> findByLikeIdEdition(String idEdition) {
         try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.edition e WHERE ide_edition LIKE ?;", Edition.class);
            query.setParameter(1, idEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Edition> findByIdTrimester(String idTrimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Edition.findByIdTrimester");
            query.setParameter("idTrimester", idTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;   
    }

    @Override
    public List<Edition> findByLikeTrimester(String idTrimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Edition.findByLikeIdTrimester");
            query.setParameter("idTrimester", idTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePK(EditionPK llaveNueva, EditionPK llaveVieja) {
             try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Edition.updatePK");
                query.setParameter("IdTrimesterNew", llaveNueva.getIdTrimester());
                query.setParameter("IdeEditionNew", llaveNueva.getIdeEdition());
               
                query.setParameter("IdTrimesterOld", llaveVieja.getIdTrimester());
                query.setParameter("IdeEditionOld", llaveVieja.getIdeEdition());
                
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
