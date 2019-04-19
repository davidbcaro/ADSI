/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ScheduleDAO;
import co.edu.sena.controller.factory.ScheduleFactory;
import co.edu.sena.model.jpa.entities.Modality;
import co.edu.sena.model.jpa.entities.Schedule;
import co.edu.sena.model.jpa.entities.SchedulePK;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author liosalfar
 */
public class ScheduleDAOImplTest {

    private Schedule sch;
    private SchedulePK schpk;

    public ScheduleDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {

        sch = new Schedule();
        sch.setHourStart("6:00");
        sch.setHourEnd("2:00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        sch.setScheduleFinish(date);
        sch.setSchedulePK(new SchedulePK(102, "Trimestre 3", "200", "sede barrio colombia", "Martes", "123456789", "CC", "1349397", "Trimestre 3", "D", "Tecnologo"));
        sch.setNameModality(new Modality("Presencial"));

        schpk = new SchedulePK(102, "Trimestre 3", "200", "sede barrio colombia", "Martes", "123456789", "CC", "1349397", "Trimestre 3", "D", "Tecnologo");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByHourStart method, of class ScheduleDAOImpl.
     */
    @Test
    public void test001Insert() {

        System.out.println("Prueba insert de Schedule");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        if (dao.find(sch.getSchedulePK()) == null) {
            dao.insert(sch);
        }
        assertEquals(dao.find(sch.getSchedulePK()), sch);
    }

    @Test
    public void test002Find() {
        System.out.println("Prueba consulta Schedule");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        Schedule schconsulta = (Schedule) dao.find(sch.getSchedulePK());
        assertEquals(schconsulta, sch);
    }

    @Test
    public void test003update() throws ParseException {
        System.out.println("Update datos");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        sch.setHourStart("9:45");
        sch.setHourEnd("9:46");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "13-10-2010 12:38:56";
        Date date = sdf.parse(dateInString);
        sch.setScheduleFinish(date);
        sch.setNameModality(new Modality("Virtual"));
        dao.update(sch);
        assertEquals(dao.find(sch.getSchedulePK()), sch);
    }

    @Test
    public void test004vupdatePrimaryKey() {
        System.out.println("Update primarykey");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        dao.updatePrimaryKey(schpk, sch.getSchedulePK());
        sch.setSchedulePK(schpk);
        assertEquals(dao.find(schpk), sch);
    }

    // pruebas findby
    @Test
    public void test005FindByVersion() {
        System.out.println("Busqueda  version");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByVersion(102);
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getVersion(), 102);
        }
        System.out.println(lista);
    }

    @Test
    public void test006findByVersionActualityTrimester() {
        System.out.println("Busqueda  trimestre actual");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByVersionActualityTrimester("Trimestre 3");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getVersionActualityTrimester(), "Trimestre 3");
        }
        System.out.println(lista);
    }

    @Test
    public void test007findByNumberEnvironment() {
        System.out.println("Busqueda  numero de ambiente");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByNumberEnvironment("200");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getNumberEnvironment(), "200");
        }
        System.out.println(lista);
    }

    @Test
    public void test008findByHeadquartersName() {
        System.out.println("Busqueda sede");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByHeadquartersName("sede barrio colombia");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getHeadquartersName(), "sede barrio colombia");
        }
        System.out.println(lista);
    }

    @Test
    public void test009findByNameDay() {
        System.out.println("Busqueda Nombre del dia");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByNameDay("Lunes");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getNameDay(), "Lunes");
        }
        System.out.println(lista);
    }

    @Test
    public void test010findByDocumentType() {
        System.out.println("Busqueda numero de documento");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByDocumentType("8013833");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getDocumentType(), "8013833");
        }
        System.out.println(lista);
    }

    @Test
    public void test011findByIdentificationCardNumber() {
        System.out.println("Busqueda like tarjeta de identificacion");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByIdentificationCardNumber("CC");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getIdentificationCardNumber(), "CC");
        }
        System.out.println(lista);
    }

    @Test
    public void test012findByGroupsNumber() {
        System.out.println("Busqueda ficha");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByGroupsNumber("1349397");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getGroupsNumber(), "1349397");
        }
        System.out.println(lista);
    }

    @Test
    public void test013findByTrimesterName() {
        System.out.println("Busqueda trimestre ");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByTrimesterName("Trimestre 3");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getTrimesterName(), "Trimestre 3");
        }
        System.out.println(lista);
    }

    @Test
    public void test014findByWorkingDayInitials() {
        System.out.println("Busqueda incial");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByWorkingDayInitials("D");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getWorkingDayInitials(), "D");
        }
        System.out.println(lista);
    }

    @Test
    public void test015findByLevelFormation() {
        System.out.println("Busqueda nivel de formacion");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        List<Schedule> lista = dao.findByLevelFormation("Tecnologo");
        for (Schedule version : lista) {
            assertEquals(version.getSchedulePK().getLevelFormation(), "Tecnologo");
        }
        System.out.println(lista);
    }


    // delete de ultimas 
    @Test
    public void test017delete() {
        System.out.println("Prueba del Delete");
        ScheduleDAO dao = ScheduleFactory.create(Schedule.class);
        sch.setSchedulePK(new SchedulePK(102, "Trimestre 3", "200", "sede barrio colombia", "Martes", "123456789", "CC", "1349397", "Trimestre 3", "D", "Tecnologo"));
        dao.remove(sch);
        assertEquals(dao.find(sch.getSchedulePK()), null);
    }

}
