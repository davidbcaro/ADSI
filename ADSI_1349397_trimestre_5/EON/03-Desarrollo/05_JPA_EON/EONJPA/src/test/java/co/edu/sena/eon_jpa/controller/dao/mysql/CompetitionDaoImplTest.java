/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.CompetitionDao;
import co.edu.sena.eon_jpa.controller.factory.CompetitionFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Competition;
import co.edu.sena.eon_jpa.model.jpa.entities.CompetitionPK;
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
public class CompetitionDaoImplTest {
    
    private Competition competition;
    private CompetitionPK updatePK;
    
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
        
        competition = new Competition();
        competition.setCompetitionPK(new CompetitionPK("Prueba", "5768877", "V107"));
        competition.setDescription("Prueba de insert de Competition");
        
        updatePK = new CompetitionPK("Update", "228106", "V102");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("Test Insert");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        dao.insert(competition);
        Competition c1 = (Competition) dao.find(competition.getCompetitionPK());
        assertEquals(c1, competition);
    }

    @Test
    public void test2find() {
        System.out.println("Test Find");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        Competition competitionConsulted = (Competition) dao.find(competition.getCompetitionPK());
        assertEquals(competitionConsulted, competition);
    }

    @Test
    public void test3update() {
        System.out.println("Test Update");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        competition.setDescription("Prueba de Update de Competition");
        dao.update(competition);
        assertEquals(dao.find(competition.getCompetitionPK()), competition);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        dao.updatePrimaryKey(updatePK, competition.getCompetitionPK());
        competition.setCompetitionPK(updatePK);
        assertEquals(dao.find(updatePK), competition);
    }

    @Test
    public void test4delete() {
        System.out.println("Test Delete");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        competition.setCompetitionPK(updatePK);
        dao.remove(competition);
        assertEquals(dao.find(competition.getCompetitionPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Test findAll");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByCode() {
        System.out.println("Test findByCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByCode("220501032");
        assertTrue(!lista.isEmpty());
        for(Competition c1: lista){
            assertEquals(c1.getCompetitionPK().getCompetitioncode(), "220501032");
        }
    }

    @Test
    public void test6FindByDescription() {
        System.out.println("Test findByDescription");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByDescription("Analizar los requisitos del cliente para construir el sistema de información");
        assertTrue(!lista.isEmpty());
        for(Competition c1: lista){
            assertEquals(c1.getDescription(), "Analizar los requisitos del cliente para construir el sistema de información");
        }
    }

    @Test
    public void test6FindByProgramCode() {
        System.out.println("Test findByProgramCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByProgramCode("228106");
        assertTrue(!lista.isEmpty());
        for(Competition c1: lista){
            assertEquals(c1.getCompetitionPK().getProgramCode(), "228106");
        }
    }

    @Test
    public void test6FindByProgramVersion() {
        System.out.println("Test findByProgramVersion");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByProgramVersion("V102");
        assertTrue(!lista.isEmpty());
        for(Competition c1: lista){
            assertEquals(c1.getCompetitionPK().getVersion(), "V102");
        }
    }

    @Test
    public void test6FindByLikeCode() {
        System.out.println("Test findByLikeCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeCode("%2%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeDescription() {
        System.out.println("Test findByLikeDescription");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeDescription("%A%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeProgramCode() {
        System.out.println("Test findByLikeProgramCode");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeProgramCode("%22%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByLikeProgramVersion() {
        System.out.println("Test findByLikeProgramVersion");
        CompetitionDao dao = CompetitionFactory.create(Competition.class);
        List<Competition> lista = dao.findByLikeProgramVersion("%V1%");
        assertTrue(!lista.isEmpty());
    }   
}
