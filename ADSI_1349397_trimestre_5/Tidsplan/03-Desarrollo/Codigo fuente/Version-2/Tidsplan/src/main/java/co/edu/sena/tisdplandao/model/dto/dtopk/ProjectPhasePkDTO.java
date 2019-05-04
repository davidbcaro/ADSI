package co.edu.sena.tisdplandao.model.dto.dtopk;

import java.io.Serializable;
import java.util.Objects;

public class ProjectPhasePkDTO implements Serializable {

    private static long serialVersionUID = 43L;

    private String namePhase;
    private String projectCode;

    public ProjectPhasePkDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ProjectPhasePkDTO.serialVersionUID = serialVersionUID;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
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
        ProjectPhasePkDTO that = (ProjectPhasePkDTO) o;
        return Objects.equals(projectCode, that.projectCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(projectCode);
    }

    @Override
    public String toString() {
        return "ProjectPhasePkDTO{" +
                "namePhase='" + namePhase + '\'' +
                ", projectCode='" + projectCode + '\'' +
                '}';
    }
}
