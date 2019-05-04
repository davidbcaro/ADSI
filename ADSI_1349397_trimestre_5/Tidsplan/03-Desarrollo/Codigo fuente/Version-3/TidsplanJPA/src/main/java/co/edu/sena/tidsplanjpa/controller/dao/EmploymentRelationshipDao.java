/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.EmploymentRelationship;
import java.util.List;

/**
 *
 * @author MIHOGAR
 * @param <T>
 */
public interface EmploymentRelationshipDao <T extends EmploymentRelationship> extends  InterfaceDao<T>{
    public List<T> findByTypeEmploymentRelationShip(String typeEmploymentRelationShip);
    public List<T> findByLikeTypeEmploymentRelationShip(String typeEmploymentRelationShip);
    public List<T> findByHours(int hours);
    public List<T> findByLikeHours(String hours);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String  newKey, String oldKey);

    
}
