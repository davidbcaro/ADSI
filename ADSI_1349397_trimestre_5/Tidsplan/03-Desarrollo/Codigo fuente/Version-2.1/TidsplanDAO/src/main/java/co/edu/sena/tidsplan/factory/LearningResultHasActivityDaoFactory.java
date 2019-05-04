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

public class LearningResultHasActivityDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return LearningResultHasActivityDao
	 */
	public static LearningResultHasActivityDao create()
	{
		return new LearningResultHasActivityDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return LearningResultHasActivityDao
	 */
	public static LearningResultHasActivityDao create(Connection conn)
	{
		return new LearningResultHasActivityDaoImpl( conn );
	}

}
