/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "useri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useri.findAll", query = "SELECT u FROM Useri u")
    , @NamedQuery(name = "Useri.findByEmail", query = "SELECT u FROM Useri u WHERE u.email = :email")
    , @NamedQuery(name = "Useri.findByPassword", query = "SELECT u FROM Useri u WHERE u.password = :password")
    , @NamedQuery(name = "Useri.findByPersonNumber", query = "SELECT u FROM Useri u WHERE u.useriPK.personNumber = :personNumber")
    , @NamedQuery(name = "Useri.findByDocument", query = "SELECT u FROM Useri u WHERE u.useriPK.document = :document")})
public class Useri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UseriPK useriPK;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "password", length = 15)
    private String password;
    @JoinColumns({
        @JoinColumn(name = "person_number", referencedColumnName = "number_document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Person person;

    public Useri() {
    }

    public Useri(UseriPK useriPK) {
        this.useriPK = useriPK;
    }

    public Useri(int personNumber, String document) {
        this.useriPK = new UseriPK(personNumber, document);
    }

    public UseriPK getUseriPK() {
        return useriPK;
    }

    public void setUseriPK(UseriPK useriPK) {
        this.useriPK = useriPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (useriPK != null ? useriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useri)) {
            return false;
        }
        Useri other = (Useri) object;
        if ((this.useriPK == null && other.useriPK != null) || (this.useriPK != null && !this.useriPK.equals(other.useriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Useri[ useriPK=" + useriPK + " ]";
    }
    
}
