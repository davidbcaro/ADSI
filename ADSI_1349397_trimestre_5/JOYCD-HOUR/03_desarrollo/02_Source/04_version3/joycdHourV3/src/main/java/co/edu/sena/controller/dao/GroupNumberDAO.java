/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.GroupNumber;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface GroupNumberDAO<T extends GroupNumber> extends InterfaceDao<T> {

    public List<GroupNumber> findByGroupsNumber(String groupsNumber);
    public List<GroupNumber> findByStartDate(Date startDate);
    public List<GroupNumber> findByFinishDate(Date finishDate);   
    public List<GroupNumber> findByRoute(char route);
    public List<GroupNumber> findByProgramCode(String programCode);
    public List<GroupNumber> findByVersionCode(String versionCode);   
    public List<GroupNumber> findByStatusGroupNumber(String statusGroupNumber); 
 
    public List<GroupNumber> findByLikeGroupsNumber(String groupsNumber);
    public List<GroupNumber> findByLikeProgramCode(String programCode);
    public List<GroupNumber> findByLikeVersionCode(String versionCode);   
    public List<GroupNumber> findByLikeStatusGroupNumber(String statusGroupNumber); 
    
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);

}
