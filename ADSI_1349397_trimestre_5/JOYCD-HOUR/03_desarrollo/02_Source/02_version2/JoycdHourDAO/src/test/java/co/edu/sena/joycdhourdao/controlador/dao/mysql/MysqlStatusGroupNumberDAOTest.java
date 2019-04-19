/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.StatusGroupNumberDAO;
import co.edu.sena.joycdhourdao.controlador.factory.StatusGroupNumberDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlDayDAOFactry;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlStatusGroupNumberDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.StatusGroupNumberDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlStatusGroupNumberDAOTest {

    private StatusGroupNumberDTO statusgroup;
    private StatusGroupNumberDTO statusgroup2;
  private StatusGroupNumberDTO key;
    //No se utiliza 
    @BeforeClass
    public static void setUpClass() {
    }

    // no se utiliza
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        statusgroup = new StatusGroupNumberDTO();
        statusgroup.setStatusname("activo");
        statusgroup.setStatus(true);

        statusgroup2 = new StatusGroupNumberDTO();
        statusgroup2.setStatusname("inactivo");
        statusgroup2.setStatus(true);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlDayDAO.
     */
    @Test
    public void test1Insert() {

        System.out.println("Prueba de DayDAO insert");
        StatusGroupNumberDAOFactory factory = new MysqlStatusGroupNumberDAOFactory();
        StatusGroupNumberDAO dao = factory.create();
        assertEquals(dao.insert(statusgroup), 1);
    }

    @Test
    public void test2FindPk() {
        System.out.println("findPK");
        StatusGroupNumberDAOFactory factory = new MysqlStatusGroupNumberDAOFactory();
        StatusGroupNumberDAO dao = factory.create();
        StatusGroupNumberDTO respuesta = dao.findPk("activo");
        assertEquals(respuesta, statusgroup);
    }

    @Test
    public void test3Update() {

        System.out.println("Prueba de DayDAO update");
        StatusGroupNumberDAOFactory factory = new MysqlStatusGroupNumberDAOFactory();
        StatusGroupNumberDAO dao = factory.create();
        assertEquals(dao.update(statusgroup2, "activo"), 1);
    }


    @Test
    public void test5Delete() {

        System.out.println("Prueba deDayDAO delete ");
        StatusGroupNumberDAOFactory factory = new MysqlStatusGroupNumberDAOFactory();
        StatusGroupNumberDAO dao = factory.create();
        assertEquals(dao.delete("inactivo"), 1);

    }

    /**
     * Test of findAll method, of class MysqlDayDAO.
     */
    @Test
    public void test4FindAll() {
        System.out.println("Prueba findAll");
        StatusGroupNumberDAOFactory factory = new MysqlStatusGroupNumberDAOFactory();
        StatusGroupNumberDAO dao = factory.create();
        List<StatusGroupNumberDTO> lista = (List<StatusGroupNumberDTO>) dao.findAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());
    }

}
