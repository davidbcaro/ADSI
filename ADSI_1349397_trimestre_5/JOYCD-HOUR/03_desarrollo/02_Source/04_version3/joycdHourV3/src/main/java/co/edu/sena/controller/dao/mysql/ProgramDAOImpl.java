/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ProgramDAO;
import co.edu.sena.model.jpa.entities.Program;
import co.edu.sena.model.jpa.entities.ProgramPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class ProgramDAOImpl extends AbstractDao<Program> implements ProgramDAO<Program> {

    public ProgramDAOImpl(Class<Program> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Program> findByProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Program> findByVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByVersion");
            query.setParameter("version", version);
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
    public List<Program> findByStatus(boolean status) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByStatus");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeProgramCode(String programCode) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeProgramCode");
            query.setParameter("programCode", programCode);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;

    }

    @Override
    public List<Program> findLikeByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeName");
            query.setParameter("name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());

        }
        return null;
    }

    @Override
    public List<Program> findByLikeVersion(String version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeVersion");
            query.setParameter("version", version);
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
    public List<Program> findByLikeLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeLevelFormation");
            query.setParameter("levelFormation", levelFormation);
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

                Query query = this.em.createNamedQuery("Program.updatePrimaryKey");
                query.setParameter("codigoNuevo", llaveNueva);
                query.setParameter("codigoAntiguo", llaveVieja);
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
