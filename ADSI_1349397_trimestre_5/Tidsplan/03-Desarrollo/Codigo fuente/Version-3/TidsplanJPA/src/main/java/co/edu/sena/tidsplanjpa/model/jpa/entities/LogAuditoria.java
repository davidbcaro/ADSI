/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "log_auditoria")
@NamedQueries({
    @NamedQuery(name = "LogAuditoria.findAll", query = "SELECT l FROM LogAuditoria l")
    , @NamedQuery(name = "LogAuditoria.findByIdLog", query = "SELECT l FROM LogAuditoria l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogAuditoria.findByLevel", query = "SELECT l FROM LogAuditoria l WHERE l.level = :level")
    , @NamedQuery(name = "LogAuditoria.findByLogName", query = "SELECT l FROM LogAuditoria l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogAuditoria.findByDate", query = "SELECT l FROM LogAuditoria l WHERE l.date = :date")
    , @NamedQuery(name = "LogAuditoria.findByUser", query = "SELECT l FROM LogAuditoria l WHERE l.user = :user")})
public class LogAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_log", nullable = false)
    private Long idLog;
    @Column(name = "level", length = 15)
    private String level;
    @Column(name = "log_name", length = 250)
    private String logName;
    @Lob
    @Column(name = "message", length = 65535)
    private String message;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "user", length = 100)
    private String user;

    public LogAuditoria() {
    }

    public LogAuditoria(Long idLog) {
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
        if (!(object instanceof LogAuditoria)) {
            return false;
        }
        LogAuditoria other = (LogAuditoria) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.LogAuditoria[ idLog=" + idLog + " ]";
    }
    
}
