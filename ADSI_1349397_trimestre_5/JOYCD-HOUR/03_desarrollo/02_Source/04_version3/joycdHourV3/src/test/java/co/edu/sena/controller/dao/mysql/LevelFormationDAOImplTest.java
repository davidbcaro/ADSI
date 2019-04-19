/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.LevelFormationDAO;
import co.edu.sena.controller.factory.LevelFormationFactory;
import co.edu.sena.model.jpa.entities.LevelFormation;
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
 * @author Chritian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LevelFormationDAOImplTest {

    private LevelFormation levelFormation;

    public LevelFormationDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        levelFormation = new LevelFormation();
        levelFormation.setLevelFormation("awebo");
        levelFormation.setStatus(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByLevelFormation method, of class LevelFormationDAOImpl.
     */
    @Test
    public void test1Insert() {
        System.out.println("test Insert LevelFormation");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        if (dao.find(levelFormation.getLevelFormation()) == null) {
            dao.insert(levelFormation);
        }
        assertEquals(dao.find(levelFormation.getLevelFormation()), levelFormation);

    }

    /**
     * Test of findByStatus method, of class DayDAOImpl.
     */
    @Test
    public void test2find() {
        System.out.println("Prueba consulta LevelFormation");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        LevelFormation levelFormationconsulta = (LevelFormation) dao.find(levelFormation.getLevelFormation());
        assertEquals(levelFormationconsulta, levelFormation);
    }

    /**
     * Test of findByLikeNameDay method, of class DayDAOImpl.
     */
    @Test
    public void test3update() {
        System.out.println("Preba test uptdate");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        levelFormation.setStatus(Boolean.FALSE);
        dao.update(levelFormation);
        assertEquals(dao.find(levelFormation.getLevelFormation()), levelFormation);
    }

    @Test
    public void test4FindByLevelFormation() {
        System.out.println("Preba test findby");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        List<LevelFormation> lista = dao.findByLevelFormation("awebo");
        assertTrue(!lista.isEmpty());
        for (LevelFormation levelFormation : lista) {
            assertEquals(levelFormation.getLevelFormation(), "awebo");
        }
    }

    /**
     * Test of findByStatus method, of class LevelFormationDAOImpl.
     */
    @Test
    public void test5FindByStatus() {
        System.out.println("Preba test findbystatus");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        List<LevelFormation> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (LevelFormation level : lista) {
            assertEquals(levelFormation.getStatus(), true);
        }
    }

    /**
     * Test of findByLikeLevelFormation method, of class LevelFormationDAOImpl.
     */
    @Test
    public void test6FindByLikeLevelFormation() {
        System.out.println("Preba test findbyLike");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        List<LevelFormation> lista = dao.findByLikeLevelFormation("%w%");
        assertTrue(!lista.isEmpty());

    }

    /**
     * Test of updatePrimaryKey method, of class LevelFormationDAOImpl.
     */
    @Test
    public void test7UpdatePrimaryKey() {
        System.out.println("Preba test update primary key ");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        int resultado = dao.updatePrimaryKey("levelnormalito", levelFormation.getLevelFormation());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test8FindAll(){
       System.out.println("Preba test FindAll ");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        List<LevelFormation> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }
    
    @Test
    public void Test6Delete(){
        System.out.println("Preba test delete ");
        LevelFormationDAO dao = LevelFormationFactory.create(LevelFormation.class);
        levelFormation.setLevelFormation("levelnormalito");
        dao.remove(levelFormation);
        assertEquals(dao.find(levelFormation.getLevelFormation()), null);
    }
    
    
    

}
