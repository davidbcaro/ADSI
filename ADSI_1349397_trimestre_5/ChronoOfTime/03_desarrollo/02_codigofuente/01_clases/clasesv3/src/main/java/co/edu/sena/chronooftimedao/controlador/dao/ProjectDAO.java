/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao;

import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface ProjectDAO {
    
    public int insert(ProjectDTO project);
    public int update(ProjectDTO project, int primariKey);
    public int delete(int primaryKey);
    public Collection<ProjectDTO> findAll();
    public ProjectDTO findPk(ProjectDTO primaryKey);

    

    
    
    
}
