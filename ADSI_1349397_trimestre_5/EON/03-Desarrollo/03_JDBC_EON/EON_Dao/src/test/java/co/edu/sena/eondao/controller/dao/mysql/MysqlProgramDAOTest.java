/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.ProgramDAO;
import co.edu.sena.eondao.controller.factory.ProgramDAOFactory;
import co.edu.sena.eondao.controller.factory.mysql.MysqlProgramDAOFactory;
import co.edu.sena.eondao.modelo.dto.ProgramDTO;
import co.edu.sena.eondao.modelo.dto.ProgramPkDTO;
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
 * @author LUISBERNARDO
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlProgramDAOTest {

    private ProgramDTO program;
    private ProgramDTO program2;
    private ProgramPkDTO llave;
    private ProgramPkDTO llave2;

    public MysqlProgramDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        program = new ProgramDTO();
        program.setCode("123455");
        program.setVersion("Prueba1");
        program.setName("Preba");
        program.setInitials("PDI3");
        program.setState(Boolean.TRUE);
        program.setTraining_Level("Tecnica");

        program2 = new ProgramDTO();
        program2.setCode("1234");
        program2.setVersion("Prueba");
        program2.setName("Preba de insert");
        program2.setInitials("PDI");
        program2.setState(Boolean.TRUE);
        program2.setTraining_Level("Tecnica");

        llave = new ProgramPkDTO();
        llave.setCode("123455");
        llave.setVersion("Prueba1");
        llave.setTraining_Level("Tecnica");

        llave2 = new ProgramPkDTO();
        llave2.setCode("1234");
        llave2.setVersion("Prueba1");
        llave2.setTraining_Level("Tecnica");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlProgramDAO.
     */
    @Test
    public void test1Insert() {
        System.out.println("Insert");
        ProgramDAOFactory factory = new MysqlProgramDAOFactory();
        ProgramDAO dao = factory.create();
        assertEquals(dao.insert(program), 1);
    }

    @Test
    public void test2FindPk() {
        System.out.println("FindPk");
        ProgramDAOFactory factory = new MysqlProgramDAOFactory();
        ProgramDAO dao = factory.create();
        ProgramDTO resultado = dao.findPk("123455");
        assertEquals(resultado, program);
    }

    @Test
    public void test3FindAll() {
        System.out.println("FindAll");
        ProgramDAOFactory factory = new MysqlProgramDAOFactory();
        ProgramDAO dao = factory.create();
        List<ProgramDTO> resultado = (List<ProgramDTO>) dao.findAll();
        assertTrue(!resultado.isEmpty());
    }

    /**
     * Test of update method, of class MysqlProgramDAO.
     */
    @Test
    public void test4Update() {
        System.out.println("Update");
        ProgramDAOFactory factory = new MysqlProgramDAOFactory();
        ProgramDAO dao = factory.create();
        assertEquals(dao.update(program, "123455"), 1);
    }

    /**
     * Test of delete method, of class MysqlProgramDAO.
     */
    @Test
    public void test5Delete() {
        System.out.println("Delete");
        ProgramDAOFactory factory = new MysqlProgramDAOFactory();
        ProgramDAO dao = factory.create();
        assertEquals(dao.delete(llave), 1);
    }

    /**
     * Test of findAll method, of class MysqlProgramDAO.
     */
    /**
     * Test of findPk method, of class MysqlProgramDAO.
     */
}
