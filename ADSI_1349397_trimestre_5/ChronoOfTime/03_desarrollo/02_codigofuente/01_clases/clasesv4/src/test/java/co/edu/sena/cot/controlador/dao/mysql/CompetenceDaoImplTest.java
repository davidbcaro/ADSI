/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.CompetenceDao;
import co.edu.sena.cot.controlador.factory.mysql.CompetenceFactory;
import co.edu.sena.cot.modelo.dto.Competence;
import co.edu.sena.cot.modelo.dto.CompetencePK;
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
public class CompetenceDaoImplTest {
    
    private Competence competence;
    private CompetencePK competencePk;
    
    public CompetenceDaoImplTest() {
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
        competence.setCompetencePK(new CompetencePK(12345678, 228106, "v 102"));
        competence.setDescription("Hola a todos x34");
        
        competencePk = new CompetencePK(87654321, 228106, "v 102");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByCodeCompetence method, of class CompetenceDaoImpl.
     */
    
     @Test
    public void test01Insert() {

        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        if (dao.find(competence.getCompetencePK()) == null) {
            dao.insert(competence);
        }
        assertEquals(dao.find(competence.getCompetencePK()), competence);
    }
    
     @Test
    public void test02find() {

        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        Competence competence2 = (Competence) dao.find(competence.getCompetencePK());
        assertEquals(competence2, competence);
    }
    
          @Test
    public void test03update() {

        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        competence.setDescription("Adios a todos x34");

        dao.update(competence);
        assertEquals(dao.find(competence.getCompetencePK()), competence);

    }
    
         @Test
    public void test80delete() {
        
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        competence.setCompetencePK(new CompetencePK(12345678, 228106, "v 102"));
        dao.remove(competence);
        assertEquals(dao.find(competence.getCompetencePK()), null);

    }
    
         @Test
    public void test06FindAll() {
        
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println("nananana "+lista);
    }
    
    @Test
    public void testFind07ByCodeCompetence() {
        System.out.println("las");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByCodeCompetence(220501032);
        assertTrue(!lista.isEmpty());
        for (Competence competence2 : lista) {
            assertEquals(competence2.getCompetencePK().getCodeCompetence(),220501032 );
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByDescription method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFind08ByDescription() {
        System.out.println("las");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByDescription("Analizar los requisitos del cliente para construir el sistema de información");
        assertTrue(!lista.isEmpty());
        for (Competence competence2 : lista) {
            assertEquals(competence2.getDescription(), "Analizar los requisitos del cliente para construir el sistema de información");
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByCodeProgram method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFind09ByCodeProgram() {
        System.out.println("las");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByCodeProgram(228106);
        assertTrue(!lista.isEmpty());
        for (Competence competence2 : lista) {
            assertEquals(competence2.getProgram().getProgramPK().getCodeProgram(), 228106 );
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByEdition method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFind10ByEdition() {
        System.out.println("las");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByEdition("v 102");
        assertTrue(!lista.isEmpty());
        for (Competence competence : lista) {
            assertEquals(competence.getCompetencePK().getEdition(), "v 102");
        }
        System.out.println("names "+lista);
    }

    /**
     * Test of findByLikeCodeComptence method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFindByLikeCodeComptence() {
        
    }

    /**
     * Test of findByLikeDescription method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFind11ByLikeDescription() {
         System.out.println("lassssss");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeDescription("%todos%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCodeProgram method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFindByLikeCodeProgram() {
        
    }

    /**
     * Test of findByLikeEdition method, of class CompetenceDaoImpl.
     */
    @Test
    public void testFind12ByLikeEdition() {
        System.out.println("lassssss");
        CompetenceDao dao = CompetenceFactory.create(Competence.class);
        List<Competence> lista = dao.findByLikeEdition("%10%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of updatePrimaryKey method, of class CompetenceDaoImpl.
     */
//    @Test
//    public void test13UpdatePrimaryKey() {
//        CompetenceDao dao = CompetenceFactory.create(Competence.class);
//        dao.updatePrimaryKey(competencePk, competence.getCompetencePK());
//        competence.setCompetencePK(competencePk);
//        assertEquals(dao.find(competencePk), competence);
//    }
    
}
