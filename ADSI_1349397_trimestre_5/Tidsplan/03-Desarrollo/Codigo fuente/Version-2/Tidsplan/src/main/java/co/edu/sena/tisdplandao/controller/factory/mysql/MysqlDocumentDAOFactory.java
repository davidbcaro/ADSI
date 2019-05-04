package co.edu.sena.tisdplandao.controller.factory.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.DocumentDAO;
import co.edu.sena.tisdplandao.controller.dao.mysql.MysqlDocumentDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.DocumentDAOFactory;

public class MysqlDocumentDAOFactory implements DocumentDAOFactory {
    public DocumentDAO create() {
        return new MysqlDocumentDAO();
    }
}
