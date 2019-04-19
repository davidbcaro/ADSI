/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao;

import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentDTO;
import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentPKDTO;
import java.util.Collection;

/**
 *
 * @author liosalfar
 */
public interface EnvironmentDAO {

    public int insert(EnvironmentDTO environment);

    public int update(EnvironmentDTO environment, EnvironmentPKDTO llave);

    public int delete(EnvironmentPKDTO llave);

    public Collection<EnvironmentDTO> findAll();

    public EnvironmentDTO findPk(EnvironmentPKDTO llave);
}
