/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

/**
 *
 * @author SOPORTE
 */
public class User {
    
    private String dateending;
    private String mail;
    private String password;
    private Client clients; 

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public String getDateending() {
        return dateending;
    }

    public void setDateending(String dateending) {
        this.dateending = dateending;
    }

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
    
   

    
}
