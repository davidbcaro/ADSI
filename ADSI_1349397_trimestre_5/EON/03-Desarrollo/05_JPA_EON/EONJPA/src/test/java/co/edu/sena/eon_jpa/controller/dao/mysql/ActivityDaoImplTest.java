/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ActivityDao;
import co.edu.sena.eon_jpa.controller.factory.ActivityFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Activity;
import co.edu.sena.eon_jpa.model.jpa.entities.ActivityPK;
import co.edu.sena.eon_jpa.model.jpa.entities.Phase;
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
public class ActivityDaoImplTest {
    
    private Activity activity;
    private ActivityPK updatePK;
    
    public ActivityDaoImplTest() {
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
        activity.setActivityPK(new ActivityPK(2, "5768877", "Prueba2"));
        activity.setName("Prueba insert de Activity");
        
        updatePK = new ActivityPK(3, "576887", "Planeacion");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("Test Insert");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        dao.insert(activity);
        Activity a1 = (Activity) dao.find(activity.getActivityPK());
        assertEquals(a1, activity);
    }

    @Test
    public void test2find() {
        System.out.println("Test Find");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        Activity a1 = (Activity) dao.find(activity.getActivityPK());
        assertEquals(a1, activity);
    }

    @Test
    public void test3update() {
        System.out.println("Test Update");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        activity.setName("Prueba de Update Activity");
        dao.update(activity);
        assertEquals(dao.find(activity.getActivityPK()), activity);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        ActivityDao dao = ActivityFactory.create(Activity.class);
        dao.updatePrimaryKey(updatePK, activity.getActivityPK());
        activity.setActivityPK(updatePK);
        assertEquals(dao.find(updatePK), activity);
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        activity.setActivityPK(updatePK);
        dao.remove(activity);
        assertEquals(dao.find(activity.getActivityPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByIdActivity() {
        System.out.println("Test findByIdActivity");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByIdActivity(5);
        assertTrue(!lista.isEmpty());
        for(Activity a1: lista){
            assertEquals(a1.getActivityPK().getIdActivity(), 5);
        }
    }

    @Test
    public void test6FindByName() {
        System.out.println("Test findByName");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByName("Determinar la estructura lógica del sistema");
        assertTrue(!lista.isEmpty());
        for(Activity a1: lista){
            assertEquals(a1.getName(), "Determinar la estructura lógica del sistema");
        }
    }

    @Test
    public void test6FindByNamePhase() {
        System.out.println("Test findByNamePhase");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByNamePhase("Analisis");
        assertTrue(!lista.isEmpty());
        for(Activity a1: lista){
            assertEquals(a1.getActivityPK().getNamePhase(), "Analisis");
        }
    }

    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByCode("576887");
        assertTrue(!lista.isEmpty());
        for(Activity a1: lista){
            assertEquals(a1.getActivityPK().getCode(), "576887");
        }
    }

    @Test
    public void test6FindByLikeName() {
        System.out.println("Test findByLikeName");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeName("%A%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeNamePhase() {
        System.out.println("Test findByLikeNamePhase");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeNamePhase("%An%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test findByLikeCode");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeCode("%57%");
        assertTrue(!lista.isEmpty());
    }   
}
