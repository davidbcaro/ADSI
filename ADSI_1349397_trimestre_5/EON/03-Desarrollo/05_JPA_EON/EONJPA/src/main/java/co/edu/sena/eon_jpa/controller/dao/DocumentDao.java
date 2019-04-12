/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Document;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <d>
 */
public interface DocumentDao<d extends Document> extends InterfaceDao<d> {

    public List<d> findBylikeidDocument(String idDocument);

    public List<d> findBylikename(String name);

    public List<d> findBystatus(boolean status);

    public List<d> findByidDocument(String idDocument);

    public List<d> findByname(String name);

    public int updatePrimaryKey(String idDocumentNuevo, String idDocumentViejo);
}
