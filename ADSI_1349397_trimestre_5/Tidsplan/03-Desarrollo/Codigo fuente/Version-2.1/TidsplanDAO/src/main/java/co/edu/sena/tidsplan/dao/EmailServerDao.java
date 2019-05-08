/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.dao;

import co.edu.sena.tidsplan.dto.*;
import co.edu.sena.tidsplan.exceptions.*;

public interface EmailServerDao
{
	/** 
	 * Inserts a new row in the email_server table.
	 */
	public EmailServerPk insert(EmailServer dto) throws EmailServerDaoException;

	/** 
	 * Updates a single row in the email_server table.
	 */
	public void update(EmailServerPk pk, EmailServer dto) throws EmailServerDaoException;

	/** 
	 * Deletes a single row in the email_server table.
	 */
	public void delete(EmailServerPk pk) throws EmailServerDaoException;

	/** 
	 * Returns the rows from the email_server table that matches the specified primary-key value.
	 */
	public EmailServer findByPrimaryKey(EmailServerPk pk) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'mail = :mail'.
	 */
	public EmailServer findByPrimaryKey(String mail) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria ''.
	 */
	public EmailServer[] findAll() throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'mail = :mail'.
	 */
	public EmailServer[] findWhereMailEquals(String mail) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'password = :password'.
	 */
	public EmailServer[] findWherePasswordEquals(String password) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'smtp_host = :smtpHost'.
	 */
	public EmailServer[] findWhereSmtpHostEquals(String smtpHost) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'smtp_port = :smtpPort'.
	 */
	public EmailServer[] findWhereSmtpPortEquals(int smtpPort) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'smtp_start_tls_enable = :smtpStartTlsEnable'.
	 */
	public EmailServer[] findWhereSmtpStartTlsEnableEquals(short smtpStartTlsEnable) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'smtp_auth = :smtpAuth'.
	 */
	public EmailServer[] findWhereSmtpAuthEquals(short smtpAuth) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'recovery_case = :recoveryCase'.
	 */
	public EmailServer[] findWhereRecoveryCaseEquals(String recoveryCase) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the criteria 'recovery_message = :recoveryMessage'.
	 */
	public EmailServer[] findWhereRecoveryMessageEquals(String recoveryMessage) throws EmailServerDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the email_server table that match the specified arbitrary SQL statement
	 */
	public EmailServer[] findByDynamicSelect(String sql, Object[] sqlParams) throws EmailServerDaoException;

	/** 
	 * Returns all rows from the email_server table that match the specified arbitrary SQL statement
	 */
	public EmailServer[] findByDynamicWhere(String sql, Object[] sqlParams) throws EmailServerDaoException;

}