/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.DayFactory;
import co.edu.sena.wariosoftjpa.controller.dao.DayDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Day;
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
 * @author Brayan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DayImplTest {

    private Day dat;

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
        dat = new Day();
        dat.setNameDay("lunfest");
        dat.setState(true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameDay method, of class DayImpl.
     */
    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de Day metodo insert");
        DayDAO dao = DayFactory.create(Day.class);
        if (dao.find(dat.getNameDay()) == null) {
            dao.insert(dat);
        }
        assertEquals(dao.find(dat.getNameDay()), dat);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de Day metodo find por llave primaria");
        DayDAO dao = DayFactory.create(Day.class);
        Day DayConsultado = (Day) dao.find(dat.getNameDay());
        assertEquals(DayConsultado, dat);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de Day metodo update po llave primaria");
        DayDAO dao = DayFactory.create(Day.class);
        dat.setState(Boolean.FALSE);
        dao.update(dat);
        assertEquals(dao.find(dat.getNameDay()), dat);
    }

    @Test
    public void test3updatePk() {
        DayDAO dao = DayFactory.create(Day.class);
        int resultado = dao.updatePk("viercoles", dat.getNameDay());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4delete() {
        System.out.println("prueba de Day metodo delete para la llave");
        DayDAO dao = DayFactory.create(Day.class);
        dat.setNameDay("viercoles");
        dao.remove(dat);
        assertEquals(dao.find(dat.getNameDay()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de Day metodo findall");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByNameDay() {
        System.out.println("findByNameDay");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByNameDay("lunfest");
        for (Day day : lista) {
            assertEquals(day.getNameDay(), "lunfest");
        }
    }

    /**
     * Test of findByState method, of class DayImpl.
     */
    @Test
    public void test7FindByState() {
        System.out.println("findByState");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByState(true);
        for (Day day : lista) {
            assertEquals(day.getState(), true);
        }
    }

    /**
     * Test of findByLikeNameDay method, of class DayImpl.
     */
    @Test
    public void test8FindByLikeNameDay() {
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByLikeNameDay("D%");
        assertTrue(!lista.isEmpty());
    }
}
