/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.TrainingProgramDao;
import co.edu.sena.tidsplanjpa.controller.factory.TrainingProgramFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgram;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgramPK;
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
public class TrainingProgramDaoImplTest {
    TrainingProgram tp;
    TrainingProgramPK tppk;
    public TrainingProgramDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tp = new TrainingProgram();
        tp.setTrainingProgramPK(new TrainingProgramPK("123", "102"));
        tp.setName("Training Program1");
        tp.setInitials("AA");
        tp.setStatus(true);
        tp.setLevelFormation(new FormationLevel("tecnico"));
        
        tppk = new TrainingProgramPK();
        tppk.setIdCode("1111");
        tppk.setVersion("102");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert(){
        System.out.println("Prueba de la tabla Training Program metodo insert");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        if(dao.find(tp.getTrainingProgramPK())==null){
            dao.insert(tp);
        }
        assertEquals(dao.find(tp.getTrainingProgramPK()), tp);
    }
    
     @Test
    public void test02Find() {
        System.out.println("Prueba de Training Program metodo find");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        TrainingProgram trainingProgramConsulted = (TrainingProgram) dao.find(tp.getTrainingProgramPK());
        assertEquals(trainingProgramConsulted, tp);

    }
    
    @Test
    public void test03Update(){
         System.out.println("Prueba de Training Program metodo Update");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        tp.setStatus(false);
        tp.setInitials("PP");
        dao.update(tp);
        assertEquals(dao.find(tp.getTrainingProgramPK()), tp);
    } 
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de Training Program metodo update por llave primaria");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        int resultado = dao.updatePrimaryKey(tppk ,tp.getTrainingProgramPK());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba de Training Program metodo delete");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        tp.setTrainingProgramPK(tppk);
        dao.remove(tp);
        assertEquals(dao.find(tp.getTrainingProgramPK()), null);
    }
      

    
    @Test
    public void test06FindAll() {
        System.out.println("prueba de Training Program metodo FindAll");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findAll();
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            
        }
    }

  
    @Test
    public void test07FindByIdCode() {
        System.out.println("prueba de Training Program metodo FindByIdCode");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByIdCode("228106");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getTrainingProgramPK().getIdCode(), "228106");
        }
        
    }

    @Test
    public void test08FindByStatus() {
        System.out.println("prueba de Training Program metodo FindByStatus");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByStatus(Boolean.TRUE);
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getStatus(), Boolean.TRUE);
        }       
    }

    
    @Test
    public void test09FindByLikeIdCode() {
        System.out.println("prueba de Training Program metodo FindByLikeIdCode");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLikeIdCode("%6%");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
        }       
    }

    /**
     * Test of findByName method, of class TrainingProgramDaoImpl.
     */
    @Test
    public void test10FindByName() {
        System.out.println("prueba de FTraining Program metodo FindByName");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByName("ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getName(), "ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION");
        }       
    }

    @Test
    public void test11FindByLikeName() {
       System.out.println("prueba de Training Program metodo FindByLikeName");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLikeName("%NA%");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
        }       
    }

   
    @Test
    public void test12FindByVersion() {
        System.out.println("prueba de FTraining Program metodo FindByVersion");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByVersion("102");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getTrainingProgramPK().getVersion(), "102");
        }       
    }

    /**
     * Test of findByLikeVersion method, of class TrainingProgramDaoImpl.
     */
    @Test
    public void test13FindByLikeVersion() {
        System.out.println("prueba de Training Program metodo FindByLikeVersion");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLikeVersion("%1%");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
        }       
    }

    
    @Test
    public void test14FindByInitials() {
        System.out.println("prueba de Training Program metodo FindByInitials");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByInitials("TPS");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getInitials(), "TPS");
        }       
    }

   
    @Test
    public void test15FindByLikeInitials() {
        System.out.println("prueba de Training Program metodo FindByLikeInitials");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLikeInitials("%S%");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
        }    
    }

    /**
     * Test of findByLevelFormation method, of class TrainingProgramDaoImpl.
     */
    @Test
    public void test16FindByLevelFormation() {
         System.out.println("prueba de Training Program metodo FindByLevelFormation");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLevelFormation("tecnico");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
            assertEquals(trainingProgram.getLevelFormation().getLevelFormation(), "tecnico");
        }       
    }

    /**
     * Test of findByLikeLevelFormation method, of class TrainingProgramDaoImpl.
     */
    @Test
    public void test17FindByLikeLevelFormation() {
         System.out.println("prueba de Training Program metodo FindByLikeLevelFormation");
        TrainingProgramDao dao = TrainingProgramFactory.create(TrainingProgram.class);
        List<TrainingProgram> list = dao.findByLikeLevelFormation("%o%");
        assertFalse(list.isEmpty());
        for (TrainingProgram trainingProgram : list) {
            System.out.println(trainingProgram);
        }       
    }
    
}
