/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.jdbc;

import co.edu.sena.tidsplan.dao.*;
import co.edu.sena.tidsplan.factory.*;
import co.edu.sena.tidsplan.dto.*;
import co.edu.sena.tidsplan.exceptions.*;
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

public class ProjectPhaseDaoImpl extends AbstractDAO implements ProjectPhaseDao
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
	protected final String SQL_SELECT = "SELECT name_phase, status, project_code FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( name_phase, status, project_code ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET name_phase = ?, status = ?, project_code = ? WHERE name_phase = ? AND project_code = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE name_phase = ? AND project_code = ?";

	/** 
	 * Index of column name_phase
	 */
	protected static final int COLUMN_NAME_PHASE = 1;

	/** 
	 * Index of column status
	 */
	protected static final int COLUMN_STATUS = 2;

	/** 
	 * Index of column project_code
	 */
	protected static final int COLUMN_PROJECT_CODE = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column name_phase
	 */
	protected static final int PK_COLUMN_NAME_PHASE = 1;

	/** 
	 * Index of primary-key column project_code
	 */
	protected static final int PK_COLUMN_PROJECT_CODE = 2;

	/** 
	 * Inserts a new row in the project_phase table.
	 */
	public ProjectPhasePk insert(ProjectPhase dto) throws ProjectPhaseDaoException
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
			stmt.setString( index++, dto.getNamePhase() );
			stmt.setShort( index++, dto.getStatus() );
			stmt.setString( index++, dto.getProjectCode() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProjectPhaseDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the project_phase table.
	 */
	public void update(ProjectPhasePk pk, ProjectPhase dto) throws ProjectPhaseDaoException
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
			stmt.setString( index++, dto.getNamePhase() );
			stmt.setShort( index++, dto.getStatus() );
			stmt.setString( index++, dto.getProjectCode() );
			stmt.setString( 4, pk.getNamePhase() );
			stmt.setString( 5, pk.getProjectCode() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProjectPhaseDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the project_phase table.
	 */
	public void delete(ProjectPhasePk pk) throws ProjectPhaseDaoException
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
			stmt.setString( 1, pk.getNamePhase() );
			stmt.setString( 2, pk.getProjectCode() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProjectPhaseDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the project_phase table that matches the specified primary-key value.
	 */
	public ProjectPhase findByPrimaryKey(ProjectPhasePk pk) throws ProjectPhaseDaoException
	{
		return findByPrimaryKey( pk.getNamePhase(), pk.getProjectCode() );
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria 'name_phase = :namePhase AND project_code = :projectCode'.
	 */
	public ProjectPhase findByPrimaryKey(String namePhase, String projectCode) throws ProjectPhaseDaoException
	{
		ProjectPhase ret[] = findByDynamicSelect( SQL_SELECT + " WHERE name_phase = ? AND project_code = ?", new Object[] { namePhase, projectCode } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria ''.
	 */
	public ProjectPhase[] findAll() throws ProjectPhaseDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY name_phase, project_code", null );
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria 'project_code = :projectCode'.
	 */
	public ProjectPhase[] findByProject(String projectCode) throws ProjectPhaseDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE project_code = ?", new Object[] { projectCode } );
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria 'name_phase = :namePhase'.
	 */
	public ProjectPhase[] findWhereNamePhaseEquals(String namePhase) throws ProjectPhaseDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_phase = ? ORDER BY name_phase", new Object[] { namePhase } );
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria 'status = :status'.
	 */
	public ProjectPhase[] findWhereStatusEquals(short status) throws ProjectPhaseDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE status = ? ORDER BY status", new Object[] {  new Short(status) } );
	}

	/** 
	 * Returns all rows from the project_phase table that match the criteria 'project_code = :projectCode'.
	 */
	public ProjectPhase[] findWhereProjectCodeEquals(String projectCode) throws ProjectPhaseDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE project_code = ? ORDER BY project_code", new Object[] { projectCode } );
	}

	/**
	 * Method 'ProjectPhaseDaoImpl'
	 * 
	 */
	public ProjectPhaseDaoImpl()
	{
	}

	/**
	 * Method 'ProjectPhaseDaoImpl'
	 * 
	 * @param userConn
	 */
	public ProjectPhaseDaoImpl(final java.sql.Connection userConn)
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
		return "tidsplan.project_phase";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ProjectPhase fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ProjectPhase dto = new ProjectPhase();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ProjectPhase[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ProjectPhase dto = new ProjectPhase();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ProjectPhase ret[] = new ProjectPhase[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ProjectPhase dto, ResultSet rs) throws SQLException
	{
		dto.setNamePhase( rs.getString( COLUMN_NAME_PHASE ) );
		dto.setStatus( rs.getShort( COLUMN_STATUS ) );
		dto.setProjectCode( rs.getString( COLUMN_PROJECT_CODE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ProjectPhase dto)
	{
	}

	/** 
	 * Returns all rows from the project_phase table that match the specified arbitrary SQL statement
	 */
	public ProjectPhase[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProjectPhaseDaoException
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
			throw new ProjectPhaseDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the project_phase table that match the specified arbitrary SQL statement
	 */
	public ProjectPhase[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProjectPhaseDaoException
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
			throw new ProjectPhaseDaoException( "Exception: " + _e.getMessage(), _e );
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
