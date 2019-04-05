/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LogErrorDao;
import co.edu.sena.cot.controlador.factory.mysql.LogErrorFactory;
import co.edu.sena.cot.modelo.dto.LogError;
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
public class LogErrorImplTest {

    private LogError le;

    public LogErrorImplTest() {
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
        le = new LogError();
        le.setLogError(123);
        le.setLevel("Dos");
        le.setLogName("Hola");
        le.setMessage("Descripcion");
        le.setUser("Jorge");
        le.setDate(date);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        if (dao.find(le.getLogError()) == null) {
            dao.insert(le);

        }
        assertEquals(dao.find(le.getLogError()), le);
    }

    @Test
    public void test02Find() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        LogError logErrorCon = (LogError) dao.find(le.getLogError());
        assertEquals(logErrorCon, le);

    }

    @Test
    public void test03Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        le.setLevel("TRES");
        dao.update(le);
        assertEquals(dao.find(le.getLogError()), le);
    }

    @Test
    public void test03vUpdatePK() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        le.setLogError(123);
        int resultado = dao.updatePK(754, le.getLogError());
        assertEquals(resultado, 1);

    }

    @Test
    public void test04FindAll() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test05FindByLogError() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLogError(754);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLevel method, of class LogErrorImpl.
     */
    @Test
    public void test06FindByLevel() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLevel("TRES");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLogName method, of class LogErrorImpl.
     */
    @Test
    public void test07FindByLogName() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLogName("Hola");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByMessage method, of class LogErrorImpl.
     */
    @Test
    public void test08FindByMessage() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByMessage("Descripcion");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByDate method, of class LogErrorImpl.
     */
    @Test
    public void test09FindByDate() throws ParseException {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date2 = sdf.parse(dateInString);
        List<LogError> lista = dao.findByDate(date2);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByUser method, of class LogErrorImpl.
     */
    @Test
    public void test10FindByUser() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByUser("Jorge");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeLogError method, of class LogErrorImpl.
     */
    @Test
    public void test11FindByLikeLogError() {
         System.out.println("lassssss");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeLogError("%7%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLevel method, of class LogErrorImpl.
     */
    @Test
    public void test12FindByLikeLevel() {
      System.out.println("lassssss");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeLevel("%T%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLogName method, of class LogErrorImpl.
     */
    @Test
    public void test13FindByLikeLogName() {
         System.out.println("lassssss");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeLogName("%H%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeMessage method, of class LogErrorImpl.
     */
    @Test
    public void test14FindByLikeMessage() {
       System.out.println("lassssss");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeMessage("%D%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeUser method, of class LogErrorImpl.
     */
    @Test
    public void test15FindByLikeUser() {
         System.out.println("lassssss");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeUser("%J%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
    
     @Test
        public void test16Delete(){
            System.out.println("prueba de tipo de documento metodo delete para la llave");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        le.setLogError(754);
        dao.remove(le);
        assertEquals(dao.find(le.getLogError()), null);
        }


}
