package co.edu.sena.eondao.controller.dao;

import co.edu.sena.eondao.modelo.dto.DocumentDTO;
import java.util.Collection;


/**
 *
 * @author 1349397
 */
public interface DocumentDAO{
    public int insert(DocumentDTO documento);
    public int update(DocumentDTO documento, String primaryKey);
    public int delete(String primaryKey);
    public Collection<DocumentDTO>findAll();
    public DocumentDTO findPk(String primaryKey);
   
}
