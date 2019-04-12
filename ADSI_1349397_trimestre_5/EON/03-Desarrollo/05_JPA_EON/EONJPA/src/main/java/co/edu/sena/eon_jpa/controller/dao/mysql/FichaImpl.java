/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;


import co.edu.sena.eon_jpa.controller.dao.FichaDao;
import co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK;
import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author SOPORTE
 */
public class FichaImpl extends AbstractDao<Ficha> implements FichaDao<Ficha>{

    public FichaImpl(Class<Ficha> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Ficha> findByNumberFicha(String numberFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByStart(Date startDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByEnd(Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByRoute(Character router) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByProgramCode(String programCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByProgramVersion(String version) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByNameState(String nameState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByLikeNumberFicha(String numberFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByLikeEnd(Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByLikeProgramCode(String programCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByLikeProgramVersion(String numberFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ficha> findByLikeNameState(String numberFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updatePrimaryKey(String nuevoNumberFicha, String viejonumberFicha) {
     try {
            this.getEntityManager();

            if (this.find(viejonumberFicha) != null) {

                Query query = this.em.createNamedQuery("Ficha.updatePrimaryKey");
                query.setParameter("nuevoNumberFicha", nuevoNumberFicha);
                query.setParameter("viejonumberFicha", viejonumberFicha);
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
    

    

