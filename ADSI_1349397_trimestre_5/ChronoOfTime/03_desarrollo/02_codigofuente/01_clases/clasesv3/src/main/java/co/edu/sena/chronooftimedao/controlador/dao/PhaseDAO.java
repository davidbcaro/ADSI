/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.PhaseDTO;
import co.edu.sena.chronooftimedao.modelo.dto.PhasePkDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface PhaseDAO {
    
    public int insert(PhaseDTO phase);
    public int update(PhaseDTO phase, PhasePkDTO primaryKey);
    public int delete(PhasePkDTO primaryKey);
    public Collection<PhaseDTO> findAll();
    public PhaseDTO findPk(PhasePkDTO primaryKey);
    
}
