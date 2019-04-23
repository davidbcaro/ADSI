/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.PhaseDAO;
import co.edu.sena.daowariosoft.model.dto.PhaseDTO;
import co.edu.sena.daowariosoft.model.dto.PhasePkDTO;


import co.edu.sena.daowariosoft.controller.factory.mysql.MysqlPhaseDAOFactory;
import co.edu.sena.daowariosoft.controller.factory.PhaseDAOFactory;


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
 * @author SENA
 */
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlPhaseDAOTest {

private PhaseDTO phase;
private PhaseDTO phase2;
private PhasePkDTO llave;
private PhasePkDTO llave2;

    public MysqlPhaseDAOTest() {
    
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    phase = new PhaseDTO();
    phase.setNamePhase("Phase1");
    phase.setProjectCode("1234");
    phase.setState(Boolean.TRUE);
    
    
    phase2 = new PhaseDTO();
    phase2.setNamePhase("Phase2");
    phase2.setProjectCode("2356");
    phase2.setState(false);
    
    llave = new PhasePkDTO();
    llave.setNamePhase("Phase1");
    llave.setProjectCode("1234");
   
    llave2 = new PhasePkDTO();
    llave2.setNamePhase("Phase2");
    llave2.setProjectCode("2356");
    
    }
    
    @After
    public void tearDown() throws Exception {
    
    }

    /**
     * Test of insert method, of class MysqlPhaseDAO.
     */
    @Test
    public void test1Insert() {
        System.out.println("prueba del insert PhaseDAO");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.insert(phase), 1);
    }
    @Test
    public void test2FindPk() {
        System.out.println("findPk");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        PhaseDTO consulta = dao.findPk(llave);
        assertEquals(consulta, phase);

    }
     @Test
    public void test3FindAll() {
        System.out.println("findAll");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        List<PhaseDTO> consulta = (List<PhaseDTO>)dao.findAll();
        assertTrue(!consulta.isEmpty());
        
    }

    @Test
    public void test4Update() {
        System.out.println("update");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.update(phase,llave),1);
    }

    @Test
    public void test5Delete() {
        System.out.println("delete");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.delete(llave),1);
    }
}