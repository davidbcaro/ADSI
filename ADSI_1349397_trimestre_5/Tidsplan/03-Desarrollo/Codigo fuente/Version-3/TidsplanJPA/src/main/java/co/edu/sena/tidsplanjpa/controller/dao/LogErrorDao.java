/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.LogError;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MIHOGAR
 * @param <T>
 */
public interface LogErrorDao <T extends LogError> extends InterfaceDao<T>{
    public List<T> findByIdLog(BigInteger idLog);
    public List<T> findByLikeIdLog(BigInteger idLog);
    public List<T> findByLevel(String level);
    public List<T> findByLikeLevel(String level);
    public List<T> findByLogName(String logName);
    public List<T> findByLikeLogName(String logName);
    public List<T> findByMessage(String message);
    public List<T> findByLikeMessage(String message);
    public List<T> findByDate(Date date);
    public int updatePrimaryKey (BigInteger newKey, BigInteger oldKey); 
}
