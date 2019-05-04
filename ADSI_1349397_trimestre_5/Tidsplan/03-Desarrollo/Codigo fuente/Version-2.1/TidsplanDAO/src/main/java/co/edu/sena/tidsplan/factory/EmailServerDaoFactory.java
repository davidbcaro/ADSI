/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.factory;

import java.sql.Connection;
import co.edu.sena.tidsplan.dao.*;
import co.edu.sena.tidsplan.jdbc.*;

public class EmailServerDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return EmailServerDao
	 */
	public static EmailServerDao create()
	{
		return new EmailServerDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return EmailServerDao
	 */
	public static EmailServerDao create(Connection conn)
	{
		return new EmailServerDaoImpl( conn );
	}

}
