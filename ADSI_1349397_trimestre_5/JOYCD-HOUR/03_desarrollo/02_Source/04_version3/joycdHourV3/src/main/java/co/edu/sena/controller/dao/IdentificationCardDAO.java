/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;
import co.edu.sena.controller.dao.InterfaceDao;
import co.edu.sena.model.jpa.entities.IdentificationCard;
import java.util.List;
/**
 *
 * @author 1349397
 */
public interface IdentificationCardDAO  <T extends IdentificationCard> extends InterfaceDao <T> {
    public List<IdentificationCard> findByIdIdentificationCardNumber (String idIdentificationCardNumber);
    public List<IdentificationCard> findByName (String name);
    public List <IdentificationCard> findByStatus (boolean status);
    public List<IdentificationCard> findByLikeIdIdentificationCardNumber (String idIdentificationCardNumber);
    public List<IdentificationCard> findByLikeName (String name);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);

    
}
