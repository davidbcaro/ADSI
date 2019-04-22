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

public class StatusFichaDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return StatusFichaDao
	 */
	public static StatusFichaDao create()
	{
		return new StatusFichaDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StatusFichaDao
	 */
	public static StatusFichaDao create(Connection conn)
	{
		return new StatusFichaDaoImpl( conn );
	}

}