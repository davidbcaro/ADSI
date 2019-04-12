/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.MailServerDao;
import co.edu.sena.eon_jpa.controller.factory.MailServerFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.MailServer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailServerDaoImplTest {
    
    private MailServer mail;
    private MailServer test;
    
    public MailServerDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        mail = new MailServer();
        mail.setMail(1349397);
        mail.setPassword("123456");
        mail.setSmtpHost("LocalHost");
        mail.setSmtpPort(4306);
        mail.setSmtpStarttlsenable(true);
        mail.setSmtpAuth(true);
        mail.setRecoveryCase("Message of alert");
        mail.setMessageRecovery("The message for recuperation of account in your email");
        
        test = new MailServer();
        test.setMail(591144);
        test.setPassword("56526");
        test.setSmtpHost("LocalHost");
        test.setSmtpPort(4306);
        test.setSmtpStarttlsenable(true);
        test.setSmtpAuth(true);
        test.setRecoveryCase("Alert");
        test.setMessageRecovery("The message for recuperation");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        if (dao.find(mail.getMail()) == null) {
            dao.insert(mail);
        }
        assertEquals(dao.find(mail.getMail()), mail);
        
        if (dao.find(test.getMail()) == null) {
            dao.insert(test);
        }
        assertEquals(dao.find(test.getMail()), test);
    }
    
    @Test
    public void test2find() {
        System.out.println("Test Find");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        MailServer mailConsulted = (MailServer) dao.find(mail.getMail());
        assertEquals(mailConsulted, mail);
    }
    
    @Test
    public void test3update() {
        System.out.println("Test Update");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        mail.setPassword("123");
        mail.setSmtpHost("Local Update");
        mail.setSmtpPort(3306);
        mail.setSmtpStarttlsenable(false);
        mail.setSmtpAuth(false);
        mail.setRecoveryCase("alert - Update");
        mail.setMessageRecovery("Update");
        dao.update(mail);
        assertEquals(dao.find(mail.getMail()), mail);
    }
    
    @Test
    public void test3vUpdatePrimaryKey() {
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        int resultado = dao.updatePrimaryKey(23165, mail.getMail());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        mail.setMail(23165);
        dao.remove(mail);
        assertEquals(dao.find(mail.getMail()), null);
    }
    
    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindByMail() {
        System.out.println("Test FindByMail");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByMail(591144);
        assertTrue(!lista.isEmpty());
        for (MailServer ms1 : lista){
         assertEquals(ms1.getMail().intValue(), 591144);       
        }
    }

    
    @Test
    public void test6FindByPassword() {
        System.out.println("Test findByPassword");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByPassword("56526");
        assertTrue(!lista.isEmpty());
        for (MailServer ms1 : lista){
            assertEquals(ms1.getPassword(), "56526");
        }
    }

    
    @Test
    public void test6FindBySmtpHost() {
        System.out.println("Test findBySmtpHost");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findBySmtpHost("LocalHost");
        assertTrue(!lista.isEmpty());
        for (MailServer ms1 : lista){
            assertEquals(ms1.getSmtpHost(), "LocalHost");
        }
    }

    
    @Test
    public void test6FindBySmtpPort() {
        System.out.println("Test findBySmtpPort");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findBySmtpPort(4306);
        assertTrue(!lista.isEmpty());
        for (MailServer ms1 : lista){
            assertEquals(ms1.getSmtpPort().intValue(), 4306);
        }
   }

    
    @Test
    public void test6FindBySmtpStartTlsEnable() {
        System.out.println("Test findBySmtpStartTlsEnable");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findBySmtpStartTlsEnable(true);
        assertTrue(!lista.isEmpty());
        for(MailServer ms1 : lista){
            assertEquals(ms1.getSmtpStarttlsenable(), true);
        }
   }

    
    @Test
    public void test6FindBySmtpAuth() {
        System.out.println("Test findBySmtpAuth");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findBySmtpAuth(true);
        assertTrue(!lista.isEmpty());
        for(MailServer ms1 : lista){
            assertEquals(ms1.getSmtpAuth(), true);
        }
   }

    
    @Test
    public void test6FindByRecoveryCase() {
        System.out.println("Test findByRecoveryCase");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByRecoveryCase("Alert");
        assertTrue(!lista.isEmpty());
        for(MailServer ms1 : lista){
            assertEquals(ms1.getRecoveryCase(), "Alert");
        } 
        
    }

    
    @Test
    public void test6FindByMessageRecovery() {
        System.out.println("Test findByMessageRecovery");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByMessageRecovery("The message for recuperation");
        assertTrue(!lista.isEmpty());
        for(MailServer ms1 : lista){
            assertEquals(ms1.getMessageRecovery(), "The message for recuperation");
        }
    }

    
    @Test
    public void test6FindByLikePassword() {
        System.out.println("Test findByLikePassword");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByLikePassword("%5%");
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void test6FindByLikeSmtpHost() {
        System.out.println("Test findByLikeSmtpHost");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByLikeSmtpHost("%L%");
        assertTrue(!lista.isEmpty());
    }

   
    @Test
    public void test6FindByLikeRecoveryCase() {
        System.out.println("Test findByLikeRecoveryCase");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByLikeRecoveryCase("%A%");
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void test6FindByLikeMessageRecovery() {
        System.out.println("Test findByLikeMessageRecovery");
        MailServerDao dao = MailServerFactory.create(MailServer.class);
        List<MailServer> lista = dao.findByLikeMessageRecovery("%T%");
        assertTrue(!lista.isEmpty());
    }
}
