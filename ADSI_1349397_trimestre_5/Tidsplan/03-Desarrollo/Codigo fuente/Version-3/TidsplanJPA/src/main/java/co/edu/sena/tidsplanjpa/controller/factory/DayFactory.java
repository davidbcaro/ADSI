/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.DayDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.DayDaoImpl;

/**
 *
 * @author MIHOGAR
 */
public class DayFactory {
      public static DayDao create(Class entityClass){
        return new DayDaoImpl(entityClass);
      }  
}
