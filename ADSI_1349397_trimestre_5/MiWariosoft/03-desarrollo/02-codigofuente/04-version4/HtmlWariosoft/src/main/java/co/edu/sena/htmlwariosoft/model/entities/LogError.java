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
@Table(name = "log_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogError.findAll", query = "SELECT l FROM LogError l")
    , @NamedQuery(name = "LogError.findByIdLog", query = "SELECT l FROM LogError l WHERE l.idLog = :idLog")
    , @NamedQuery(name = "LogError.findByLevel", query = "SELECT l FROM LogError l WHERE l.level = :level")
    , @NamedQuery(name = "LogError.findByLogName", query = "SELECT l FROM LogError l WHERE l.logName = :logName")
    , @NamedQuery(name = "LogError.findByDate", query = "SELECT l FROM LogError l WHERE l.date = :date")
    , @NamedQuery(name = "LogError.findByUser", query = "SELECT l FROM LogError l WHERE l.user = :user")})
public class LogError implements Serializable {

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
        return "co.edu.sena.htmlwariosoft.model.entities.LogError[ idLog=" + idLog + " ]";
    }
    
}
