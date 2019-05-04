/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.User;
import co.edu.sena.tidsplanjpa.model.jpa.entities.UserPK;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MIHOGAR
 * @param <T>
 */
public interface UserDao <T extends User> extends InterfaceDao<T>{
    public List<T> findByMail(String mail);
    public List<T> findByLikeMail(String mail);
    public List<T> findByPassword(String password);
    public List<T> findByLikePassword(String password);
    public List<T> findByEndDate(Date endDate);
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByLikeDocumentNumber(String documentNumber);
    public List<T> findByDocument(String document);
    public List<T> findByLikeDocument(String document);
    public int updatePrimaryKey(UserPK newKey, UserPK oldKey);
}
