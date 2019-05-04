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

public interface VersionDao
{
	/** 
	 * Inserts a new row in the version table.
	 */
	public VersionPk insert(Version dto) throws VersionDaoException;

	/** 
	 * Updates a single row in the version table.
	 */
	public void update(VersionPk pk, Version dto) throws VersionDaoException;

	/** 
	 * Deletes a single row in the version table.
	 */
	public void delete(VersionPk pk) throws VersionDaoException;

	/** 
	 * Returns the rows from the version table that matches the specified primary-key value.
	 */
	public Version findByPrimaryKey(VersionPk pk) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria 'id_version = :idVersion AND id_trimester_current = :idTrimesterCurrent'.
	 */
	public Version findByPrimaryKey(int idVersion, String idTrimesterCurrent) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria ''.
	 */
	public Version[] findAll() throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria 'id_trimester_current = :idTrimesterCurrent'.
	 */
	public Version[] findByTrimesterCurrent(String idTrimesterCurrent) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria 'id_version = :idVersion'.
	 */
	public Version[] findWhereIdVersionEquals(int idVersion) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria 'status = :status'.
	 */
	public Version[] findWhereStatusEquals(short status) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the criteria 'id_trimester_current = :idTrimesterCurrent'.
	 */
	public Version[] findWhereIdTrimesterCurrentEquals(String idTrimesterCurrent) throws VersionDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the version table that match the specified arbitrary SQL statement
	 */
	public Version[] findByDynamicSelect(String sql, Object[] sqlParams) throws VersionDaoException;

	/** 
	 * Returns all rows from the version table that match the specified arbitrary SQL statement
	 */
	public Version[] findByDynamicWhere(String sql, Object[] sqlParams) throws VersionDaoException;

}
