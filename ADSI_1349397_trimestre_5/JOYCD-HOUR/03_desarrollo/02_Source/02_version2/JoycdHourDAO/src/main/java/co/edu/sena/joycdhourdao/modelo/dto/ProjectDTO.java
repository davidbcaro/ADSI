/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class ProjectDTO implements java.io.Serializable {

    private static long serialVersionUID = 43L;
    private String codeproject;
    private String nameproject;
    private boolean statusproject;

    public boolean isStatusproject() {
        return statusproject;
    }

    public void setStatusproject(boolean statusproject) {
        this.statusproject = statusproject;
    }

    public ProjectDTO() {
    }

    public String getCodeproject() {
        return codeproject;
    }

    public void setCodeproject(String code_project) {
        this.codeproject = code_project;
    }

    public String getNameproject() {
        return nameproject;
    }

    public void setNameproject(String name_project) {
        this.nameproject = name_project;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.codeproject);
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
        final ProjectDTO other = (ProjectDTO) obj;
        if (!Objects.equals(this.codeproject, other.codeproject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" + "code_project=" + codeproject + ", name_project=" + nameproject + ", status_project=" + statusproject + '}';
    }
    

}
