/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.model.dao.dao.TeacherDao;
import co.edu.sena.model.dao.dto.Teacher;
import co.edu.sena.model.dao.exceptions.TeacherDaoException;
import co.edu.sena.model.dao.factory.TeacherDaoFactory;

public class TeacherDaoSample
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
		// findByClient("", "");
		// findBySpecialty("");
		// findByLinking("");
		// findWhereIdDocumentEquals("");
		// findWhereDocumentNumberEquals("");
		// findWhereTypeLinkingEquals("");
		// findWhereNameSpecialtyEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByClient'
	 * 
	 * @param idDocument
	 * @param documentNumber
	 */
	public static void findByClient(String idDocument, String documentNumber)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findByClient(idDocument, documentNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findBySpecialty'
	 * 
	 * @param nameSpecialty
	 */
	public static void findBySpecialty(String nameSpecialty)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findBySpecialty(nameSpecialty);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByLinking'
	 * 
	 * @param typeLinking
	 */
	public static void findByLinking(String typeLinking)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findByLinking(typeLinking);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdDocumentEquals'
	 * 
	 * @param idDocument
	 */
	public static void findWhereIdDocumentEquals(String idDocument)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findWhereIdDocumentEquals(idDocument);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDocumentNumberEquals'
	 * 
	 * @param documentNumber
	 */
	public static void findWhereDocumentNumberEquals(String documentNumber)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findWhereDocumentNumberEquals(documentNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTypeLinkingEquals'
	 * 
	 * @param typeLinking
	 */
	public static void findWhereTypeLinkingEquals(String typeLinking)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findWhereTypeLinkingEquals(typeLinking);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNameSpecialtyEquals'
	 * 
	 * @param nameSpecialty
	 */
	public static void findWhereNameSpecialtyEquals(String nameSpecialty)
	{
		try {
			TeacherDao _dao = getTeacherDao();
			Teacher _result[] = _dao.findWhereNameSpecialtyEquals(nameSpecialty);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getTeacherDao'
	 * 
	 * @return TeacherDao
	 */
	public static TeacherDao getTeacherDao()
	{
		return TeacherDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Teacher dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdDocument() );
		buf.append( ", " );
		buf.append( dto.getDocumentNumber() );
		buf.append( ", " );
		buf.append( dto.getTypeLinking() );
		buf.append( ", " );
		buf.append( dto.getNameSpecialty() );
		System.out.println( buf.toString() );
	}

}