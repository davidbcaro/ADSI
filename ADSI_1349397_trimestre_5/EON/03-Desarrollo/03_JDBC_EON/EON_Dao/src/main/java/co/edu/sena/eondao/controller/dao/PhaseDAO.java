package co.edu.sena.eondao.controller.dao;


import co.edu.sena.eondao.modelo.dto.PhaseDTO;
import co.edu.sena.eondao.modelo.dto.PhasePKDTO;
import java.util.Collection;

public interface PhaseDAO {
    public int insert(PhaseDTO phase);
    public int update(PhaseDTO phase, PhasePKDTO llavePrimaria);
    public int delete(PhasePKDTO llave);
    public Collection<PhaseDTO> findAll();
    public PhaseDTO findPk(PhasePKDTO llave);
}
