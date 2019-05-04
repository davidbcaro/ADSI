/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.EnvironmentDao;
import co.edu.sena.tidsplanjpa.controller.factory.EnvironmentFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Environment;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EnvironmentPK;
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

public class EnvironmentDaoImplTest {

    private Environment e;
    private EnvironmentPK epk;

    @Before
    public void setUp() {
        e = new Environment();
        e.setEnvironmentPK(new EnvironmentPK("56", "Barrio Colombia"));
        e.setDescription("Nueva descripción");
        e.setStatus(Boolean.TRUE);

        epk = new EnvironmentPK();
        epk.setNameHeadquartes("Barrio colombia");
        epk.setNumberEnvironment("666");
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de metodo insert");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        if (dao.find(e.getEnvironmentPK()) == null) {
            dao.insert(e);
        }
        assertEquals(dao.find(e.getEnvironmentPK()), e);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de metodo find");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        Environment en = (Environment) dao.find(e.getEnvironmentPK());
        assertEquals(en, e);
    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de metodo Update");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        e.setDescription("Sede new");
        e.setStatus(true);
        dao.update(e);
        assertEquals(dao.find(e.getEnvironmentPK()), e);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de metodo update por llave primaria");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        int result = dao.updatePrimaryKey(epk, e.getEnvironmentPK());
        assertEquals(result, 1);
    }

    @Test
    public void test05FindAll() {
        System.out.println("prueba de metodo Find All");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findAll();
        assertFalse(list.isEmpty());
    }
     @Test
    public void test06Delete() {
        System.out.println("prueba de metodo delete");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        e.setEnvironmentPK(epk);
        dao.remove(e);
        assertEquals(dao.find(e.getEnvironmentPK()), null);
    }

    @Test
    public void test07FindByNumberEnvironment() {
        System.out.println("prueba de metodo Find By");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByNumberEnvironment("200");
        assertFalse(list.isEmpty());
        for (Environment en : list) {
            assertEquals(en.getEnvironmentPK().getNumberEnvironment(), "200");
        }
    }

    @Test
    public void test08FindByLikeNumberEnvironment() {
        System.out.println("prueba de metodo Find By Like");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByLikeNumberEnvironment("%");
        assertFalse(list.isEmpty());
        for (Environment e : list) {
            System.out.println(e);
        }
    }

    @Test
    public void test09FindByDescription() {
        System.out.println("prueba de metodo Find By");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByDescription("Ambiente 101");
        assertFalse(list.isEmpty());
        for (Environment en : list) {
            assertEquals(en.getDescription(), "Ambiente 101");
        }
    }
    
    @Test
    public void test10FindByLikeDescription() {
        System.out.println("prueba de metodo Find By Like");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByLikeDescription("%");
        assertFalse(list.isEmpty());
        for (Environment e : list) {
            System.out.println(e);
        }
    }

    @Test
    public void test11FindByStatus() {
        System.out.println("prueba de metodo Find By");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByStatus(true);
        assertFalse(list.isEmpty());
        for (Environment en : list) {
            assertEquals(en.getStatus(), true);
        }
    }

    @Test
    public void test12FindByNameHeadquartes() {
        System.out.println("prueba de metodo Find By");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByNameHeadquartes("Barrio Colombia");
        assertFalse(list.isEmpty());
        for (Environment en : list) {
            assertEquals(en.getHeadquartes().getNameHeadquartes(), "Barrio Colombia");
        }
    }
    
    @Test
    public void test13FindByLikeNameHeadquartes() {
        System.out.println("prueba de metodo Find By Like");
        EnvironmentDao dao = EnvironmentFactory.create(Environment.class);
        List<Environment> list = dao.findByLikeNameHeadquartes("%");
        assertFalse(list.isEmpty());
        for (Environment e : list) {
            System.out.println(e);
        }
    }
    
   
}
