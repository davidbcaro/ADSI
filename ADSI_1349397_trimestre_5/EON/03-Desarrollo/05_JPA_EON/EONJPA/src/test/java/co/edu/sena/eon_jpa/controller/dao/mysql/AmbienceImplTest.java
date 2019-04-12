/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.AmbienceDao;
import co.edu.sena.eon_jpa.controller.factory.AmbienceFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Ambience;
import co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SOPORTE
 */
public class AmbienceImplTest {
    
    private Ambience a;
    private AmbiencePK b;

    
    public AmbienceImplTest() {
    }

    
    @BeforeClass
    public static void setUpClass() {
    }

    
    @AfterClass
    public static void tearDownClass() {
    }

    
    @Before
    public void setUp() {
    a = new Ambience();
    a.setAmbiencePK(new AmbiencePK("000", "Sede Barrio Colombia"));
    a.setDescription("vgerfg");
    a.setStatus(Boolean.TRUE);
    
    b= new AmbiencePK ("1111", "Sede Barrio Colombia");
    
    
    }
    

    
    @After
    public void tearDown() {
    }

    
   

    
    @Test
     public void test1Insert(){
     AmbienceDao dao = AmbienceFactory.create(Ambience.class);
     if (dao.find(a.getAmbiencePK())== null) {
         
            dao.insert(a);
}
     assertEquals(dao.find(a.getAmbiencePK()),a);

     
     }
     
     @Test
 public void test2Find() {
        AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        Ambience ambienceConsultado = (Ambience) dao.find(a.getAmbiencePK());
        assertEquals(ambienceConsultado,a);
    }
 
  @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        a.setDescription("pppp");
        a.setStatus(Boolean.FALSE);
        dao.update(a);
        assertEquals(dao.find(a.getAmbiencePK()), a);
    }
    
    @Test
    public void test3vUpdatePrimaryKey() {
        AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        dao.updatePrimaryKey(b , a.getAmbiencePK());
        a.setAmbiencePK(b);
        assertEquals(dao.find(b),a);
    }
    
     @Test
    public void test4Delete(){
       
        AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        a.setAmbiencePK(b);
        dao.remove(a);
                assertEquals(dao.find(a.getAmbiencePK()),null);

        
    }

    /**
     * Test of findByDescription method, of class AmbienceImpl.
     */
    @Test
    public void testFindByDescription() {
           AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByDescription("m");
        for (Ambience ambience : lista) {
            assertEquals(ambience.getDescription(), "m");
        }
    }

    @Test
    public void testFindByStatus() {
         AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByStatus(true);
        for (Ambience ambience : lista) {
            assertEquals(ambience.getStatus(), true);
        }
    }

    /**
     * Test of findByNumberAmbience method, of class AmbienceImpl.
     */
    @Test
    public void testFindByNumberAmbience() {
         AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByDescription("m");
        for (Ambience ambience : lista) {
            assertEquals(ambience.getDescription(), "m");
        }
    }

    /**
     * Test of findByNameHeadquarters method, of class AmbienceImpl.
     */
    @Test
    public void testFindByNameHeadquarters() {
         AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByDescription("m");
        for (Ambience ambience : lista) {
            assertEquals(ambience.getDescription(), "m");
        }
    }

    /**
     * Test of findByLikeDescription method, of class AmbienceImpl.
     */
    @Test
    public void testFindByLikeDescription() {
            AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByLikeDescription("%m");
        for (Ambience ambience : lista) {
            assertEquals(ambience.getDescription(), "%m");
        }
    }

    /**
     * Test of findByLikeNumberAmbience method, of class AmbienceImpl.
     */
    @Test
    public void testFindByLikeNumberAmbience() {
                   AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByLikeNumberAmbience("%0");
        for (Ambience ambience : lista) {
            assertEquals(ambience.getAmbiencePK().getNumberAmbience().contains("0"), true);
        }
    }

    /**
     * Test of findByLikeNameHeadquarters method, of class AmbienceImpl.
     */
    @Test
    public void testFindByLikeNameHeadquarters() {
              AmbienceDao dao = AmbienceFactory.create(Ambience.class);
        List<Ambience> lista = dao.findByLikeNameHeadquarters("%S%");
        for (Ambience ambience : lista) {
            assertTrue(ambience.getAmbiencePK().getNameHeadquarters().contains("S"));
        }
    }

    /**
     * Test of updatePrimaryKey method, of class AmbienceImpl.
     */
    @Test
    public void testUpdatePrimaryKey() {
        
    }
    
}
