/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AuditoryLogDao;
import co.edu.sena.eon_jpa.controller.factory.AuditoryLogFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.AuditoryLog;
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
 * @author LUISBERNARDO
 */
public class AuditoryLogDaoImplTest {
    
    private AuditoryLog log;
    private AuditoryLog test;
    
    public AuditoryLogDaoImplTest() {
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
        log = new AuditoryLog();
        log.setIdLog(12345678L);
        log.setLevel("Minimo");
        log.setLogName("Error en Query");
        log.setMessage("Mensaje");
        log.setDate(a.parse("25-11-2017"));
        log.setUser("Eon");
        
        test = new AuditoryLog();
        test.setIdLog(4521L);
        test.setLevel("No hay");
        test.setLogName("Error auditory");
        test.setMessage("Mensaje auditory");
        test.setDate(a.parse("12-05-2017"));
        test.setUser("Prueba");
    }
    
    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
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
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        AuditoryLog AudiConsulted = (AuditoryLog) dao.find(log.getIdLog());
        assertEquals(AudiConsulted, log);
    }
      
    
    @Test
    public void test3update() throws ParseException {
        
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Test update");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
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
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        int resultado = dao.updatePrimaryKey(15648L, log.getIdLog());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4Delete(){
        System.out.println("Test Delete");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        log.setIdLog(15648L);
        dao.remove(log);
        assertEquals(dao.find(log.getIdLog()), null);
    }
   
  
    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    
    @Test
    public void test6FindByLevel() {
        System.out.println("Test findByLevel");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLevel("No hay");
        assertTrue(!lista.isEmpty());
        for (AuditoryLog le1 : lista){
            assertEquals(le1.getLevel(), "No hay");
        }
    }

    @Test
    public void test6FindByLogName() {
        System.out.println("Test findByLogName");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLogName("Error auditory");
        assertTrue(!lista.isEmpty());
        for (AuditoryLog le1 : lista){
            assertEquals(le1.getLogName(), "Error auditory");
        }
    }

    @Test
    public void test6FindByMessage() {
        System.out.println("Test findByMessage");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByMessage("Mensaje auditory");
        assertTrue(!lista.isEmpty());
        for (AuditoryLog le1 : lista){
            assertEquals(le1.getMessage(), "Mensaje auditory");
        }
    }

    @Test
    public void test6FindByDate() throws ParseException {
        System.out.println("Test findByDate");
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        Date log1 = a.parse("12-05-2017");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByDate(log1);
        for (AuditoryLog le1 : lista){
            assertEquals(le1.getDate(), log1);
        }
    }

    @Test
    public void test6FindByUser() {
        System.out.println("Test findByUser");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByUser("Prueba");
        assertTrue(!lista.isEmpty());
        for (AuditoryLog le1 : lista){
            assertEquals(le1.getUser(), "Prueba");
        }
    }

    @Test
    public void test6FindByLikeLevel() {
        System.out.println("Test findByLikeLevel");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLikeLevel("%N%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeLogName() {
        System.out.println("Test findByLikeLogName");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLikeLogName("%Er%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeMessage() {
        System.out.println("Test findByLikeMessage");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLikeMessage("%Men%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeUser() {
        System.out.println("Test findByLikeUser");
        AuditoryLogDao dao = AuditoryLogFactory.create(AuditoryLog.class);
        List<AuditoryLog> lista = dao.findByLikeUser("%Pr%");
        assertTrue(!lista.isEmpty());
    }   
    
}
