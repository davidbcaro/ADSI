/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DisponibilityDao;
import co.edu.sena.tidsplanjpa.controller.factory.DisponibilityFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Disponibility;
import co.edu.sena.tidsplanjpa.model.jpa.entities.DisponibilityPK;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JulianC
 */
public class DisponibilityDaoImplTest {
    
    private Disponibility d;
    private DisponibilityPK dpk;
    
    @Before
    public void setUp() throws ParseException {
        
        d = new Disponibility();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        
        d.setDisponibilityPK(new DisponibilityPK("CC", "80013833", format.parse("06:00:00"), "Lunes", "D"));
        d.setEndHour(format2.parse("05:00:00"));
        
        dpk = new DisponibilityPK();
        dpk.setDocument("CC");
        dpk.setDocumentNumber("59874135");
        dpk.setNameDay("Jueves");
        dpk.setStartHour(format3.parse("21:00:00"));
        dpk.setWorkingDayInitials("D");
    }


    

  

    @Test
    public void test01Insert() {
        System.out.println("Prueba de metodo insert");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        if (dao.find(d.getDisponibilityPK()) == null) {
            dao.insert(d);
        }
        assertEquals(dao.find(d.getDisponibilityPK()), d);
    }
    
    @Test
    public void test02find() {
        System.out.println("Prueba de Find");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        Disponibility di = (Disponibility) dao.find(d.getDisponibilityPK());
        assertEquals(di, d);
    }
    
    @Test
    public void test03Update() throws ParseException {
        System.out.println("Prueba de metodo Update");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        d.setEndHour(format3.parse("14:00:00"));
        dao.update(d);
        assertEquals(dao.find(d.getDisponibilityPK()), d);
    }
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de metodo update por llave primaria");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        int resultado = dao.updatePrimaryKey(dpk, d.getDisponibilityPK());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba de metodo delete");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        d.setDisponibilityPK(dpk);
        dao.remove(d);
        assertEquals(dao.find(d.getDisponibilityPK()), null);
    }
    
    @Test
    public void test06FindAll() {
        System.out.println("prueba de find all");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findAll();
        assertFalse(list.isEmpty());        
    }
    
    @Test
    public void test07FindByDocument() {
        System.out.println("prueba de  FindBy");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByDocument("CC");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getDocument(), "CC");
        }
    }
    
    @Test
    public void test08FindByLikeDocument() {
        System.out.println("prueba de  Find By Like");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByLikeDocument("CC");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getDocument(), "CC");
        }
    }
    
    @Test
    public void test09FindByDocumentNumber() {
        System.out.println("prueba de  Find By Like");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByDocumentNumber("80013833");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getDocumentNumber(), "80013833");
        }
    }
    
    @Test
    public void test10FindByLikeDocumentNumber() {
        System.out.println("prueba de  Find By Like");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByLikeDocumentNumber("80013833");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getDocumentNumber(), "80013833");
        }
    }
    
    @Test
    public void test11FindByNameDay() {
        System.out.println("prueba de  Find By");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByNameDay("Lunes");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getNameDay(), "Lunes");
        }
    }
    
    public void test12FindByLikeNameDay() {
        System.out.println("prueba de  Find By Like");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByNameDay("Lunes");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getNameDay(), "Lunes");
        }
    }
    
    @Test
    public void test13FindByWorkingDayInitials() {
        System.out.println("prueba de  Find By");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByWorkindDayInitials("D");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getWorkingDayInitials(), "D");
        }
    }
    
    @Test
    public void test14FindByLikeWorkingDayInitials() {
        System.out.println("prueba de Find By Like");
        DisponibilityDao dao = DisponibilityFactory.create(Disponibility.class);
        List<Disponibility> list = dao.findByLikeWorkindDayInitials("D");
        assertFalse(list.isEmpty());
        for (Disponibility ds : list) {
            assertEquals(ds.getDisponibilityPK().getWorkingDayInitials(), "D");
        }
    }

}
