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
import co.edu.sena.tidsplan.dao.ModalityDao;
import co.edu.sena.tidsplan.dto.Modality;
import co.edu.sena.tidsplan.exceptions.ModalityDaoException;
import co.edu.sena.tidsplan.factory.ModalityDaoFactory;

public class ModalityDaoSample
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
		// findWhereNameModalityEquals("");
		// findWhereStatusEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ModalityDao _dao = getModalityDao();
			Modality _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNameModalityEquals'
	 * 
	 * @param nameModality
	 */
	public static void findWhereNameModalityEquals(String nameModality)
	{
		try {
			ModalityDao _dao = getModalityDao();
			Modality _result[] = _dao.findWhereNameModalityEquals(nameModality);
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
			ModalityDao _dao = getModalityDao();
			Modality _result[] = _dao.findWhereStatusEquals(status);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getModalityDao'
	 * 
	 * @return ModalityDao
	 */
	public static ModalityDao getModalityDao()
	{
		return ModalityDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Modality dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getNameModality() );
		buf.append( ", " );
		buf.append( dto.getStatus() );
		System.out.println( buf.toString() );
	}

}
