/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.dao.RoleDAO;
import co.edu.sena.controller.dao.StatusGroupNumberDAO;
import co.edu.sena.controller.factory.ProjectFactory;
import co.edu.sena.controller.factory.RoleFactory;
import co.edu.sena.controller.factory.StatusGroupNumberFactory;
import co.edu.sena.model.jpa.entities.Project;
import co.edu.sena.model.jpa.entities.Role;
import co.edu.sena.model.jpa.entities.StatusGroupNumber;
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
    /**
     * Test of findByStatusName method, of class StatusGroupNumberDAOImpl.
     */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatusGroupNumberDAOImplTest {
    private StatusGroupNumber status;
    public StatusGroupNumberDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        status= new StatusGroupNumber ();
        status.setStatusName("en curso");
        status.setStatus(Boolean.TRUE);
    }
 
    @After
    public void tearDown() {
    }

    /**
     * Test of findByStatusName method, of class StatusGroupNumberDAOImpl.
     */
    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de status");
        StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        if (dao.find(status.getStatusName()) == null) {
            dao.insert(status);
        }
        assertEquals(dao.find(status.getStatusName()), status);
    }
    
   @Test
    public void test2find(){
    
        System.out.println("Prueba consulta status");
        StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        StatusGroupNumber statusconsulta =(StatusGroupNumber) dao.find(status.getStatusName());
        assertEquals(statusconsulta, status);
    }
    
    @Test
    public void test3update (){
       
        System.out.println("Prueba del Update");
        StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        status.setStatus(true);
        dao.update(status);
        assertEquals(dao.find(status.getStatusName()), status);   
    }
     @Test
    public void test3vFindAll() {
        System.out.println("prueba de findall");
   StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        List<StatusGroupNumber> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
         System.out.println(lista);
    }
    
    @Test 
    public void test4vUpdatePrimaryKey (){
     StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
       int resultado = dao.updatePrimaryKey("estadoo", status.getStatusName());
       assertEquals(resultado, 1);     
    }
    
   @Test
   public void test5FindByStatusName(){
       System.out.println("Prueba del Status Name");
        StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        List <StatusGroupNumber> lista = dao.findByStatusName("aplazada");
        assertTrue(!lista.isEmpty());
        for (StatusGroupNumber statusGroupNumber: lista ){
            assertEquals(statusGroupNumber.getStatusName(),"aplazada");
        }
        
   }
   @Test
   public void test6FindByStatus(){
       System.out.println("prueba del status jaja");
       StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
     List <StatusGroupNumber> lista = dao.findByStatus(true);
     assertTrue(!lista.isEmpty());
     for (StatusGroupNumber statusGroupNumber: lista){
         assertEquals(statusGroupNumber.getStatus(),true);
     }
   }
   @Test
    public void test7FindByLikeStatusName() {
        System.out.println("prueba del metodo status  ");
         StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
        List<StatusGroupNumberDAO> lista = dao.findByLikeStatusName("%apla%");
        assertTrue(!lista.isEmpty());
    }
    @Test 
    public void test8Delete (){
        System.out.println("Prueba del Delete");
       StatusGroupNumberDAO dao = StatusGroupNumberFactory.create(StatusGroupNumber.class);
       status.setStatusName("estadoo");
        dao.remove(status);
        assertEquals(dao.find(status.getStatusName()), null);  
    }

}
