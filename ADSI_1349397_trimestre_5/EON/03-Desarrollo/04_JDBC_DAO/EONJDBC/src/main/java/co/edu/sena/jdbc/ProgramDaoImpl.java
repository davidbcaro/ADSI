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

public class ProgramDaoImpl extends AbstractDAO implements ProgramDao
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
	protected final String SQL_SELECT = "SELECT Program_Code, Version, Name, Initials, State, training_Level FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( Program_Code, Version, Name, Initials, State, training_Level ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET Program_Code = ?, Version = ?, Name = ?, Initials = ?, State = ?, training_Level = ? WHERE Program_Code = ? AND Version = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE Program_Code = ? AND Version = ?";

	/** 
	 * Index of column Program_Code
	 */
	protected static final int COLUMN_PROGRAM_CODE = 1;

	/** 
	 * Index of column Version
	 */
	protected static final int COLUMN_VERSION = 2;

	/** 
	 * Index of column Name
	 */
	protected static final int COLUMN_NAME = 3;

	/** 
	 * Index of column Initials
	 */
	protected static final int COLUMN_INITIALS = 4;

	/** 
	 * Index of column State
	 */
	protected static final int COLUMN_STATE = 5;

	/** 
	 * Index of column training_Level
	 */
	protected static final int COLUMN_TRAINING_LEVEL = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column Program_Code
	 */
	protected static final int PK_COLUMN_PROGRAM_CODE = 1;

	/** 
	 * Index of primary-key column Version
	 */
	protected static final int PK_COLUMN_VERSION = 2;

	/** 
	 * Inserts a new row in the program table.
	 */
	public ProgramPk insert(Program dto) throws ProgramDaoException
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
			stmt.setString( index++, dto.getProgramCode() );
			stmt.setString( index++, dto.getVersion() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getInitials() );
			if (dto.isStateNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getState() );
			}
		
			stmt.setString( index++, dto.getTrainingLevel() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProgramDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the program table.
	 */
	public void update(ProgramPk pk, Program dto) throws ProgramDaoException
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
			stmt.setString( index++, dto.getProgramCode() );
			stmt.setString( index++, dto.getVersion() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getInitials() );
			if (dto.isStateNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getState() );
			}
		
			stmt.setString( index++, dto.getTrainingLevel() );
			stmt.setString( 7, pk.getProgramCode() );
			stmt.setString( 8, pk.getVersion() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProgramDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the program table.
	 */
	public void delete(ProgramPk pk) throws ProgramDaoException
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
			stmt.setString( 1, pk.getProgramCode() );
			stmt.setString( 2, pk.getVersion() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ProgramDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the program table that matches the specified primary-key value.
	 */
	public Program findByPrimaryKey(ProgramPk pk) throws ProgramDaoException
	{
		return findByPrimaryKey( pk.getProgramCode(), pk.getVersion() );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'Program_Code = :programCode AND Version = :version'.
	 */
	public Program findByPrimaryKey(String programCode, String version) throws ProgramDaoException
	{
		Program ret[] = findByDynamicSelect( SQL_SELECT + " WHERE Program_Code = ? AND Version = ?", new Object[] { programCode, version } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the program table that match the criteria ''.
	 */
	public Program[] findAll() throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY Program_Code, Version", null );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'training_Level = :trainingLevel'.
	 */
	public Program[] findByTrainingLevel(String trainingLevel) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE training_Level = ?", new Object[] { trainingLevel } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'Program_Code = :programCode'.
	 */
	public Program[] findWhereProgramCodeEquals(String programCode) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Program_Code = ? ORDER BY Program_Code", new Object[] { programCode } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'Version = :version'.
	 */
	public Program[] findWhereVersionEquals(String version) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Version = ? ORDER BY Version", new Object[] { version } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'Name = :name'.
	 */
	public Program[] findWhereNameEquals(String name) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Name = ? ORDER BY Name", new Object[] { name } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'Initials = :initials'.
	 */
	public Program[] findWhereInitialsEquals(String initials) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Initials = ? ORDER BY Initials", new Object[] { initials } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'State = :state'.
	 */
	public Program[] findWhereStateEquals(short state) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE State = ? ORDER BY State", new Object[] {  new Short(state) } );
	}

	/** 
	 * Returns all rows from the program table that match the criteria 'training_Level = :trainingLevel'.
	 */
	public Program[] findWhereTrainingLevelEquals(String trainingLevel) throws ProgramDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE training_Level = ? ORDER BY training_Level", new Object[] { trainingLevel } );
	}

	/**
	 * Method 'ProgramDaoImpl'
	 * 
	 */
	public ProgramDaoImpl()
	{
	}

	/**
	 * Method 'ProgramDaoImpl'
	 * 
	 * @param userConn
	 */
	public ProgramDaoImpl(final java.sql.Connection userConn)
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
		return "eon.program";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Program fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Program dto = new Program();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Program[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Program dto = new Program();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Program ret[] = new Program[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Program dto, ResultSet rs) throws SQLException
	{
		dto.setProgramCode( rs.getString( COLUMN_PROGRAM_CODE ) );
		dto.setVersion( rs.getString( COLUMN_VERSION ) );
		dto.setName( rs.getString( COLUMN_NAME ) );
		dto.setInitials( rs.getString( COLUMN_INITIALS ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
		if (rs.wasNull()) {
			dto.setStateNull( true );
		}
		
		dto.setTrainingLevel( rs.getString( COLUMN_TRAINING_LEVEL ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Program dto)
	{
	}

	/** 
	 * Returns all rows from the program table that match the specified arbitrary SQL statement
	 */
	public Program[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProgramDaoException
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
			throw new ProgramDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the program table that match the specified arbitrary SQL statement
	 */
	public Program[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProgramDaoException
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
			throw new ProgramDaoException( "Exception: " + _e.getMessage(), _e );
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