/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.InstructorDao;
import co.edu.sena.eon_jpa.controller.factory.InstructorFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Bonding;
import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.InstructorPK;
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

public class InstructorDaoImplTest {

    private Instructor i;
    private InstructorPK iPK;

    public InstructorDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        i = new Instructor();
        i.setInstructorPK(new InstructorPK("1234", "CC"));

        i.setSpecialityName(new Speciality("ubygby"));
        i.setTypeLinkage(new Bonding("yvugyj"));

        iPK = new InstructorPK("12345", "CC");

    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void test1Insert() {
//
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        dao.insert(i);
//        Instructor rhc = (Instructor) dao.find(i.getInstructorPK());
//        assertEquals(rhc, i);
//    }
//
//    @Test
//    public void test2find() {
//
//        System.out.println("prueba de role metodo find por llave primaria");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        Instructor cConsulted = (Instructor) dao.find(i.getInstructorPK());
//        assertEquals(cConsulted, i);
//
//    }
//
//    @Test
//    public void test3update() {
//        System.out.println("Prueba de Role metodo update por llave primaria");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        i.setInstructorPK(new InstructorPK("1234", "CC"));
//        dao.update(i);
//        assertEquals(dao.find(i.getInstructorPK()), i);
//    }
//
//    @Test
//    public void test4FindByDocumentNumber() {
//        System.out.println("Prueba del metodo findBondingType del dao Vinculación");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        List<Instructor> lista = dao.findByDocumentNumber("80013833");
//        assertTrue(!lista.isEmpty());
//        for (Instructor bonding : lista) {
//            assertEquals(bonding.getInstructorPK().getDocumentNumber(), "80013833");
//
//        }
//    }
//
//    /**
//     * Test of findByIdDocument method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test4FindByIdDocument() {
//        System.out.println("Prueba del metodo findBondingType del dao Vinculación");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        List<Instructor> lista = dao.findByIdDocument("CC");
//        assertTrue(!lista.isEmpty());
//        for (Instructor bonding : lista) {
//            assertEquals(bonding.getInstructorPK().getIdDocument(), "CC");
//        }
//    }
//
//    /**
//     * Test of findBySpecialityName method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test4FindBySpecialityName() {
//        System.out.println("findBySpecialityName");
//        String specialityName = "";
//        InstructorDaoImpl instance = null;
//        List<Instructor> expResult = null;
//        List<Instructor> result = instance.findBySpecialityName(specialityName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByTypeLinkage method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test4FindByTypeLinkage() {
//        System.out.println("findByTypeLinkage");
//        String typeLinkage = "";
//        InstructorDaoImpl instance = null;
//        List<Instructor> expResult = null;
//        List<Instructor> result = instance.findByTypeLinkage(typeLinkage);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByLikeDocumentNumber method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test6FindByLikeDocumentNumber() {
//        System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        List<Instructor> lista = dao.findByLikeDocumentNumber("8%");
//        assertTrue(!lista.isEmpty());
//        for (Instructor RoleHasCustomer : lista) {
//            assertTrue(!lista.isEmpty());
//        }
//    }
//
//    /**
//     * Test of findByLikeIdDocument method, of class InstructorDaoImpl.
//     */
//    @Test
//
//    public void test6FindByLikeIdDocument() {
//        System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
//        InstructorDao dao = InstructorFactory.create(Instructor.class);
//        List<Instructor> lista = dao.findByLikeIdDocument("C%");
//        assertTrue(!lista.isEmpty());
//        for (Instructor RoleHasCustomer : lista) {
//            assertTrue(!lista.isEmpty());
//        }
//    }
//
//    /**
//     * Test of findByLikeSpecialityName method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test4FindByLikeSpecialityName() {
//        System.out.println("findByLikeSpecialityName");
//        String specialityName = "";
//        InstructorDaoImpl instance = null;
//        List<Instructor> expResult = null;
//        List<Instructor> result = instance.findByLikeSpecialityName(specialityName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByLikeTypeLinkage method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test4FindByLikeTypeLinkage() {
//        System.out.println("findByLikeTypeLinkage");
//        String typeLinkage = "";
//        InstructorDaoImpl instance = null;
//        List<Instructor> expResult = null;
//        List<Instructor> result = instance.findByLikeTypeLinkage(typeLinkage);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePrimaryKey method, of class InstructorDaoImpl.
//     */
//    @Test
//    public void test3UpdatePrimaryKey() {
//        System.out.println("updatePrimaryKey");
//        InstructorPK newKey = null;
//        InstructorPK oldKey = null;
//        InstructorDaoImpl instance = null;
//        int expResult = 0;
//        int result = instance.UpdatePrimaryKey(newKey, oldKey);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

}
