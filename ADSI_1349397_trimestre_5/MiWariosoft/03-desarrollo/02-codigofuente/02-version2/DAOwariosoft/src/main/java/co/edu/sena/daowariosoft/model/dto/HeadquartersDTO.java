/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;

import java.util.Objects;

/**
 *
 * @author WINDOWS 8
 */
public class HeadquartersDTO implements java.io.Serializable{
   private String NameHeadquarters;
   private String address;
   private boolean state;

    public String getNameHeadquarters() {
        return NameHeadquarters;
    }

    public void setNameHeadquarters(String NameHeadquarters) {
        this.NameHeadquarters = NameHeadquarters;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.NameHeadquarters);
        hash = 89 * hash + Objects.hashCode(this.address);
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
        final HeadquartersDTO other = (HeadquartersDTO) obj;
        if (!Objects.equals(this.NameHeadquarters, other.NameHeadquarters)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HeadquartersDTO{" + "NameHeadquarters=" + NameHeadquarters + ", address=" + address + ", state=" + state + '}';
    }

  
      
}
