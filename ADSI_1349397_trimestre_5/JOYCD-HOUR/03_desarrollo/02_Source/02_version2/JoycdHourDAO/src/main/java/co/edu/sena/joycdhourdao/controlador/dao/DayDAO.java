/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.DayDTO;
import java.util.Collection;


/**
 *
 * @author 1349397
 */
public interface DayDAO {
    
    public int insert(DayDTO day);
    public int update(DayDTO day,String primaryKey);
    public int delete(String primaryKey);
    public Collection <DayDTO> findAll();
    public DayDTO findPk(String primaryKey);
    

    
}
