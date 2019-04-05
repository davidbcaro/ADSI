/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Trimester;
import co.edu.sena.cot.modelo.dto.TrimesterPK;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface TrimesterDao <T extends Trimester> extends InterfaceDao<T> {
    public List<T> findByNumber (int number);
    public List<T> findByInitials (String initials);
    public List<T> findByCode (String code);
    public List<T> findByLikeNumber (String number);
    public List<T> findByLikeInitials (String initials);
    public List<T> findByLikeCode (String code);
    public int updatePrimaryKey(TrimesterPK llaveNueva, TrimesterPK llaveVieja);
}
