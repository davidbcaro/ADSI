/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.ProjectDAO;
import co.edu.sena.daowariosoft.controller.factory.ProjectDAOFactory;
import co.edu.sena.daowariosoft.controller.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.daowariosoft.model.dto.ProjectDTO;
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
 * @author SENA
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlProjectDAOTest {
    
    private ProjectDTO document;
    private ProjectDTO document2;
    
    public MysqlProjectDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        document = new ProjectDTO();
        document.setCode("1234");
        document.setName("name1");
        document.setState(true);

        document2 = new ProjectDTO();
        document2.setCode("235");
        document2.setName("123");
        document2.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlProjectDAO.
     */
    @Test
    public void test1Insert() {
        System.out.println("insert");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.insert(document), 1);

    }
        @Test
    public void test2FindPk() {
      System.out.println("finpk");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        dao.findPk("1234");

    }

    
    
      
    
     @Test
    public void test3FindAll() {
        System.out.println("findAll");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        List<ProjectDTO> consulta = (List<ProjectDTO>)dao.findAll();
        assertTrue(!consulta.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlProjectDAO.
     */
  
    @Test
    public void test4Update() {
        System.out.println("update");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.update(document2,"1234"), 1);
    
    }

    /**
     * Test of delete method, of class MysqlProjectDAO.
     */
    @Test
    public void test5Delete() {
        System.out.println("delete");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.delete("235"), 1);
    }

    /**
     * Test of findAll method, of class MysqlProjectDAO.
     */
   
    
}
