/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.EmailServer;
import java.util.List;



/**
 *
 * @author Jorge
 */
public interface EmailServerDao <T extends EmailServer> extends InterfaceDao<T>{
    
   public List<T> findByEmail(String email);
    public List<T> findByPasswordSecurity (String passSec);
    public List<T> findBySmtpHost (String host);
    public List<T> findBySmtpPort (String port);
    public List<T> findByRecoveryOrder (String recoOr);
    public List<T> findByRecoveryMessage (String recoMe);
    
    public List<T> findByLikeEmail(String email);
    public List<T> findByLikePasswordSecurity (String passSec);
    public List<T> findByLikeSmtpHost (String host);
    public List<T> findByLikeSmtpPort (String port);
    public List<T> findByLikeRecoveryOrder (String recoOr);
    public List<T> findByLikeRecoveryMessage (String recoMe);
    
    public int updatePK(String  llaveNueva, String llaveVieja);
    
}
