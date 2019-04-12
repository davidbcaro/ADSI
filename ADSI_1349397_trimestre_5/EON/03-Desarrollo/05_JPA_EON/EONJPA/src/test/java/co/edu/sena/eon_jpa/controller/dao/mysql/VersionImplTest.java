/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.VersionDao;
import co.edu.sena.eon_jpa.controller.factory.VersionFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Version;
import co.edu.sena.eon_jpa.model.jpa.entities.VersionPK;
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
 * @author Telegrafia01
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VersionImplTest {

    private Version v;
    private VersionPK ve;

    public VersionImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        v = new Version();
        v.setVersionPK(new VersionPK(7, "3"));
        v.setActive(Boolean.TRUE);

        ve = new VersionPK(1, "5");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void Test1Insert() {

        VersionDao dao = VersionFactory.create(Version.class);
        if (dao.find(v.getVersionPK()) == null) {
            dao.insert(v);
        }
        assertEquals(dao.find(v.getVersionPK()), v);
    }

    @Test
    public void test2Find() {
        VersionDao dao = VersionFactory.create(Version.class);
        Version versionConsultada = (Version) dao.find(v.getVersionPK());
        assertEquals(versionConsultada, v);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        VersionDao dao = VersionFactory.create(Version.class);
        v.setActive(false);
        dao.update(v);
        assertEquals(dao.find(v.getVersionPK()), v);
    }

//    @Test
//    public void test3vUpdatePrimaryKey() {
//        VersionDao dao = VersionFactory.create(Version.class);
//        dao.updatePrimaryKey(ve, v.getVersionPK());
//        v.setVersionPK(ve);
//        assertEquals(dao.find(ve), v);
//    }

    @Test
    public void test4Delete() {

        VersionDao dao = VersionFactory.create(Version.class);
        v.setVersionPK(ve);
        dao.remove(v);
        assertEquals(dao.find(v.getVersionPK()), null);

    }

    /**
     * Test of findByIdCurrentQuarter method, of class VersionImpl.
     */
    @Test
    public void testFindByIdCurrentQuarter() {
    }

    /**
     * Test of findByIdVersion method, of class VersionImpl.
     */
    @Test
    public void testFindByIdVersion() {
    }

    /**
     * Test of findByActive method, of class VersionImpl.
     */
    @Test
    public void testFindByActive() {
    }

    /**
     * Test of findByLikeIdCurrentQuarter method, of class VersionImpl.
     */
    @Test
    public void testFindByLikeIdCurrentQuarter() {
    }

    /**
     * Test of findByLikeIdVersion method, of class VersionImpl.
     */
    @Test
    public void testFindByLikeIdVersion() {
    }

    /**
     * Test of updatePrimaryKey method, of class VersionImpl.
     */
    @Test
    public void testUpdatePrimaryKey() {
    }

 
    
}
