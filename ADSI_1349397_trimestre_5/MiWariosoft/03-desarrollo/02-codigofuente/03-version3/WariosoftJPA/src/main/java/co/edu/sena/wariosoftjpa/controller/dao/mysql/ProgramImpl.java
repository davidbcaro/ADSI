package co.edu.sena.wariosoftjpa.controller.dao.mysql;
import co.edu.sena.wariosoftjpa.controller.dao.ProgramDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ProgramPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ProgramImpl extends AbstractDAO<Program> implements ProgramDAO<Program> {

        public ProgramImpl(Class<Program> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Program> findByCode(String code) {
       try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByCode");
            query.setParameter("Code", code);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeCode");
            query.setParameter("Code", code);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<Program> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByName");
            query.setParameter("Name", name);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<Program> findByVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByVersion");
            query.setParameter("Version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeVersion(String version) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByLikeVersion");
            query.setParameter("Version", version);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByInitials(String initials) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByInitials");
            query.setParameter("Initials", initials);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByState(Boolean state) {
         try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByTrainingLevel(String traininglevel) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Program.findByTrainingLevel");
            query.setParameter("TrainingLevel", traininglevel);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Program> findByLikeTrainingLevel(String traininglevel) {
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("Program.findByLikeTrainingLevel");
            query.setParameter("TrainingLevel", traininglevel);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePk(ProgramPK llaveNueva, ProgramPK llaveVieja) {
       try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Program.updatePk");
            
            query.setParameter("codeNuevo", llaveNueva.getProgramCode());
            query.setParameter("versionNueva", llaveNueva.getVersion());
            query.setParameter("codeViejo", llaveVieja.getProgramCode());
            query.setParameter("versionVieja", llaveNueva.getVersion());
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
        return 0;    }
    }
    

