/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EmailServerDao;
import co.edu.sena.cot.controlador.dao.LearningResultDao;
import co.edu.sena.cot.controlador.dao.RolDao;
import co.edu.sena.cot.controlador.factory.mysql.EmailServerFactory;
import co.edu.sena.cot.controlador.factory.mysql.LearningResultFactory;
import co.edu.sena.cot.controlador.factory.mysql.RolFactory;
import co.edu.sena.cot.modelo.dto.EmailServer;
import co.edu.sena.cot.modelo.dto.LearningResult;
import co.edu.sena.cot.modelo.dto.Rol;
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
 * @author Natsumi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RolDaoImplTest {

    private Rol ro;

    public RolDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ro = new Rol();
        ro.setIdRol("1257");
        ro.setDescription("Ejemplo");
        ro.setState(true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdRol method, of class RolDaoImpl.
     */
    public void test01Insert() {
        RolDao dao = RolFactory.create(Rol.class);
        if (dao.find(ro.getIdRol()) == null) {
            dao.insert(ro);
        }
        assertEquals(dao.find(ro.getIdRol()), ro);
    }
//
//    @Test
//    public void test02Find() {
//        RolDao dao = RolFactory.create(Rol.class);
//        Rol lista = (Rol) dao.find(ro.getIdRol());
//        assertEquals(lista, ro);
//
//    }

    @Test
    public void test03Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        RolDao dao = RolFactory.create(Rol.class);
        ro.setDescription("Update superado");
        ro.setState(false);
        dao.update(ro);
        assertEquals(dao.find(ro.getIdRol()), ro);
    }

    @Test
    public void test17Delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        RolDao dao = RolFactory.create(Rol.class); 
        ro.setIdRol("9876");
        dao.remove(ro);
        assertEquals(dao.find(ro.getIdRol()), null);
    }

    @Test
    public void test04FindByIdRol() {
        RolDao dao = RolFactory.create(Rol.class);
        List<Rol> lista = dao.findByIdRol("1257");
        assertTrue(!lista.isEmpty());
        for (Rol lear : lista) {
            assertEquals(ro.getIdRol(), "1257");
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByDescription method, of class RolDaoImpl.
     */
    @Test
    public void test05FindByDescription() {
        RolDao dao = RolFactory.create(Rol.class);
        List<Rol> lista = dao.findByDescription("Crea los horarios");
        assertTrue(!lista.isEmpty());
        for (Rol lear : lista) {
            assertEquals(lear.getDescription(), "Crea los horarios");
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByState method, of class RolDaoImpl.
     */
    @Test
    public void test06FindByState() {
        RolDao dao = RolFactory.create(Rol.class);
        List<Rol> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Rol lear : lista) {
            assertEquals(ro.getState(), true);
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByLikeIdRol method, of class RolDaoImpl.
     */
    @Test
    public void test07FindByLikeIdRol() {
        System.out.println("lassssss");
        RolDao dao = RolFactory.create(Rol.class);
        List<Rol> lista = dao.findByLikeIdRol("%A%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeDescription method, of class RolDaoImpl.
     */
    @Test
    public void test08FindByLikeDescription() {
        System.out.println("lassssss");
        RolDao dao = RolFactory.create(Rol.class);
        List<Rol> lista = dao.findByLikeDescription("%E%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of updatePK method, of class RolDaoImpl.
     */
    @Test
    public void test09UpdatePK() {
        RolDao dao = RolFactory.create(Rol.class);
        ro.setIdRol("1257");
        int resultado = dao.updatePK("9876", ro.getIdRol());
        assertEquals(resultado, 1);
    }

}
