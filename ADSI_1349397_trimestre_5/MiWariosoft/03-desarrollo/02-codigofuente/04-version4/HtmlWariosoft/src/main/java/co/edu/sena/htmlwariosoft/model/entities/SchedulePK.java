/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 1349397
 */
@Embeddable
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_Trimester", nullable = false, length = 20)
    private String nameTrimester;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "number_Group", nullable = false, length = 100)
    private String numberGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "initials_Working_Day", nullable = false, length = 10)
    private String initialsWorkingDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "document_Number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_Document", nullable = false, length = 10)
    private String idDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "name_Day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "number_Environment", nullable = false, length = 100)
    private String numberEnvironment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Version", nullable = false)
    private int idVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_Current_Quarter", nullable = false, length = 20)
    private String idCurrentQuarter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "training_Level", nullable = false, length = 20)
    private String trainingLevel;

    public SchedulePK() {
    }

    public SchedulePK(String nameTrimester, String numberGroup, String initialsWorkingDay, String documentNumber, String idDocument, String nameDay, String numberEnvironment, String nameHeadquarters, int idVersion, String idCurrentQuarter, String trainingLevel) {
        this.nameTrimester = nameTrimester;
        this.numberGroup = numberGroup;
        this.initialsWorkingDay = initialsWorkingDay;
        this.documentNumber = documentNumber;
        this.idDocument = idDocument;
        this.nameDay = nameDay;
        this.numberEnvironment = numberEnvironment;
        this.nameHeadquarters = nameHeadquarters;
        this.idVersion = idVersion;
        this.idCurrentQuarter = idCurrentQuarter;
        this.trainingLevel = trainingLevel;
    }

    public String getNameTrimester() {
        return nameTrimester;
    }

    public void setNameTrimester(String nameTrimester) {
        this.nameTrimester = nameTrimester;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getInitialsWorkingDay() {
        return initialsWorkingDay;
    }

    public void setInitialsWorkingDay(String initialsWorkingDay) {
        this.initialsWorkingDay = initialsWorkingDay;
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

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
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

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameTrimester != null ? nameTrimester.hashCode() : 0);
        hash += (numberGroup != null ? numberGroup.hashCode() : 0);
        hash += (initialsWorkingDay != null ? initialsWorkingDay.hashCode() : 0);
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (nameHeadquarters != null ? nameHeadquarters.hashCode() : 0);
        hash += (int) idVersion;
        hash += (idCurrentQuarter != null ? idCurrentQuarter.hashCode() : 0);
        hash += (trainingLevel != null ? trainingLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if ((this.nameTrimester == null && other.nameTrimester != null) || (this.nameTrimester != null && !this.nameTrimester.equals(other.nameTrimester))) {
            return false;
        }
        if ((this.numberGroup == null && other.numberGroup != null) || (this.numberGroup != null && !this.numberGroup.equals(other.numberGroup))) {
            return false;
        }
        if ((this.initialsWorkingDay == null && other.initialsWorkingDay != null) || (this.initialsWorkingDay != null && !this.initialsWorkingDay.equals(other.initialsWorkingDay))) {
            return false;
        }
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        if ((this.numberEnvironment == null && other.numberEnvironment != null) || (this.numberEnvironment != null && !this.numberEnvironment.equals(other.numberEnvironment))) {
            return false;
        }
        if ((this.nameHeadquarters == null && other.nameHeadquarters != null) || (this.nameHeadquarters != null && !this.nameHeadquarters.equals(other.nameHeadquarters))) {
            return false;
        }
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if ((this.idCurrentQuarter == null && other.idCurrentQuarter != null) || (this.idCurrentQuarter != null && !this.idCurrentQuarter.equals(other.idCurrentQuarter))) {
            return false;
        }
        if ((this.trainingLevel == null && other.trainingLevel != null) || (this.trainingLevel != null && !this.trainingLevel.equals(other.trainingLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.SchedulePK[ nameTrimester=" + nameTrimester + ", numberGroup=" + numberGroup + ", initialsWorkingDay=" + initialsWorkingDay + ", documentNumber=" + documentNumber + ", idDocument=" + idDocument + ", nameDay=" + nameDay + ", numberEnvironment=" + numberEnvironment + ", nameHeadquarters=" + nameHeadquarters + ", idVersion=" + idVersion + ", idCurrentQuarter=" + idCurrentQuarter + ", trainingLevel=" + trainingLevel + " ]";
    }
    
}
