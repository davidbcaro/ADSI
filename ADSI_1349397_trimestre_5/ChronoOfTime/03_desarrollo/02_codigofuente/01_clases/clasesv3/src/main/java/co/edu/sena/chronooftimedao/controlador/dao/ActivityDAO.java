/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.ActivityDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ActivityPkDTO;
import java.util.Collection;

/**
 *
 * @author Jorge
 */
public interface ActivityDAO {
    
    public int insert(ActivityDTO activitydto);
    public int update(ActivityDTO activitydto, ActivityPkDTO primaryKey);
    public int delete(ActivityPkDTO primaryKey);
    public Collection<ActivityDTO> findAll();
    public ActivityDTO findPk(ActivityPkDTO primaryKey);
}
