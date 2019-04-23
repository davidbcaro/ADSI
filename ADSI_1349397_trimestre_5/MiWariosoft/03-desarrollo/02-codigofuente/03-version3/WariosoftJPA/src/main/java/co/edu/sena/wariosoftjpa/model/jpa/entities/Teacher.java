/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "teacher")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeacherPK teacherPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Availability> availabilityCollection;
    @JoinColumns({
        @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Client client;
    @JoinColumn(name = "name_Specialty", referencedColumnName = "name_Specialty", nullable = false)
    @ManyToOne(optional = false)
    private Specialty nameSpecialty;
    @JoinColumn(name = "type_Linking", referencedColumnName = "type_Linking", nullable = false)
    @ManyToOne(optional = false)
    private Linking typeLinking;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Schedule> scheduleCollection;

    public Teacher() {
    }

    public Teacher(TeacherPK teacherPK) {
        this.teacherPK = teacherPK;
    }

    public Teacher(String idDocument, String documentNumber) {
        this.teacherPK = new TeacherPK(idDocument, documentNumber);
    }

    public TeacherPK getTeacherPK() {
        return teacherPK;
    }

    public void setTeacherPK(TeacherPK teacherPK) {
        this.teacherPK = teacherPK;
    }

    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Specialty getNameSpecialty() {
        return nameSpecialty;
    }

    public void setNameSpecialty(Specialty nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
    }

    public Linking getTypeLinking() {
        return typeLinking;
    }

    public void setTypeLinking(Linking typeLinking) {
        this.typeLinking = typeLinking;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherPK != null ? teacherPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherPK == null && other.teacherPK != null) || (this.teacherPK != null && !this.teacherPK.equals(other.teacherPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Teacher[ teacherPK=" + teacherPK + " ]";
    }
    
}
