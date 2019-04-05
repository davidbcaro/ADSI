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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Embeddable
public class DisponibilityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "number_document", nullable = false)
    private int numberDocument;
    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "work_initials", nullable = false, length = 10)
    private String workInitials;
    @Basic(optional = false)
    @Column(name = "name_dayi", nullable = false, length = 10)
    private String nameDayi;

    public DisponibilityPK() {
    }

    public DisponibilityPK(Date startDate, int numberDocument, String document, String workInitials, String nameDayi) {
        this.startDate = startDate;
        this.numberDocument = numberDocument;
        this.document = document;
        this.workInitials = workInitials;
        this.nameDayi = nameDayi;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(int numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getWorkInitials() {
        return workInitials;
    }

    public void setWorkInitials(String workInitials) {
        this.workInitials = workInitials;
    }

    public String getNameDayi() {
        return nameDayi;
    }

    public void setNameDayi(String nameDayi) {
        this.nameDayi = nameDayi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (startDate != null ? startDate.hashCode() : 0);
        hash += (int) numberDocument;
        hash += (document != null ? document.hashCode() : 0);
        hash += (workInitials != null ? workInitials.hashCode() : 0);
        hash += (nameDayi != null ? nameDayi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilityPK)) {
            return false;
        }
        DisponibilityPK other = (DisponibilityPK) object;
        if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
            return false;
        }
        if (this.numberDocument != other.numberDocument) {
            return false;
        }
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        if ((this.workInitials == null && other.workInitials != null) || (this.workInitials != null && !this.workInitials.equals(other.workInitials))) {
            return false;
        }
        if ((this.nameDayi == null && other.nameDayi != null) || (this.nameDayi != null && !this.nameDayi.equals(other.nameDayi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.DisponibilityPK[ startDate=" + startDate + ", numberDocument=" + numberDocument + ", document=" + document + ", workInitials=" + workInitials + ", nameDayi=" + nameDayi + " ]";
    }
    
}
