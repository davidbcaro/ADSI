/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.CurrentQuarterDao;
import co.edu.sena.eon_jpa.controller.factory.CurrentQuarterFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.CurrentQuarter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
public class CurrentQuarterImplTest {

    private CurrentQuarter c;

    public CurrentQuarterImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        c = new CurrentQuarter();
        c.setIdCurrentQuarter("47");
        c.setStartDate(s.parse("01-01-2018"));
        c.setEndDate(s.parse("12-11-2018"));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdCurrentQuarter method, of class CurrentQuarterImpl.
     */
    @Test
    public void test1Insert() {

        CurrentQuarterDao dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        if (dao.find(c.getIdCurrentQuarter()) == null) {
            dao.insert(c);
        }
        assertEquals(dao.find(c.getIdCurrentQuarter()), c);
    }
    
    
    @Test
 public void test2Find() {
        CurrentQuarterDao dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        CurrentQuarter currentQuartersConsultas = (CurrentQuarter) dao.find(c.getIdCurrentQuarter());
        assertEquals(currentQuartersConsultas,c);
    }
 
  @Test
    public void test3Update() throws ParseException{
        System.out.println("prueba update de campo de status ficha ");
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date calDate = s.parse("30-03-2013");
        Date calDate2 = s.parse("30-03-2014");
        CurrentQuarterDao dao = CurrentQuarterFactory.create(CurrentQuarter.class);
      c.setStartDate(calDate);
      c.setEndDate(calDate2);
        dao.update(c);
        assertEquals(dao.find(c.getIdCurrentQuarter()), c);
    } 
    
        @Test
    public void test3vUpdate() {
        CurrentQuarterDao dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        int resultado = dao.updatePrimaryKey("14", c.getIdCurrentQuarter());
        assertEquals(resultado, 1);
    }
    
     @Test
    public void test4Delete(){
       
        CurrentQuarterDao dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        c.setIdCurrentQuarter("14");
        dao.remove(c);
        assertEquals(dao.find(c.getIdCurrentQuarter()),null);
    }
    
    
    
//
//    @Test
//    public void testFindByIdCurrentQuarter() {
//       
//    
//    
//    
//    
//    }
//
//    /**
//     * Test of findByLikeIdCurrentQuarter method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testFindByLikeIdCurrentQuarter() {
//    }
//
//    /**
//     * Test of findByStartDate method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testFindByStartDate() {
//    }
//
//    /**
//     * Test of findByLikeStarDate method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testFindByLikeStarDate() {
//    }
//
//    /**
//     * Test of findByEndDate method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testFindByEndDate() {
//    }
//
//    /**
//     * Test of findByLikeEndDate method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testFindByLikeEndDate() {
//    }
//
//    /**
//     * Test of updatePrimaryKey method, of class CurrentQuarterImpl.
//     */
//    @Test
//    public void testUpdatePrimaryKey() {
//    }

}
