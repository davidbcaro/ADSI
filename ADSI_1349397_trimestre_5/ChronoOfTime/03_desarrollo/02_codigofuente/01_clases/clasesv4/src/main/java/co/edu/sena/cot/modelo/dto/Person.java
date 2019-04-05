/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByNumberDocument", query = "SELECT p FROM Person p WHERE p.personPK.numberDocument = :numberDocument")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findBySecondName", query = "SELECT p FROM Person p WHERE p.secondName = :secondName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findBySecondLname", query = "SELECT p FROM Person p WHERE p.secondLname = :secondLname")
    , @NamedQuery(name = "Person.findByDocument", query = "SELECT p FROM Person p WHERE p.personPK.document = :document")})
public class Person implements Serializable {

    @Basic(optional = false)
    @Lob
    @Column(name = "photo", nullable = false)
    private byte[] photo;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPK personPK;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "second_name", length = 100)
    private String secondName;
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "second_lname", length = 100)
    private String secondLname;
    @JoinTable(name = "person_has_rol", joinColumns = {
        @JoinColumn(name = "person_number_document", referencedColumnName = "number_document", nullable = false)
        , @JoinColumn(name = "person_id_docuemnt", referencedColumnName = "document", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)})
    @ManyToMany
    private Collection<Rol> rolCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Useri useri;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Instructor instructor;
    @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document1;

    public Person() {
    }

    public Person(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Person(PersonPK personPK, String firstName, String lastName, byte[] photo) {
        this.personPK = personPK;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public Person(int numberDocument, String document) {
        this.personPK = new PersonPK(numberDocument, document);
    }

    public PersonPK getPersonPK() {
        return personPK;
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLname() {
        return secondLname;
    }

    public void setSecondLname(String secondLname) {
        this.secondLname = secondLname;
    }


    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public Useri getUseri() {
        return useri;
    }

    public void setUseri(Useri useri) {
        this.useri = useri;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Document getDocument1() {
        return document1;
    }

    public void setDocument1(Document document1) {
        this.document1 = document1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPK != null ? personPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personPK == null && other.personPK != null) || (this.personPK != null && !this.personPK.equals(other.personPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Person[ personPK=" + personPK + " ]";
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
}
