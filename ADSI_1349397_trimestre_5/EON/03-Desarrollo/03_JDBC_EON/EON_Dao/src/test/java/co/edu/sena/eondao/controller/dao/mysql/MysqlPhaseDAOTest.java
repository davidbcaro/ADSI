package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.PhaseDAO;
import co.edu.sena.eondao.controller.factory.PhaseDAOFactory;
import co.edu.sena.eondao.controller.factory.mysql.MysqlPhaseDAOFactory;
import co.edu.sena.eondao.modelo.dto.PhaseDTO;
import co.edu.sena.eondao.modelo.dto.PhasePKDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlPhaseDAOTest {

    private PhaseDTO phase;
    private PhaseDTO phase2;
    private PhasePKDTO llave;
    private PhasePKDTO llave2;

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
        phase.setNamePhase("senol");
        phase.setState(Boolean.TRUE);
        phase.setProjectCode("576887");

        phase2 = new PhaseDTO();
        phase2.setNamePhase("senolo");
        phase2.setState(Boolean.TRUE);
        phase2.setProjectCode("13");

        llave = new PhasePKDTO();
        llave.setPhaseName("senol");
        llave.setProjectCode("576887");
        
        llave2 = new PhasePKDTO();
        llave2.setPhaseName("senolo");
        llave2.setProjectCode("13");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Insert");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.insert(phase), 1);
    }

    @Test
    public void test2FindPk() {
        System.out.println("Busqueda");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        PhaseDTO resultado = dao.findPk(llave);
        assertEquals(resultado, phase);
    }

    @Test
    public void test3Update() {
        System.out.println("Update");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.update(phase2, llave), 1);
    }

  

    @Test
    public void test4FindAll() {
        System.out.println("FindAll");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        List<PhaseDTO> resultado = (List<PhaseDTO>) dao.findAll();
        assertTrue(!resultado.isEmpty());

    }
      @Test
    public void test5Delete() {
        System.out.println("Delete");
        PhaseDAOFactory factory = new MysqlPhaseDAOFactory();
        PhaseDAO dao = factory.create();
        assertEquals(dao.delete(llave2), 1);
    }

}
