/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ActivityDAO;
import co.edu.sena.controller.factory.ActivityFactory;
import co.edu.sena.model.jpa.entities.Activity;
import co.edu.sena.model.jpa.entities.ActivityPK;
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
 * @author Chritian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityDAOImplTest {

    private Activity activity;
    private ActivityPK activitypk;

    public ActivityDAOImplTest() {
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
        activity.setNameActivity("Actividad recreativa");
        activity.setActivityPK(new ActivityPK("100", "analisis", "576887"));

        activitypk = new ActivityPK("200", "evaluacion", "576887");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba insert de Activity");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        if (dao.find(activity.getActivityPK()) == null) {
            dao.insert(activity);
        }
        assertEquals(dao.find(activity.getActivityPK()), activity);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de find Activity");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        Activity activityconsulta = (Activity) dao.find(activity.getActivityPK());
        assertEquals(activityconsulta, activity);
    }

    @Test
    public void test03update() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        activity.setNameActivity("321");
        dao.update(activity);
        assertEquals(dao.find(activity.getActivityPK()), activity);
    }

    /**
     * Test of findByIdActivity method, of class ActivityDAOImpl.
     */
    @Test
    public void test04FindByIdActivity() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByIdActivity("100");
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getIdActivity(), "100");
        }
    }

    /**
     * Test of finByNameActivity method, of class ActivityDAOImpl.
     */
    @Test
    public void test05FinByNameActivity() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.finByNameActivity("321");
        for (Activity activity : lista) {
            assertEquals(activity.getNameActivity(), "321");
        }
    }

    /**
     * Test of findByNamePhase method, of class ActivityDAOImpl.
     */
    @Test
    public void test06FindByNamePhase() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByNamePhase("evaluacion");
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getNamePhase(), "evaluacion");
        }
        System.out.println("objetos" + lista);
    }

    /**
     * Test of findByProjectCode method, of class ActivityDAOImpl.
     */
    @Test
    // error
    public void test07FindByProjectCode() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByProjectCode("576887");
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getProjectcode(), "576887");
        }
        
        System.out.println("VEA OBJETOS" + lista);
    }

    /**
     * Test of findByLikeIdActivity method, of class ActivityDAOImpl.
     */
    @Test
    public void test08FindByLikeIdActivity() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeIdActivity("%2%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of finByLikeNameActivity method, of class ActivityDAOImpl.
     */
    @Test
    public void test09FinByLikeNameActivity() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.finByLikeNameActivity("%3%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeNamePhase method, of class ActivityDAOImpl.
     */
    @Test
    public void test10FindByLikeNamePhase() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeNamePhase("%e%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeProjectCode method, of class ActivityDAOImpl.
     */
    @Test
    //error
    public void test11FindByLikeProjectCode() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeProjectCode("%5%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of updatePrimaryKey method, of class ActivityDAOImpl.
     */
    @Test
    
    
    public void test12UpdatePrimaryKey() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        dao.updatePrimaryKey(activitypk, activity.getActivityPK());
        activity.setActivityPK(activitypk);
        assertEquals(dao.find(activitypk), activity);
    }

     @Test
    public void test13delete() {
        System.out.println("Prueba del Delete");
         ActivityDAO dao = ActivityFactory.create(Activity.class);   
        activity.setActivityPK(new ActivityPK("200", "evaluacion", "576887"));
        dao.remove(activity);
        assertEquals(dao.find(activity.getActivityPK()), null);
    }
}
