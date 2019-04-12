/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AvailabilityDao;
import co.edu.sena.eon_jpa.controller.factory.AvailabilityFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Availability;
import co.edu.sena.eon_jpa.model.jpa.entities.AvailabilityPK;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 *
 * @author 1349397
 */
public class AvailabilityDaoImplTest {

    private Availability a;
    private AvailabilityPK aPK;
    

    public AvailabilityDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        a = new Availability();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        a.setAvailabilityPK(new AvailabilityPK("80013833", "CC",formatter.parse(("06:00:00")), "N", "Jueves"));
        a.setEndTime(formatter.parse("14:00:00"));
        
        
        aPK = new AvailabilityPK ("12345", "CC" ,formatter.parse(("06:00:00")), "D","Jueves");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de bonding metodo insert");
        AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        if (dao.find(a.getAvailabilityPK()) == null) {
            dao.insert(a);
        }
        assertEquals(dao.find(a.getAvailabilityPK()), a);
    }

    @Test
    public void test2find() {

        System.out.println("Test Find");
        AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        Availability specialtyConsulted = (Availability) dao.find(a.getAvailabilityPK());
        assertEquals(specialtyConsulted, a);

    }

    @Test
    public void test3update() throws ParseException {
        System.out.println("Prueba de vinculación metodo update por llave primaria");
        AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        a.setEndTime(formatter.parse("15:00:00"));
        dao.update(a);
        assertEquals(dao.find(a.getAvailabilityPK()), a);

    }

// Test ignorado    
//   @Test
//    public void test3vUpdatePrimaryKey() {
//         AvailabilityDao dao =  AvailabilityFactory.create( Availability.class);
//        dao.UpdatePrimaryKey(aPK,a.getAvailabilityPK());
//        a.setAvailabilityPK(aPK);
//        assertEquals(dao.find(aPK), a);
//    }
    

    @Test
    public void test4Delete()  throws ParseException {
          AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        a.setAvailabilityPK(aPK);
        dao.remove(a);
        assertEquals(dao.find(a.getAvailabilityPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Prueba de vinculación metodo findAll");
        AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        List<Availability> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void test6FindByStartTime() throws ParseException {
        System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        Date Hora = formatter.parse("06:00:00");
        List<Availability> lista = dao.findByStartTime(Hora);
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getAvailabilityPK().getStartTime(),Hora);
        }

    }
    @Test
    public void test7FindByEndTime() throws ParseException {
         System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        List<Availability> lista = dao.findByEndTime(formatter.parse("14:00:00"));
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getEndTime(),formatter.parse("14:00:00"));
        }
    }

  
    @Test
    public void test8FindByIdDocument() {
          System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        List<Availability> lista = dao.findByIdDocument("CC");
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getAvailabilityPK().getIdDocument(),"CC");
        
    }
    }

    
    @Test
    public void test9FindByDocumentNumber() {
           System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        List<Availability> lista = dao.findByDocumentNumber("80013833");
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getAvailabilityPK().getDocumentNumber(),"80013833");
        
    }
    }

    
    @Test
    public void test10FindByAcronymsWorkingDay() {
             System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        List<Availability> lista = dao.findByAcronymsWorkingDay("D");
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getAvailabilityPK().getAcronymsWorkingDay(),"D");
        
    }
    }

    /**
     * Test of findByNameDay method, of class AvailabilityDaoImpl.
     */
    @Test
    public void test11FindByNameDay() {
        
        System.out.println("Prueba del metodo findBondingType del dao Vinculación");
       AvailabilityDao dao = AvailabilityFactory.create(Availability.class);
        List<Availability> lista = dao.findByNameDay("Lunes");
        assertTrue(!lista.isEmpty());
        for (Availability bonding : lista) {
            assertEquals(bonding.getAvailabilityPK().getNameDay(),"Lunes");
        
    }
    }

    /**
     * Test of findByLikeStarTime method, of class AvailabilityDaoImpl.
     */
   

    /**
     * Test of findByLikeEndTime method, of class AvailabilityDaoImpl.
    

    /**
     * Test of findByLikeIdDocument method, of class AvailabilityDaoImpl.
     */
    @Test
    public void test12FindByLikeIdDocument() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
         AvailabilityDao dao =  AvailabilityFactory.create( Availability.class);
        List<Availability> lista = dao.findByLikeIdDocument("C%");
        assertTrue(!lista.isEmpty());
        for ( Availability RoleHasCustomer : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

    /**
     * Test of findByLikeDocumentNumber method, of class AvailabilityDaoImpl.
     */
    @Test
    public void test13FindByLikeDocumentNumber() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
         AvailabilityDao dao =  AvailabilityFactory.create( Availability.class);
        List<Availability> lista = dao.findBylikeDocumentNumber("8%");
        assertTrue(!lista.isEmpty());
        for ( Availability RoleHasCustomer : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

    /**
     * Test of findByLikeAcronymsWorkingDay method, of class
     * AvailabilityDaoImpl.
     */
    @Test
    public void test14FindByLikeAcronymsWorkingDay() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
         AvailabilityDao dao =  AvailabilityFactory.create( Availability.class);
        List<Availability> lista = dao.findByLikeAcronymsWorkingDay("D%");
        assertTrue(!lista.isEmpty());
        for ( Availability RoleHasCustomer : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

    /**
     * Test of findByLikeNameDay method, of class AvailabilityDaoImpl.
     */
    @Test
    public void test15FindByLikeNameDay() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
         AvailabilityDao dao =  AvailabilityFactory.create( Availability.class);
        List<Availability> lista = dao.findByLikeNameDay("L%");
        assertTrue(!lista.isEmpty());
        for ( Availability RoleHasCustomer : lista) {
            assertTrue(!lista.isEmpty());
        }
    }


}
