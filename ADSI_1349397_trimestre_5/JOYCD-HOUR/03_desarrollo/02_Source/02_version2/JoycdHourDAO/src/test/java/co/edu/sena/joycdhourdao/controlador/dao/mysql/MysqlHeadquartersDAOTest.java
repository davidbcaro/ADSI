/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.HeadquartersDAO;
import co.edu.sena.joycdhourdao.controlador.factory.HeadquartersDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlHeadquartersDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.HeadquartersDTO;
import java.util.Collection;
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
 * @author liosalfar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlHeadquartersDAOTest {
    
    
    private HeadquartersDTO headDT;
    private HeadquartersDTO headDT2;
    
    public MysqlHeadquartersDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       headDT = new HeadquartersDTO();
       headDT.setNameHeadquarters("barrio colombia");
       headDT.setDirection("calle 1234");
       headDT.setStatus(true);
       
       headDT2 = new HeadquartersDTO();
       headDT2.setNameHeadquarters("complejo sur");
       headDT2.setDirection("primera de mayo");
       headDT2.setStatus(true);
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlHeadquartersDAO.
     */
    @Test
    public void test1Insert() {

        System.out.println("Prueba de HeadquartersDAO");
        HeadquartersDAOFactory factory = new MysqlHeadquartersDAOFactory();
        HeadquartersDAO dao = factory.create();
        assertEquals(dao.insert(headDT), 1);
        
    }

    /**
     * Test of update method, of class MysqlHeadquartersDAO.
     */
    @Test
    public void test2Update() {

        System.out.println("Prueba HeadquartersDAO");
        HeadquartersDAOFactory factory = new MysqlHeadquartersDAOFactory();
        HeadquartersDAO dao = factory.create();
        assertEquals(dao.update(headDT2,"barrio colombia"),1);
    }

    /**
     * Test of delete method, of class MysqlHeadquartersDAO.
     */
    @Test
    public void test5Delete() {
System.out.println("Prueba HeadquartersDAO");
        HeadquartersDAOFactory factory = new MysqlHeadquartersDAOFactory();
        HeadquartersDAO dao = factory.create();
        assertEquals(dao.delete("complejo sur"),1);
    }

    /**
     * Test of findAll method, of class MysqlHeadquartersDAO.
     */
    @Test
    public void test3FindAll() {
        HeadquartersDAOFactory factory = new MysqlHeadquartersDAOFactory();
        HeadquartersDAO dao = factory.create();
        List<HeadquartersDTO> lista=(List<HeadquartersDTO>)dao.findAll();  
        System.out.println(lista);
       assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlHeadquartersDAO.
     */
    @Test
    public void test4FindPk() {
 
        HeadquartersDAOFactory factory = new MysqlHeadquartersDAOFactory();
         HeadquartersDAO dao = factory.create();
         HeadquartersDTO respuesta = dao.findPk("complejo sur");
         assertEquals(respuesta,headDT2);
    }
    
}
