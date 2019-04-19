/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.DayDAO;
import co.edu.sena.joycdhourdao.controlador.factory.DayDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlDayDAOFactry;
import co.edu.sena.joycdhourdao.modelo.dto.DayDTO;
import java.util.Collection;
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
public class MysqlDayDAOTest {
    
    private DayDTO day;
    private DayDTO day2;


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

        day = new DayDTO();
        day.setNameDay("jueves");
        day.setStatus(true);

        day2 = new DayDTO();
        day2.setNameDay("viernes");
        day2.setStatus(true);

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
        DayDAOFactory factory = new MysqlDayDAOFactry();
        DayDAO dao = factory.create();
        assertEquals(dao.insert(day), 1);
    }

    /**
     * Test of update method, of class MysqlDayDAO.
     */
    @Test
    public void test2Update() {

        System.out.println("Prueba deDayDAO update");
        DayDAOFactory factory = new MysqlDayDAOFactry();
        DayDAO dao = factory.create();
        assertEquals(dao.update(day2,"jueves"),1);
    }

    /**
     * Test of delete method, of class MysqlDayDAO.
     */
    @Test
    public void test5Delete() {
  
        System.out.println("Prueba deDayDAO delete ");
        DayDAOFactory factory = new MysqlDayDAOFactry();
        DayDAO dao = factory.create();
        assertEquals(dao.delete("viernes"),1);
        
    }

    /**
     * Test of findAll method, of class MysqlDayDAO.
     */
    @Test
    public void test4FindAll() {
        System.out.println("Prueba findAll");
        DayDAOFactory factory = new MysqlDayDAOFactry();
        DayDAO dao = factory.create();
        List<DayDTO> lista=(List<DayDTO>)dao.findAll();  
        System.out.println(lista);
       assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlDayDAO.
     */
    @Test
    public void test3FindPk() {
        System.out.println("findPK");
        DayDAOFactory factory = new MysqlDayDAOFactry();
         DayDAO dao = factory.create();
         DayDTO respuesta = dao.findPk("viernes");
         assertEquals(respuesta,day2);
    }
    
}
