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
 * This class represents the primary key of the speciality table.
 */
public class SpecialityPk implements Serializable
{
	protected String specialityName;

	/** 
	 * Sets the value of specialityName
	 */
	public void setSpecialityName(String specialityName)
	{
		this.specialityName = specialityName;
	}

	/** 
	 * Gets the value of specialityName
	 */
	public String getSpecialityName()
	{
		return specialityName;
	}

	/**
	 * Method 'SpecialityPk'
	 * 
	 */
	public SpecialityPk()
	{
	}

	/**
	 * Method 'SpecialityPk'
	 * 
	 * @param specialityName
	 */
	public SpecialityPk(final String specialityName)
	{
		this.specialityName = specialityName;
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
		
		if (!(_other instanceof SpecialityPk)) {
			return false;
		}
		
		final SpecialityPk _cast = (SpecialityPk) _other;
		if (specialityName == null ? _cast.specialityName != specialityName : !specialityName.equals( _cast.specialityName )) {
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
		if (specialityName != null) {
			_hashCode = 29 * _hashCode + specialityName.hashCode();
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
		ret.append( "co.edu.sena.dto.SpecialityPk: " );
		ret.append( "specialityName=" + specialityName );
		return ret.toString();
	}

}
