/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.LogError;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <l>
 */
public interface LogErrorDao <l extends LogError> extends InterfaceDao<l>{
    public List<l> findByLevel(String Level);
    public List<l> findByLogName(String logName);
    public List<l> findByMessage(String Message);
    public List<l> findByDate(Date Date);
    public List<l> findByUser(String User);
    public List<l> findByLikeLevel(String Level);
    public List<l> findByLikeLogName(String logName);
    public List<l> findByLikeMessage(String Message);
    public List<l> findByLikeUser(String User);
    public int updatePrimaryKey(long llaveNueva, long llaveVieja);
}
