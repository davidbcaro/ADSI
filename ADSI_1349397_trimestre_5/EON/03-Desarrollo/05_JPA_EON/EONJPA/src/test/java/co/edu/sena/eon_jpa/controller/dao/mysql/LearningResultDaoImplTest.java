/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.LearningResultDao;
import co.edu.sena.eon_jpa.controller.factory.LearningResultFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResult;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResultPK;
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
 * @author LUISBERNARDO
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LearningResultDaoImplTest {
    
    private LearningResult learning;
    private LearningResultPK update;
    
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
        
        learning = new LearningResult();
        learning.setLearningResultPK(new LearningResultPK("RAB PRUEBA", "228106", "220501009", "V102"));
        learning.setDescription("Insert de Description");
        
        update = new LearningResultPK("RAB UPDATE", "228106", "220501034", "V102");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        if(dao.find(learning.getLearningResultPK()) == null){
            dao.insert(learning);
        }
        assertEquals(dao.find(learning.getLearningResultPK()), learning);
    }
    
    @Test
    public void test2find(){
        System.out.println("Test Find");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        LearningResult LearningConsulted = (LearningResult) dao.find(learning.getLearningResultPK());
        assertEquals(LearningConsulted, learning);
    }
    
    @Test
    public void test3Update(){
        System.out.println("Test Update");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        learning.setDescription("Update de Descrpition");
        dao.update(learning);
        assertEquals(dao.find(learning.getLearningResultPK()), learning);
    }
    
    @Test
    public void test3vUpdatePrimaryKey() {
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        dao.updatePrimaryKey(update, learning.getLearningResultPK());
        learning.setLearningResultPK(update);
        assertEquals(dao.find(update), learning);
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        learning.setLearningResultPK(update);
        dao.remove(learning);
        assertEquals(dao.find(learning.getLearningResultPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
 
    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByCode("RAB-1 240201500-06");
        assertTrue(!lista.isEmpty());
        for (LearningResult lr1 : lista){
            assertEquals(lr1.getLearningResultPK().getCode(), "RAB-1 240201500-06");
        }
    }

    @Test
    public void test6FindByDescription() {
        System.out.println("Test findByDescription");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByDescription("Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social");
        assertTrue(!lista.isEmpty());
        for (LearningResult lr1 : lista){
            assertEquals(lr1.getDescription(), "Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social");
        }
    }

    @Test
    public void test6FindByCompetitionCode() {
        System.out.println("Test findByCompetitionCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByCompetitionCode("240201500");
        assertTrue(!lista.isEmpty());
        for (LearningResult lr1 : lista){
            assertEquals(lr1.getLearningResultPK().getCompetitionCode(), "240201500");
        }
    }

    @Test
    public void test6FindByProgramCode() {
        System.out.println("Test findByProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByProgramCode("228106");
        assertTrue(!lista.isEmpty());
        for (LearningResult lr1 : lista){
            assertEquals(lr1.getLearningResultPK().getProgramCode(), "228106");
        }
    }

    @Test
    public void test6FindByVersion() {
        System.out.println("Test findByVersion");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByVersion("V102");
        assertTrue(!lista.isEmpty());
        for (LearningResult pr1 : lista){
            assertEquals(pr1.getLearningResultPK().getVersion(), "V102");
        }
    }

    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test findByLikeCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeCode("%RAB%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeDescription() {
        System.out.println("Test findByLikeDescription");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeDescription("%Gen%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeCompetitionCode() {
        System.out.println("Test findByLikeCompetitionCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeCompetitionCode("%240%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeProgramCode() {
        System.out.println("Test findByLikeProgramCode");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeProgramCode("%228%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeVersion() {
        System.out.println("Test findByLikeVersion");
        LearningResultDao dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeVersion("%V1%");
        assertTrue(!lista.isEmpty());
    }   
}
