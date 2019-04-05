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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "timetable", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name_head", "num_environment", "number_group", "number_tri", "initials_dai", "trim_code", "name_dai", "ide_edition", "number_current", "id_num_document", "type_document"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t")
    , @NamedQuery(name = "Timetable.findByNameHead", query = "SELECT t FROM Timetable t WHERE t.timetablePK.nameHead = :nameHead")
    , @NamedQuery(name = "Timetable.findByNumEnvironment", query = "SELECT t FROM Timetable t WHERE t.timetablePK.numEnvironment = :numEnvironment")
    , @NamedQuery(name = "Timetable.findByNumberGroup", query = "SELECT t FROM Timetable t WHERE t.timetablePK.numberGroup = :numberGroup")
    , @NamedQuery(name = "Timetable.findByNumberTri", query = "SELECT t FROM Timetable t WHERE t.timetablePK.numberTri = :numberTri")
    , @NamedQuery(name = "Timetable.findByInitialsDai", query = "SELECT t FROM Timetable t WHERE t.timetablePK.initialsDai = :initialsDai")
    , @NamedQuery(name = "Timetable.findByNameDai", query = "SELECT t FROM Timetable t WHERE t.timetablePK.nameDai = :nameDai")
    , @NamedQuery(name = "Timetable.findByIdeEdition", query = "SELECT t FROM Timetable t WHERE t.timetablePK.ideEdition = :ideEdition")
    , @NamedQuery(name = "Timetable.findByNumberCurrent", query = "SELECT t FROM Timetable t WHERE t.timetablePK.numberCurrent = :numberCurrent")
    , @NamedQuery(name = "Timetable.findByIdNumDocument", query = "SELECT t FROM Timetable t WHERE t.timetablePK.idNumDocument = :idNumDocument")
    , @NamedQuery(name = "Timetable.findByTypeDocument", query = "SELECT t FROM Timetable t WHERE t.timetablePK.typeDocument = :typeDocument")
    , @NamedQuery(name = "Timetable.findByStartDate", query = "SELECT t FROM Timetable t WHERE t.startDate = :startDate")
    , @NamedQuery(name = "Timetable.findByEndDate", query = "SELECT t FROM Timetable t WHERE t.endDate = :endDate")
    , @NamedQuery(name = "Timetable.findByTrimCode", query = "SELECT t FROM Timetable t WHERE t.timetablePK.trimCode = :trimCode")})
public class Timetable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimetablePK timetablePK;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "name_dai", referencedColumnName = "name_dayi", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dayi dayi;
    @JoinColumns({
        @JoinColumn(name = "ide_edition", referencedColumnName = "ide_edition", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "number_current", referencedColumnName = "id_trimester", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Edition edition;
    @JoinColumns({
        @JoinColumn(name = "name_head", referencedColumnName = "name_head", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "num_environment", referencedColumnName = "num_environment", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Headquaters headquaters;
    @JoinColumns({
        @JoinColumn(name = "id_num_document", referencedColumnName = "number_document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "type_document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "name_modality", referencedColumnName = "name_modality", nullable = false)
    @ManyToOne(optional = false)
    private Modality nameModality;
    @JoinColumns({
        @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "number_tri", referencedColumnName = "number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "initials_dai", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "trim_code", referencedColumnName = "tri_code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private NumberGroupHasTrimester numberGroupHasTrimester;

    public Timetable() {
    }

    public Timetable(TimetablePK timetablePK) {
        this.timetablePK = timetablePK;
    }

    public Timetable(String nameHead, String numEnvironment, int numberGroup, int numberTri, String initialsDai, String nameDai, int ideEdition, String numberCurrent, int idNumDocument, String typeDocument, String trimCode) {
        this.timetablePK = new TimetablePK(nameHead, numEnvironment, numberGroup, numberTri, initialsDai, nameDai, ideEdition, numberCurrent, idNumDocument, typeDocument, trimCode);
    }

    public TimetablePK getTimetablePK() {
        return timetablePK;
    }

    public void setTimetablePK(TimetablePK timetablePK) {
        this.timetablePK = timetablePK;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Headquaters getHeadquaters() {
        return headquaters;
    }

    public void setHeadquaters(Headquaters headquaters) {
        this.headquaters = headquaters;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Modality getNameModality() {
        return nameModality;
    }

    public void setNameModality(Modality nameModality) {
        this.nameModality = nameModality;
    }

    public NumberGroupHasTrimester getNumberGroupHasTrimester() {
        return numberGroupHasTrimester;
    }

    public void setNumberGroupHasTrimester(NumberGroupHasTrimester numberGroupHasTrimester) {
        this.numberGroupHasTrimester = numberGroupHasTrimester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timetablePK != null ? timetablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timetable)) {
            return false;
        }
        Timetable other = (Timetable) object;
        if ((this.timetablePK == null && other.timetablePK != null) || (this.timetablePK != null && !this.timetablePK.equals(other.timetablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Timetable[ timetablePK=" + timetablePK + " ]";
    }
    
}
