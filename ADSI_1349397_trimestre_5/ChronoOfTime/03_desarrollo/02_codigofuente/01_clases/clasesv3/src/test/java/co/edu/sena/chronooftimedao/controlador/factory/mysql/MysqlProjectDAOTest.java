/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ProjectDAO;
import co.edu.sena.chronooftimedao.controlador.factory.ProjectDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
import static com.sun.javafx.scene.CameraHelper.project;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1349397
 */
public class MysqlProjectDAOTest {

    private ProjectDTO project;
    private ProjectDTO project2;
    

    @Before
    public void setUp() {
        System.out.println("Before");
        project = new ProjectDTO();
        project.setCode(12345);
        project.setName("hola");
        project.setState(true);
        
        project2= new ProjectDTO();
        project2.setCode( 12345);
        project2.setName("adioskfldkf");
        project2.setState(false);

    }

    @After
    public void tearDown() {
        System.out.println("after");
    }

    /**
     * Test of insert method, of class MysqlProjectDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("prueba del insert de ProjectDAO");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.insert(project), 1);

    }
    
     @Test
    public void test2FindPk() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        ProjectDTO respuesta =dao.findPk(project);
        assertEquals(respuesta,project);
    }

    /**
     * Test of update method, of class MysqlProjectDAO.
     */
    @Test
    public void testUpdate() {

       System.out.println("prueba del update de ProjectDAo");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.update(project2, 12345), 1);

    }

    /**
     * Test of delete method, of class MysqlProjectDAO.
     */
    @Test
    public void testDelete() {    
        
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.delete(12345),1);

    }

    /**
     * Test of findAll method, of class MysqlProjectDAO.
     */
    @Test
    public void testFindAll() {
        
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        List<ProjectDTO> lista = (List<ProjectDTO>)dao.findAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());

    }

}
