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
public class ClientPkDTO {
    private static long serialVersionUID = 43L;
    
    
    private String documentNumber;
    private String idDocument;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ClientPkDTO.serialVersionUID = serialVersionUID;
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
        final ClientPkDTO other = (ClientPkDTO) obj;
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
        return "ClientPkDTO{" + "documentNumber=" + documentNumber + ", idDocument=" + idDocument + '}';
    }
    
}
