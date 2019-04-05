/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LogAuditDao;
import co.edu.sena.cot.controlador.factory.mysql.LogAuditFactory;
import co.edu.sena.cot.modelo.dto.LogAudit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class LogAuditDaoImplTest {

    LogAudit la;

    public LogAuditDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        la = new LogAudit();
        la.setLogAudit(123L);
        la.setLevel("Dos");
        la.setLogName("Hola");
        la.setMessage("Descripcion");
        la.setUser("Jorge");
        la.setDate(date);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        if (dao.find(la.getLogAudit()) == null) {
            dao.insert(la);

        }
        assertEquals(dao.find(la.getLogAudit()), la);
    }

    @Test
    public void test02Find() {
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        LogAudit logAuditCon = (LogAudit) dao.find(la.getLogAudit());
        assertEquals(logAuditCon, la);

    }

    @Test
    public void test03Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        la.setLevel("TRES");
        dao.update(la);
        assertEquals(dao.find(la.getLogAudit()), la);
    }

    @Test
    public void test03vUpdatePK() {
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        la.setLogAudit(123L);
        int resultado = dao.updatePK(754L, la.getLogAudit());
        assertEquals(resultado, 1);

    }

    @Test
    public void test04FindAll() {
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test05FindPrimaryKey() {
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLogAudit(754L);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

   
    /**
     * Test of findByLevel method, of class LogAuditDaoImpl.
     */
    @Test
    public void test06FindByLevel() {
        System.out.println("las");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLevel("TRES");
        assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getLevel(), "TRES");
        }
        System.out.println("estados " + lista);
    }

    /**
     * Test of findByLogName method, of class LogAuditDaoImpl.
     */
    @Test
    public void test07FindByLogName() {
        System.out.println("las2");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLogName("Hola");
        assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getLogName(), "Hola");
        }
        System.out.println("estados " + lista);
    }


/**
 * Test of findByMessage method, of class LogAuditDaoImpl.
 */
@Test
        public void test08FindByMessage() {
        System.out.println("las");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByMessage("Descripcion");
          assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getMessage(), "Descripcion");
        }
        System.out.println("estados "+lista);
    
    }

   
    /**
     * Test of findByUser method, of class LogAuditDaoImpl.
     */
    @Test
        public void test09FindByUser() {
        System.out.println("las");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByUser("Jorge");
          assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getUser(), "Jorge");
        }
        System.out.println("estados "+lista);
    }
        
        @Test
        public void test10FindByLogAudit() {
        System.out.println("las");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLogAudit(754L);
          assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getLogAudit().longValue(), 754L);
        }
        System.out.println("estados "+lista);
    }
        
        @Test
        public void test11FindByDate() throws ParseException {
        System.out.println("las");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        SimpleDateFormat by = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date by2 = by.parse("31-08-1982 10:20:56");
        List<LogAudit> lista = dao.findByDate(by2);
          assertTrue(!lista.isEmpty());
        for (LogAudit loga : lista) {
            assertEquals(loga.getDate(), by2);
        }
        System.out.println("estados "+lista);
    }
        
        @Test
        public void test12FindByLikeLogAudit() {
       System.out.println("lassssss");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLikeLogAudit("%7%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
   


    /**
     * Test of findByLikeLevel method, of class LogAuditDaoImpl.
     */
    @Test
        public void test13FindByLikeLevel() {
       System.out.println("lassssss");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLikeLevel("%T%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLogName method, of class LogAuditDaoImpl.
     */
    @Test
        public void test14FindByLikeLogName() {
       System.out.println("lassssss");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLikeLogName("%H%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeMessage method, of class LogAuditDaoImpl.
     */
    @Test
        public void test15FindByLikeMessage() {
        System.out.println("lassssss");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLikeMessage("%D%");
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
        public void test16FindByLikeUser() {
         
        System.out.println("lassssss");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        List<LogAudit> lista = dao.findByLikeUser("%J%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
     //@Test
       // public void test17FindByLikeDate() throws ParseException {
         
       // System.out.println("lassssss");
        //LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
       
      //  List<LogAudit> lista = dao.findByLikeDate("%1982%");
       // assertTrue(!lista.isEmpty());
        //System.out.println("nananan "+ lista);
    //}
        
        
    @Test
        public void test18Delete(){
            System.out.println("prueba de tipo de documento metodo delete para la llave");
        LogAuditDao dao = LogAuditFactory.create(LogAudit.class);
        la.setLogAudit(754L);
        dao.remove(la);
        assertEquals(dao.find(la.getLogAudit()), null);
        }

}
