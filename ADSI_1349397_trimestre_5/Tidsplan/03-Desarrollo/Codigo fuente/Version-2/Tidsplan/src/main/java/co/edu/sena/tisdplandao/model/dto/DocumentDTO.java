package co.edu.sena.tisdplandao.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class DocumentDTO implements Serializable {
    private String idDocument;
    private String typeDocument;
    private boolean status;

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDTO that = (DocumentDTO) o;
        return Objects.equals(idDocument, that.idDocument) &&
                Objects.equals(typeDocument, that.typeDocument);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDocument, typeDocument);
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "idDocument='" + idDocument + '\'' +
                ", typeDocument='" + typeDocument + '\'' +
                ", status=" + status +
                '}';
    }
}
