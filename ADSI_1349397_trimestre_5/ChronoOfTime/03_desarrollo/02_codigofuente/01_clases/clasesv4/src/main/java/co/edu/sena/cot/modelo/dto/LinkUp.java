/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "link_up")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinkUp.findAll", query = "SELECT l FROM LinkUp l")
    , @NamedQuery(name = "LinkUp.findByTypeLink", query = "SELECT l FROM LinkUp l WHERE l.typeLink = :typeLink")
    , @NamedQuery(name = "LinkUp.findByHours", query = "SELECT l FROM LinkUp l WHERE l.hours = :hours")
    , @NamedQuery(name = "LinkUp.findByState", query = "SELECT l FROM LinkUp l WHERE l.state = :state")
    ,@NamedQuery(name = "LinkUp.updatePK", query = "UPDATE LinkUp l SET l.typeLink = :LinkUpNew WHERE l.typeLink = :LinkUpOld")

    , @NamedQuery(name = "LinkUp.findByLikeTypeLink", query = "SELECT l FROM LinkUp l WHERE l.typeLink LIKE :typeLink")

})
public class LinkUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_link", nullable = false, length = 100)
    private String typeLink;
    @Basic(optional = false)
    @Column(name = "hours", nullable = false)
    private int hours;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "linkuTol")
    private Collection<Instructor> instructorCollection;

    public LinkUp() {
    }

    public LinkUp(String typeLink) {
        this.typeLink = typeLink;
    }

    public LinkUp(String typeLink, int hours, boolean state) {
        this.typeLink = typeLink;
        this.hours = hours;
        this.state = state;
    }

    public String getTypeLink() {
        return typeLink;
    }

    public void setTypeLink(String typeLink) {
        this.typeLink = typeLink;
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
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLink != null ? typeLink.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinkUp)) {
            return false;
        }
        LinkUp other = (LinkUp) object;
        if ((this.typeLink == null && other.typeLink != null) || (this.typeLink != null && !this.typeLink.equals(other.typeLink))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.LinkUp[ typeLink=" + typeLink + " ]";
    }

}
