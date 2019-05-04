package co.edu.sena.tisdplandao.controller.factory.mysql;


import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.FormationLevelDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlFormationLevelDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.FormationLevelDAOFactory;

public class MysqlFormationLevelDAOFactory implements FormationLevelDAOFactory {

    public FormationLevelDAO create(){
        return new MysqlFormationLevelDAO();

    }
}
