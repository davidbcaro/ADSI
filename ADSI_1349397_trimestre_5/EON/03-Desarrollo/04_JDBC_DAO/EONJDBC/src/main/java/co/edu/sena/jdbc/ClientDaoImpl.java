/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.jdbc;

import co.edu.sena.dao.*;
import co.edu.sena.factory.*;
import co.edu.sena.dto.*;
import co.edu.sena.exceptions.*;
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

public class ClientDaoImpl extends AbstractDAO implements ClientDao
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
	protected final String SQL_SELECT = "SELECT document_Number, first_Name, second_Name, first_Last_name, second_Last_name, Photo, id_Document FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( document_Number, first_Name, second_Name, first_Last_name, second_Last_name, Photo, id_Document ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET document_Number = ?, first_Name = ?, second_Name = ?, first_Last_name = ?, second_Last_name = ?, Photo = ?, id_Document = ? WHERE document_Number = ? AND id_Document = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE document_Number = ? AND id_Document = ?";

	/** 
	 * Index of column document_Number
	 */
	protected static final int COLUMN_DOCUMENT_NUMBER = 1;

	/** 
	 * Index of column first_Name
	 */
	protected static final int COLUMN_FIRST_NAME = 2;

	/** 
	 * Index of column second_Name
	 */
	protected static final int COLUMN_SECOND_NAME = 3;

	/** 
	 * Index of column first_Last_name
	 */
	protected static final int COLUMN_FIRST_LAST_NAME = 4;

	/** 
	 * Index of column second_Last_name
	 */
	protected static final int COLUMN_SECOND_LAST_NAME = 5;

	/** 
	 * Index of column Photo
	 */
	protected static final int COLUMN_PHOTO = 6;

	/** 
	 * Index of column id_Document
	 */
	protected static final int COLUMN_ID_DOCUMENT = 7;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 7;

	/** 
	 * Index of primary-key column document_Number
	 */
	protected static final int PK_COLUMN_DOCUMENT_NUMBER = 1;

	/** 
	 * Index of primary-key column id_Document
	 */
	protected static final int PK_COLUMN_ID_DOCUMENT = 2;

	/** 
	 * Inserts a new row in the client table.
	 */
	public ClientPk insert(Client dto) throws ClientDaoException
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
			stmt.setString( index++, dto.getDocumentNumber() );
			stmt.setString( index++, dto.getFirstName() );
			stmt.setString( index++, dto.getSecondName() );
			stmt.setString( index++, dto.getFirstLastName() );
			stmt.setString( index++, dto.getSecondLastName() );
			super.setBlobColumn(stmt, index++, dto.getPhoto() );
			stmt.setString( index++, dto.getIdDocument() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClientDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the client table.
	 */
	public void update(ClientPk pk, Client dto) throws ClientDaoException
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
			stmt.setString( index++, dto.getDocumentNumber() );
			stmt.setString( index++, dto.getFirstName() );
			stmt.setString( index++, dto.getSecondName() );
			stmt.setString( index++, dto.getFirstLastName() );
			stmt.setString( index++, dto.getSecondLastName() );
			super.setBlobColumn(stmt, index++, dto.getPhoto() );
			stmt.setString( index++, dto.getIdDocument() );
			stmt.setString( 8, pk.getDocumentNumber() );
			stmt.setString( 9, pk.getIdDocument() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClientDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the client table.
	 */
	public void delete(ClientPk pk) throws ClientDaoException
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
			stmt.setString( 1, pk.getDocumentNumber() );
			stmt.setString( 2, pk.getIdDocument() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClientDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the client table that matches the specified primary-key value.
	 */
	public Client findByPrimaryKey(ClientPk pk) throws ClientDaoException
	{
		return findByPrimaryKey( pk.getDocumentNumber(), pk.getIdDocument() );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'document_Number = :documentNumber AND id_Document = :idDocument'.
	 */
	public Client findByPrimaryKey(String documentNumber, String idDocument) throws ClientDaoException
	{
		Client ret[] = findByDynamicSelect( SQL_SELECT + " WHERE document_Number = ? AND id_Document = ?", new Object[] { documentNumber, idDocument } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the client table that match the criteria ''.
	 */
	public Client[] findAll() throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY document_Number, id_Document", null );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'id_Document = :idDocument'.
	 */
	public Client[] findByDocument(String idDocument) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_Document = ?", new Object[] { idDocument } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'document_Number = :documentNumber'.
	 */
	public Client[] findWhereDocumentNumberEquals(String documentNumber) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE document_Number = ? ORDER BY document_Number", new Object[] { documentNumber } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'first_Name = :firstName'.
	 */
	public Client[] findWhereFirstNameEquals(String firstName) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE first_Name = ? ORDER BY first_Name", new Object[] { firstName } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'second_Name = :secondName'.
	 */
	public Client[] findWhereSecondNameEquals(String secondName) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE second_Name = ? ORDER BY second_Name", new Object[] { secondName } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'first_Last_name = :firstLastName'.
	 */
	public Client[] findWhereFirstLastNameEquals(String firstLastName) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE first_Last_name = ? ORDER BY first_Last_name", new Object[] { firstLastName } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'second_Last_name = :secondLastName'.
	 */
	public Client[] findWhereSecondLastNameEquals(String secondLastName) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE second_Last_name = ? ORDER BY second_Last_name", new Object[] { secondLastName } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'Photo = :photo'.
	 */
	public Client[] findWherePhotoEquals(byte[] photo) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Photo = ? ORDER BY Photo", new Object[] { photo } );
	}

	/** 
	 * Returns all rows from the client table that match the criteria 'id_Document = :idDocument'.
	 */
	public Client[] findWhereIdDocumentEquals(String idDocument) throws ClientDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_Document = ? ORDER BY id_Document", new Object[] { idDocument } );
	}

	/**
	 * Method 'ClientDaoImpl'
	 * 
	 */
	public ClientDaoImpl()
	{
	}

	/**
	 * Method 'ClientDaoImpl'
	 * 
	 * @param userConn
	 */
	public ClientDaoImpl(final java.sql.Connection userConn)
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
		return "eon.client";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Client fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Client dto = new Client();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Client[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Client dto = new Client();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Client ret[] = new Client[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Client dto, ResultSet rs) throws SQLException
	{
		dto.setDocumentNumber( rs.getString( COLUMN_DOCUMENT_NUMBER ) );
		dto.setFirstName( rs.getString( COLUMN_FIRST_NAME ) );
		dto.setSecondName( rs.getString( COLUMN_SECOND_NAME ) );
		dto.setFirstLastName( rs.getString( COLUMN_FIRST_LAST_NAME ) );
		dto.setSecondLastName( rs.getString( COLUMN_SECOND_LAST_NAME ) );
		dto.setPhoto( super.getBlobColumn(rs, COLUMN_PHOTO ) );
		dto.setIdDocument( rs.getString( COLUMN_ID_DOCUMENT ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Client dto)
	{
	}

	/** 
	 * Returns all rows from the client table that match the specified arbitrary SQL statement
	 */
	public Client[] findByDynamicSelect(String sql, Object[] sqlParams) throws ClientDaoException
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
			throw new ClientDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the client table that match the specified arbitrary SQL statement
	 */
	public Client[] findByDynamicWhere(String sql, Object[] sqlParams) throws ClientDaoException
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
			throw new ClientDaoException( "Exception: " + _e.getMessage(), _e );
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
