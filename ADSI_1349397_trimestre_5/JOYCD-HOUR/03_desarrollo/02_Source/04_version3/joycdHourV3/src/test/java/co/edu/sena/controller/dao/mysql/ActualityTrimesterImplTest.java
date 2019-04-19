/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ActualityTrimesterDAO;
import co.edu.sena.controller.factory.ActualityTrimesterFactory;
import co.edu.sena.model.jpa.entities.ActualityTrimester;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ActualityTrimesterImplTest {

    private ActualityTrimester st;

    public ActualityTrimesterImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        st = new ActualityTrimester();
        st.setActualityTrimester("Trimestre 20");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String Fecha1 = "24-11-2017";
        String dateInString2 = "20-05-2018";
        Date date1 = formatter.parse(Fecha1);
        Date date2 = formatter.parse(dateInString2);

        //st.setStartDate(formatter.parse("24-11-2017"));
        //st.setEndDate(formatter.parse("24-11-2018"));
        st.setDateStart(date1);
        st.setDateFinish(date2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de  ActualityTrimester metodo insert");
        ActualityTrimesterDAO dao = ActualityTrimesterFactory.create(ActualityTrimester.class);
        if (dao.find(st.getActualityTrimester()) == null) {
            dao.insert(st);
        }
        assertEquals(dao.find(st.getActualityTrimester()), st);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de  ActualityTrimester metodo find por llave primaria");
        ActualityTrimesterDAO dao = ActualityTrimesterFactory.create(ActualityTrimester.class);
        ActualityTrimester ActualityTrimesterConsultado = (ActualityTrimester) dao.find(st.getActualityTrimester());
        assertEquals(ActualityTrimesterConsultado, st);
    }

    @Test
    public void test3update() throws ParseException {
        System.out.println("prueba de  ActualityTrimester metodo update po llave primaria");
        ActualityTrimesterDAO dao = ActualityTrimesterFactory.create(ActualityTrimester.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String Fecha1 = "24-11-2019";
        String Fecha2 = "20-01-2020";
        Date date1 = formatter.parse(Fecha1);
        Date date2 = formatter.parse(Fecha2);

        st.setDateStart(date1);
        st.setDateFinish(date2);
        dao.update(st);
        assertEquals(dao.find(st.getActualityTrimester()), st);
    }


    @Test
    public void test4delete() {
        System.out.println("prueba de  ActualityTrimester metodo delete para la llave");
        ActualityTrimesterDAO dao = ActualityTrimesterFactory.create(ActualityTrimester.class);
        st.setActualityTrimester("24-11-2016");
        dao.remove(st);
        assertEquals(dao.find(st.getActualityTrimester()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de  ActualityTrimester metodo findall");
        ActualityTrimesterDAO dao = ActualityTrimesterFactory.create(ActualityTrimester.class);
        List<ActualityTrimester> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

}
