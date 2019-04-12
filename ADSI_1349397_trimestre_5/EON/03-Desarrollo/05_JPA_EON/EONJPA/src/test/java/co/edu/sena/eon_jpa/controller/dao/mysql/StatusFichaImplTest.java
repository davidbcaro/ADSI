/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.StatusFichaDao;
import co.edu.sena.eon_jpa.controller.factory.StatusFichaFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
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
 * @author SOPORTE
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatusFichaImplTest {

    private StatusFicha sf;

    public StatusFichaImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sf = new StatusFicha();
        sf.setNameState("dfghjk");
        sf.setState(Boolean.TRUE);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test1Insert() {
        System.out.println("prueba del insert del statusficha");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        if (dao.find(sf.getNameState()) == null) {
            dao.insert(sf);
        }
        assertEquals(dao.find(sf.getNameState()), sf);
    }

    @Test
    public void test2Find() {
        System.out.println("prueba find por llave primaria de status ficha");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        StatusFicha statusFichaConsultado = (StatusFicha) dao.find(sf.getNameState());
        assertEquals(statusFichaConsultado, sf);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        sf.setState(Boolean.FALSE);
        dao.update(sf);
        assertEquals(dao.find(sf.getNameState()), sf);
    }

    @Test
    public void test3vUpdate() {
        System.out.println("prueba de update de la  llave primaia de status ficha");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        int resultado = dao.updatePrimaryKey("dkdkdk", sf.getNameState());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4Delete() {
        System.out.println("prueba de delete de la llave primaria de status ficha");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        sf.setNameState("dkdkdk");
        dao.remove(sf);
        assertEquals(dao.find(sf.getNameState()), null);
    }

    @Test
    public void test5findByNameState() {
        System.out.println("prueba del metodo findByNameState del dao de status ficha");
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        List<StatusFicha> lista = dao.findByNameState("Aplazado");
        for (StatusFicha stateFicha : lista) {
            assertEquals(stateFicha.getNameState(), "Aplazado");
        }
    }

//    @Test
//    public void test5findByState() {
//        System.out.println("prueba del metodo findByState del dao de status ficha");
//        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
//        List<StatusFicha> lista = dao.findByState(true);
//        for (StatusFicha stateFicha : lista) {
//            assertEquals(stateFicha.getState(), true);
//        }
//    }

    @Test
    public void test5findByLikeNameState() {
        StatusFichaDao dao = StatusFichaFactory.create(StatusFicha.class);
        List<StatusFicha> lista = dao.findByLikeNameState("a%");
        assertTrue(!lista.isEmpty());
    }

}
