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

public class ActivityDaoImpl extends AbstractDAO implements ActivityDao
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
	protected final String SQL_SELECT = "SELECT id_Activity, Name, Code, name_phase FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id_Activity, Name, Code, name_phase ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id_Activity = ?, Name = ?, Code = ?, name_phase = ? WHERE id_Activity = ? AND name_phase = ? AND Code = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id_Activity = ? AND name_phase = ? AND Code = ?";

	/** 
	 * Index of column id_Activity
	 */
	protected static final int COLUMN_ID_ACTIVITY = 1;

	/** 
	 * Index of column Name
	 */
	protected static final int COLUMN_NAME = 2;

	/** 
	 * Index of column Code
	 */
	protected static final int COLUMN_CODE = 3;

	/** 
	 * Index of column name_phase
	 */
	protected static final int COLUMN_NAME_PHASE = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column id_Activity
	 */
	protected static final int PK_COLUMN_ID_ACTIVITY = 1;

	/** 
	 * Index of primary-key column name_phase
	 */
	protected static final int PK_COLUMN_NAME_PHASE = 2;

	/** 
	 * Index of primary-key column Code
	 */
	protected static final int PK_COLUMN_CODE = 3;

	/** 
	 * Inserts a new row in the activity table.
	 */
	public ActivityPk insert(Activity dto) throws ActivityDaoException
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
			stmt.setInt( index++, dto.getIdActivity() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getCode() );
			stmt.setString( index++, dto.getNamePhase() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ActivityDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the activity table.
	 */
	public void update(ActivityPk pk, Activity dto) throws ActivityDaoException
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
			stmt.setInt( index++, dto.getIdActivity() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getCode() );
			stmt.setString( index++, dto.getNamePhase() );
			stmt.setInt( 5, pk.getIdActivity() );
			stmt.setString( 6, pk.getNamePhase() );
			stmt.setString( 7, pk.getCode() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ActivityDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the activity table.
	 */
	public void delete(ActivityPk pk) throws ActivityDaoException
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
			stmt.setInt( 1, pk.getIdActivity() );
			stmt.setString( 2, pk.getNamePhase() );
			stmt.setString( 3, pk.getCode() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ActivityDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the activity table that matches the specified primary-key value.
	 */
	public Activity findByPrimaryKey(ActivityPk pk) throws ActivityDaoException
	{
		return findByPrimaryKey( pk.getIdActivity(), pk.getNamePhase(), pk.getCode() );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'id_Activity = :idActivity AND name_phase = :namePhase AND Code = :code'.
	 */
	public Activity findByPrimaryKey(int idActivity, String namePhase, String code) throws ActivityDaoException
	{
		Activity ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id_Activity = ? AND name_phase = ? AND Code = ?", new Object[] {  new Integer(idActivity), namePhase, code } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the activity table that match the criteria ''.
	 */
	public Activity[] findAll() throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id_Activity, name_phase, Code", null );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'name_phase = :namePhase AND Code = :code'.
	 */
	public Activity[] findByPhase(String namePhase, String code) throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_phase = ? AND Code = ?", new Object[] { namePhase, code } );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'id_Activity = :idActivity'.
	 */
	public Activity[] findWhereIdActivityEquals(int idActivity) throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_Activity = ? ORDER BY id_Activity", new Object[] {  new Integer(idActivity) } );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'Name = :name'.
	 */
	public Activity[] findWhereNameEquals(String name) throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Name = ? ORDER BY Name", new Object[] { name } );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'Code = :code'.
	 */
	public Activity[] findWhereCodeEquals(String code) throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Code = ? ORDER BY Code", new Object[] { code } );
	}

	/** 
	 * Returns all rows from the activity table that match the criteria 'name_phase = :namePhase'.
	 */
	public Activity[] findWhereNamePhaseEquals(String namePhase) throws ActivityDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_phase = ? ORDER BY name_phase", new Object[] { namePhase } );
	}

	/**
	 * Method 'ActivityDaoImpl'
	 * 
	 */
	public ActivityDaoImpl()
	{
	}

	/**
	 * Method 'ActivityDaoImpl'
	 * 
	 * @param userConn
	 */
	public ActivityDaoImpl(final java.sql.Connection userConn)
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
		return "eon.activity";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Activity fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Activity dto = new Activity();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Activity[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Activity dto = new Activity();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Activity ret[] = new Activity[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Activity dto, ResultSet rs) throws SQLException
	{
		dto.setIdActivity( rs.getInt( COLUMN_ID_ACTIVITY ) );
		dto.setName( rs.getString( COLUMN_NAME ) );
		dto.setCode( rs.getString( COLUMN_CODE ) );
		dto.setNamePhase( rs.getString( COLUMN_NAME_PHASE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Activity dto)
	{
	}

	/** 
	 * Returns all rows from the activity table that match the specified arbitrary SQL statement
	 */
	public Activity[] findByDynamicSelect(String sql, Object[] sqlParams) throws ActivityDaoException
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
			throw new ActivityDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the activity table that match the specified arbitrary SQL statement
	 */
	public Activity[] findByDynamicWhere(String sql, Object[] sqlParams) throws ActivityDaoException
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
			throw new ActivityDaoException( "Exception: " + _e.getMessage(), _e );
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
