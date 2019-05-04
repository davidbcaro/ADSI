package co.edu.sena.tisdplandao.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class CustomerDTO implements Serializable{
    private String documentNumber;
    private String firtsName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private byte[] photo;
    private String document;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documentNumber, document);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "documentNumber='" + documentNumber + '\'' +
                ", firtsName='" + firtsName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", document='" + document + '\'' +
                '}';
    }
}
