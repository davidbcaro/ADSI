/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LearningResultDao;
import co.edu.sena.cot.controlador.factory.mysql.LearningResultFactory;
import co.edu.sena.cot.modelo.dto.LearningResult;
import co.edu.sena.cot.modelo.dto.LearningResultPK;
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
public class LearningResultImplTest {

    private LearningResult lear;
    private LearningResultPK learPK;

    public LearningResultImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        lear = new LearningResult();
        lear.setLearningResultPK(new LearningResultPK("ra12", 240201500, 228106, "v 102"));
        lear.setDescription("Hola");
        
        learPK = new LearningResultPK("RA13", 240201500, 228106, "v 102");
        

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByCode method, of class LearningResultImpl.
     */
    @Test
    public void test01Insert() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        if (dao.find(lear.getLearningResultPK()) == null) {
            dao.insert(lear);
        }
        assertEquals(dao.find(lear.getLearningResultPK()), lear);
    }

    @Test
    public void test02Find() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        LearningResult lear2 = (LearningResult) dao.find(lear.getLearningResultPK());
        assertEquals(lear2, lear);
    }

    @Test
    public void test03update() {

        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        lear.setDescription("Adios");

        dao.update(lear);
        assertEquals(dao.find(lear.getLearningResultPK()), lear);

    }

    @Test
    public void test04FindAll() {

        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println("nananana " + lista);
    }

    @Test
    public void test05FindByCode() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByCode("ra12");
        assertTrue(!lista.isEmpty());
        for (LearningResult lear : lista) {
            assertEquals(lear.getLearningResultPK().getCode(), "ra12");
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByDescription method, of class LearningResultImpl.
     */
    @Test
    public void test06FindByDescription() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByDescription("Adios");
        assertTrue(!lista.isEmpty());
        for (LearningResult lear : lista) {
            assertEquals(lear.getDescription(), "Adios");
        }
        System.out.println("names " + lista);
    }


/**
 * Test of findByCodeCompetence method, of class LearningResultImpl.
 */
@Test
        public void test07FindByCodeCompetence() {
       LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByCodeCompetence(240201500);
        assertTrue(!lista.isEmpty());
        for (LearningResult lear : lista) {
            assertEquals(lear.getLearningResultPK().getCodeCompetence(), 240201500);
        }
        System.out.println("names "+lista);
    
    }

    /**
     * Test of findByCodeProgram method, of class LearningResultImpl.
     */
    @Test
        public void test08FindByCodeProgram() {
          LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByCodeProgram(228106);
        assertTrue(!lista.isEmpty());
        for (LearningResult lear : lista) {
            assertEquals(lear.getLearningResultPK().getCodeProgram(), 228106);
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByEdition method, of class LearningResultImpl.
     */
    @Test
        public void test09FindByEdition() {
         LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByEdition("v 102");
        assertTrue(!lista.isEmpty());
        for (LearningResult lear : lista) {
            assertEquals(lear.getLearningResultPK().getEdition(), "v 102");
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByLikeCode method, of class LearningResultImpl.
     */
    @Test
        public void test10FindByLikeCode() {
       System.out.println("lassssss");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeCode("%r%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeDescription method, of class LearningResultImpl.
     */
    @Test
        public void test11FindByLikeDescription() {
        System.out.println("lassssss");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeDescription("%A%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCodeCompetence method, of class LearningResultImpl.
     */
    @Test
        public void test12FindByLikeCodeCompetence() {
       System.out.println("lassssss");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeCodeCompetence("%2%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCodeProgram method, of class LearningResultImpl.
     */
    @Test
        public void test13FindByLikeCodeProgram() {
         System.out.println("lassssss");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeCodeProgram("%2%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeEdition method, of class LearningResultImpl.
     */
    @Test
        public void test14FindByLikeEdition() {
     System.out.println("lassssss");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeEdition("%102%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of updatePrimaryKey method, of class LearningResultImpl.
     */
    @Test
        public void test15UpdatePrimaryKey() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        dao.updatePrimaryKey(learPK, lear.getLearningResultPK());
        lear.setLearningResultPK(learPK);
        assertEquals(dao.find(learPK), lear);
    }
        
    @Test
    public void test16delete() {
        
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        lear.setLearningResultPK(new LearningResultPK("RA13", 240201500, 228106, "v 102"));
        dao.remove(lear);
        assertEquals(dao.find(lear.getLearningResultPK()), null);

    }
    
}
