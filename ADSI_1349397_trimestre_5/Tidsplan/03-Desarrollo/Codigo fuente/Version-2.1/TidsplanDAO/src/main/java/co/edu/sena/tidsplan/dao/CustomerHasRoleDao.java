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

public interface CustomerHasRoleDao
{
	/** 
	 * Inserts a new row in the customer_has_role table.
	 */
	public CustomerHasRolePk insert(CustomerHasRole dto) throws CustomerHasRoleDaoException;

	/** 
	 * Updates a single row in the customer_has_role table.
	 */
	public void update(CustomerHasRolePk pk, CustomerHasRole dto) throws CustomerHasRoleDaoException;

	/** 
	 * Deletes a single row in the customer_has_role table.
	 */
	public void delete(CustomerHasRolePk pk) throws CustomerHasRoleDaoException;

	/** 
	 * Returns the rows from the customer_has_role table that matches the specified primary-key value.
	 */
	public CustomerHasRole findByPrimaryKey(CustomerHasRolePk pk) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'document_number = :documentNumber AND document = :document AND idrol = :idrol'.
	 */
	public CustomerHasRole findByPrimaryKey(String documentNumber, String document, String idrol) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria ''.
	 */
	public CustomerHasRole[] findAll() throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'document = :document AND document_number = :documentNumber'.
	 */
	public CustomerHasRole[] findByCustomer(String document, String documentNumber) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'idrol = :idrol'.
	 */
	public CustomerHasRole[] findByRole(String idrol) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'document = :document'.
	 */
	public CustomerHasRole[] findWhereDocumentEquals(String document) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'document_number = :documentNumber'.
	 */
	public CustomerHasRole[] findWhereDocumentNumberEquals(String documentNumber) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'idrol = :idrol'.
	 */
	public CustomerHasRole[] findWhereIdrolEquals(String idrol) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the criteria 'status = :status'.
	 */
	public CustomerHasRole[] findWhereStatusEquals(short status) throws CustomerHasRoleDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the customer_has_role table that match the specified arbitrary SQL statement
	 */
	public CustomerHasRole[] findByDynamicSelect(String sql, Object[] sqlParams) throws CustomerHasRoleDaoException;

	/** 
	 * Returns all rows from the customer_has_role table that match the specified arbitrary SQL statement
	 */
	public CustomerHasRole[] findByDynamicWhere(String sql, Object[] sqlParams) throws CustomerHasRoleDaoException;

}