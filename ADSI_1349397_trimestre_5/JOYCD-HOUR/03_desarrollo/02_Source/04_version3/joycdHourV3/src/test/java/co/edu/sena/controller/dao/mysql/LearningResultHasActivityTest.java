/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ActivityDAO;
import co.edu.sena.controller.dao.LearningResultDAO;
import co.edu.sena.controller.factory.ActivityFactory;
import co.edu.sena.controller.factory.LearningResultFactory;
import co.edu.sena.model.jpa.entities.Activity;
import co.edu.sena.model.jpa.entities.ActivityPK;
import co.edu.sena.model.jpa.entities.LearningResult;
import co.edu.sena.model.jpa.entities.LearningResultPK;
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
 * @author 1349397
 */@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LearningResultHasActivityTest {
    private Activity activity;
    private ActivityPK activitypk;

    public LearningResultHasActivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        activity = new Activity();
        activity.setNameActivity("name activity");
        activity.setActivityPK(new ActivityPK ("100","analisis","576887"));
        
        activity.setLearningResultCollection(new ArrayList <>());
        activity.getLearningResultCollection().add(
        new LearningResult(
            new LearningResultPK("RAB 1 (Comunicacion)","228120","240201500","Version 102")));
        
    
          activitypk = new ActivityPK("10","evaluacion","576887");
         
           
    }
        
      @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        LearningResultDAO daoLearning = LearningResultFactory.create(LearningResult.class);
        dao.insert(activity);

        LearningResult lr = (LearningResult) daoLearning.find(new LearningResultPK("RAB 1 (Comunicacion)","228120","240201500","Version 102"));

        lr.setActivityCollection(new ArrayList<>());
        lr.getActivityCollection().add(activity);
        daoLearning.update(lr);

        assertTrue(!lr.getActivityCollection().isEmpty());
        for (Activity activity : lr.getActivityCollection()) {
            assertEquals(activity, activity);
        }

     }
     
     @Test
     public void test2update(){
         
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        LearningResultDAO daoLearning = LearningResultFactory.create(LearningResult.class);
        activity.setNameActivity("nombreActividad");
        dao.update(activity);
       
        LearningResult lr = (LearningResult) daoLearning.find(new LearningResultPK("RAB 1 (Comunicacion)", "228120", "240201500", "Version 102"));
         lr.setDescription("nombreDescripcion");
          
         lr.getActivityCollection().add(activity);
         daoLearning.update(lr);
         
         if (lr.getActivityCollection().isEmpty()){
             dao.update(activity);
         }
     
     }
     @Test
     public void test3delete (){
         ActivityDAO dao = ActivityFactory.create(Activity.class);
         LearningResultDAO daoLearning = LearningResultFactory.create(LearningResult.class);
         
         LearningResult lr = (LearningResult) daoLearning.find(new LearningResultPK("RAB 1 (Comunicacion)", "228120", "240201500", "Version 102"));
         
         lr.getActivityCollection().remove(activity);
         daoLearning.update(lr);
         
         if (lr.getActivityCollection().isEmpty()){
             dao.remove(activity);
         }
     
     }
     @Test
     public void test4UpdatePrimaryKey (){
         ActivityDAO dao = ActivityFactory.create(Activity.class);
         LearningResultDAO daoLearning = LearningResultFactory.create(LearningResult.class);
         
         LearningResult lr = (LearningResult) daoLearning.find(new LearningResultPK("RAB 1 (Comunicacion)", "228120", "240201500", "Version 102"));
         lr.setLearningResultPK(new LearningResultPK ("RAB 2 (Induccion)", "228106", "240201500", "Version 102"));
        
         lr.getActivityCollection().add(activity);
         daoLearning.update(lr);
         activity.getActivityPK();
         dao.updatePrimaryKey(activitypk, activity.getActivityPK());
    
         
     }
    
       
        
     
}
