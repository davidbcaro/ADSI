/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LinkUpDao;
import co.edu.sena.cot.controlador.dao.LogAuditDao;
import co.edu.sena.cot.controlador.dao.ProjectDao;
import co.edu.sena.cot.controlador.dao.SpecialityDao;
import co.edu.sena.cot.controlador.factory.mysql.LinkUpFactory;
import co.edu.sena.cot.controlador.factory.mysql.LogAuditFactory;
import co.edu.sena.cot.controlador.factory.mysql.ProjectFactory;
import co.edu.sena.cot.controlador.factory.mysql.SpecialityFactory;
import co.edu.sena.cot.modelo.dto.LinkUp;
import co.edu.sena.cot.modelo.dto.LogAudit;
import co.edu.sena.cot.modelo.dto.Project;
import co.edu.sena.cot.modelo.dto.Speciality;
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

public class LinkUpDaoImplTest {

    LinkUp lp;

    public LinkUpDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lp = new LinkUp();
        lp.setTypeLink("Medioo Tempo");
        lp.setHours(25);
        lp.setState(true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByTypeLink method, of class LinkUpDaoImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        if (dao.find(lp.getTypeLink()) == null) {
            dao.insert(lp);
        }
        assertEquals(dao.find(lp.getTypeLink()), lp);
    }

    @Test
    public void test02Find() {
        System.out.println("prueba del nombre metodo find por llave primaria");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        LinkUp nameConsultado = (LinkUp) dao.find(lp.getTypeLink());
        assertEquals(nameConsultado, lp);

    }

    @Test
    public void test03update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        lp.setState(false);
        dao.update(lp);
        assertEquals(dao.find(lp.getTypeLink()), lp);
    }

    @Test
    public void test10Deleate() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        lp.setTypeLink("Mediooo Tempo");
        dao.remove(lp);
        assertEquals(dao.find(lp.getTypeLink()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        List<LinkUp> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test04FindByTypeLink() {
        System.out.println("las2");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        List<LinkUp> lista = dao.findByTypeLink("Medio Tiempo");
        assertTrue(!lista.isEmpty());
        for (LinkUp loga : lista) {
            assertEquals(loga.getTypeLink(), "Medio Tiempo");
        }
        System.out.println("estados " + lista);
    }

    /**
     * Test of findByHours method, of class LinkUpDaoImpl.
     */
    @Test
    public void test05FindByHours() {
        System.out.println("las2");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        List<LinkUp> lista = dao.findByHours(8);
        assertTrue(!lista.isEmpty());
        for (LinkUp loga : lista) {
            assertEquals(loga.getHours(), 8);
        }
        System.out.println("estados " + lista);
    }

    /**
     * Test of findByState method, of class LinkUpDaoImpl.
     */
    @Test
    public void test06FindByState() {
        System.out.println("las");
        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        List<LinkUp> lista = dao.findByState(false);
        for (LinkUp lp : lista) {
            assertEquals(lp.getState(), false);
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of findByLikeTypeLink method, of class LinkUpDaoImpl.
     */
    @Test
    public void test07FindByLikeTypeLink() {
        System.out.println("lassssss");
        LinkUpDao dao = LinkUpFactory.create(Project.class);
        List<LinkUp> lista = dao.findByLikeTypeLink("%Me%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeHours method, of class LinkUpDaoImpl.
     */
    

    /**
     * Test of updatePrimaryKey method, of class LinkUpDaoImpl.
     */
    @Test
    public void test09UpdatePrimaryKey() {

        LinkUpDao dao = LinkUpFactory.create(LinkUp.class);
        lp.setTypeLink("Medioo Tempo");
        int resultado = dao.updatePK("Mediooo Tempo", lp.getTypeLink());
        assertEquals(resultado, 1);
    }
}
