/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.LogErrorDao;
import co.edu.sena.eon_jpa.controller.factory.LogErrorFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.LogError;
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

/**
 *
 * @author 1349397
 */
public class LogErrorDaoImplTest {
    
    private LogError log;
    private LogError test;
    
    public LogErrorDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        log = new LogError();
        log.setIdLog(12345678L);
        log.setLevel("Minimo");
        log.setLogName("Error en Query");
        log.setMessage("Mensaje de Error");
        log.setDate(a.parse("25-11-2017"));
        log.setUser("Eon");
        
        test = new LogError();
        test.setIdLog(4521L);
        test.setLevel("No hay");
        test.setLogName("Error mostrado en Pantalla");
        test.setMessage("Mensaje que Envia el programa");
        test.setDate(a.parse("12-05-2017"));
        test.setUser("Prueba");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        if(dao.find(log.getIdLog())== null){
            dao.insert(log);
        }
        assertEquals(dao.find(log.getIdLog()), log);
        
        if(dao.find(test.getIdLog())== null){
            dao.insert(test);
        }
        assertEquals(dao.find(test.getIdLog()), test);
    }
    
    @Test
    public void test2find(){
        System.out.println("Test Find");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        LogError LogConsulted = (LogError) dao.find(log.getIdLog());
        assertEquals(LogConsulted, log);
    }
      
    
    @Test
    public void test3update() throws ParseException {
        
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Test update");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        log.setLevel("Maximo");
        log.setLogName("Logueo");
        log.setMessage("Error al loguearse");
        Date log1 = a.parse("06-12-2018");
        log.setDate(log1);
        log.setUser("EON Update");
        dao.update(log);
        assertEquals(dao.find(log.getIdLog()), log);
    }
     
    
    @Test
    public void test3vUpdatePrimaryKey() {
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        int resultado = dao.updatePrimaryKey(15648L, log.getIdLog());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4Delete(){
        System.out.println("Test Delete");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        log.setIdLog(15648L);
        dao.remove(log);
        assertEquals(dao.find(log.getIdLog()), null);
    }
   
  
    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    
    @Test
    public void test6FindByLevel() {
        System.out.println("Test findByLevel");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLevel("No hay");
        assertTrue(!lista.isEmpty());
        for (LogError le1 : lista){
            assertEquals(le1.getLevel(), "No hay");
        }
    }

    @Test
    public void test6FindByLogName() {
        System.out.println("Test findByLogName");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLogName("Error mostrado en Pantalla");
        assertTrue(!lista.isEmpty());
        for (LogError le1 : lista){
            assertEquals(le1.getLogName(), "Error mostrado en Pantalla");
        }
    }

    @Test
    public void test6FindByMessage() {
        System.out.println("Test findByMessage");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByMessage("Mensaje que Envia el programa");
        assertTrue(!lista.isEmpty());
        for (LogError le1 : lista){
            assertEquals(le1.getMessage(), "Mensaje que Envia el programa");
        }
    }

    @Test
    public void test6FindByDate() throws ParseException {
        System.out.println("Test findByDate");
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        Date log1 = a.parse("12-05-2017");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByDate(log1);
        for (LogError le1 : lista){
            assertEquals(le1.getDate(), log1);
        }
    }

    @Test
    public void test6FindByUser() {
        System.out.println("Test findByUser");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByUser("Prueba");
        assertTrue(!lista.isEmpty());
        for (LogError le1 : lista){
            assertEquals(le1.getUser(), "Prueba");
        }
    }

    @Test
    public void test6FindByLikeLevel() {
        System.out.println("Test findByLikeLevel");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeLevel("%N%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeLogName() {
        System.out.println("Test findByLikeLogName");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeLogName("%Er%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeMessage() {
        System.out.println("Test findByLikeMessage");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeMessage("%Men%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeUser() {
        System.out.println("Test findByLikeUser");
        LogErrorDao dao = LogErrorFactory.create(LogError.class);
        List<LogError> lista = dao.findByLikeUser("%Pr%");
        assertTrue(!lista.isEmpty());
    }    
}
