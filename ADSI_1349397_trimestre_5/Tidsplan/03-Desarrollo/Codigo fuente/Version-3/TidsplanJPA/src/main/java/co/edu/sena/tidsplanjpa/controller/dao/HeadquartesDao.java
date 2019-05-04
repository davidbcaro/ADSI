package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Headquartes;

import java.util.List;

public interface HeadquartesDao<T extends Headquartes> extends InterfaceDao<T> {
    public List<T> findByNameHeadquares(String nameHeadquares);
    public List<T> findByAddress(String address);
    public List<Headquartes> findByStatus(boolean status);
    public List<T> findByLikeNameHeadquares(String nameHeadquares);
    public List<T> findByLikeAddress(String address);
    public int updatePrimaryKey(String newKey, String oldKey);
}
