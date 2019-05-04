/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.TrimesterDao;
import co.edu.sena.tidsplanjpa.controller.factory.TrimesterFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Trimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterPK;
import java.util.ArrayList;
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
 * @author Miguel
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrimesterDaoImplTest {

    Trimester tr;
    TrimesterPK pk;

    public TrimesterDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tr = new Trimester();
        tr.setTrimesterPK(new TrimesterPK("Trime", "FS", "tecnico"));
        pk = new TrimesterPK("Trom", "D", "tecnologo");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Trimestre metodo insert");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        if (dao.find(tr.getTrimesterPK()) == null) {
            dao.insert(tr);
        }
        assertEquals(dao.find(tr.getTrimesterPK()), tr);

    }

    @Test
    public void test02find() {
        System.out.println("Prueba de Trimestre metodo Find");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        Trimester stateGroupConsulted = (Trimester) dao.find(tr.getTrimesterPK());
        assertEquals(stateGroupConsulted, tr);
    }

    @Test
    public void test03UpdatePrimaryKey() {
        System.out.println("Prueba de Trimestre metodo UpdatePrimaryKey");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        int result = dao.updatePrimaryKey(pk, tr.getTrimesterPK());
        assertEquals(result, 1);
    }

    @Test
    public void test04Delete() {
        System.out.println("Prueba de Trimestre metodo Delete");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        tr.setTrimesterPK(pk);
        dao.remove(tr);
        assertEquals(dao.find(tr.getTrimesterPK()), null);
    }

    @Test
    public void test05FindByNameTrimester() {
        System.out.println("Prueba de Trimestre metodo findByNameTrimester");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> list = dao.findByNameTrimester("trimestre-1");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            assertEquals(trimester.getTrimesterPK().getNameTrimester(), "trimestre-1");
        }
    }

    @Test
    public void test06FindByLikeNameTrimester() {
        System.out.println("Prueba de Trimestre metodo findByNameTrimester");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List< Trimester> list = dao.findByLikeNameTrimester("%tri%");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            System.out.println(trimester);
        }
    }

    @Test
    public void test07FindByWorkingDayInitials() {
        System.out.println("Prueba de Trimestre metodo findByWorkingDayInitials");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> list = dao.findByWorkingDayInitials("D");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            System.out.println(trimester);
            assertEquals(trimester.getTrimesterPK().getWorkingdayInitials(), "D");
        }
    }

    @Test
    public void test08FindByLikeWorkingDayInitials() {
        System.out.println("Prueba de Trimestre metodo findByWorkingDayInitials");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> list = dao.findByLikeWorkingDayInitials("%D%");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            System.out.println(trimester);
        }
    }

    @Test
    public void test09FindByLevelFormation() {
        System.out.println("Prueba de Trimestre metodo findByLevelFormation");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> list = dao.findByLevelFormation("tecnico");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            System.out.println(trimester);
            assertEquals(trimester.getTrimesterPK().getLevelFormation(), "tecnico");

        }

    }

    @Test
    public void test10FindByLikeLevelFormation() {
        System.out.println("Prueba de Trimestre metodo findByLikeLevelFormation");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> list = dao.findByLikeLevelFormation("%te%");
        assertFalse(list.isEmpty());
        for (Trimester trimester : list) {
            System.out.println(trimester);
            
        }
    }
}

  