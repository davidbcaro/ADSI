/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.model.dto.DocumentDTO;
import co.edu.sena.daowariosoft.controller.factory.mysql.MysqldocumentDAOFactory;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import co.edu.sena.daowariosoft.controller.dao.DocumentDAO;
import co.edu.sena.daowariosoft.controller.factory.DocumentDAOFactory;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqldocumentDAOTest {

    private DocumentDTO document;
    private DocumentDTO document2;
     private DocumentDTO document3;
     
     
    public MysqldocumentDAOTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        document = new DocumentDTO();
        document.setIdDocument("ap");
        document.setName("asdds");
        document.setState(true);

        document2 = new DocumentDTO();
        document2.setIdDocument("asd");
        document2.setName("123");
        document2.setState(true);
    
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqldocumentDAO.
     */
    @Test
    public void test1Insert() {

        System.out.println("prueba del insert de documetDAO");
        DocumentDAOFactory factory = new MysqldocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.insert(document), 1);

    }


      @Test
    public void test2FindPk() {
        System.out.println("finpk");
        DocumentDAOFactory factory = new MysqldocumentDAOFactory();
        DocumentDAO dao = factory.create();
        dao.findPk("ap");

    }
        @Test
    public void test3FindAll() {
        System.out.println("prueba de FindAll de documentDAO");
        DocumentDAOFactory factory = new MysqldocumentDAOFactory();
        DocumentDAO dao = factory.create();
        List<DocumentDTO> consulta = (List<DocumentDTO>)dao.findAll();
        assertTrue(!consulta.isEmpty());
    }
    
  
    /**
     * Test of findPk method, of class MysqldocumentDAO.
     */
    
    @Test
    public void test4Update() {
        System.out.println("prueba del update de documentDAO");
        DocumentDAOFactory factory = new MysqldocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.update(document2, "ap"), 1);
    }

    /**
     * Test of delete method, of class MysqldocumentDAO.
     */
    @Test
    public void test5Delete() {
        System.out.println("prueba del delete de documetDAO");
        DocumentDAOFactory factory = new MysqldocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.delete("asd"), 1);

    }

    /**
     * Test of findAll method, of class MysqldocumentDAO.
     */
   
  

}
