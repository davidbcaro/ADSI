/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class TimetablePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name_head", nullable = false, length = 45)
    private String nameHead;
    @Basic(optional = false)
    @Column(name = "num_environment", nullable = false, length = 45)
    private String numEnvironment;
    @Basic(optional = false)
    @Column(name = "number_group", nullable = false)
    private int numberGroup;
    @Basic(optional = false)
    @Column(name = "number_tri", nullable = false)
    private int numberTri;
    @Basic(optional = false)
    @Column(name = "initials_dai", nullable = false, length = 10)
    private String initialsDai;
    @Basic(optional = false)
    @Column(name = "name_dai", nullable = false, length = 10)
    private String nameDai;
    @Basic(optional = false)
    @Column(name = "ide_edition", nullable = false)
    private int ideEdition;
    @Basic(optional = false)
    @Column(name = "number_current", nullable = false, length = 25)
    private String numberCurrent;
    @Basic(optional = false)
    @Column(name = "id_num_document", nullable = false)
    private int idNumDocument;
    @Basic(optional = false)
    @Column(name = "type_document", nullable = false, length = 10)
    private String typeDocument;
    @Basic(optional = false)
    @Column(name = "trim_code", nullable = false, length = 45)
    private String trimCode;

    public TimetablePK() {
    }

    public TimetablePK(String nameHead, String numEnvironment, int numberGroup, int numberTri, String initialsDai, String nameDai, int ideEdition, String numberCurrent, int idNumDocument, String typeDocument, String trimCode) {
        this.nameHead = nameHead;
        this.numEnvironment = numEnvironment;
        this.numberGroup = numberGroup;
        this.numberTri = numberTri;
        this.initialsDai = initialsDai;
        this.nameDai = nameDai;
        this.ideEdition = ideEdition;
        this.numberCurrent = numberCurrent;
        this.idNumDocument = idNumDocument;
        this.typeDocument = typeDocument;
        this.trimCode = trimCode;
    }

    public String getNameHead() {
        return nameHead;
    }

    public void setNameHead(String nameHead) {
        this.nameHead = nameHead;
    }

    public String getNumEnvironment() {
        return numEnvironment;
    }

    public void setNumEnvironment(String numEnvironment) {
        this.numEnvironment = numEnvironment;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public int getNumberTri() {
        return numberTri;
    }

    public void setNumberTri(int numberTri) {
        this.numberTri = numberTri;
    }

    public String getInitialsDai() {
        return initialsDai;
    }

    public void setInitialsDai(String initialsDai) {
        this.initialsDai = initialsDai;
    }

    public String getNameDai() {
        return nameDai;
    }

    public void setNameDai(String nameDai) {
        this.nameDai = nameDai;
    }

    public int getIdeEdition() {
        return ideEdition;
    }

    public void setIdeEdition(int ideEdition) {
        this.ideEdition = ideEdition;
    }

    public String getNumberCurrent() {
        return numberCurrent;
    }

    public void setNumberCurrent(String numberCurrent) {
        this.numberCurrent = numberCurrent;
    }

    public int getIdNumDocument() {
        return idNumDocument;
    }

    public void setIdNumDocument(int idNumDocument) {
        this.idNumDocument = idNumDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTrimCode() {
        return trimCode;
    }

    public void setTrimCode(String trimCode) {
        this.trimCode = trimCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameHead != null ? nameHead.hashCode() : 0);
        hash += (numEnvironment != null ? numEnvironment.hashCode() : 0);
        hash += (int) numberGroup;
        hash += (int) numberTri;
        hash += (initialsDai != null ? initialsDai.hashCode() : 0);
        hash += (nameDai != null ? nameDai.hashCode() : 0);
        hash += (int) ideEdition;
        hash += (numberCurrent != null ? numberCurrent.hashCode() : 0);
        hash += (int) idNumDocument;
        hash += (typeDocument != null ? typeDocument.hashCode() : 0);
        hash += (trimCode != null ? trimCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimetablePK)) {
            return false;
        }
        TimetablePK other = (TimetablePK) object;
        if ((this.nameHead == null && other.nameHead != null) || (this.nameHead != null && !this.nameHead.equals(other.nameHead))) {
            return false;
        }
        if ((this.numEnvironment == null && other.numEnvironment != null) || (this.numEnvironment != null && !this.numEnvironment.equals(other.numEnvironment))) {
            return false;
        }
        if (this.numberGroup != other.numberGroup) {
            return false;
        }
        if (this.numberTri != other.numberTri) {
            return false;
        }
        if ((this.initialsDai == null && other.initialsDai != null) || (this.initialsDai != null && !this.initialsDai.equals(other.initialsDai))) {
            return false;
        }
        if ((this.nameDai == null && other.nameDai != null) || (this.nameDai != null && !this.nameDai.equals(other.nameDai))) {
            return false;
        }
        if (this.ideEdition != other.ideEdition) {
            return false;
        }
        if ((this.numberCurrent == null && other.numberCurrent != null) || (this.numberCurrent != null && !this.numberCurrent.equals(other.numberCurrent))) {
            return false;
        }
        if (this.idNumDocument != other.idNumDocument) {
            return false;
        }
        if ((this.typeDocument == null && other.typeDocument != null) || (this.typeDocument != null && !this.typeDocument.equals(other.typeDocument))) {
            return false;
        }
        if ((this.trimCode == null && other.trimCode != null) || (this.trimCode != null && !this.trimCode.equals(other.trimCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.TimetablePK[ nameHead=" + nameHead + ", numEnvironment=" + numEnvironment + ", numberGroup=" + numberGroup + ", numberTri=" + numberTri + ", initialsDai=" + initialsDai + ", nameDai=" + nameDai + ", ideEdition=" + ideEdition + ", numberCurrent=" + numberCurrent + ", idNumDocument=" + idNumDocument + ", typeDocument=" + typeDocument + ", trimCode=" + trimCode + " ]";
    }
    
}
