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

public class DocumentDaoImpl extends AbstractDAO implements DocumentDao
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
	protected final String SQL_SELECT = "SELECT id_Document, Name, Status FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id_Document, Name, Status ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id_Document = ?, Name = ?, Status = ? WHERE id_Document = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id_Document = ?";

	/** 
	 * Index of column id_Document
	 */
	protected static final int COLUMN_ID_DOCUMENT = 1;

	/** 
	 * Index of column Name
	 */
	protected static final int COLUMN_NAME = 2;

	/** 
	 * Index of column Status
	 */
	protected static final int COLUMN_STATUS = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column id_Document
	 */
	protected static final int PK_COLUMN_ID_DOCUMENT = 1;

	/** 
	 * Inserts a new row in the document table.
	 */
	public DocumentPk insert(Document dto) throws DocumentDaoException
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
			stmt.setString( index++, dto.getIdDocument() );
			stmt.setString( index++, dto.getName() );
			if (dto.isStatusNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getStatus() );
			}
		
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the document table.
	 */
	public void update(DocumentPk pk, Document dto) throws DocumentDaoException
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
			stmt.setString( index++, dto.getIdDocument() );
			stmt.setString( index++, dto.getName() );
			if (dto.isStatusNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getStatus() );
			}
		
			stmt.setString( 4, pk.getIdDocument() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the document table.
	 */
	public void delete(DocumentPk pk) throws DocumentDaoException
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
			stmt.setString( 1, pk.getIdDocument() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the document table that matches the specified primary-key value.
	 */
	public Document findByPrimaryKey(DocumentPk pk) throws DocumentDaoException
	{
		return findByPrimaryKey( pk.getIdDocument() );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'id_Document = :idDocument'.
	 */
	public Document findByPrimaryKey(String idDocument) throws DocumentDaoException
	{
		Document ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id_Document = ?", new Object[] { idDocument } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the document table that match the criteria ''.
	 */
	public Document[] findAll() throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id_Document", null );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'id_Document = :idDocument'.
	 */
	public Document[] findWhereIdDocumentEquals(String idDocument) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_Document = ? ORDER BY id_Document", new Object[] { idDocument } );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'Name = :name'.
	 */
	public Document[] findWhereNameEquals(String name) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Name = ? ORDER BY Name", new Object[] { name } );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'Status = :status'.
	 */
	public Document[] findWhereStatusEquals(short status) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Status = ? ORDER BY Status", new Object[] {  new Short(status) } );
	}

	/**
	 * Method 'DocumentDaoImpl'
	 * 
	 */
	public DocumentDaoImpl()
	{
	}

	/**
	 * Method 'DocumentDaoImpl'
	 * 
	 * @param userConn
	 */
	public DocumentDaoImpl(final java.sql.Connection userConn)
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
		return "eon.document";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Document fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Document dto = new Document();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Document[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Document dto = new Document();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Document ret[] = new Document[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Document dto, ResultSet rs) throws SQLException
	{
		dto.setIdDocument( rs.getString( COLUMN_ID_DOCUMENT ) );
		dto.setName( rs.getString( COLUMN_NAME ) );
		dto.setStatus( rs.getShort( COLUMN_STATUS ) );
		if (rs.wasNull()) {
			dto.setStatusNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Document dto)
	{
	}

	/** 
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public Document[] findByDynamicSelect(String sql, Object[] sqlParams) throws DocumentDaoException
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
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public Document[] findByDynamicWhere(String sql, Object[] sqlParams) throws DocumentDaoException
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
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
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
