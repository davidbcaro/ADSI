/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory;

import co.edu.sena.chronooftimedao.controlador.dao.ProjectDAO;

/**
 *
 * @author 1349397
 */
public interface ProjectDAOFactory {
    
    public ProjectDAO create();
    
}
