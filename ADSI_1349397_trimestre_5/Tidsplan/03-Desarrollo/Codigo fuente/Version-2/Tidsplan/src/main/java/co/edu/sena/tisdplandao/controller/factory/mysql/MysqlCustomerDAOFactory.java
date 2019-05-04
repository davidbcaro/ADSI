package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.CustomerDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlCustomerDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.CustomerDAOFactory;

public class MysqlCustomerDAOFactory implements CustomerDAOFactory {
    @Override
    public CustomerDAO create() {
        return new MysqlCustomerDAO();
    }
}
