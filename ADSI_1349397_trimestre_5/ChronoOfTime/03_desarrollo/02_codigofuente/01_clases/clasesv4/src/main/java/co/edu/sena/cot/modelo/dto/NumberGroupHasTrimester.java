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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "number_group_has_trimester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumberGroupHasTrimester.findAll", query = "SELECT n FROM NumberGroupHasTrimester n")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByNumberGroup", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.numberGroup = :numberGroup")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByNumber", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.number = :number")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByInitials", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.initials = :initials")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByTriCode", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.triCode = :triCode")})
public class NumberGroupHasTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumberGroupHasTrimesterPK numberGroupHasTrimesterPK;
    @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NumberGroup numberGroup1;
    @JoinColumns({
        @JoinColumn(name = "number", referencedColumnName = "number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "tri_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trimester trimester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numberGroupHasTrimester")
    private Collection<Timetable> timetableCollection;

    public NumberGroupHasTrimester() {
    }

    public NumberGroupHasTrimester(NumberGroupHasTrimesterPK numberGroupHasTrimesterPK) {
        this.numberGroupHasTrimesterPK = numberGroupHasTrimesterPK;
    }

    public NumberGroupHasTrimester(int numberGroup, int number, String initials, String triCode) {
        this.numberGroupHasTrimesterPK = new NumberGroupHasTrimesterPK(numberGroup, number, initials, triCode);
    }

    public NumberGroupHasTrimesterPK getNumberGroupHasTrimesterPK() {
        return numberGroupHasTrimesterPK;
    }

    public void setNumberGroupHasTrimesterPK(NumberGroupHasTrimesterPK numberGroupHasTrimesterPK) {
        this.numberGroupHasTrimesterPK = numberGroupHasTrimesterPK;
    }

    public NumberGroup getNumberGroup1() {
        return numberGroup1;
    }

    public void setNumberGroup1(NumberGroup numberGroup1) {
        this.numberGroup1 = numberGroup1;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
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
        hash += (numberGroupHasTrimesterPK != null ? numberGroupHasTrimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberGroupHasTrimester)) {
            return false;
        }
        NumberGroupHasTrimester other = (NumberGroupHasTrimester) object;
        if ((this.numberGroupHasTrimesterPK == null && other.numberGroupHasTrimesterPK != null) || (this.numberGroupHasTrimesterPK != null && !this.numberGroupHasTrimesterPK.equals(other.numberGroupHasTrimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.NumberGroupHasTrimester[ numberGroupHasTrimesterPK=" + numberGroupHasTrimesterPK + " ]";
    }
    
}
