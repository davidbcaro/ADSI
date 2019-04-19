/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.HeadquartersDTO;
import java.util.Collection;

/**
 *
 * @author liosalfar
 */
public interface HeadquartersDAO {
    
    public int insert(HeadquartersDTO head);
    public int update(HeadquartersDTO head,String primaryKey);
    public int delete(String primaryKey);
    public Collection <HeadquartersDTO> findAll();
    public HeadquartersDTO findPk(String primaryKey);
    
}
