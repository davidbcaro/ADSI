package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.RoleDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlRoleDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.RoleDAOFactory;

public class MysqlRoleDAOFactory implements RoleDAOFactory {
    @Override
    public RoleDAO create() {
        return new MysqlRoleDAO();
    }
}
