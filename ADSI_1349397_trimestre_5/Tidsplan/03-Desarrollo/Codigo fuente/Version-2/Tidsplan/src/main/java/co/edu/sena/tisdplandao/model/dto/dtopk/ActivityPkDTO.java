package co.edu.sena.tisdplandao.model.dto.dtopk;

import java.io.Serializable;
import java.util.Objects;

public class ActivityPkDTO implements Serializable {

    private static long serialVersionUID = 43L;

    private String idActivity;
    private String namePhase;
    private String projectCode;

    public ActivityPkDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ActivityPkDTO.serialVersionUID = serialVersionUID;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
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
        return "ActivityPkDTO{" +
                "idActivity='" + idActivity + '\'' +
                ", namePhase='" + namePhase + '\'' +
                ", projectCode='" + projectCode + '\'' +
                '}';
    }
}
