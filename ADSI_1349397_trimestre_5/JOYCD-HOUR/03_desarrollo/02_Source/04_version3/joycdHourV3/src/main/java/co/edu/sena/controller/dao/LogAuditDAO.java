/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.LogAudit;
import java.sql.Clob;
import java.util.Date;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface LogAuditDAO<T extends LogAudit> extends InterfaceDao<T> {

    public List<LogAudit> findByLogAudit(long logAudit);

    public List<LogAudit> findByLevel(String level);

    public List<LogAudit> findByLogName(String logName);

    public List<LogAudit> findByMessage(Clob message);

    public List<LogAudit> findByDate(Date date);

    public List<LogAudit> findByUser(String user);

    public List<LogAudit> findByLikeLogAudit(String logAudit);

    public List<LogAudit> findByLikeLevel(String level);

    public List<LogAudit> findByLikeLogName(String logName);

    public List<LogAudit> findByLikeMessage(String message);

    public List<LogAudit> findByLikeDate(String date);

    public List<LogAudit> findByLikeUser(String user);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
