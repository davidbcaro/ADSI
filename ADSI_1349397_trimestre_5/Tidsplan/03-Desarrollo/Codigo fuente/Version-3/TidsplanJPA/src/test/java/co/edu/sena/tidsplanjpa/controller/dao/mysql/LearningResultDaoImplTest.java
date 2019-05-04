/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.LearningResultDao;
import co.edu.sena.tidsplanjpa.controller.factory.LearningResultFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK;
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
/**
 *
 * @author 1349397
 */
public class LearningResultDaoImplTest {

    LearningResult lr;
    LearningResultPK lrpk;

    public LearningResultDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lr = new LearningResult();
        lr.setLearningResultPK(new LearningResultPK("123", "228106", "240201500", "102"));
        lr.setDescription("Hola");

        lrpk = new LearningResultPK("321", "228120", "220501032", "102");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {          
        System.out.println("Prueba de LearningResult metodo insert");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        if (dao.find(lr.getLearningResultPK()) == null) {
            dao.insert(lr);
        }
        assertEquals(dao.find(lr.getLearningResultPK()), lr);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de LearningResult metodo find");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        LearningResult learningResultConsulted = (LearningResult) dao.find(lr.getLearningResultPK());
        assertEquals(learningResultConsulted, lr);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de LearningResult metodo Update");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        lr.setDescription("Hello");
        dao.update(lr);
        assertEquals(dao.find(lr.getLearningResultPK()), lr);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de LearningResult metodo update por llave primaria");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        int resultado = dao.updatePrimaryKey(lrpk, lr.getLearningResultPK());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05delete() {
        System.out.println("prueba de LearningResult metodo delete");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        lr.setLearningResultPK(lrpk);
        dao.remove(lr);
        assertEquals(dao.find(lr.getLearningResultPK()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("prueba de LearningResult metodo FindAll");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByLikeIdCode() {
        System.out.println("prueba de LearningResult metodo findByLikeIdCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByLikeIdCode("%ETIC%");
        assertFalse(list.isEmpty());
    }

    
    @Test
    public void test08FindByIdCode() {
        System.out.println("prueba de LearningResult metodo findByIdCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByIdCode("RAB-1 (AMBIENTAL Y CULTURA FISICA)");
        assertFalse(list.isEmpty());
        for (LearningResult learningResult : list) {
            assertEquals(learningResult.getLearningResultPK().getIdCode(), "RAB-1 (AMBIENTAL Y CULTURA FISICA)");     
        }
    }

    @Test
    public void test09FindByLikeDescription() {
        System.out.println("prueba de LearningResult metodo FindByLikeDescription");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByLikeDescription("%responsablemente%");
        assertFalse(list.isEmpty());
    }

    /**
     * Test of findByDescription method, of class LearningResultDaoImpl.
     */
    @Test
    public void test10FindByDescription() {
         System.out.println("prueba de LearningResult metodo FindByDescription");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByDescription("Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.");
        assertFalse(list.isEmpty());
        for (LearningResult learningResult : list) {
            assertEquals(learningResult.getDescription(), "Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.");     
        }
    }

   
    @Test
    public void test11FindByProgramCode() {
        System.out.println("prueba de LearningResult metodo FindByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByProgramCode("228106");
        assertFalse(list.isEmpty());
        for (LearningResult learningResult : list) {
            assertEquals(learningResult.getLearningResultPK().getProgramCode(), "228106");
        }
    }

    @Test
    public void test12FindByLikeProgramCode() {
        System.out.println("prueba de LearningResult metodo FindByLikeProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByLikeProgramCode("%2%6%");
        assertFalse(list.isEmpty());
    }

    @Test
    public void test13FindByLikeCompetitionCode() {
        System.out.println("prueba de LearningResult metodo FindByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByLikeCompetitionCode("%2%0%");
        assertFalse(list.isEmpty());
    }

    /**
     * Test of findByCompetitionCode method, of class LearningResultDaoImpl.
     */
    @Test
    public void test14FindByCompetitionCode() {
        System.out.println("prueba de LearningResult metodo FindByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByProgramCode("228106");
        assertFalse(list.isEmpty());
        for (LearningResult learningResult : list) {
            assertEquals(learningResult.getLearningResultPK().getProgramCode(), "228106");
        }
    }

   
    @Test
    public void test15FindByLikeProgramVersion() {
        System.out.println("prueba de LearningResult metodo FindByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByLikeProgramVersion("%1%");
        assertFalse(list.isEmpty());
    }

    
    @Test
    public void test16FindByProgramVersion() {
        System.out.println("prueba de LearningResult metodo FindByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> list = dao.findByProgramVersion("102");
        assertFalse(list.isEmpty());
        for (LearningResult learningResult : list) {
            assertEquals(learningResult.getLearningResultPK().getProgramVersion(), "102");
        }
    }

    
}
