/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.tidsplan.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the modality table.
 */
public class ModalityPk implements Serializable
{
	protected String nameModality;

	/** 
	 * Sets the value of nameModality
	 */
	public void setNameModality(String nameModality)
	{
		this.nameModality = nameModality;
	}

	/** 
	 * Gets the value of nameModality
	 */
	public String getNameModality()
	{
		return nameModality;
	}

	/**
	 * Method 'ModalityPk'
	 * 
	 */
	public ModalityPk()
	{
	}

	/**
	 * Method 'ModalityPk'
	 * 
	 * @param nameModality
	 */
	public ModalityPk(final String nameModality)
	{
		this.nameModality = nameModality;
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
		
		if (!(_other instanceof ModalityPk)) {
			return false;
		}
		
		final ModalityPk _cast = (ModalityPk) _other;
		if (nameModality == null ? _cast.nameModality != nameModality : !nameModality.equals( _cast.nameModality )) {
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
		if (nameModality != null) {
			_hashCode = 29 * _hashCode + nameModality.hashCode();
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
		ret.append( "co.edu.sena.tidsplan.dto.ModalityPk: " );
		ret.append( "nameModality=" + nameModality );
		return ret.toString();
	}

}
