/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ActivityDao;
import co.edu.sena.tidsplanjpa.controller.dao.GroupHasTrimesterDao;
import co.edu.sena.tidsplanjpa.controller.dao.LearningResultDao;
import co.edu.sena.tidsplanjpa.controller.factory.ActivityFactory;
import co.edu.sena.tidsplanjpa.controller.factory.GroupHasTrimesterFactory;
import co.edu.sena.tidsplanjpa.controller.factory.LearningResultFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Activity;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ActivityPK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimesterPK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK;
import java.util.ArrayList;

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
 * @author MIHOGAR
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LearningResultHasActivitylTest {

    private Activity a;
    private LearningResult lea;

    public LearningResultHasActivitylTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        lea = new LearningResult();
        lea.setLearningResultPK(new LearningResultPK("3211", "228106", "240201500", "102"));
        lea.setDescription("Hola");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByTypeEmploymentRelationship method, of class
     * InstructorDaoImpl.
     */
//    @Test
//    public void test01Insert() {
//        System.out.println("Prueba de  insert");
//        ActivityDao daoAc = ActivityFactory.create(Activity.class);
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//        daoAc.insert(lea);
//        Activity act = (Activity) daoAc.find(new ActivityPK("Actividad 1", "ANALISIS", "569629"));
//        
//        act.setLearningResultCollection(new ArrayList<>());
//        act.getLearningResultCollection().add(lea);
//        daoLea.update(act);
//        
//        assertFalse(act.getLearningResultCollection().isEmpty());
//        
//        for (LearningResult lear : act.getLearningResultCollection()) {
//            assertEquals(lear, lea);            
//        }
//        
//         LearningResult learn = (LearningResult) daoLea.find(lea.getLearningResultPK());
//         assertEquals(learn, lea);
//        
//    }
//    
//    @Test
//     public void test02Delete() {
//        System.out.println("Prueba de  delete");
//        ActivityDao daoAc = ActivityFactory.create(Activity.class);
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//        Activity act = (Activity) daoAc.find(new ActivityPK("Actividad 1", "ANALISIS", "569629"));
//        
//        act.getLearningResultCollection().remove(lea);
//        daoAc.update(act);
//        if (act.getLearningResultCollection().isEmpty()) {
//            daoLea.remove(act);
//            
//        }
//     }

}