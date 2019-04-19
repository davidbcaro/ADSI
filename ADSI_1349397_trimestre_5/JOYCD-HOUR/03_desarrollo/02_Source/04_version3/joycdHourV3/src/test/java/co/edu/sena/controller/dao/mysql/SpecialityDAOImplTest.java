/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.SpecialityDAO;
import co.edu.sena.controller.factory.SpecialityFactory;
import co.edu.sena.model.jpa.entities.Speciality;
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
public class SpecialityDAOImplTest {

    private Speciality sp;

    public SpecialityDAOImplTest() {

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
        sp.setNameSpeciality("musica");
        sp.setStatus(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameSpeciality method, of class SpecialityDAOImpl.
     */
    @Test
    public void test1Insert() {
        System.out.println("test Insert Speciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        if (dao.find(sp.getNameSpeciality()) == null) {
            dao.insert(sp);
        }
        assertEquals(dao.find(sp.getNameSpeciality()), sp);

    }

    /**
     * Test of findByStatus method, of class DayDAOImpl.
     */
    @Test
    public void test2find() {
        System.out.println("Prueba consulta Speciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        Speciality spconsulta = (Speciality) dao.find(sp.getNameSpeciality());
        assertEquals(spconsulta, sp);
    }

    /**
     * Test of findByLikeNameDay method, of class DayDAOImpl.
     */
    @Test
    public void test3update() {
        System.out.println("Preba test uptdate");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        sp.setStatus(Boolean.FALSE);
        dao.update(sp);
        assertEquals(dao.find(sp.getNameSpeciality()), sp);
    }

    @Test
    public void test3vUpdatePrimarykey() {
        System.out.println("prueba de update Speciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        int resultado = dao.updatePrimaryKey("SpecialidadNormal", sp.getNameSpeciality());
        assertEquals(resultado, 1);

    }

    //lanza error
    @Test
    public void test4FindByLikeNameSpeciality() {
        System.out.println("Prueba findlikeNameSpeciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByLikeNameSpeciality("S%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba consulta tabla Speciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }

    @Test
    public void Test6Delete() {
        System.out.println("prueba de Delete tabla Speciality");
        SpecialityDAO dao = SpecialityFactory.create(Speciality.class);
        sp.setNameSpeciality("SpecialidadNormal");
        dao.remove(sp);
        assertEquals(dao.find(sp.getNameSpeciality()), null);
    }

}
