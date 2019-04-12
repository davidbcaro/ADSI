/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.TrimesterDao;
import co.edu.sena.eon_jpa.controller.factory.TrimesterFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import co.edu.sena.eon_jpa.model.jpa.entities.TrimesterPK;
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
public class TrimesterImplTest {
    private Trimester t;
    private TrimesterPK te;
    public TrimesterImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new Trimester();
        t.setTrimesterPK(new TrimesterPK("10", "D", "TeleInformatica"));
        te = new TrimesterPK("ggg", "D", "TeleInformatica");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByQuarterName method, of class TrimesterImpl.
     */
     @Test
    public void test1Insert() {

        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        if (dao.find(t.getTrimesterPK()) == null) {
            dao.insert(t);
        }
        assertEquals(dao.find(t.getTrimesterPK()), t);
    }
    
    @Test
    public void test2Find() {
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        Trimester trimesterConsultada = (Trimester) dao.find(t.getTrimesterPK());
        assertEquals(trimesterConsultada, t);
    }

    @Test
    public void test3vUpdatePrimaryKey() {
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        dao.updatePrimaryKey(te, t.getTrimesterPK());
        t.setTrimesterPK(te);
        assertEquals(dao.find(te), t);
    }
    
        @Test
    public void test4Delete() {

        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        t.setTrimesterPK(te);
        dao.remove(t);
        assertEquals(dao.find(t.getTrimesterPK()), null);

    }
    @Test
    public void testFindByQuarterName() {
    }

    
    /**
     * Test of findByAcronymsWorkingDay method, of class TrimesterImpl.
     */
    @Test
    public void testFindByAcronymsWorkingDay() {
    }

    /**
     * Test of findBySpecialityName method, of class TrimesterImpl.
     */
    @Test
    public void testFindBySpecialityName() {
    }

    /**
     * Test of findByLikeQuarterName method, of class TrimesterImpl.
     */
    @Test
    public void testFindByLikeQuarterName() {
    }

    /**
     * Test of findByLikeAcronymsWorkingDay method, of class TrimesterImpl.
     */
    @Test
    public void testFindByLikeAcronymsWorkingDay() {
    }

    /**
     * Test of findByLikeSpecialityName method, of class TrimesterImpl.
     */
    @Test
    public void testFindByLikeSpecialityName() {
    }

    /**
     * Test of updatePrimaryKey method, of class TrimesterImpl.
     */
    @Test
    public void testUpdatePrimaryKey() {
    }
    
}
