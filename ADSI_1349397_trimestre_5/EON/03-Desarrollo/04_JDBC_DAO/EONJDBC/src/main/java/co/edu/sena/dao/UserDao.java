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

public interface UserDao
{
	/** 
	 * Inserts a new row in the user table.
	 */
	public UserPk insert(User dto) throws UserDaoException;

	/** 
	 * Updates a single row in the user table.
	 */
	public void update(UserPk pk, User dto) throws UserDaoException;

	/** 
	 * Deletes a single row in the user table.
	 */
	public void delete(UserPk pk) throws UserDaoException;

	/** 
	 * Returns the rows from the user table that matches the specified primary-key value.
	 */
	public User findByPrimaryKey(UserPk pk) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'document_Number = :documentNumber AND id_Document = :idDocument'.
	 */
	public User findByPrimaryKey(String documentNumber, String idDocument) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria ''.
	 */
	public User[] findAll() throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'document_Number = :documentNumber AND id_Document = :idDocument'.
	 */
	public User[] findByClient(String documentNumber, String idDocument) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'document_Number = :documentNumber'.
	 */
	public User[] findWhereDocumentNumberEquals(String documentNumber) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'id_Document = :idDocument'.
	 */
	public User[] findWhereIdDocumentEquals(String idDocument) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'Mail = :mail'.
	 */
	public User[] findWhereMailEquals(String mail) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'Password = :password'.
	 */
	public User[] findWherePasswordEquals(String password) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the criteria 'Date_endind = :dateEndind'.
	 */
	public User[] findWhereDateEndindEquals(Date dateEndind) throws UserDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the user table that match the specified arbitrary SQL statement
	 */
	public User[] findByDynamicSelect(String sql, Object[] sqlParams) throws UserDaoException;

	/** 
	 * Returns all rows from the user table that match the specified arbitrary SQL statement
	 */
	public User[] findByDynamicWhere(String sql, Object[] sqlParams) throws UserDaoException;

}
