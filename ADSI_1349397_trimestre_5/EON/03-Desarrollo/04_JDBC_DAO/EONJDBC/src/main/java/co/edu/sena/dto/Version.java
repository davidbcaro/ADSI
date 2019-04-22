/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.dto;

import co.edu.sena.dao.*;
import co.edu.sena.factory.*;
import co.edu.sena.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class Version implements Serializable
{
	/** 
	 * This attribute maps to the column idVersion in the version table.
	 */
	protected int idVersion;

	/** 
	 * This attribute maps to the column active in the version table.
	 */
	protected short active;

	/** 
	 * This attribute represents whether the primitive attribute active is null.
	 */
	protected boolean activeNull = true;

	/** 
	 * This attribute maps to the column idCurrent_Quarter in the version table.
	 */
	protected String idcurrentQuarter;

	/**
	 * Method 'Version'
	 * 
	 */
	public Version()
	{
	}

	/**
	 * Method 'getIdVersion'
	 * 
	 * @return int
	 */
	public int getIdVersion()
	{
		return idVersion;
	}

	/**
	 * Method 'setIdVersion'
	 * 
	 * @param idVersion
	 */
	public void setIdVersion(int idVersion)
	{
		this.idVersion = idVersion;
	}

	/**
	 * Method 'getActive'
	 * 
	 * @return short
	 */
	public short getActive()
	{
		return active;
	}

	/**
	 * Method 'setActive'
	 * 
	 * @param active
	 */
	public void setActive(short active)
	{
		this.active = active;
		this.activeNull = false;
	}

	/**
	 * Method 'setActiveNull'
	 * 
	 * @param value
	 */
	public void setActiveNull(boolean value)
	{
		this.activeNull = value;
	}

	/**
	 * Method 'isActiveNull'
	 * 
	 * @return boolean
	 */
	public boolean isActiveNull()
	{
		return activeNull;
	}

	/**
	 * Method 'getIdcurrentQuarter'
	 * 
	 * @return String
	 */
	public String getIdcurrentQuarter()
	{
		return idcurrentQuarter;
	}

	/**
	 * Method 'setIdcurrentQuarter'
	 * 
	 * @param idcurrentQuarter
	 */
	public void setIdcurrentQuarter(String idcurrentQuarter)
	{
		this.idcurrentQuarter = idcurrentQuarter;
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
		
		if (!(_other instanceof Version)) {
			return false;
		}
		
		final Version _cast = (Version) _other;
		if (idVersion != _cast.idVersion) {
			return false;
		}
		
		if (active != _cast.active) {
			return false;
		}
		
		if (activeNull != _cast.activeNull) {
			return false;
		}
		
		if (idcurrentQuarter == null ? _cast.idcurrentQuarter != idcurrentQuarter : !idcurrentQuarter.equals( _cast.idcurrentQuarter )) {
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
		_hashCode = 29 * _hashCode + idVersion;
		_hashCode = 29 * _hashCode + (int) active;
		_hashCode = 29 * _hashCode + (activeNull ? 1 : 0);
		if (idcurrentQuarter != null) {
			_hashCode = 29 * _hashCode + idcurrentQuarter.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return VersionPk
	 */
	public VersionPk createPk()
	{
		return new VersionPk(idcurrentQuarter, idVersion);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.Version: " );
		ret.append( "idVersion=" + idVersion );
		ret.append( ", active=" + active );
		ret.append( ", idcurrentQuarter=" + idcurrentQuarter );
		return ret.toString();
	}

}