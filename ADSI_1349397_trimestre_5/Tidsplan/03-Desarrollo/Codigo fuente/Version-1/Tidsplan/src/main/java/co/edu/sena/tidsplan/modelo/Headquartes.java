/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Headquartes {
    private String nameHeadquartes;
    private String adrees;
    private boolean status;
    private List<Enviroment> enviroments;

    public String getNameHeadquartes() {
        return nameHeadquartes;
    }

    public void setNameHeadquartes(String nameHeadquartes) {
        this.nameHeadquartes = nameHeadquartes;
    }

    public String getAdrees() {
        return adrees;
    }

    public void setAdrees(String adrees) {
        this.adrees = adrees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Enviroment> getEnviroments() {
        return enviroments;
    }

    public void setEnviroments(List<Enviroment> enviroments) {
        this.enviroments = enviroments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nameHeadquartes);
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
        final Headquartes other = (Headquartes) obj;
        if (!Objects.equals(this.nameHeadquartes, other.nameHeadquartes)) {
            return false;
        }
        return true;
    }
    
    
}
