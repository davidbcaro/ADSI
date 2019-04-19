/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.SpecialityDTO;
import java.util.Collection;


/**
 *
 * @author 1349397
 */
public interface SpecialityDAO {
    
    public int insert(SpecialityDTO peciality);
    public int update(SpecialityDTO speciality,String primaryKey);
    public int delete(String primaryKey);
    public Collection <SpecialityDTO> findAll();
    public SpecialityDTO findPk(String primaryKey);
    

    
}
