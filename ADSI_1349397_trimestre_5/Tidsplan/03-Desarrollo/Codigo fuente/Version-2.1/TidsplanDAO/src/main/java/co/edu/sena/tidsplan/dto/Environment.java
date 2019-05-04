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

public class Environment implements Serializable
{
	/** 
	 * This attribute maps to the column number_environment in the environment table.
	 */
	protected String numberEnvironment;

	/** 
	 * This attribute maps to the column description in the environment table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column status in the environment table.
	 */
	protected short status;

	/** 
	 * This attribute represents whether the primitive attribute status is null.
	 */
	protected boolean statusNull = true;

	/** 
	 * This attribute maps to the column name_headquartes in the environment table.
	 */
	protected String nameHeadquartes;

	/**
	 * Method 'Environment'
	 * 
	 */
	public Environment()
	{
	}

	/**
	 * Method 'getNumberEnvironment'
	 * 
	 * @return String
	 */
	public String getNumberEnvironment()
	{
		return numberEnvironment;
	}

	/**
	 * Method 'setNumberEnvironment'
	 * 
	 * @param numberEnvironment
	 */
	public void setNumberEnvironment(String numberEnvironment)
	{
		this.numberEnvironment = numberEnvironment;
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
	 * Method 'getNameHeadquartes'
	 * 
	 * @return String
	 */
	public String getNameHeadquartes()
	{
		return nameHeadquartes;
	}

	/**
	 * Method 'setNameHeadquartes'
	 * 
	 * @param nameHeadquartes
	 */
	public void setNameHeadquartes(String nameHeadquartes)
	{
		this.nameHeadquartes = nameHeadquartes;
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
		
		if (!(_other instanceof Environment)) {
			return false;
		}
		
		final Environment _cast = (Environment) _other;
		if (numberEnvironment == null ? _cast.numberEnvironment != numberEnvironment : !numberEnvironment.equals( _cast.numberEnvironment )) {
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
		
		if (nameHeadquartes == null ? _cast.nameHeadquartes != nameHeadquartes : !nameHeadquartes.equals( _cast.nameHeadquartes )) {
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
		if (numberEnvironment != null) {
			_hashCode = 29 * _hashCode + numberEnvironment.hashCode();
		}
		
		if (description != null) {
			_hashCode = 29 * _hashCode + description.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) status;
		_hashCode = 29 * _hashCode + (statusNull ? 1 : 0);
		if (nameHeadquartes != null) {
			_hashCode = 29 * _hashCode + nameHeadquartes.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return EnvironmentPk
	 */
	public EnvironmentPk createPk()
	{
		return new EnvironmentPk(numberEnvironment, nameHeadquartes);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Environment: " );
		ret.append( "numberEnvironment=" + numberEnvironment );
		ret.append( ", description=" + description );
		ret.append( ", status=" + status );
		ret.append( ", nameHeadquartes=" + nameHeadquartes );
		return ret.toString();
	}

}
