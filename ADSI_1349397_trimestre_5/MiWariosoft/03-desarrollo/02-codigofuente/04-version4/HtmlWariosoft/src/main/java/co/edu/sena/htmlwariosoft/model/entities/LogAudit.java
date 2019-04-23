/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "log_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogAudit.findAll", query = "SELECT l FROM LogAudit l")
    , @NamedQuery(name = "LogAudit.findByIdLog", query = "SELECT l FROM LogAudit l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogAudit.findByLevel", query = "SELECT l FROM LogAudit l WHERE l.level = :level")
    , @NamedQuery(name = "LogAudit.findByLogName", query = "SELECT l FROM LogAudit l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogAudit.findByDate", query = "SELECT l FROM LogAudit l WHERE l.date = :date")
    , @NamedQuery(name = "LogAudit.findByUser", query = "SELECT l FROM LogAudit l WHERE l.user = :user")})
public class LogAudit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Log", nullable = false)
    private Long idLog;
    @Size(max = 15)
    @Column(name = "level", length = 15)
    private String level;
    @Size(max = 256)
    @Column(name = "log_Name", length = 256)
    private String logName;
    @Lob
    @Size(max = 65535)
    @Column(name = "message", length = 65535)
    private String message;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 100)
    @Column(name = "user", length = 100)
    private String user;

    public LogAudit() {
    }

    public LogAudit(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
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
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAudit)) {
            return false;
        }
        LogAudit other = (LogAudit) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.LogAudit[ idLog=" + idLog + " ]";
    }
    
}
