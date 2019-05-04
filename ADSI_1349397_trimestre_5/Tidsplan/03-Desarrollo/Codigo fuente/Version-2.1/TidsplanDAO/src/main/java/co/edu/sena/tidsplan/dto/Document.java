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

public class Document implements Serializable
{
	/** 
	 * This attribute maps to the column id_document in the document table.
	 */
	protected String idDocument;

	/** 
	 * This attribute maps to the column type_document in the document table.
	 */
	protected String typeDocument;

	/** 
	 * This attribute maps to the column status in the document table.
	 */
	protected short status;

	/** 
	 * This attribute represents whether the primitive attribute status is null.
	 */
	protected boolean statusNull = true;

	/**
	 * Method 'Document'
	 * 
	 */
	public Document()
	{
	}

	/**
	 * Method 'getIdDocument'
	 * 
	 * @return String
	 */
	public String getIdDocument()
	{
		return idDocument;
	}

	/**
	 * Method 'setIdDocument'
	 * 
	 * @param idDocument
	 */
	public void setIdDocument(String idDocument)
	{
		this.idDocument = idDocument;
	}

	/**
	 * Method 'getTypeDocument'
	 * 
	 * @return String
	 */
	public String getTypeDocument()
	{
		return typeDocument;
	}

	/**
	 * Method 'setTypeDocument'
	 * 
	 * @param typeDocument
	 */
	public void setTypeDocument(String typeDocument)
	{
		this.typeDocument = typeDocument;
	}

	/**
	 * Method 'getStatus'
	 * 
	 * @return short
	 */
	public short getStatus()
	{
		return status;
	}

	/**
	 * Method 'setStatus'
	 * 
	 * @param status
	 */
	public void setStatus(short status)
	{
		this.status = status;
		this.statusNull = false;
	}

	/**
	 * Method 'setStatusNull'
	 * 
	 * @param value
	 */
	public void setStatusNull(boolean value)
	{
		this.statusNull = value;
	}

	/**
	 * Method 'isStatusNull'
	 * 
	 * @return boolean
	 */
	public boolean isStatusNull()
	{
		return statusNull;
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
		
		if (!(_other instanceof Document)) {
			return false;
		}
		
		final Document _cast = (Document) _other;
		if (idDocument == null ? _cast.idDocument != idDocument : !idDocument.equals( _cast.idDocument )) {
			return false;
		}
		
		if (typeDocument == null ? _cast.typeDocument != typeDocument : !typeDocument.equals( _cast.typeDocument )) {
			return false;
		}
		
		if (status != _cast.status) {
			return false;
		}
		
		if (statusNull != _cast.statusNull) {
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
		if (idDocument != null) {
			_hashCode = 29 * _hashCode + idDocument.hashCode();
		}
		
		if (typeDocument != null) {
			_hashCode = 29 * _hashCode + typeDocument.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) status;
		_hashCode = 29 * _hashCode + (statusNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return DocumentPk
	 */
	public DocumentPk createPk()
	{
		return new DocumentPk(idDocument);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.tidsplan.dto.Document: " );
		ret.append( "idDocument=" + idDocument );
		ret.append( ", typeDocument=" + typeDocument );
		ret.append( ", status=" + status );
		return ret.toString();
	}

}
