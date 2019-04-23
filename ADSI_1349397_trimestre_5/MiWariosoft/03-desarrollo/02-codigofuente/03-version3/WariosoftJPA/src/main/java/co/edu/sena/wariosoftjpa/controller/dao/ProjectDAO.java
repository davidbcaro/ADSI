package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Project;
import java.util.List;

public interface ProjectDAO<T extends Project> extends InterfaceDAO<T> {

    public List<T> findByCode(String code);
    public List<T> findByName(String name);
    public List<T> findByState(boolean state);
    public List<T> findByLikeCode(String code);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
