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
@Table(name = "log_error")
@NamedQueries({
    @NamedQuery(name = "LogError.findAll", query = "SELECT l FROM LogError l")
    , @NamedQuery(name = "LogError.findByIdLog", query = "SELECT l FROM LogError l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogError.findByLikeIdLog", query = "SELECT l FROM LogError l WHERE l.idLog like :idLog")
    , @NamedQuery(name = "LogError.findByLevel", query = "SELECT l FROM LogError l WHERE l.level = :level")
    , @NamedQuery(name = "LogError.findByLikeLevel", query = "SELECT l FROM LogError l WHERE l.level like :level")
    , @NamedQuery(name = "LogError.findByLogName", query = "SELECT l FROM LogError l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogError.findByLikeLogName", query = "SELECT l FROM LogError l WHERE l.logName like :logName")
    , @NamedQuery(name = "LogError.findByDate", query = "SELECT l FROM LogError l WHERE l.date = :date")
    , @NamedQuery(name = "LogError.findByUser", query = "SELECT l FROM LogError l WHERE l.user = :user")
    , @NamedQuery(name = "LogError.findByLikeUser", query = "SELECT l FROM LogError l WHERE l.user like :user")
    , @NamedQuery(name = "LogError.updatePrimaryKey", query = "UPDATE LogError l SET l.idLog = :newKey WHERE l.idLog = :oldKey")})

public class LogError implements Serializable {

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
    @Column(name = "user", length = 50)
    private String user;

    public LogError() {
    }

    public LogError(Long idLog) {
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
        if (!(object instanceof LogError)) {
            return false;
        }
        LogError other = (LogError) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.LogError[ idLog=" + idLog + " ]";
    }
    
}
