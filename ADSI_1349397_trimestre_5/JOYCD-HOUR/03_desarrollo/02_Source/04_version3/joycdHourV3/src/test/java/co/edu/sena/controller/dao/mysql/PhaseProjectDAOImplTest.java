/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.PhaseProjectDAO;
import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.factory.PhaseProjectFactory;
import co.edu.sena.controller.factory.ProjectFactory;
import co.edu.sena.model.jpa.entities.CustomerPK;
import co.edu.sena.model.jpa.entities.PhaseProject;
import co.edu.sena.model.jpa.entities.PhaseProjectPK;
import co.edu.sena.model.jpa.entities.Project;
import co.edu.sena.model.jpa.entities.Role;
import co.edu.sena.model.jpa.entities.StatusGroupNumber;
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
public class PhaseProjectDAOImplTest {
    private PhaseProject fase;
    private PhaseProjectPK fasepk;
    
    public PhaseProjectDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fase = new PhaseProject();
        fase.setStatusPhase("1");
        fase.setPhaseProjectPK(new PhaseProjectPK("analisis","576887" ));
        

        fasepk = new PhaseProjectPK("ejecucionn", "576887");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de FASE");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        if (dao.find(fase.getPhaseProjectPK()) == null) {
            dao.insert(fase);
        }
        assertEquals(dao.find(fase.getPhaseProjectPK()), fase);
    }

    @Test
    public void test2Find() {
        System.out.println("Prueba de find fase");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        PhaseProject faseconsulta = (PhaseProject) dao.find(fase.getPhaseProjectPK());
        assertEquals(faseconsulta, fase);
       
    }

    @Test
    public void test3update() {
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        fase.setStatusPhase("321");
            fase.setPhaseProjectPK(new PhaseProjectPK("analisis","576887"));
        dao.update(fase);
        assertEquals(dao.find(fase.getPhaseProjectPK()), fase);
    }

    @Test
    public void test4vupdatePrimaryKey() {
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        dao.updatePrimaryKey(fasepk, fase.getPhaseProjectPK());
        fase.setPhaseProjectPK(fasepk);
        assertEquals(dao.find(fasepk), fase);

    }
    @Test
     public void test5vFindAll() {
        System.out.println("prueba del metodo findall");
     PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        


     }
    @Test
    public void test5FindByNamePhase() {
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByNamePhase("evaluacion");
        assertTrue(!lista.isEmpty());
        for (PhaseProject phaseproject : lista) {
            assertEquals(phaseproject.getPhaseProjectPK(), new PhaseProjectPK("evaluacion","576887"));
        }

    }

    @Test
    public void test6FindByStatus() {
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByStatusPhase("1");
        assertTrue(!lista.isEmpty());
        for (PhaseProject phaseproject : lista) {
            assertEquals(phaseproject.getStatusPhase(), "1");
        }
    }

    @Test
    public void test7FindByCode() {
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByProjectCode("123");
        int espero =0;
        for (PhaseProject phaseproject : lista) {
            if (phaseproject.getPhaseProjectPK().equals(new PhaseProjectPK("Fasesita","123"))){
                espero++;
            }
            assertEquals(espero,1);

        }
        
    }
    @Test
    public void test8FindByLikeNamePhase() {
        System.out.println("prueba del metodo ");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByLikeNamePhase("ejecu%");
        assertTrue(!lista.isEmpty());
    }
    @Test
    public void test9findByLikeStatus(){
        System.out.println("buscador de estado");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByLikeStatusPhase("1%");
        assertTrue(!lista.isEmpty());
    }
    @Test
    public void test10findByLikeCode (){
        System.out.println("buscador de code");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        List<PhaseProject> lista = dao.findByLikeProjectCode("576%");
         assertTrue(!lista.isEmpty());
    }
   

    @Test
    public void test11delete() {        
        System.out.println("Prueba del Delete");
        PhaseProjectDAO dao = PhaseProjectFactory.create(PhaseProject.class);
        fase.setPhaseProjectPK(new PhaseProjectPK("Fasesita","321"));
        dao.remove(fase);
        assertEquals(dao.find(fase.getPhaseProjectPK()), null);
    }
}




