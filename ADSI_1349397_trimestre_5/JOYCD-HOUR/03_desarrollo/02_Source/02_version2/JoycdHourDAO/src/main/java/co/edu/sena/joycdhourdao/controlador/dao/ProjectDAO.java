/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;


import co.edu.sena.joycdhourdao.modelo.dto.ProjectDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface ProjectDAO {
   
    public int insert(ProjectDTO project);
    public int update(ProjectDTO project, String key);
    public int delete(String key);
    public Collection<ProjectDTO> findAll();
    public ProjectDTO findPk(String key);

}
    

