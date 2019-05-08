/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.tidsplan.dao.LearningResultHasActivityDao;
import co.edu.sena.tidsplan.dto.LearningResultHasActivity;
import co.edu.sena.tidsplan.exceptions.LearningResultHasActivityDaoException;
import co.edu.sena.tidsplan.factory.LearningResultHasActivityDaoFactory;

public class LearningResultHasActivityDaoSample
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
		
		 findAll();
		// findByActivity("", "", "");
		// findByLearningResult("", "", "", "");
		// findWhereLrCodeEquals("");
		// findWhereProgramCodeEquals("");
		// findWhereCompetitionCodeEquals("");
		// findWhereIdActivityEquals("");
		// findWhereNamePhaseEquals("");
		// findWhereProjectCodeEquals("");
		// findWhereProgramVersionEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByActivity'
	 * 
	 * @param idActivity
	 * @param namePhase
	 * @param projectCode
	 */
	public static void findByActivity(String idActivity, String namePhase, String projectCode)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findByActivity(idActivity, namePhase, projectCode);
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
	 * @param lrCode
	 * @param programCode
	 * @param competitionCode
	 * @param programVersion
	 */
	public static void findByLearningResult(String lrCode, String programCode, String competitionCode, String programVersion)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findByLearningResult(lrCode, programCode, competitionCode, programVersion);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLrCodeEquals'
	 * 
	 * @param lrCode
	 */
	public static void findWhereLrCodeEquals(String lrCode)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereLrCodeEquals(lrCode);
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
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereProgramCodeEquals(programCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereCompetitionCodeEquals'
	 * 
	 * @param competitionCode
	 */
	public static void findWhereCompetitionCodeEquals(String competitionCode)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereCompetitionCodeEquals(competitionCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdActivityEquals'
	 * 
	 * @param idActivity
	 */
	public static void findWhereIdActivityEquals(String idActivity)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereIdActivityEquals(idActivity);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNamePhaseEquals'
	 * 
	 * @param namePhase
	 */
	public static void findWhereNamePhaseEquals(String namePhase)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereNamePhaseEquals(namePhase);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereProjectCodeEquals'
	 * 
	 * @param projectCode
	 */
	public static void findWhereProjectCodeEquals(String projectCode)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereProjectCodeEquals(projectCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereProgramVersionEquals'
	 * 
	 * @param programVersion
	 */
	public static void findWhereProgramVersionEquals(String programVersion)
	{
		try {
			LearningResultHasActivityDao _dao = getLearningResultHasActivityDao();
			LearningResultHasActivity _result[] = _dao.findWhereProgramVersionEquals(programVersion);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getLearningResultHasActivityDao'
	 * 
	 * @return LearningResultHasActivityDao
	 */
	public static LearningResultHasActivityDao getLearningResultHasActivityDao()
	{
		return LearningResultHasActivityDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(LearningResultHasActivity dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getLrCode() );
		buf.append( ", " );
		buf.append( dto.getProgramCode() );
		buf.append( ", " );
		buf.append( dto.getCompetitionCode() );
		buf.append( ", " );
		buf.append( dto.getIdActivity() );
		buf.append( ", " );
		buf.append( dto.getNamePhase() );
		buf.append( ", " );
		buf.append( dto.getProjectCode() );
		buf.append( ", " );
		buf.append( dto.getProgramVersion() );
		System.out.println( buf.toString() );
	}

}