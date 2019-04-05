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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findBySpecialityName", query = "SELECT i FROM Instructor i WHERE i.specialityName.name = :specialityName")
    , @NamedQuery(name = "Instructor.findByNumberDocument", query = "SELECT i FROM Instructor i WHERE i.instructorPK.numberDocument = :numberDocument")
    , @NamedQuery(name = "Instructor.findByLikeSpecialityName", query = "SELECT i FROM Instructor i WHERE i.specialityName.name LIKE :specialityName")
    , @NamedQuery(name = "Instructor.findByTypeLink", query = "SELECT i FROM Instructor i WHERE i.linkuTol.typeLink = :typeLink")
    
    ,@NamedQuery(name = "Instructor.updatePK", query = "UPDATE Instructor i SET i.instructorPK.document = :DocumentNew, i.instructorPK.numberDocument = :NumberDocumentNew WHERE i.instructorPK.document = :DocumentOld AND i.instructorPK.numberDocument = :NumberDocumentOld")    
    ,@NamedQuery(name = "Instructor.findByDocument", query = "SELECT i FROM Instructor i WHERE i.instructorPK.document = :document")
    ,@NamedQuery(name = "Instructor.findByLikeTypeLink", query = "SELECT i FROM Instructor i WHERE i.linkuTol.typeLink LIKE :typeLink")
    ,@NamedQuery(name = "Instructor.findByLikeDocument", query = "SELECT i FROM Instructor i WHERE i.instructorPK.document LIKE :document")

})

public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorPK instructorPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Disponibility> disponibilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Timetable> timetableCollection;
    @JoinColumn(name = "linku_tol", referencedColumnName = "type_link", nullable = false)
    @ManyToOne(optional = false)
    private LinkUp linkuTol;
    @JoinColumns({
        @JoinColumn(name = "number_document", referencedColumnName = "number_document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "speciality_name", referencedColumnName = "name", nullable = false)
    @ManyToOne(optional = false)
    private Speciality specialityName;

    public Instructor() {
    }

    public Instructor(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    public Instructor(int numberDocument, String document) {
        this.instructorPK = new InstructorPK(numberDocument, document);
    }

    public InstructorPK getInstructorPK() {
        return instructorPK;
    }

    public void setInstructorPK(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    @XmlTransient
    public Collection<Disponibility> getDisponibilityCollection() {
        return disponibilityCollection;
    }

    public void setDisponibilityCollection(Collection<Disponibility> disponibilityCollection) {
        this.disponibilityCollection = disponibilityCollection;
    }

    @XmlTransient
    public Collection<Timetable> getTimetableCollection() {
        return timetableCollection;
    }

    public void setTimetableCollection(Collection<Timetable> timetableCollection) {
        this.timetableCollection = timetableCollection;
    }

    public LinkUp getLinkuTol() {
        return linkuTol;
    }

    public void setLinkuTol(LinkUp linkuTol) {
        this.linkuTol = linkuTol;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Speciality getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(Speciality specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorPK != null ? instructorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorPK == null && other.instructorPK != null) || (this.instructorPK != null && !this.instructorPK.equals(other.instructorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Instructor[ instructorPK=" + instructorPK + " ]";
    }

}
