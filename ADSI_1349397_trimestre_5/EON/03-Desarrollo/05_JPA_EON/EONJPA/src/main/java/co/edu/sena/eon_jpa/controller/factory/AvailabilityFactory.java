
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.AvailabilityDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.AvailabilityDaoImpl;


public class AvailabilityFactory {
   
     public static AvailabilityDao create(Class entityClass){
        return new AvailabilityDaoImpl(entityClass);
    } 
    
}
