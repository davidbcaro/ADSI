/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol")
        , @NamedQuery(name = "Rol.findByLikeIdRol", query = "SELECT r FROM Rol r WHERE r.idRol LIKE :idRol")
    , @NamedQuery(name = "Rol.findByDescription", query = "SELECT r FROM Rol r WHERE r.description = :description")
    , @NamedQuery(name = "Rol.findByState", query = "SELECT r FROM Rol r WHERE r.state = :state")
    , @NamedQuery(name = "Rol.findByLikeDescription", query = "SELECT r FROM Rol r WHERE r.description LIKE :description")
    ,@NamedQuery(name = "Rol.updatePK", query = "UPDATE Rol r SET r.idRol = :llaveNueva WHERE r.idRol = :llaveVieja")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false, length = 45)
    private String idRol;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 250)
    private String description;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Person> personCollection;

    public Rol() {
    }

    public Rol(String idRol) {
        this.idRol = idRol;
    }

    public Rol(String idRol, String description, boolean state) {
        this.idRol = idRol;
        this.description = description;
        this.state = state;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Rol[ idRol=" + idRol + " ]";
    }

}
