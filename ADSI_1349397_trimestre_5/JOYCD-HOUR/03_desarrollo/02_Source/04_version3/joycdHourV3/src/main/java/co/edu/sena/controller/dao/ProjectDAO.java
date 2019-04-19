/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;


import co.edu.sena.controller.dao.InterfaceDao;
import co.edu.sena.controller.dao.InterfaceDao;
import co.edu.sena.model.jpa.entities.Project;
import java.util.List;


/**
 *
 * @author 1349397
 */
public interface ProjectDAO <T extends Project> extends InterfaceDao <T> {
    public List<Project> findByCodeProject (String codeProject);
    public List<Project> findByNameProject (String nameProject);
    public List <Project> findByStatusProject (boolean statusProject);
    public List<Project> findByLikeCodeProject (String codeProject);
    public List<Project> findByLikeNameProject (String nameProject);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
