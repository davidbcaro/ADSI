/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.WorkingDayDao;
import co.edu.sena.tidsplanjpa.controller.factory.WorkingDayFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.WorkingDay;
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
 * @author Miguel
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkingDayDaoImplTest {
    WorkingDay wd;
    public WorkingDayDaoImplTest() {
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
        wd.setInitials("WOD");
        wd.setName("Dia1");
        wd.setDescription("Este es el dia 1");
        wd.setImage(null);
        wd.setStatus(false);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void test01Insert() {
        System.out.println("Prueba de Jornada metodo insert");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        if (dao.find(wd.getInitials()) == null) {
            dao.insert(wd);

        }
        assertEquals(dao.find(wd.getInitials()), wd);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba de Jornada metodo find");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        WorkingDay WorkingDayConsulted = (WorkingDay) dao.find(wd.getInitials());
        assertEquals(WorkingDayConsulted, wd);
    }

    @Test
    public void test03Update() {
        System.out.println("prueba de Jornada metodo update");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setDescription("Description");
        wd.setStatus(Boolean.TRUE);
        dao.update(wd);
        assertEquals(dao.find(wd.getInitials()), wd);
    }

    @Test
    public void test04updatePrimaryKey() {
        System.out.println("prueba de Jornada metodo update por llave primaria");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        int resultado = dao.updatePrimaryKey("WWW", wd.getInitials());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05delete() {
        System.out.println("prueba de tipo de Jornada delete para la llave primaria");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        wd.setInitials("WWW");
        dao.remove(wd);
        assertEquals(dao.find(wd.getInitials()), null);

    }


    @Test
    public void test07FindByLikeInitials() {
         System.out.println("Prueba de Jornada metodo findByLikeNameState");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByLikeInitials("%F%");
        assertTrue(!list.isEmpty());
        for (WorkingDay stateGroup : list) {
            System.out.println(stateGroup);
        }
    }

  
    @Test
    public void test08FindByInitials() {
        System.out.println("Prueba de Jornada metodo FindByInitials");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByInitials("D");
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            assertEquals(workingDay.getInitials(), "D");
        }

    }

    
    @Test
    public void test09FindByLikeName() {
        System.out.println("Prueba de Jornada metodo FindByLikeName");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByLikeName("%r%");
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            System.out.println(workingDay);
        }
    }
    

    @Test
    public void test10FindByName() {
        System.out.println("Prueba de Jornada metodo FindByName");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByName("Diurna");
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            assertEquals(workingDay.getName(), "Diurna");
        }
    }

    /**
     * Test of findByLikeDescription method, of class WorkingDayDaoImpl.
     */
    @Test
    public void test11FindByLikeDescription() {
        System.out.println("Prueba de Jornada metodo FindByLikeDescription");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByLikeDescription("%semana%");
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            System.out.println(workingDay);
        }
    }

    /**
     * Test of findByDescription method, of class WorkingDayDaoImpl.
     */
    @Test
    public void test12FindByDescription() {
        System.out.println("Prueba de Jornada metodo FindByDescription");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByDescription("Jornada Nocturna de 6:00 PM a 10:00 PM");
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            assertEquals(workingDay.getDescription(), "Jornada Nocturna de 6:00 PM a 10:00 PM");
        }
    }

    @Test
    public void test13FindByStatus() {
        System.out.println("Prueba de estado de grupo metodo findByStatus");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findByStatus(true);
        assertTrue(!list.isEmpty());
        for (WorkingDay workingDay : list) {
            assertEquals(workingDay.getStatus(), true);
        }
    }
    
    @Test 
    public void test06FindAll(){
        System.out.println("Prueba de estado de grupo metodo findByStatus");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> list = dao.findAll();
        assertFalse(list.isEmpty());
        for (WorkingDay workingDay : list) {
            System.out.println(workingDay);
        }
    }
    
}
