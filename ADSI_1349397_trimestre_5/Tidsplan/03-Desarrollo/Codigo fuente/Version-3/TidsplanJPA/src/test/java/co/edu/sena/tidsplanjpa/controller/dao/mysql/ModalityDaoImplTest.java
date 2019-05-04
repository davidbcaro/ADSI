/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.ModalityDao;
import co.edu.sena.tidsplanjpa.controller.factory.ModalityFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Modality;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author JulianC
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ModalityDaoImplTest {

    private Modality m;

    @Before
    public void setUp() {
        m = new Modality();
       m.setNameModality("semipresencial");
       m.setStatus(Boolean.TRUE);
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        if (dao.find(m.getNameModality()) == null) {
            dao.insert(m);
        }
        assertEquals(dao.find(m.getNameModality()), m);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba find");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        Modality dc = (Modality) dao.find(m.getNameModality());
        assertEquals(dc, m);
    }

    @Test
    public void test03update() {
        System.out.println("Prueba update");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        m.setStatus(Boolean.FALSE);
        dao.update(m);
        assertEquals(dao.find(m.getNameModality()), m);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba update primary key");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        int result = dao.updatePrimaryKey("Semivirtual", m.getNameModality());
        assertEquals(result, 1);
    }
    
    @Test
    public void test05FindAll() {
        System.out.println("Prueba de metodo FindAll");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> list = dao.findAll();
        assertFalse(list.isEmpty());
    }
    
    @Test
    public void test06FindByNameModality() {
        System.out.println("Prueba de Find By");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByNameModality("Semivirtual");
        assertTrue(!lista.isEmpty());
        for (Modality mod : lista) {
            assertEquals(mod.getNameModality(), "Semivirtual");
        }
    }
    
    @Test
    public void test07FindByLikeTypeDocument() {
        System.out.println("Prueba de Find Like");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByLikeNameModality("%");
        assertTrue(!lista.isEmpty());
        for (Modality mo : lista) {
            System.out.println(mo);

        }

    }
    
    @Test
    public void test08FindByStatus() {
        System.out.println("Prueba de Find By");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByStatus(false);
        assertTrue(!lista.isEmpty());
        for (Modality mo : lista) {
            assertEquals(mo.getStatus(), false);
        }
    }
    @Test
    public void test09Delete() {
        System.out.println("Prueba de delete");
        ModalityDao dao = ModalityFactory.create(Modality.class);
        m.setNameModality("Semivirtual");
        dao.remove(m);
        assertEquals(dao.find(m.getNameModality()), null);

    }
}
