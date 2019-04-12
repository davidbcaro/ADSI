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

public class MailServer implements Serializable
{
	/** 
	 * This attribute maps to the column Mail in the mail_server table.
	 */
	protected int mail;

	/** 
	 * This attribute maps to the column Password in the mail_server table.
	 */
	protected String password;

	/** 
	 * This attribute maps to the column smtp_Host in the mail_server table.
	 */
	protected String smtpHost;

	/** 
	 * This attribute maps to the column smtp_Port in the mail_server table.
	 */
	protected int smtpPort;

	/** 
	 * This attribute represents whether the primitive attribute smtpPort is null.
	 */
	protected boolean smtpPortNull = true;

	/** 
	 * This attribute maps to the column smtp_Start_tls_enable in the mail_server table.
	 */
	protected short smtpStartTlsEnable;

	/** 
	 * This attribute represents whether the primitive attribute smtpStartTlsEnable is null.
	 */
	protected boolean smtpStartTlsEnableNull = true;

	/** 
	 * This attribute maps to the column smtp_Auth in the mail_server table.
	 */
	protected short smtpAuth;

	/** 
	 * This attribute represents whether the primitive attribute smtpAuth is null.
	 */
	protected boolean smtpAuthNull = true;

	/** 
	 * This attribute maps to the column recovery_Case in the mail_server table.
	 */
	protected String recoveryCase;

	/** 
	 * This attribute maps to the column message_Recovery in the mail_server table.
	 */
	protected String messageRecovery;

	/**
	 * Method 'MailServer'
	 * 
	 */
	public MailServer()
	{
	}

	/**
	 * Method 'getMail'
	 * 
	 * @return int
	 */
	public int getMail()
	{
		return mail;
	}

	/**
	 * Method 'setMail'
	 * 
	 * @param mail
	 */
	public void setMail(int mail)
	{
		this.mail = mail;
	}

	/**
	 * Method 'getPassword'
	 * 
	 * @return String
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Method 'setPassword'
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Method 'getSmtpHost'
	 * 
	 * @return String
	 */
	public String getSmtpHost()
	{
		return smtpHost;
	}

	/**
	 * Method 'setSmtpHost'
	 * 
	 * @param smtpHost
	 */
	public void setSmtpHost(String smtpHost)
	{
		this.smtpHost = smtpHost;
	}

	/**
	 * Method 'getSmtpPort'
	 * 
	 * @return int
	 */
	public int getSmtpPort()
	{
		return smtpPort;
	}

	/**
	 * Method 'setSmtpPort'
	 * 
	 * @param smtpPort
	 */
	public void setSmtpPort(int smtpPort)
	{
		this.smtpPort = smtpPort;
		this.smtpPortNull = false;
	}

	/**
	 * Method 'setSmtpPortNull'
	 * 
	 * @param value
	 */
	public void setSmtpPortNull(boolean value)
	{
		this.smtpPortNull = value;
	}

	/**
	 * Method 'isSmtpPortNull'
	 * 
	 * @return boolean
	 */
	public boolean isSmtpPortNull()
	{
		return smtpPortNull;
	}

	/**
	 * Method 'getSmtpStartTlsEnable'
	 * 
	 * @return short
	 */
	public short getSmtpStartTlsEnable()
	{
		return smtpStartTlsEnable;
	}

	/**
	 * Method 'setSmtpStartTlsEnable'
	 * 
	 * @param smtpStartTlsEnable
	 */
	public void setSmtpStartTlsEnable(short smtpStartTlsEnable)
	{
		this.smtpStartTlsEnable = smtpStartTlsEnable;
		this.smtpStartTlsEnableNull = false;
	}

	/**
	 * Method 'setSmtpStartTlsEnableNull'
	 * 
	 * @param value
	 */
	public void setSmtpStartTlsEnableNull(boolean value)
	{
		this.smtpStartTlsEnableNull = value;
	}

	/**
	 * Method 'isSmtpStartTlsEnableNull'
	 * 
	 * @return boolean
	 */
	public boolean isSmtpStartTlsEnableNull()
	{
		return smtpStartTlsEnableNull;
	}

	/**
	 * Method 'getSmtpAuth'
	 * 
	 * @return short
	 */
	public short getSmtpAuth()
	{
		return smtpAuth;
	}

	/**
	 * Method 'setSmtpAuth'
	 * 
	 * @param smtpAuth
	 */
	public void setSmtpAuth(short smtpAuth)
	{
		this.smtpAuth = smtpAuth;
		this.smtpAuthNull = false;
	}

	/**
	 * Method 'setSmtpAuthNull'
	 * 
	 * @param value
	 */
	public void setSmtpAuthNull(boolean value)
	{
		this.smtpAuthNull = value;
	}

	/**
	 * Method 'isSmtpAuthNull'
	 * 
	 * @return boolean
	 */
	public boolean isSmtpAuthNull()
	{
		return smtpAuthNull;
	}

	/**
	 * Method 'getRecoveryCase'
	 * 
	 * @return String
	 */
	public String getRecoveryCase()
	{
		return recoveryCase;
	}

	/**
	 * Method 'setRecoveryCase'
	 * 
	 * @param recoveryCase
	 */
	public void setRecoveryCase(String recoveryCase)
	{
		this.recoveryCase = recoveryCase;
	}

	/**
	 * Method 'getMessageRecovery'
	 * 
	 * @return String
	 */
	public String getMessageRecovery()
	{
		return messageRecovery;
	}

	/**
	 * Method 'setMessageRecovery'
	 * 
	 * @param messageRecovery
	 */
	public void setMessageRecovery(String messageRecovery)
	{
		this.messageRecovery = messageRecovery;
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
		
		if (!(_other instanceof MailServer)) {
			return false;
		}
		
		final MailServer _cast = (MailServer) _other;
		if (mail != _cast.mail) {
			return false;
		}
		
		if (password == null ? _cast.password != password : !password.equals( _cast.password )) {
			return false;
		}
		
		if (smtpHost == null ? _cast.smtpHost != smtpHost : !smtpHost.equals( _cast.smtpHost )) {
			return false;
		}
		
		if (smtpPort != _cast.smtpPort) {
			return false;
		}
		
		if (smtpPortNull != _cast.smtpPortNull) {
			return false;
		}
		
		if (smtpStartTlsEnable != _cast.smtpStartTlsEnable) {
			return false;
		}
		
		if (smtpStartTlsEnableNull != _cast.smtpStartTlsEnableNull) {
			return false;
		}
		
		if (smtpAuth != _cast.smtpAuth) {
			return false;
		}
		
		if (smtpAuthNull != _cast.smtpAuthNull) {
			return false;
		}
		
		if (recoveryCase == null ? _cast.recoveryCase != recoveryCase : !recoveryCase.equals( _cast.recoveryCase )) {
			return false;
		}
		
		if (messageRecovery == null ? _cast.messageRecovery != messageRecovery : !messageRecovery.equals( _cast.messageRecovery )) {
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
		_hashCode = 29 * _hashCode + mail;
		if (password != null) {
			_hashCode = 29 * _hashCode + password.hashCode();
		}
		
		if (smtpHost != null) {
			_hashCode = 29 * _hashCode + smtpHost.hashCode();
		}
		
		_hashCode = 29 * _hashCode + smtpPort;
		_hashCode = 29 * _hashCode + (smtpPortNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (int) smtpStartTlsEnable;
		_hashCode = 29 * _hashCode + (smtpStartTlsEnableNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (int) smtpAuth;
		_hashCode = 29 * _hashCode + (smtpAuthNull ? 1 : 0);
		if (recoveryCase != null) {
			_hashCode = 29 * _hashCode + recoveryCase.hashCode();
		}
		
		if (messageRecovery != null) {
			_hashCode = 29 * _hashCode + messageRecovery.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return MailServerPk
	 */
	public MailServerPk createPk()
	{
		return new MailServerPk(mail);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.dto.MailServer: " );
		ret.append( "mail=" + mail );
		ret.append( ", password=" + password );
		ret.append( ", smtpHost=" + smtpHost );
		ret.append( ", smtpPort=" + smtpPort );
		ret.append( ", smtpStartTlsEnable=" + smtpStartTlsEnable );
		ret.append( ", smtpAuth=" + smtpAuth );
		ret.append( ", recoveryCase=" + recoveryCase );
		ret.append( ", messageRecovery=" + messageRecovery );
		return ret.toString();
	}

}
