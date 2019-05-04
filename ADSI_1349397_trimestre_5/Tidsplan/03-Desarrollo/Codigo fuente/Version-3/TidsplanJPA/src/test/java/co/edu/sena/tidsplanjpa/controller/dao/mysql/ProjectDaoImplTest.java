/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ProjectDao;
import co.edu.sena.tidsplanjpa.controller.factory.ProjectFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Project;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 *
 * @author 1349397
 */
public class ProjectDaoImplTest {

    Project pr;
    Project pr2;

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
        pr = new Project();
        pr.setCode("1111");
        pr.setName("Proyecto1");
        pr.setStatus(true);

      
    }

    @After
    public void tearDown() {
    }

   

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Proyecto metodo insert");
        ProjectDao dao = ProjectFactory.create(Project.class);
        if (dao.find(pr.getCode()) == null) {
            dao.insert(pr);

        }
        assertEquals(dao.find(pr.getCode()), pr);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba de Proyecto metodo find por llave primaria");
        ProjectDao dao = ProjectFactory.create(Project.class);
        Project proyectConsulted = (Project) dao.find(pr.getCode());
        assertEquals(proyectConsulted, pr);
    }

    @Test
    public void test03Update() {
        System.out.println("prueba de Proyecto metodo update");
        ProjectDao dao = ProjectFactory.create(Project.class);
        pr.setName("Proyecto2");
        pr.setStatus(Boolean.FALSE);
        dao.update(pr);
        assertEquals(dao.find(pr.getCode()), pr);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de Proyecto metodo update por llave primaria");
        ProjectDao dao = ProjectFactory.create(Project.class);
        int resultado = dao.updatePrimaryKey("2222", pr.getCode());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05delete() {
        System.out.println("prueba de tipo de Proyecto delete para la llave primaria");
        ProjectDao dao = ProjectFactory.create(Project.class);
        pr.setCode("2222");
        dao.remove(pr);
        assertEquals(dao.find(pr.getCode()), null);

    }

    @Test
    public void test06FindAll() {
        System.out.println("Prueba de Proyecto metodo find all");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    public void test07FindByLikeCode() {
        System.out.println("Prueba de Proyecto metodo findByLikeCode");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeCode("%9%");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            System.out.println(project);
            
        }
       
    }

    @Test
    public void test08FindByCode() {
        System.out.println("Prueba de Proyecto metodo FindByCode");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByCode("569629");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getCode(), "569629");
        }
    }

    @Test
    public void test09FindByLikeName() {
        System.out.println("Prueba de Proyecto metodo FindByLikeName");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeName("%r%");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            System.out.println(project);
        }
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test10FindByName() {
        System.out.println("Prueba de Proyecto metodo FindByName");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByName("Implementación de módulos en el Sistema integral web de gestión de procesos educativos para el CEET");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getName(), "Implementación de módulos en el Sistema integral web de gestión de procesos educativos para el CEET");
        }
    }
    
     @Test
    public void test11FindByStatus() {
        System.out.println("Prueba de Proyecto metodo FindByStatus");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByStatus(Boolean.TRUE);
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getStatus(), Boolean.TRUE);
        }
    }

}
