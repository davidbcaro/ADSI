/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.ProjectDTO;
import java.util.Collection;

/**
 *
 * @author SENA
 */
public interface ProjectDAO {
     public int insert(ProjectDTO project);
    public int update(ProjectDTO project, String llavePrimaria);
    public int delete(String llavePrimaria);
    public Collection<ProjectDTO> findAll();
    public ProjectDTO findPk(String llavePrimaria);
}
