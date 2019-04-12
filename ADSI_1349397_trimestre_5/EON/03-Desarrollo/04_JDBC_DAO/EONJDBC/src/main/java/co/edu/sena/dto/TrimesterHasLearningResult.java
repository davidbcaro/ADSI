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

public class TrimesterHasLearningResult implements Serializable
{
	/** 
	 * This attribute maps to the column quarter_Name in the trimester_has_learning_result table.
	 */
	protected String quarterName;

	/** 
	 * This attribute maps to the column acronyms_Working_Day in the trimester_has_learning_result table.
	 */
	protected String acronymsWorkingDay;

	/** 
	 * This attribute maps to the column Learning_Result_Code in the trimester_has_learning_result table.
	 */
	protected String learningResultCode;

	/** 
	 * This attribute maps to the column Program_Code in the trimester_has_learning_result table.
	 */
	protected String programCode;

	/** 
	 * This attribute maps to the column Competition_Code in the trimester_has_learning_result table.
	 */
	protected String competitionCode;

	/** 
	 * This attribute maps to the column speciality_Name in the trimester_has_learning_result table.
	 */
	protected String specialityName;

	/** 
	 * This attribute maps to the column Version in the trimester_has_learning_result table.
	 */
	protected String version;

	/**
	 * Method 'TrimesterHasLearningResult'
	 * 
	 */
	public TrimesterHasLearningResult()
	{
	}

	/**
	 * Method 'getQuarterName'
	 * 
	 * @return String
	 */
	public String getQuarterName()
	{
		return quarterName;
	}

	/**
	 * Method 'setQuarterName'
	 * 
	 * @param quarterName
	 */
	public void setQuarterName(String quarterName)
	{
		this.quarterName = quarterName;
	}

	/**
	 * Method 'getAcronymsWorkingDay'
	 * 
	 * @return String
	 */
	public String getAcronymsWorkingDay()
	{
		return acronymsWorkingDay;
	}

	/**
	 * Method 'setAcronymsWorkingDay'
	 * 
	 * @param acronymsWorkingDay
	 */
	public void setAcronymsWorkingDay(String acronymsWorkingDay)
	{
		this.acronymsWorkingDay = acronymsWorkingDay;
	}

	/**
	 * Method 'getLearningResultCode'
	 * 
	 * @return String
	 */
	public String getLearningResultCode()
	{
		return learningResultCode;
	}

	/**
	 * Method 'setLearningResultCode'
	 * 
	 * @param learningResultCode
	 */
	public void setLearningResultCode(String learningResultCode)
	{
		this.learningResultCode = learningResultCode;
	}

	/**
	 * Method 'getProgramCode'
	 * 
	 * @return String
	 */
	public String getProgramCode()
	{
		return programCode;
	}

	/**
	 * Method 'setProgramCode'
	 * 
	 * @param programCode
	 */
	public void setProgramCode(String programCode)
	{
		this.programCode = programCode;
	}

	/**
	 * Method 'getCompetitionCode'
	 * 
	 * @return String
	 */
	public String getCompetitionCode()
	{
		return competitionCode;
	}

	/**
	 * Method 'setCompetitionCode'
	 * 
	 * @param competitionCode
	 */
	public void setCompetitionCode(String competitionCode)
	{
		this.competitionCode = competitionCode;
	}

	/**
	 * Method 'getSpecialityName'
	 * 
	 * @return String
	 */
	public String getSpecialityName()
	{
		return specialityName;
	}

	/**
	 * Method 'setSpecialityName'
	 * 
	 * @param specialityName
	 */
	public void setSpecialityName(String specialityName)
	{
		this.specialityName = specialityName;
	}

	/**
	 * Method 'getVersion'
	 * 
	 * @return String
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * Method 'setVersion'
	 * 
	 * @param version
	 */
	public void setVersion(String version)
	{
		this.version = version;
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
		
		if (!(_other instanceof TrimesterHasLearningResult)) {
			return false;
		}
		
		final TrimesterHasLearningResult _cast = (TrimesterHasLearningResult) _other;
		if (quarterName == null ? _cast.quarterName != quarterName : !quarterName.equals( _cast.quarterName )) {
			return false;
		}
		
		if (acronymsWorkingDay == null ? _cast.acronymsWorkingDay != acronymsWorkingDay : !acronymsWorkingDay.equals( _cast.acronymsWorkingDay )) {
			return false;
		}
		
		if (learningResultCode == null ? _cast.learningResultCode != learningResultCode : !learningResultCode.equals( _cast.learningResultCode )) {
			return false;
		}
		
		if (programCode == null ? _cast.programCode != programCode : !programCode.equals( _cast.programCode )) {
			return false;
		}
		
		if (competitionCode == null ? _cast.competitionCode != competitionCode : !competitionCode.equals( _cast.competitionCode )) {
			return false;
		}
		
		if (specialityName == null ? _cast.specialityName != specialityName : !specialityName.equals( _cast.specialityName )) {
			return false;
		}
		
		if (version == null ? _cast.version != version : !version.equals( _cast.version )) {
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
		if (quarterName != null) {
			_hashCode = 29 * _hashCode + quarterName.hashCode();
		}
		
		if (acronymsWorkingDay != null) {
			_hashCode = 29 * _hashCode + acronymsWorkingDay.hashCode();
		}
		
		if (learningResultCode != null) {
			_hashCode = 29 * _hashCode + learningResultCode.hashCode();
		}
		
		if (programCode != null) {
			_hashCode = 29 * _hashCode + programCode.hashCode();
		}
		
		if (competitionCode != null) {
			_hashCode = 29 * _hashCode + competitionCode.hashCode();
		}
		
		if (specialityName != null) {
			_hashCode = 29 * _hashCode + specialityName.hashCode();
		}
		
		if (version != null) {
			_hashCode = 29 * _hashCode + version.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return TrimesterHasLearningResultPk
	 */
	public TrimesterHasLearningResultPk createPk()
	{
		return new TrimesterHasLearningResultPk(quarterName, acronymsWorkingDay, specialityName, learningResultCode, programCode, competitionCode, version);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.TrimesterHasLearningResult: " );
		ret.append( "quarterName=" + quarterName );
		ret.append( ", acronymsWorkingDay=" + acronymsWorkingDay );
		ret.append( ", learningResultCode=" + learningResultCode );
		ret.append( ", programCode=" + programCode );
		ret.append( ", competitionCode=" + competitionCode );
		ret.append( ", specialityName=" + specialityName );
		ret.append( ", version=" + version );
		return ret.toString();
	}

}
