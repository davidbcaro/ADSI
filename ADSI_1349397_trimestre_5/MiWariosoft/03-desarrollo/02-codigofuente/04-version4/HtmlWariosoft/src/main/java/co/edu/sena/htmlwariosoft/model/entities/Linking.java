/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "linking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linking.findAll", query = "SELECT l FROM Linking l")
    , @NamedQuery(name = "Linking.findByTypeLinking", query = "SELECT l FROM Linking l WHERE l.typeLinking = :typeLinking")
    , @NamedQuery(name = "Linking.findByHours", query = "SELECT l FROM Linking l WHERE l.hours = :hours")
    , @NamedQuery(name = "Linking.findByState", query = "SELECT l FROM Linking l WHERE l.state = :state")})
public class Linking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type_Linking", nullable = false, length = 20)
    private String typeLinking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hours", nullable = false)
    private int hours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeLinking", fetch = FetchType.LAZY)
    private Collection<Teacher> teacherCollection;

    public Linking() {
    }

    public Linking(String typeLinking) {
        this.typeLinking = typeLinking;
    }

    public Linking(String typeLinking, int hours, boolean state) {
        this.typeLinking = typeLinking;
        this.hours = hours;
        this.state = state;
    }

    public String getTypeLinking() {
        return typeLinking;
    }

    public void setTypeLinking(String typeLinking) {
        this.typeLinking = typeLinking;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLinking != null ? typeLinking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linking)) {
            return false;
        }
        Linking other = (Linking) object;
        if ((this.typeLinking == null && other.typeLinking != null) || (this.typeLinking != null && !this.typeLinking.equals(other.typeLinking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.Linking[ typeLinking=" + typeLinking + " ]";
    }
    
}
