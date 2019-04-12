/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author LUISBERNARDO
 */
public class TrainingLevelDTO {
    public String training_Level;
    public boolean State;

    public TrainingLevelDTO() {
    }

    public String getTraining_Level() {
        return training_Level;
    }

    public void setTraining_Level(String training_Level) {
        this.training_Level = training_Level;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.training_Level);
        hash = 31 * hash + (this.State ? 1 : 0);
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
        final TrainingLevelDTO other = (TrainingLevelDTO) obj;
        if (this.State != other.State) {
            return false;
        }
        if (!Objects.equals(this.training_Level, other.training_Level)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Training_LevelDTO{" + "training_Level=" + training_Level + ", State=" + State + '}';
    }

    
}