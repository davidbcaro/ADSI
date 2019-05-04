package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.ProjectDTO;

import java.util.Collection;

public interface ProjectDAO {

    public int insert(ProjectDTO project);
    public int update(ProjectDTO project, String key);
    public int delete(String key);
    public Collection<ProjectDTO> findAll();
    public ProjectDTO findPk(String key);

}

