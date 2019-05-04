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

public class ActivityDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ActivityDao
	 */
	public static ActivityDao create()
	{
		return new ActivityDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ActivityDao
	 */
	public static ActivityDao create(Connection conn)
	{
		return new ActivityDaoImpl( conn );
	}

}
