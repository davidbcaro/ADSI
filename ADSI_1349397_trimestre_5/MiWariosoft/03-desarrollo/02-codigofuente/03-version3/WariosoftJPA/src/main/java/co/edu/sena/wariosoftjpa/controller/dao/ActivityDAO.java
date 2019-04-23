/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Activity;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ActivityPK;
import java.util.List;

/**
 *
 * @author WINDOWS 8
 * @param <T>
 */
public interface ActivityDAO<T extends Activity> extends InterfaceDAO<T> {

    public List<T> findByIdActivity(int idActivity);

    public List<T> findByNameActivity(String nameActivity);

    public List<T> findByNamePhase(String namePhase);

    public List<T> findByProjectCode(String projectCode);

    public List<T> findByLikeIdActivity(int idActivity);

    public List<T> findByLikeProjectCode(String projectCode);

    public List<T> findByLikeNameActivity(String nameActivity);

    public int updatePk(ActivityPK llaveNueva, ActivityPK llaveVieja);

}
