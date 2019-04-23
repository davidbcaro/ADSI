/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.EnvironmentDTO;
import co.edu.sena.daowariosoft.model.dto.EnvironmentPkDTO;
import java.util.Collection;

/**
 *
 * @author WINDOWS 8
 */
public interface EnvironmentDAO {
      public int insert(EnvironmentDTO phase);
    public int update(EnvironmentDTO phase, EnvironmentPkDTO llavePrimaria);
    public int delete(EnvironmentPkDTO llavePrimaria);
    public Collection<EnvironmentDTO> findAll();
    public EnvironmentDTO findPk(EnvironmentPkDTO llavePrimaria); 
}
