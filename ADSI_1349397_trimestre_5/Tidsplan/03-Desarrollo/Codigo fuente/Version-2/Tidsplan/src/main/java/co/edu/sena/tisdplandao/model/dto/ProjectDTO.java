package co.edu.sena.tisdplandao.model.dto;

import java.util.Objects;

public class ProjectDTO implements java.io.Serializable {
    private static long serialVersionUID = 43L;

    private String code;
    private String name;
    private boolean status;

    public ProjectDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ProjectDTO.serialVersionUID = serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        ProjectDTO that = (ProjectDTO) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
