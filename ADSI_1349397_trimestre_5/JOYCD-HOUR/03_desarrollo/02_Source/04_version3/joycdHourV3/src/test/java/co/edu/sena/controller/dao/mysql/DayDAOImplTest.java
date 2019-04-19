/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.DayDAO;
import co.edu.sena.controller.factory.DayFactory;
import co.edu.sena.model.jpa.entities.Day;
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
 * @author liosalfar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DayDAOImplTest {

    private Day day;

    public DayDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        day = new Day();
        day.setNameDay("diaLoco");
        day.setStatus(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameDay method, of class DayDAOImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("test Insert DAY");
        DayDAO dao = DayFactory.create(Day.class);
        if (dao.find(day.getNameDay()) == null) {
            dao.insert(day);
        }
        assertEquals(dao.find(day.getNameDay()), day);

    }

    /**
     * Test of findByStatus method, of class DayDAOImpl.
     */
    @Test
    public void test02find() {
        System.out.println("Prueba consulta DAY");
        DayDAO dao = DayFactory.create(Day.class);
        Day dayconsulta = (Day) dao.find(day.getNameDay());
        assertEquals(dayconsulta, day);
    }

    /**
     * Test of findByLikeNameDay method, of class DayDAOImpl.
     */
    @Test
    public void test03update() {
        System.out.println("Preba test uptdate");
        DayDAO dao = DayFactory.create(Day.class);
        day.setStatus(Boolean.FALSE);
        dao.update(day);
        assertEquals(dao.find(day.getNameDay()), day);
    }

    @Test
    public void test03vUpdatePrimarykey() {
        System.out.println("prueba de update Bonding");
        DayDAO dao = DayFactory.create(Day.class);
        int resultado = dao.updatePrimaryKey("diaNormal", day.getNameDay());
        assertEquals(resultado, 1);

    }

    @Test
    public void test04FindByNameDay() {
        System.out.println("Prueba findlikeNameDay");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByNameDay("diaNormal");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test05FindByLikeNameDay() {
        System.out.println("Prueba findlikeNameDay");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findByLikeNameDay("L%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test06FindAll() {
        System.out.println("prueba consulta tabla Day");
        DayDAO dao = DayFactory.create(Day.class);
        List<Day> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }

    @Test
    public void Test07Delete() {
        System.out.println("prueba de Delete tabla day");
        DayDAO dao = DayFactory.create(Day.class);
        day.setNameDay("diaNormal");
        dao.remove(day);
        assertEquals(dao.find(day.getNameDay()), null);
    }

    /**
     * Test of updatePrimaryKey method, of class DayDAOImpl.
     */
}
