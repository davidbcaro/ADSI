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

public class Schedule implements Serializable
{
	/** 
	 * This attribute maps to the column start_hour in the schedule table.
	 */
	protected Date startHour;

	/** 
	 * This attribute maps to the column end_hour in the schedule table.
	 */
	protected Date endHour;

	/** 
	 * This attribute maps to the column id_version in the schedule table.
	 */
	protected int idVersion;

	/** 
	 * This attribute maps to the column name_day in the schedule table.
	 */
	protected String nameDay;

	/** 
	 * This attribute maps to the column id_trimester_current in the schedule table.
	 */
	protected String idTrimesterCurrent;

	/** 
	 * This attribute maps to the column name_modality in the schedule table.
	 */
	protected String nameModality;

	/** 
	 * This attribute maps to the column number_environment in the schedule table.
	 */
	protected String numberEnvironment;

	/** 
	 * This attribute maps to the column name_headquartes in the schedule table.
	 */
	protected String nameHeadquartes;

	/** 
	 * This attribute maps to the column number_group in the schedule table.
	 */
	protected String numberGroup;

	/** 
	 * This attribute maps to the column name_trimester in the schedule table.
	 */
	protected String nameTrimester;

	/** 
	 * This attribute maps to the column working_day_initials in the schedule table.
	 */
	protected String workingDayInitials;

	/** 
	 * This attribute maps to the column document_number in the schedule table.
	 */
	protected String documentNumber;

	/** 
	 * This attribute maps to the column document in the schedule table.
	 */
	protected String document;

	/**
	 * Method 'Schedule'
	 * 
	 */
	public Schedule()
	{
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
	 * Method 'getIdVersion'
	 * 
	 * @return int
	 */
	public int getIdVersion()
	{
		return idVersion;
	}

	/**
	 * Method 'setIdVersion'
	 * 
	 * @param idVersion
	 */
	public void setIdVersion(int idVersion)
	{
		this.idVersion = idVersion;
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
	 * Method 'getIdTrimesterCurrent'
	 * 
	 * @return String
	 */
	public String getIdTrimesterCurrent()
	{
		return idTrimesterCurrent;
	}

	/**
	 * Method 'setIdTrimesterCurrent'
	 * 
	 * @param idTrimesterCurrent
	 */
	public void setIdTrimesterCurrent(String idTrimesterCurrent)
	{
		this.idTrimesterCurrent = idTrimesterCurrent;
	}

	/**
	 * Method 'getNameModality'
	 * 
	 * @return String
	 */
	public String getNameModality()
	{
		return nameModality;
	}

	/**
	 * Method 'setNameModality'
	 * 
	 * @param nameModality
	 */
	public void setNameModality(String nameModality)
	{
		this.nameModality = nameModality;
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
	 * Method 'getNumberGroup'
	 * 
	 * @return String
	 */
	public String getNumberGroup()
	{
		return numberGroup;
	}

	/**
	 * Method 'setNumberGroup'
	 * 
	 * @param numberGroup
	 */
	public void setNumberGroup(String numberGroup)
	{
		this.numberGroup = numberGroup;
	}

	/**
	 * Method 'getNameTrimester'
	 * 
	 * @return String
	 */
	public String getNameTrimester()
	{
		return nameTrimester;
	}

	/**
	 * Method 'setNameTrimester'
	 * 
	 * @param nameTrimester
	 */
	public void setNameTrimester(String nameTrimester)
	{
		this.nameTrimester = nameTrimester;
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
		
		if (!(_other instanceof Schedule)) {
			return false;
		}
		
		final Schedule _cast = (Schedule) _other;
		if (startHour == null ? _cast.startHour != startHour : !startHour.equals( _cast.startHour )) {
			return false;
		}
		
		if (endHour == null ? _cast.endHour != endHour : !endHour.equals( _cast.endHour )) {
			return false;
		}
		
		if (idVersion != _cast.idVersion) {
			return false;
		}
		
		if (nameDay == null ? _cast.nameDay != nameDay : !nameDay.equals( _cast.nameDay )) {
			return false;
		}
		
		if (idTrimesterCurrent == null ? _cast.idTrimesterCurrent != idTrimesterCurrent : !idTrimesterCurrent.equals( _cast.idTrimesterCurrent )) {
			return false;
		}
		
		if (nameModality == null ? _cast.nameModality != nameModality : !nameModality.equals( _cast.nameModality )) {
			return false;
		}
		
		if (numberEnvironment == null ? _cast.numberEnvironment != numberEnvironment : !numberEnvironment.equals( _cast.numberEnvironment )) {
			return false;
		}
		
		if (nameHeadquartes == null ? _cast.nameHeadquartes != nameHeadquartes : !nameHeadquartes.equals( _cast.nameHeadquartes )) {
			return false;
		}
		
		if (numberGroup == null ? _cast.numberGroup != numberGroup : !numberGroup.equals( _cast.numberGroup )) {
			return false;
		}
		
		if (nameTrimester == null ? _cast.nameTrimester != nameTrimester : !nameTrimester.equals( _cast.nameTrimester )) {
			return false;
		}
		
		if (workingDayInitials == null ? _cast.workingDayInitials != workingDayInitials : !workingDayInitials.equals( _cast.workingDayInitials )) {
			return false;
		}
		
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
		if (startHour != null) {
			_hashCode = 29 * _hashCode + startHour.hashCode();
		}
		
		if (endHour != null) {
			_hashCode = 29 * _hashCode + endHour.hashCode();
		}
		
		_hashCode = 29 * _hashCode + idVersion;
		if (nameDay != null) {
			_hashCode = 29 * _hashCode + nameDay.hashCode();
		}
		
		if (idTrimesterCurrent != null) {
			_hashCode = 29 * _hashCode + idTrimesterCurrent.hashCode();
		}
		
		if (nameModality != null) {
			_hashCode = 29 * _hashCode + nameModality.hashCode();
		}
		
		if (numberEnvironment != null) {
			_hashCode = 29 * _hashCode + numberEnvironment.hashCode();
		}
		
		if (nameHeadquartes != null) {
			_hashCode = 29 * _hashCode + nameHeadquartes.hashCode();
		}
		
		if (numberGroup != null) {
			_hashCode = 29 * _hashCode + numberGroup.hashCode();
		}
		
		if (nameTrimester != null) {
			_hashCode = 29 * _hashCode + nameTrimester.hashCode();
		}
		
		if (workingDayInitials != null) {
			_hashCode = 29 * _hashCode + workingDayInitials.hashCode();
		}
		
		if (documentNumber != null) {
			_hashCode = 29 * _hashCode + documentNumber.hashCode();
		}
		
		if (document != null) {
			_hashCode = 29 * _hashCode + document.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SchedulePk
	 */
	public SchedulePk createPk()
	{
		return new SchedulePk(startHour, nameDay, idTrimesterCurrent, numberEnvironment, nameHeadquartes, numberGroup, nameTrimester, workingDayInitials, documentNumber, document);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Schedule: " );
		ret.append( "startHour=" + startHour );
		ret.append( ", endHour=" + endHour );
		ret.append( ", idVersion=" + idVersion );
		ret.append( ", nameDay=" + nameDay );
		ret.append( ", idTrimesterCurrent=" + idTrimesterCurrent );
		ret.append( ", nameModality=" + nameModality );
		ret.append( ", numberEnvironment=" + numberEnvironment );
		ret.append( ", nameHeadquartes=" + nameHeadquartes );
		ret.append( ", numberGroup=" + numberGroup );
		ret.append( ", nameTrimester=" + nameTrimester );
		ret.append( ", workingDayInitials=" + workingDayInitials );
		ret.append( ", documentNumber=" + documentNumber );
		ret.append( ", document=" + document );
		return ret.toString();
	}

}
