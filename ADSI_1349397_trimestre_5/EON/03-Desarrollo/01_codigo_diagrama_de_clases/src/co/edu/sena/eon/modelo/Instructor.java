/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class Instructor {
    private Client client2;
    private Speciality spe;
    private Bonding bonding;
    private Availability ava;
    private List <Schedule>schedule;

    public Client getClient2() {
        return client2;
    }

    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public Speciality getSpe() {
        return spe;
    }

    public void setSpe(Speciality spe) {
        this.spe = spe;
    }

    public Bonding getBonding() {
        return bonding;
    }

    public void setBonding(Bonding bonding) {
        this.bonding = bonding;
    }
    
    
}
