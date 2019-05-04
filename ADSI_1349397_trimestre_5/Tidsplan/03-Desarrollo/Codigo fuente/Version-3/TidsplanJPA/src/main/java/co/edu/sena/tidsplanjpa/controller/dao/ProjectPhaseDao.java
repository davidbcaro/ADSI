
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhase;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhasePK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface ProjectPhaseDao <T extends ProjectPhase> extends InterfaceDao<T>{
    public List<T> findByNamePhase(String namePhase);
    public List<T> findByLikeNamePhase(String namePhase);
    public List<T> findByProjectCode(String projectCode);
    public List<T> findByLikeProjectCode(String projectCode);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(ProjectPhasePK newKey, ProjectPhasePK oldKey);
    
}
