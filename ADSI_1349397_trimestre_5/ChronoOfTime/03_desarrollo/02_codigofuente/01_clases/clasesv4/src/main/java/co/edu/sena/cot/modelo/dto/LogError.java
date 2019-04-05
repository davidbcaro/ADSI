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
@Table(name = "log_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogError.findAll", query = "SELECT l FROM LogError l")
    , @NamedQuery(name = "LogError.findByLogError", query = "SELECT l FROM LogError l WHERE l.logError = :logError")
    , @NamedQuery(name = "LogError.findByLevel", query = "SELECT l FROM LogError l WHERE l.level = :level")
    , @NamedQuery(name = "LogError.findByLogName", query = "SELECT l FROM LogError l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogError.findByDate", query = "SELECT l FROM LogError l WHERE l.date = :date")
    , @NamedQuery(name = "LogError.findByUser", query = "SELECT l FROM LogError l WHERE l.user = :user")
    , @NamedQuery(name = "LogError.findByMessage", query = "SELECT l FROM LogError l WHERE l.message = :message")
    , @NamedQuery(name = "LogError.findByLikeLevel", query = "SELECT l FROM LogError l WHERE l.level LIKE :level")
    , @NamedQuery(name = "LogError.findByLikeLogName", query = "SELECT l FROM LogError l WHERE l.logName LIKE :logName")
    , @NamedQuery(name = "LogError.findByLikeUser", query = "SELECT l FROM LogError l WHERE l.user LIKE :user")
    , @NamedQuery(name = "LogError.findByLikeMessage", query = "SELECT l FROM LogError l WHERE l.message LIKE :message")
    ,@NamedQuery (name = "LogError.updatePK", query = "UPDATE LogError l SET l.logError = :llaveNueva WHERE l.logError = :llaveVieja")})
public class LogError implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "log_error", nullable = false)
    private Integer logError;
    @Column(name = "level", length = 15)
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

    public LogError() {
    }

    public LogError(Integer logError) {
        this.logError = logError;
    }

    public Integer getLogError() {
        return logError;
    }

    public void setLogError(Integer logError) {
        this.logError = logError;
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
        hash += (logError != null ? logError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogError)) {
            return false;
        }
        LogError other = (LogError) object;
        if ((this.logError == null && other.logError != null) || (this.logError != null && !this.logError.equals(other.logError))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.LogError[ logError=" + logError + " ]";
    }
    
}
