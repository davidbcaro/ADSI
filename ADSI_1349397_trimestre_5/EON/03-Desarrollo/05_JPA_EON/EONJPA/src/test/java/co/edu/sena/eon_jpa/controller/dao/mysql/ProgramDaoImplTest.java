/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ProgramDao;
import co.edu.sena.eon_jpa.controller.factory.ProgramFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Program;
import co.edu.sena.eon_jpa.model.jpa.entities.ProgramPK;
import co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel;
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
 * @author LUISBERNARDO
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProgramDaoImplTest {
    
    private Program program;
    private Program program2;
    private ProgramPK programPk;
    
    public ProgramDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        program = new Program();
        program.setProgramPK(new ProgramPK("1349397", "V105"));
        program.setName("Analisis");
        program.setInitials("ADSI");
        program.setState(true);
        program.setTrainingLevel(new TrainingLevel("Tecnologo"));
        
        programPk = new ProgramPK("252186", "V103"); 
        
        program2 = new Program();
        program2.setProgramPK(new ProgramPK("5768877", "V107"));
        program2.setName("Prueba");
        program2.setInitials("CEET");
        program2.setState(true);
        program2.setTrainingLevel(new TrainingLevel("Tecnologo"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert(){
        System.out.println("Test Insert");
        ProgramDao dao = ProgramFactory.create(Program.class);
        if(dao.find(program.getProgramPK()) == null){
            dao.insert(program);
        }
        assertEquals(dao.find(program.getProgramPK()), program);
        
        
        if(dao.find(program2.getProgramPK()) == null){
            dao.insert(program2);
        }
        assertEquals(dao.find(program2.getProgramPK()), program2);
    }
    
    @Test
    public void test2find(){
        System.out.println("Test Find");
        ProgramDao dao = ProgramFactory.create(Program.class);
        Program ProgramConsulted = (Program) dao.find(program.getProgramPK());
        assertEquals(ProgramConsulted, program);
    }
    
    @Test
    public void test3Update(){
        System.out.println("Test Update");
        ProgramDao dao = ProgramFactory.create(Program.class);
        program.setName("Prueba");
        program.setInitials("AV");
        program.setState(false);
        dao.update(program);
        assertEquals(dao.find(program.getProgramPK()), program);
    }
    
    @Test
    public void test3vUpdatePrimaryKey() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        dao.updatePrimaryKey(programPk, program.getProgramPK());
        program.setProgramPK(programPk);
        assertEquals(dao.find(programPk), program);        
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        ProgramDao dao = ProgramFactory.create(Program.class);
        program.setProgramPK(programPk);
        dao.remove(program);
        assertEquals(dao.find(program.getProgramPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByCode("228106");
        assertTrue(!lista.isEmpty());
        for (Program pr1 : lista){
            assertEquals(pr1.getProgramPK().getProgramCode(), "228106");
        }
    }
     
    @Test
    public void test6FindByVersion() {
        System.out.println("Test findByVersion");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByVersion("V102");
        assertTrue(!lista.isEmpty());
        for (Program pr1 : lista){
            assertEquals(pr1.getProgramPK().getVersion(), "V102");
        }
    }

    @Test
    public void test6FindByName() {
        System.out.println("Test findByName");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByName("ANÁLISIS Y DESARROLLO DE SISTEMAS DE INFORMACIÓN");
        assertTrue(!lista.isEmpty());
        for (Program pr1 : lista){
            assertEquals(pr1.getName(), "ANÁLISIS Y DESARROLLO DE SISTEMAS DE INFORMACIÓN");
        }
    }

    @Test
    public void test6FindByInitials() {
        System.out.println("Test findByInitials");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByInitials("ADSI");
        assertTrue(!lista.isEmpty());
        for (Program pr1: lista){
            assertEquals(pr1.getInitials(), "ADSI");
        }
    }

    @Test
    public void test6FindByState() {
        System.out.println("Test findByState");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for(Program pr1: lista){
            assertEquals(pr1.getState(), true);
        }
    }

    @Test
    public void test6FindByTrainingLevel() {
        System.out.println("Test FindByTrainingLevel");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByTrainingLevel("Tecnologo");
        assertTrue(!lista.isEmpty());
        for(Program pr1: lista){
            assertEquals(pr1.getTrainingLevel().getTrainingLevel(), "Tecnologo");
        }
    }

    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test FindByLikeCode");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program>  lista = dao.findByLikeCode("%2%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeVersion() {
        System.out.println("Test FindByLikeVersion");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeVersion("%V1%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeName() {
        System.out.println("Test FindByLikeName");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeName("%A%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeInitials() {
        System.out.println("Test findByLikeInitials");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeInitials("%A%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeTrainingLevel() {
        System.out.println("Test findByLikeTrainingLevel");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeTrainingLevel("%T%");
        assertTrue(!lista.isEmpty());
    }  
}
