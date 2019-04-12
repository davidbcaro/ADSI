/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay;
import java.util.List;

/**
 *
 * @author Telegrafia01
 * @param <W>
 */
public interface WorkingDayDao <W extends WorkingDay>extends InterfaceDao <W> {
    
    public List<W> findByName(String name);

    public List<W> findByLikeName(String name);

    public List<W> findByDescription(String description);

    public List<W> findByLikeDescription(String description);

    public List<W> findByState(Boolean state);

    public List<W> findByAcronymsWorkingDay(String acronymsWorkingDay);

    public List<W> findByLikeAcronymsWorkingDay(String acronymsWorkingDay);

    public int updatePrimaryKey(String NuevoAcronim, String ViejoAcronim);
}
