/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
@Table(name = "auditory_log")
@NamedQueries({
    @NamedQuery(name = "AuditoryLog.findAll", query = "SELECT a FROM AuditoryLog a"),
    @NamedQuery(name = "AuditoryLog.findByLevel", query = "SELECT l FROM AuditoryLog l WHERE l.level = :Level"),
    @NamedQuery(name = "AuditoryLog.findByLogName", query = "SELECT l FROM AuditoryLog l WHERE l.logName = :logName"),
    @NamedQuery(name = "AuditoryLog.findByMessage", query = "SELECT l FROM AuditoryLog l WHERE l.message = :Message"),
    @NamedQuery(name = "AuditoryLog.findByDate", query = "SELECT l FROM AuditoryLog l WHERE l.date = :Date"),
    @NamedQuery(name = "AuditoryLog.findByUser", query = "SELECT l FROM AuditoryLog l WHERE l.user = :User"),
    @NamedQuery(name = "AuditoryLog.findByLikeLevel", query = "SELECT l FROM AuditoryLog l WHERE l.level LIKE :Level"),
    @NamedQuery(name = "AuditoryLog.findByLikeLogName", query = "SELECT l FROM AuditoryLog l WHERE l.logName LIKE :logName"),
    @NamedQuery(name = "AuditoryLog.findByLikeMessage", query = "SELECT l FROM AuditoryLog l WHERE l.message LIKE :Message"),
    @NamedQuery(name = "AuditoryLog.findByLikeUser", query = "SELECT l FROM AuditoryLog l WHERE l.user LIKE :User"),
    @NamedQuery(name = "AuditoryLog.updatePrimaryKey", query = "UPDATE AuditoryLog l SET l.idLog = :AudiNuevo WHERE l.idLog = :AudiViejo")
})
public class AuditoryLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Log", nullable = false)
    private Long idLog;
    @Column(name = "Level", length = 15)
    private String level;
    @Lob
    @Column(name = "log_Name", length = 65535)
    private String logName;
    @Lob
    @Column(name = "Message", length = 65535)
    private String message;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "User", length = 100)
    private String user;

    public AuditoryLog() {
    }

    public AuditoryLog(Long idLog) {
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
        if (!(object instanceof AuditoryLog)) {
            return false;
        }
        AuditoryLog other = (AuditoryLog) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.AuditoryLog[ idLog=" + idLog + " ]";
    }
    
}
