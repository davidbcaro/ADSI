/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlPhaseProjectDAO;

import co.edu.sena.joycdhourdao.controlador.dao.PhaseProjectDAO;
import co.edu.sena.joycdhourdao.controlador.factory.PhaseProjectDAOFactory;


/**
 *
 * @author SENA
 */
public class MysqlPhaseProjectDAOFactory implements PhaseProjectDAOFactory {
    @Override
    public PhaseProjectDAO create() {
        return new  MysqlPhaseProjectDAO();
    }
}
