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

public class LearningResult implements Serializable
{
	/** 
	 * This attribute maps to the column id_code in the learning_result table.
	 */
	protected String idCode;

	/** 
	 * This attribute maps to the column description in the learning_result table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column program_code in the learning_result table.
	 */
	protected String programCode;

	/** 
	 * This attribute maps to the column competition_code in the learning_result table.
	 */
	protected String competitionCode;

	/** 
	 * This attribute maps to the column program_version in the learning_result table.
	 */
	protected String programVersion;

	/**
	 * Method 'LearningResult'
	 * 
	 */
	public LearningResult()
	{
	}

	/**
	 * Method 'getIdCode'
	 * 
	 * @return String
	 */
	public String getIdCode()
	{
		return idCode;
	}

	/**
	 * Method 'setIdCode'
	 * 
	 * @param idCode
	 */
	public void setIdCode(String idCode)
	{
		this.idCode = idCode;
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
	 * Method 'getProgramVersion'
	 * 
	 * @return String
	 */
	public String getProgramVersion()
	{
		return programVersion;
	}

	/**
	 * Method 'setProgramVersion'
	 * 
	 * @param programVersion
	 */
	public void setProgramVersion(String programVersion)
	{
		this.programVersion = programVersion;
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
		
		if (!(_other instanceof LearningResult)) {
			return false;
		}
		
		final LearningResult _cast = (LearningResult) _other;
		if (idCode == null ? _cast.idCode != idCode : !idCode.equals( _cast.idCode )) {
			return false;
		}
		
		if (description == null ? _cast.description != description : !description.equals( _cast.description )) {
			return false;
		}
		
		if (programCode == null ? _cast.programCode != programCode : !programCode.equals( _cast.programCode )) {
			return false;
		}
		
		if (competitionCode == null ? _cast.competitionCode != competitionCode : !competitionCode.equals( _cast.competitionCode )) {
			return false;
		}
		
		if (programVersion == null ? _cast.programVersion != programVersion : !programVersion.equals( _cast.programVersion )) {
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
		if (idCode != null) {
			_hashCode = 29 * _hashCode + idCode.hashCode();
		}
		
		if (description != null) {
			_hashCode = 29 * _hashCode + description.hashCode();
		}
		
		if (programCode != null) {
			_hashCode = 29 * _hashCode + programCode.hashCode();
		}
		
		if (competitionCode != null) {
			_hashCode = 29 * _hashCode + competitionCode.hashCode();
		}
		
		if (programVersion != null) {
			_hashCode = 29 * _hashCode + programVersion.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return LearningResultPk
	 */
	public LearningResultPk createPk()
	{
		return new LearningResultPk(idCode, programCode, competitionCode, programVersion);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.LearningResult: " );
		ret.append( "idCode=" + idCode );
		ret.append( ", description=" + description );
		ret.append( ", programCode=" + programCode );
		ret.append( ", competitionCode=" + competitionCode );
		ret.append( ", programVersion=" + programVersion );
		return ret.toString();
	}

}
