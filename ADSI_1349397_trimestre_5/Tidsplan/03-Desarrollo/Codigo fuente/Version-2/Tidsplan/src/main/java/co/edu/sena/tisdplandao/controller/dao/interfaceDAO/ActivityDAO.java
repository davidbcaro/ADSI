package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.ActivityDTO;
import co.edu.sena.tisdplandao.model.dto.ProjectPhaseDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ActivityPkDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ProjectPhasePkDTO;

import java.util.Collection;

public interface ActivityDAO {

    public int insert(ActivityDTO activity);
    public int update(ActivityDTO activity, ActivityPkDTO primarykey);
    public int delete(ActivityPkDTO primarykey);
    public Collection<ActivityDTO> findAll();
    public ActivityDTO findPk(ActivityPkDTO primarykey);

}


