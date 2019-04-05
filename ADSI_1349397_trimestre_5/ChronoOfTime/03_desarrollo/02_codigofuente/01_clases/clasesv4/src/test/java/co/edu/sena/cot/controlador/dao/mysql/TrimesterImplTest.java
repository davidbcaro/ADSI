/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterDao;
import co.edu.sena.cot.controlador.factory.mysql.TrimesterFactory;
import co.edu.sena.cot.modelo.dto.Trimester;
import co.edu.sena.cot.modelo.dto.TrimesterPK;
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
 * @author Jorge
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrimesterImplTest {
    
    private  Trimester tri;
    private TrimesterPK triPK;
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
        
        tri = new Trimester();
        tri.setTrimesterPK(new TrimesterPK(9, "D", "Tecnico"));
        
        
        triPK = new TrimesterPK(10, "M", "Tecnologo");
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void test01Insert(){
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        if (dao.find(tri.getTrimesterPK()) == null) {
            dao.insert(tri);
        }
        assertEquals(dao.find(tri.getTrimesterPK()), tri);
    
    }
    
    @Test
    public void test02Find() {
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        Trimester logAuditCon = (Trimester) dao.find(tri.getTrimesterPK());
        assertEquals(logAuditCon, tri);

    }
    
    @Test
    public void test03UpdatePK() {
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        dao.updatePrimaryKey(triPK, tri.getTrimesterPK());
        tri.setTrimesterPK(triPK);
        assertEquals(dao.find(triPK), tri);

    }

    @Test
    public void test04FindAll() {
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test05FindByNumber() {
       TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByNumber(10);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByInitials method, of class TrimesterImpl.
     */
    @Test
    public void test06FindByInitials() {
         TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByInitials("M");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByCode method, of class TrimesterImpl.
     */
    @Test
    public void test07FindByCode() {
       TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByCode("Tecnologo");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeNumber method, of class TrimesterImpl.
     */
    @Test
    public void test08FindByLikeNumber() {
      System.out.println("lassssss");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeNumber("%1%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeInitials method, of class TrimesterImpl.
     */
    @Test
    public void test09FindByLikeInitials() {
        System.out.println("lassssss");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeInitials("%M%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeCode method, of class TrimesterImpl.
     */
    @Test
    public void test10FindByLikeCode() {
            System.out.println("lassssss");
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        List<Trimester> lista = dao.findByLikeCode("%T%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of updatePrimaryKey method, of class TrimesterImpl.
     */
   @Test
        public void test11Delete(){
        TrimesterDao dao = TrimesterFactory.create(Trimester.class);
        tri.setTrimesterPK(new TrimesterPK(10, "M", "Tecnologo"));
        dao.remove(tri);
        assertEquals(dao.find(tri.getTrimesterPK()), null);
        }

    
}
