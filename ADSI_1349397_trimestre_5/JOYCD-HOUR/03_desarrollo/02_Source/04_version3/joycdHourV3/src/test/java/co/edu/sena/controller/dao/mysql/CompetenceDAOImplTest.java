/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.CompetenceDAO;
import co.edu.sena.controller.factory.CompetenceFactory;
import co.edu.sena.model.jpa.entities.Competence;
import co.edu.sena.model.jpa.entities.CompetencePK;
import static co.edu.sena.model.jpa.entities.Competence_.competencePK;
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
public class CompetenceDAOImplTest {

    private Competence competence;
    private CompetencePK competencepk;

    public CompetenceDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        competence = new Competence();
        competence.setDescription("description1");
        competence.setCompetencePK(new CompetencePK("CompetenceCodeNew", "228106", "Version 102"));

        competencepk = new CompetencePK("123456789", "228106", "Version 102");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1insert() {
        System.out.println("Prueba insert de Competence");
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        if (dao.find(competence.getCompetencePK()) == null) {
            dao.insert(competence);
        }
        assertEquals(dao.find(competence.getCompetencePK()), competence);
    }

    @Test
    public void test2find() {
        System.out.println("prueba del find");
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        Competence resultconsulta = (Competence) dao.find(competence.getCompetencePK());
        assertEquals(resultconsulta, competence);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de update");
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        competence.setDescription("description actualizado");
        dao.update(competence);
        assertEquals(dao.find(competence.getCompetencePK()), competence);
    }

    @Test
    public void test4updatePrimaryKey() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        dao.updatePrimaryKey(competencepk, competence.getCompetencePK());
        competence.setCompetencePK(competencepk);
        assertEquals(dao.find(competencepk), competence);
    }

    @Test
    public void test5FindCompetenceCode() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByCompetenceCode("123456789");
        assertTrue(!lista.isEmpty());
        for (Competence competence : lista) {
            assertEquals(competence.getCompetencePK().getCompetenceCode(), "123456789");
        }
    }

    @Test
    public void test6FindByDescription() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByDescription("description actualizado");
        assertTrue(!lista.isEmpty());
        for (Competence competence : lista) {
            assertEquals(competence.getDescription(), "description actualizado");
        }
    }

    @Test
    public void test7FindByProgramCode() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByProgramCode("228106");
        assertTrue(!lista.isEmpty());
        for (Competence competence : lista) {
            assertEquals(competence.getCompetencePK().getProgramCode(), "228106");
        }
    }

    @Test
    public void test8FindByVersion() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByVersion("Version 102");
        assertTrue(!lista.isEmpty());
        for (Competence competence : lista) {
            assertEquals(competence.getCompetencePK().getVersion(), "Version 102");
            
        }
    }

    @Test
    public void test9FindByLikeCompetenceCode() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeCompetenceCode("%2%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test10FindByLikeDescription() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeDescription("%a%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test11FindByLikeProgramCode() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeProgramCode("%1%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test12FindByLikeVersion() {
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeVersion("%2");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test13Delete() {
        System.out.println("Prueba del Delete");
        CompetenceDAO dao = CompetenceFactory.create(Competence.class);
        competence.setCompetencePK(new CompetencePK("123456789", "228106", "Version 102"));
        dao.remove(competence);
        assertEquals(dao.find(competence.getCompetencePK()), null);
    }
}
