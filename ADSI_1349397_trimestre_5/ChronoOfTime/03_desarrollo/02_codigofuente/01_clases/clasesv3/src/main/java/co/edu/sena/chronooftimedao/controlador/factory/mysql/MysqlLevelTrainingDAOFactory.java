/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlLevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.dao.LevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.factory.LevelTrainingDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlLevelTrainingDAOFactory implements LevelTrainingDAOFactory {

    @Override
    public LevelTrainingDAO create() {
        return new MysqlLevelTrainingDAO();
    }
}
