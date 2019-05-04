/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.tidsplan.dao.LogAuditoriaDao;
import co.edu.sena.tidsplan.dto.LogAuditoria;
import co.edu.sena.tidsplan.exceptions.LogAuditoriaDaoException;
import co.edu.sena.tidsplan.factory.LogAuditoriaDaoFactory;

public class LogAuditoriaDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		 findAll();
		// findWhereIdLogEquals(0);
		// findWhereLevelEquals("");
		// findWhereLogNameEquals("");
		// findWhereMessageEquals("");
		// findWhereDateEquals(null);
		// findWhereUserEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdLogEquals'
	 * 
	 * @param idLog
	 */
	public static void findWhereIdLogEquals(long idLog)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereIdLogEquals(idLog);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLevelEquals'
	 * 
	 * @param level
	 */
	public static void findWhereLevelEquals(String level)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereLevelEquals(level);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLogNameEquals'
	 * 
	 * @param logName
	 */
	public static void findWhereLogNameEquals(String logName)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereLogNameEquals(logName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereMessageEquals'
	 * 
	 * @param message
	 */
	public static void findWhereMessageEquals(String message)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereMessageEquals(message);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateEquals'
	 * 
	 * @param date
	 */
	public static void findWhereDateEquals(Date date)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereDateEquals(date);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserEquals'
	 * 
	 * @param user
	 */
	public static void findWhereUserEquals(String user)
	{
		try {
			LogAuditoriaDao _dao = getLogAuditoriaDao();
			LogAuditoria _result[] = _dao.findWhereUserEquals(user);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getLogAuditoriaDao'
	 * 
	 * @return LogAuditoriaDao
	 */
	public static LogAuditoriaDao getLogAuditoriaDao()
	{
		return LogAuditoriaDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(LogAuditoria dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdLog() );
		buf.append( ", " );
		buf.append( dto.getLevel() );
		buf.append( ", " );
		buf.append( dto.getLogName() );
		buf.append( ", " );
		buf.append( dto.getMessage() );
		buf.append( ", " );
		buf.append( dto.getDate() );
		buf.append( ", " );
		buf.append( dto.getUser() );
		System.out.println( buf.toString() );
	}

}
