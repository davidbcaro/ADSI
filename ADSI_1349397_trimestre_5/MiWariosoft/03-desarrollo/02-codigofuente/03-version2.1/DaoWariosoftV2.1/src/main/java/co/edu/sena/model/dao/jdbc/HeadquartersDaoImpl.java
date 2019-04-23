/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.jdbc;

import co.edu.sena.model.dao.dao.*;
import co.edu.sena.model.dao.factory.*;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.model.dao.exceptions.*;
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

public class HeadquartersDaoImpl extends AbstractDAO implements HeadquartersDao
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
	protected final String SQL_SELECT = "SELECT name_Headquarters, address, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( name_Headquarters, address, state ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET name_Headquarters = ?, address = ?, state = ? WHERE name_Headquarters = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE name_Headquarters = ?";

	/** 
	 * Index of column name_Headquarters
	 */
	protected static final int COLUMN_NAME_HEADQUARTERS = 1;

	/** 
	 * Index of column address
	 */
	protected static final int COLUMN_ADDRESS = 2;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column name_Headquarters
	 */
	protected static final int PK_COLUMN_NAME_HEADQUARTERS = 1;

	/** 
	 * Inserts a new row in the headquarters table.
	 */
	public HeadquartersPk insert(Headquarters dto) throws HeadquartersDaoException
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
			stmt.setString( index++, dto.getNameHeadquarters() );
			stmt.setString( index++, dto.getAddress() );
			if (dto.isStateNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getState() );
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
			throw new HeadquartersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the headquarters table.
	 */
	public void update(HeadquartersPk pk, Headquarters dto) throws HeadquartersDaoException
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
			stmt.setString( index++, dto.getNameHeadquarters() );
			stmt.setString( index++, dto.getAddress() );
			if (dto.isStateNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getState() );
			}
		
			stmt.setString( 4, pk.getNameHeadquarters() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new HeadquartersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the headquarters table.
	 */
	public void delete(HeadquartersPk pk) throws HeadquartersDaoException
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
			stmt.setString( 1, pk.getNameHeadquarters() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new HeadquartersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the headquarters table that matches the specified primary-key value.
	 */
	public Headquarters findByPrimaryKey(HeadquartersPk pk) throws HeadquartersDaoException
	{
		return findByPrimaryKey( pk.getNameHeadquarters() );
	}

	/** 
	 * Returns all rows from the headquarters table that match the criteria 'name_Headquarters = :nameHeadquarters'.
	 */
	public Headquarters findByPrimaryKey(String nameHeadquarters) throws HeadquartersDaoException
	{
		Headquarters ret[] = findByDynamicSelect( SQL_SELECT + " WHERE name_Headquarters = ?", new Object[] { nameHeadquarters } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the headquarters table that match the criteria ''.
	 */
	public Headquarters[] findAll() throws HeadquartersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY name_Headquarters", null );
	}

	/** 
	 * Returns all rows from the headquarters table that match the criteria 'name_Headquarters = :nameHeadquarters'.
	 */
	public Headquarters[] findWhereNameHeadquartersEquals(String nameHeadquarters) throws HeadquartersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_Headquarters = ? ORDER BY name_Headquarters", new Object[] { nameHeadquarters } );
	}

	/** 
	 * Returns all rows from the headquarters table that match the criteria 'address = :address'.
	 */
	public Headquarters[] findWhereAddressEquals(String address) throws HeadquartersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE address = ? ORDER BY address", new Object[] { address } );
	}

	/** 
	 * Returns all rows from the headquarters table that match the criteria 'state = :state'.
	 */
	public Headquarters[] findWhereStateEquals(short state) throws HeadquartersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'HeadquartersDaoImpl'
	 * 
	 */
	public HeadquartersDaoImpl()
	{
	}

	/**
	 * Method 'HeadquartersDaoImpl'
	 * 
	 * @param userConn
	 */
	public HeadquartersDaoImpl(final java.sql.Connection userConn)
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
		return "wariosoft.headquarters";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Headquarters fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Headquarters dto = new Headquarters();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Headquarters[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Headquarters dto = new Headquarters();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Headquarters ret[] = new Headquarters[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Headquarters dto, ResultSet rs) throws SQLException
	{
		dto.setNameHeadquarters( rs.getString( COLUMN_NAME_HEADQUARTERS ) );
		dto.setAddress( rs.getString( COLUMN_ADDRESS ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
		if (rs.wasNull()) {
			dto.setStateNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Headquarters dto)
	{
	}

	/** 
	 * Returns all rows from the headquarters table that match the specified arbitrary SQL statement
	 */
	public Headquarters[] findByDynamicSelect(String sql, Object[] sqlParams) throws HeadquartersDaoException
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
			throw new HeadquartersDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the headquarters table that match the specified arbitrary SQL statement
	 */
	public Headquarters[] findByDynamicWhere(String sql, Object[] sqlParams) throws HeadquartersDaoException
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
			throw new HeadquartersDaoException( "Exception: " + _e.getMessage(), _e );
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