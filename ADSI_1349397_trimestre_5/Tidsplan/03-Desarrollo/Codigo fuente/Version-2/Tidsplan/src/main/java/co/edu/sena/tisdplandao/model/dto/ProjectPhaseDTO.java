package co.edu.sena.tisdplandao.model.dto;

import java.util.Objects;

public class ProjectPhaseDTO implements java.io.Serializable {
    private static long serialVersionUID = 43L;

    private String namePhase;
    private boolean status;
    private String projectCode;

    public ProjectPhaseDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ProjectPhaseDTO.serialVersionUID = serialVersionUID;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPhaseDTO that = (ProjectPhaseDTO) o;
        return Objects.equals(projectCode, that.projectCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(projectCode);
    }

    @Override
    public String toString() {
        return "ProjectPhaseDTO{" +
                "namePhase='" + namePhase + '\'' +
                ", status=" + status +
                ", projectCode='" + projectCode + '\'' +
                '}';
    }
}
