/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ProgramDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Program;
import co.edu.sena.eon_jpa.model.jpa.entities.ProgramPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author LUISBERNARDO
 */
public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao<Program> {

    public ProgramDaoImpl(Class entityClass) {
        super(entityClass);
    }

    @Override
    public List<Program> findByCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByVersion(String Version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByName(String Name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByName");
            query.setParameter("Name", Name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByInitials(String Initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByInitials");
            query.setParameter("Initials", Initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByState(boolean State) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByState");
            query.setParameter("State", State);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByTrainingLevel(String training_Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByTrainingLevel");
            query.setParameter("TrainingLevel", training_Level);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeCode(String Code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeCode");
            query.setParameter("Code", Code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeVersion(String Version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeVersion");
            query.setParameter("Version", Version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeName(String Name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeName");
            query.setParameter("Name", Name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeInitials(String Initials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeInitials");
            query.setParameter("Initials", Initials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeTrainingLevel(String training_Level) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeTrainingLevel");
            query.setParameter("TrainingLevel", training_Level);
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
                query.setParameter("CodeNuevo", llaveNueva.getProgramCode());
                query.setParameter("VersionNuevo", llaveNueva.getVersion());
                query.setParameter("CodeViejo", llaveVieja.getProgramCode());              
                query.setParameter("VersionViejo", llaveVieja.getVersion());           
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
