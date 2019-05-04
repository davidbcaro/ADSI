/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.CustomerHasRoleDao;
import co.edu.sena.tidsplanjpa.controller.dao.RoleDao;
import co.edu.sena.tidsplanjpa.controller.factory.CustomerHasRoleFactory;
import co.edu.sena.tidsplanjpa.controller.factory.RoleFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRole;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRolePK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Role;
import java.util.ArrayList;

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
 * @author MIHOGAR
 */

public class CustomerHasRoleDaoImplTest {
    private CustomerHasRole chr;
    private CustomerHasRolePK chrpk;
    private Role r;

    public CustomerHasRoleDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        chr = new CustomerHasRole();
        chr.setCustomerHasRolePK(new CustomerHasRolePK("CC", "59874135","Administrador"));
        chr.setStatus(true);
        
        
        chrpk = new CustomerHasRolePK();
        chrpk.setDocument("CC");
        chrpk.setDocumentNumber("21488946");
        chrpk.setIdrol("Super administrador");
     
        
        
    }

    @After
    public void tearDown() {
    }
    
  @Test
    public void test01Insert() {
        System.out.println("Prueba de  insert");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        if (dao.find(chr.getCustomerHasRolePK())==null) {
            dao.insert(chr);
          
      }
      assertEquals(dao.find(chr.getCustomerHasRolePK()), chr);

    }

    
 @Test
    public void test02Find() {
        System.out.println("Prueba de  find");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        CustomerHasRole cutomerHasRoleConsulted = (CustomerHasRole) dao.find(chr.getCustomerHasRolePK());
        assertEquals(cutomerHasRoleConsulted, chr);

    }
    
    @Test
    public void test03Update(){
         System.out.println("Prueba de  update");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        chr.setStatus(false);
        dao.update(chr);
        assertEquals(dao.find(chr.getCustomerHasRolePK()), chr);
    } 
    
   
    
    @Test
    public void test05delete() {
        System.out.println("prueba de Fase de Proyecto metodo delete");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        chr.setCustomerHasRolePK(chrpk);
        dao.remove(chr);
        assertEquals(dao.find(chr.getCustomerHasRolePK()), null);
    }
    
    @Test
    public void test06FindAll() {
        System.out.println("prueba de find all");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findAll();
        assertFalse(list.isEmpty());   
    }

    /**
     * Test of findByDocumentNumber method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test07FindByDocumentNumber() {
        System.out.println("prueba de  FindByDocumentNumber");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByDocumentNumber("80013833");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            assertEquals(customerHasRole.getCustomerHasRolePK().getDocumentNumber(), "80013833");
        }
    }

    /**
     * Test of findByLikeDocumentNumber method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test08FindByLikeDocumentNumber() {
        System.out.println("prueba de  FindByLikeDocumentNumber");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByLikeDocumentNumber("%8%");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            System.out.println(customerHasRole);
        }
    }

    /**
     * Test of findByDocument method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test09FindByDocument() {
        System.out.println("prueba de  FindByDocument");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByDocument("CC");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            assertEquals(customerHasRole.getCustomerHasRolePK().getDocument(), "CC");
        }
    }

    /**
     * Test of findByLikeDocument method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test10FindByLikeDocument() {
        System.out.println("prueba de  FindByLikeDocument");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByLikeDocument("%C%");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            System.out.println(customerHasRole);
        }
    }

    /**
     * Test of findByIdRol method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test11FindByIdRol() {
        System.out.println("prueba de  FindByIdRol");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByIdRol("Administrador");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            assertEquals(customerHasRole.getCustomerHasRolePK().getIdrol(), "Administrador");
        }
    }

    /**
     * Test of findByLikeIdRol method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test12FindByLikeIdRol() {
        System.out.println("prueba de  FindByLikeIdRol");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findByLikeIdRol("%mi%");
        assertFalse(list.isEmpty());
        for (CustomerHasRole customerHasRole : list) {
            System.out.println(customerHasRole);
        }
    }

    /**
     * Test of updatePrimaryKey method, of class CustomerHasRoleDaoImpl.
     */
   

    /**
     * Test of findAll method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test14FindAll() {
         System.out.println("prueba de find all");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> list = dao.findAll();
        assertFalse(list.isEmpty());   
    }

    /**
     * Test of findByStatus method, of class CustomerHasRoleDaoImpl.
     */
    @Test
    public void test15FindByStatus() {
         System.out.println("Prueba de FindByStatus");
        CustomerHasRoleDao dao = CustomerHasRoleFactory.create(CustomerHasRole.class);
        List<CustomerHasRole> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (CustomerHasRole project : lista) {
            assertEquals(project.getStatus(), true);
        }
    }
    
}
