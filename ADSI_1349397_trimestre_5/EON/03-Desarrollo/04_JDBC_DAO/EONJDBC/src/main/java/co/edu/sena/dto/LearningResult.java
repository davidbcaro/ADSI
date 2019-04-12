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

public class LearningResult implements Serializable
{
	/** 
	 * This attribute maps to the column Code in the learning_result table.
	 */
	protected String code;

	/** 
	 * This attribute maps to the column Description in the learning_result table.
	 */
	protected String description;

	/** 
	 * This attribute maps to the column Program_Code in the learning_result table.
	 */
	protected String programCode;

	/** 
	 * This attribute maps to the column Competition_Code in the learning_result table.
	 */
	protected String competitionCode;

	/** 
	 * This attribute maps to the column Version in the learning_result table.
	 */
	protected String version;

	/**
	 * Method 'LearningResult'
	 * 
	 */
	public LearningResult()
	{
	}

	/**
	 * Method 'getCode'
	 * 
	 * @return String
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Method 'setCode'
	 * 
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
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
		
		if (!(_other instanceof LearningResult)) {
			return false;
		}
		
		final LearningResult _cast = (LearningResult) _other;
		if (code == null ? _cast.code != code : !code.equals( _cast.code )) {
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
		if (code != null) {
			_hashCode = 29 * _hashCode + code.hashCode();
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
		
		if (version != null) {
			_hashCode = 29 * _hashCode + version.hashCode();
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
		return new LearningResultPk(code, programCode, version, competitionCode);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.LearningResult: " );
		ret.append( "code=" + code );
		ret.append( ", description=" + description );
		ret.append( ", programCode=" + programCode );
		ret.append( ", competitionCode=" + competitionCode );
		ret.append( ", version=" + version );
		return ret.toString();
	}

}
