/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.LearningResultDao;
import co.edu.sena.tidsplanjpa.controller.dao.TrimesterDao;
import co.edu.sena.tidsplanjpa.controller.factory.LearningResultFactory;
import co.edu.sena.tidsplanjpa.controller.factory.TrimesterFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Trimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterPK;
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
public class QuarterPlanninglTest {

    private Trimester tr;

    public QuarterPlanninglTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        tr = new Trimester();
        tr.setTrimesterPK(new TrimesterPK("Triemst", "D", "tecnologo"));

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
//        TrimesterDao daoTri = TrimesterFactory.create(Trimester.class);
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//            daoLea.insert(tr);
//
//        
//
//        LearningResult learn = (LearningResult) daoLea.find(new LearningResultPK("RAB-2 (Comunicación)",
//                "228106",
//                "240201500",
//                "102"));
//           
//            
//        learn.setTrimesterCollection(new ArrayList<>());
//        learn.getTrimesterCollection().add(tr);
//        daoLea.update(learn);
//        
//        
//    
//        assertFalse(learn.getTrimesterCollection().isEmpty());
//
//        for (Trimester trimester : learn.getTrimesterCollection()) {
//           assertEquals(trimester, tr);
//        }
//        Trimester qq = (Trimester) daoTri.find(tr.getTrimesterPK());
//        assertEquals(qq, tr);
//    }
//
//    @Test
//    public void test02Delete() {
//        System.out.println("Prueba de  delete");
//        LearningResultDao daoLea = LearningResultFactory.create(LearningResult.class);
//        TrimesterDao daoTri = TrimesterFactory.create(Trimester.class);
//         LearningResult learn = (LearningResult) daoLea.find(new LearningResultPK("RAB-2 (Comunicación)",
//                "228106",
//                "240201500",
//                "102"));
//        learn.getTrimesterCollection().remove(tr);
//        daoLea.remove(tr);
//        daoLea.update(learn);
//        if (learn.getTrimesterCollection().isEmpty()) {
//            daoTri.remove(learn);
//
//        }
//    }

}
