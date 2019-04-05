/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Edition;
import co.edu.sena.cot.modelo.dto.EditionPK;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface EditionDao <T extends Edition> extends InterfaceDao<T> {
    
    public List <T> findByIdEdition (int idEdition);   
    public List <T> findByLikeIdEdition (String idEdition);  
    public List <T> findByIdTrimester (String idTrimester);  
    public List <T> findByLikeTrimester (String idTrimester);  
    
    public int updatePK(EditionPK  llaveNueva, EditionPK llaveVieja);
    
}
