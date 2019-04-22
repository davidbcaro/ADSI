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
import co.edu.sena.controler.dao.dao.CustomerDao;
import co.edu.sena.controler.dao.dto.Customer;
import co.edu.sena.controler.dao.exceptions.CustomerDaoException;
import co.edu.sena.controler.dao.factory.CustomerDaoFactory;

public class CustomerDaoSample
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
		// findByIdentificationCard("");
		// findWhereDocumentTypeEquals("");
		// findWhereFirstNameEquals("");
		// findWhereSecondNameEquals("");
		// findWhereFirstLastNameEquals("");
		// findWhereSecondLastNameEquals("");
		// findWherePhotoEquals(null);
		// findWhereIdentificationCardNumberEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByIdentificationCard'
	 * 
	 * @param identificationCardNumber
	 */
	public static void findByIdentificationCard(String identificationCardNumber)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findByIdentificationCard(identificationCardNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDocumentTypeEquals'
	 * 
	 * @param documentType
	 */
	public static void findWhereDocumentTypeEquals(String documentType)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereDocumentTypeEquals(documentType);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereFirstNameEquals'
	 * 
	 * @param firstName
	 */
	public static void findWhereFirstNameEquals(String firstName)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereFirstNameEquals(firstName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSecondNameEquals'
	 * 
	 * @param secondName
	 */
	public static void findWhereSecondNameEquals(String secondName)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereSecondNameEquals(secondName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereFirstLastNameEquals'
	 * 
	 * @param firstLastName
	 */
	public static void findWhereFirstLastNameEquals(String firstLastName)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereFirstLastNameEquals(firstLastName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSecondLastNameEquals'
	 * 
	 * @param secondLastName
	 */
	public static void findWhereSecondLastNameEquals(String secondLastName)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereSecondLastNameEquals(secondLastName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePhotoEquals'
	 * 
	 * @param photo
	 */
	public static void findWherePhotoEquals(byte[] photo)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWherePhotoEquals(photo);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdentificationCardNumberEquals'
	 * 
	 * @param identificationCardNumber
	 */
	public static void findWhereIdentificationCardNumberEquals(String identificationCardNumber)
	{
		try {
			CustomerDao _dao = getCustomerDao();
			Customer _result[] = _dao.findWhereIdentificationCardNumberEquals(identificationCardNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getCustomerDao'
	 * 
	 * @return CustomerDao
	 */
	public static CustomerDao getCustomerDao()
	{
		return CustomerDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Customer dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getDocumentType() );
		buf.append( ", " );
		buf.append( dto.getFirstName() );
		buf.append( ", " );
		buf.append( dto.getSecondName() );
		buf.append( ", " );
		buf.append( dto.getFirstLastName() );
		buf.append( ", " );
		buf.append( dto.getSecondLastName() );
		buf.append( ", " );
		buf.append( dto.getPhoto() );
		buf.append( ", " );
		buf.append( dto.getIdentificationCardNumber() );
		System.out.println( buf.toString() );
	}

}