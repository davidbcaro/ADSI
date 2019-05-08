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

public class Trimester implements Serializable
{
	/** 
	 * This attribute maps to the column name_trimester in the trimester table.
	 */
	protected String nameTrimester;

	/** 
	 * This attribute maps to the column workingday_initials in the trimester table.
	 */
	protected String workingdayInitials;

	/** 
	 * This attribute maps to the column level_formation in the trimester table.
	 */
	protected String levelFormation;

	/**
	 * Method 'Trimester'
	 * 
	 */
	public Trimester()
	{
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
	 * Method 'getWorkingdayInitials'
	 * 
	 * @return String
	 */
	public String getWorkingdayInitials()
	{
		return workingdayInitials;
	}

	/**
	 * Method 'setWorkingdayInitials'
	 * 
	 * @param workingdayInitials
	 */
	public void setWorkingdayInitials(String workingdayInitials)
	{
		this.workingdayInitials = workingdayInitials;
	}

	/**
	 * Method 'getLevelFormation'
	 * 
	 * @return String
	 */
	public String getLevelFormation()
	{
		return levelFormation;
	}

	/**
	 * Method 'setLevelFormation'
	 * 
	 * @param levelFormation
	 */
	public void setLevelFormation(String levelFormation)
	{
		this.levelFormation = levelFormation;
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
		
		if (!(_other instanceof Trimester)) {
			return false;
		}
		
		final Trimester _cast = (Trimester) _other;
		if (nameTrimester == null ? _cast.nameTrimester != nameTrimester : !nameTrimester.equals( _cast.nameTrimester )) {
			return false;
		}
		
		if (workingdayInitials == null ? _cast.workingdayInitials != workingdayInitials : !workingdayInitials.equals( _cast.workingdayInitials )) {
			return false;
		}
		
		if (levelFormation == null ? _cast.levelFormation != levelFormation : !levelFormation.equals( _cast.levelFormation )) {
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
		if (nameTrimester != null) {
			_hashCode = 29 * _hashCode + nameTrimester.hashCode();
		}
		
		if (workingdayInitials != null) {
			_hashCode = 29 * _hashCode + workingdayInitials.hashCode();
		}
		
		if (levelFormation != null) {
			_hashCode = 29 * _hashCode + levelFormation.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return TrimesterPk
	 */
	public TrimesterPk createPk()
	{
		return new TrimesterPk(nameTrimester, workingdayInitials, levelFormation);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Trimester: " );
		ret.append( "nameTrimester=" + nameTrimester );
		ret.append( ", workingdayInitials=" + workingdayInitials );
		ret.append( ", levelFormation=" + levelFormation );
		return ret.toString();
	}

}