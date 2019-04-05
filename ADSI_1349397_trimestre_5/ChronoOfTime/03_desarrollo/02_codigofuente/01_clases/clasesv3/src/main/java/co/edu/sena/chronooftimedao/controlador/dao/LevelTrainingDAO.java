/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.LevelTrainingDTO;
import java.util.Collection;
/**
 *
 * @author 1349397
 */
public interface LevelTrainingDAO {
    public int insert(LevelTrainingDTO levelTrainingDTO);
    public int update(LevelTrainingDTO levelTrainingDTO, String primaryKey);
    public int delete(String primaryKey);
    public Collection<LevelTrainingDTO>FindAll();
    public LevelTrainingDTO findPk(LevelTrainingDTO primaryKey);
}
