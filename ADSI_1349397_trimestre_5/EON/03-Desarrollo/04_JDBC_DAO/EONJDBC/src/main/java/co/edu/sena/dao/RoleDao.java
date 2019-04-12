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

public interface RoleDao
{
	/** 
	 * Inserts a new row in the role table.
	 */
	public RolePk insert(Role dto) throws RoleDaoException;

	/** 
	 * Updates a single row in the role table.
	 */
	public void update(RolePk pk, Role dto) throws RoleDaoException;

	/** 
	 * Deletes a single row in the role table.
	 */
	public void delete(RolePk pk) throws RoleDaoException;

	/** 
	 * Returns the rows from the role table that matches the specified primary-key value.
	 */
	public Role findByPrimaryKey(RolePk pk) throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the criteria 'id_Role = :idRole'.
	 */
	public Role findByPrimaryKey(String idRole) throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the criteria ''.
	 */
	public Role[] findAll() throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the criteria 'id_Role = :idRole'.
	 */
	public Role[] findWhereIdRoleEquals(String idRole) throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the criteria 'Description = :description'.
	 */
	public Role[] findWhereDescriptionEquals(String description) throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the criteria 'Status = :status'.
	 */
	public Role[] findWhereStatusEquals(short status) throws RoleDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the role table that match the specified arbitrary SQL statement
	 */
	public Role[] findByDynamicSelect(String sql, Object[] sqlParams) throws RoleDaoException;

	/** 
	 * Returns all rows from the role table that match the specified arbitrary SQL statement
	 */
	public Role[] findByDynamicWhere(String sql, Object[] sqlParams) throws RoleDaoException;

}
