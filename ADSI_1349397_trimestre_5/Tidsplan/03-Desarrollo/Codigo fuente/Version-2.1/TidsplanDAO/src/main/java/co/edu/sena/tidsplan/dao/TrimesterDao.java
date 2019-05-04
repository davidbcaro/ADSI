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

public interface TrimesterDao
{
	/** 
	 * Inserts a new row in the trimester table.
	 */
	public TrimesterPk insert(Trimester dto) throws TrimesterDaoException;

	/** 
	 * Updates a single row in the trimester table.
	 */
	public void update(TrimesterPk pk, Trimester dto) throws TrimesterDaoException;

	/** 
	 * Deletes a single row in the trimester table.
	 */
	public void delete(TrimesterPk pk) throws TrimesterDaoException;

	/** 
	 * Returns the rows from the trimester table that matches the specified primary-key value.
	 */
	public Trimester findByPrimaryKey(TrimesterPk pk) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'name_trimester = :nameTrimester AND workingday_initials = :workingdayInitials AND level_formation = :levelFormation'.
	 */
	public Trimester findByPrimaryKey(String nameTrimester, String workingdayInitials, String levelFormation) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria ''.
	 */
	public Trimester[] findAll() throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'level_formation = :levelFormation'.
	 */
	public Trimester[] findByFormationLevel(String levelFormation) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'workingday_initials = :workingdayInitials'.
	 */
	public Trimester[] findByWorkingDay(String workingdayInitials) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'name_trimester = :nameTrimester'.
	 */
	public Trimester[] findWhereNameTrimesterEquals(String nameTrimester) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'workingday_initials = :workingdayInitials'.
	 */
	public Trimester[] findWhereWorkingdayInitialsEquals(String workingdayInitials) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the criteria 'level_formation = :levelFormation'.
	 */
	public Trimester[] findWhereLevelFormationEquals(String levelFormation) throws TrimesterDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the trimester table that match the specified arbitrary SQL statement
	 */
	public Trimester[] findByDynamicSelect(String sql, Object[] sqlParams) throws TrimesterDaoException;

	/** 
	 * Returns all rows from the trimester table that match the specified arbitrary SQL statement
	 */
	public Trimester[] findByDynamicWhere(String sql, Object[] sqlParams) throws TrimesterDaoException;

}
