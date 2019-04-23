/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ProgramPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface ProgramDAO<T extends Program> extends InterfaceDAO<T> {

    public List<T> findByCode(String code);
    public List<T> findByLikeCode(String code);

    public List<T> findByName(String name);

    public List<T> findByVersion(String version);
    public List<T> findByLikeVersion(String version);

    public List<T> findByInitials(String initials);

    public List<T> findByState(Boolean state);

    public List<T> findByTrainingLevel(String traininglevel);
    public List<T> findByLikeTrainingLevel(String traininglevel);

    public int updatePk(ProgramPK llaveNueva, ProgramPK llaveVieja);

}
