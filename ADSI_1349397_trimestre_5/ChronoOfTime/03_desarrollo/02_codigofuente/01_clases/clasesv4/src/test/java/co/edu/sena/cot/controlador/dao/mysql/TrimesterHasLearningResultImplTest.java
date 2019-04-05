/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;


import co.edu.sena.cot.controlador.dao.TrimesterHasLearningResultDao;

import co.edu.sena.cot.controlador.factory.mysql.TrimesterHasLearningResultFactory;

import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResult;
import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResultPK;

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
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrimesterHasLearningResultImplTest {
    private TrimesterHasLearningResult triHasLear;
    private TrimesterHasLearningResultPK triHasLearPK;
    public TrimesterHasLearningResultImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        triHasLear = new TrimesterHasLearningResult();
        triHasLear.setTrimesterHasLearningResultPK(new TrimesterHasLearningResultPK(7, "D", "RAB 01", "Tecnologo", "v 102", 228106, 240201500));
        
        triHasLearPK = new TrimesterHasLearningResultPK(8, "D", "RAB 02", "Tecnologo", "v 102", 228106, 240201500);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert(){
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        if (dao.find(triHasLear.getTrimesterHasLearningResultPK()) == null) {
            dao.insert(triHasLear);
        }
        assertEquals(dao.find(triHasLear.getTrimesterHasLearningResultPK()), triHasLear);
    }
    
    @Test
    public void test02Find() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        TrimesterHasLearningResult logAuditCon = (TrimesterHasLearningResult) dao.find(triHasLear.getTrimesterHasLearningResultPK());
        assertEquals(logAuditCon, triHasLear);

    }
    
    @Test
    public void test03UpdatePK() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        dao.updatePK(triHasLearPK, triHasLear.getTrimesterHasLearningResultPK());
        triHasLear.setTrimesterHasLearningResultPK(triHasLearPK);
        assertEquals(dao.find(triHasLearPK), triHasLear);

    }
     @Test
    public void test04FindAll() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test05FindByTrimesterNumber() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByTrimesterNumber(8);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }
    
    

  
    @Test
    public void test06FindByTrimesterWDInitials() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByTriWorkInitials("D");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLevelCode method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test07FindByLevelCode() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLeveltCode("Tecnologo");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLearningCode method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test08FindByLearningCode() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLearningrCode("RAB 02");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByCodeCompetence method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test09FindByCodeCompetence() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByCompetenceCode(240201500);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByCodeProgram method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test10FindByCodeProgram() {
       TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByProgramCode(228106);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByEdition method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test11FindByEdition() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeLearningEdition("v 102");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeTrimesterNumber method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test12FindByLikeTrimesterNumber() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeTrimesterNumber("%8%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeTrimesterWDInitials method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test13FindByLikeTrimesterWDInitials() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeTriWorkInitials("%D%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLevelCode method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test14FindByLikeLevelCode() {
       TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeLeveltCode("%T%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLearningCode method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test15FindByLikeLearningCode() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeLearningrCode("%R%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCodeCompetence method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test16FindByLikeCodeCompetence() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeCompetenceCode("%2%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCodeProgram method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test17FindByLikeCodeProgram() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeProgramCode("%2%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeEdition method, of class TrimesterHasLearningResultImpl.
     */
    @Test
    public void test18FindByLikeEdition() {
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        List<TrimesterHasLearningResult> lista = dao.findByLikeLearningEdition("%v%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
    
    @Test
    public void test19Delete(){
        TrimesterHasLearningResultDao dao = TrimesterHasLearningResultFactory.create(TrimesterHasLearningResult.class);
        triHasLear.setTrimesterHasLearningResultPK(new TrimesterHasLearningResultPK(8, "D", "RAB 02", "Tecnologo", "v 102", 228106, 240201500));
        dao.remove(triHasLear);
        assertEquals(dao.find(triHasLear.getTrimesterHasLearningResultPK()), null);
        }

    /**
     * Test of updatePrimaryKey method, of class TrimesterHasLearningResultImpl.
     */
    
    
    
}
