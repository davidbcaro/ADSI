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

public class ScheduleDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ScheduleDao
	 */
	public static ScheduleDao create()
	{
		return new ScheduleDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ScheduleDao
	 */
	public static ScheduleDao create(Connection conn)
	{
		return new ScheduleDaoImpl( conn );
	}

}
