/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.dao;

import java.util.Date;
import co.edu.sena.tidsplan.dto.*;
import co.edu.sena.tidsplan.exceptions.*;

public interface DisponibilityDao
{
	/** 
	 * Inserts a new row in the disponibility table.
	 */
	public DisponibilityPk insert(Disponibility dto) throws DisponibilityDaoException;

	/** 
	 * Updates a single row in the disponibility table.
	 */
	public void update(DisponibilityPk pk, Disponibility dto) throws DisponibilityDaoException;

	/** 
	 * Deletes a single row in the disponibility table.
	 */
	public void delete(DisponibilityPk pk) throws DisponibilityDaoException;

	/** 
	 * Returns the rows from the disponibility table that matches the specified primary-key value.
	 */
	public Disponibility findByPrimaryKey(DisponibilityPk pk) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'start_hour = :startHour AND name_day = :nameDay AND working_day_initials = :workingDayInitials AND document_number = :documentNumber AND document = :document'.
	 */
	public Disponibility findByPrimaryKey(Date startHour, String nameDay, String workingDayInitials, String documentNumber, String document) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria ''.
	 */
	public Disponibility[] findAll() throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'name_day = :nameDay'.
	 */
	public Disponibility[] findByDay(String nameDay) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'document_number = :documentNumber AND document = :document'.
	 */
	public Disponibility[] findByInstructor(String documentNumber, String document) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'working_day_initials = :workingDayInitials'.
	 */
	public Disponibility[] findByWorkingDay(String workingDayInitials) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'document = :document'.
	 */
	public Disponibility[] findWhereDocumentEquals(String document) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'document_number = :documentNumber'.
	 */
	public Disponibility[] findWhereDocumentNumberEquals(String documentNumber) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'start_hour = :startHour'.
	 */
	public Disponibility[] findWhereStartHourEquals(Date startHour) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'end_hour = :endHour'.
	 */
	public Disponibility[] findWhereEndHourEquals(Date endHour) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'name_day = :nameDay'.
	 */
	public Disponibility[] findWhereNameDayEquals(String nameDay) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the criteria 'working_day_initials = :workingDayInitials'.
	 */
	public Disponibility[] findWhereWorkingDayInitialsEquals(String workingDayInitials) throws DisponibilityDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the disponibility table that match the specified arbitrary SQL statement
	 */
	public Disponibility[] findByDynamicSelect(String sql, Object[] sqlParams) throws DisponibilityDaoException;

	/** 
	 * Returns all rows from the disponibility table that match the specified arbitrary SQL statement
	 */
	public Disponibility[] findByDynamicWhere(String sql, Object[] sqlParams) throws DisponibilityDaoException;

}