/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.HeadquartersFactory;
import co.edu.sena.wariosoftjpa.controller.dao.HeadquartersDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Headquarters;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Sebastian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadquartersImplTest {

    private Headquarters hq;

    public HeadquartersImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hq = new Headquarters();
        hq.setNameHeadquarters("Alameda del porvenir 2");
        hq.setAddress("cll 55 sur #104-49");
        hq.setState(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1insert() {
        System.out.println("Prueba de Headquarters insert");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        if (dao.find(hq.getNameHeadquarters()) == null) {
            dao.insert(hq);
        }
        assertEquals(dao.find(hq.getNameHeadquarters()), hq);

    }

    @Test
    public void test2find() {
        System.out.println("prueba de headquarters find ");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        Headquarters headquartersConsultado = (Headquarters) dao.find(hq.getNameHeadquarters());
        assertEquals(headquartersConsultado, hq);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de headquarters metodo update po llave primaria");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        hq.setAddress("cll 56 sur #105-48");
        hq.setState(Boolean.FALSE);
        dao.update(hq);
        assertEquals(dao.find(hq.getNameHeadquarters()), hq);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        System.out.println("Prueba update primaryKey");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        int resultado = dao.updatePrimaryKey("Chupameestepenco", hq.getNameHeadquarters());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4delete() {
        System.out.println("prueba de headquarters metodo delete para la llave");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        hq.setNameHeadquarters("Chupameestepenco");
        dao.remove(hq);
        assertEquals(dao.find(hq.getNameHeadquarters()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("Prueba de Project en metodo findAll");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByHeadquarters method, of class HeadquartersImpl.
     */
    @Test
    public void test6FindByHeadquarters() {
        System.out.println("Prueba de Headquarters en metodo findByHeadquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByHeadquarters("SENA SEDE BARRIO COLOMBIA");
        assertTrue(!lista.isEmpty());
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getNameHeadquarters(),"SENA SEDE BARRIO COLOMBIA");
        }
    }

    /**
     * Test of findByAddress method, of class HeadquartersImpl.
     */
    @Test
    public void testFindByAddress() {
        System.out.println(" Prueba de metodo findByAddress");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByAddress("Cll. 69 #20-36");
        assertTrue(!lista.isEmpty());
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getAddress(), "Cll. 69 #20-36");
        }
    }

  
    @Test
    public void testFindByState() {
        System.out.println("Prueba de metodo findByState");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
         List<Headquarters> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getState(), true);
        }
    }

    
    @Test
    public void testFindByLikeHeadquarters() {
        System.out.println("Prueba de metodo findByLikeHeadquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByLikeHeadquarters("%EDE%");
        assertTrue(!lista.isEmpty());
    }

    
}
