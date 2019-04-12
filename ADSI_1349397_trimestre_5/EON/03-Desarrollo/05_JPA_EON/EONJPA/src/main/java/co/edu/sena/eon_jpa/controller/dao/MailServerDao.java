/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.MailServer;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <m>
 */
public interface MailServerDao <m extends MailServer> extends InterfaceDao<m>{
    public List<m> findByMail(int Mail);
    public List<m> findByPassword(String Password);
    public List<m> findBySmtpHost(String SmtpHost);
    public List<m> findBySmtpPort(int SmtpPort);
    public List<m> findBySmtpStartTlsEnable(boolean SmtpStartTlsEnable);
    public List<m> findBySmtpAuth(boolean SmtpAuth);
    public List<m> findByRecoveryCase(String recoveryCase);
    public List<m> findByMessageRecovery(String messageRecovery);
    public List<m> findByLikePassword(String Password);
    public List<m> findByLikeSmtpHost(String SmtpHost);
    public List<m> findByLikeSmtpPort(int SmtpPort);
    public List<m> findByLikeSmtpStartTlsEnable(boolean SmtpStartTlsEnable);
    public List<m> findByLikeSmtpAuth(boolean SmtpAuth);
    public List<m> findByLikeRecoveryCase(String recoveryCase);
    public List<m> findByLikeMessageRecovery(String messageRecovery);
    public int updatePrimaryKey(int llaveNueva, int llaveVieja);
}
