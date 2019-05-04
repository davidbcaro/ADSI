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
 * This class represents the primary key of the training_program table.
 */
public class TrainingProgramPk implements Serializable
{
	protected String idCode;

	protected String version;

	/** 
	 * Sets the value of idCode
	 */
	public void setIdCode(String idCode)
	{
		this.idCode = idCode;
	}

	/** 
	 * Gets the value of idCode
	 */
	public String getIdCode()
	{
		return idCode;
	}

	/** 
	 * Sets the value of version
	 */
	public void setVersion(String version)
	{
		this.version = version;
	}

	/** 
	 * Gets the value of version
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * Method 'TrainingProgramPk'
	 * 
	 */
	public TrainingProgramPk()
	{
	}

	/**
	 * Method 'TrainingProgramPk'
	 * 
	 * @param idCode
	 * @param version
	 */
	public TrainingProgramPk(final String idCode, final String version)
	{
		this.idCode = idCode;
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
		
		if (!(_other instanceof TrainingProgramPk)) {
			return false;
		}
		
		final TrainingProgramPk _cast = (TrainingProgramPk) _other;
		if (idCode == null ? _cast.idCode != idCode : !idCode.equals( _cast.idCode )) {
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
		if (idCode != null) {
			_hashCode = 29 * _hashCode + idCode.hashCode();
		}
		
		if (version != null) {
			_hashCode = 29 * _hashCode + version.hashCode();
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
		ret.append( "co.edu.sena.tidsplan.dto.TrainingProgramPk: " );
		ret.append( "idCode=" + idCode );
		ret.append( ", version=" + version );
		return ret.toString();
	}

}
