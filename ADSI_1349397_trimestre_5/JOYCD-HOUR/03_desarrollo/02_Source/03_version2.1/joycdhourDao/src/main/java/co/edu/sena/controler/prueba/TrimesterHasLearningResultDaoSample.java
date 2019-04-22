/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controler.prueba;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.controler.dao.dao.TrimesterHasLearningResultDao;
import co.edu.sena.controler.dao.dto.TrimesterHasLearningResult;
import co.edu.sena.controler.dao.exceptions.TrimesterHasLearningResultDaoException;
import co.edu.sena.controler.dao.factory.TrimesterHasLearningResultDaoFactory;

public class TrimesterHasLearningResultDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findByLearningResult("", "", "", "");
		// findByTrimester("", "", "");
		// findWhereTrimesterNameEquals("");
		// findWhereWorkingDayInitialsEquals("");
		// findWhereLearningResultCodeEquals("");
		// findWhereProgramCodeEquals("");
		// findWhereCompetenceCodeEquals("");
		// findWhereLevelFormationEquals("");
		// findWhereVersionEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByLearningResult'
	 * 
	 * @param learningResultCode
	 * @param programCode
	 * @param competenceCode
	 * @param version
	 */
	public static void findByLearningResult(String learningResultCode, String programCode, String competenceCode, String version)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findByLearningResult(learningResultCode, programCode, competenceCode, version);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByTrimester'
	 * 
	 * @param trimesterName
	 * @param workingDayInitials
	 * @param levelFormation
	 */
	public static void findByTrimester(String trimesterName, String workingDayInitials, String levelFormation)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findByTrimester(trimesterName, workingDayInitials, levelFormation);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTrimesterNameEquals'
	 * 
	 * @param trimesterName
	 */
	public static void findWhereTrimesterNameEquals(String trimesterName)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereTrimesterNameEquals(trimesterName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereWorkingDayInitialsEquals'
	 * 
	 * @param workingDayInitials
	 */
	public static void findWhereWorkingDayInitialsEquals(String workingDayInitials)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereWorkingDayInitialsEquals(workingDayInitials);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLearningResultCodeEquals'
	 * 
	 * @param learningResultCode
	 */
	public static void findWhereLearningResultCodeEquals(String learningResultCode)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereLearningResultCodeEquals(learningResultCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereProgramCodeEquals'
	 * 
	 * @param programCode
	 */
	public static void findWhereProgramCodeEquals(String programCode)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereProgramCodeEquals(programCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereCompetenceCodeEquals'
	 * 
	 * @param competenceCode
	 */
	public static void findWhereCompetenceCodeEquals(String competenceCode)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereCompetenceCodeEquals(competenceCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLevelFormationEquals'
	 * 
	 * @param levelFormation
	 */
	public static void findWhereLevelFormationEquals(String levelFormation)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereLevelFormationEquals(levelFormation);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereVersionEquals'
	 * 
	 * @param version
	 */
	public static void findWhereVersionEquals(String version)
	{
		try {
			TrimesterHasLearningResultDao _dao = getTrimesterHasLearningResultDao();
			TrimesterHasLearningResult _result[] = _dao.findWhereVersionEquals(version);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getTrimesterHasLearningResultDao'
	 * 
	 * @return TrimesterHasLearningResultDao
	 */
	public static TrimesterHasLearningResultDao getTrimesterHasLearningResultDao()
	{
		return TrimesterHasLearningResultDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(TrimesterHasLearningResult dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getTrimesterName() );
		buf.append( ", " );
		buf.append( dto.getWorkingDayInitials() );
		buf.append( ", " );
		buf.append( dto.getLearningResultCode() );
		buf.append( ", " );
		buf.append( dto.getProgramCode() );
		buf.append( ", " );
		buf.append( dto.getCompetenceCode() );
		buf.append( ", " );
		buf.append( dto.getLevelFormation() );
		buf.append( ", " );
		buf.append( dto.getVersion() );
		System.out.println( buf.toString() );
	}

}