package co.edu.sena.tisdplandao.model.dto.dtopk;

import java.io.Serializable;
import java.util.Objects;

public class CustomerPkDTO implements Serializable {
    private String documentNumber;
    private String document;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
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
        CustomerPkDTO that = (CustomerPkDTO) o;
        return Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documentNumber, document);
    }

    @Override
    public String toString() {
        return "CustomerPkDTO{" +
                "documentNumber='" + documentNumber + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
