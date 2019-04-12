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

public class InstructorDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return InstructorDao
	 */
	public static InstructorDao create()
	{
		return new InstructorDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return InstructorDao
	 */
	public static InstructorDao create(Connection conn)
	{
		return new InstructorDaoImpl( conn );
	}

}
