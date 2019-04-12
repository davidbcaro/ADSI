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
 * This class represents the primary key of the modality table.
 */
public class ModalityPk implements Serializable
{
	protected String modalityName;

	/** 
	 * Sets the value of modalityName
	 */
	public void setModalityName(String modalityName)
	{
		this.modalityName = modalityName;
	}

	/** 
	 * Gets the value of modalityName
	 */
	public String getModalityName()
	{
		return modalityName;
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
	 * @param modalityName
	 */
	public ModalityPk(final String modalityName)
	{
		this.modalityName = modalityName;
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
		if (modalityName == null ? _cast.modalityName != modalityName : !modalityName.equals( _cast.modalityName )) {
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
		if (modalityName != null) {
			_hashCode = 29 * _hashCode + modalityName.hashCode();
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
		ret.append( "co.edu.sena.dto.ModalityPk: " );
		ret.append( "modalityName=" + modalityName );
		return ret.toString();
	}

}
