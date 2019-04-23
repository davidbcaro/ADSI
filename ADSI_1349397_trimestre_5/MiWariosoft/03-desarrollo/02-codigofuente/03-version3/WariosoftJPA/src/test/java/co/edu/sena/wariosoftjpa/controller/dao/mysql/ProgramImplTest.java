/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.ProgramFactory;
import co.edu.sena.wariosoftjpa.controller.dao.ProgramDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ProgramPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
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
public class ProgramImplTest {

    private Program pm;
    private ProgramPK pmK;

    public ProgramImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pm = new Program();
        pm.setProgramPK(new ProgramPK("2654223", "version 102"));
        pm.setTrainingLevel(new TrainingLevel("Tecnologo"));
        pm.setName("Sistema Alimenticio Felino");
        pm.setInitials("S.A.F");
        pm.setState(Boolean.TRUE);

        pmK = new ProgramPK("2654223", "version 102");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        ProgramDAO dao = ProgramFactory.create(Program.class);
        dao.insert(pm);
        Program programBaseDatos = (Program) dao.find(pm.getProgramPK());
        assertEquals(programBaseDatos, pm);
    }

    @Test
    public void test2findpk() {
        ProgramDAO dao = ProgramFactory.create(Program.class);
        Program pr = (Program) dao.find(pm.getProgramPK());
        assertEquals(pr, pm);
    }

    @Test
    public void test3update() {

        ProgramDAO dao = ProgramFactory.create(Program.class);
        pm.setName("Sistema Alimenticio Mamifero");
        dao.update(pm);
        assertEquals(dao.find(pm.getProgramPK()), pm);
    }

    @Test
    public void test3UpdatePk() {
        System.out.println("updatePk");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        dao.updatePk(pmK, pm.getProgramPK());
        pm.setProgramPK(pmK);
        assertEquals(dao.find(pmK), pm);

    }

    @Test
    public void test4Remove() {
        ProgramDAO dao = ProgramFactory.create(Program.class);
        pm.setProgramPK(pmK);
        dao.remove(pm);
        assertEquals(dao.find(pm.getProgramPK()), null);
    }

    @Test
    public void test5FindByCode() {
        System.out.println("findByCode");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByCode("228120");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getProgramPK().getProgramCode(), "228120");
        }
    }

    @Test
    public void test6FindBylikeCode() {
        System.out.println("findBylikeCode");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeCode("%22%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test7FindByName() {
        System.out.println("findByName");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByName("Analisis y Desarrollo de Sistemas de Informacion");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getName(), "Analisis y Desarrollo de Sistemas de Informacion");
        }
    }

    @Test
    public void test8FindByVersion() {
        System.out.println("findByVersion");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByVersion("version 102");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getProgramPK().getVersion(), "version 102");
        }
    }

    @Test
    public void test9FindByLikeVersion() {
        System.out.println("findByLikeVersion");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByLikeVersion("%ver%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test10FindByInitials() {
        System.out.println("findByInitials");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByInitials("A.D.S.I");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getInitials(), "A.D.S.I");
        }
    }

    @Test
    public void test11FindByState() {
        System.out.println("findByState");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByState(Boolean.TRUE);
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getState(), Boolean.TRUE);
        }
    }

    @Test
    public void test12FindByTrainingLevel() {
        System.out.println("findByTrainingLevel");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByTrainingLevel("Tecnologo");
        assertTrue(!lista.isEmpty());
        for (Program program : lista) {
            assertEquals(program.getTrainingLevel().getTrainingLevel(), "Tecnologo");
        }
    }

    @Test
    public void test13FindByLikeTrainingLevel() {
        System.out.println("findByLikeTrainingLevel");
        ProgramDAO dao = ProgramFactory.create(Program.class);
        List<Program> lista = dao.findByTrainingLevel("%ogo%");
         for (Program program : lista) {
            assertEquals(program.getTrainingLevel(), "%ogo%");
        }
    }

}
