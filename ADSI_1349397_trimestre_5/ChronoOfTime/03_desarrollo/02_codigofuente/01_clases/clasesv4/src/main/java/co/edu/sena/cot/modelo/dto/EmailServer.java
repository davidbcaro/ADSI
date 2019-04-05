/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "email_server")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailServer.findAll", query = "SELECT e FROM EmailServer e")
    , @NamedQuery(name = "EmailServer.findByEmail", query = "SELECT e FROM EmailServer e WHERE e.email = :email")
    , @NamedQuery(name = "EmailServer.findByPasswordSecurity", query = "SELECT e FROM EmailServer e WHERE e.passwordSecurity = :passwordSecurity")
    , @NamedQuery(name = "EmailServer.findBySmtpHost", query = "SELECT e FROM EmailServer e WHERE e.smtpHost = :smtpHost")
    , @NamedQuery(name = "EmailServer.findBySmtpPort", query = "SELECT e FROM EmailServer e WHERE e.smtpPort = :smtpPort")
    , @NamedQuery(name = "EmailServer.findBySmtpStartTlsEnable", query = "SELECT e FROM EmailServer e WHERE e.smtpStartTlsEnable = :smtpStartTlsEnable")
    , @NamedQuery(name = "EmailServer.findBySmtpAuth", query = "SELECT e FROM EmailServer e WHERE e.smtpAuth = :smtpAuth")
    , @NamedQuery(name = "EmailServer.findByRecoveryOrder", query = "SELECT e FROM EmailServer e WHERE e.recoveryOrder = :recoveryOrder")
    , @NamedQuery(name = "EmailServer.findByRecoveryMessage", query = "SELECT e FROM EmailServer e WHERE e.recoveryMessage = :recoveryMessage")
    , @NamedQuery(name = "EmailServer.findByLikeEmail", query = "SELECT e FROM EmailServer e WHERE e.email LIKE :email")
    , @NamedQuery(name = "EmailServer.findByLikePasswordSecurity", query = "SELECT e FROM EmailServer e WHERE e.passwordSecurity LIKE :passwordSecurity")
    , @NamedQuery(name = "EmailServer.findByLikeSmtpHost", query = "SELECT e FROM EmailServer e WHERE e.smtpHost LIKE :smtpHost")
    , @NamedQuery(name = "EmailServer.findByLikeSmtpPort", query = "SELECT e FROM EmailServer e WHERE e.smtpPort LIKE :smtpPort")
    , @NamedQuery(name = "EmailServer.findByLikeRecoveryOrder", query = "SELECT e FROM EmailServer e WHERE e.recoveryOrder LIKE :recoveryOrder")
    , @NamedQuery(name = "EmailServer.findByLikeRecoveryMessage", query = "SELECT e FROM EmailServer e WHERE e.recoveryMessage LIKE :recoveryMessage")
    ,@NamedQuery (name = "EmailServer.updatePK", query = "UPDATE EmailServer e SET e.email = :llaveNueva WHERE e.email = :llaveVieja")})
public class EmailServer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "password_security", length = 45)
    private String passwordSecurity;
    @Column(name = "smtp_host", length = 45)
    private String smtpHost;
    @Column(name = "smtp_port", length = 45)
    private String smtpPort;
    @Column(name = "smtp_start_tls_enable")
    private Boolean smtpStartTlsEnable;
    @Column(name = "smtp_auth")
    private Boolean smtpAuth;
    @Column(name = "recovery_order", length = 45)
    private String recoveryOrder;
    @Column(name = "recovery_message", length = 45)
    private String recoveryMessage;

    public EmailServer() {
    }

    public EmailServer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordSecurity() {
        return passwordSecurity;
    }

    public void setPasswordSecurity(String passwordSecurity) {
        this.passwordSecurity = passwordSecurity;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
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

    public String getRecoveryOrder() {
        return recoveryOrder;
    }

    public void setRecoveryOrder(String recoveryOrder) {
        this.recoveryOrder = recoveryOrder;
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
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailServer)) {
            return false;
        }
        EmailServer other = (EmailServer) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.EmailServer[ email=" + email + " ]";
    }
    
}
