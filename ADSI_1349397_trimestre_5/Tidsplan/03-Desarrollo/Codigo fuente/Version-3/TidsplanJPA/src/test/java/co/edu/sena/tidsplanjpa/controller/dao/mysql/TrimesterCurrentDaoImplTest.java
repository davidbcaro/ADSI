/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.RoleDao;
import co.edu.sena.tidsplanjpa.controller.dao.TrimesterCurrentDao;
import co.edu.sena.tidsplanjpa.controller.factory.RoleFactory;
import co.edu.sena.tidsplanjpa.controller.factory.TrimesterCurrentFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Role;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterCurrent;
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

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrimesterCurrentDaoImplTest {

    private TrimesterCurrent tc;

    public TrimesterCurrentDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        tc = new TrimesterCurrent();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        tc.setIdTrimester("idt");
        tc.setStartDate(format.parse("31-24-2019"));
        tc.setEndDate(format.parse("04-10-2021"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdTrimester method, of class TrimesterCurrentDaoImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        if (dao.find(tc.getIdTrimester()) == null) {
            dao.insert(tc);
        }
        assertEquals(dao.find(tc.getIdTrimester()), tc);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba de llave primaria");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        TrimesterCurrent t = (TrimesterCurrent) dao.find(tc.getIdTrimester());
        assertEquals(t, tc);

    }
        @Test
    public void test03update() throws ParseException  {
        System.out.println("Prueba update");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        tc.getStartDate();
        tc.getEndDate();
        dao.update(tc);
        assertEquals(dao.find(tc.getIdTrimester()) , tc);
    }

   @Test
    public void test04UpdatePrimaryKey(){
        System.out.println("Prueba update primary key");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        int resultado = dao.updatePrimaryKey("TRIMI", tc.getIdTrimester());
        assertEquals(resultado, 1);
    }
    
   @Test
    public void test05delete() {
        System.out.println("prueba delete");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        tc.setIdTrimester("TRIMI");
        dao.remove(tc);
        assertEquals(dao.find(tc.getIdTrimester()), null);

    }
    
   @Test
    public void test06FindAll() {
        System.out.println("Prueba de findAll");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        List<TrimesterCurrent> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }
    
   
    @Test
    public void test07FindByIdTrimester() {
        System.out.println("Prueba de FindByIdTrimester");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        List<TrimesterCurrent> lista = dao.findByIdTrimester("T3");
        for (TrimesterCurrent trimesterCurrent : lista) {
            assertEquals(trimesterCurrent.getIdTrimester(), "T3");
        }
    }
    
      @Test
    public void test07FindByLikeIdTrimester() {
        System.out.println("Prueba de  findByLikeIdTrimester");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
        List<TrimesterCurrent> lista = dao.findByLikeIdTrimester("%3%");
        for (TrimesterCurrent trimesterCurrent : lista) {
            System.out.println(trimesterCurrent);
        }
        assertTrue(!lista.isEmpty());
    }
    
     @Test
    public void test08FindByStartDate() throws ParseException {
        System.out.println("Prueba de FindByStartDate");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
         SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<TrimesterCurrent> lista = dao.findByStartDate(format.parse("2017-10-24"));
        for (TrimesterCurrent trimesterCurrent : lista) {
            assertEquals(trimesterCurrent.getStartDate(), "2017-10-24");
        }
    }
    
     @Test
    public void test09FindByEndDate() throws ParseException {
        System.out.println("Prueba de FindByEndDate");
        TrimesterCurrentDao dao = TrimesterCurrentFactory.create(TrimesterCurrent.class);
         SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<TrimesterCurrent> lista = dao.findByEndDate(format.parse("2018-03-21"));
        for (TrimesterCurrent trimesterCurrent : lista) {
            assertEquals(trimesterCurrent.getStartDate(), "2018-03-21");
        }
    }
    
     

}
