/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DayDao;
import co.edu.sena.tidsplanjpa.controller.factory.DayFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Day;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author MIHOGAR
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DayDaoImplTest {
    private Day dy;
    public DayDaoImplTest() {
    }
    
  
    
    @Before
    public void setUp() {
        dy = new Day();
        dy.setNameDay("Festivo");
        dy.setStatus(Boolean.TRUE);
    }
    
 
        @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        DayDao dao =DayFactory.create(Day.class);
        if (dao.find(dy.getNameDay()) == null) {
            dao.insert(dy);
        }
        assertEquals(dao.find(dy.getNameDay()), dy);
    }
    
    @Test
    public void test02find() {
        System.out.println("Prueba de find");
        DayDao dao =DayFactory.create(Day.class);
        Day d = (Day) dao.find(dy.getNameDay());
        assertEquals(d, dy);
    }
    
    @Test
    public void test03update() {
        System.out.println("Prueba update");
        DayDao dao =DayFactory.create(Day.class);
        dy.setStatus(Boolean.FALSE);
        dao.update(dy);
        assertEquals(dao.find(dy.getNameDay()) , dy);
    }
    
    @Test
    public void test04UpdatePrimaryKey(){
        System.out.println("prueba de metodo update por llave primaria");
        DayDao dao =DayFactory.create(Day.class);
        int resultado = dao.updatePrimaryKey("Visiesto", dy.getNameDay());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba delete");
        DayDao dao =DayFactory.create(Day.class);
        dy.setNameDay("Visiesto");
        dao.remove(dy);
        assertEquals(dao.find(dy.getNameDay()), null);

    }
      @Test
    public void test06FindAll() {
        System.out.println("Prueba de findAll");
        DayDao dao =DayFactory.create(Day.class);
        List<Day> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }
    
    @Test
    public void testFindByNameDay() {
        System.out.println("Prueba de Find By");
        DayDao dao =DayFactory.create(Day.class);
        List<Day> lista = dao.findByNameDay("Miercoles");
        assertTrue(!lista.isEmpty());
        for (Day day : lista) {
            assertEquals(day.getNameDay(), "Miercoles");
        }
    }

    /**
     * Test of findByLikeNameDay method, of class DayDaoImpl.
     */
    @Test
    public void testFindByLikeNameDay() {
        System.out.println("Prueba de Find Like");
        DayDao dao =DayFactory.create(Day.class);
        List<Day> lista = dao.findByLikeNameDay("%M%");
        assertTrue(!lista.isEmpty());
        for (Day day : lista) {
            System.out.println(day);

        }
    }

    /**
     * Test of findByStatus method, of class DayDaoImpl.
     */
    @Test
    public void testFindByStatus() {
        System.out.println("Prueba de Find By");
        DayDao dao =DayFactory.create(Day.class);
        List<Day> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (Day day : lista) {
            assertEquals(day.getStatus(), true);
        }
    }

   
}
