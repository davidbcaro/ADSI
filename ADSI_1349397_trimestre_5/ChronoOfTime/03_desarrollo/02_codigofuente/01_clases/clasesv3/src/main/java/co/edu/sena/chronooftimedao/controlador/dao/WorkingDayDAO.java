/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.WorkingDayDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface WorkingDayDAO {
    public int insert(WorkingDayDTO workingDayDTO);
    
     public int update(WorkingDayDTO workingDayDTO, String primaryKey);

    public int delete(String primaryKey);

    public Collection<WorkingDayDTO> FindAll();

    public WorkingDayDTO findPk(WorkingDayDTO primaryKey);

   
}
