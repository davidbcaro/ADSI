/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EmailServerDao;
import co.edu.sena.cot.controlador.factory.mysql.EmailServerFactory;
import co.edu.sena.cot.modelo.dto.EmailServer;
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
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailServerImplTest {
    EmailServer es;
    public EmailServerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        es = new EmailServer();
        es.setEmail("asfa@gmail.com");
        es.setPasswordSecurity("12345");
        es.setRecoveryMessage("Hola");
        es.setRecoveryOrder("Titulo");
        es.setSmtpAuth(true);
        es.setSmtpStartTlsEnable(false);
        es.setSmtpHost("12");
        es.setSmtpPort("14");
                
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByLogEmail method, of class EmailServerImpl.
     */
    @Test
    public void test01Insert() {
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        if (dao.find(es.getEmail()) == null) {
            dao.insert(es);

        }
        assertEquals(dao.find(es.getEmail()), es);
    }

    @Test
    public void test02Find() {
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        EmailServer logAuditCon = (EmailServer) dao.find(es.getEmail());
        assertEquals(logAuditCon, es);

    }

    @Test
    public void test03Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        es.setPasswordSecurity("7894");
        dao.update(es);
        assertEquals(dao.find(es.getEmail()), es);
    }

    @Test
    public void test03vUpdatePK() {
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        es.setEmail("asfa@gmail.com");
        int resultado = dao.updatePK("lkjh@gmail.com", es.getEmail());
        assertEquals(resultado, 1);

    }

    @Test
    public void test04FindAll() {
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test05FindByEmail() {
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByEmail("lkjh@gmail.com");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

   
    /**
     * Test of findByLevel method, of class LogAuditDaoImpl.
     */
    @Test
    public void test06FindByPasswordSecurity() {
        System.out.println("las");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByPasswordSecurity("7894");
        assertTrue(!lista.isEmpty());
        for (EmailServer loga : lista) {
            assertEquals(loga.getPasswordSecurity(), "7894");
        }
        System.out.println("estados " + lista);
    }

    /**
     * Test of findByLogName method, of class LogAuditDaoImpl.
     */
    @Test
    public void test07FindByRecoveryMessage() {
        System.out.println("las2");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByRecoveryMessage("Hola");
        assertTrue(!lista.isEmpty());
        for (EmailServer loga : lista) {
            assertEquals(loga.getRecoveryMessage(), "Hola");
        }
        System.out.println("estados " + lista);
    }


/**
 * Test of findByMessage method, of class LogAuditDaoImpl.
 */
@Test
        public void test08FindByRecoveryOrder() {
        System.out.println("las");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByRecoveryOrder("Titulo");
          assertTrue(!lista.isEmpty());
        for (EmailServer loga : lista) {
            assertEquals(loga.getRecoveryOrder(), "Titulo");
        }
        System.out.println("estados "+lista);
    
    }

    /**

     */
    @Test
        public void test09FindBySmtpHost() {
        System.out.println("las");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findBySmtpHost("12");
          assertTrue(!lista.isEmpty());
        for (EmailServer loga : lista) {
            assertEquals(loga.getSmtpHost(), "12");
        }
        System.out.println("estados "+lista);
    }
        
        @Test
        public void test10FindBySmtpPort() {
        System.out.println("las");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findBySmtpPort("14");
          assertTrue(!lista.isEmpty());
        for (EmailServer loga : lista) {
            assertEquals(loga.getSmtpPort(), "14");
        }
        System.out.println("estados "+lista);
    }

   


    /**
     * Test of findByLikeLevel method, of class LogAuditDaoImpl.
     */
    @Test
        public void test11FindByLikeEmail() {
       System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikeEmail("%l%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLogName method, of class LogAuditDaoImpl.
     */
    @Test
        public void test12FindByLikePasswordSecurity() {
       System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikePasswordSecurity("%7%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeMessage method, of class LogAuditDaoImpl.
     */
    @Test
        public void test13FindByLikeSmtpHost() {
        System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikeSmtpHost("%1%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeDate method, of class LogAuditDaoImpl.
     */
    
    /**
     * Test of findByLikeUser method, of class LogAuditDaoImpl.
     */
    @Test
        public void test14FindByLikeSmtpPort() {
         
        System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikeSmtpPort("%1%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
        
         @Test
        public void test15FindByLikeRecoveryOrder() {
         
        System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikeRecoveryOrder("%T%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
        
          @Test
        public void test16FindByLikeRecoveryMessage() {
         
        System.out.println("lassssss");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        List<EmailServer> lista = dao.findByLikeRecoveryMessage("%H%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
        
    @Test
        public void test17Delete(){
            System.out.println("prueba de tipo de documento metodo delete para la llave");
        EmailServerDao dao = EmailServerFactory.create(EmailServer.class);
        es.setEmail("lkjh@gmail.com");
        dao.remove(es);
        assertEquals(dao.find(es.getEmail()), null);
        }

    
}
