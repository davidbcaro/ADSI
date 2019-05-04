/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ProjectPhaseDao;
import co.edu.sena.tidsplanjpa.controller.factory.ProjectPhaseFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhase;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhasePK;
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
 * @author Miguel
 */
public class ProjectPhaseDaoImplTest {

    private ProjectPhase pph;
    private ProjectPhasePK pphpk;
    private ProjectPhasePK pphpk2;

    public ProjectPhaseDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pph = new ProjectPhase();
        pph.setProjectPhasePK(new ProjectPhasePK("Fase1", "569629"));
        pph.setStatus(false);
        
        pphpk = new ProjectPhasePK();
        pphpk.setNamePhase("Fase1000");
        pphpk.setProjectCode("569629");
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de fase del projecto metodo insert");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        if (dao.find(pph.getProjectPhasePK()) == null) {
            dao.insert(pph);
        }
        assertEquals(dao.find(pph.getProjectPhasePK()), pph);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de fase del projecto metodo find");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        ProjectPhase proyectphaseConsulted = (ProjectPhase) dao.find(pph.getProjectPhasePK());
        assertEquals(proyectphaseConsulted, pph);

    }
    
    @Test
    public void test03Update(){
         System.out.println("Prueba de fase del projecto metodo Update");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        pph.setStatus(true);
        dao.update(pph);
        assertEquals(dao.find(pph.getProjectPhasePK()), pph);
    } 
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de Fase de Proyecto metodo update por llave primaria");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        int resultado = dao.updatePrimaryKey(pphpk ,pph.getProjectPhasePK());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba de Fase de Proyecto metodo delete");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        pph.setProjectPhasePK(pphpk);
        dao.remove(pph);
        assertEquals(dao.find(pph.getProjectPhasePK()), null);
    }
    
    @Test
    public void test06FindAll() {
        System.out.println("prueba de Fase de Proyecto metodo delete");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> list = dao.findAll();
        assertFalse(list.isEmpty());   
    }

    @Test
    public void test07FindByNamePhase() {
        System.out.println("prueba de Fase de Proyecto metodo FindByNamePhase");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> list = dao.findByNamePhase("ANALISIS");
        assertFalse(list.isEmpty());
        for (ProjectPhase projectPhase : list) {
            assertEquals(projectPhase.getProjectPhasePK().getNamePhase(), "ANALISIS");
        }
    }

    
    @Test
    public void test08FindByLikeNamePhase() {
        System.out.println("prueba de Fase de Proyecto metodo FindByNamePhase");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> list = dao.findByLikeNamePhase("%o%");
        assertFalse(list.isEmpty());
        for (ProjectPhase projectPhase : list) {
            System.out.println(projectPhase);
        }
    }

    @Test
    public void test09FindByProjectCode() {
        System.out.println("prueba de Fase de Proyecto metodo FindByNamePhase");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> list = dao.findByProjectCode("569629");
        assertFalse(list.isEmpty());
        for (ProjectPhase projectPhase : list) {
            assertEquals(projectPhase.getProjectPhasePK().getProjectCode(), "569629");
        }
    }

 
    @Test
    public void test10FindByLikeProjectCode() {
        System.out.println("prueba de Fase de Proyecto metodo FindByNamePhase");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> list = dao.findByLikeProjectCode("%5%9%");
        assertFalse(list.isEmpty());
        for (ProjectPhase projectPhase : list) {
            System.out.println(projectPhase);
        }
    }

    /**
     * Test of findByStatus method, of class ProjectPhaseDaoImpl.
     */
    @Test
    public void test11FindByStatus() {
        System.out.println("Prueba de Proyecto metodo FindByStatus");
        ProjectPhaseDao dao = ProjectPhaseFactory.create(ProjectPhase.class);
        List<ProjectPhase> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (ProjectPhase project : lista) {
            assertEquals(project.getStatus(), true);
        }
       
    }

}
