/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.LogError;
import java.sql.Clob;
import java.util.List;
import java.util.Date;

/**
 *
 * @author liosalfar
 */
public interface LogErrorDAO<T extends LogError> extends InterfaceDao<T> {

    public List<LogError> findByLogError(long logError);

    public List<LogError> findByLevel(String level);

    public List<LogError> findByLogName(String logName);

    public List<LogError> findByMessage(Clob menssage);

    public List<LogError> findByDate(Date date);

    public List<LogError> findByUser(String user);

    public List<LogError> findByLikeLogError(String logError);

    public List<LogError> findByLikeLevel(String level);

    public List<LogError> findByLikeLogName(String logName);

    public List<LogError> findByLikeMessage(String logName);

    public List<LogError> findByLikeDate(String date);

    public List<LogError> findByLikeUser(String user);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
