/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.DisponibilityDao;
import co.edu.sena.cot.controlador.dao.EmailServerDao;
import co.edu.sena.cot.controlador.dao.LogErrorDao;
import co.edu.sena.cot.controlador.factory.mysql.DisponibilityFactory;
import co.edu.sena.cot.controlador.factory.mysql.EmailServerFactory;
import co.edu.sena.cot.controlador.factory.mysql.LogErrorFactory;
import co.edu.sena.cot.modelo.dto.Disponibility;
import co.edu.sena.cot.modelo.dto.DisponibilityPK;
import co.edu.sena.cot.modelo.dto.EmailServer;
import co.edu.sena.cot.modelo.dto.LogError;
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
public class DisponiblityDaoImplTest {

    private Disponibility dp;
    private DisponibilityPK dppk;

    public DisponiblityDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "31-08-1982";
        Date date = sdf.parse(dateInString);
        dp = new Disponibility();
        dp.setDisponibilityPK(new DisponibilityPK(date, 80013831, "CC", "D", "Jueves"));
        dp.setEndDate(date);
        
        
        String dateInString2 = "31-08-1999 10:20:56";
        Date date2 = sdf.parse(dateInString2);
        
        dppk = new DisponibilityPK(date2, 987654321, "CC", "M", "Domingo");
                

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdDisponibility method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test01Insert() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        if (dao.find(dp.getDisponibilityPK()) == null) {
            dao.insert(dp);

        }
        assertEquals(dao.find(dp.getDisponibilityPK()), dp);
    }

    /**
     * Test of findByStartDate method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test02FindByStartDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "31-08-1982";
        Date date = sdf.parse(dateInString);
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByStartDate(date);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByEndDate method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test03FindByEndDate() throws ParseException {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        SimpleDateFormat by = new SimpleDateFormat("dd-MM-yyyy");
        Date by2 = by.parse("31-08-1982");
        List<Disponibility> lista = dao.findByEndDate(by2);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByNumberDocument method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test04FindByNumberDocument() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByNumberDocument(80013831);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);

    }

    /**
     * Test of findByDocument method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test05FindByDocument() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByDocument("CC");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByWorkDInitiasl method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test06FindByWorkDInitiasl() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByWorkDInitiasl("D");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByNameDayi method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test07FindByNameDayi() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByNameDayi("Jueves");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeIdDisponibility method, of class DisponiblityDaoImpl.
     */
   
    /**
     * Test of findByLikeNumberDocument method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test08FindByLikeNumberDocument() {
    System.out.println("lassssss");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByLikeNumberDocument("%8%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeDocument method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test09FindByLikeDocument() {
        System.out.println("lassssss");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByLikeDocument("%C%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeWorkDInitiasl method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test10FindByLikeWorkDInitiasl() {
       System.out.println("lassssss");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByLikeWorkDInitiasl("%D%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeNameDayi method, of class DisponiblityDaoImpl.
     */
    @Test
    public void test11FindByLikeNameDayi() {
        System.out.println("lassssss");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> lista = dao.findByLikeNameDayi("%J%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
    
    @Test
    public void test17UpdatePK() {
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        dao.updatePK(dppk, dp.getDisponibilityPK());
        dp.setDisponibilityPK(dppk);
        assertEquals(dao.find(dppk), dp);

    }
    
     @Test
        public void test18Delete() throws ParseException{
        SimpleDateFormat by = new SimpleDateFormat("dd-MM-yyyy");
        Date by2 = by.parse("31-08-1999");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        dp.setDisponibilityPK( new DisponibilityPK(by2, 987654321, "CC", "M", "Domingo"));
        
        dao.remove(dp);
        assertEquals(dao.find(dp.getDisponibilityPK()), null);
        }

}
