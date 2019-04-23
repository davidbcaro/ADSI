package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.ProjectDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Project;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ProjectImpl extends AbstractDAO<Project> implements ProjectDAO<Project> {

    public ProjectImpl(Class<Project> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Project> findByCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByCode");
            query.setParameter("Code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Project> findByName(String name) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByName");
            query.setParameter("Name", name);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Project> findByState(boolean state) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByState");
            query.setParameter("State", state);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Project> findByLikeCode(String code) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Project.findByLikeCode");
            query.setParameter("Code", code);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePrimaryKey(String llaveNueva, String llaveVieja) {
        try {
            this.getEntityManager();
            if (this.find(llaveVieja) != null) {
                Query query = this.em.createNamedQuery("Project.updatePrimaryKey");
                query.setParameter("codigoNuevo", llaveNueva);
                query.setParameter("codigoViejo", llaveVieja);
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
