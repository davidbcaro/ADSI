/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.SpecialityDao;
import co.edu.sena.eon_jpa.controller.factory.SpecialityFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Speciality;
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
 * @author Liliana Narvaez
 */
public class SpecialityDaoImplTest {

    Speciality s;

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

        s = new Speciality();
        s.setSpecialityName("lool");
        s.setStatus(Boolean.FALSE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        if (dao.find(s.getSpecialityName()) == null) {
            dao.insert(s);
        }
        assertEquals(dao.find(s.getSpecialityName()), s);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de tipo de documento metodo find por llave primaria");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        Speciality speciality = (Speciality) dao.find(s.getSpecialityName());
        assertEquals(speciality, s);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        s.setStatus(Boolean.TRUE);
        dao.update(s);
        assertEquals(dao.find(s.getSpecialityName()), s);
    }
        
    @Test
    public void test3vUpdatePrimaryKey() {
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        int resultado = dao.updatePrimaryKey("iiiii", s.getSpecialityName());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4FindAll() {
        System.out.println("prueba metodo findall");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test5Remove() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        s.setSpecialityName("iiiii");
        dao.remove(s);
        assertEquals(dao.find(s.getSpecialityName()), null);

    }

    @Test
    public void test6findspecialityName() {
        System.out.println("prueba de metodo findDescripcion del dao");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByspecialityName("Lider del Programa");
        for (Speciality s : lista) {
            assertEquals(s.getSpecialityName(), "Lider del Programa");
        }
    }

    @Test
    public void test6Findstatus() {
        System.out.println("prueba de metodo findDescripcion del dao");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByStatus(true);
        for (Speciality s : lista) {
            assertEquals(s.getStatus(), true);
        }
    }

    @Test
    public void test6findBylikespecialityName() {
        System.out.println("prueba del metodo findDescripcion del dao ");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findBylikespecialityName("%A%");
        assertTrue(!lista.isEmpty());

    }   
}
