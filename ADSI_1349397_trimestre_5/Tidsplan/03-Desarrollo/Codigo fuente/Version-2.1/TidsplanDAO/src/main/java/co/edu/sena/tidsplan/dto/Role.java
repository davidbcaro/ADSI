/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.dto;

import co.edu.sena.tidsplan.dao.*;
import co.edu.sena.tidsplan.factory.*;
import co.edu.sena.tidsplan.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class Role implements Serializable
{
	/** 
	 * This attribute maps to the column id_rol in the role table.
	 */
	protected String idRol;

	/** 
	 * This attribute maps to the column description in the role table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column status in the role table.
	 */
	protected short status;

	/** 
	 * This attribute represents whether the primitive attribute status is null.
	 */
	protected boolean statusNull = true;

	/**
	 * Method 'Role'
	 * 
	 */
	public Role()
	{
	}

	/**
	 * Method 'getIdRol'
	 * 
	 * @return String
	 */
	public String getIdRol()
	{
		return idRol;
	}

	/**
	 * Method 'setIdRol'
	 * 
	 * @param idRol
	 */
	public void setIdRol(String idRol)
	{
		this.idRol = idRol;
	}

	/**
	 * Method 'getDescription'
	 * 
	 * @return String
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Method 'setDescription'
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Method 'getStatus'
	 * 
	 * @return short
	 */
	public short getStatus()
	{
		return status;
	}

	/**
	 * Method 'setStatus'
	 * 
	 * @param status
	 */
	public void setStatus(short status)
	{
		this.status = status;
		this.statusNull = false;
	}

	/**
	 * Method 'setStatusNull'
	 * 
	 * @param value
	 */
	public void setStatusNull(boolean value)
	{
		this.statusNull = value;
	}

	/**
	 * Method 'isStatusNull'
	 * 
	 * @return boolean
	 */
	public boolean isStatusNull()
	{
		return statusNull;
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
		
		if (!(_other instanceof Role)) {
			return false;
		}
		
		final Role _cast = (Role) _other;
		if (idRol == null ? _cast.idRol != idRol : !idRol.equals( _cast.idRol )) {
			return false;
		}
		
		if (description == null ? _cast.description != description : !description.equals( _cast.description )) {
			return false;
		}
		
		if (status != _cast.status) {
			return false;
		}
		
		if (statusNull != _cast.statusNull) {
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
		if (idRol != null) {
			_hashCode = 29 * _hashCode + idRol.hashCode();
		}
		
		if (description != null) {
			_hashCode = 29 * _hashCode + description.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) status;
		_hashCode = 29 * _hashCode + (statusNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RolePk
	 */
	public RolePk createPk()
	{
		return new RolePk(idRol);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Role: " );
		ret.append( "idRol=" + idRol );
		ret.append( ", description=" + description );
		ret.append( ", status=" + status );
		return ret.toString();
	}

}
