/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the version table.
 */
public class VersionPk implements Serializable
{
	protected int idVersion;

	protected String idCurrentQuarter;

	/** 
	 * This attribute represents whether the primitive attribute idVersion is null.
	 */
	protected boolean idVersionNull;

	/** 
	 * Sets the value of idVersion
	 */
	public void setIdVersion(int idVersion)
	{
		this.idVersion = idVersion;
	}

	/** 
	 * Gets the value of idVersion
	 */
	public int getIdVersion()
	{
		return idVersion;
	}

	/** 
	 * Sets the value of idCurrentQuarter
	 */
	public void setIdCurrentQuarter(String idCurrentQuarter)
	{
		this.idCurrentQuarter = idCurrentQuarter;
	}

	/** 
	 * Gets the value of idCurrentQuarter
	 */
	public String getIdCurrentQuarter()
	{
		return idCurrentQuarter;
	}

	/**
	 * Method 'VersionPk'
	 * 
	 */
	public VersionPk()
	{
	}

	/**
	 * Method 'VersionPk'
	 * 
	 * @param idVersion
	 * @param idCurrentQuarter
	 */
	public VersionPk(final int idVersion, final String idCurrentQuarter)
	{
		this.idVersion = idVersion;
		this.idCurrentQuarter = idCurrentQuarter;
	}

	/** 
	 * Sets the value of idVersionNull
	 */
	public void setIdVersionNull(boolean idVersionNull)
	{
		this.idVersionNull = idVersionNull;
	}

	/** 
	 * Gets the value of idVersionNull
	 */
	public boolean isIdVersionNull()
	{
		return idVersionNull;
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
		
		if (!(_other instanceof VersionPk)) {
			return false;
		}
		
		final VersionPk _cast = (VersionPk) _other;
		if (idVersion != _cast.idVersion) {
			return false;
		}
		
		if (idCurrentQuarter == null ? _cast.idCurrentQuarter != idCurrentQuarter : !idCurrentQuarter.equals( _cast.idCurrentQuarter )) {
			return false;
		}
		
		if (idVersionNull != _cast.idVersionNull) {
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
		if (idCurrentQuarter != null) {
			_hashCode = 29 * _hashCode + idCurrentQuarter.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (idVersionNull ? 1 : 0);
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
		ret.append( "co.edu.sena.model.dao.dto.VersionPk: " );
		ret.append( "idVersion=" + idVersion );
		ret.append( ", idCurrentQuarter=" + idCurrentQuarter );
		return ret.toString();
	}

}