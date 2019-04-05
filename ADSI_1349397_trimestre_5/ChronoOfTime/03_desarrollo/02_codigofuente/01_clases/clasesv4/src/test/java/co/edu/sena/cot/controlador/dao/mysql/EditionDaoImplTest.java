/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.EditionDao;
import co.edu.sena.cot.controlador.factory.mysql.EditionFactory;
import co.edu.sena.cot.modelo.dto.Edition;
import co.edu.sena.cot.modelo.dto.EditionPK;
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
public class EditionDaoImplTest {
    
    private Edition ed;
    private EditionPK edPK;
    
    public EditionDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ed = new Edition();
        ed.setEditionPK(new EditionPK(103, "III-2017"));
        
        edPK = new EditionPK(147, "III-2017");
     
    }
    
    @After
    public void tearDown() {
    }

 @Test
    public void test01Insert() {
        EditionDao dao = EditionFactory.create(Edition.class);
        if (dao.find(ed.getEditionPK()) == null) {
            dao.insert(ed);

        }
        assertEquals(dao.find(ed.getEditionPK()), ed);
    }
    
    @Test
    public void test02Find() {
        EditionDao dao = EditionFactory.create(Edition.class);
        Edition logAuditCon = (Edition) dao.find(ed.getEditionPK());
        assertEquals(logAuditCon, ed);

    }

    @Test
    public void test03UpdatePK() {
        EditionDao dao = EditionFactory.create(Edition.class);
        dao.updatePK(edPK, ed.getEditionPK());
        ed.setEditionPK(edPK);
        assertEquals(dao.find(edPK), ed);

    }
    
     @Test
    public void test04FindAll() {
        EditionDao dao = EditionFactory.create(Edition.class);
        List<Edition> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void test05FindByIdEdition() {
        EditionDao dao = EditionFactory.create(Edition.class);
        List<Edition> lista = dao.findByIdEdition(102);
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeIdEdition method, of class EditionDaoImpl.
     */
    @Test
    public void test06FindByLikeIdEdition() {
        EditionDao dao = EditionFactory.create(Edition.class);
        List<Edition> lista = dao.findByLikeIdEdition("%1%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByIdTrimester method, of class EditionDaoImpl.
     */
    @Test
    public void test07FindByIdTrimester() {
        EditionDao dao = EditionFactory.create(Edition.class);
        List<Edition> lista = dao.findByIdTrimester("III-2017");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeTrimester method, of class EditionDaoImpl.
     */
    @Test
    public void test08FindByLikeTrimester() {
       EditionDao dao = EditionFactory.create(Edition.class);
        List<Edition> lista = dao.findByLikeTrimester("%I%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }
    
    @Test
    public void test09Delete(){
        EditionDao dao = EditionFactory.create(Edition.class);
        ed.setEditionPK(new EditionPK(147, "III-2017"));
        dao.remove(ed);
        assertEquals(dao.find(ed.getEditionPK()), null);
        }
    
}
