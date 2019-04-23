/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;

import java.util.Objects;

/**
 *
 * @author Brayan
 */
public class ClientDTO implements java.io.Serializable {

    private static long serialVersionUID = 43L;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String firstLastname;
    private String secondLastname;
    private String idDocument;
    
    public ClientDTO() {
    } 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ClientDTO.serialVersionUID = serialVersionUID;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNUmber) {
        this.documentNumber = documentNUmber;
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

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.documentNumber);
        hash = 29 * hash + Objects.hashCode(this.idDocument);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientDTO other = (ClientDTO) obj;
        if (!Objects.equals(this.documentNumber, other.documentNumber)) {
            return false;
        }
        if (!Objects.equals(this.idDocument, other.idDocument)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClientDTO{" + "documentNUmber=" + documentNumber + ", firstName=" + firstName + ", secondName=" + secondName + ", firstLastname=" + firstLastname + ", secondLastname=" + secondLastname + ", idDocument=" + idDocument + '}';
    }
    
}
