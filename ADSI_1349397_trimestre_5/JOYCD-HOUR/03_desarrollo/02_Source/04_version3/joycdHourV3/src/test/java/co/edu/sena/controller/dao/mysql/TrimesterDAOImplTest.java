/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.TrimesterDAO;
import co.edu.sena.controller.factory.TrimesterFactory;
import co.edu.sena.model.jpa.entities.Trimester;
import co.edu.sena.model.jpa.entities.TrimesterPK;
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
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrimesterDAOImplTest {

    private Trimester trimester;
    private TrimesterPK trimesterpk;

    public TrimesterDAOImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        trimester = new Trimester();
        trimester.setTrimesterPK(new TrimesterPK("Trimestre 1", "D", "Tecnico"));
        trimesterpk = new TrimesterPK("Trimestre 20","D", "Tecnico");

    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test01Insert() {
        System.out.println("Prueba insert de trimester");
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        if (dao.find(trimester.getTrimesterPK()) == null) {
            dao.insert(trimester);
        }
        assertEquals(dao.find(trimester.getTrimesterPK()), trimester);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de find Trimester");
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        Trimester trimconsulta = (Trimester) dao.find(trimester.getTrimesterPK());
        assertEquals(trimconsulta, trimester);
    }

 
    @Test
    public void test06FindByLikeTrimesterName() {
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeLevelFormation("%T%");
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void test07FindByLikeWorkingDayInitials() {
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeWorkingDayInitials("%D");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test08FindByLikeLevelFormation() {
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeLevelFormation("%T%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test09UpdatePrimaryKey() {
        TrimesterDAO dao = TrimesterFactory.create(Trimester.class);
        dao.updatePrimaryKey(trimesterpk, trimester.getTrimesterPK());
        trimester.setTrimesterPK(trimesterpk);
        assertEquals(dao.find(trimesterpk), trimester);
    }
    
     @Test
    public void test13delete() {
        System.out.println("Prueba del Delete");
         TrimesterDAO dao = TrimesterFactory.create(Trimester.class);   
       trimester.setTrimesterPK(new TrimesterPK("Trimestre 20", "D", "Tecnico"));
        dao.remove(trimester);
        assertEquals(dao.find(trimester.getTrimesterPK()), null);
    }

}
