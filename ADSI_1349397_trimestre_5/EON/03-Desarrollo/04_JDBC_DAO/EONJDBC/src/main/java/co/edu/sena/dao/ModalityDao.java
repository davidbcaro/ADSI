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

public interface ModalityDao
{
	/** 
	 * Inserts a new row in the modality table.
	 */
	public ModalityPk insert(Modality dto) throws ModalityDaoException;

	/** 
	 * Updates a single row in the modality table.
	 */
	public void update(ModalityPk pk, Modality dto) throws ModalityDaoException;

	/** 
	 * Deletes a single row in the modality table.
	 */
	public void delete(ModalityPk pk) throws ModalityDaoException;

	/** 
	 * Returns the rows from the modality table that matches the specified primary-key value.
	 */
	public Modality findByPrimaryKey(ModalityPk pk) throws ModalityDaoException;

	/** 
	 * Returns all rows from the modality table that match the criteria 'modality_Name = :modalityName'.
	 */
	public Modality findByPrimaryKey(String modalityName) throws ModalityDaoException;

	/** 
	 * Returns all rows from the modality table that match the criteria ''.
	 */
	public Modality[] findAll() throws ModalityDaoException;

	/** 
	 * Returns all rows from the modality table that match the criteria 'modality_Name = :modalityName'.
	 */
	public Modality[] findWhereModalityNameEquals(String modalityName) throws ModalityDaoException;

	/** 
	 * Returns all rows from the modality table that match the criteria 'State = :state'.
	 */
	public Modality[] findWhereStateEquals(short state) throws ModalityDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the modality table that match the specified arbitrary SQL statement
	 */
	public Modality[] findByDynamicSelect(String sql, Object[] sqlParams) throws ModalityDaoException;

	/** 
	 * Returns all rows from the modality table that match the specified arbitrary SQL statement
	 */
	public Modality[] findByDynamicWhere(String sql, Object[] sqlParams) throws ModalityDaoException;

}
