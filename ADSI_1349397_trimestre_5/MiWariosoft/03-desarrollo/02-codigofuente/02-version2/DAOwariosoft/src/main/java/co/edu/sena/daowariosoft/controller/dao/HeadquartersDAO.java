/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.HeadquartersDTO;
import java.util.Collection;

/**
 *
 * @author WINDOWS 8
 */
public interface HeadquartersDAO {
       public int insert(HeadquartersDTO document);
    public int update(HeadquartersDTO document, String llavePrimaria);
    public int delete(String llavePrimaria);
    public Collection<HeadquartersDTO> findAll();
    public HeadquartersDTO findPk(String llavePrimaria);
}
