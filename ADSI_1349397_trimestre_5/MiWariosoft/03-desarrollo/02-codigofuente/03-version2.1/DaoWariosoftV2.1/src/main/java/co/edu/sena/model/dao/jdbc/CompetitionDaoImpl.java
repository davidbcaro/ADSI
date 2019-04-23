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

public class CompetitionDaoImpl extends AbstractDAO implements CompetitionDao
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
	protected final String SQL_SELECT = "SELECT competition_Code, description, program_Code, version FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( competition_Code, description, program_Code, version ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET competition_Code = ?, description = ?, program_Code = ?, version = ? WHERE competition_Code = ? AND program_Code = ? AND version = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE competition_Code = ? AND program_Code = ? AND version = ?";

	/** 
	 * Index of column competition_Code
	 */
	protected static final int COLUMN_COMPETITION_CODE = 1;

	/** 
	 * Index of column description
	 */
	protected static final int COLUMN_DESCRIPTION = 2;

	/** 
	 * Index of column program_Code
	 */
	protected static final int COLUMN_PROGRAM_CODE = 3;

	/** 
	 * Index of column version
	 */
	protected static final int COLUMN_VERSION = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column competition_Code
	 */
	protected static final int PK_COLUMN_COMPETITION_CODE = 1;

	/** 
	 * Index of primary-key column program_Code
	 */
	protected static final int PK_COLUMN_PROGRAM_CODE = 2;

	/** 
	 * Index of primary-key column version
	 */
	protected static final int PK_COLUMN_VERSION = 3;

	/** 
	 * Inserts a new row in the competition table.
	 */
	public CompetitionPk insert(Competition dto) throws CompetitionDaoException
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
			stmt.setString( index++, dto.getCompetitionCode() );
			stmt.setString( index++, dto.getDescription() );
			stmt.setString( index++, dto.getProgramCode() );
			stmt.setString( index++, dto.getVersion() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CompetitionDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the competition table.
	 */
	public void update(CompetitionPk pk, Competition dto) throws CompetitionDaoException
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
			stmt.setString( index++, dto.getCompetitionCode() );
			stmt.setString( index++, dto.getDescription() );
			stmt.setString( index++, dto.getProgramCode() );
			stmt.setString( index++, dto.getVersion() );
			stmt.setString( 5, pk.getCompetitionCode() );
			stmt.setString( 6, pk.getProgramCode() );
			stmt.setString( 7, pk.getVersion() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CompetitionDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the competition table.
	 */
	public void delete(CompetitionPk pk) throws CompetitionDaoException
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
			stmt.setString( 1, pk.getCompetitionCode() );
			stmt.setString( 2, pk.getProgramCode() );
			stmt.setString( 3, pk.getVersion() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CompetitionDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the competition table that matches the specified primary-key value.
	 */
	public Competition findByPrimaryKey(CompetitionPk pk) throws CompetitionDaoException
	{
		return findByPrimaryKey( pk.getCompetitionCode(), pk.getProgramCode(), pk.getVersion() );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'competition_Code = :competitionCode AND program_Code = :programCode AND version = :version'.
	 */
	public Competition findByPrimaryKey(String competitionCode, String programCode, String version) throws CompetitionDaoException
	{
		Competition ret[] = findByDynamicSelect( SQL_SELECT + " WHERE competition_Code = ? AND program_Code = ? AND version = ?", new Object[] { competitionCode, programCode, version } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the competition table that match the criteria ''.
	 */
	public Competition[] findAll() throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY competition_Code, program_Code, version", null );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'program_Code = :programCode AND version = :version'.
	 */
	public Competition[] findByProgram(String programCode, String version) throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE program_Code = ? AND version = ?", new Object[] { programCode, version } );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'competition_Code = :competitionCode'.
	 */
	public Competition[] findWhereCompetitionCodeEquals(String competitionCode) throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE competition_Code = ? ORDER BY competition_Code", new Object[] { competitionCode } );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'description = :description'.
	 */
	public Competition[] findWhereDescriptionEquals(String description) throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE description = ? ORDER BY description", new Object[] { description } );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'program_Code = :programCode'.
	 */
	public Competition[] findWhereProgramCodeEquals(String programCode) throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE program_Code = ? ORDER BY program_Code", new Object[] { programCode } );
	}

	/** 
	 * Returns all rows from the competition table that match the criteria 'version = :version'.
	 */
	public Competition[] findWhereVersionEquals(String version) throws CompetitionDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE version = ? ORDER BY version", new Object[] { version } );
	}

	/**
	 * Method 'CompetitionDaoImpl'
	 * 
	 */
	public CompetitionDaoImpl()
	{
	}

	/**
	 * Method 'CompetitionDaoImpl'
	 * 
	 * @param userConn
	 */
	public CompetitionDaoImpl(final java.sql.Connection userConn)
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
		return "wariosoft.competition";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Competition fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Competition dto = new Competition();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Competition[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Competition dto = new Competition();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Competition ret[] = new Competition[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Competition dto, ResultSet rs) throws SQLException
	{
		dto.setCompetitionCode( rs.getString( COLUMN_COMPETITION_CODE ) );
		dto.setDescription( rs.getString( COLUMN_DESCRIPTION ) );
		dto.setProgramCode( rs.getString( COLUMN_PROGRAM_CODE ) );
		dto.setVersion( rs.getString( COLUMN_VERSION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Competition dto)
	{
	}

	/** 
	 * Returns all rows from the competition table that match the specified arbitrary SQL statement
	 */
	public Competition[] findByDynamicSelect(String sql, Object[] sqlParams) throws CompetitionDaoException
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
			throw new CompetitionDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the competition table that match the specified arbitrary SQL statement
	 */
	public Competition[] findByDynamicWhere(String sql, Object[] sqlParams) throws CompetitionDaoException
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
			throw new CompetitionDaoException( "Exception: " + _e.getMessage(), _e );
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