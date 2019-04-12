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
 * This class represents the primary key of the bonding table.
 */
public class BondingPk implements Serializable
{
	protected String typeLinkage;

	/** 
	 * Sets the value of typeLinkage
	 */
	public void setTypeLinkage(String typeLinkage)
	{
		this.typeLinkage = typeLinkage;
	}

	/** 
	 * Gets the value of typeLinkage
	 */
	public String getTypeLinkage()
	{
		return typeLinkage;
	}

	/**
	 * Method 'BondingPk'
	 * 
	 */
	public BondingPk()
	{
	}

	/**
	 * Method 'BondingPk'
	 * 
	 * @param typeLinkage
	 */
	public BondingPk(final String typeLinkage)
	{
		this.typeLinkage = typeLinkage;
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
		
		if (!(_other instanceof BondingPk)) {
			return false;
		}
		
		final BondingPk _cast = (BondingPk) _other;
		if (typeLinkage == null ? _cast.typeLinkage != typeLinkage : !typeLinkage.equals( _cast.typeLinkage )) {
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
		if (typeLinkage != null) {
			_hashCode = 29 * _hashCode + typeLinkage.hashCode();
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
		ret.append( "co.edu.sena.dto.BondingPk: " );
		ret.append( "typeLinkage=" + typeLinkage );
		return ret.toString();
	}

}
