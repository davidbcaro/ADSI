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

public class ScheduleDaoImpl extends AbstractDAO implements ScheduleDao
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
	protected final String SQL_SELECT = "SELECT document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET document_Number = ?, id_Document = ?, start_Time = ?, end_Time = ?, name_Day = ?, modality_Name = ?, number_Ambience = ?, name_Headquarters = ?, number_Ficha = ?, quarter_Name = ?, acronyms_Working_Day = ?, idVersion = ?, idCurrent_Quarter = ? WHERE document_Number = ? AND id_Document = ? AND name_Day = ? AND number_Ambience = ? AND name_Headquarters = ? AND number_Ficha = ? AND quarter_Name = ? AND acronyms_Working_Day = ? AND idVersion = ? AND idCurrent_Quarter = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE document_Number = ? AND id_Document = ? AND name_Day = ? AND number_Ambience = ? AND name_Headquarters = ? AND number_Ficha = ? AND quarter_Name = ? AND acronyms_Working_Day = ? AND idVersion = ? AND idCurrent_Quarter = ?";

	/** 
	 * Index of column document_Number
	 */
	protected static final int COLUMN_DOCUMENT_NUMBER = 1;

	/** 
	 * Index of column id_Document
	 */
	protected static final int COLUMN_ID_DOCUMENT = 2;

	/** 
	 * Index of column start_Time
	 */
	protected static final int COLUMN_START_TIME = 3;

	/** 
	 * Index of column end_Time
	 */
	protected static final int COLUMN_END_TIME = 4;

	/** 
	 * Index of column name_Day
	 */
	protected static final int COLUMN_NAME_DAY = 5;

	/** 
	 * Index of column modality_Name
	 */
	protected static final int COLUMN_MODALITY_NAME = 6;

	/** 
	 * Index of column number_Ambience
	 */
	protected static final int COLUMN_NUMBER_AMBIENCE = 7;

	/** 
	 * Index of column name_Headquarters
	 */
	protected static final int COLUMN_NAME_HEADQUARTERS = 8;

	/** 
	 * Index of column number_Ficha
	 */
	protected static final int COLUMN_NUMBER_FICHA = 9;

	/** 
	 * Index of column quarter_Name
	 */
	protected static final int COLUMN_QUARTER_NAME = 10;

	/** 
	 * Index of column acronyms_Working_Day
	 */
	protected static final int COLUMN_ACRONYMS_WORKING_DAY = 11;

	/** 
	 * Index of column idVersion
	 */
	protected static final int COLUMN_ID_VERSION = 12;

	/** 
	 * Index of column idCurrent_Quarter
	 */
	protected static final int COLUMN_IDCURRENT_QUARTER = 13;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 13;

	/** 
	 * Index of primary-key column document_Number
	 */
	protected static final int PK_COLUMN_DOCUMENT_NUMBER = 1;

	/** 
	 * Index of primary-key column id_Document
	 */
	protected static final int PK_COLUMN_ID_DOCUMENT = 2;

	/** 
	 * Index of primary-key column name_Day
	 */
	protected static final int PK_COLUMN_NAME_DAY = 3;

	/** 
	 * Index of primary-key column number_Ambience
	 */
	protected static final int PK_COLUMN_NUMBER_AMBIENCE = 4;

	/** 
	 * Index of primary-key column name_Headquarters
	 */
	protected static final int PK_COLUMN_NAME_HEADQUARTERS = 5;

	/** 
	 * Index of primary-key column number_Ficha
	 */
	protected static final int PK_COLUMN_NUMBER_FICHA = 6;

	/** 
	 * Index of primary-key column quarter_Name
	 */
	protected static final int PK_COLUMN_QUARTER_NAME = 7;

	/** 
	 * Index of primary-key column acronyms_Working_Day
	 */
	protected static final int PK_COLUMN_ACRONYMS_WORKING_DAY = 8;

	/** 
	 * Index of primary-key column idVersion
	 */
	protected static final int PK_COLUMN_ID_VERSION = 9;

	/** 
	 * Index of primary-key column idCurrent_Quarter
	 */
	protected static final int PK_COLUMN_IDCURRENT_QUARTER = 10;

	/** 
	 * Inserts a new row in the schedule table.
	 */
	public SchedulePk insert(Schedule dto) throws ScheduleDaoException
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
			stmt.setString( index++, dto.getIdDocument() );
			stmt.setString( index++, dto.getStartTime() );
			stmt.setString( index++, dto.getEndTime() );
			stmt.setString( index++, dto.getNameDay() );
			stmt.setString( index++, dto.getModalityName() );
			stmt.setString( index++, dto.getNumberAmbience() );
			stmt.setString( index++, dto.getNameHeadquarters() );
			stmt.setString( index++, dto.getNumberFicha() );
			stmt.setString( index++, dto.getQuarterName() );
			stmt.setString( index++, dto.getAcronymsWorkingDay() );
			stmt.setInt( index++, dto.getIdVersion() );
			stmt.setString( index++, dto.getIdcurrentQuarter() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ScheduleDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the schedule table.
	 */
	public void update(SchedulePk pk, Schedule dto) throws ScheduleDaoException
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
			stmt.setString( index++, dto.getIdDocument() );
			stmt.setString( index++, dto.getStartTime() );
			stmt.setString( index++, dto.getEndTime() );
			stmt.setString( index++, dto.getNameDay() );
			stmt.setString( index++, dto.getModalityName() );
			stmt.setString( index++, dto.getNumberAmbience() );
			stmt.setString( index++, dto.getNameHeadquarters() );
			stmt.setString( index++, dto.getNumberFicha() );
			stmt.setString( index++, dto.getQuarterName() );
			stmt.setString( index++, dto.getAcronymsWorkingDay() );
			stmt.setInt( index++, dto.getIdVersion() );
			stmt.setString( index++, dto.getIdcurrentQuarter() );
			stmt.setString( 14, pk.getDocumentNumber() );
			stmt.setString( 15, pk.getIdDocument() );
			stmt.setString( 16, pk.getNameDay() );
			stmt.setString( 17, pk.getNumberAmbience() );
			stmt.setString( 18, pk.getNameHeadquarters() );
			stmt.setString( 19, pk.getNumberFicha() );
			stmt.setString( 20, pk.getQuarterName() );
			stmt.setString( 21, pk.getAcronymsWorkingDay() );
			stmt.setInt( 22, pk.getIdVersion() );
			stmt.setString( 23, pk.getIdcurrentQuarter() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ScheduleDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the schedule table.
	 */
	public void delete(SchedulePk pk) throws ScheduleDaoException
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
			stmt.setString( 3, pk.getNameDay() );
			stmt.setString( 4, pk.getNumberAmbience() );
			stmt.setString( 5, pk.getNameHeadquarters() );
			stmt.setString( 6, pk.getNumberFicha() );
			stmt.setString( 7, pk.getQuarterName() );
			stmt.setString( 8, pk.getAcronymsWorkingDay() );
			stmt.setInt( 9, pk.getIdVersion() );
			stmt.setString( 10, pk.getIdcurrentQuarter() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ScheduleDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the schedule table that matches the specified primary-key value.
	 */
	public Schedule findByPrimaryKey(SchedulePk pk) throws ScheduleDaoException
	{
		return findByPrimaryKey( pk.getDocumentNumber(), pk.getIdDocument(), pk.getNameDay(), pk.getNumberAmbience(), pk.getNameHeadquarters(), pk.getNumberFicha(), pk.getQuarterName(), pk.getAcronymsWorkingDay(), pk.getIdVersion(), pk.getIdcurrentQuarter() );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'document_Number = :documentNumber AND id_Document = :idDocument AND name_Day = :nameDay AND number_Ambience = :numberAmbience AND name_Headquarters = :nameHeadquarters AND number_Ficha = :numberFicha AND quarter_Name = :quarterName AND acronyms_Working_Day = :acronymsWorkingDay AND idVersion = :idVersion AND idCurrent_Quarter = :idcurrentQuarter'.
	 */
	public Schedule findByPrimaryKey(String documentNumber, String idDocument, String nameDay, String numberAmbience, String nameHeadquarters, String numberFicha, String quarterName, String acronymsWorkingDay, int idVersion, String idcurrentQuarter) throws ScheduleDaoException
	{
		Schedule ret[] = findByDynamicSelect( SQL_SELECT + " WHERE document_Number = ? AND id_Document = ? AND name_Day = ? AND number_Ambience = ? AND name_Headquarters = ? AND number_Ficha = ? AND quarter_Name = ? AND acronyms_Working_Day = ? AND idVersion = ? AND idCurrent_Quarter = ?", new Object[] { documentNumber, idDocument, nameDay, numberAmbience, nameHeadquarters, numberFicha, quarterName, acronymsWorkingDay,  new Integer(idVersion), idcurrentQuarter } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria ''.
	 */
	public Schedule[] findAll() throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY document_Number, id_Document, name_Day, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter", null );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'name_Headquarters = :nameHeadquarters AND number_Ambience = :numberAmbience'.
	 */
	public Schedule[] findByAmbience(String nameHeadquarters, String numberAmbience) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_Headquarters = ? AND number_Ambience = ?", new Object[] { nameHeadquarters, numberAmbience } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'name_Day = :nameDay'.
	 */
	public Schedule[] findByDay(String nameDay) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_Day = ?", new Object[] { nameDay } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'number_Ficha = :numberFicha AND quarter_Name = :quarterName AND acronyms_Working_Day = :acronymsWorkingDay'.
	 */
	public Schedule[] findByFichaHasTrimester(String numberFicha, String quarterName, String acronymsWorkingDay) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE number_Ficha = ? AND quarter_Name = ? AND acronyms_Working_Day = ?", new Object[] { numberFicha, quarterName, acronymsWorkingDay } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'document_Number = :documentNumber AND id_Document = :idDocument'.
	 */
	public Schedule[] findByInstructor(String documentNumber, String idDocument) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE document_Number = ? AND id_Document = ?", new Object[] { documentNumber, idDocument } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'modality_Name = :modalityName'.
	 */
	public Schedule[] findByModality(String modalityName) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE modality_Name = ?", new Object[] { modalityName } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'idCurrent_Quarter = :idcurrentQuarter AND idVersion = :idVersion'.
	 */
	public Schedule[] findByVersion(String idcurrentQuarter, int idVersion) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE idCurrent_Quarter = ? AND idVersion = ?", new Object[] { idcurrentQuarter,  new Integer(idVersion) } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'document_Number = :documentNumber'.
	 */
	public Schedule[] findWhereDocumentNumberEquals(String documentNumber) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE document_Number = ? ORDER BY document_Number", new Object[] { documentNumber } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'id_Document = :idDocument'.
	 */
	public Schedule[] findWhereIdDocumentEquals(String idDocument) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_Document = ? ORDER BY id_Document", new Object[] { idDocument } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'start_Time = :startTime'.
	 */
	public Schedule[] findWhereStartTimeEquals(String startTime) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE start_Time = ? ORDER BY start_Time", new Object[] { startTime } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'end_Time = :endTime'.
	 */
	public Schedule[] findWhereEndTimeEquals(String endTime) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE end_Time = ? ORDER BY end_Time", new Object[] { endTime } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'name_Day = :nameDay'.
	 */
	public Schedule[] findWhereNameDayEquals(String nameDay) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_Day = ? ORDER BY name_Day", new Object[] { nameDay } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'modality_Name = :modalityName'.
	 */
	public Schedule[] findWhereModalityNameEquals(String modalityName) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE modality_Name = ? ORDER BY modality_Name", new Object[] { modalityName } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'number_Ambience = :numberAmbience'.
	 */
	public Schedule[] findWhereNumberAmbienceEquals(String numberAmbience) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE number_Ambience = ? ORDER BY number_Ambience", new Object[] { numberAmbience } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'name_Headquarters = :nameHeadquarters'.
	 */
	public Schedule[] findWhereNameHeadquartersEquals(String nameHeadquarters) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name_Headquarters = ? ORDER BY name_Headquarters", new Object[] { nameHeadquarters } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'number_Ficha = :numberFicha'.
	 */
	public Schedule[] findWhereNumberFichaEquals(String numberFicha) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE number_Ficha = ? ORDER BY number_Ficha", new Object[] { numberFicha } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'quarter_Name = :quarterName'.
	 */
	public Schedule[] findWhereQuarterNameEquals(String quarterName) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE quarter_Name = ? ORDER BY quarter_Name", new Object[] { quarterName } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'acronyms_Working_Day = :acronymsWorkingDay'.
	 */
	public Schedule[] findWhereAcronymsWorkingDayEquals(String acronymsWorkingDay) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE acronyms_Working_Day = ? ORDER BY acronyms_Working_Day", new Object[] { acronymsWorkingDay } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'idVersion = :idVersion'.
	 */
	public Schedule[] findWhereIdVersionEquals(int idVersion) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE idVersion = ? ORDER BY idVersion", new Object[] {  new Integer(idVersion) } );
	}

	/** 
	 * Returns all rows from the schedule table that match the criteria 'idCurrent_Quarter = :idcurrentQuarter'.
	 */
	public Schedule[] findWhereIdcurrentQuarterEquals(String idcurrentQuarter) throws ScheduleDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE idCurrent_Quarter = ? ORDER BY idCurrent_Quarter", new Object[] { idcurrentQuarter } );
	}

	/**
	 * Method 'ScheduleDaoImpl'
	 * 
	 */
	public ScheduleDaoImpl()
	{
	}

	/**
	 * Method 'ScheduleDaoImpl'
	 * 
	 * @param userConn
	 */
	public ScheduleDaoImpl(final java.sql.Connection userConn)
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
		return "eon.schedule";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Schedule fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Schedule dto = new Schedule();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Schedule[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Schedule dto = new Schedule();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Schedule ret[] = new Schedule[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Schedule dto, ResultSet rs) throws SQLException
	{
		dto.setDocumentNumber( rs.getString( COLUMN_DOCUMENT_NUMBER ) );
		dto.setIdDocument( rs.getString( COLUMN_ID_DOCUMENT ) );
		dto.setStartTime( rs.getString( COLUMN_START_TIME ) );
		dto.setEndTime( rs.getString( COLUMN_END_TIME ) );
		dto.setNameDay( rs.getString( COLUMN_NAME_DAY ) );
		dto.setModalityName( rs.getString( COLUMN_MODALITY_NAME ) );
		dto.setNumberAmbience( rs.getString( COLUMN_NUMBER_AMBIENCE ) );
		dto.setNameHeadquarters( rs.getString( COLUMN_NAME_HEADQUARTERS ) );
		dto.setNumberFicha( rs.getString( COLUMN_NUMBER_FICHA ) );
		dto.setQuarterName( rs.getString( COLUMN_QUARTER_NAME ) );
		dto.setAcronymsWorkingDay( rs.getString( COLUMN_ACRONYMS_WORKING_DAY ) );
		dto.setIdVersion( rs.getInt( COLUMN_ID_VERSION ) );
		dto.setIdcurrentQuarter( rs.getString( COLUMN_IDCURRENT_QUARTER ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Schedule dto)
	{
	}

	/** 
	 * Returns all rows from the schedule table that match the specified arbitrary SQL statement
	 */
	public Schedule[] findByDynamicSelect(String sql, Object[] sqlParams) throws ScheduleDaoException
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
			throw new ScheduleDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the schedule table that match the specified arbitrary SQL statement
	 */
	public Schedule[] findByDynamicWhere(String sql, Object[] sqlParams) throws ScheduleDaoException
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
			throw new ScheduleDaoException( "Exception: " + _e.getMessage(), _e );
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
