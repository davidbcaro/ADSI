/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.NumberGroup;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface NumberGroupDao<T extends NumberGroup> extends InterfaceDao<T> {
    
    public List<T> findByNumberGroup (int numberGroup);
    public List<T> findByDateStart (Date dateStart);
    public List<T> findByDateEnd (Date dateEnd);
    public List<T> findByRoute (String route);
    public List<T> findByState (boolean state);
    public List<T> findByProgramCode (int programCode);
    public List<T> findByProgramEdition (String programEdition);
    public List<T> findByLikeNumberGroup (String numberGroup);
    public List<T> findByLikeRoute (String route);
    public List<T> findByLikeProgramCode (String programCode);
    public List<T> findByLikeProgramEdition (String programEdition);
    public int updatePrimaryKey(int llaveNueva, int llaveVieja);
    
}
