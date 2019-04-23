/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.WorkingDayFactory;
import co.edu.sena.wariosoftjpa.controller.dao.WorkingDayDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay;
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
        wd.setInitialsWorkingDay("M");
        wd.setName("Mediodia");
        wd.setDescription("Es un  horario con disponibilidad de 12:00pm a 1:00pm");
        wd.setState(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba de metodo insert en Working por llavePrimaria");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        if (dao.find(wd.getInitialsWorkingDay()) == null) {
            dao.insert(wd);
        }
        assertEquals(dao.find(wd.getInitialsWorkingDay()), wd);
    }

    @Test
    public void test2Find() {
        System.out.println("Prueba de metodo find en WorkingDay por llavePrimaria");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        WorkingDay workingdayConsulta = (WorkingDay) dao.find(wd.getInitialsWorkingDay());
        assertEquals(workingdayConsulta, wd);
    }

    @Test
    public void test3Update() {
        System.out.println("update");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setName("Medianoche");
       
        dao.update(wd);
        assertEquals(dao.find(wd.getInitialsWorkingDay()), wd);
    }

    @Test
    public void test3UpdatePrimaryKey() {
        System.out.println("updatePrimaryKey");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        int resultado = dao.updatePrimaryKey("Med", wd.getInitialsWorkingDay());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4Remove() {
        System.out.println("remove");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setInitialsWorkingDay("Med");
        dao.remove(wd);
        assertEquals(dao.find(wd.getInitialsWorkingDay()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("FindAll");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByInitialsWorkingDay() {
        System.out.println("findByInitialsWorkingDay");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByInitialsWorkingDay("D");
        assertTrue(!lista.isEmpty());
        for (WorkingDay workingday : lista) {
            assertEquals(workingday.getInitialsWorkingDay(), "D");
        }
    }

    @Test
    public void test7FindByName() {
        System.out.println("findByName");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByName("Diurno");
        assertTrue(!lista.isEmpty());
        for (WorkingDay workingday : lista) {
            assertEquals(workingday.getName(), "Diurno");
        }
    }

    @Test
    public void test8FindByDescription() {
        System.out.println("findByDescription");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByDescription("Es un horario con disponibilidad de 6 am-6 pm");
        assertTrue(!lista.isEmpty());
        for (WorkingDay workingday : lista) {
            assertEquals(workingday.getDescription(), "Es un horario con disponibilidad de 6 am-6 pm");
        }
    }

    @Test
    public void test9FindByState() {
        System.out.println("findByState");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (WorkingDay workingday : lista) {
            assertEquals(workingday.getState(), true);
        }
    }

    @Test
    public void test10FindByLikeInitialsWorkingDay() {
        System.out.println("findByLikeInitialsWorkingDay");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
         List<WorkingDay> lista = dao.findByLikeInitialsWorkingDay("%D");
        assertTrue(!lista.isEmpty());
        
    }

    

}
