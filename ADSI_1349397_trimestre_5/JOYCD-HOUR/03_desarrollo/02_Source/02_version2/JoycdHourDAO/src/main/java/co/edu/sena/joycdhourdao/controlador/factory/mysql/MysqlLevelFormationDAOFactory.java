/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;
import co.edu.sena.joycdhourdao.controlador.dao.LevelFormationDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlLevelFormationDAO;
import co.edu.sena.joycdhourdao.controlador.factory.LevelFormationDAOFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author 1349397
 */
public class MysqlLevelFormationDAOFactory implements LevelFormationDAOFactory {
    @Override
    public LevelFormationDAO create() {
        return new  MysqlLevelFormationDAO();
        
    }
    
}
