package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.ProjectPhaseDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ProjectPhasePkDTO;

import java.util.Collection;

public interface ProjectPhaseDAO {

    public int insert(ProjectPhaseDTO projectPhase);
    public int update(ProjectPhaseDTO projectPhase, ProjectPhasePkDTO primarykey);
    public int delete(ProjectPhasePkDTO primarykey);
    public Collection<ProjectPhaseDTO> findAll();
    public ProjectPhaseDTO findPk(ProjectPhasePkDTO primarykey);

}

