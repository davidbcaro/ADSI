/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class DocumentDTO {
    private String idDocumento;
    private String Name;
    private boolean Status;

    public DocumentDTO() {
    }
    

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idDocumento);
        hash = 89 * hash + Objects.hashCode(this.Name);
        hash = 89 * hash + (this.Status ? 1 : 0);
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
        final DocumentDTO other = (DocumentDTO) obj;
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.idDocumento, other.idDocumento)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" + "idDocumento=" + idDocumento + ", Name=" + Name + ", Status=" + Status + '}';
    }

    
    
    
    
}
