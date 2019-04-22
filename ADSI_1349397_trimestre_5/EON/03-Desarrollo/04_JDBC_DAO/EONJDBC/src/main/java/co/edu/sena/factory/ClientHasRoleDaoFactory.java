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

public class ClientHasRoleDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ClientHasRoleDao
	 */
	public static ClientHasRoleDao create()
	{
		return new ClientHasRoleDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ClientHasRoleDao
	 */
	public static ClientHasRoleDao create(Connection conn)
	{
		return new ClientHasRoleDaoImpl( conn );
	}

}