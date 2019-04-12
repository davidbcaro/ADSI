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
 * This class represents the primary key of the ficha table.
 */
public class FichaPk implements Serializable
{
	protected String numberFicha;

	/** 
	 * Sets the value of numberFicha
	 */
	public void setNumberFicha(String numberFicha)
	{
		this.numberFicha = numberFicha;
	}

	/** 
	 * Gets the value of numberFicha
	 */
	public String getNumberFicha()
	{
		return numberFicha;
	}

	/**
	 * Method 'FichaPk'
	 * 
	 */
	public FichaPk()
	{
	}

	/**
	 * Method 'FichaPk'
	 * 
	 * @param numberFicha
	 */
	public FichaPk(final String numberFicha)
	{
		this.numberFicha = numberFicha;
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
		
		if (!(_other instanceof FichaPk)) {
			return false;
		}
		
		final FichaPk _cast = (FichaPk) _other;
		if (numberFicha == null ? _cast.numberFicha != numberFicha : !numberFicha.equals( _cast.numberFicha )) {
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
		if (numberFicha != null) {
			_hashCode = 29 * _hashCode + numberFicha.hashCode();
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
		ret.append( "co.edu.sena.dto.FichaPk: " );
		ret.append( "numberFicha=" + numberFicha );
		return ret.toString();
	}

}
