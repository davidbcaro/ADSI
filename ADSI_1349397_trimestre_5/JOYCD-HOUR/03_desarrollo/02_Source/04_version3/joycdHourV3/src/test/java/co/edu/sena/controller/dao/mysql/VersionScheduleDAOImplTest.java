/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.VersionScheduleDAO;
import co.edu.sena.controller.factory.VersionScheduleFactory;
import co.edu.sena.model.jpa.entities.VersionSchedule;
import co.edu.sena.model.jpa.entities.VersionSchedulePK;
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
 * @author PCK
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VersionScheduleDAOImplTest {

    private VersionSchedule versionSchedule;
    private VersionSchedulePK versionSchedulepk;

    public VersionScheduleDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        versionSchedule = new VersionSchedule();

        versionSchedule.setStatusVersion(true);
        versionSchedule.setVersionSchedulePK(new VersionSchedulePK(102, "Trimestre 4"));

        versionSchedulepk = new VersionSchedulePK(104, "Trimestre 6");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1insert() {
        System.out.println("Prueba insert de VersionSchedule");
        VersionScheduleDAO dao = VersionScheduleFactory.create(VersionSchedule.class);
        if (dao.find(versionSchedule.getVersionSchedulePK()) == null) {
            dao.insert(versionSchedule);
        }
        assertEquals(dao.find(versionSchedule.getVersionSchedulePK()), versionSchedule);
    }

    @Test
    public void test2find() {
        System.out.println("prueba del find");
        VersionScheduleDAO dao = VersionScheduleFactory.create(VersionSchedule.class);
        VersionSchedule resultconsulta = (VersionSchedule) dao.find(versionSchedule.getVersionSchedulePK());
        assertEquals(resultconsulta, versionSchedule);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de update");
        VersionScheduleDAO dao = VersionScheduleFactory.create(VersionSchedule.class);
        versionSchedule.setStatusVersion(false);
        dao.update(versionSchedule);
        assertEquals(dao.find(versionSchedule.getVersionSchedulePK()), versionSchedule);
    }

    @Test
    public void test4updatePrimaryKey() {
        VersionScheduleDAO dao = VersionScheduleFactory.create(VersionSchedule.class);
        dao.updatePrimaryKey(versionSchedulepk, versionSchedule.getVersionSchedulePK());
        versionSchedule.setVersionSchedulePK(versionSchedulepk);
        assertEquals(dao.find(versionSchedulepk), versionSchedule);
    }

    @Test
    public void test5FindAll() {
        VersionScheduleDAO dao = VersionScheduleFactory.create(VersionSchedule.class);
        List<VersionSchedule> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        System.out.println(lista);
    }


    @Test
    public void test11delete() {
        System.out.println("Prueba del Delete");
        VersionScheduleDAO dao =  VersionScheduleFactory.create(VersionSchedule.class);
        versionSchedule.setVersionSchedulePK(new VersionSchedulePK(102, "Trimestre 6"));
        dao.remove(versionSchedule);
        assertEquals(dao.find(versionSchedule.getVersionSchedulePK()), null);
    }
}
