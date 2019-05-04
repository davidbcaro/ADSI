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

public interface EnvironmentDao
{
	/** 
	 * Inserts a new row in the environment table.
	 */
	public EnvironmentPk insert(Environment dto) throws EnvironmentDaoException;

	/** 
	 * Updates a single row in the environment table.
	 */
	public void update(EnvironmentPk pk, Environment dto) throws EnvironmentDaoException;

	/** 
	 * Deletes a single row in the environment table.
	 */
	public void delete(EnvironmentPk pk) throws EnvironmentDaoException;

	/** 
	 * Returns the rows from the environment table that matches the specified primary-key value.
	 */
	public Environment findByPrimaryKey(EnvironmentPk pk) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'number_environment = :numberEnvironment AND name_headquartes = :nameHeadquartes'.
	 */
	public Environment findByPrimaryKey(String numberEnvironment, String nameHeadquartes) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria ''.
	 */
	public Environment[] findAll() throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'name_headquartes = :nameHeadquartes'.
	 */
	public Environment[] findByHeadquartes(String nameHeadquartes) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'number_environment = :numberEnvironment'.
	 */
	public Environment[] findWhereNumberEnvironmentEquals(String numberEnvironment) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'description = :description'.
	 */
	public Environment[] findWhereDescriptionEquals(String description) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'status = :status'.
	 */
	public Environment[] findWhereStatusEquals(short status) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the criteria 'name_headquartes = :nameHeadquartes'.
	 */
	public Environment[] findWhereNameHeadquartesEquals(String nameHeadquartes) throws EnvironmentDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the environment table that match the specified arbitrary SQL statement
	 */
	public Environment[] findByDynamicSelect(String sql, Object[] sqlParams) throws EnvironmentDaoException;

	/** 
	 * Returns all rows from the environment table that match the specified arbitrary SQL statement
	 */
	public Environment[] findByDynamicWhere(String sql, Object[] sqlParams) throws EnvironmentDaoException;

}
