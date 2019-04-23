/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.LinkingFactory;
import co.edu.sena.wariosoftjpa.controller.dao.LinkingDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Linking;
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
public class LinkingImplTest {
    
    private Linking lt;
    
    public LinkingImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lt = new Linking();
        lt.setTypeLinking("Tiempo Corto");
        lt.setHours(2);
        lt.setState(true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("prueba de Linking metodo insert");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        if (dao.find(lt.getTypeLinking()) == null) {
            dao.insert(lt);
        }
        assertEquals(dao.find(lt.getTypeLinking()), lt);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de Linking metodo find por llave primaria");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        Linking LinkingConsultado = (Linking) dao.find(lt.getTypeLinking());
        assertEquals(LinkingConsultado, lt);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de Linking metodo update po llave primaria");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        lt.setState(Boolean.FALSE);
        dao.update(lt);
        assertEquals(dao.find(lt.getTypeLinking()), lt);
    }

    @Test
    public void test3updatePk() {
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        int resultado = dao.updatePk("Tiempo libre", lt.getTypeLinking());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4delete() {
        System.out.println("prueba de Linking metodo delete para la llave");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        lt.setTypeLinking("Tiempo libre");
        dao.remove(lt);
        assertEquals(dao.find(lt.getTypeLinking()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de Linking metodo findall");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        List<Linking> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    
    /**
     * Test of findByTipeLinking method, of class LinkingImpl.
     */
    @Test
    public void test6FindByTypeLinking() {
        System.out.println("findByTipeLinking");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        List<Linking> lista = dao.findByTypeLinking("Tiempo Corto");
        for (Linking linking : lista) {
            assertEquals(linking.getTypeLinking(), "Tiempo Corto");
        }
    }

    /**
     * Test of findByHours method, of class LinkingImpl.
     */
    @Test
    public void test7FindByHours() {
        System.out.println("findByHours");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        List<Linking> lista = dao.findByHours(12);
        for (Linking linking : lista) {
            assertEquals(linking.getHours(), 2);
        }
    }

    /**
     * Test of findByState method, of class LinkingImpl.
     */
    @Test
    public void test8FindByState() {
        System.out.println("findByState");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        List<Linking> lista = dao.findByState(true);
        for (Linking linking : lista) {
            assertEquals(linking.getState(), true);
        }
    }

    /**
     * Test of findByLikeTipeLinking method, of class LinkingImpl.
     */
    @Test
    public void test9FindByLikeTypeLinking() {
        System.out.println("findByLikeTipeLinking");
        LinkingDAO dao = LinkingFactory.create(Linking.class);
        List<Linking> lista = dao.findByLikeTypeLinking("M%");
        assertTrue(!lista.isEmpty());
    }    
}
