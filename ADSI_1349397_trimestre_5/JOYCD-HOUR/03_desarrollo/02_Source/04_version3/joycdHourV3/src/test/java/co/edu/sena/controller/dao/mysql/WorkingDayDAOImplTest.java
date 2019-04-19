/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.WorkingDayDAO;
import co.edu.sena.controller.factory.WorkingDayFactory;
import co.edu.sena.model.jpa.entities.WorkingDay;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class WorkingDayDAOImplTest {

    private WorkingDay wor;

    public WorkingDayDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        wor = new WorkingDay();
        wor.setInitials("DT");
        wor.setName("diaTrabajo");
        wor.setDescription("des");

        wor.setStatus(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de WorkingDay");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        if (dao.find(wor.getInitials()) == null) {
            dao.insert(wor);

        }
        assertEquals(dao.find(wor.getInitials()), wor);

    }

    @Test
    public void test2find() {

        System.out.println("Prueba consulta WorkingDay");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        WorkingDay workingdayconsulta = (WorkingDay) dao.find(wor.getInitials());
        assertEquals(workingdayconsulta, wor);
    }

    @Test
    public void test3update() {
        System.out.println("Prueba del Update");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        wor.setName("diaTrabajo3");
        wor.setDescription("des4");
        wor.setStatus(false);
        dao.update(wor);
        assertEquals(dao.find(wor.getInitials()), wor);
    }

    @Test
    public void test4UpdatePrimaryKey() {
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        int resultado = dao.updatePrimaryKey("dt123", wor.getInitials());
        assertEquals(resultado, 1);
    }

    @Test
    public void test5Delete() {
        System.out.println("Prueba del Delete");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        wor.setInitials("dt123");
        dao.remove(wor);
        assertEquals(dao.find(wor.getInitials()), null);
    }

    @Test
    public void test6FindByInitials() {
        System.out.println("prueba de  metodo findByInitials");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByInitials("D");
        assertTrue(!lista.isEmpty());
        for (WorkingDay wor : lista) {
            assertEquals(wor.getInitials(), "D");
        }
    }

    @Test
    public void test7FindByName() {
        System.out.println("prueba de  metodo findByName");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByName("Diurno");
         assertTrue(!lista.isEmpty());
        for (WorkingDay wor : lista) {
            assertEquals(wor.getName(), "Diurno");
        }
    }

    @Test
    public void test8FindByDescription() {
        System.out.println("prueba de  metodo findByDescription");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByDescription("la jornada diurna tendra una disponibilidad de 6:00 am a 6:00 pm");
         assertTrue(!lista.isEmpty());
        for (WorkingDay wor : lista) {
            assertEquals(wor.getDescription(), "la jornada diurna tendra una disponibilidad de 6:00 am a 6:00 pm");
        }
    }

    @Test
    public void test8FindByStatus() {
        System.out.println("prueba de  metodo findByStatus");
        WorkingDayDAO dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByStatus(true);
         assertTrue(!lista.isEmpty());
        for (WorkingDay wor : lista) {
            assertEquals(wor.getStatus(), (true));
        }
    }


    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kintmas");
        EntityManager em = emf.createEntityManager();
        System.out.println("dfg");

    }

}
