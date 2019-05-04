/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.VersionDao;
import co.edu.sena.tidsplanjpa.controller.factory.VersionFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Version;
import co.edu.sena.tidsplanjpa.model.jpa.entities.VersionPK;
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
 */ @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VersionDaoImplTest {
    private Version vs;
    private VersionPK vspk;
    public VersionDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vs = new Version();
        vs.setVersionPK(new VersionPK(7, "T1"));
        vs.setStatus(false);
        
        vspk = new VersionPK();
        vspk.setIdVersion(13);
        vspk.setIdTrimesterCurrent("T3");
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdVersion method, of class VersionDaoImpl.
     */
    
     @Test
    public void test01Insert() {
        System.out.println("Prueba de  insert");
        VersionDao dao = VersionFactory.create(Version.class);
        if (dao.find(vs.getVersionPK()) == null) {
            dao.insert(vs);
        }
        assertEquals(dao.find(vs.getVersionPK()), vs);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de  find");
        VersionDao dao = VersionFactory.create(Version.class);
        Version versionConsulted = (Version) dao.find(vs.getVersionPK());
        assertEquals(versionConsulted, vs);

    }
    
    @Test
    public void test03Update(){
         System.out.println("Prueba de Update");
        VersionDao dao = VersionFactory.create(Version.class);
        vs.setStatus(false);
        dao.update(vs);
        assertEquals(dao.find(vs.getVersionPK()), vs);
    } 
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de update por llave primaria");
        VersionDao dao = VersionFactory.create(Version.class);
        int resultado = dao.updatePrimaryKey(vspk ,vs.getVersionPK());
        assertEquals(resultado, 1);
    }
    @Test
    public void test05delete() {
        System.out.println("prueba de  delete");
        VersionDao dao = VersionFactory.create(Version.class);
        vs.setVersionPK(vspk);
        dao.remove(vs);
        assertEquals(dao.find(vs.getVersionPK()), null);
    }

     
       
        
      @Test
    public void test06FindAll() {
        System.out.println("prueba de  findAll");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> list = dao.findAll();
        assertFalse(list.isEmpty());
    }
    
       @Test
    public void test07FindByIdVersion() {
        System.out.println("Prueba de FindByIdVersion");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> lista = dao.findByIdVersion(3);
        for (Version version : lista) {
            assertEquals(version.getVersionPK().getIdVersion(), 3);
        }
    }

    /**
     * Test of findByLikeMail method, of class UserDaoImpl.
     */
    @Test
    public void test08FindByLikeIdVersion() {
        System.out.println("Prueba de  findByLikeIdVersion");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> list = dao.findByLikeIdVersion(3);
        assertTrue(!list.isEmpty());
        for (Version version : list) {
            System.out.println(version);
        }
    
    }
    
        @Test
    public void test09FindByIdTrimesterCurrent() {
        System.out.println("Prueba de FindByIdTrimesterCurrent");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> lista = dao.findByIdTrimesterCurrent("T4");
        for (Version version : lista) {
            assertEquals(version.getVersionPK().getIdTrimesterCurrent(), "T4");
        }
    }

    /**
     * Test of findByLikeMail method, of class UserDaoImpl.
     */
    @Test
    public void test10FindByLikeIdTrimesterCurrent() {
        System.out.println("Prueba de  findByLikeIdTrimesterCurrent");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> list = dao.findByLikeIdTrimesterCurrent("%4%");
        assertTrue(!list.isEmpty());
        for (Version version : list) {
            System.out.println(version);
        }
    
    }
        @Test
    public void test11FindByStatus() {
        System.out.println("Prueba de FindByStatus");
        VersionDao dao = VersionFactory.create(Version.class);
        List<Version> lista = dao.findByStatus(true);
        for (Version version : lista) {
            assertEquals(version.getStatus(), true);
        }
    }
}
