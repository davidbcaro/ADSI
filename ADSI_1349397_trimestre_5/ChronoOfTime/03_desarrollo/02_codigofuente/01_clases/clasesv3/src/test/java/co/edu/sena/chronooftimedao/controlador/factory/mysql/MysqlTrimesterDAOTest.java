/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.TrimesterDAO;
import co.edu.sena.chronooftimedao.controlador.factory.TrimesterDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.TrimesterDTO;
import co.edu.sena.chronooftimedao.modelo.dto.TrimesterPkDTO;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1349397
 */
public class MysqlTrimesterDAOTest {

    private TrimesterDTO tri;
    private TrimesterDTO tri2;
    private TrimesterPkDTO pri;
    private TrimesterPkDTO pri2;

    public MysqlTrimesterDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tri = new TrimesterDTO();
        tri.setInitials("D");
        tri.setCode("Hola");
        tri.setNumber(1);

        tri2 = new TrimesterDTO();
        tri2.setInitials("Y");
        tri2.setCode("Yahiko1");
        tri2.setNumber(8);

        pri = new TrimesterPkDTO();
        pri.setInitials("Y");
        pri.setCode("Yahiko1");
        pri.setNumber(8);

        pri2 = new TrimesterPkDTO();
        pri2.setInitials("holi");
        pri2.setCode("asg");
        pri2.setNumber(1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlTrimesterDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("prueba del insert de PhaseDAO");
        TrimesterDAOFactory factory = new MysqlTrimesterDaoFactory();
        TrimesterDAO dao2 = factory.create();
        assertEquals(dao2.insert(tri2), 1);

    }

    /**
     * Test of update method, of class MysqlTrimesterDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("prueba del update de PhaseDAo");
        TrimesterDAOFactory factory = new MysqlTrimesterDaoFactory();
        TrimesterDAO dao2 = factory.create();
        assertEquals(dao2.update(tri, pri), 1);
    }

    /**
     * Test of delete method, of class MysqlTrimesterDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("prueba del update de PhaseDAo");
         System.out.println("prueba del delete de clienteDAo");
        TrimesterDAOFactory factory = new MysqlTrimesterDaoFactory();
        TrimesterDAO dao = factory.create();
        assertEquals(dao.delete(pri2),1);
    }

    /**
     * Test of FindAll method, of class MysqlTrimesterDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("prueba del select * de clienteDAo");
        TrimesterDAOFactory factory = new MysqlTrimesterDaoFactory();
        TrimesterDAO dao = factory.create();
        Collection<TrimesterDTO> consulta = (Collection<TrimesterDTO>) dao.FindAll();
        assertTrue(!consulta.isEmpty());

    }

    /**
     * Test of findPk method, of class MysqlTrimesterDAO.
     */
    @Test
    public void testFindPk() {
         System.out.println("prueba del búsqueda llave primaria de clienteDAo");
        TrimesterDAOFactory factory = new MysqlTrimesterDaoFactory();
        TrimesterDAO dao = factory.create();
        TrimesterDTO consulta = dao.findPk(pri);
        assertEquals(consulta, tri);
    }

}
