package co.edu.sena.tisdplandao.model.dto;

import java.util.Objects;

public class RoleDTO {
    private String idRol;
    private String description;
    private boolean status;

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoleDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(idRol, roleDTO.idRol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRol);

    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "idRol='" + idRol + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
