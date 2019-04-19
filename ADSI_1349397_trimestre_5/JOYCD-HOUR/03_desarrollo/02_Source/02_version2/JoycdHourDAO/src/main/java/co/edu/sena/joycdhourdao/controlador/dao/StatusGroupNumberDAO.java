/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.StatusGroupNumberDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface StatusGroupNumberDAO {
    public int insert(StatusGroupNumberDTO statusgroup);
    public int update(StatusGroupNumberDTO statusgroup,String primaryKey);
    public int delete(String primaryKey);
    public Collection <StatusGroupNumberDTO> findAll();
    public StatusGroupNumberDTO findPk(String primaryKey);
    
    
}
