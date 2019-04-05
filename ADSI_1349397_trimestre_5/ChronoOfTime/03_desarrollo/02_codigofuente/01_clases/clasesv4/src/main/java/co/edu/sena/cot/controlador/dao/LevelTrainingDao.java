/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.LevelTrainig;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LevelTrainingDao <T extends LevelTrainig> extends InterfaceDao<T> {
    
    public List<T> findByState (boolean state);
    public List<T> findByLikeCode (String code);
    public int updatePK(String llaveNueva, String llaveVieja);
    
}
