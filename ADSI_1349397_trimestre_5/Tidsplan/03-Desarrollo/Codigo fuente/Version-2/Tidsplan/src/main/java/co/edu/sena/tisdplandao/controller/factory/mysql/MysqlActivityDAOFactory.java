package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ActivityDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlActivityDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ActivityDAOFactory;

public class MysqlActivityDAOFactory implements ActivityDAOFactory {

    public ActivityDAO create(){
        return new MysqlActivityDAO();

    }
}
