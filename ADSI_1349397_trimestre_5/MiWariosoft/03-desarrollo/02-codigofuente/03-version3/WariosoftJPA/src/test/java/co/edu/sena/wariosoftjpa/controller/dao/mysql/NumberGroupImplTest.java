/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.NumberGroupFactory;
import co.edu.sena.wariosoftjpa.controller.dao.NumberGroupDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroup;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
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
public class NumberGroupImplTest {

    private NumberGroup st;

    public NumberGroupImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        st = new NumberGroup();
        st.setNumberGroup("13493972");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        st.setStartDate(formatter.parse("24-11-2017"));
        st.setEndDate(formatter.parse("24-11-2018"));
        st.setRoute("566");
        st.setNameState(new StateNumberGroup("En formacion"));

        st.setProgram(new Program("228106", "Version 102"));
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
       System.out.println("prueba de tipo de StateNumberGroup metodo insert");
       NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        if (dao.find(st.getNumberGroup()) == null) {
            dao.insert(st);
        } 
        assertEquals(dao.find(st.getNumberGroup()), st);
    }
     @Test
    public void test2find() {
        System.out.println("prueba de StateNumberGroup metodo find por llave primaria");
        NumberGroupDAO dao =  NumberGroupFactory.create(NumberGroup.class);
        NumberGroup numberGroupConsultado = (NumberGroup) dao.find(st.getNumberGroup());
        assertEquals(numberGroupConsultado, st);
    }
    @Test
    public void test3update() throws ParseException {
        System.out.println("prueba de StateNumberGroup metodo update po llave primaria");
        NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        st.setStartDate(formatter.parse("24-11-2016"));
        dao.update(st);
        assertEquals(dao.find(st.getNumberGroup()), st);

        
    }
    @Test
    public void test3updatePk() {
        NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        int resultado = dao.updatePk("13493971", st.getNumberGroup());
        assertEquals(resultado, 1);
    }
    @Test
    public void test4delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        st.setNumberGroup("13493971");
        dao.remove(st);
        assertEquals(dao.find(st.getNumberGroup()), null);

    }
     @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
       NumberGroupDAO dao =  NumberGroupFactory.create(NumberGroup.class);
        List< NumberGroup> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }


    /**
     * Test of findByNumberGroup method, of class NumberGroupImpl.
     */
    @Test
    public void test6FindByNumberGroup() {
       System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByNumberGroup("13493972");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getNumberGroup(), "13493972");
        }
    }

    /**
     * Test of findByStartDate method, of class NumberGroupImpl.
     */
    @Test
    public void test7FindByStartDate() throws ParseException  {
       System.out.println("findByStartDate");
        NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Date fecha = formatter.parse("01-12-2016");
        List<NumberGroup> lista = dao.findByStartDate(formatter.parse("01-12-2016"));
        assertTrue(!lista.isEmpty());
 
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getStartDate(), fecha);

        }

    }

    /**
     * Test of findByEndDate method, of class NumberGroupImpl.
     */
    @Test
    public void test8FindByEndDate()throws ParseException   {
        System.out.println("findByEndDate");
        NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Date fecha = formatter.parse("30-11-2018");
        List<NumberGroup> lista = dao.findByEndDate(formatter.parse("30-11-2018"));
        assertTrue(!lista.isEmpty());
 
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getEndDate(), fecha);

        }
    }

    /**
     * Test of findByRoute method, of class NumberGroupImpl.
     */
    @Test
    public void test9FindByRoute() {
    System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
         
        List<NumberGroup> lista = dao.findByRoute("566");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getRoute(), "566");
        }
    
    
    }

    /**
     * Test of findByNameState method, of class NumberGroupImpl.
     */
    @Test
    public void test10FindByNameState() {
          System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByNameState("En formacion");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getNameState().getNameState(),"En formacion");
        
        }
    }

    /**
     * Test of findByProgramCode method, of class NumberGroupImpl.
     */
    @Test
    public void test11FindByProgramCode() {
         System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByNameState("En formacion");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getNameState().getNameState(),"En formacion");
        }
    }

    /**
     * Test of findByVersion method, of class NumberGroupImpl.
     */
    @Test
    public void test12FindByVersion() {
         System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByVersion("version 102");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getProgram().getProgramPK().getVersion(),"version 102");
        }
    }

    /**
     * Test of findByLikeNameState method, of class NumberGroupImpl.
     */
    @Test
    public void test13FindByLikeNameState() {
         System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeNameState("En formacion");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getNameState().getNameState(),"En formacion");
        
        }
    }

    /**
     * Test of findByLikeProgramCode method, of class NumberGroupImpl.
     */
    @Test
    public void test14FindByLikeProgramCode() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeProgramCode("En formacion");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getNameState().getNameState(),"En formacion");
        }
    }

    /**
     * Test of findByLikeVersion method, of class NumberGroupImpl.
     */
    @Test
    public void test15FindByLikeVersion() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         NumberGroupDAO dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeVersion("version 102");
        for (NumberGroup numberGroup : lista) {
            assertEquals(numberGroup.getProgram().getProgramPK().getVersion(),"version 102");
        }
    }

    /**
     * Test of updatePk method, of class NumberGroupImpl.
     */
   
}
