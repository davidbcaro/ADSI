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

public class Bonding implements Serializable
{
	/** 
	 * This attribute maps to the column type_Linkage in the bonding table.
	 */
	protected String typeLinkage;

	/** 
	 * This attribute maps to the column Hours in the bonding table.
	 */
	protected int hours;

	/** 
	 * This attribute maps to the column Status in the bonding table.
	 */
	protected short status;

	/**
	 * Method 'Bonding'
	 * 
	 */
	public Bonding()
	{
	}

	/**
	 * Method 'getTypeLinkage'
	 * 
	 * @return String
	 */
	public String getTypeLinkage()
	{
		return typeLinkage;
	}

	/**
	 * Method 'setTypeLinkage'
	 * 
	 * @param typeLinkage
	 */
	public void setTypeLinkage(String typeLinkage)
	{
		this.typeLinkage = typeLinkage;
	}

	/**
	 * Method 'getHours'
	 * 
	 * @return int
	 */
	public int getHours()
	{
		return hours;
	}

	/**
	 * Method 'setHours'
	 * 
	 * @param hours
	 */
	public void setHours(int hours)
	{
		this.hours = hours;
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
		
		if (!(_other instanceof Bonding)) {
			return false;
		}
		
		final Bonding _cast = (Bonding) _other;
		if (typeLinkage == null ? _cast.typeLinkage != typeLinkage : !typeLinkage.equals( _cast.typeLinkage )) {
			return false;
		}
		
		if (hours != _cast.hours) {
			return false;
		}
		
		if (status != _cast.status) {
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
		
		_hashCode = 29 * _hashCode + hours;
		_hashCode = 29 * _hashCode + (int) status;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return BondingPk
	 */
	public BondingPk createPk()
	{
		return new BondingPk(typeLinkage);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.Bonding: " );
		ret.append( "typeLinkage=" + typeLinkage );
		ret.append( ", hours=" + hours );
		ret.append( ", status=" + status );
		return ret.toString();
	}

}
