/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.ClientDTO;
import co.edu.sena.daowariosoft.model.dto.ClientPkDTO;
import java.util.Collection;

/**
 *
 * @author Brayan
 */
public interface ClientDAO {
  public int insert(ClientDTO phase);
    public int update(ClientDTO phase, ClientPkDTO llavePrimaria);
    public int delete(ClientDTO llavePrimaria);
    public Collection<ClientDTO> findAll();
    public ClientDTO findPk(ClientPkDTO llavePrimaria);
}
