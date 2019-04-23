/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.PhaseDTO;
import co.edu.sena.daowariosoft.model.dto.PhasePkDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface PhaseDAO {
    public int insert(PhaseDTO phase);
    public int update(PhaseDTO phase, PhasePkDTO llavePrimaria);
    public int delete(PhasePkDTO llavePrimaria);
    public Collection<PhaseDTO> findAll();
    public PhaseDTO findPk(PhasePkDTO llavePrimaria);
}
