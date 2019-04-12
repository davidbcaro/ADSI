/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.WorkingDayDao;
import co.edu.sena.eon_jpa.controller.factory.WorkingDayFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay;
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
 * @author Telegrafia01
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkingDayImplTest {

    private WorkingDay wd;

    public WorkingDayImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        wd = new WorkingDay();
        wd.setAcronymsWorkingDay("W");
        wd.setDescription("blablabla");
        wd.setName("noce");
        wd.setState(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void Test1Insert() {
        System.out.println("prueba de el insert de workingDay");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        if (dao.find(wd.getAcronymsWorkingDay()) == null) {
            dao.insert(wd);
        }
        assertEquals(dao.find(wd.getAcronymsWorkingDay()), wd);
    }
@Test
    public void test2Find() {
        System.out.println("prueba find por llave primaria de WorkingDay");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        WorkingDay workingDayConsultado = (WorkingDay) dao.find(wd.getAcronymsWorkingDay());
        assertEquals(workingDayConsultado, wd);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setDescription("basura");
        wd.setName("basurarestante");
        wd.setState(Boolean.FALSE);
        dao.update(wd);
        assertEquals(dao.find(wd.getAcronymsWorkingDay()), wd);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        System.out.println("prueba de update de la  llave primaia de status ficha");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        int resultado = dao.updatePrimaryKey("Q", wd.getAcronymsWorkingDay());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4Delete() {
        System.out.println("prueba de delete de la llave primaria de status ficha");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setAcronymsWorkingDay("Q");
        dao.remove(wd);
        assertEquals(dao.find(wd.getAcronymsWorkingDay()), null);

    }

    @Test
    public void testFindByName() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByName("Diurno");
        for (WorkingDay WorkingDay : lista) {
            assertEquals(WorkingDay.getName(), "Diurno");
        }

    }

    @Test
    public void testFindByLikeName() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeName("%D%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testFindByDescription() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByDescription("de 06:00:00 AM a 12:00:00 PM");
        for (WorkingDay WorkingDay : lista) {
            assertEquals(WorkingDay.getDescription(), "de 06:00:00 AM a 12:00:00 PM");
        }
    }

    @Test
    public void testFindByLikeDescription() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeDescription("%de %");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testFindByState() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByState(true);
        for (WorkingDay state : lista) {
            assertEquals(state.getState(), true);
        }

    }

    @Test
    public void testFindByAcronymsWorkingDay() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByAcronymsWorkingDay("D");
        for (WorkingDay acronimsworkingday : lista) {
            assertEquals(acronimsworkingday.getAcronymsWorkingDay(), "D");
        }
    }

    @Test
    public void testFindByLikeAcronymsWorkingDay() {
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeAcronymsWorkingDay("%D%");
        assertTrue(!lista.isEmpty());
    }
    
}
