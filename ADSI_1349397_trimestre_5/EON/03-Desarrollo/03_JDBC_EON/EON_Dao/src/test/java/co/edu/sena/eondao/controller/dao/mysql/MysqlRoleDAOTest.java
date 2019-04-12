/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.RoleDAO;
import co.edu.sena.eondao.controller.factory.RoleDAOFactory;
import co.edu.sena.eondao.controller.factory.mysql.MysqlRoleDAOFactory;
import co.edu.sena.eondao.modelo.dto.RoleDTO;
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
public class MysqlRoleDAOTest {
    
    private RoleDTO role;
    private RoleDTO role2;
    private RoleDTO role3;
 
    
    public MysqlRoleDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        role = new RoleDTO();
        role.setId_Role("ADMin123");
        role.setDescription("awd");
        role.setStatus(Boolean.TRUE);
        
        
        role2 = new RoleDTO();
        role2.setId_Role("ADMin345");
        role2.setDescription("awd");
        role2.setStatus(Boolean.TRUE);   
        
        role3 = new RoleDTO();
        role3.setId_Role("Cambiodeee");
        role3.setDescription("awd");
        role3.setStatus(Boolean.TRUE); 
      
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Insert");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.insert(role),1);       
    }
    
    @Test
    public void test2FindPk() {
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        RoleDTO resultado = dao.findPk("ADMin123");
        assertEquals(resultado, role);
    }

    @Test
    public void test3Update() {
        System.out.println("Update");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.update(role3, "ADMin123"), 1);   
    }

    @Test
    public void test4Delete() {
        System.out.println("Delete");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.delete("Cambiodeee"), 1);
    }
   
    @Test
    public void test5FindAll(){
        System.out.println("FindAll");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        List<RoleDTO> resultado = (List<RoleDTO>) dao.findAll();
        assertTrue(!resultado.isEmpty());
        
    }
    
}
