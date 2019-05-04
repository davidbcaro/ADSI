package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlProjectDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ProjectDAOFactory;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectDAO;

public class MysqlProjectDAOFactory implements ProjectDAOFactory {

    public ProjectDAO create(){
        return new MysqlProjectDAO();

    }
}
