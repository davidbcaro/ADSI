/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.ProgramDao;
import co.edu.sena.cot.controlador.factory.mysql.ProgramFactory;
import co.edu.sena.cot.modelo.dto.LevelTrainig;
import co.edu.sena.cot.modelo.dto.Program;
import co.edu.sena.cot.modelo.dto.ProgramPK;
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
public class ProgramDaoImplTest {
    
    private Program program;
    private ProgramPK programPK;
    
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
        program.setProgramPK(new ProgramPK(78945, "v 102"));
        program.setNameProgram("Nombre");
        program.setInitials("NASI");
        program.setState("1");
        program.setLevelTraCode(new LevelTrainig("Tecnico"));
        
        
        programPK = new ProgramPK(9635, "v 103");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByCodeProgram method, of class ProgramDaoImpl.
     */
    
    @Test
    public void test01Insert() {

        ProgramDao dao = ProgramFactory.create(Program.class);
        if (dao.find(program.getProgramPK()) == null) {
            dao.insert(program);
        }
        assertEquals(dao.find(program.getProgramPK()), program);
    }
    
    @Test
    public void test02find() {

        ProgramDao dao = ProgramFactory.create(Program.class);
        Program pro = (Program) dao.find(program.getProgramPK());
        assertEquals(pro, program);
    }
    
     @Test
    public void test03update() {

        ProgramDao dao = ProgramFactory.create(Program.class);
        program.setNameProgram("Nombre 34");
        program.setState("0");
        dao.update(program);
        assertEquals(dao.find(program.getProgramPK()), program);

    }
    
    @Test
    public void test10delete() {
        
        ProgramDao dao = ProgramFactory.create(Program.class);
        program.setProgramPK(new ProgramPK(9635, "v 103"));
        dao.remove(program);
        assertEquals(dao.find(program.getProgramPK()), null);

    }
    
     @Test
    public void test05FindAll() {
        
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println("nananana "+lista);
    }
    
    @Test
    public void testFindByCodeProgram() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByCodeProgram(228106);
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getProgramPK(), new ProgramPK(228106, "v 102"));
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByNameProgram method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByNameProgram() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByNameProgram("PROGRAMACION DE SOFTWARE");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getProgramPK(), new ProgramPK(228120, "v 102"));
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByEdition method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByEdition() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByEdition("v 102");
        assertTrue(!lista.isEmpty());
        int espero=0;
        for (Program program : lista) {
            
            if(program.getProgramPK().equals(new ProgramPK(228106, "v 102") ))
            espero++;
        }
         assertEquals(espero,1);
    }

    /**
     * Test of findByInitials method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByInitials() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByInitials("ADSI");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getProgramPK(), new ProgramPK(228106, "v 102"));
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByState method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByState() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByState("1");
        assertTrue(!lista.isEmpty());
        int espero = 0 ;
        for (Program program : lista) {
            if(program.getProgramPK().equals(new ProgramPK(228106, "v 102")) )
                espero++;
        }
         assertEquals(espero, 1);
    }

    /**
     * Test of findByLevelTraCode method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByLevelTraCode() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLevelTraCode("Tecnico");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getLevelTraCode().getCode(), "Tecnico");
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByLikeCodeProgram method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByLikeCodeProgram() {
        
    }

    /**
     * Test of findByLikeNameProgram method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByLikeNameProgram() {
        System.out.println("lassssss");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeNameProgram("%SI%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of finfByLikeEdition method, of class ProgramDaoImpl.
     */
    @Test
    public void testFinfByLikeEdition() {
        System.out.println("lassssss");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.finfByLikeEdition("%10%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeInitials method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByLikeInitials() {
        System.out.println("lassssss");
        ProgramDao dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeInitials("%D%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeLevelTraCode method, of class ProgramDaoImpl.
     */
    @Test
    public void testFindByLikeLevelTraCode() {
       
    }

    /**
     * Test of updatePrimaryKey method, of class ProgramDaoImpl.
     */
    @Test
    public void testUpdatePrimaryKey() {
        ProgramDao dao = ProgramFactory.create(Program.class);
        dao.updatePrimaryKey(programPK, program.getProgramPK());
        program.setProgramPK(programPK);
        assertEquals(dao.find(programPK), program);
    }
    
}
