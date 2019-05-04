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

public class StateGroup implements Serializable
{
	/** 
	 * This attribute maps to the column name_state in the state_group table.
	 */
	protected String nameState;

	/** 
	 * This attribute maps to the column status in the state_group table.
	 */
	protected short status;

	/**
	 * Method 'StateGroup'
	 * 
	 */
	public StateGroup()
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
		
		if (!(_other instanceof StateGroup)) {
			return false;
		}
		
		final StateGroup _cast = (StateGroup) _other;
		if (nameState == null ? _cast.nameState != nameState : !nameState.equals( _cast.nameState )) {
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
		if (nameState != null) {
			_hashCode = 29 * _hashCode + nameState.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) status;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return StateGroupPk
	 */
	public StateGroupPk createPk()
	{
		return new StateGroupPk(nameState);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.StateGroup: " );
		ret.append( "nameState=" + nameState );
		ret.append( ", status=" + status );
		return ret.toString();
	}

}
