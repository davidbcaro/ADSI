package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.HeadquartesDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.HeadquartesDaoImpl;

public class HeadquartesFactoy {
    public static HeadquartesDao create(Class entityClass){
        return new HeadquartesDaoImpl(entityClass);
    }

}
