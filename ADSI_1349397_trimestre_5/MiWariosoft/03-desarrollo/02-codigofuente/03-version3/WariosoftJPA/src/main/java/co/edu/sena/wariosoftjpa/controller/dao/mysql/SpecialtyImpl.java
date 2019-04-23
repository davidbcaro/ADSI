/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.SpecialtyDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Specialty;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class SpecialtyImpl extends AbstractDAO<Specialty> implements SpecialtyDAO<Specialty> {

    public SpecialtyImpl(Class<Specialty> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Specialty> findByNameSpecialty(String nameSpecialty) {
    try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Specialty.findByNameSpecialty");
            query.setParameter("NameSpecialty", nameSpecialty);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Specialty> findByState(boolean state) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Specialty.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;   
    
    }

    @Override
    public List<Specialty> findByLikeNameSpecialty(String nameSpecialty) {
  try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Specialty.findByLikeNameSpecialty");
            query.setParameter("NameSpecialty", nameSpecialty);
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
            
            Query query = this.em.createNamedQuery("Specialty.updatePk");
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
