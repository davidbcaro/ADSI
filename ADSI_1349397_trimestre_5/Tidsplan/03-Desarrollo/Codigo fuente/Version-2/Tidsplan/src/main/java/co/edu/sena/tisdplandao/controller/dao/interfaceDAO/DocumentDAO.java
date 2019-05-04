package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.DocumentDTO;

import java.util.Collection;

public interface DocumentDAO {
    public int insert(DocumentDTO document);
    public int update(DocumentDTO document, String key);
    public int delete(String primaryKey);
    public Collection<DocumentDTO> findAll();
    public DocumentDTO findPk(String key);
}
