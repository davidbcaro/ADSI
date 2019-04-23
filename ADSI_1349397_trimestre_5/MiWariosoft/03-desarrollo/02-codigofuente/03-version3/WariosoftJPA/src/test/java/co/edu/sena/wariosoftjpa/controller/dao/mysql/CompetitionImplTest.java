/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.CompetitionFactory;
import co.edu.sena.wariosoftjpa.controller.dao.CompetitionDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Competition;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CompetitionPK;
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
public class CompetitionImplTest {
    
    private Competition com;
    private CompetitionPK comPK;
    
    public CompetitionImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        com = new Competition();
        com.setCompetitionPK(new CompetitionPK("222666666", "228106", "Version 102"));
        com.setDescription("loquesea");
        
        comPK = new CompetitionPK("220501006", "228106", "Version 102");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        dao.insert(com);
        Competition Competition = (Competition) dao.find(com.getCompetitionPK());
        assertEquals(Competition, com);
    }

    @Test
    public void test2findpk() {
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        Competition cm = (Competition) dao.find(com.getCompetitionPK());
        assertEquals(cm, com);
    }

    @Test
    public void test3update() {
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        com.setDescription("cual");
        dao.update(com);
        assertEquals(dao.find(com.getCompetitionPK()), com);
    }

    @Test
    public void test3updatePk() {
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        dao.updatePk(comPK, com.getCompetitionPK());
        com.setCompetitionPK(comPK);
        assertEquals(dao.find(comPK), com);
        
    }

    @Test
    public void test4Remove() {
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        com.setCompetitionPK(new CompetitionPK("222666666", "228106", "Version 102"));
        dao.remove(com);
        assertEquals(dao.find(com.getCompetitionPK()), null);

    }
 
    /**
     * Test of findByCode method, of class CompetitionImpl.
     */
    @Test
    public void test5FindByCode() {
        System.out.println("findByCode");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByCode("220501006");
        for (Competition competition : lista) {
            assertEquals(competition.getCompetitionPK().getCompetitionCode(), "220501006");
        }
    }

    /**
     * Test of findByDescription method, of class CompetitionImpl.
     */
    @Test
    public void test6FindByDescription() {
        System.out.println("findByDescription");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByDescription("Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente");
        for (Competition competition : lista) {
            assertEquals(competition.getDescription(), "Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente");
        }
    }

    /**
     * Test of findByLikeCode method, of class CompetitionImpl.
     */
    @Test
    public void test7FindByLikeCode() {
        System.out.println("findByLikeCode");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByCode("220501006");
        for (Competition competition : lista) {
            assertEquals(competition.getCompetitionPK().getCompetitionCode(), "220501006");
        }
    }

    /**
     * Test of findByProgramCode method, of class CompetitionImpl.
     */
    @Test
    public void test8FindByProgramCode() {
        System.out.println("findByProgramCode");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByProgramCode("228106");
        for (Competition competition : lista) {
            assertEquals(competition.getCompetitionPK().getProgramCode(), "228106");
        }
    }

    /**
     * Test of findByProgramVersion method, of class CompetitionImpl.
     */
    @Test
    public void test9FindByProgramVersion() {
        System.out.println("findByProgramVersion");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByProgramVersion("version 102");
        for (Competition competition : lista) {
            assertEquals(competition.getProgram().getProgramPK().getVersion(), "version 102");
        }
    }

    /**
     * Test of findByLikeProgramCode method, of class CompetitionImpl.
     */
    @Test
    public void test10FindByLikeProgramCode() {
        System.out.println("findByLikeProgramCode");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeProgramCode("228106");
        for (Competition competition : lista) {
            assertEquals(competition.getCompetitionPK().getProgramCode(), "228106");
        }
    }

    /**
     * Test of findByLikeProgramVersion method, of class CompetitionImpl.
     */
    @Test
    public void test11FindByLikeProgramVersion() {
        System.out.println("findByLikeProgramVersion");
        CompetitionDAO dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeProgramVersion("version 102");
        for (Competition competition : lista) {
            assertEquals(competition.getProgram().getProgramPK().getVersion(), "version 102");
        }
    }    
}
