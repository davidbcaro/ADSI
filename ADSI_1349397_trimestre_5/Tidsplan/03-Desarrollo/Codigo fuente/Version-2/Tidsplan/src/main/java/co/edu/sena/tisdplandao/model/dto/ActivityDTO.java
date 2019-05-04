package co.edu.sena.tisdplandao.model.dto;

import java.io.Serializable;

public class ActivityDTO implements Serializable {

    private String idActivity;
    private String name;
    private String namePhase;
    private String projectCode;

    public ActivityDTO() {
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return "ActivityDTO{" +
                "idActivity='" + idActivity + '\'' +
                ", name='" + name + '\'' +
                ", namePhase='" + namePhase + '\'' +
                ", projectCode='" + projectCode + '\'' +
                '}';
    }
}
