/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
@Table(name = "mail_server")
@NamedQueries({
    @NamedQuery(name = "MailServer.findAll", query = "SELECT m FROM MailServer m"),
    @NamedQuery(name = "MailServer.findByMail", query = "SELECT m FROM MailServer m WHERE m.mail = :Mail"),
    @NamedQuery(name = "MailServer.findByPassword", query = "SELECT m FROM MailServer m WHERE m.password = :Password"),
    @NamedQuery(name = "MailServer.findBySmtpHost", query = "SELECT m FROM MailServer m WHERE m.smtpHost = :SmtpHost"),
    @NamedQuery(name = "MailServer.findBySmtpPort", query = "SELECT m FROM MailServer m WHERE m.smtpPort = :SmtpPort"),
    @NamedQuery(name = "MailServer.findBySmtpStartTlsEnable", query = "SELECT m FROM MailServer m WHERE m.smtpStarttlsenable = :SmtpStartTlsEnable"),
    @NamedQuery(name = "MailServer.findBySmtpAuth", query = "SELECT m FROM MailServer m WHERE m.smtpAuth = :SmtpAuth"),
    @NamedQuery(name = "MailServer.findByRecoveryCase", query = "SELECT m FROM MailServer m WHERE m.recoveryCase = :recoveryCase"),
    @NamedQuery(name = "MailServer.findByMessageRecovery", query = "SELECT m FROM MailServer m WHERE m.messageRecovery = :messageRecovery"),
    @NamedQuery(name = "MailServer.findByLikePassword", query = "SELECT m FROM MailServer m WHERE m.password LIKE :Password"),
    @NamedQuery(name = "MailServer.findByLikeSmtpHost", query = "SELECT m FROM MailServer m WHERE m.smtpHost LIKE :SmtpHost"),
    @NamedQuery(name = "MailServer.findByLikeRecoveryCase", query = "SELECT m FROM MailServer m WHERE m.recoveryCase LIKE :recoveryCase"),
    @NamedQuery(name = "MailServer.findByLikeMessageRecovery", query = "SELECT m FROM MailServer m WHERE m.messageRecovery LIKE :messageRecovery"),
    @NamedQuery(name = "MailServer.updatePrimaryKey", query = "UPDATE MailServer m SET m.mail = :mailNuevo WHERE m.mail = :mailViejo")
})
public class MailServer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Mail", nullable = false)
    private Integer mail;
    @Column(name = "Password", length = 30)
    private String password;
    @Column(name = "smtp_Host", length = 120)
    private String smtpHost;
    @Column(name = "smtp_Port")
    private Integer smtpPort;
    @Column(name = "smtp_Start_tls_enable")
    private Boolean smtpStarttlsenable;
    @Column(name = "smtp_Auth")
    private Boolean smtpAuth;
    @Column(name = "recovery_Case", length = 50)
    private String recoveryCase;
    @Column(name = "message_Recovery", length = 250)
    private String messageRecovery;

    public MailServer() {
    }

    public MailServer(Integer mail) {
        this.mail = mail;
    }

    public Integer getMail() {
        return mail;
    }

    public void setMail(Integer mail) {
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

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    public Boolean getSmtpStarttlsenable() {
        return smtpStarttlsenable;
    }

    public void setSmtpStarttlsenable(Boolean smtpStarttlsenable) {
        this.smtpStarttlsenable = smtpStarttlsenable;
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

    public String getMessageRecovery() {
        return messageRecovery;
    }

    public void setMessageRecovery(String messageRecovery) {
        this.messageRecovery = messageRecovery;
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
        if (!(object instanceof MailServer)) {
            return false;
        }
        MailServer other = (MailServer) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.MailServer[ mail=" + mail + " ]";
    }
    
}
