/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.PhaseDao;
import co.edu.sena.cot.controlador.factory.mysql.PhaseFactory;
import co.edu.sena.cot.modelo.dto.Phase;
import co.edu.sena.cot.modelo.dto.PhasePK;
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
 * @author Camargo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhaseDaoImplTest {

    private Phase phase;
    private PhasePK phasePK;

    public PhaseDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        phase = new Phase();
        phase.setPhasePK(new PhasePK("CC", 3333));
        phase.setState(true);
        
        phasePK = new PhasePK("TI", 3333 );

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByState method, of class PhaseDaoImpl.
     */
    @Test
    public void test01Insert() {

        PhaseDao dao = PhaseFactory.create(Phase.class);
        if (dao.find(phase.getPhasePK()) == null) {
            dao.insert(phase);
        }
        assertEquals(dao.find(phase.getPhasePK()), phase);
    }
    
    @Test
    public void test02find() {

        PhaseDao dao = PhaseFactory.create(Phase.class);
        Phase tipoDocumentoConsultado = (Phase) dao.find(phase.getPhasePK());
        assertEquals(tipoDocumentoConsultado, phase);
    }
    
     @Test
    public void test03update() {

        PhaseDao dao = PhaseFactory.create(Phase.class);
        phase.setState(false);

        dao.update(phase);
        assertEquals(dao.find(phase.getPhasePK()), phase);

    }
    
    @Test
    public void test11UpdatePrimaryKey(){
      PhaseDao dao = PhaseFactory.create(Phase.class);
        dao.updatePrimaryKey(phasePK, phase.getPhasePK());
        phase.setPhasePK(phasePK);
        assertEquals(dao.find(phasePK), phase);
    }
    
     
     @Test
    public void test10delete() {
        
        PhaseDao dao = PhaseFactory.create(Phase.class);
        phase.setPhasePK(new PhasePK("CC", 12345));
        dao.remove(phase);
        assertEquals(dao.find(phase.getPhasePK()), null);

    }
    
     @Test
    public void test05FindAll() {
        
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println("nananana "+lista);
    }
    
    @Test
    public void test06FindByName() {
        
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByName("TI");
        assertTrue(!lista.isEmpty());
        for (Phase phase : lista) {
            assertEquals(phase.getPhasePK().getNamePhase(), "TI");
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }
    
     @Test
    public void test07FindByCode() {
        
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByCode(3333);
        assertTrue(!lista.isEmpty());
        for (Phase phase : lista) {
            assertEquals(phase.getPhasePK().getProjectCode(),3333);
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }
    
    
    @Test
    public void test08FindState() {
        System.out.println("las");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Phase project : lista) {
            assertEquals(project.getState(), true);
        }
        System.out.println("estados "+lista);
    }
    
    @Test
    public void test09FindLikeName() {
        System.out.println("lassssss");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByLikeName("%C%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
        
    }
    
   //  @Test
    //public void testFindLikeCode() {
      //  System.out.println("lassssss");
        //PhaseDao dao = PhaseFactory.create(Phase.class);
        //List<Phase> lista = dao.findByLikeCode("%3%");
        //assertTrue(!lista.isEmpty());
        //System.out.println("nananan "+ lista);
        
    //}


}
