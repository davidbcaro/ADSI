/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "disponibility")
@NamedQueries({
    @NamedQuery(name = "Disponibility.findAll", query = "SELECT d FROM Disponibility d")
    , @NamedQuery(name = "Disponibility.findByStartDate", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.startDate = :startDate")
    , @NamedQuery(name = "Disponibility.findByEndDate", query = "SELECT d FROM Disponibility d WHERE d.endDate = :endDate")
    , @NamedQuery(name = "Disponibility.findByNumberDocument", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.numberDocument = :numberDocument")
    , @NamedQuery(name = "Disponibility.findByDocument", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.document = :document")
    , @NamedQuery(name = "Disponibility.findByWorkInitials", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.workInitials = :workInitials")
    , @NamedQuery(name = "Disponibility.findByNameDayi", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.nameDayi = :nameDayi")
    
    , @NamedQuery(name = "Disponibility.updatePK", query = "UPDATE Disponibility d SET d.disponibilityPK.document = :DocumentNew, d.disponibilityPK.nameDayi = :NameDayiNew, d.disponibilityPK.numberDocument = :NumberDocumentNew, d.disponibilityPK.startDate = :StartDateNew, d.disponibilityPK.workInitials = :WorkInitialsNew WHERE d.disponibilityPK.document = :DocumentOld AND d.disponibilityPK.nameDayi = :NameDayiOld AND d.disponibilityPK.numberDocument = :NumberDocumentOld AND d.disponibilityPK.startDate = :StartDateOld AND d.disponibilityPK.workInitials = :WorkInitialsOld")    
    , @NamedQuery(name = "Disponibility.findByLikeDocument", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.document LIKE  :document")
    , @NamedQuery(name = "Disponibilityt.findByLikeWorkDInitiasl", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.workInitials LIKE  :workInitials")
    , @NamedQuery(name = "Disponibility.findByLikeNameDayi", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.nameDayi LIKE  :nameDayi")

})
public class Disponibility implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisponibilityPK disponibilityPK;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "name_dayi", referencedColumnName = "name_dayi", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dayi dayi;
    @JoinColumns({
        @JoinColumn(name = "number_document", referencedColumnName = "number_document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "work_initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Disponibility() {
    }

    public Disponibility(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Disponibility(Date startDate, int numberDocument, String document, String workInitials, String nameDayi) {
        this.disponibilityPK = new DisponibilityPK(startDate, numberDocument, document, workInitials, nameDayi);
    }

    public DisponibilityPK getDisponibilityPK() {
        return disponibilityPK;
    }

    public void setDisponibilityPK(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Dayi getDayi() {
        return dayi;
    }

    public void setDayi(Dayi dayi) {
        this.dayi = dayi;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disponibilityPK != null ? disponibilityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibility)) {
            return false;
        }
        Disponibility other = (Disponibility) object;
        if ((this.disponibilityPK == null && other.disponibilityPK != null) || (this.disponibilityPK != null && !this.disponibilityPK.equals(other.disponibilityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Disponibility[ disponibilityPK=" + disponibilityPK + " ]";
    }

}
