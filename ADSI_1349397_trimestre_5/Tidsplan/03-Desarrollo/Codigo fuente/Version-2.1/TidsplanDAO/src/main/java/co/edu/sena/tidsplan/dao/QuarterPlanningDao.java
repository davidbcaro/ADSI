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

public interface QuarterPlanningDao
{
	/** 
	 * Inserts a new row in the quarter_planning table.
	 */
	public QuarterPlanningPk insert(QuarterPlanning dto) throws QuarterPlanningDaoException;

	/** 
	 * Updates a single row in the quarter_planning table.
	 */
	public void update(QuarterPlanningPk pk, QuarterPlanning dto) throws QuarterPlanningDaoException;

	/** 
	 * Deletes a single row in the quarter_planning table.
	 */
	public void delete(QuarterPlanningPk pk) throws QuarterPlanningDaoException;

	/** 
	 * Returns the rows from the quarter_planning table that matches the specified primary-key value.
	 */
	public QuarterPlanning findByPrimaryKey(QuarterPlanningPk pk) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'name_trimester = :nameTrimester AND workingday_initials = :workingdayInitials AND lr_code = :lrCode AND program_code = :programCode AND competition_code = :competitionCode AND level_formation = :levelFormation AND program_version = :programVersion'.
	 */
	public QuarterPlanning findByPrimaryKey(String nameTrimester, String workingdayInitials, String lrCode, String programCode, String competitionCode, String levelFormation, String programVersion) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria ''.
	 */
	public QuarterPlanning[] findAll() throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'lr_code = :lrCode AND program_code = :programCode AND competition_code = :competitionCode AND program_version = :programVersion'.
	 */
	public QuarterPlanning[] findByLearningResult(String lrCode, String programCode, String competitionCode, String programVersion) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'name_trimester = :nameTrimester AND workingday_initials = :workingdayInitials AND level_formation = :levelFormation'.
	 */
	public QuarterPlanning[] findByTrimester(String nameTrimester, String workingdayInitials, String levelFormation) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'name_trimester = :nameTrimester'.
	 */
	public QuarterPlanning[] findWhereNameTrimesterEquals(String nameTrimester) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'workingday_initials = :workingdayInitials'.
	 */
	public QuarterPlanning[] findWhereWorkingdayInitialsEquals(String workingdayInitials) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'lr_code = :lrCode'.
	 */
	public QuarterPlanning[] findWhereLrCodeEquals(String lrCode) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'program_code = :programCode'.
	 */
	public QuarterPlanning[] findWhereProgramCodeEquals(String programCode) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'competition_code = :competitionCode'.
	 */
	public QuarterPlanning[] findWhereCompetitionCodeEquals(String competitionCode) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'level_formation = :levelFormation'.
	 */
	public QuarterPlanning[] findWhereLevelFormationEquals(String levelFormation) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the criteria 'program_version = :programVersion'.
	 */
	public QuarterPlanning[] findWhereProgramVersionEquals(String programVersion) throws QuarterPlanningDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the quarter_planning table that match the specified arbitrary SQL statement
	 */
	public QuarterPlanning[] findByDynamicSelect(String sql, Object[] sqlParams) throws QuarterPlanningDaoException;

	/** 
	 * Returns all rows from the quarter_planning table that match the specified arbitrary SQL statement
	 */
	public QuarterPlanning[] findByDynamicWhere(String sql, Object[] sqlParams) throws QuarterPlanningDaoException;

}