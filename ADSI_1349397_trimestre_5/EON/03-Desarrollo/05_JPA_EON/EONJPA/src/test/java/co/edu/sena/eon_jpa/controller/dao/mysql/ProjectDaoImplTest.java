/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ProjectDao;
import co.edu.sena.eon_jpa.controller.factory.ProjectFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Project;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author LUISBERNARDO
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectDaoImplTest {

    private Project project;
    private Project project2;

    public ProjectDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        project = new Project();
        project.setCode("1349397");
        project.setName("Analisis y Desarrollo de Sistemas de Informacion");
        project.setState(Boolean.TRUE);
        
        project2 = new Project();
        project2.setCode("5768877");
        project2.setName("Analisis");
        project2.setState(Boolean.TRUE);
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Test Insert");
        ProjectDao dao = ProjectFactory.create(Project.class);
        if (dao.find(project.getCode()) == null) {
            dao.insert(project);
        }
        assertEquals(dao.find(project.getCode()), project);
       
        if (dao.find(project2.getCode()) == null) {
            dao.insert(project2);
        }
        assertEquals(dao.find(project2.getCode()), project2);
    }

    @Test
    public void test2find() {
        System.out.println("Test Find");
        ProjectDao dao = ProjectFactory.create(Project.class);
        Project ProjectConsulted = (Project) dao.find(project.getCode());
        assertEquals(ProjectConsulted, project);
    }

    @Test
    public void test3update() {
        System.out.println("Test Update");
        ProjectDao dao = ProjectFactory.create(Project.class);
        project.setName("Prueba");
        project.setState(Boolean.FALSE);
        dao.update(project);
        assertEquals(dao.find(project.getCode()), project);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        ProjectDao dao = ProjectFactory.create(Project.class);
        int resultado = dao.updatePrimaryKey("1385615", project.getCode());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        ProjectDao dao = ProjectFactory.create(Project.class);
        project.setCode("1385615");
        dao.remove(project);
        assertEquals(dao.find(project.getCode()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByCode("576887");
        assertTrue(!lista.isEmpty());
        for (Project p1 : lista) {
            assertEquals(p1.getCode(), "576887");
        }
    }

    @Test
    public void test6FindByName() {
        System.out.println("Test findByName");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByName("SISTEMA INTEGRAL WEB PARA GESTION DE PROCESOS EDUCATIVOS DEL CEET");
        assertTrue(!lista.isEmpty());
        for (Project p1 : lista) {
            assertEquals(p1.getName(), "SISTEMA INTEGRAL WEB PARA GESTION DE PROCESOS EDUCATIVOS DEL CEET");
        }
    }

    @Test
    public void test6FindByState() {
        System.out.println("Test findByState");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Project p1 : lista) {
            assertEquals(p1.getState(), Boolean.TRUE);
        }
    }
    
    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test findByLikeCode");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeCode("%5%");
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindByLikeName(){
        System.out.println("Test findByLikeName");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeName("%S%");
        assertTrue(!lista.isEmpty());
    }
}
