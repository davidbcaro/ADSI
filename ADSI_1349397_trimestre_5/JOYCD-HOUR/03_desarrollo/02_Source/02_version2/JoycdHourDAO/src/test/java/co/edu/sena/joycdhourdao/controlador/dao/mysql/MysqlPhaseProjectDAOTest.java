/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.PhaseProjectDAO;
import co.edu.sena.joycdhourdao.controlador.factory.PhaseProjectDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlPhaseProjectDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectDTO;
import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectPkDTO;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlPhaseProjectDAOTest {
     private PhaseProjectDTO phase;
    private PhaseProjectDTO phase2;
    private PhaseProjectPkDTO key;
    private PhaseProjectPkDTO key2;
    
    public MysqlPhaseProjectDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        phase = new PhaseProjectDTO();
        phase.setNamephase("Fasesita");
        phase.setStatusphase("Activo");
        phase.setProjectcode("123");
        

        key = new PhaseProjectPkDTO();
        key.setNamephase("Fasesita");
        key.setProjectcode("123");

        phase2 = new PhaseProjectDTO();
        phase2.setNamephase("Fasesota");
        phase2.setStatusphase("Inactiva");
        phase2.setProjectcode("321");
        
        key2 = new PhaseProjectPkDTO();
        key2.setNamephase("Fasesota");
        key2.setProjectcode("321");
 
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1insert() {
        System.out.println("prueba de insert de projectDAO");
        PhaseProjectDAOFactory factory = new MysqlPhaseProjectDAOFactory();
        PhaseProjectDAO dao = factory.create();
        dao.insert(phase);

    }
    @Test
    public void test2findPk() {
        PhaseProjectDAOFactory factory = new MysqlPhaseProjectDAOFactory();
        PhaseProjectDAO dao = factory.create();
        PhaseProjectDTO find = dao.findPk(key);
        assertEquals(find, phase);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba de update de ProjectDAO");
        PhaseProjectDAOFactory factory = new MysqlPhaseProjectDAOFactory();
        PhaseProjectDAO dao = factory.create();
        assertEquals(dao.update(phase2, key), 1);
    }

    @Test
    public void test4FindAll() {
        System.out.println("findAll");
        PhaseProjectDAOFactory factory = new MysqlPhaseProjectDAOFactory();
        PhaseProjectDAO dao = factory.create();
        List<PhaseProjectDTO> consulta = (List<PhaseProjectDTO>) dao.findAll();
        System.out.println(consulta);
        assertTrue(!consulta.isEmpty());

    }

    @Test
    public void test5Delete() {
        System.out.println("prueba de update de projectDao");
        PhaseProjectDAOFactory factory = new MysqlPhaseProjectDAOFactory();
        PhaseProjectDAO dao = factory.create();
        assertEquals(dao.delete(key2), 1);
    }

}

