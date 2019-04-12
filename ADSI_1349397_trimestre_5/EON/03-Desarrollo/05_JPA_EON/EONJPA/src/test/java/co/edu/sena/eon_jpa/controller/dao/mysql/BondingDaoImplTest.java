/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.BondingDao;
import co.edu.sena.eon_jpa.controller.factory.BondingFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Bonding;
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
 * @author Liliana Narvaez
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BondingDaoImplTest {

    Bonding b;

    public BondingDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        b = new Bonding();
        b.setTypeLinkage("awdawd");
        b.setHours(3);
        b.setStatus(true);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void test1Insert() {
         System.out.println("prueba de bonding metodo insert");
        BondingDao dao = BondingFactory.create(Bonding.class);
        if (dao.find(b.getTypeLinkage()) == null) {
            dao.insert(b);
        }
        assertEquals(dao.find(b.getTypeLinkage()), b);
    }

    @Test
    public void test2find() {

        System.out.println("prueba de vinculación metodo find por llave primaria");
        BondingDao dao = BondingFactory.create(Bonding.class);
        Bonding specialtyConsulted = (Bonding) dao.find(b.getTypeLinkage());
        assertEquals(specialtyConsulted, b);

    }

    @Test
    public void test3update() {
        System.out.println("Prueba de vinculación metodo update por llave primaria");
        BondingDao dao = BondingFactory.create(Bonding.class);
        b.setHours(7);
        b.setStatus(false);
        dao.update(b);
        assertEquals(dao.find(b.getTypeLinkage()), b);

    }

    @Test
    public void test3vupdatePrimaryKey() {
        BondingDao dao = BondingFactory.create(Bonding.class);
        int resultado = dao.updatePrimaryKey("Trabajando ando", b.getTypeLinkage());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4Delete() {
   System.out.println("prueba de vinculación metodo delete para la llave");
        BondingDao dao = BondingFactory.create(Bonding.class);
        b.setTypeLinkage("Trabajando ando");
        dao.remove(b);
        assertEquals(dao.find(b.getTypeLinkage()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Prueba de vinculación metodo findAll");
        BondingDao dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void test6findBytypeLinkage() {
        System.out.println("Prueba del metodo findBondingtype del dao Vinculación");
        BondingDao dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findBytypeLinkage("Tiempo Completo");
        assertTrue(!lista.isEmpty());
        for (Bonding Bonding : lista) {
            assertEquals(Bonding.getTypeLinkage(), "Tiempo Completo");
        }
    }

    @Test
    public void test6findByHours() {
        System.out.println("Prueba del metodo findHours del dao Vinculación");
        BondingDao dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findByHours(8);
        assertTrue(!lista.isEmpty());
        for (Bonding Bonding : lista) {
            assertEquals(Bonding.getHours(), 8);
        }
    }

    @Test
    public void test6findByStatus() {
        System.out.println("Prueba del metodo findState del dao Vinculación");
        BondingDao dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (Bonding Bonding : lista) {
            assertEquals(Bonding.getStatus(), true);
        }
    }

    @Test
    public void test6findByLiketypeLinkage() {
        System.out.println("Prueba del metodo findLikeBondingtype del dao Vinculación");
        BondingDao dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findByLiketypeLinkage("T%");
        assertTrue(!lista.isEmpty());
        for (Bonding Bonding : lista) {
            assertTrue(!lista.isEmpty());
        }

    }
}
