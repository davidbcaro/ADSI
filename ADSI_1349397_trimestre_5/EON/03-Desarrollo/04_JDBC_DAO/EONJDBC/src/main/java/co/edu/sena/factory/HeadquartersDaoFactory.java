/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.factory;

import java.sql.Connection;
import co.edu.sena.dao.*;
import co.edu.sena.jdbc.*;

public class HeadquartersDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return HeadquartersDao
	 */
	public static HeadquartersDao create()
	{
		return new HeadquartersDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return HeadquartersDao
	 */
	public static HeadquartersDao create(Connection conn)
	{
		return new HeadquartersDaoImpl( conn );
	}

}