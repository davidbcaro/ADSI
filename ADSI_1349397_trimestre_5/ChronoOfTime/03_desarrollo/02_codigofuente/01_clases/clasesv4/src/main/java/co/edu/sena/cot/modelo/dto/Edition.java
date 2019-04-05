/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "edition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e")
    , @NamedQuery(name = "Edition.findByIdEdition", query = "SELECT e FROM Edition e WHERE e.editionPK.ideEdition = :ideEdition")
    , @NamedQuery(name = "Edition.findByIdTrimester", query = "SELECT e FROM Edition e WHERE e.editionPK.idTrimester = :idTrimester")
    , @NamedQuery(name = "Edition.findByLikeIdTrimester", query = "SELECT e FROM Edition e WHERE e.editionPK.idTrimester LIKE :idTrimester")
    , @NamedQuery(name = "Edition.updatePK", query = "UPDATE Edition e SET e.editionPK.idTrimester = :IdTrimesterNew, e.editionPK.ideEdition = :IdeEditionNew WHERE e.editionPK.idTrimester = :IdTrimesterOld AND e.editionPK.ideEdition = :IdeEditionOld")})
public class Edition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EditionPK editionPK;
    @JoinColumn(name = "id_trimester", referencedColumnName = "id_trimester", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrimesterTerm trimesterTerm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edition")
    private Collection<Timetable> timetableCollection;

    public Edition() {
    }

    public Edition(EditionPK editionPK) {
        this.editionPK = editionPK;
    }

    public Edition(int ideEdition, String idTrimester) {
        this.editionPK = new EditionPK(ideEdition, idTrimester);
    }

    public EditionPK getEditionPK() {
        return editionPK;
    }

    public void setEditionPK(EditionPK editionPK) {
        this.editionPK = editionPK;
    }

    public TrimesterTerm getTrimesterTerm() {
        return trimesterTerm;
    }

    public void setTrimesterTerm(TrimesterTerm trimesterTerm) {
        this.trimesterTerm = trimesterTerm;
    }

    @XmlTransient
    public Collection<Timetable> getTimetableCollection() {
        return timetableCollection;
    }

    public void setTimetableCollection(Collection<Timetable> timetableCollection) {
        this.timetableCollection = timetableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (editionPK != null ? editionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edition)) {
            return false;
        }
        Edition other = (Edition) object;
        if ((this.editionPK == null && other.editionPK != null) || (this.editionPK != null && !this.editionPK.equals(other.editionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Edition[ editionPK=" + editionPK + " ]";
    }
    
}
