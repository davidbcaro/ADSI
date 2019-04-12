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

public class Ambience implements Serializable
{
	/** 
	 * This attribute maps to the column number_Ambience in the ambience table.
	 */
	protected String numberAmbience;

	/** 
	 * This attribute maps to the column Description in the ambience table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column Status in the ambience table.
	 */
	protected short status;

	/** 
	 * This attribute represents whether the primitive attribute status is null.
	 */
	protected boolean statusNull = true;

	/** 
	 * This attribute maps to the column name_Headquarters in the ambience table.
	 */
	protected String nameHeadquarters;

	/**
	 * Method 'Ambience'
	 * 
	 */
	public Ambience()
	{
	}

	/**
	 * Method 'getNumberAmbience'
	 * 
	 * @return String
	 */
	public String getNumberAmbience()
	{
		return numberAmbience;
	}

	/**
	 * Method 'setNumberAmbience'
	 * 
	 * @param numberAmbience
	 */
	public void setNumberAmbience(String numberAmbience)
	{
		this.numberAmbience = numberAmbience;
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
	 * Method 'getNameHeadquarters'
	 * 
	 * @return String
	 */
	public String getNameHeadquarters()
	{
		return nameHeadquarters;
	}

	/**
	 * Method 'setNameHeadquarters'
	 * 
	 * @param nameHeadquarters
	 */
	public void setNameHeadquarters(String nameHeadquarters)
	{
		this.nameHeadquarters = nameHeadquarters;
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
		
		if (!(_other instanceof Ambience)) {
			return false;
		}
		
		final Ambience _cast = (Ambience) _other;
		if (numberAmbience == null ? _cast.numberAmbience != numberAmbience : !numberAmbience.equals( _cast.numberAmbience )) {
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
		
		if (nameHeadquarters == null ? _cast.nameHeadquarters != nameHeadquarters : !nameHeadquarters.equals( _cast.nameHeadquarters )) {
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
		if (numberAmbience != null) {
			_hashCode = 29 * _hashCode + numberAmbience.hashCode();
		}
		
		if (description != null) {
			_hashCode = 29 * _hashCode + description.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) status;
		_hashCode = 29 * _hashCode + (statusNull ? 1 : 0);
		if (nameHeadquarters != null) {
			_hashCode = 29 * _hashCode + nameHeadquarters.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return AmbiencePk
	 */
	public AmbiencePk createPk()
	{
		return new AmbiencePk(nameHeadquarters, numberAmbience);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.Ambience: " );
		ret.append( "numberAmbience=" + numberAmbience );
		ret.append( ", description=" + description );
		ret.append( ", status=" + status );
		ret.append( ", nameHeadquarters=" + nameHeadquarters );
		return ret.toString();
	}

}
