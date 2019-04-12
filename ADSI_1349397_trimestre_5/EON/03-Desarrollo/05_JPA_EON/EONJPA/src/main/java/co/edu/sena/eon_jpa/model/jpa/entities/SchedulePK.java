/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document_Number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "id_Document", nullable = false, length = 10)
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "name_Day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @Column(name = "number_Ambience", nullable = false, length = 20)
    private String numberAmbience;
    @Basic(optional = false)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;
    @Basic(optional = false)
    @Column(name = "number_Ficha", nullable = false, length = 60)
    private String numberFicha;
    @Basic(optional = false)
    @Column(name = "quarter_Name", nullable = false, length = 20)
    private String quarterName;
    @Basic(optional = false)
    @Column(name = "acronyms_Working_Day", nullable = false, length = 20)
    private String acronymsWorkingDay;
    @Basic(optional = false)
    @Column(name = "speciality_Name", nullable = false, length = 100)
    private String specialityName;
    @Basic(optional = false)
    @Column(name = "idVersion", nullable = false)
    private int idVersion;
    @Basic(optional = false)
    @Column(name = "idCurrent_Quarter", nullable = false, length = 10)
    private String idCurrentQuarter;

    public SchedulePK() {
    }

    public SchedulePK(String documentNumber, String idDocument, String nameDay, String numberAmbience, String nameHeadquarters, String numberFicha, String quarterName, String acronymsWorkingDay, String specialityName, int idVersion, String idCurrentQuarter) {
        this.documentNumber = documentNumber;
        this.idDocument = idDocument;
        this.nameDay = nameDay;
        this.numberAmbience = numberAmbience;
        this.nameHeadquarters = nameHeadquarters;
        this.numberFicha = numberFicha;
        this.quarterName = quarterName;
        this.acronymsWorkingDay = acronymsWorkingDay;
        this.specialityName = specialityName;
        this.idVersion = idVersion;
        this.idCurrentQuarter = idCurrentQuarter;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getNumberAmbience() {
        return numberAmbience;
    }

    public void setNumberAmbience(String numberAmbience) {
        this.numberAmbience = numberAmbience;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getNumberFicha() {
        return numberFicha;
    }

    public void setNumberFicha(String numberFicha) {
        this.numberFicha = numberFicha;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public String getAcronymsWorkingDay() {
        return acronymsWorkingDay;
    }

    public void setAcronymsWorkingDay(String acronymsWorkingDay) {
        this.acronymsWorkingDay = acronymsWorkingDay;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getIdCurrentQuarter() {
        return idCurrentQuarter;
    }

    public void setIdCurrentQuarter(String idCurrentQuarter) {
        this.idCurrentQuarter = idCurrentQuarter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (numberAmbience != null ? numberAmbience.hashCode() : 0);
        hash += (nameHeadquarters != null ? nameHeadquarters.hashCode() : 0);
        hash += (numberFicha != null ? numberFicha.hashCode() : 0);
        hash += (quarterName != null ? quarterName.hashCode() : 0);
        hash += (acronymsWorkingDay != null ? acronymsWorkingDay.hashCode() : 0);
        hash += (specialityName != null ? specialityName.hashCode() : 0);
        hash += (int) idVersion;
        hash += (idCurrentQuarter != null ? idCurrentQuarter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        if ((this.numberAmbience == null && other.numberAmbience != null) || (this.numberAmbience != null && !this.numberAmbience.equals(other.numberAmbience))) {
            return false;
        }
        if ((this.nameHeadquarters == null && other.nameHeadquarters != null) || (this.nameHeadquarters != null && !this.nameHeadquarters.equals(other.nameHeadquarters))) {
            return false;
        }
        if ((this.numberFicha == null && other.numberFicha != null) || (this.numberFicha != null && !this.numberFicha.equals(other.numberFicha))) {
            return false;
        }
        if ((this.quarterName == null && other.quarterName != null) || (this.quarterName != null && !this.quarterName.equals(other.quarterName))) {
            return false;
        }
        if ((this.acronymsWorkingDay == null && other.acronymsWorkingDay != null) || (this.acronymsWorkingDay != null && !this.acronymsWorkingDay.equals(other.acronymsWorkingDay))) {
            return false;
        }
        if ((this.specialityName == null && other.specialityName != null) || (this.specialityName != null && !this.specialityName.equals(other.specialityName))) {
            return false;
        }
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if ((this.idCurrentQuarter == null && other.idCurrentQuarter != null) || (this.idCurrentQuarter != null && !this.idCurrentQuarter.equals(other.idCurrentQuarter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.SchedulePK[ documentNumber=" + documentNumber + ", idDocument=" + idDocument + ", nameDay=" + nameDay + ", numberAmbience=" + numberAmbience + ", nameHeadquarters=" + nameHeadquarters + ", numberFicha=" + numberFicha + ", quarterName=" + quarterName + ", acronymsWorkingDay=" + acronymsWorkingDay + ", specialityName=" + specialityName + ", idVersion=" + idVersion + ", idCurrentQuarter=" + idCurrentQuarter + " ]";
    }
    
}
