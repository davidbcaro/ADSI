/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycd.modelo.DTO.LevelFormationDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface LevelFormationDAO {

    public int insert(LevelFormationDTO levelFormation);

    public int update(LevelFormationDTO levelFormation, String key);

    public int delete(String key);

    public Collection<LevelFormationDTO> findAll();

    public LevelFormationDTO findPk(String key);
}
