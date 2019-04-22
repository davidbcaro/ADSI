/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controler.dao.jdbc;

import co.edu.sena.controler.dao.dao.*;
import co.edu.sena.controler.dao.factory.*;
import co.edu.sena.controler.dao.dto.*;
import co.edu.sena.controler.dao.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class CustomerDaoImpl extends AbstractDAO implements CustomerDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT document_type, first_name, second_name, first_last_name, second_last_name, photo, identification_card_number FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( document_type, first_name, second_name, first_last_name, second_last_name, photo, identification_card_number ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET document_type = ?, first_name = ?, second_name = ?, first_last_name = ?, second_last_name = ?, photo = ?, identification_card_number = ? WHERE document_type = ? AND identification_card_number = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE document_type = ? AND identification_card_number = ?";

	/** 
	 * Index of column document_type
	 */
	protected static final int COLUMN_DOCUMENT_TYPE = 1;

	/** 
	 * Index of column first_name
	 */
	protected static final int COLUMN_FIRST_NAME = 2;

	/** 
	 * Index of column second_name
	 */
	protected static final int COLUMN_SECOND_NAME = 3;

	/** 
	 * Index of column first_last_name
	 */
	protected static final int COLUMN_FIRST_LAST_NAME = 4;

	/** 
	 * Index of column second_last_name
	 */
	protected static final int COLUMN_SECOND_LAST_NAME = 5;

	/** 
	 * Index of column photo
	 */
	protected static final int COLUMN_PHOTO = 6;

	/** 
	 * Index of column identification_card_number
	 */
	protected static final int COLUMN_IDENTIFICATION_CARD_NUMBER = 7;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 7;

	/** 
	 * Index of primary-key column document_type
	 */
	protected static final int PK_COLUMN_DOCUMENT_TYPE = 1;

	/** 
	 * Index of primary-key column identification_card_number
	 */
	protected static final int PK_COLUMN_IDENTIFICATION_CARD_NUMBER = 2;

	/** 
	 * Inserts a new row in the customer table.
	 */
	public CustomerPk insert(Customer dto) throws CustomerDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setString( index++, dto.getDocumentType() );
			stmt.setString( index++, dto.getFirstName() );
			stmt.setString( index++, dto.getSecondName() );
			stmt.setString( index++, dto.getFirstLastName() );
			stmt.setString( index++, dto.getSecondLastName() );
			super.setBlobColumn(stmt, index++, dto.getPhoto() );
			stmt.setString( index++, dto.getIdentificationCardNumber() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CustomerDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the customer table.
	 */
	public void update(CustomerPk pk, Customer dto) throws CustomerDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getDocumentType() );
			stmt.setString( index++, dto.getFirstName() );
			stmt.setString( index++, dto.getSecondName() );
			stmt.setString( index++, dto.getFirstLastName() );
			stmt.setString( index++, dto.getSecondLastName() );
			super.setBlobColumn(stmt, index++, dto.getPhoto() );
			stmt.setString( index++, dto.getIdentificationCardNumber() );
			stmt.setString( 8, pk.getDocumentType() );
			stmt.setString( 9, pk.getIdentificationCardNumber() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CustomerDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the customer table.
	 */
	public void delete(CustomerPk pk) throws CustomerDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getDocumentType() );
			stmt.setString( 2, pk.getIdentificationCardNumber() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CustomerDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the customer table that matches the specified primary-key value.
	 */
	public Customer findByPrimaryKey(CustomerPk pk) throws CustomerDaoException
	{
		return findByPrimaryKey( pk.getDocumentType(), pk.getIdentificationCardNumber() );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'document_type = :documentType AND identification_card_number = :identificationCardNumber'.
	 */
	public Customer findByPrimaryKey(String documentType, String identificationCardNumber) throws CustomerDaoException
	{
		Customer ret[] = findByDynamicSelect( SQL_SELECT + " WHERE document_type = ? AND identification_card_number = ?", new Object[] { documentType, identificationCardNumber } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the customer table that match the criteria ''.
	 */
	public Customer[] findAll() throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY document_type, identification_card_number", null );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'identification_card_number = :identificationCardNumber'.
	 */
	public Customer[] findByIdentificationCard(String identificationCardNumber) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE identification_card_number = ?", new Object[] { identificationCardNumber } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'document_type = :documentType'.
	 */
	public Customer[] findWhereDocumentTypeEquals(String documentType) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE document_type = ? ORDER BY document_type", new Object[] { documentType } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'first_name = :firstName'.
	 */
	public Customer[] findWhereFirstNameEquals(String firstName) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE first_name = ? ORDER BY first_name", new Object[] { firstName } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'second_name = :secondName'.
	 */
	public Customer[] findWhereSecondNameEquals(String secondName) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE second_name = ? ORDER BY second_name", new Object[] { secondName } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'first_last_name = :firstLastName'.
	 */
	public Customer[] findWhereFirstLastNameEquals(String firstLastName) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE first_last_name = ? ORDER BY first_last_name", new Object[] { firstLastName } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'second_last_name = :secondLastName'.
	 */
	public Customer[] findWhereSecondLastNameEquals(String secondLastName) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE second_last_name = ? ORDER BY second_last_name", new Object[] { secondLastName } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'photo = :photo'.
	 */
	public Customer[] findWherePhotoEquals(byte[] photo) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE photo = ? ORDER BY photo", new Object[] { photo } );
	}

	/** 
	 * Returns all rows from the customer table that match the criteria 'identification_card_number = :identificationCardNumber'.
	 */
	public Customer[] findWhereIdentificationCardNumberEquals(String identificationCardNumber) throws CustomerDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE identification_card_number = ? ORDER BY identification_card_number", new Object[] { identificationCardNumber } );
	}

	/**
	 * Method 'CustomerDaoImpl'
	 * 
	 */
	public CustomerDaoImpl()
	{
	}

	/**
	 * Method 'CustomerDaoImpl'
	 * 
	 * @param userConn
	 */
	public CustomerDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "joycd.customer";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Customer fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Customer dto = new Customer();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Customer[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Customer dto = new Customer();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Customer ret[] = new Customer[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Customer dto, ResultSet rs) throws SQLException
	{
		dto.setDocumentType( rs.getString( COLUMN_DOCUMENT_TYPE ) );
		dto.setFirstName( rs.getString( COLUMN_FIRST_NAME ) );
		dto.setSecondName( rs.getString( COLUMN_SECOND_NAME ) );
		dto.setFirstLastName( rs.getString( COLUMN_FIRST_LAST_NAME ) );
		dto.setSecondLastName( rs.getString( COLUMN_SECOND_LAST_NAME ) );
		dto.setPhoto( super.getBlobColumn(rs, COLUMN_PHOTO ) );
		dto.setIdentificationCardNumber( rs.getString( COLUMN_IDENTIFICATION_CARD_NUMBER ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Customer dto)
	{
	}

	/** 
	 * Returns all rows from the customer table that match the specified arbitrary SQL statement
	 */
	public Customer[] findByDynamicSelect(String sql, Object[] sqlParams) throws CustomerDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CustomerDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the customer table that match the specified arbitrary SQL statement
	 */
	public Customer[] findByDynamicWhere(String sql, Object[] sqlParams) throws CustomerDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CustomerDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}