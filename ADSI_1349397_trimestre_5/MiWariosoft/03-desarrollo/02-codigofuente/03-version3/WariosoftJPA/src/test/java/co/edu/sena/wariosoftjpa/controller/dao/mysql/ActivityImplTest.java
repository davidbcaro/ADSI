/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.ActivityFactory;
import co.edu.sena.wariosoftjpa.controller.dao.ActivityDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Activity;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ActivityPK;
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
 * @author WINDOWS 8
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityImplTest {

    private Activity activity;
    private ActivityPK activityPK;

    public ActivityImplTest() {
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
        activity.setActivityPK(new ActivityPK(12, "FASE 1: ANÁLISIS", "576887 v102"));
        activity.setNameActivity("Preparar documentación del proceso de implantación del sistema");

        activityPK = new ActivityPK(14, "FASE 1: ANÁLISIS", "576887 v102");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        dao.insert(activity);
        Activity activityBaseDatos = (Activity) dao.find(activity.getActivityPK());
        assertEquals(activityBaseDatos, activity);
    }

    @Test
    public void test2findpk() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        Activity cs = (Activity) dao.find(activity.getActivityPK());
        assertEquals(cs, activity);
    }

    @Test
    public void test3update() {

        ActivityDAO dao = ActivityFactory.create(Activity.class);
        activity.setNameActivity("namedea");
        dao.update(activity);
        assertEquals(dao.find(activity.getActivityPK()), activity);
    }

    @Test
    public void test3updatePk() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        dao.updatePk(activityPK, activity.getActivityPK());
        activity.setActivityPK(activityPK);
        assertEquals(dao.find(activityPK), activity);

    }

    @Test
    public void test4Remove() {
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        activity.setActivityPK(activityPK);
        dao.remove(activity);
        assertEquals(dao.find(activity.getActivityPK()), null);

    }

    /**
     * Test of findByIdActivity method, of class ActivityImpl.
     */
    @Test
    public void test5FindByIdActivity() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByIdActivity(12);
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getIdActivity(), 12);
        }
    }

    /**
     * Test of findByNameActivity method, of class ActivityImpl.
     */
    @Test
    public void test6FindByNameActivity() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByNameActivity("Preparar documentación del proceso de implantación del sistema");
        for (Activity activity : lista) {
            assertEquals(activity.getNameActivity(), "Preparar documentación del proceso de implantación del sistema");
        }
    }

    /**
     * Test of findByNamePhase method, of class ActivityImpl.
     */
    @Test
    public void test7FindByNamePhase() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByNamePhase("Preparar documentación del proceso de implantación del sistema");
        for (Activity activity : lista) {
            assertEquals(activity.getNameActivity(), "Preparar documentación del proceso de implantación del sistema");
        }
    }

    /**
     * Test of findByProjectCode method, of class ActivityImpl.
     */
    @Test
    public void test8FindByProjectCode() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByProjectCode("576887 v102");
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getProjectCode(), "576887 v102");
        }
    }

    /**
     * Test of findByLikeIdActivity method, of class ActivityImpl.
     */
    @Test
    public void test9FindByLikeIdActivity() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeIdActivity(1);
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getIdActivity(), 1);
        }
    }

    /**
     * Test of findByLikeProjectCode method, of class ActivityImpl.
     */
    @Test
    public void test10FindByLikeProjectCode() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ActivityDAO dao = ActivityFactory.create(Activity.class);
        List<Activity> lista = dao.findByLikeProjectCode("576887 v102");
        for (Activity activity : lista) {
            assertEquals(activity.getActivityPK().getProjectCode(), "576887 v102");
        }
    }

    /**
     * Test of findByLikeNameActivity method, of class ActivityImpl.
     */
    /**
     * Test of updatePk method, of class ActivityImpl.
     */

}