/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.TrimesterDTO;
import co.edu.sena.chronooftimedao.modelo.dto.TrimesterPkDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface TrimesterDAO {

    public int insert(TrimesterDTO trimesterDTO);
    public int update(TrimesterDTO trimesterDTO,TrimesterPkDTO primaryKey);
    public int delete(TrimesterPkDTO primaryKey);
    public Collection<TrimesterDTO> FindAll();
    public TrimesterDTO findPk(TrimesterPkDTO primaryKey);
}

