/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import java.util.Date;
import java.util.List;
import static javax.persistence.DiscriminatorType.CHAR;

/**
 *
 * @author SOPORTE
 */
public interface FichaDao <F extends Ficha> extends InterfaceDao<F>{
    public List<F>findByNumberFicha(String numberFicha);
    public List<F>findByStart(Date startDate);
    public List<F>findByEnd(Date endDate);
    public List<F>findByRoute(Character router);
    public List<F>findByProgramCode(String programCode);
    public List<F>findByProgramVersion(String version);
    public List<F>findByNameState(String nameState);
    public List<F>findByLikeNumberFicha(String numberFicha);
    public List<F>findByLikeEnd(Date endDate);
    public List<F>findByLikeProgramCode(String programCode);
    public List<F>findByLikeProgramVersion(String numberFicha);
    public List<F>findByLikeNameState(String numberFicha);
    public int updatePrimaryKey(String nuevoNumberFicha , String viejonumberFicha);
    
    
    
}
