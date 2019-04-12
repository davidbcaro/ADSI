/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao;

import co.edu.sena.eondao.modelo.dto.ProgramPkDTO;
import co.edu.sena.eondao.modelo.dto.TrainingLevelDTO;
import java.util.Collection;

/**
 *
 * @author LUISBERNARDO
 */
public interface TrainingLevelDAO {
    public int insert(TrainingLevelDTO training);
    public int update(TrainingLevelDTO training, String primaryKey);
    public int delete(String primaryKey);
    public Collection<TrainingLevelDTO> findAll();
    public TrainingLevelDTO findPk(String primaryKey);
}
