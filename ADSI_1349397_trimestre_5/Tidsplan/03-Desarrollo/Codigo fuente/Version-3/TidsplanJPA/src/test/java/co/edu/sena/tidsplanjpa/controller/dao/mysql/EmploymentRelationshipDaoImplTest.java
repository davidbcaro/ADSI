/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.EmploymentRelationshipDao;
import co.edu.sena.tidsplanjpa.controller.factory.EmploymentRelationshipFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EmploymentRelationship;
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
public class EmploymentRelationshipDaoImplTest {
    private EmploymentRelationship er;
    public EmploymentRelationshipDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        er = new EmploymentRelationship();
        er.setTypeEmploymentRelationship("Planta");
        er.setHours(6);
        er.setStatus(true);
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByTypeEmploymentRelationShip method, of class EmploymentRelationshipDaoImpl.
     */
      @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        if (dao.find(er.getTypeEmploymentRelationship()) == null) {
            dao.insert(er);
        }
        assertEquals(dao.find(er.getTypeEmploymentRelationship()), er);
    }
    
    @Test
    public void test02find() {
        System.out.println("Prueba de find");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        EmploymentRelationship e = (EmploymentRelationship) dao.find(er.getTypeEmploymentRelationship());
        assertEquals(e, er);
    }
    
    @Test
    public void test03update() {
        System.out.println("Prueba update");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        er.setStatus(false);
        er.setStatus(Boolean.TRUE);
        dao.update(er);
        assertEquals(dao.find(er.getTypeEmploymentRelationship()) , er);
    }
    
    @Test
    public void test04UpdatePrimaryKey(){
        System.out.println("prueba de metodo update por llave primaria");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        int resultado = dao.updatePrimaryKey("timo", er.getTypeEmploymentRelationship());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba delete");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        er.setTypeEmploymentRelationship("timo");
        dao.remove(er);
        assertEquals(dao.find(er.getTypeEmploymentRelationship()), null);

    }
      @Test
    public void test06FindAll() {
        System.out.println("Prueba de findAll");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }
    @Test
    public void test07FindByTypeEmploymentRelationShip() {
         System.out.println("Prueba de FindByTypeEmploymentRelationShip");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> lista = dao.findByTypeEmploymentRelationShip("medio tiempo");
        for (EmploymentRelationship employmentRelationship : lista) {
            assertEquals(employmentRelationship.getTypeEmploymentRelationship(), "medio tiempo");
        }
    }

    /**
     * Test of findByLikeTypeEmploymentRelationShip method, of class EmploymentRelationshipDaoImpl.
     */
    @Test
    public void test08FindByLikeTypeEmploymentRelationShip() {
        System.out.println("Prueba de  FindByLikeTypeEmploymentRelationShip");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> lista = dao.findByLikeTypeEmploymentRelationShip("%e%");
        assertTrue(!lista.isEmpty());
        for (EmploymentRelationship employmentRelationship : lista) {
            System.out.println(employmentRelationship);
        }
    }

    /**
     * Test of findByHours method, of class EmploymentRelationshipDaoImpl.
     */
    @Test
    public void test09FindByHours() {
          System.out.println("Prueba de FindByHours");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> lista = dao.findByHours(12);
        assertTrue(!lista.isEmpty());
        for (EmploymentRelationship employmentRelationship : lista) {
            assertEquals(employmentRelationship.getHours(), 12);
        }
    }

  @Test
    public void test10FindByLikeHours() {
        System.out.println("Prueba de FindByLikeHours");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> lista = dao.findByLikeHours("%2%");
        for (EmploymentRelationship employmentRelationship : lista) {
            System.out.println(employmentRelationship);
        }
         assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test11FindByStatus() {
          System.out.println("Prueba de FindByStatus");
        EmploymentRelationshipDao dao = EmploymentRelationshipFactory.create(EmploymentRelationship.class);
        List<EmploymentRelationship> lista = dao.findByStatus(true);
        for (EmploymentRelationship employmentRelationship : lista) {
            System.out.println(employmentRelationship);
            assertEquals(employmentRelationship.getStatus(), true);
        }
    }

}
