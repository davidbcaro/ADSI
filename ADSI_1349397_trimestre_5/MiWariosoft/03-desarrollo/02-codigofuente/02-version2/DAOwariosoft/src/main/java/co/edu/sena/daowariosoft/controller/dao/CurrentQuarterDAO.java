/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao;

import co.edu.sena.daowariosoft.model.dto.CurrentQuarterDTO;
import java.util.Collection;

/**
 *
 * @author 1349397
 */
public interface CurrentQuarterDAO {
    public int insert(CurrentQuarterDTO currentQuarter);
    public int update(CurrentQuarterDTO currentQuarter, String llave);
    public int delete(String llave);
    public Collection<CurrentQuarterDTO> findAll();
    public CurrentQuarterDTO findPk(String llave);
}
