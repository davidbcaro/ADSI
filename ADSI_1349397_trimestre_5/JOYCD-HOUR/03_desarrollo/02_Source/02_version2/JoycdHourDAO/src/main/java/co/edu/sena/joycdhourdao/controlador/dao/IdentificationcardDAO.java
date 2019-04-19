/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.IdentificationcardDTO;
import java.util.Collection;

/**
 *
 * @author Usser
 */
public interface  IdentificationcardDAO {
    public int insert(IdentificationcardDTO identificationcard);
    public int update(IdentificationcardDTO identificationcard,String Key);
    public int delete(String Key);
    public Collection <IdentificationcardDTO> findAll();
    public IdentificationcardDTO findPk(String Key);
    
}
