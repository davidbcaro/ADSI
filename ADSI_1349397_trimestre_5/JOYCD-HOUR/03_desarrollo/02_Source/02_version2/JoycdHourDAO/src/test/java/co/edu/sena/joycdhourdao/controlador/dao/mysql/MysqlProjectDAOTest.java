/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;


import co.edu.sena.joycdhourdao.controlador.dao.ProjectDAO;
import co.edu.sena.joycdhourdao.controlador.factory.ProjectDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.ProjectDTO;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlProjectDAOTest {

    private ProjectDTO project;
    private ProjectDTO project2;
    private ProjectDTO key;

    @Before
    public void setUp() throws Exception {
        project = new ProjectDTO();
        project.setCodeproject("123");
        project.setNameproject("JOYCD");
        project.setStatusproject(Boolean.TRUE);
        
        
        project2 = new ProjectDTO();
        project2.setCodeproject("321");
        project2.setNameproject("hola");
        project2.setStatusproject(Boolean.TRUE);
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("prueba de insert de projectDAO");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.insert(project), 1);
        
    }
    
    @Test
    public void test2FindPk() {
        System.out.println("prueba del búsqueda llave primaria de ProjectDAo");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        ProjectDTO consulta = dao.findPk("123");
        assertEquals(consulta, project);

    }

    @Test
    public void test3Update() {
        System.out.println("prueba de update de ProjectDAO");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.update(project2, "123"), 1);
    }
    
    @Test
    public void test4FindAll() {
        System.out.println("prueba de select * de ProjectDAO");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        List<ProjectDTO> consulta = (List<ProjectDTO>) dao.findAll();
        System.out.println(consulta);
        assertTrue(!consulta.isEmpty());
    }
   
    @Test
    public void test5Delete() {
        System.out.println("prueba de update de projectDao");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.delete("321"), 1);
    }
}
