/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.InstructorDao;
import co.edu.sena.tidsplanjpa.controller.factory.InstructorFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EmploymentRelationship;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Instructor;
import co.edu.sena.tidsplanjpa.model.jpa.entities.InstructorPK;
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
public class InstructorDaoImplTest {
    private Instructor in;
    private InstructorPK inpk;
   

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
        in = new Instructor();
        in.setTypeEmploymentRelationship(new EmploymentRelationship("medio tiempo"));
        in.setNameSpeciality(new Speciality("ELECTRICIDAD"));
        in.setInstructorPK(new InstructorPK("CC", "21488946"));
       
        inpk = new InstructorPK();
        inpk.setDocumentNumber("21488946");
        inpk.setDocument("CC");
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByTypeEmploymentRelationship method, of class InstructorDaoImpl.
     */
     @Test
    public void test01Insert() {
        System.out.println("Prueba de  insert");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        if (dao.find(in.getInstructorPK()) == null) {
            dao.insert(in);
        }
        assertEquals(dao.find(in.getInstructorPK()), in);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de  find");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        Instructor instructorConsulted = (Instructor) dao.find(in.getInstructorPK());
        assertEquals(instructorConsulted, in);

    }
    
    @Test
    public void test03Update(){
         System.out.println("Prueba de Update");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
   
        dao.update(in);
        assertEquals(dao.find(in.getInstructorPK()), in);
    } 
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de  update por llave primaria");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        int resultado = dao.updatePrimaryKey(inpk ,in.getInstructorPK());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba de o delete");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        in.setInstructorPK(inpk);
        dao.remove(in);
        assertEquals(dao.find(in.getInstructorPK()), null);
    }
    
    @Test
    public void test06FindAll() {
        System.out.println("prueba de  findAll");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findAll();
        assertFalse(list.isEmpty());   
    }

    @Test
    public void test07FindByTypeEmploymentRelationship() {
       System.out.println("prueba de  FindByTypeEmploymentRelationship");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByTypeEmploymentRelationship("tiempo completo");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            assertEquals(instructor.getTypeEmploymentRelationship().getTypeEmploymentRelationship(), "tiempo completo");
        }
    }

    /**
     * Test of findByLikeTypeEmploymentRelationship method, of class InstructorDaoImpl.
     */
    @Test
    public void test08FindByLikeTypeEmploymentRelationship() {
        System.out.println("prueba de FindByLikeTypeEmploymentRelationship");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByLikeTypeEmploymentRelationship("%o%");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            System.out.println(instructor);
        }
    }

    /**
     * Test of findByNameSpeciality method, of class InstructorDaoImpl.
     */
    @Test
    public void test09FindByNameSpeciality() {
        System.out.println("prueba de  FindByNameSpeciality");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByNameSpeciality("TELEINFORMATICA");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            assertEquals(instructor.getNameSpeciality().getNameSpeciality(), "TELEINFORMATICA");
        }
    }

    /**
     * Test of findByLikeNameSpeciality method, of class InstructorDaoImpl.
     */
    @Test
    public void test10FindByLikeNameSpeciality() {
        System.out.println("prueba de FindByLikeNameSpeciality");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByLikeNameSpeciality("%E%");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            System.out.println(instructor);
        }
    }

    /**
     * Test of findByDocumentNumber method, of class InstructorDaoImpl.
     */
    @Test
    public void test11FindByDocumentNumber() {
       System.out.println("prueba de  FindByDocumentNumber");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByDocumentNumber("14796314");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            assertEquals(instructor.getInstructorPK().getDocumentNumber(), "14796314");
        }
    }

    /**
     * Test of findByLikeDocumentNumber method, of class InstructorDaoImpl.
     */
    @Test
    public void test12FindByLikeDocumentNumber() {
       System.out.println("prueba de FindByLikeDocumentNumber");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByLikeDocumentNumber("%4%");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            System.out.println(instructor);
        }
    }

    /**
     * Test of findByDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test13FindByDocument() {
        System.out.println("prueba de  FindByDocument");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByDocument("CC");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            assertEquals(instructor.getInstructorPK().getDocument(), "CC");
        }
    }

    /**
     * Test of findByLikeDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test14FindByLikeDocument() {
       System.out.println("prueba de FindByLikeDocument");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> list = dao.findByLikeDocument("%C%");
        assertFalse(list.isEmpty());
        for (Instructor instructor : list) {
            System.out.println(instructor);
        }
    }

   
    
}
