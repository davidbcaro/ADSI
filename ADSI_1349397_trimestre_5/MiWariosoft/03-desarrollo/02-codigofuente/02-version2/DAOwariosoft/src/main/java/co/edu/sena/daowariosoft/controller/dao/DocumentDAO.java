/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;


import co.edu.sena.daowariosoft.model.dto.DocumentDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface DocumentDAO {
    public int insert(DocumentDTO document);
    public int update(DocumentDTO document, String llavePrimaria);
    public int delete(String llavePrimaria);
    public Collection<DocumentDTO> findAll();
    public DocumentDTO findPk(String llavePrimaria);
}
