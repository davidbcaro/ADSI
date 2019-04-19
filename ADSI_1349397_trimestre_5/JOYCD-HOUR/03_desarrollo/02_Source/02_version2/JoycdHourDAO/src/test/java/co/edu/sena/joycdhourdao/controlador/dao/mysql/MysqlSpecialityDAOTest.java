/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.SpecialityDAO;
import co.edu.sena.joycdhourdao.controlador.factory.SpecialityFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlSpecialityDAOFactry;
import co.edu.sena.joycdhourdao.modelo.dto.SpecialityDTO;
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
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlSpecialityDAOTest {
    
    private SpecialityDTO spec;
    private SpecialityDTO spec2;
    
    public MysqlSpecialityDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        spec = new SpecialityDTO();
        spec.setNameSpeciality("teleinformatica");
        spec.setStatus(true);

        spec2 = new SpecialityDTO();
        spec2.setNameSpeciality("telecomunicaciones");
        spec2.setStatus(true);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlSpecialityDAO.
     */
    @Test
    public void test1Insert() {

        System.out.println("Prueba de SpecialityDAO");
        SpecialityFactory factory = new MysqlSpecialityDAOFactry();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.insert(spec), 1);
        
    }

    /**
     * Test of update method, of class MysqlSpecialityDAO.
     */
    @Test
    public void test2Update() {
 
    System.out.println("Prueba deSpecialityDAO");
        SpecialityFactory factory = new MysqlSpecialityDAOFactry();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.update(spec2,"teleinformatica"),1);    
    }

    /**
     * Test of delete method, of class MysqlSpecialityDAO.
     */
    @Test
    public void test5Delete() {
    
         System.out.println("Prueba deSpecialityDAO");
        SpecialityFactory factory = new MysqlSpecialityDAOFactry();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.delete("telecomunicaciones"),1);
    }

    /**
     * Test of findAll method, of class MysqlSpecialityDAO.
     */
    @Test
    public void test3FindAll() {
    SpecialityFactory factory = new MysqlSpecialityDAOFactry();
        SpecialityDAO dao = factory.create();
        List<SpecialityDTO> lista=(List<SpecialityDTO>)dao.findAll();  
        System.out.println(lista);
       assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlSpecialityDAO.
     */
    @Test
    public void test4FindPk() {
    SpecialityFactory factory = new MysqlSpecialityDAOFactry();
         SpecialityDAO dao = factory.create();
         SpecialityDTO respuesta = dao.findPk("telecomunicaciones");
         assertEquals(respuesta,spec2);
    }
    
}
