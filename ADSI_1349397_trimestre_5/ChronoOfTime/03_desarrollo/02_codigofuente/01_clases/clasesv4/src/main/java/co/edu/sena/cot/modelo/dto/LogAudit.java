/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "log_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogAudit.findAll", query = "SELECT l FROM LogAudit l")
    , @NamedQuery(name = "LogAudit.findByLogAudit", query = "SELECT l FROM LogAudit l WHERE l.logAudit = :logAudit")
    , @NamedQuery(name = "LogAudit.findByLevel", query = "SELECT l FROM LogAudit l WHERE l.level = :level")
    ,
       @NamedQuery(name = "LogAudit.findByMessage", query = "SELECT l FROM LogAudit l WHERE l.message = :message")
    , @NamedQuery(name = "LogAudit.findByLogName", query = "SELECT l FROM LogAudit l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogAudit.findByDate", query = "SELECT l FROM LogAudit l WHERE l.date = :date")
    , @NamedQuery(name = "LogAudit.findByUser", query = "SELECT l FROM LogAudit l WHERE l.user = :user")
    , @NamedQuery(name = "LogAudit.findByLikeLevel", query = "SELECT l FROM LogAudit l WHERE l.level LIKE :level")
    , @NamedQuery(name = "LogAudit.findByLikeLogName", query = "SELECT l FROM LogAudit l WHERE l.logName LIKE :logName")
    , @NamedQuery(name = "LogAudit.findByLikeMessage", query = "SELECT l FROM LogAudit l WHERE l.message LIKE :message")
    , @NamedQuery(name = "LogAudit.findByLikeUser", query = "SELECT l FROM LogAudit l WHERE l.user LIKE :user")
    ,@NamedQuery (name = "LogAudit.updatePK", query = "UPDATE LogAudit l SET l.logAudit = :llaveNueva WHERE l.logAudit = :llaveVieja")
})
public class LogAudit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "log_audit", nullable = false)
    private Long logAudit;
    @Column(name = "level", length = 45)
    private String level;
    @Column(name = "log_name", length = 256)
    private String logName;
    @Lob
    @Column(name = "message", length = 65535)
    private String message;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "user", length = 100)
    private String user;

    public LogAudit() {
    }

    public LogAudit(Long logAudit) {
        this.logAudit = logAudit;
    }

    public Long getLogAudit() {
        return logAudit;
    }

    public void setLogAudit(Long logAudit) {
        this.logAudit = logAudit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logAudit != null ? logAudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAudit)) {
            return false;
        }
        LogAudit other = (LogAudit) object;
        if ((this.logAudit == null && other.logAudit != null) || (this.logAudit != null && !this.logAudit.equals(other.logAudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.LogAudit[ logAudit=" + logAudit + " ]";
    }

}
