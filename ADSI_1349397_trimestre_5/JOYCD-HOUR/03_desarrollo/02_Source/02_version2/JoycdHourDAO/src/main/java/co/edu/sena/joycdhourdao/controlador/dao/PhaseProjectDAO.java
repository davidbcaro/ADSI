/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;


import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectDTO;
import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectPkDTO;
import java.util.Collection;

/**
 *
 * @author SENA
 */
public interface PhaseProjectDAO {
    
    public int insert(PhaseProjectDTO phase);
    public int update(PhaseProjectDTO  phase, PhaseProjectPkDTO keyPrimaria);
    public int delete(PhaseProjectPkDTO key);
    public Collection<PhaseProjectDTO> findAll();
    public PhaseProjectDTO findPk(PhaseProjectPkDTO key);

}


