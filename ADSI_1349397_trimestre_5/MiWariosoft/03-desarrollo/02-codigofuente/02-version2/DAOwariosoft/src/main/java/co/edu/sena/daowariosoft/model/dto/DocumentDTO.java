/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class DocumentDTO implements java.io.Serializable {
    
    private static long serialVersionUID = 43L;

    private String idDocument;
    private String name;
    private boolean state;
    
    public DocumentDTO(){
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        DocumentDTO.serialVersionUID = serialVersionUID;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
        if (!Objects.equals(this.idDocument, other.idDocument)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" + "idDocument=" + idDocument + ", name=" + name + ", state=" + state + '}';
    }
    
    
    
}
