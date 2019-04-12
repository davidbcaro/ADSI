/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.dao;

import co.edu.sena.dto.*;
import co.edu.sena.exceptions.*;

public interface WorkingDayDao
{
	/** 
	 * Inserts a new row in the working_day table.
	 */
	public WorkingDayPk insert(WorkingDay dto) throws WorkingDayDaoException;

	/** 
	 * Updates a single row in the working_day table.
	 */
	public void update(WorkingDayPk pk, WorkingDay dto) throws WorkingDayDaoException;

	/** 
	 * Deletes a single row in the working_day table.
	 */
	public void delete(WorkingDayPk pk) throws WorkingDayDaoException;

	/** 
	 * Returns the rows from the working_day table that matches the specified primary-key value.
	 */
	public WorkingDay findByPrimaryKey(WorkingDayPk pk) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'acronyms_Working_Day = :acronymsWorkingDay'.
	 */
	public WorkingDay findByPrimaryKey(String acronymsWorkingDay) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria ''.
	 */
	public WorkingDay[] findAll() throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'acronyms_Working_Day = :acronymsWorkingDay'.
	 */
	public WorkingDay[] findWhereAcronymsWorkingDayEquals(String acronymsWorkingDay) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'name = :name'.
	 */
	public WorkingDay[] findWhereNameEquals(String name) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'description = :description'.
	 */
	public WorkingDay[] findWhereDescriptionEquals(String description) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'Image = :image'.
	 */
	public WorkingDay[] findWhereImageEquals(byte[] image) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the criteria 'State = :state'.
	 */
	public WorkingDay[] findWhereStateEquals(int state) throws WorkingDayDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the working_day table that match the specified arbitrary SQL statement
	 */
	public WorkingDay[] findByDynamicSelect(String sql, Object[] sqlParams) throws WorkingDayDaoException;

	/** 
	 * Returns all rows from the working_day table that match the specified arbitrary SQL statement
	 */
	public WorkingDay[] findByDynamicWhere(String sql, Object[] sqlParams) throws WorkingDayDaoException;

}
