/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.DayDao;
import co.edu.sena.eon_jpa.controller.factory.DayFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Day;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
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
 * @author Telegrafia01
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DayImplTest {
    private Day d;
    
    public DayImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d = new Day();
        d.setNameDay("Lunesito");
        d.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameDay method, of class DayImpl.
     */
    
    @Test
    public void test1Insert(){
        System.out.println("prueba de insert en Day");
        DayDao dao = DayFactory.create(Day.class);
        if (dao.find(d.getNameDay())== null) {
            dao.insert(d);
        }
        assertEquals(dao.find(d.getNameDay()),d);
    }
    
    @Test 
        public void test2Find() {
        System.out.println("prueba find por llave primaria de status ficha");
        DayDao dao = DayFactory.create(Day.class);
        Day dayConsultado = (Day) dao.find(d.getNameDay());
        assertEquals(dayConsultado, d);
    }
        
    @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        DayDao dao = DayFactory.create(Day.class);
        d.setState(Boolean.FALSE);
        dao.update(d);
        assertEquals(dao.find(d.getNameDay()), d);
    }

    @Test
    public void test3vUpdatePk() {
        System.out.println("prueba de update de la  llave primaia de status ficha");
        DayDao dao = DayFactory.create(Day.class);
        int resultado = dao.UpdatePk("Marte", d.getNameDay());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void  test4Delete(){
        System.out.println("prueba de delete de la llave primaria de status ficha");
        DayDao dao = DayFactory.create(Day.class);
        d.setNameDay("Marte");
        dao.remove(d);
        assertEquals(dao.find(d.getNameDay()),null);
    
    }
        
    @Test
    public void testFindByNameDay() {
          DayDao dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByNameDay("Mar");
        for (Day day : lista) {
            assertEquals(d.getNameDay(),"Mar");
        }
    }

    /**
     * Test of findByLike method, of class DayImpl.
     */
    @Test
    public void testFindByLikeNameDay() {
          DayDao dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByLikeNameDay("%a%");
        assertTrue(!lista.isEmpty());
        }
    

    /**
     * Test of findByState method, of class DayImpl.
     */
    @Test
    public void testFindByState() {
          DayDao dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByState(true);
        for (Day day : lista) {
            assertEquals(day.getState(), true);
        }
    }
    
}
