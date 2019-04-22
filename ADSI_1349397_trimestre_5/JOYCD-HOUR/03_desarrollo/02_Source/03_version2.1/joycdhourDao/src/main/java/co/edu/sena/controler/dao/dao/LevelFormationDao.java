/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controler.dao.dao;

import co.edu.sena.controler.dao.dto.*;
import co.edu.sena.controler.dao.exceptions.*;

public interface LevelFormationDao
{
	/** 
	 * Inserts a new row in the level_formation table.
	 */
	public LevelFormationPk insert(LevelFormation dto) throws LevelFormationDaoException;

	/** 
	 * Updates a single row in the level_formation table.
	 */
	public void update(LevelFormationPk pk, LevelFormation dto) throws LevelFormationDaoException;

	/** 
	 * Deletes a single row in the level_formation table.
	 */
	public void delete(LevelFormationPk pk) throws LevelFormationDaoException;

	/** 
	 * Returns the rows from the level_formation table that matches the specified primary-key value.
	 */
	public LevelFormation findByPrimaryKey(LevelFormationPk pk) throws LevelFormationDaoException;

	/** 
	 * Returns all rows from the level_formation table that match the criteria 'level_formation = :levelFormation'.
	 */
	public LevelFormation findByPrimaryKey(String levelFormation) throws LevelFormationDaoException;

	/** 
	 * Returns all rows from the level_formation table that match the criteria ''.
	 */
	public LevelFormation[] findAll() throws LevelFormationDaoException;

	/** 
	 * Returns all rows from the level_formation table that match the criteria 'level_formation = :levelFormation'.
	 */
	public LevelFormation[] findWhereLevelFormationEquals(String levelFormation) throws LevelFormationDaoException;

	/** 
	 * Returns all rows from the level_formation table that match the criteria 'status = :status'.
	 */
	public LevelFormation[] findWhereStatusEquals(short status) throws LevelFormationDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the level_formation table that match the specified arbitrary SQL statement
	 */
	public LevelFormation[] findByDynamicSelect(String sql, Object[] sqlParams) throws LevelFormationDaoException;

	/** 
	 * Returns all rows from the level_formation table that match the specified arbitrary SQL statement
	 */
	public LevelFormation[] findByDynamicWhere(String sql, Object[] sqlParams) throws LevelFormationDaoException;

}