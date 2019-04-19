/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.EmailServer;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface EmailServerDAO <T extends EmailServer> extends InterfaceDao<T>{

    public List<EmailServer> findByEmail(String email);

    public List<EmailServer> findByPassword(String password);

    public List<EmailServer> findBySmtpHost(String smtpHost);

    public List<EmailServer> findBySmtpPort(int smtpPort);

    public List<EmailServer> findBySmtpStartTlsEnable(boolean startTls);

    public List<EmailServer> findBySmtpAuth(boolean smtpAuth);

    public List<EmailServer> findByRecoveryOrder(String recoveryOrder);

    public List<EmailServer> findByRecoveryMessage(String recoveryMessage);

    public List<EmailServer> findByLikeEmail(String email);

    public List<EmailServer> findByLikePassword(String password);

    public List<EmailServer> findByLikeSmtpHost(String smtpHost);

    public List<EmailServer> findByLikeSmtpPort(String smtpPort);

    public List<EmailServer> findByLikeRecoveryOrder(String recoveryOrder);

    public List<EmailServer> findByLikeRecoveryMessage(String recoveryMessage);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
