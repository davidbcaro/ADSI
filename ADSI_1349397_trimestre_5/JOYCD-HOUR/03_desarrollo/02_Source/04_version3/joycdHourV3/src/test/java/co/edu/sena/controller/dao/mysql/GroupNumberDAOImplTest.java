/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.GroupNumberDAO;
import co.edu.sena.controller.factory.GroupNumberFactory;
import co.edu.sena.model.jpa.entities.GroupNumber;
import co.edu.sena.model.jpa.entities.Program;
import co.edu.sena.model.jpa.entities.StatusGroupNumber;
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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Chritian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupNumberDAOImplTest {

    private GroupNumber groupNumber;

    public GroupNumberDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        groupNumber = new GroupNumber();

        groupNumber.setGroupsNumber("adsis");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "21-12-2016 6:00:00";
        String dateInString2 = "21-12-2018 12:00:00";
        Date date = sdf.parse(dateInString);
        Date date2 = sdf.parse(dateInString2);
        groupNumber.setStartDate(date);
        groupNumber.setFinishDate(date2);

        groupNumber.setRoute("2-H");
        groupNumber.setProgram(new Program("228106", "Version 102"));
        groupNumber.setStatusGroupNumber(new StatusGroupNumber("en formacion"));

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of findByGroupsNumber method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test01Insert() {

        System.out.println("Prueba insert de groupnumber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        if (dao.find(groupNumber.getGroupsNumber()) == null) {
            dao.insert(groupNumber);
        }
        assertEquals(dao.find(groupNumber.getGroupsNumber()), groupNumber);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba insert de groupnumber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        GroupNumber groupNumberconsulta = (GroupNumber) dao.find(groupNumber.getGroupsNumber());
        assertEquals(groupNumberconsulta, groupNumber);
    }

    @Test
    public void test03update() throws ParseException {
        System.out.println("Prueba update de groupnumber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);       
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "21-12-2016 6:00:00";
        String dateInString2 = "21-12-2018 12:00:00";
        Date date = sdf.parse(dateInString);
        Date date2 = sdf.parse(dateInString2);
        groupNumber.setStartDate(date);
        groupNumber.setFinishDate(date2);
        groupNumber.setRoute("2-H");
        groupNumber.setProgram(new Program("2281064", "Version 101"));
        groupNumber.setStatusGroupNumber(new StatusGroupNumber("inactivo"));

        dao.update(groupNumber);
        assertEquals(dao.find(groupNumber.getGroupsNumber()), groupNumber);
    }

    @Test
    public void test04FindByGroupsNumber() {
        System.out.println("Prueba groupnumber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByGroupsNumber("12345");
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getGroupsNumber(), "12345");
        }
        System.out.println(lista);
    }

    /**
     * Test of findByStartDate method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test05FindByStartDate() throws ParseException {
        System.out.println("Prueba group number date start");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "21-12-2016 6:00:00";
        Date date = sdf.parse(dateInString);
        List<GroupNumber> lista = dao.findByStartDate(date);
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getStartDate(), date);
        }
        System.out.println(lista);
    }

    /**
     * Test of findByFinishDate method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test06FindByFinishDate() throws ParseException {
        System.out.println("Prueba groupnumber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString2 = "21-12-2018 12:00:00";
        Date date2 = sdf.parse(dateInString2);
        List<GroupNumber> lista = dao.findByFinishDate(date2);
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getFinishDate(), date2);
        }
        System.out.println(lista);
    }

    /**
     * Test of findByRoute method, of class GroupNumberDAOImpl.
     */
//    @Test
//    public void testFindByRoute() {
//        System.out.println("Prueba group number route ");
//        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
//        List<GroupNumber> lista = dao.findByRoute("2-j");
//        for (GroupNumber groupNumber : lista) {
//            assertEquals(groupNumber.getRoute(), "2-j");
//        }
//        System.out.println(lista);
//    }

    /**
     * Test of findByProgramCode method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test07FindByProgramCode() {
        System.out.println("Prueba group number program code");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByProgramCode("228106");
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getProgram().getProgramPK().getProgramCode(), "228106");
        }
        System.out.println(lista);
    }

    /**
     * Test of findByVersionCode method, of class GroupNumberDAOImpl.
     */
    /////////////////////////////////////////// 
    //duda
    @Test
    public void test08FindByVersionCode() {
        System.out.println("Prueba group number version code");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByVersionCode("Version 102");
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getProgram().getProgramPK().getVersion(), "Version 102");
        }
        System.out.println(lista);
    }

    /**
     * Test of findByStatusGroupNumber method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test09FindByStatusGroupNumber() {
        System.out.println("Prueba group number status group number");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByStatusGroupNumber("inactivo");
        for (GroupNumber groupNumber : lista) {
            assertEquals(groupNumber.getStatusGroupNumber(), "inactivo");
        }
        System.out.println(lista);
    }

    /**
     * Test of findByLikeGroupsNumber method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test10FindByLikeGroupsNumber() {
        System.out.println("Prueba group number status like group number ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByLikeGroupsNumber("%3%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeProgramCode method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test11FindByLikeProgramCode() {
        System.out.println("Prueba group number status like program code ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByLikeProgramCode("%8%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeVersionCode method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test12FindByLikeVersionCode() {
        System.out.println("Prueba group number status like version code ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByLikeVersionCode("% 1%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeStatusGroupNumber method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test13FindByLikeStatusGroupNumber() {
        System.out.println("Prueba group number status like status group number ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findByLikeStatusGroupNumber("%a%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of updatePrimaryKey method, of class GroupNumberDAOImpl.
     */
    @Test
    public void test14UpdatePrimaryKey() {
        System.out.println("test update primary key to group numnber");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        int resultado = dao.updatePrimaryKey("1234567", groupNumber.getGroupsNumber());
       

        assertEquals(resultado, 1);
    }

    @Test
    public void test15FindAll() {
        System.out.println("Preba test FindAll ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        List<GroupNumber> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }

    @Test
    public void Test16Delete() {
        System.out.println("Preba test delete ");
        GroupNumberDAO dao = GroupNumberFactory.create(GroupNumber.class);
        groupNumber.setGroupsNumber("1234567");
        dao.remove(groupNumber);
        assertEquals(dao.find(groupNumber.getGroupsNumber()), null);
    }

}
