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

public interface ProgramDao
{
	/** 
	 * Inserts a new row in the program table.
	 */
	public ProgramPk insert(Program dto) throws ProgramDaoException;

	/** 
	 * Updates a single row in the program table.
	 */
	public void update(ProgramPk pk, Program dto) throws ProgramDaoException;

	/** 
	 * Deletes a single row in the program table.
	 */
	public void delete(ProgramPk pk) throws ProgramDaoException;

	/** 
	 * Returns the rows from the program table that matches the specified primary-key value.
	 */
	public Program findByPrimaryKey(ProgramPk pk) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'Program_Code = :programCode AND Version = :version'.
	 */
	public Program findByPrimaryKey(String programCode, String version) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria ''.
	 */
	public Program[] findAll() throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'training_Level = :trainingLevel'.
	 */
	public Program[] findByTrainingLevel(String trainingLevel) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'Program_Code = :programCode'.
	 */
	public Program[] findWhereProgramCodeEquals(String programCode) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'Version = :version'.
	 */
	public Program[] findWhereVersionEquals(String version) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'Name = :name'.
	 */
	public Program[] findWhereNameEquals(String name) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'Initials = :initials'.
	 */
	public Program[] findWhereInitialsEquals(String initials) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'State = :state'.
	 */
	public Program[] findWhereStateEquals(short state) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the criteria 'training_Level = :trainingLevel'.
	 */
	public Program[] findWhereTrainingLevelEquals(String trainingLevel) throws ProgramDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the program table that match the specified arbitrary SQL statement
	 */
	public Program[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProgramDaoException;

	/** 
	 * Returns all rows from the program table that match the specified arbitrary SQL statement
	 */
	public Program[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProgramDaoException;

}
