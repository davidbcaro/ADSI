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
import java.util.Date;

public class Disponibility implements Serializable
{
	/** 
	 * This attribute maps to the column document in the disponibility table.
	 */
	protected String document;

	/** 
	 * This attribute maps to the column document_number in the disponibility table.
	 */
	protected String documentNumber;

	/** 
	 * This attribute maps to the column start_hour in the disponibility table.
	 */
	protected Date startHour;

	/** 
	 * This attribute maps to the column end_hour in the disponibility table.
	 */
	protected Date endHour;

	/** 
	 * This attribute maps to the column name_day in the disponibility table.
	 */
	protected String nameDay;

	/** 
	 * This attribute maps to the column working_day_initials in the disponibility table.
	 */
	protected String workingDayInitials;

	/**
	 * Method 'Disponibility'
	 * 
	 */
	public Disponibility()
	{
	}

	/**
	 * Method 'getDocument'
	 * 
	 * @return String
	 */
	public String getDocument()
	{
		return document;
	}

	/**
	 * Method 'setDocument'
	 * 
	 * @param document
	 */
	public void setDocument(String document)
	{
		this.document = document;
	}

	/**
	 * Method 'getDocumentNumber'
	 * 
	 * @return String
	 */
	public String getDocumentNumber()
	{
		return documentNumber;
	}

	/**
	 * Method 'setDocumentNumber'
	 * 
	 * @param documentNumber
	 */
	public void setDocumentNumber(String documentNumber)
	{
		this.documentNumber = documentNumber;
	}

	/**
	 * Method 'getStartHour'
	 * 
	 * @return Date
	 */
	public Date getStartHour()
	{
		return startHour;
	}

	/**
	 * Method 'setStartHour'
	 * 
	 * @param startHour
	 */
	public void setStartHour(Date startHour)
	{
		this.startHour = startHour;
	}

	/**
	 * Method 'getEndHour'
	 * 
	 * @return Date
	 */
	public Date getEndHour()
	{
		return endHour;
	}

	/**
	 * Method 'setEndHour'
	 * 
	 * @param endHour
	 */
	public void setEndHour(Date endHour)
	{
		this.endHour = endHour;
	}

	/**
	 * Method 'getNameDay'
	 * 
	 * @return String
	 */
	public String getNameDay()
	{
		return nameDay;
	}

	/**
	 * Method 'setNameDay'
	 * 
	 * @param nameDay
	 */
	public void setNameDay(String nameDay)
	{
		this.nameDay = nameDay;
	}

	/**
	 * Method 'getWorkingDayInitials'
	 * 
	 * @return String
	 */
	public String getWorkingDayInitials()
	{
		return workingDayInitials;
	}

	/**
	 * Method 'setWorkingDayInitials'
	 * 
	 * @param workingDayInitials
	 */
	public void setWorkingDayInitials(String workingDayInitials)
	{
		this.workingDayInitials = workingDayInitials;
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
		
		if (!(_other instanceof Disponibility)) {
			return false;
		}
		
		final Disponibility _cast = (Disponibility) _other;
		if (document == null ? _cast.document != document : !document.equals( _cast.document )) {
			return false;
		}
		
		if (documentNumber == null ? _cast.documentNumber != documentNumber : !documentNumber.equals( _cast.documentNumber )) {
			return false;
		}
		
		if (startHour == null ? _cast.startHour != startHour : !startHour.equals( _cast.startHour )) {
			return false;
		}
		
		if (endHour == null ? _cast.endHour != endHour : !endHour.equals( _cast.endHour )) {
			return false;
		}
		
		if (nameDay == null ? _cast.nameDay != nameDay : !nameDay.equals( _cast.nameDay )) {
			return false;
		}
		
		if (workingDayInitials == null ? _cast.workingDayInitials != workingDayInitials : !workingDayInitials.equals( _cast.workingDayInitials )) {
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
		if (document != null) {
			_hashCode = 29 * _hashCode + document.hashCode();
		}
		
		if (documentNumber != null) {
			_hashCode = 29 * _hashCode + documentNumber.hashCode();
		}
		
		if (startHour != null) {
			_hashCode = 29 * _hashCode + startHour.hashCode();
		}
		
		if (endHour != null) {
			_hashCode = 29 * _hashCode + endHour.hashCode();
		}
		
		if (nameDay != null) {
			_hashCode = 29 * _hashCode + nameDay.hashCode();
		}
		
		if (workingDayInitials != null) {
			_hashCode = 29 * _hashCode + workingDayInitials.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return DisponibilityPk
	 */
	public DisponibilityPk createPk()
	{
		return new DisponibilityPk(startHour, nameDay, workingDayInitials, documentNumber, document);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Disponibility: " );
		ret.append( "document=" + document );
		ret.append( ", documentNumber=" + documentNumber );
		ret.append( ", startHour=" + startHour );
		ret.append( ", endHour=" + endHour );
		ret.append( ", nameDay=" + nameDay );
		ret.append( ", workingDayInitials=" + workingDayInitials );
		return ret.toString();
	}

}
