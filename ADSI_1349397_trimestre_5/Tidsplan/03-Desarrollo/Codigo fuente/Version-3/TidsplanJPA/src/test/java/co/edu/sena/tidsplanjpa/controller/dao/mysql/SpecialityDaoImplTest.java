/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.SpecialityDao;
import co.edu.sena.tidsplanjpa.controller.factory.SpecialityFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Speciality;
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
 * @author MIHOGAR
 */@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecialityDaoImplTest {
     private Speciality sp;
    public SpecialityDaoImplTest() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sp = new Speciality();
        sp.setNameSpeciality("d");
        sp.setStatus(Boolean.TRUE);
        sp.setPhoto(null);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void test01Insert() {
         System.out.println("Prueba insert");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        if (dao.find(sp.getNameSpeciality()) == null) {
            dao.insert(sp);

        }
        assertEquals(dao.find(sp.getNameSpeciality()), sp);
    }
    
    @Test
    public void test02find() {
        System.out.println("Prueba de find");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        Speciality s = (Speciality) dao.find(sp.getNameSpeciality());
        assertEquals(s, sp);
    }
    
    @Test
    public void test03update() {
        System.out.println("Prueba update");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        sp.setStatus(Boolean.FALSE);
        dao.update(sp);
        assertEquals(dao.find(sp.getNameSpeciality()) , sp);
    }
    
    @Test
    public void test04UpdatePrimaryKey(){
        System.out.println("Prueba update primary key");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        int result = dao.updatePrimaryKey("Prueba", sp.getNameSpeciality());
        assertEquals(result, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba delete");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        sp.setNameSpeciality("Prueba");
        dao.remove(sp);
        assertEquals(dao.find(sp.getNameSpeciality()), null);

    }
      @Test
    public void test06FindAll() {
        System.out.println("Prueba de findAll");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }
    @Test
    public void test07FindByNameSpeciality() {
      System.out.println("Prueba de FindByNameSpeciality");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByNameSpeciality("ELECTRICIDAD");
        for (Speciality speciality : lista) {
            assertEquals(speciality.getNameSpeciality(), "ELECTRICIDAD");
        }
    }

    /**
     * Test of findByLikeNameSpeciality method, of class SpecialityDaoImpl.
     */
    @Test
    public void test08FindByLikeNameSpeciality() {
        System.out.println("Prueba de  FindByLikeNameSpeciality");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByLikeNameSpeciality("%T%");
        for (Speciality speciality: lista) {
            System.out.println(speciality);
        }
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByStatus method, of class SpecialityDaoImpl.
     */
    @Test
    public void test09FindByStatus() {
       System.out.println("Prueba de  FindByStatus");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByStatus(false);
        for (Speciality speciality : lista) {
            assertEquals(speciality.getStatus(), false);
        }
    }

    
}
