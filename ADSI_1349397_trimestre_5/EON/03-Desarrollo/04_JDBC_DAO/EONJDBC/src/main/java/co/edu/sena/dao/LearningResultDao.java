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

public interface LearningResultDao
{
	/** 
	 * Inserts a new row in the learning_result table.
	 */
	public LearningResultPk insert(LearningResult dto) throws LearningResultDaoException;

	/** 
	 * Updates a single row in the learning_result table.
	 */
	public void update(LearningResultPk pk, LearningResult dto) throws LearningResultDaoException;

	/** 
	 * Deletes a single row in the learning_result table.
	 */
	public void delete(LearningResultPk pk) throws LearningResultDaoException;

	/** 
	 * Returns the rows from the learning_result table that matches the specified primary-key value.
	 */
	public LearningResult findByPrimaryKey(LearningResultPk pk) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Code = :code AND Program_Code = :programCode AND Version = :version AND Competition_Code = :competitionCode'.
	 */
	public LearningResult findByPrimaryKey(String code, String programCode, String version, String competitionCode) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria ''.
	 */
	public LearningResult[] findAll() throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Competition_Code = :competitionCode AND Program_Code = :programCode AND Version = :version'.
	 */
	public LearningResult[] findByCompetition(String competitionCode, String programCode, String version) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Code = :code'.
	 */
	public LearningResult[] findWhereCodeEquals(String code) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Description = :description'.
	 */
	public LearningResult[] findWhereDescriptionEquals(String description) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Program_Code = :programCode'.
	 */
	public LearningResult[] findWhereProgramCodeEquals(String programCode) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Competition_Code = :competitionCode'.
	 */
	public LearningResult[] findWhereCompetitionCodeEquals(String competitionCode) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the criteria 'Version = :version'.
	 */
	public LearningResult[] findWhereVersionEquals(String version) throws LearningResultDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the learning_result table that match the specified arbitrary SQL statement
	 */
	public LearningResult[] findByDynamicSelect(String sql, Object[] sqlParams) throws LearningResultDaoException;

	/** 
	 * Returns all rows from the learning_result table that match the specified arbitrary SQL statement
	 */
	public LearningResult[] findByDynamicWhere(String sql, Object[] sqlParams) throws LearningResultDaoException;

}
