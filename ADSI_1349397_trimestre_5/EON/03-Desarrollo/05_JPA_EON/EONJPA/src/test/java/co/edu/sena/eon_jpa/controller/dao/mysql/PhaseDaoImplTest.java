/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.PhaseDao;
import co.edu.sena.eon_jpa.controller.factory.PhaseFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Phase;
import co.edu.sena.eon_jpa.model.jpa.entities.PhasePK;

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
public class PhaseDaoImplTest {
    
    private Phase phase;
    private Phase phase2;
    private PhasePK phasePk;
    
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
        phase.setPhasePK(new PhasePK("Prueba", "5768877"));
        phase.setState(true);
        
        phasePk = new PhasePK("Update", "576887");
        
        phase2 = new Phase();
        phase2.setPhasePK(new PhasePK("Prueba2", "5768877"));
        phase2.setState(true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("Test Insert");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        dao.insert(phase);
        Phase ph1 = (Phase) dao.find(phase.getPhasePK());
        assertEquals(ph1, phase);
        
        if (dao.find(phase2.getPhasePK()) == null) {
            dao.insert(phase2);
        }
        assertEquals(dao.find(phase2.getPhasePK()), phase2);
    }

    @Test
    public void test2find() {
        System.out.println("Test Find");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        Phase Phase1 = (Phase) dao.find(phase.getPhasePK());
        assertEquals(Phase1, phase);
    }

    @Test
    public void test3update() {
        System.out.println("Test Update");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        phase.setState(false);
        dao.update(phase);
        assertEquals(dao.find(phase.getPhasePK()), phase);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        PhaseDao dao = PhaseFactory.create(Phase.class);
        dao.updatePrimaryKey(phasePk, phase.getPhasePK());
        phase.setPhasePK(phasePk);
        assertEquals(dao.find(phasePk), phase);
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        phase.setPhasePK(phasePk);
        dao.remove(phase);
        assertEquals(dao.find(phase.getPhasePK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindByNamePhase() {
        System.out.println("Test FindByNamePhase");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByNamePhase("Ejecucion");
        assertTrue(!lista.isEmpty());
        for(Phase ph1: lista){
            assertEquals(ph1.getPhasePK().getNamePhase(), "Ejecucion");
        }
    }

    @Test
    public void test6FindByState() {
        System.out.println("Test findByState");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for(Phase ph1: lista){
            assertEquals(ph1.getState(), true);
        }
    }

    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByCode("576887");
        assertTrue(!lista.isEmpty());
        for (Phase ph1 : lista) {
            assertEquals(ph1.getPhasePK().getCode(), "576887");
        }
    }

    @Test
    public void test6FindByLikeNamePhase() {
        System.out.println("Test findByLikeNamePhase");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByLikeNamePhase("%E%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test FindByLikeCode");
        PhaseDao dao = PhaseFactory.create(Phase.class);
        List<Phase> lista = dao.findByLikeCode("%5%");
        assertTrue(!lista.isEmpty());
    }    
}
