/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ActivityDao;
import co.edu.sena.tidsplanjpa.controller.factory.ActivityFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Activity;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ActivityPK;
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
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityDaoImplTest {

    private Activity ac;
    private ActivityPK pk;

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
        ac = new Activity();
        ac.setActivityPK(new ActivityPK("Actividad1", "ANALISIS", "569629"));
        ac.setName("Actividades de  inducción en la formación profesional integral SENA");

        pk = new ActivityPK();
        pk.setIdActivity("Actividad10");
        pk.setNamePhase("EJECUCION");
        pk.setProjectCode("569629");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Actividad metodo insert");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        if (dao.find(ac.getActivityPK()) == null) {
            dao.insert(ac);
        }
        assertEquals(dao.find(ac.getActivityPK()), ac);

    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de Actividad medoto Find");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        Activity activityConsulted = (Activity) dao.find(ac.getActivityPK());
        assertEquals(activityConsulted, ac);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de Actividad metodo Update");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        ac.setName("Actividades de  inducción en la formación profesional integral SENA");
        dao.update(ac);
        assertEquals(dao.find(ac.getActivityPK()), ac);

    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba de Actividad metodo Update por llave primaria");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        int resultado = dao.updatePrimaryKey(pk, ac.getActivityPK());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05Delete() {
        System.out.println("Prueba de Actividad metodo Delete");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        ac.setActivityPK(pk);
        dao.remove(ac);
        assertEquals(dao.find(ac.getActivityPK()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("Prueba de Actividad metodo FindAll");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByIdActivity() {
        System.out.println("Prueba de Actividad metodo FindByIdActivity");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByIdActivity("Actividad 11");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
            assertEquals(activity.getActivityPK().getIdActivity(), "Actividad 11");
        }
    }

    /**
     * Test of findByLikeIdActivity method, of class ActivityDaoImpl.
     */
    @Test
    public void test08FindByLikeIdActivity() {
        System.out.println("Prueba de Actividad metodo FindByIdActivity");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByLikeIdActivity("%Ac%");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
        }
    }

    @Test
    public void test09FindByProjectCode() {
        System.out.println("Prueba de Actividad metodo FindByProjectCode");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<  Activity> list = dao.findByProjectCode("569629");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            assertEquals(activity.getActivityPK().getProjectCode(), "569629");
        }
    }

    @Test
    public void test10FindByLikeProjectCode() {
        System.out.println("Prueba de Actividad metodo FindByLikeProjectCode");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByLikeProjectCode("%5%9%");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
        }
    }

    @Test
    public void test11findByName() {
        System.out.println("Prueba de Actividad metodo findByLikeName");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByLikeName(" Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
        }
    }

    @Test
    public void test12findByLikeName() {
        System.out.println("Prueba de Actividad metodo findByLikeName");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByLikeName("%e%");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
        }
    }

    @Test
    public void test13FindByNamePhase() {
        System.out.println("Prueba de Actividad metodo findByLikeNamePhase");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByNamePhase("EJECUCION");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            assertEquals(activity.getActivityPK().getNamePhase(), "EJECUCION");
        }
    }

    @Test
    public void test14findByLikeNamePhase() {
        System.out.println("Prueba de Actividad metodo findByLikeNamePhase");
        ActivityDao dao = ActivityFactory.create(Activity.class);
        List<Activity> list = dao.findByLikeNamePhase("%CU%");
        assertFalse(list.isEmpty());
        for (Activity activity : list) {
            System.out.println(activity);
        }
    }
}
