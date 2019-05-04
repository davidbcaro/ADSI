/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

/**
 *
 * @author 1349397
 */
public class EmailServer {
    private String mail;
    private String password;
    private String smtpHost;
    private int smtpPort;
    private boolean smtpStartTlsEnable;
    private boolean smtpAuth;
    private String subjectRecovery;
    private String messageRecovery;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public boolean isSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(boolean smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    public boolean isSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public String getSubjectRecovery() {
        return subjectRecovery;
    }

    public void setSubjectRecovery(String subjectRecovery) {
        this.subjectRecovery = subjectRecovery;
    }

    public String getMessageRecovery() {
        return messageRecovery;
    }

    public void setMessageRecovery(String messageRecovery) {
        this.messageRecovery = messageRecovery;
    }
    
    
}
