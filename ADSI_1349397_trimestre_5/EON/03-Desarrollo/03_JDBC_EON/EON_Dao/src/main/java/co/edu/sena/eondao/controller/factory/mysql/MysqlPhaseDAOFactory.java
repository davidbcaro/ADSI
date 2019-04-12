
package co.edu.sena.eondao.controller.factory.mysql;

import co.edu.sena.eondao.controller.dao.PhaseDAO;
import co.edu.sena.eondao.controller.dao.mysql.MysqlPhaseDAO;
import co.edu.sena.eondao.controller.factory.PhaseDAOFactory;





public class MysqlPhaseDAOFactory implements PhaseDAOFactory{
    
     
      public PhaseDAO create(){
        return new MysqlPhaseDAO();
      }
}