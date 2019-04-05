/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.PhaseDAO;
import co.edu.sena.chronooftimedao.controlador.dao.ProjectDAO;
import co.edu.sena.chronooftimedao.controlador.factory.PhaseDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.ProjectDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.mysql.MysqlPhaseDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.PhaseDTO;
import co.edu.sena.chronooftimedao.modelo.dto.PhasePkDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
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
    public void setUp() {
        
        phase = new PhaseDTO();
        phase.setNamePhase("Hola");
        phase.setProjectCode((short) 12345);
        phase.setState(true);
        
        phase2 = new PhaseDTO();
        phase2.setNamePhase("nellpror");
        phase2.setProjectCode((short) 12345);
        phase2.setState(false);
        
        llave = new PhasePkDTO();
        llave.setNamePhase("Hola");
        llave.setProjectCode((short) 12345);
        
        llave2 = new PhasePkDTO();
        llave2.setNamePhase("nellpror");
        llave2.setProjectCode((short) 12345);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlPhaseDAO.
     */
    @Test
    public void testInsert() {
         System.out.println("prueba del insert de PhaseDAO");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao2 =  factory.create();
        assertEquals(dao2.insert(phase),1);
        
    }
    
   

    /**
     * Test of update method, of class MysqlPhaseDAO.
     */
    @Test
    public void testUpdate() {
        
        System.out.println("prueba del update de PhaseDAo");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao2 = factory.create();
        assertEquals(dao2.update(phase2, llave), 1);
       
    }

    /**
     * Test of delete method, of class MysqlPhaseDAO.
     */
    @Test
    public void testDelete() {
        
        System.out.println("prueba del delete de clienteDAo");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.delete(llave2),1);
       
    }

    /**
     * Test of findAll method, of class MysqlPhaseDAO.
     */
    @Test
    public void testFindAll() {
        
         System.out.println("prueba del select * de clienteDAo");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        Collection<PhaseDTO> consulta = (Collection<PhaseDTO>) dao.findAll();
        assertTrue(!consulta.isEmpty());
        
    }

    /**
     * Test of findPk method, of class MysqlPhaseDAO.
     */
    @Test
    public void testFindPk() {
        
         System.out.println("prueba del búsqueda llave primaria de clienteDAo");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        PhaseDTO consulta = dao.findPk(llave);
        assertEquals(consulta, phase);
        
    }
    
}
