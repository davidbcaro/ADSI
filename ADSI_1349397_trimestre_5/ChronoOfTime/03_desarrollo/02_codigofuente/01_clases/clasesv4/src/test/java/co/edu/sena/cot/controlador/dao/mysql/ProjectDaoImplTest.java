/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ProjectDao;
import co.edu.sena.cot.controlador.factory.mysql.ProjectFactory;
import static co.edu.sena.cot.modelo.dto.Phase_.project;
import co.edu.sena.cot.modelo.dto.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class ProjectDaoImplTest {
    
    private Project project;
    
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
        project.setCode(12345);
        project.setName("Hola");
        project.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByName method, of class ProjectDaoImpl.
     */
   
    
    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        ProjectDao dao = ProjectFactory.create(Project.class);
        if (dao.find(project.getCode()) == null) {
            dao.insert(project);
        } 
        assertEquals(dao.find(project.getCode()), project);
    }  
    
    
    @Test
    public void test2find() {
        System.out.println("prueba de tipo de documento metodo find por llave primaria");
        ProjectDao dao = ProjectFactory.create(Project.class);
        Project tipoDocumentoConsultado = (Project) dao.find(project.getCode());
        assertEquals(tipoDocumentoConsultado, project);
    }
    
     @Test
    public void test3update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        ProjectDao dao = ProjectFactory.create(Project.class);
        project.setName("Adios");
        project.setState(false);
        dao.update(project);
        assertEquals(dao.find(project.getCode()), project);
    }
    
    @Test
    public void test4UpdatePrimaryKey(){
        ProjectDao dao = ProjectFactory.create(Project.class);
        project.setCode(12345);
        int resultado = dao.updatePrimaryKey(789, project.getCode());
        assertEquals(resultado, 1);
    
    }
    
     @Test
    public void test5delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        ProjectDao dao = ProjectFactory.create(Project.class);
        project.setCode(789);
        dao.remove(project);
        assertEquals(dao.find(project.getCode()), null);

    }
    
     @Test
    public void test6FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
      
    
     @Test
    public void test6FindName() {
         System.out.println("la");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByName("Adios");
        for (Project project2 : lista) {
            assertEquals(project2.getName(), "Adios");
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }
    
    @Test
    public void test6FindState() {
        System.out.println("las");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByState(true);
        for (Project project : lista) {
            assertEquals(project.getState(), true);
        }
        System.out.println("estados "+lista);
    }
    
    
         
    
    @Test
    public void test6FindLikeName() {
        System.out.println("lassssss");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeName("%Ad%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
    
    @Test
    public void testFindLikeCode() {
        
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeCode("%3%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }
    
    
    @Test
    public void test6findDataBase(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.edu.sena_ChronoOfTimeDAO_jar_2.0.0PU");
        EntityManager em = emf.createEntityManager();
        System.out.println("");
    }
}
