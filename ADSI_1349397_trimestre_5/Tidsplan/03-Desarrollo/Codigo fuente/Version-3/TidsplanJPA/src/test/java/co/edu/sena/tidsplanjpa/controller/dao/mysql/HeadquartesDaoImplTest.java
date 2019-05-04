package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.HeadquartesDao;
import co.edu.sena.tidsplanjpa.controller.factory.HeadquartesFactoy;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Headquartes;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadquartesDaoImplTest {

    private Headquartes hq;

    @Before
    public void setUp() throws Exception {

        hq = new Headquartes();
        hq.setNameHeadquartes("Nuevo");
        hq.setAddress("Ca");
        hq.setStatus(true);
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        if (dao.find(hq.getNameHeadquartes()) == null) {
            dao.insert(hq);

        }
        assertEquals(dao.find(hq.getNameHeadquartes()), hq);
    }
    
    @Test
    public void test02Find (){
        System.out.println("Prueba de find");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        Headquartes h = (Headquartes) dao.find(hq.getNameHeadquartes());
        assertEquals(hq, h);
    }
    
    @Test
    public void test03update() {
        System.out.println("Prueba update");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        hq.setNameHeadquartes("Nueva Sede");
        hq.setAddress("Calle 66");
        hq.setStatus(Boolean.TRUE);
        dao.update(hq);
        assertEquals(dao.find(hq.getNameHeadquartes()), hq);
    }
    
    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba update primary key");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        int result = dao.updatePrimaryKey("Nueva I", hq.getNameHeadquartes());
        assertEquals(result, 1);
    }
    
    @Test
    public void test05FindByNameHeadquares() {
        System.out.println("Prueba de Find By");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> lista = dao.findByNameHeadquares("Nueva Sede");
        assertTrue(!lista.isEmpty());
        for (Headquartes hc : lista) {
            assertEquals(hc.getNameHeadquartes(), "Nueva Sede");
        }
    }
    
    @Test
    public void test06FindByLikeNameHeadquartes (){
        System.out.println("Prueba find like heardquartes");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> lista = dao.findByLikeNameHeadquares("%");
        assertTrue(!lista.isEmpty());
        for (Headquartes hc : lista) {
            System.out.println(hc);

        }
    }
    
    @Test
    public void test07FindByAddress() {
        System.out.println("Prueba de Find By");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> lista = dao.findByAddress("Calle 66");
        assertTrue(!lista.isEmpty());
        for (Headquartes hc : lista) {
            assertEquals(hc.getAddress(), "Calle 66");
        }
    }
    
    @Test
    public void test08FindByLikeAddress (){
        System.out.println("Prueba find like address");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> lista = dao.findByLikeAddress("%");
        assertTrue(!lista.isEmpty());
        for (Headquartes hc : lista) {
            System.out.println(hc);

        }
    }
    
    @Test
    public void test09FindByStatus() {
        System.out.println("Prueba de Find By");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (Headquartes hc : lista) {
            assertEquals(hc.getStatus(), true);
        }
    }
    
    @Test
    public void test10Delete() {
        System.out.println("Prueba de delete");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        hq.setNameHeadquartes("Nueva I");
        dao.remove(hq);
        assertEquals(dao.find(hq.getNameHeadquartes()), null);

    }
    
    @Test
    public void test11FindAll() {
        System.out.println("Prueba de metodo FindAll");
        HeadquartesDao dao = HeadquartesFactoy.create(Headquartes.class);
        List<Headquartes> list = dao.findAll();
        assertFalse(list.isEmpty());
    }
}