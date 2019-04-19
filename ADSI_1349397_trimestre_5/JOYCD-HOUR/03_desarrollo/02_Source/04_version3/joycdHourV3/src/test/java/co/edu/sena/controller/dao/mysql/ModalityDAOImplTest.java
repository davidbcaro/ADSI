/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ModalityDAO;
import co.edu.sena.controller.factory.ModalityFactory;
import co.edu.sena.model.jpa.entities.Modality;
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
public class ModalityDAOImplTest {

    private Modality mod;

    public ModalityDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mod = new Modality();
        mod.setNameModality("online");
        mod.setStatus(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameModality method, of class ModalityDAOImpl.
     */
    @Test
    public void test1Insert() {
        System.out.println("test Insert Modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        if (dao.find(mod.getNameModality()) == null) {
            dao.insert(mod);
        }
        assertEquals(dao.find(mod.getNameModality()), mod);

    }

    /**
     * Test of findByStatus method, of class DayDAOImpl.
     */
    @Test
    public void test2find() {
        System.out.println("Prueba consulta Modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        Modality modalityConsulta = (Modality) dao.find(mod.getNameModality());
        assertEquals(modalityConsulta, mod);
    }

    /**
     * Test of findByLikeNameDay method, of class DayDAOImpl.
     */
    @Test
    public void test3update() {
        System.out.println("Preba test uptdate Modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        mod.setStatus(Boolean.FALSE);
        dao.update(mod);
        assertEquals(dao.find(mod.getNameModality()), mod);
    }

    @Test
    public void test3vUpdatePrimarykey() {
        System.out.println("prueba de update Modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        int resultado = dao.updatePrimaryKey("offLine", mod.getNameModality());
        assertEquals(resultado, 1);

    }

    @Test
    public void test4FindByLikeNameModality() {
        System.out.println("Prueba FindByLikeNameModality");
         ModalityDAO dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByLikeNameModality("v%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba consulta tabla modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }

    @Test
    public void Test6Delete() {
        System.out.println("prueba de Delete tabla modality");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        mod.setNameModality("offLine");
        dao.remove(mod);
        assertEquals(dao.find(mod.getNameModality()), null);
    }

}
