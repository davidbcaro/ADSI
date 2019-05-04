/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.CompetitionDao;
import co.edu.sena.tidsplanjpa.controller.factory.CompetitionFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Competition;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CompetitionPK;
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
public class CompetitionDaoImplTest {

    private Competition co;
    private CompetitionPK copk;

    public CompetitionDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        co = new Competition();
        co.setCompetitionPK(new CompetitionPK("1111", "228106", "102"));
        co.setDescription("sistema");

        copk = new CompetitionPK();
        copk.setCode("1111");
        copk.setProgramCode("228106");
        copk.setProgramVersion("102");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Competicion metodo insert");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        if (dao.find(co.getCompetitionPK()) == null) {
            dao.insert(co);
        }
        assertEquals(dao.find(co.getCompetitionPK()), co);

    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de Competicion metodo find");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        Competition competitionConsulted = (Competition) dao.find(co.getCompetitionPK());
        assertEquals(competitionConsulted, co);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de Competicion metodo update");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        co.setDescription("necesidades del cliente");
        dao.update(co);
        assertEquals(dao.find(co.getCompetitionPK()), co);

    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba de Competicion metodo Update por llave primaria");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        int resultado = dao.updatePrimaryKey(copk, co.getCompetitionPK());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05Delete() {
        System.out.println("Prueba de competencia metodo Delete");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        co.setCompetitionPK(copk);
        dao.remove(co);
        assertEquals(dao.find(co.getCompetitionPK()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("Prueba de Competencia metodo FindAll");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByCode() {
        System.out.println("Prueba de Competencia metodo FindByCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByCode("220501006");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
            assertEquals(competition.getCompetitionPK().getCode(), "220501006");
        }
    }

    @Test
    public void test08FindByLikeCode() {
        System.out.println("Prueba de Competencia metodo FindByLikeCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByLikeCode("%5%");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
        }
    }

    @Test
    public void test09FindByProgramCode(){
        System.out.println("Prueba de Competencia metodo FindByProgramCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByProgramCode("228106");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
            assertEquals(competition.getCompetitionPK().getProgramCode(), "228106");
        }
    }

    @Test
    public void test10FindByLikeProgramCode() {
        System.out.println("Prueba de Competencia metodo FindByLikeProgramCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByLikeProgramCode("%8%");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
        }
    }

    @Test
    public void test11FindByProgramVersion() {
        System.out.println("Prueba de Competencia metodo FindByProgramVersion");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByProgramVersion("102");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
            assertEquals(competition.getCompetitionPK().getProgramVersion(), "102");
        }
    }

    @Test
    public void test12FindByLikeProgramVersion() {
        System.out.println("Prueba de Competencia metodo FindByLikeProgramVersion");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByLikeProgramCode("%1%");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
        }
    }

    /**
     * Test of findByLikeDescription method, of class CompetitionDaoImpl.
     */
    @Test
    public void testFindByDescription() {
        System.out.println("Prueba de Competencia metodo FindByDescription ");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByDescription("Participar en el proceso de negociación de Tecnología informática para permitir la implementación del sistema de información.");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
        }
    }

    @Test
    public void test10FindByLikeDescription() {
      System.out.println("Prueba de Competencia metodo FindByLikeDescription ");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> list = dao.findByLikeDescription("%Part%");
        assertFalse(list.isEmpty());
        for (Competition competition : list) {
            System.out.println(competition);
        }
    }

}
