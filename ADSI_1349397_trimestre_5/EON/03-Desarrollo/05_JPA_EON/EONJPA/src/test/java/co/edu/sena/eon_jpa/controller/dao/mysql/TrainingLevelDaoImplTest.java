/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.TrainingLevelDao;
import co.edu.sena.eon_jpa.controller.factory.TrainingLevelFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel;
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
public class TrainingLevelDaoImplTest {
    
    private TrainingLevel trainingLevel;
    
    public TrainingLevelDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        trainingLevel = new TrainingLevel();
        trainingLevel.setTrainingLevel("Profesional");
        trainingLevel.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        if (dao.find(trainingLevel.getTrainingLevel()) == null) {
            dao.insert(trainingLevel);
        }
        assertEquals(dao.find(trainingLevel.getTrainingLevel()), trainingLevel);
    }
    
    @Test
    public void test2find() {
        System.out.println("Test Find");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        TrainingLevel TrainingLevelConsulted = (TrainingLevel) dao.find(trainingLevel.getTrainingLevel());
        assertEquals(TrainingLevelConsulted, trainingLevel);
    }
    
    @Test
    public void test3update() {
        System.out.println("Test Update");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        trainingLevel.setState(false);
        dao.update(trainingLevel);
        assertEquals(dao.find(trainingLevel.getTrainingLevel()), trainingLevel);
    }
    
    @Test
    public void test3vUpdatePrimaryKey() {
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        int resultado = dao.updatePrimaryKey("Programador", trainingLevel.getTrainingLevel());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        trainingLevel.setTrainingLevel("Programador");
        dao.remove(trainingLevel);
        assertEquals(dao.find(trainingLevel.getTrainingLevel()), null);
    }
    
    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindByTrainingLevel() {
        System.out.println("Test FindByTrainingLevel");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByTrainingLevel("Especializado");
        assertTrue(!lista.isEmpty());
        for (TrainingLevel tl1 : lista) {
            assertEquals(tl1.getTrainingLevel(), "Especializado");
        }
    }
    
    @Test
    public void test6FindByState(){
        System.out.println("Test FindByState");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByState(false);
        assertTrue(!lista.isEmpty());
        for (TrainingLevel tl1 : lista){
            assertEquals(tl1.getState(), false);            
        }
    }
    
    @Test
    public void test6FindByLikeTrainingLevel() {
        System.out.println("Test findByLikeTrainingLevel");
        TrainingLevelDao dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByLikeTrainingLevel("%Tec%");
        assertTrue(!lista.isEmpty());
    }
}
