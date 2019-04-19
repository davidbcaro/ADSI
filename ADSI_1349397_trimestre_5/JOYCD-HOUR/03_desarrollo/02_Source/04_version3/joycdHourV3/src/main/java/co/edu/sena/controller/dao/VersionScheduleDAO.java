/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.VersionSchedule;
import co.edu.sena.model.jpa.entities.VersionSchedulePK;
import java.util.List;

/**
 *
 * @author PCK
 */
public interface VersionScheduleDAO<T extends VersionSchedule> extends InterfaceDao<T> {

    public List<VersionSchedule> findByVersion(int version);

    public List<VersionSchedule> findByStatusVersion(boolean statusVersion);

    public List<VersionSchedule> findByActualityTrimester(String actualityTrimester);

    public int updatePrimaryKey(VersionSchedulePK llaveNueva, VersionSchedulePK llaveVieja);
}
