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

public interface HeadquartesDao
{
	/** 
	 * Inserts a new row in the headquartes table.
	 */
	public HeadquartesPk insert(Headquartes dto) throws HeadquartesDaoException;

	/** 
	 * Updates a single row in the headquartes table.
	 */
	public void update(HeadquartesPk pk, Headquartes dto) throws HeadquartesDaoException;

	/** 
	 * Deletes a single row in the headquartes table.
	 */
	public void delete(HeadquartesPk pk) throws HeadquartesDaoException;

	/** 
	 * Returns the rows from the headquartes table that matches the specified primary-key value.
	 */
	public Headquartes findByPrimaryKey(HeadquartesPk pk) throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the criteria 'name_headquartes = :nameHeadquartes'.
	 */
	public Headquartes findByPrimaryKey(String nameHeadquartes) throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the criteria ''.
	 */
	public Headquartes[] findAll() throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the criteria 'name_headquartes = :nameHeadquartes'.
	 */
	public Headquartes[] findWhereNameHeadquartesEquals(String nameHeadquartes) throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the criteria 'address = :address'.
	 */
	public Headquartes[] findWhereAddressEquals(String address) throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the criteria 'status = :status'.
	 */
	public Headquartes[] findWhereStatusEquals(short status) throws HeadquartesDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the headquartes table that match the specified arbitrary SQL statement
	 */
	public Headquartes[] findByDynamicSelect(String sql, Object[] sqlParams) throws HeadquartesDaoException;

	/** 
	 * Returns all rows from the headquartes table that match the specified arbitrary SQL statement
	 */
	public Headquartes[] findByDynamicWhere(String sql, Object[] sqlParams) throws HeadquartesDaoException;

}
