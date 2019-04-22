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

public class StatusFicha implements Serializable
{
	/** 
	 * This attribute maps to the column name_State in the status_ficha table.
	 */
	protected String nameState;

	/** 
	 * This attribute maps to the column State in the status_ficha table.
	 */
	protected String state;

	/**
	 * Method 'StatusFicha'
	 * 
	 */
	public StatusFicha()
	{
	}

	/**
	 * Method 'getNameState'
	 * 
	 * @return String
	 */
	public String getNameState()
	{
		return nameState;
	}

	/**
	 * Method 'setNameState'
	 * 
	 * @param nameState
	 */
	public void setNameState(String nameState)
	{
		this.nameState = nameState;
	}

	/**
	 * Method 'getState'
	 * 
	 * @return String
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * Method 'setState'
	 * 
	 * @param state
	 */
	public void setState(String state)
	{
		this.state = state;
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
		
		if (!(_other instanceof StatusFicha)) {
			return false;
		}
		
		final StatusFicha _cast = (StatusFicha) _other;
		if (nameState == null ? _cast.nameState != nameState : !nameState.equals( _cast.nameState )) {
			return false;
		}
		
		if (state == null ? _cast.state != state : !state.equals( _cast.state )) {
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
		if (nameState != null) {
			_hashCode = 29 * _hashCode + nameState.hashCode();
		}
		
		if (state != null) {
			_hashCode = 29 * _hashCode + state.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return StatusFichaPk
	 */
	public StatusFichaPk createPk()
	{
		return new StatusFichaPk(nameState);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.StatusFicha: " );
		ret.append( "nameState=" + nameState );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}