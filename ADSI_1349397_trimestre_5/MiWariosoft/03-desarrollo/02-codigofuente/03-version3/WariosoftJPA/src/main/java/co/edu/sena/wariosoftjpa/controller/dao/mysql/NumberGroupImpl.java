/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.NumberGroupDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroup;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class NumberGroupImpl extends AbstractDAO<NumberGroup> implements NumberGroupDAO<NumberGroup> {

    public NumberGroupImpl(Class<NumberGroup> entityClass) {
        super(entityClass);
    }

    @Override
    public List<NumberGroup> findByNumberGroup(String numberGroup) {
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
    public List<NumberGroup> findByStartDate(Date startDate) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByStartDate");
            query.setParameter("startDate", startDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<NumberGroup> findByEndDate(Date endDate) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByEndDate");
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
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
            System.out.println("Exception:" + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<NumberGroup> findByNameState(String nameState) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByNameState");
            query.setParameter("nameState", nameState);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<NumberGroup> findByProgramCode(String programCode) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<NumberGroup> findByVersion(String version) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<NumberGroup> findByLikeNameState(String nameState) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByNameState");
            query.setParameter("nameState", nameState);
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
            Query query = this.em.createNamedQuery("NumberGroup.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;    
    }

    @Override
    public List<NumberGroup> findByLikeVersion(String version) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("NumberGroup.findByLikeVersion");
            query.setParameter("version", version);
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
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("NumberGroup.updatePk");
            query.setParameter("documentoNuevo", llaveNueva );
            query.setParameter("documentoViejo", llaveVieja );
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
