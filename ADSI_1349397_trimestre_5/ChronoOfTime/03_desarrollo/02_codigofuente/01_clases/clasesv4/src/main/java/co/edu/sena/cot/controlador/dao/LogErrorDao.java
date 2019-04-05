/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.LogError;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LogErrorDao<T extends LogError> extends InterfaceDao<T>{
    public List<T> findByLogError (int logError);
    public List<T> findByLevel (String level);
    public List<T> findByLogName (String logName);
    public List<T> findByMessage (String message);
    public List<T> findByDate (Date date);
    public List<T> findByUser (String user);
    
    public List<T> findByLikeLogError (String logError);
    public List<T> findByLikeLevel (String level);
    public List<T> findByLikeLogName (String logName);
    public List<T> findByLikeMessage (String message);
    public List<T> findByLikeUser (String user);
    public int updatePK(int llaveNueva, int llaveVieja);
    
}
