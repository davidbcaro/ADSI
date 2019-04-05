/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ProgramDao;
import co.edu.sena.cot.modelo.dto.Program;
import co.edu.sena.cot.modelo.dto.ProgramPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author 1349397
 */
public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao<Program> {
    
    public ProgramDaoImpl(Class<Program> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Program> findByCodeProgram(int codeProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByCodeProgram");
            query.setParameter("codeProgram", codeProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByNameProgram(String nameProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByNameProgram");
            query.setParameter("nameProgram", nameProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByEdition(String edition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByEdition");
            query.setParameter("edition", edition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByInitials(String initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByState(String state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByState");
            query.setParameter("state", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLevelTraCode(String levelTraCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLevelTraCode");
            query.setParameter("levelTraCode", levelTraCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeCodeProgram(String codeProgram) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Program> findByLikeNameProgram(String nameProgram) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeNameProgram");
            query.setParameter("nameProgram", nameProgram);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> finfByLikeEdition(String edition) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.finfByLikeEdition");
            query.setParameter("edition", edition);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeInitials(String initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeInitials");
            query.setParameter("initials", initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeLevelTraCode(String levelTraCode) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeLevelTraCode");
            query.setParameter("levelTraCode", levelTraCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(ProgramPK llaveNueva, ProgramPK llaveVieja) {
        try {
            this.getEntityManager();

            if (this.find(llaveVieja) != null) {

                Query query = this.em.createNamedQuery("Program.updatePK");
                query.setParameter("ProgramNew", llaveNueva.getCodeProgram());
                query.setParameter("ProgramNew2", llaveNueva.getEdition());
                query.setParameter("ProgramOld", llaveVieja.getCodeProgram());
                query.setParameter("ProgramOld2", llaveVieja.getEdition());
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
