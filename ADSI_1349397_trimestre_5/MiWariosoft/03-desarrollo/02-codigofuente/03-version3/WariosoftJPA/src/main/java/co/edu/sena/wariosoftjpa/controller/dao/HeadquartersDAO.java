/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Headquarters;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface HeadquartersDAO<T extends Headquarters> extends InterfaceDAO<T> {

    public List<T> findByHeadquarters(String headquarters);
    public List<T> findByAddress(String address);
    public List<T> findByState(boolean state);
    public List<T> findByLikeHeadquarters(String headquarters);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
