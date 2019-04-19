/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.RoleDAO;
import co.edu.sena.controller.factory.RoleFactory;
import co.edu.sena.model.jpa.entities.Role;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Usser
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleDAOImplTest {
     private Role role;
     
      public  RoleDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        role = new Role();
        role .setIdRole("juez");
        role .setDescription("el señor");
        role .setStatus(Boolean.TRUE);        
    }
      
    @After
    public void tearDown() {
    }
   
  @Test
    public void test1Insert() {
        System.out.println("Prueba insert de role");
        RoleDAO dao = RoleFactory.create(Role.class);
        if (dao.find(role.getIdRole()) == null) {
            dao.insert(role);
        }
        assertEquals(dao.find(role.getIdRole()), role);
    }
    
   @Test
    public void test2find(){
    
        System.out.println("Prueba consulta role");
        RoleDAO dao = RoleFactory.create(Role.class);
        Role roleconsulta =(Role) dao.find(role.getIdRole());
        assertEquals(roleconsulta, role);
    }
    
    @Test
    public void test3update (){  
       System.out.println("Prueba del Update");
        RoleDAO dao = RoleFactory.create(Role.class);
        role.setDescription("el agente es viejo");
        role.setStatus(true);
        dao.update(role);
        assertEquals(dao.find(role.getIdRole()), role);   
    }
    
    @Test 
    public void test4UpdatePrimaryKey (){
        RoleDAO dao = RoleFactory.create(Role.class);
        int resultado = dao.updatePrimaryKey("policia", role.getIdRole());
        assertEquals(resultado, 1); 
    }
    @Test 
    public void test5Delete (){
        System.out.println("Prueba del Delete");
        RoleDAO dao = RoleFactory.create(Role.class);
        role.setIdRole("policia");
        dao.remove(role);
        assertEquals(dao.find(role.getIdRole()), null);
    }
    
     @Test
    public void test6FindAll() {
        System.out.println("prueba del metodo findall");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test7FindByIdRole () {
        System.out.println("prueba de  metodo findByIdRole");
        RoleDAO dao = RoleFactory.create(Role.class);    
        List<Role> lista = dao.findByIdRole("administrador");
        assertTrue(!lista.isEmpty());
        for (Role role :lista){
            assertEquals(role.getIdRole(),"administrador");
        }      
    }
    
    @Test
    public void test8FindByDescription () {
        System.out.println("prueba de  metodo FindByDescription");
        RoleDAO dao = RoleFactory.create(Role.class);    
        List<Role> lista = dao.findByDescription("el admisnistrador ingresara a la aplicacion, asimismo creara los componentes del horario");
        assertTrue(!lista.isEmpty());
        for (Role role :lista){
            assertEquals(role.getDescription(),"el admisnistrador ingresara a la aplicacion, asimismo creara los componentes del horario");
        }      
    }
    
    @Test 
    public void test9FindByStatus() {
        System.out.println("prueba del metodo FindByStatus");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (Role project : lista) {
            assertEquals(role.getStatus(), true);
        }
    }

    @Test
    public void test10FindByLikeIdRole() {
        System.out.println("prueba del metodo findLikeIdRole  ");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByLikeIdRole("%super%");
        assertTrue(!lista.isEmpty());
    }
 
    @Test

    public void test11FindByLikeDescription() {
        System.out.println("prueba del metodo findLikeDescription");
        RoleDAO dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByLikeDescription("%super%");
        assertTrue(!lista.isEmpty());

    }
}
