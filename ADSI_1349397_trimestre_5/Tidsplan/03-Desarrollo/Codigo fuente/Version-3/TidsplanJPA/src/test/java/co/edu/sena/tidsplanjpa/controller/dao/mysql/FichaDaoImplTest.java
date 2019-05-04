/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.FichaDao;
import co.edu.sena.tidsplanjpa.controller.factory.FichaFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Ficha;
import co.edu.sena.tidsplanjpa.model.jpa.entities.StateGroup;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgram;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class FichaDaoImplTest {

    Ficha f;
    SimpleDateFormat format;

    public FichaDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        f = new Ficha();
        f.setNumberGroup("Paa");
        format = new SimpleDateFormat("dd-MM-yyyy");
        f.setStartDate(format.parse("01-03-1999"));
        f.setEndDate(format.parse("05-07-2000"));
        f.setRoute("111");
        f.setNameState(new StateGroup("Aplazada"));
        f.setTrainingProgram(new TrainingProgram("228106", "102"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Nivel de formacion metodo insert");
        FichaDao dao = FichaFactory.create(Ficha.class);
        if (dao.find(f.getNumberGroup()) == null) {
            dao.insert(f);

        }
        assertEquals(dao.find(f.getNumberGroup()), f);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de Nivel de formacion metodo Find");
        FichaDao dao = FichaFactory.create(Ficha.class);
        Ficha fichaConsulted = (Ficha) dao.find(f.getNumberGroup());
        assertEquals(fichaConsulted, f);

    }

    @Test
    public void test03Update() throws ParseException {
        System.out.println("Prueba de Nivel de formacion metodo Update");
        FichaDao dao = FichaFactory.create(Ficha.class);
        f.setRoute("999");
        dao.update(f);
        assertEquals(dao.find(f.getNumberGroup()), f);

    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba de Nivel de formacion metodo UpdatePrimaryKey");
        FichaDao dao = FichaFactory.create(Ficha.class);
        int result = dao.updatePrimaryKey("6999", f.getNumberGroup());
        assertEquals(result, 1);
    }

    @Test
    public void test05FindAll() {
        System.out.println("Prueba de Nivel de formacion metodo FindaAll");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findAll();
        assertTrue(!list.isEmpty());
        for (Ficha formationLevel : list) {
            System.out.println(formationLevel);
        }

    }

    @Test
    public void test06FindByLikeNumberGroup() {
        System.out.println("Prueba de Nivel de formacion metodo findByLikeNumberGroup");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeNumberGroup("%3%");
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByNumberGroup() {
        System.out.println("Prueba de Nivel de formacion metodo FindByNumberGroup");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeNumberGroup("1349397");
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            assertEquals(ficha.getNumberGroup(), "1349397");
        }
    }

    @Test
    public void test08FindByStartDate() throws ParseException {
        System.out.println("Prueba de Nivel de formacion metodo FindByNumberGroup");
        FichaDao dao = FichaFactory.create(Ficha.class);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<Ficha> list = dao.findByStartDate(this.format.parse("01-03-1999"));
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            System.out.println(ficha);
        }
    }

    @Test
    public void test09FindByEndDate() throws ParseException {
         System.out.println("Prueba de Nivel de formacion metodo FindByNumberGroup");
        FichaDao dao = FichaFactory.create(Ficha.class);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<Ficha> list = dao.findByEndDate(this.format.parse("05-07-2000"));
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            System.out.println(ficha);
        }
    }

    @Test
    public void test10Delete() {
        System.out.println("Prueba de Nivel de formacion metodo Delete");
        FichaDao dao = FichaFactory.create(Ficha.class);
        f.setNumberGroup("6999");
        dao.remove(f);
        assertEquals(dao.find(f.getNumberGroup()), null);
    }

    @Test
    public void test11FindByLikeRoute() {
        System.out.println("Prueba de Nivel de formacion metodo FindByLikeRoute");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeRoute("%23%");
        assertFalse(list.isEmpty());
    }

    @Test
    public void test12FindByRoute() {
        System.out.println("Prueba de Nivel de formacion metodo FindByRoute");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByRoute("3123");
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            assertEquals(ficha.getRoute(), "3123");
        }
    }

   
    @Test
    public void test13FindByNameState() {
        System.out.println("Prueba de Nivel de formacion metodo FindByNameState");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByNameState("En formacion");
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            assertEquals(ficha.getNameState().getNameState(), "En formacion");
        }
    }

    /**
     * Test of findByLikeNameState method, of class FichaDaoImpl.
     */
    @Test
    public void test14FindByLikeNameState() {
        System.out.println("Prueba de Nivel de formacion metodo FindByLikeNameState");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeNameState("%mac%");
        assertFalse(list.isEmpty());
    }

    
    @Test
    public void test15FindByVersion() {
        System.out.println("Prueba de Nivel de formacion metodo FindByVersion");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByVersion("102");
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            assertEquals(ficha.getTrainingProgram().getTrainingProgramPK().getVersion(), "102");
        }
    }

    /**
     * Test of findByLikeVersion method, of class FichaDaoImpl.
     */
    @Test
    public void test16FindByLikeVersion() {
        System.out.println("Prueba de Nivel de formacion metodo FindByVersion");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeVersion("%1%");
        assertFalse(list.isEmpty());
    }

    /**
     * Test of findByProgramCode method, of class FichaDaoImpl.
     */
    @Test
    public void test17FindByProgramCode() {
        System.out.println("Prueba de Nivel de formacion metodo FindByProgramCode");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByProgramCode("228106");
        assertFalse(list.isEmpty());
        for (Ficha ficha : list) {
            assertEquals(ficha.getTrainingProgram().getTrainingProgramPK().getIdCode(), "228106");
        }
    }

   
    @Test
    public void test18FindByLikeProgramCode() {
         System.out.println("Prueba de Nivel de formacion metodo FindByLikeProgramCode");
        FichaDao dao = FichaFactory.create(Ficha.class);
        List<Ficha> list = dao.findByLikeProgramCode("%28%");
        assertFalse(list.isEmpty());
    }
    }

