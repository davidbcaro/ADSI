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
 * This class represents the primary key of the group_has_trimester table.
 */
public class GroupHasTrimesterPk implements Serializable
{
	protected String numberGroup;

	protected String nameTrimester;

	protected String workingdayInitials;

	protected String levelFormation;

	/** 
	 * Sets the value of numberGroup
	 */
	public void setNumberGroup(String numberGroup)
	{
		this.numberGroup = numberGroup;
	}

	/** 
	 * Gets the value of numberGroup
	 */
	public String getNumberGroup()
	{
		return numberGroup;
	}

	/** 
	 * Sets the value of nameTrimester
	 */
	public void setNameTrimester(String nameTrimester)
	{
		this.nameTrimester = nameTrimester;
	}

	/** 
	 * Gets the value of nameTrimester
	 */
	public String getNameTrimester()
	{
		return nameTrimester;
	}

	/** 
	 * Sets the value of workingdayInitials
	 */
	public void setWorkingdayInitials(String workingdayInitials)
	{
		this.workingdayInitials = workingdayInitials;
	}

	/** 
	 * Gets the value of workingdayInitials
	 */
	public String getWorkingdayInitials()
	{
		return workingdayInitials;
	}

	/** 
	 * Sets the value of levelFormation
	 */
	public void setLevelFormation(String levelFormation)
	{
		this.levelFormation = levelFormation;
	}

	/** 
	 * Gets the value of levelFormation
	 */
	public String getLevelFormation()
	{
		return levelFormation;
	}

	/**
	 * Method 'GroupHasTrimesterPk'
	 * 
	 */
	public GroupHasTrimesterPk()
	{
	}

	/**
	 * Method 'GroupHasTrimesterPk'
	 * 
	 * @param numberGroup
	 * @param nameTrimester
	 * @param workingdayInitials
	 * @param levelFormation
	 */
	public GroupHasTrimesterPk(final String numberGroup, final String nameTrimester, final String workingdayInitials, final String levelFormation)
	{
		this.numberGroup = numberGroup;
		this.nameTrimester = nameTrimester;
		this.workingdayInitials = workingdayInitials;
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
		
		if (!(_other instanceof GroupHasTrimesterPk)) {
			return false;
		}
		
		final GroupHasTrimesterPk _cast = (GroupHasTrimesterPk) _other;
		if (numberGroup == null ? _cast.numberGroup != numberGroup : !numberGroup.equals( _cast.numberGroup )) {
			return false;
		}
		
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
		if (numberGroup != null) {
			_hashCode = 29 * _hashCode + numberGroup.hashCode();
		}
		
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
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.GroupHasTrimesterPk: " );
		ret.append( "numberGroup=" + numberGroup );
		ret.append( ", nameTrimester=" + nameTrimester );
		ret.append( ", workingdayInitials=" + workingdayInitials );
		ret.append( ", levelFormation=" + levelFormation );
		return ret.toString();
	}

}