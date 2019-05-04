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
import co.edu.sena.tidsplan.dao.TrainingProgramDao;
import co.edu.sena.tidsplan.dto.TrainingProgram;
import co.edu.sena.tidsplan.exceptions.TrainingProgramDaoException;
import co.edu.sena.tidsplan.factory.TrainingProgramDaoFactory;

public class TrainingProgramDaoSample
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
		// findByFormationLevel("");
		// findWhereIdCodeEquals("");
		// findWhereNameEquals("");
		// findWhereVersionEquals("");
		// findWhereInitialsEquals("");
		// findWhereStatusEquals(0);
		// findWhereLevelFormationEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByFormationLevel'
	 * 
	 * @param levelFormation
	 */
	public static void findByFormationLevel(String levelFormation)
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findByFormationLevel(levelFormation);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdCodeEquals'
	 * 
	 * @param idCode
	 */
	public static void findWhereIdCodeEquals(String idCode)
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereIdCodeEquals(idCode);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNameEquals'
	 * 
	 * @param name
	 */
	public static void findWhereNameEquals(String name)
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereNameEquals(name);
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
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereVersionEquals(version);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereInitialsEquals'
	 * 
	 * @param initials
	 */
	public static void findWhereInitialsEquals(String initials)
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereInitialsEquals(initials);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStatusEquals'
	 * 
	 * @param status
	 */
	public static void findWhereStatusEquals(short status)
	{
		try {
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereStatusEquals(status);
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
			TrainingProgramDao _dao = getTrainingProgramDao();
			TrainingProgram _result[] = _dao.findWhereLevelFormationEquals(levelFormation);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getTrainingProgramDao'
	 * 
	 * @return TrainingProgramDao
	 */
	public static TrainingProgramDao getTrainingProgramDao()
	{
		return TrainingProgramDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(TrainingProgram dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdCode() );
		buf.append( ", " );
		buf.append( dto.getName() );
		buf.append( ", " );
		buf.append( dto.getVersion() );
		buf.append( ", " );
		buf.append( dto.getInitials() );
		buf.append( ", " );
		buf.append( dto.getStatus() );
		buf.append( ", " );
		buf.append( dto.getLevelFormation() );
		System.out.println( buf.toString() );
	}

}
