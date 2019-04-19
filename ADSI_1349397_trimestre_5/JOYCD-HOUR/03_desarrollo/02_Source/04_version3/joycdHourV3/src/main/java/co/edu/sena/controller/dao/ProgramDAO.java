/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Program;
import co.edu.sena.model.jpa.entities.ProgramPK;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface ProgramDAO<T extends Program> extends InterfaceDao<T> {

    public List<Program> findByProgramCode(String programCode);

    public List<Program> findByName(String name);

    public List<Program> findByVersion(String version);

    public List<Program> findByInitials(String initials);

    public List<Program> findByStatus(boolean status);

    public List<Program> findByLevelFormation(String levelFormation);

    public List<Program> findByLikeProgramCode(String programCode);

    public List<Program> findLikeByName(String name);

    public List<Program> findByLikeVersion(String version);

    public List<Program> findByLikeInitials(String initials);

    public List<Program> findByLikeLevelFormation(String levelFormation);

    public int updatePrimaryKey(ProgramPK llaveNueva, ProgramPK llaveVieja);
}
