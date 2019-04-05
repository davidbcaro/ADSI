/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.LogAudit;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LogAuditDao<T extends LogAudit> extends InterfaceDao<T> {
    public List<T> findByLogAudit(Long logAu);
    public List<T> findByLevel (String level);
    public List<T> findByLogName (String logName);
    public List<T> findByMessage (String message);
    public List<T> findByDate (Date date);
    public List<T> findByUser (String user);
    public List<T> findByLikeLogAudit(String logAu);
    public List<T> findByLikeLevel (String level);
    public List<T> findByLikeLogName (String logName);
    public List<T> findByLikeMessage (String message);
    public List<T> findByLikeDate (String date);
    public List<T> findByLikeUser (String user);
    public int updatePK(Long llaveNueva, Long llaveVieja);
    
    
    
    
    
}
