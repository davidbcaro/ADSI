/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.LearningOutcomeFactory;
import co.edu.sena.wariosoftjpa.controller.dao.LearningOutcomeDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcomePK;
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
 * @author Sebastian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LearningOutcomeImplTest {
    
    private LearningOutcome learningoutcome;
    private LearningOutcomePK learningoutcomePK;
    
    public LearningOutcomeImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        learningoutcome = new LearningOutcome();
        learningoutcome.setLearningOutcomePK(new LearningOutcomePK("RAT-70","240201500","228106","Version 102"));
        learningoutcome.setDescription("Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y soci. ");
 
        learningoutcomePK = new LearningOutcomePK("RAB-100","240201500","228120","Version 102");
    }
        

    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void test01insert() {
        System.out.println("Prueba de metodo insert en LearningOutcome por llavePrimaria");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        dao.insert(learningoutcome);
        LearningOutcome learningOutcome = (LearningOutcome) dao.find(learningoutcome.getLearningOutcomePK());
        assertEquals(learningOutcome, learningoutcome);         

    }
    
    @Test 
    public void test02findPrimaryKey() {
        System.out.println("Prueba de metodo find en LearningOutcome por llavePrimaria");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        LearningOutcome learningOutcomeConsulta = (LearningOutcome) dao.find(learningoutcome.getLearningOutcomePK());
        assertEquals(learningOutcomeConsulta, learningoutcome);
        
    }
    
    @Test 
    public void test03update () {
        System.out.println("Prueba de metodo update en LearningOutcome por llavePrimaria");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        learningoutcome.setDescription("Palomita");
        dao.update(learningoutcome);
        assertEquals(dao.find(learningoutcome.getLearningOutcomePK()),learningoutcome );
    }
    
     @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("updatePrimaryKey");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        dao.updatePrimaryKey(learningoutcomePK, learningoutcome.getLearningOutcomePK());
        learningoutcome.setLearningOutcomePK(learningoutcomePK);
         assertEquals(dao.find(learningoutcomePK), learningoutcome);
        
    }
    @Test 
   public void  test05remove(){
       LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
       learningoutcome.setLearningOutcomePK(learningoutcomePK);
       dao.remove(learningoutcome);
        assertEquals(dao.find(learningoutcome.getLearningOutcomePK()), null);
       
   }
   @Test
    public void test06FindAll() {
        System.out.println("prueba de Linking metodo findall");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    
 
    /**
     * Test of findByLearningOutcome method, of class LearningOutcomeImpl.
     */
    @Test
    public void test07FindByLearningOutcome() {
        System.out.println("findByLearningOutcome");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByLearningOutcome("RAB-1 (AMBIENTAL Y CULTURA FISICA)");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getLearningOutcomePK().getLearningOutcomeCode(), "RAB-1 (AMBIENTAL Y CULTURA FISICA)");
        }
    }

    /**
     * Test of findByDescription method, of class LearningOutcomeImpl.
     */
    @Test
    public void test08FindByDescription() {
        System.out.println("findByDescription");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByDescription("Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getDescription(), "Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ");
        }
    }

    /**
     * Test of findByLikeLearningOutcome method, of class LearningOutcomeImpl.
     */
    @Test
    public void test09FindByLikeLearningOutcome() {
        System.out.println("findByLikeLearningOutcome");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByLikeLearningOutcome("RAB-1 (AMBIENTAL Y CULTURA FISICA)");
        assertTrue(!lista.isEmpty());
    }

   @Test
    public void test10FindByCompetitionCode() {
        System.out.println("findByCompetitionCode");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByCompetitionCode("240201500");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getLearningOutcomePK().getCompetitionCode(), "240201500");
        }
    }
    
     @Test
    public void test11FindByLikeCompetitionCode() {
        System.out.println("findByLikeCompetitionCode");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByLikeCompetitionCode("240201500");
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test12FindByProgramCode() {
        System.out.println("findByProgramCode");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByProgramCode("228106");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getLearningOutcomePK().getProgramCode(), "228106");
        }
    }
    
    @Test
    public void test13FindByLikeProgramCode() {
        System.out.println("findByLikeCompetitionCode");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByLikeProgramCode("228106");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getLearningOutcomePK().getProgramCode(), "228106");
        }
    }
    @Test
    public void test14FindByVersion() {
        System.out.println("findByVersion");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByVersion("Version 102");
        assertTrue(!lista.isEmpty());
        for (LearningOutcome learningOutcome : lista) {
            assertEquals(learningOutcome.getLearningOutcomePK().getVersion(), "Version 102");
        }
    }
    
    @Test
    public void test15FindByLikeVersion() {
        System.out.println("findByLikeCompetitionCode");
        LearningOutcomeDAO dao = LearningOutcomeFactory.create(LearningOutcome.class);
        List<LearningOutcome> lista = dao.findByLikeVersion("Version 102");
        assertTrue(!lista.isEmpty());
    }
    
   
    

    
}
