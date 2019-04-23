/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.CurrentQuarterFactory;
import co.edu.sena.wariosoftjpa.controller.dao.CurrentQuarterDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CurrentQuarter;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CurrentQuarterImplTest {

    private CurrentQuarter st;

    public CurrentQuarterImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        st = new CurrentQuarter();
        st.setIdCurrentQuarter("2017-04");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        st.setStartDate(formatter.parse("24-11-2017"));
        st.setEndDate(formatter.parse("24-11-2018"));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de StateNumberGroup metodo insert");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        if (dao.find(st.getIdCurrentQuarter()) == null) {
            dao.insert(st);
        }
        assertEquals(dao.find(st.getIdCurrentQuarter()), st);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de StateNumberGroup metodo find por llave primaria");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        CurrentQuarter CurrentQuarterConsultado = (CurrentQuarter) dao.find(st.getIdCurrentQuarter());
        assertEquals(CurrentQuarterConsultado, st);
    }

    @Test
    public void test3update() throws ParseException {
        System.out.println("prueba de StateNumberGroup metodo update po llave primaria");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        st.setStartDate(formatter.parse("24-11-2016"));
        dao.update(st);
        assertEquals(dao.find(st.getIdCurrentQuarter()), st);
    }

    @Test
    public void test3updatePk() {
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        int resultado = dao.updatePk("2017-04", st.getIdCurrentQuarter());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);

        st.setIdCurrentQuarter("24-11-2016");
        dao.remove(st);
        assertEquals(dao.find(st.getIdCurrentQuarter()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        List< CurrentQuarter> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByIdCurrentQuarter method, of class CurrentQuarterImpl.
     */
    @Test
    public void test6FindByIdCurrentQuarter() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        List<CurrentQuarter> lista = dao.findByIdCurrentQuarter("2017-04");
        assertTrue(!lista.isEmpty());
        for (CurrentQuarter currentQuarter : lista) {
            assertEquals(currentQuarter.getIdCurrentQuarter(), "2017-04");
        }

    }

    /**
     * Test of findByStartDate method, of class CurrentQuarterImpl.
     */
    @Test
    public void testFindByStartDate() throws ParseException {
        System.out.println("findByStartDate");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Date fecha = formatter.parse("24-11-2016");
        List<CurrentQuarter> lista = dao.findByStartDate(formatter.parse("24-11-2016"));
        assertTrue(!lista.isEmpty());
 
        for (CurrentQuarter currentQuarter : lista) {
            assertEquals(currentQuarter.getStartDate(), fecha);

        }

    }

    /**
     * Test of findByEndDate method, of class CurrentQuarterImpl.
     */
    @Test
    public void testFindByEndDate() throws ParseException {
        System.out.println("findByState");
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = formatter.parse("24-11-2018");
        List<CurrentQuarter> lista = dao.findByEndDate(fecha);
        assertTrue(!lista.isEmpty());
        for (CurrentQuarter currentQuarter : lista) {
            assertEquals(currentQuarter.getEndDate(), fecha);

        }

    }

    /**
     * Test of findByLikeIdCurrentQuarter method, of class CurrentQuarterImpl.
     */
    @Test
    public void testFindByLikeIdCurrentQuarter() {
        CurrentQuarterDAO dao = CurrentQuarterFactory.create(CurrentQuarter.class);
        List<CurrentQuarter> lista = dao.findByLikeIdCurrentQuarter("2%");
        assertTrue(!lista.isEmpty());
    }
}

/**
 * Test of updatePk method, of class CurrentQuarterImpl.
 */
