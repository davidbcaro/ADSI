package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.SpecialityDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlSpecialityDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.SpecialityDAOFactory;

public class MysqlSpecialityDAOFactory implements SpecialityDAOFactory {
    @Override
    public SpecialityDAO create() {
        return new MysqlSpecialityDAO();
    }
}
