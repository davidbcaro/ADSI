/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
@Table(name = "server_email")
@NamedQueries({
    @NamedQuery(name = "ServerEmail.findAll", query = "SELECT s FROM ServerEmail s")})
public class ServerEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @Column(name = "smtp_host", nullable = false, length = 100)
    private String smtpHost;
    @Basic(optional = false)
    @Column(name = "smtp_Port", nullable = false)
    private int smtpPort;
    @Basic(optional = false)
    @Column(name = "smtp_Start_Tls_Enable", nullable = false)
    private boolean smtpStartTlsEnable;
    @Basic(optional = false)
    @Column(name = "smtp_Auth", nullable = false)
    private boolean smtpAuth;
    @Column(name = "affair_Recovery", length = 200)
    private String affairRecovery;
    @Column(name = "recovery_Case", length = 50)
    private String recoveryCase;

    public ServerEmail() {
    }

    public ServerEmail(String email) {
        this.email = email;
    }

    public ServerEmail(String email, String password, String smtpHost, int smtpPort, boolean smtpStartTlsEnable, boolean smtpAuth) {
        this.email = email;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.smtpStartTlsEnable = smtpStartTlsEnable;
        this.smtpAuth = smtpAuth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean getSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(boolean smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    public boolean getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public String getAffairRecovery() {
        return affairRecovery;
    }

    public void setAffairRecovery(String affairRecovery) {
        this.affairRecovery = affairRecovery;
    }

    public String getRecoveryCase() {
        return recoveryCase;
    }

    public void setRecoveryCase(String recoveryCase) {
        this.recoveryCase = recoveryCase;
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
        if (!(object instanceof ServerEmail)) {
            return false;
        }
        ServerEmail other = (ServerEmail) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.ServerEmail[ email=" + email + " ]";
    }
    
}
