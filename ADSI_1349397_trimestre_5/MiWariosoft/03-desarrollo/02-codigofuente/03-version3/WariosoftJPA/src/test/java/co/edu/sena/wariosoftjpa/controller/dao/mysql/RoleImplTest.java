/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.RoleFactory;
import co.edu.sena.wariosoftjpa.controller.dao.RoleDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Role;
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
 * @author Brayan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleImplTest {
    
    private Role rt;
    
    public RoleImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rt = new Role();
        rt.setIdRole("Maxter");
        rt.setDescriptionRole("es el mas kpo");
        rt.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de Role metodo insert");
        RoleDAO dao = RoleFactory.create(Role.class);
        if (dao.find(rt.getIdRole()) == null) {
            dao.insert(rt);
        }
        assertEquals(dao.find(rt.getIdRole()), rt);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de Role find por llave primaria");
        RoleDAO dao = RoleFactory.create(Role.class);
        Role RoleConsultado = (Role) dao.find(rt.getIdRole());
        assertEquals(RoleConsultado, rt);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de Role metodo update po llave primaria");
        RoleDAO dao = RoleFactory.create(Role.class);
        rt.setState(Boolean.FALSE);
        dao.update(rt);
        assertEquals(dao.find(rt.getIdRole()), rt);
    }

    @Test
    public void test3updatePk() {
        RoleDAO dao = RoleFactory.create(Role.class);
        int resultado = dao.updatePk("Mayister", rt.getIdRole());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4delete() {
        System.out.println("prueba de Role metodo delete para la llave");
        RoleDAO dao = RoleFactory.create(Role.class);
        rt.setIdRole("Mayister");
        dao.remove(rt);
        assertEquals(dao.find(rt.getIdRole()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de Role metodo findall");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    /**
     * Test of findByIdRole method, of class RoleImpl.
     */
    @Test
    public void test6FindByIdRole() {
        System.out.println("findByIdRole");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByIdRole("Maxter");
        for (Role role : lista) {
            assertEquals(role.getIdRole(), "Maxter");
        }
    }

    /**
     * Test of findByDescriptionRole method, of class RoleImpl.
     */
    
    
    
    @Test
    public void testFindByDescriptionRole() {
        System.out.println("findByDescriptionRole");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByIdRole("es el mas kpo");
        for (Role role : lista) {
            assertEquals(role.getIdRole(), "es el mas kpo");
        }
    }

    /**
     * Test of findByState method, of class RoleImpl.
     */
    @Test
    public void testFindByState() {
        System.out.println("findByState");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByState(true);
        for (Role role : lista) {
            assertEquals(role.getState(), true);
        }
    }

    /**
     * Test of findByLikeIdRole method, of class RoleImpl.
     */
    @Test
    public void testFindByLikeIdRole() {
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByLikeIdRole("A%");
        assertTrue(!lista.isEmpty());
    }
    
}
