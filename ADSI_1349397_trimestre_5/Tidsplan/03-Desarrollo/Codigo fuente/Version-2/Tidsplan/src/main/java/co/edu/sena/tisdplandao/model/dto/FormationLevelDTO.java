package co.edu.sena.tisdplandao.model.dto;

import java.io.Serializable;

public class FormationLevelDTO implements Serializable {

    private String levelformation;
    private boolean status;


    public FormationLevelDTO() {
    }

    public String getLevelformation() {
        return levelformation;
    }

    public void setLevelformation(String levelformation) {
        this.levelformation = levelformation;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FormationLevelDTO{" +
                "levelformation='" + levelformation + '\'' +
                ", status=" + status +
                '}';
    }
}
