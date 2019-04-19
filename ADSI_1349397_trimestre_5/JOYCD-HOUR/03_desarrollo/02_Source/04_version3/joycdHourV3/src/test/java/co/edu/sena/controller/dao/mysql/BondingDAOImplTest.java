/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.BondingDAO;
import co.edu.sena.controller.factory.BondingFactory;
import co.edu.sena.model.jpa.entities.Bonding;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class BondingDAOImplTest {

    private Bonding bon;

    public BondingDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        bon = new Bonding();
        bon.setTypeBonding("madrugada");
        bon.setStatus(Boolean.TRUE);
        bon.setHours(6);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        if (dao.find(bon.getTypeBonding()) == null) {
            dao.insert(bon);
        }
        assertEquals(dao.find(bon.getTypeBonding()), bon);
    }

    @Test
    public void test2find() {

        System.out.println("Prueba consulta bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        Bonding bondingconsulta = (Bonding) dao.find(bon.getTypeBonding());
        assertEquals(bondingconsulta, bon);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de actualizacion de campos de la tabla bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        bon.setHours(7);
        bon.setStatus(Boolean.FALSE);
        dao.update(bon);
        assertEquals(dao.find(bon.getTypeBonding()), bon);

    }

    @Test
    public void test3vUpdatePrimarykey() {
        System.out.println("prueba de update Bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        int resultado = dao.updatePrimaryKey("madrugada33", bon.getTypeBonding());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4delete() {
        System.out.println("prueba de delete Bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        bon.setTypeBonding("madrugada33");
        dao.remove(bon);
        assertEquals(dao.find(bon.getTypeBonding()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de select Bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void test6FindLikeTypeBonding() {
        System.out.println("prueba de select Bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        List<Bonding> lista = dao.findByLikeTypeBonding("M%");
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void test7FindLikeHours() {
        System.out.println("prueba de select Bonding");
        BondingDAO dao = BondingFactory.create(Bonding.class);
        
        List<Bonding> lista = dao.findByLikeHours("%8%");
        assertTrue(!lista.isEmpty());
        
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kintmas");
        EntityManager em = emf.createEntityManager();
        System.out.println("conecta a la base de datos");
        

    }

}
