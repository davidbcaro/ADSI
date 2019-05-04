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
 * This class represents the primary key of the instructor table.
 */
public class InstructorPk implements Serializable
{
	protected String documentNumber;

	protected String document;

	/** 
	 * Sets the value of documentNumber
	 */
	public void setDocumentNumber(String documentNumber)
	{
		this.documentNumber = documentNumber;
	}

	/** 
	 * Gets the value of documentNumber
	 */
	public String getDocumentNumber()
	{
		return documentNumber;
	}

	/** 
	 * Sets the value of document
	 */
	public void setDocument(String document)
	{
		this.document = document;
	}

	/** 
	 * Gets the value of document
	 */
	public String getDocument()
	{
		return document;
	}

	/**
	 * Method 'InstructorPk'
	 * 
	 */
	public InstructorPk()
	{
	}

	/**
	 * Method 'InstructorPk'
	 * 
	 * @param documentNumber
	 * @param document
	 */
	public InstructorPk(final String documentNumber, final String document)
	{
		this.documentNumber = documentNumber;
		this.document = document;
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
		
		if (!(_other instanceof InstructorPk)) {
			return false;
		}
		
		final InstructorPk _cast = (InstructorPk) _other;
		if (documentNumber == null ? _cast.documentNumber != documentNumber : !documentNumber.equals( _cast.documentNumber )) {
			return false;
		}
		
		if (document == null ? _cast.document != document : !document.equals( _cast.document )) {
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
		if (documentNumber != null) {
			_hashCode = 29 * _hashCode + documentNumber.hashCode();
		}
		
		if (document != null) {
			_hashCode = 29 * _hashCode + document.hashCode();
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
		ret.append( "co.edu.sena.tidsplan.dto.InstructorPk: " );
		ret.append( "documentNumber=" + documentNumber );
		ret.append( ", document=" + document );
		return ret.toString();
	}

}
