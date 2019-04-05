/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.NumberGroupDao;
import co.edu.sena.cot.modelo.dto.NumberGroup;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class NumberGroupImpl extends AbstractDao<NumberGroup> implements NumberGroupDao<NumberGroup>  {
    
    public NumberGroupImpl(Class<NumberGroup> entityClass) {
        super(entityClass);
    }

    @Override
    public List<NumberGroup> findByNumberGroup(int numberGroup) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByNumberGroup");
            query.setParameter("numberGroup", numberGroup);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByDateStart(Date dateStart) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByDateStart");
            query.setParameter("dateStart", dateStart);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByDateEnd(Date dateEnd) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByDateEnd");
            query.setParameter("dateEnd", dateEnd);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByRoute(String route) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByRoute");
            query.setParameter("route", route);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByProgramCode(int programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByProgramCode");
            query.setParameter("codeProgram", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByProgramEdition(String programEdition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByProgramEdition");
            query.setParameter("programEdition", programEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByLikeNumberGroup(String numberGroup) {
       try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.number_group n WHERE number_group LIKE ?;", NumberGroup.class) ;
            query.setParameter(1, numberGroup);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByLikeRoute(String route) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByLikeRoute");
            query.setParameter("route", route);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM cot.number_group n WHERE program_code LIKE ?;", NumberGroup.class);
            query.setParameter(1, programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NumberGroup> findByLikeProgramEdition(String programEdition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByLikeProgramEdition");
            query.setParameter("programEdition", programEdition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(int llaveNueva, int llaveVieja) {
       try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("NumberGroup.updatePk");
            query.setParameter("GroupNew", llaveNueva );
            query.setParameter("GroupOld", llaveVieja );
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
    
}
