/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.GroupHasTrimesterDao;
import co.edu.sena.tidsplanjpa.controller.dao.LearningResultDao;
import co.edu.sena.tidsplanjpa.controller.factory.GroupHasTrimesterFactory;
import co.edu.sena.tidsplanjpa.controller.factory.LearningResultFactory;
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
public class ResultsViwedlTest {

   
    LearningResult lea;

    public ResultsViwedlTest() {
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
//        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//        if (daoLea.find(lea.getLearningResultPK()) == null) {
//            dao.insert(lea);
//
//        }
//
//        
//        GroupHasTrimester ght = (GroupHasTrimester) dao.find(new GroupHasTrimesterPK("1234456"
//                , "trimestre-1"
//                , "D"
//                , "tecnico"));
//        
//        ght.setLearningResultCollection(new ArrayList<>());
//        ght.getLearningResultCollection().add(lea);
//        dao.update(ght);
//        
//        assertFalse(ght.getLearningResultCollection().isEmpty());
//        
//        for (LearningResult lear : ght.getLearningResultCollection()) {
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
//        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//        GroupHasTrimester ght = (GroupHasTrimester) dao.find(new GroupHasTrimesterPK("1234456"
//                , "trimestre-1"
//                , "D"
//                , "tecnico"));
//        
//        ght.getLearningResultCollection().remove(lea);
//        dao.update(ght);
//        if (ght.getLearningResultCollection().isEmpty()) {
//            daoLea.remove(ght);
//            
//        }
//     }

}