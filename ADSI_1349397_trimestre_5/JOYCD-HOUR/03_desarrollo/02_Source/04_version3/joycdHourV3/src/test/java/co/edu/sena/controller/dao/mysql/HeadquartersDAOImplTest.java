/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.HeadquartersDAO;
import co.edu.sena.controller.factory.HeadquartersFactory;
import co.edu.sena.model.jpa.entities.Headquarters;
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
 * @author liosalfar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadquartersDAOImplTest {

    private Headquarters head;

    public HeadquartersDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        head = new Headquarters();

        head.setNameHeadquarters("sedeSena");
        head.setDirection("kr 3 con 48");
        head.setStatus(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("test Insert Headquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        if (dao.find(head.getNameHeadquarters()) == null) {
            dao.insert(head);
        }
        assertEquals(dao.find(head.getNameHeadquarters()), head);

    }

    /**
     * Test of findByStatus method, of class DayDAOImpl.
     */
    @Test
    public void test2find() {
        System.out.println("Prueba consulta Headquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        Headquarters headconsulta = (Headquarters) dao.find(head.getNameHeadquarters());
        assertEquals(headconsulta, head);
    }

    /**
     *
     */
    @Test
    public void test3update() {
        System.out.println("Preba test uptdate");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        head.setStatus(Boolean.FALSE);
        head.setDirection("nueva direccion");
        dao.update(head);
        assertEquals(dao.find(head.getNameHeadquarters()), head);
    }

    @Test
    public void test3vUpdatePrimarykey() {
        System.out.println("prueba de update headquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        int resultado = dao.updatePrimaryKey("senaAntiguo", head.getNameHeadquarters());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4FindByLikeNameDay() {
        System.out.println("Prueba findlikeNameheadquarters ");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByLikeHeadquarters("s%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test5FindByLikeDirection() {
        System.out.println("Prueba findlikeDirection");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByLikeHeadquarters("%c%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindAll() {
        System.out.println("prueba consulta tabla headquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }

    //test delete
    @Test
    public void Test7remove() {
        System.out.println("prueba de Delete tabla headquarters");
        HeadquartersDAO dao = HeadquartersFactory.create(Headquarters.class);
        head.setNameHeadquarters("senaAntiguo");
        dao.remove(head);
        assertEquals(dao.find(head.getNameHeadquarters()), null);
    }

    /**
     * Test of findByNameHeadquarters method, of class HeadquartersDAOImpl.
     */
}
