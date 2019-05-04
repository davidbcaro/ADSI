package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectPhaseDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlProjectPhaseDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ProjectPhaseDAOFactory;

public class MysqlProjectPhaseDAOFactory implements ProjectPhaseDAOFactory {

    public ProjectPhaseDAO create(){
        return new MysqlProjectPhaseDAO();

    }
}
