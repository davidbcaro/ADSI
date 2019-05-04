package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.ActivityDTO;
import co.edu.sena.tisdplandao.model.dto.FormationLevelDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ActivityPkDTO;

import java.util.Collection;

public interface FormationLevelDAO {

    public int insert(FormationLevelDTO formationlevel);
    public int update(FormationLevelDTO formationlevel, String primarykey);
    public int delete(String primarykey);
    public Collection<FormationLevelDTO> findAll();
    public FormationLevelDTO findPk(String primarykey);

}


