/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;
import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.factory.ProjectFactory;
import co.edu.sena.model.jpa.entities.Project;
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
public class ProjectDaoImplTest {
     private Project pro;
    
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
        pro = new Project();
        pro.setCodeProject("123");
        pro.setNameProject("Fasesita");
        pro.setStatusProject(Boolean.TRUE);        
    }
      
    @After
    public void tearDown() {
    }
   
  @Test
    public void test1Insert() {
        System.out.println("Prueba insert de project");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        if (dao.find(pro.getCodeProject()) == null) {
            dao.insert(pro);
        }
        assertEquals(dao.find(pro.getCodeProject()), pro);
    }
    
   @Test
    public void test2find(){
    
        System.out.println("Prueba consulta project");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        Project projectconsulta =(Project) dao.find(pro.getCodeProject());
        assertEquals(projectconsulta, pro);
    }
    
    @Test
    public void test3update (){
       
        System.out.println("Prueba del Update");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        pro.setNameProject("Fasesota");
        pro.setStatusProject(true);
        dao.update(pro);
        assertEquals(dao.find(pro.getCodeProject()), pro);   
    }
       @Test
    public void test3vFindAll() {
        System.out.println("prueba de select project");
   ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    @Test 
    public void test4UpdatePrimaryKey (){
       ProjectDAO dao = ProjectFactory.create(Project.class);
       int resultado = dao.updatePrimaryKey("3211", pro.getCodeProject());
       assertEquals(resultado, 1);     
    }
    
    @Test 
    public void test5Delete (){
        System.out.println("Prueba del Delete");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        pro.setCodeProject("3211");
        dao.remove(pro);
        assertEquals(dao.find(pro.getCodeProject()), null);  
    }
    
    @Test
    public void test6FindByCodeProject() {
        System.out.println("prueba de  metodo findByCodeProject");
        ProjectDAO dao = ProjectFactory.create(Project.class);    
        List<Project> lista = dao.findByCodeProject("228106");
        assertTrue(!lista.isEmpty());
        for (Project project :lista){
            assertEquals(project.getCodeProject(),"228106");
        }      
    }
    
    @Test
    public void test7FindByNameProject() {
        System.out.println("prueba de  metodo findByNameProject");
        ProjectDAO dao = ProjectFactory.create(Project.class);    
        List<Project> lista = dao.findByNameProject("sistema integral web para gestion de procesos educativos del ceet");
        assertTrue(!lista.isEmpty());
        for (Project project :lista){
            assertEquals(project.getNameProject(),"sistema integral web para gestion de procesos educativos del ceet");
        }      
    }
    @Test
    public void test8FindByStatusProject() {
     System.out.println("prueba del metodo find");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByStatusProject(true);
        assertTrue(!lista.isEmpty());
        for (Project project : lista) {
            assertEquals(project.getStatusProject(), true);
        }
    }

       @Test
    public void test9FindByLikeNameProject() {
        System.out.println("prueba del metodo find");
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeNameProject("sis%");
        assertTrue(!lista.isEmpty());
    }
    
   @Test
    public void test10FindLikeCodeProject() {
        ProjectDAO dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeCodeProject("22%");
        assertTrue(!lista.isEmpty());
    }
   
 }
    
 

