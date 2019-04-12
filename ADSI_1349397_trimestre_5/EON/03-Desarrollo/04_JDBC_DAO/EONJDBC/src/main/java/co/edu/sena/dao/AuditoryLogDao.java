/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.dao;

import java.util.Date;
import co.edu.sena.dto.*;
import co.edu.sena.exceptions.*;

public interface AuditoryLogDao
{
	/** 
	 * Inserts a new row in the auditory_log table.
	 */
	public AuditoryLogPk insert(AuditoryLog dto) throws AuditoryLogDaoException;

	/** 
	 * Updates a single row in the auditory_log table.
	 */
	public void update(AuditoryLogPk pk, AuditoryLog dto) throws AuditoryLogDaoException;

	/** 
	 * Deletes a single row in the auditory_log table.
	 */
	public void delete(AuditoryLogPk pk) throws AuditoryLogDaoException;

	/** 
	 * Returns the rows from the auditory_log table that matches the specified primary-key value.
	 */
	public AuditoryLog findByPrimaryKey(AuditoryLogPk pk) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'id_Log = :idLog'.
	 */
	public AuditoryLog findByPrimaryKey(long idLog) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria ''.
	 */
	public AuditoryLog[] findAll() throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'id_Log = :idLog'.
	 */
	public AuditoryLog[] findWhereIdLogEquals(long idLog) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'Level = :level'.
	 */
	public AuditoryLog[] findWhereLevelEquals(String level) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'log_Name = :logName'.
	 */
	public AuditoryLog[] findWhereLogNameEquals(String logName) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'Message = :message'.
	 */
	public AuditoryLog[] findWhereMessageEquals(String message) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'Date = :date'.
	 */
	public AuditoryLog[] findWhereDateEquals(Date date) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the criteria 'User = :user'.
	 */
	public AuditoryLog[] findWhereUserEquals(String user) throws AuditoryLogDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the auditory_log table that match the specified arbitrary SQL statement
	 */
	public AuditoryLog[] findByDynamicSelect(String sql, Object[] sqlParams) throws AuditoryLogDaoException;

	/** 
	 * Returns all rows from the auditory_log table that match the specified arbitrary SQL statement
	 */
	public AuditoryLog[] findByDynamicWhere(String sql, Object[] sqlParams) throws AuditoryLogDaoException;

}
