/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Bonding;
import java.util.List;

/**
 *
 * @author Liliana Narvaez
 * @param <T>
 */
public interface BondingDao<T extends Bonding> extends InterfaceDao<T> {

    public List<T> findBytypeLinkage(String typeLinkage);
    public List<T> findByHours(int Hours);
    public List<T> findByStatus(boolean Status);
    public int updatePrimaryKey(String specialityNuevo, String specialityViejo);   
    public List<T> findByLiketypeLinkage(String typeLinkage);
}
