/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.FichaDao;
import co.edu.sena.eon_jpa.controller.factory.FichaFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import co.edu.sena.eon_jpa.model.jpa.entities.Program;
import co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author SOPORTE
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FichaImplTest {
    private Ficha f; 
    
    public FichaImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        
         SimpleDateFormat s = new SimpleDateFormat("yyyy-DD-MM");  
        f = new Ficha();
        f.setEndDate(s.parse("2019-01-01"));
        f.setStartDate(s.parse("2018-01-01"));
        f.setNumberFicha("76349397");
        f.setRoute("fff g6 499");
        f.setProgram(new Program("228106", "V102"));
        f.setNameState(new StatusFicha("En ejecucion"));
        
        
    }

    @Test
    public void test1Insert() {
        FichaDao dao = FichaFactory.create(Ficha.class);
        if (dao.find(f.getNumberFicha()) == null) {
            
             dao.insert(f);
        }
        
        assertEquals(dao.find(f.getNumberFicha()), f);
    }

    @Test
    public void test2Find() {
        FichaDao dao = FichaFactory.create(Ficha.class);
        Ficha FichaConsultas = (Ficha) dao.find(f.getNumberFicha());
        assertEquals(FichaConsultas, f);
    }
    
      @Test
    public void test3Update() throws ParseException{
      
        SimpleDateFormat s = new SimpleDateFormat("yyyy-dd-MM");
        Date calDate = s.parse("2013-03-03");
        Date calDate2 = s.parse("2014-03-05");
        FichaDao dao = FichaFactory.create(Ficha.class);
      f.setEndDate(calDate);
      f.setStartDate(calDate2);
      f.setRoute("32651"); 
      f.setProgram(new Program("228106", "V102"));
      f.setNameState(new StatusFicha("En ejecucion"));
      dao.update(f);
        assertEquals(dao.find(f.getNumberFicha()), f);
    }
    
     @Test
    public void test3vUpdate() {
        FichaDao dao = FichaFactory.create(Ficha.class);
        int resultado = dao.updatePrimaryKey("14", f.getNumberFicha());
        assertEquals(resultado, 1);
    }
    
      @Test
    public void test4Delete(){
       
        FichaDao dao = FichaFactory.create(Ficha.class);
        f.setNumberFicha("14");
        dao.remove(f);
        assertEquals(dao.find(f.getNumberFicha()),null);
    }
    
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByNumberFicha method, of class FichaImpl.
     */
    @Test
    public void testFindByNumberFicha() {
    }

    /**
     * Test of findByStart method, of class FichaImpl.
     */
    @Test
    public void testFindByStart() {
    }

    /**
     * Test of findByEnd method, of class FichaImpl.
     */
    @Test
    public void testFindByEnd() {
    }

    /**
     * Test of findByRoute method, of class FichaImpl.
     */
    @Test
    public void testFindByRoute() {
    }

    /**
     * Test of findByProgramCode method, of class FichaImpl.
     */
    @Test
    public void testFindByProgramCode() {
    }

    /**
     * Test of findByProgramVersion method, of class FichaImpl.
     */
    @Test
    public void testFindByProgramVersion() {
    }

    /**
     * Test of findByNameState method, of class FichaImpl.
     */
    @Test
    public void testFindByNameState() {
    }

    /**
     * Test of findByLikeNumberFicha method, of class FichaImpl.
     */
    @Test
    public void testFindByLikeNumberFicha() {
    }

    /**
     * Test of findByLikeEnd method, of class FichaImpl.
     */
    @Test
    public void testFindByLikeEnd() {
    }

    /**
     * Test of findByLikeProgramCode method, of class FichaImpl.
     */
    @Test
    public void testFindByLikeProgramCode() {
    }

    /**
     * Test of findByLikeProgramVersion method, of class FichaImpl.
     */
    @Test
    public void testFindByLikeProgramVersion() {
    }

    /**
     * Test of findByLikeNameState method, of class FichaImpl.
     */
    @Test
    public void testFindByLikeNameState() {
    }

    /**
     * Test of updatePrimaryKey method, of class FichaImpl.
     */
    @Test
    public void testUpdatePrimaryKey() {
    }
    
}
