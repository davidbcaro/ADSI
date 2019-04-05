/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Document;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface DocumentDao <T extends Document> extends InterfaceDao <T> {
    
    public List<T> findByDocument(String document);

    public List<T> findByName(String name);

    public List<T> findByState(boolean state);

    public List<T> findByLikeDocument(String document);

    public List<T> findByLikeName(String name);
    
    public int updatePK(String llaveNueva, String llaveVieja);
}
