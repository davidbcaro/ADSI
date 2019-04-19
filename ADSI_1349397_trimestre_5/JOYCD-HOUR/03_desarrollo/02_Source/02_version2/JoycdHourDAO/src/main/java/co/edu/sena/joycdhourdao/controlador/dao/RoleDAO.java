/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.RoleDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface RoleDAO {
    public int insert(RoleDTO role);
    public int update(RoleDTO role, String key);
    public int delete(String key);
    public Collection<RoleDTO> findAll();
    public RoleDTO findPk(String key);
    
}
