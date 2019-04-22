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
import co.edu.sena.controler.dao.dao.ActualityTrimesterDao;
import co.edu.sena.controler.dao.dto.ActualityTrimester;
import co.edu.sena.controler.dao.exceptions.ActualityTrimesterDaoException;
import co.edu.sena.controler.dao.factory.ActualityTrimesterDaoFactory;

public class ActualityTrimesterDaoSample
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
		 findWhereActualityTrimesterEquals("Trimestre 1");
		// findWhereDateStartEquals(null);
		// findWhereDateFinishEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ActualityTrimesterDao _dao = getActualityTrimesterDao();
			ActualityTrimester _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereActualityTrimesterEquals'
	 * 
	 * @param actualityTrimester
	 */
	public static void findWhereActualityTrimesterEquals(String actualityTrimester)
	{
		try {
			ActualityTrimesterDao _dao = getActualityTrimesterDao();
			ActualityTrimester _result[] = _dao.findWhereActualityTrimesterEquals(actualityTrimester);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateStartEquals'
	 * 
	 * @param dateStart
	 */
	public static void findWhereDateStartEquals(Date dateStart)
	{
		try {
			ActualityTrimesterDao _dao = getActualityTrimesterDao();
			ActualityTrimester _result[] = _dao.findWhereDateStartEquals(dateStart);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDateFinishEquals'
	 * 
	 * @param dateFinish
	 */
	public static void findWhereDateFinishEquals(Date dateFinish)
	{
		try {
			ActualityTrimesterDao _dao = getActualityTrimesterDao();
			ActualityTrimester _result[] = _dao.findWhereDateFinishEquals(dateFinish);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getActualityTrimesterDao'
	 * 
	 * @return ActualityTrimesterDao
	 */
	public static ActualityTrimesterDao getActualityTrimesterDao()
	{
		return ActualityTrimesterDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(ActualityTrimester dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getActualityTrimester() );
		buf.append( ", " );
		buf.append( dto.getDateStart() );
		buf.append( ", " );
		buf.append( dto.getDateFinish() );
		System.out.println( buf.toString() );
	}

}