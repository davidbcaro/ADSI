/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ActivityDao;
import co.edu.sena.cot.controlador.factory.mysql.ActivityFactory;
import co.edu.sena.cot.modelo.dto.Activity;
import co.edu.sena.cot.modelo.dto.ActivityPK;
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
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActivityDaoImplTest {
    
    private Activity activity;
    private ActivityPK activityPK;
    
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
        activity.setActivityPK(new ActivityPK("Hola","FASE 1. ANALISIS",576887));
        activity.setName("Hola a todos");
        
        activityPK = new ActivityPK("jAJA", "FASE-4. EVALUACION", 569629);
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
    public void test01Insert() {

        ActivityDao dao = ActivityFactory.create(Activity.class);
        if (dao.find(activity.getActivityPK()) == null) {
            dao.insert(activity);
        }
        assertEquals(dao.find(activity.getActivityPK()), activity);
    }
    
    @Test
    public void test02find() {

        ActivityDao dao = ActivityFactory.create(Activity.class);
        Activity activity2 = (Activity) dao.find(activity.getActivityPK());
        assertEquals(activity2, activity);
    }
    
      @Test
    public void test03update() {

        ActivityDao dao = ActivityFactory.create(Activity.class);
        activity.setName("Adios a todos");

        dao.update(activity);
        assertEquals(dao.find(activity.getActivityPK()), activity);

    }
    
    @Test
    public void test03vUpdatePrimaryKey() {
        ActivityDao dao = ActivityFactory.create(Activity.class);
        dao.updatePK(activityPK, activity.getActivityPK());
        activity.setActivityPK(activityPK);
        assertEquals(dao.find(activityPK), activity);
    }
    
    
    
         @Test
    public void test04FindAll() {
        
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println("nananana "+lista);
    }

    /**
     * Test of findByName method, of class ActivityDaoImpl.
     */
    @Test
    public void test05FindByName() {
        
     System.out.println("las");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByName("Especificar modelo conceptual del sistema, especificando necesidades y requerimientos.");
        assertTrue(!lista.isEmpty());
        for (Activity activity : lista) {
            assertEquals(activity.getName(), "Especificar modelo conceptual del sistema, especificando necesidades y requerimientos.");
        }
        System.out.println("names "+lista);
    
        
    }

    /**
     * Test of findByIdActivity method, of class ActivityDaoImpl.
     */
    @Test
    public void test06FindByIdActivity() {
        
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByIdActivity("Actividad 4");
        assertTrue(!lista.isEmpty());
        for (Activity activity : lista) {
            //assertEquals(activity.getActivityPK(), new ActivityPK("Actividad 4","FASE-2. PLANEACIÓN", 569629));
            //assertEquals(activity.getActivityPK(), new ActivityPK("Actividad 4","FASE 2. PLANEACIÓN", 576887));
        }
         System.out.println("en la lista estan estos objetos "+ lista);
        
    }

    /**
     * Test of findByNamePhase method, of class ActivityDaoImpl.
     */
    @Test
    public void test07FindByNamePhase() {
        
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByNamePhase("FASE 1. ANALISIS");
        assertTrue(!lista.isEmpty());
        System.out.println("en la lista estan estos objetos "+ lista);
        
    }

    /**
     * Test of findByCodeProject method, of class ActivityDaoImpl.
     */
    @Test
    public void test08FindByCodeProject() {
        
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByCodeProject(576887);
        assertTrue(!lista.isEmpty());
        System.out.println("en la lista estan estos objetos "+ lista);
        
    }

    /**
     * Test of findByLikeName method, of class ActivityDaoImpl.
     */
    @Test
    public void test09FindByLikeName() {
        
        System.out.println("lassssss");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeName("%Ela%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
        
    }

    /**
     * Test of findByLikeIdActivity method, of class ActivityDaoImpl.
     */
    @Test
    public void test10FindByLikeIdActivity() {
        
        System.out.println("lassssss");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeIdActivity("%Ac%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
        
    }

    /**
     * Test of findByLikeNamePhase method, of class ActivityDaoImpl.
     */
    @Test
    public void test11FindByLikeNamePhase() {
        
           System.out.println("lassssss");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeNamePhase("%ANA%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
        
        
    }

    /**
     * Test of findByLikeCodeProject method, of class ActivityDaoImpl.
     */
    @Test
    public void test12FindByLikeCodeProject() {
        
    System.out.println("lassssss");
    ActivityDao dao = ActivityFactory.create(Activity.class);
    List<Activity> lista = dao.findByLikeCodeProject("%9%");
    assertTrue(!lista.isEmpty());
    System.out.println("nananan "+ lista);
        
    }

     @Test
    public void test13delete() {
        
        ActivityDao dao = ActivityFactory.create(Activity.class);
        activity.setActivityPK(new ActivityPK("jAJA", "FASE-4. EVALUACION", 569629));
        dao.remove(activity);
        assertEquals(dao.find(activity.getActivityPK()), null);

    }
    
    /**
     * Test of updatePrimaryKey method, of class ActivityDaoImpl.
     */
    
}
