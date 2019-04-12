/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao;

import co.edu.sena.eondao.modelo.dto.ProgramDTO;
import co.edu.sena.eondao.modelo.dto.ProgramPkDTO;
import java.util.Collection;

/**
 *
 * @author LUISBERNARDO
 */
public interface ProgramDAO {
    public int insert(ProgramDTO program);
    public int update(ProgramDTO program, String llavePrimaria);
    public int delete(ProgramPkDTO llave);
    public Collection<ProgramDTO> findAll();
    public ProgramDTO findPk(String llavePk);
}
