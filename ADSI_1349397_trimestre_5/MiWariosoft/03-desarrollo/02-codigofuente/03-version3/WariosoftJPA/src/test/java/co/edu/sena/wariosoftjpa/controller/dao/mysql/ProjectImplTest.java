package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.ProjectFactory;
import co.edu.sena.wariosoftjpa.controller.dao.ProjectDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Project;
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
public class ProjectImplTest {

    private Project p;

    public ProjectImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Project();
        p.setProjectCode("191817 v1");
        p.setNameProject("SISTEMA INTEGRAL ALIMENTICIO");
        p.setState(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba de project en metodo insert");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        if (dao.find(p.getProjectCode()) == null) {
            dao.insert(p);
        }
        assertEquals(dao.find(p.getProjectCode()), p);
    }

    @Test
    public void test2find() {
        System.out.println("Prueba de Project en metodo find por llavePrimaria");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        Project projectConsulta = (Project) dao.find(p.getProjectCode());
        assertEquals(projectConsulta, p);
    }

    @Test
    public void test3update() {
        System.out.println("Prueba de Project en metodo update por llavePrimaria");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        p.setNameProject("SISTEMA INTEGRAL CANINO");
        p.setState(Boolean.TRUE);
        dao.update(p);
        assertEquals(dao.find(p.getProjectCode()), p);
    }

    @Test
    public void test3UpdatePrimaryKey() {
        System.out.println("updatePrimaryKey");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        int resultado = dao.updatePrimaryKey("191816 v2", p.getProjectCode());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4delete() {
        System.out.println("Prueba de Project en metodo delete pro llavePrimaria");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        p.setProjectCode("191816 v2");
        dao.remove(p);
        assertEquals(dao.find(p.getProjectCode()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Prueba de Project en metodo findAll");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByCode() {
        System.out.println(" Prueba de Project en metodo findByCode");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByCode("191817 v1");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getProjectCode(), "191817 v1");
        }
    }

    @Test
    public void test7FindByName() {
        System.out.println("Prueba de Project en metodo findByName");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByName("SISTEMA INTEGRAL CANINO");
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getNameProject(), "SISTEMA INTEGRAL CANINO");
        }
    }

    @Test
    public void test8FindByState() {
        System.out.println("Prueba de Project en metodo findByState");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getState(), true);
        }
    }

    @Test
    public void test9FindByLikeCode() {
        System.out.println("Prueba de Project en metodo findByLikeCode");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeCode("%v1%");
        assertTrue(!lista.isEmpty());
    }

}


