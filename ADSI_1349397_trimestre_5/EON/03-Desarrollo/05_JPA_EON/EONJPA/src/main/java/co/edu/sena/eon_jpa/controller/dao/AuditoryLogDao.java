/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.AuditoryLog;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <a>
 */
public interface AuditoryLogDao <a extends AuditoryLog> extends InterfaceDao<a>{
    public List<a> findByLevel(String Level);
    public List<a> findByLogName(String logName);
    public List<a> findByMessage(String Message);
    public List<a> findByDate(Date Date);
    public List<a> findByUser(String User);
    public List<a> findByLikeLevel(String Level);
    public List<a> findByLikeLogName(String logName);
    public List<a> findByLikeMessage(String Message);
    public List<a> findByLikeUser(String User);
    public int updatePrimaryKey(long llaveNueva, long llaveVieja);
}
