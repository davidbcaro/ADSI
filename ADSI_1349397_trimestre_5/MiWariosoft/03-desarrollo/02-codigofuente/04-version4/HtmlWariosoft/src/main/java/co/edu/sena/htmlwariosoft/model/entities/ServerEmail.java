/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "server_email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServerEmail.findAll", query = "SELECT s FROM ServerEmail s")
    , @NamedQuery(name = "ServerEmail.findByEmail", query = "SELECT s FROM ServerEmail s WHERE s.email = :email")
    , @NamedQuery(name = "ServerEmail.findByPassword", query = "SELECT s FROM ServerEmail s WHERE s.password = :password")
    , @NamedQuery(name = "ServerEmail.findBySmtpHost", query = "SELECT s FROM ServerEmail s WHERE s.smtpHost = :smtpHost")
    , @NamedQuery(name = "ServerEmail.findBySmtpPort", query = "SELECT s FROM ServerEmail s WHERE s.smtpPort = :smtpPort")
    , @NamedQuery(name = "ServerEmail.findBySmtpStartTlsEnable", query = "SELECT s FROM ServerEmail s WHERE s.smtpStartTlsEnable = :smtpStartTlsEnable")
    , @NamedQuery(name = "ServerEmail.findBySmtpAuth", query = "SELECT s FROM ServerEmail s WHERE s.smtpAuth = :smtpAuth")
    , @NamedQuery(name = "ServerEmail.findByAffairRecovery", query = "SELECT s FROM ServerEmail s WHERE s.affairRecovery = :affairRecovery")
    , @NamedQuery(name = "ServerEmail.findByRecoveryCase", query = "SELECT s FROM ServerEmail s WHERE s.recoveryCase = :recoveryCase")})
public class ServerEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "smtp_host", nullable = false, length = 100)
    private String smtpHost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smtp_Port", nullable = false)
    private int smtpPort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smtp_Start_Tls_Enable", nullable = false)
    private boolean smtpStartTlsEnable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smtp_Auth", nullable = false)
    private boolean smtpAuth;
    @Size(max = 200)
    @Column(name = "affair_Recovery", length = 200)
    private String affairRecovery;
    @Size(max = 50)
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
        return "co.edu.sena.htmlwariosoft.model.entities.ServerEmail[ email=" + email + " ]";
    }
    
}
