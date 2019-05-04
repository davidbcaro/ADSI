package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.SpecialityDTO;

import java.util.Collection;

public interface SpecialityDAO {

    public int insert(SpecialityDTO  speciality);
    public int update(SpecialityDTO specialityDTO, String primaryKey);
    public int delete(String primaryKey);
    public Collection<SpecialityDTO> findAll();
    public SpecialityDTO findPk(String primaryKey);

}
