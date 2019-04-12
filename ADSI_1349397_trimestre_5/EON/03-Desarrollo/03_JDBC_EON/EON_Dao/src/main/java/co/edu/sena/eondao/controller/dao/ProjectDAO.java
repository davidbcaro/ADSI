package co.edu.sena.eondao.controller.dao;


import co.edu.sena.eondao.modelo.dto.ProjectDTO;
import java.util.Collection;

public interface ProjectDAO {
    public int insert(ProjectDTO project);
    public int update(ProjectDTO project, String llavePrimaria);
    public int delete(String llavePrimaria);
    public Collection<ProjectDTO> findAll();
    public ProjectDTO findPK(String llavePrimaria);
}
