/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the role table.
 */
public class RolePk implements Serializable
{
	protected String idRole;

	/** 
	 * Sets the value of idRole
	 */
	public void setIdRole(String idRole)
	{
		this.idRole = idRole;
	}

	/** 
	 * Gets the value of idRole
	 */
	public String getIdRole()
	{
		return idRole;
	}

	/**
	 * Method 'RolePk'
	 * 
	 */
	public RolePk()
	{
	}

	/**
	 * Method 'RolePk'
	 * 
	 * @param idRole
	 */
	public RolePk(final String idRole)
	{
		this.idRole = idRole;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof RolePk)) {
			return false;
		}
		
		final RolePk _cast = (RolePk) _other;
		if (idRole == null ? _cast.idRole != idRole : !idRole.equals( _cast.idRole )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idRole != null) {
			_hashCode = 29 * _hashCode + idRole.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.RolePk: " );
		ret.append( "idRole=" + idRole );
		return ret.toString();
	}

}
