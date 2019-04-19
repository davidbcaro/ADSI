/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.EnvironmentDAO;
import co.edu.sena.joycdhourdao.controlador.factory.EnvironmentDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlEnvironmentDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentDTO;
import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentPKDTO;
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
 * @author liosalfar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlEnvironmentDAOTest {

    private EnvironmentDTO env;
    private EnvironmentDTO env2;
    private EnvironmentPKDTO llave;
    private EnvironmentPKDTO llave2;

    public MysqlEnvironmentDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        env = new EnvironmentDTO();
        env.setNumberEnvironment(300);
        env.setDescription("ambiente con pcs y sillas");
        env.setStatus(true);
        env.setHeadquartersName("complejo sur");

        env2 = new EnvironmentDTO();
        env2.setNumberEnvironment(301);
        env2.setDescription("ambiente con pcs y sillas *2");
        env2.setStatus(true);
        env2.setHeadquartersName("complejo sur");

        llave = new EnvironmentPKDTO();
        llave.setNumberEnvironment(300);
        llave.setHeadquartersName("conplejo sur");

        llave2 = new EnvironmentPKDTO();
        llave2.setNumberEnvironment(301);
        llave2.setHeadquartersName("conplejo sur");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlEnvironmentDAO.
     */
    @Test
    public void test1Insert() {

        System.out.println("prueba del insert de EnvironmentDAO");
        EnvironmentDAOFactory factory = new MysqlEnvironmentDAOFactory();
        EnvironmentDAO dao = factory.create();
        assertEquals(dao.insert(env), 1);

    }

    /**
     * Test of update method, of class MysqlEnvironmentDAO.
     */
    @Test
    public void test2Update() {
        System.out.println("prueba del update de EnvironmentDAO");
        EnvironmentDAOFactory factory = new MysqlEnvironmentDAOFactory();
        EnvironmentDAO dao = factory.create();
        assertEquals(dao.update(env2, llave), 1);
    }

    /**
     * Test of delete method, of class MysqlEnvironmentDAO.
     */
    @Test
    public void test5Delete() {
        System.out.println("prueba del delete de clienteDAo");
        EnvironmentDAOFactory factory = new MysqlEnvironmentDAOFactory();
        EnvironmentDAO dao = factory.create();
        assertEquals(dao.delete(llave2), 1);
    }

    /**
     * Test of findAll method, of class MysqlEnvironmentDAO.
     */
    @Test
    public void test4FindAll() {
        System.out.println("prueba del select * de clienteDAo");
        EnvironmentDAOFactory factory = new MysqlEnvironmentDAOFactory();
        EnvironmentDAO dao = factory.create();
        List<EnvironmentDTO> consulta = (List<EnvironmentDTO>) dao.findAll();
        assertTrue(!consulta.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlEnvironmentDAO.
     */
    @Test
    public void test3FindPk() {

        System.out.println("prueba del búsqueda llave primaria de clienteDAo");
        EnvironmentDAOFactory factory = new MysqlEnvironmentDAOFactory();
        EnvironmentDAO dao = factory.create();
        EnvironmentDTO consulta = dao.findPk(llave);
        assertEquals(consulta, env);

    }

}
