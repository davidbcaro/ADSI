
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.ProjectDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.ProjectImpl;


public class ProjectFactory {
    public static ProjectDAO create(Class entityClass){
        return new ProjectImpl(entityClass);
    }
}
