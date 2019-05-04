/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Disponibility;
import co.edu.sena.tidsplanjpa.model.jpa.entities.DisponibilityPK;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author JulianC
 */
public interface DisponibilityDao <T extends Disponibility> extends InterfaceDao<T>{
    public List<T> findByStartHour(Time startHour);
    public List<T> findByLikeStartHour(Time startHour);
    public List<T> findByEndHour(Time endHour);
    public List<T> findByLikeEndHour(Time endHour);
    public List<T> findByNameDay(String nameDay);
    public List<T> findByLikeNameDay(String nameDay);
    public List<T> findByWorkindDayInitials(String workingDayInitials);
    public List<T> findByLikeWorkindDayInitials(String workingDayInitials);
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByLikeDocumentNumber(String documentNumber);
    public List<T> findByDocument(String document);
    public List<T> findByLikeDocument(String document);
    public int updatePrimaryKey(DisponibilityPK  newKey, DisponibilityPK oldKey);
}
