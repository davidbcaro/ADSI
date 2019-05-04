/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "email_server")
@NamedQueries({
    @NamedQuery(name = "EmailServer.findAll", query = "SELECT e FROM EmailServer e")
    , @NamedQuery(name = "EmailServer.findByMail", query = "SELECT e FROM EmailServer e WHERE e.mail = :mail")
    , @NamedQuery(name = "EmailServer.findByPassword", query = "SELECT e FROM EmailServer e WHERE e.password = :password")
    , @NamedQuery(name = "EmailServer.findBySmtpHost", query = "SELECT e FROM EmailServer e WHERE e.smtpHost = :smtpHost")
    , @NamedQuery(name = "EmailServer.findBySmtpPort", query = "SELECT e FROM EmailServer e WHERE e.smtpPort = :smtpPort")
    , @NamedQuery(name = "EmailServer.findBySmtpStartTlsEnable", query = "SELECT e FROM EmailServer e WHERE e.smtpStartTlsEnable = :smtpStartTlsEnable")
    , @NamedQuery(name = "EmailServer.findBySmtpAuth", query = "SELECT e FROM EmailServer e WHERE e.smtpAuth = :smtpAuth")
    , @NamedQuery(name = "EmailServer.findByRecoveryCase", query = "SELECT e FROM EmailServer e WHERE e.recoveryCase = :recoveryCase")
    , @NamedQuery(name = "EmailServer.findByRecoveryMessage", query = "SELECT e FROM EmailServer e WHERE e.recoveryMessage = :recoveryMessage")})
public class EmailServer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic(optional = false)
    @Column(name = "smtp_host", nullable = false, length = 60)
    private String smtpHost;
    @Basic(optional = false)
    @Column(name = "smtp_port", nullable = false)
    private int smtpPort;
    @Column(name = "smtp_start_tls_enable")
    private Boolean smtpStartTlsEnable;
    @Column(name = "smtp_auth")
    private Boolean smtpAuth;
    @Basic(optional = false)
    @Column(name = "recovery_case", nullable = false, length = 45)
    private String recoveryCase;
    @Basic(optional = false)
    @Column(name = "recovery_message", nullable = false, length = 100)
    private String recoveryMessage;

    public EmailServer() {
    }

    public EmailServer(String mail) {
        this.mail = mail;
    }

    public EmailServer(String mail, String password, String smtpHost, int smtpPort, String recoveryCase, String recoveryMessage) {
        this.mail = mail;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.recoveryCase = recoveryCase;
        this.recoveryMessage = recoveryMessage;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public Boolean getSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(Boolean smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    public Boolean getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(Boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public String getRecoveryCase() {
        return recoveryCase;
    }

    public void setRecoveryCase(String recoveryCase) {
        this.recoveryCase = recoveryCase;
    }

    public String getRecoveryMessage() {
        return recoveryMessage;
    }

    public void setRecoveryMessage(String recoveryMessage) {
        this.recoveryMessage = recoveryMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailServer)) {
            return false;
        }
        EmailServer other = (EmailServer) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.EmailServer[ mail=" + mail + " ]";
    }
    
}
