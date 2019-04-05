/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.DocumentDao;
import co.edu.sena.cot.controlador.dao.RolDao;
import co.edu.sena.cot.controlador.factory.mysql.DocumentFactory;
import co.edu.sena.cot.controlador.factory.mysql.RolFactory;
import co.edu.sena.cot.modelo.dto.Document;
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
public class DocumentDaoImplTest {

    private Document doc;

    public DocumentDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        doc = new Document();
        doc.setDocument("CT");
        doc.setName("Cedula Tradicional");
        doc.setState(true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByDocument method, of class DocumentDaoImpl.
     */
    @Test
    public void test01Insert() {
        DocumentDao dao = DocumentFactory.create(Document.class);
        if (dao.find(doc.getDocument()) == null) {
            dao.insert(doc);
        }
        assertEquals(dao.find(doc.getDocument()), doc);
    }

    @Test
    public void test02Find() {
        DocumentDao dao = DocumentFactory.create(Document.class);
        Document lista = (Document) dao.find(doc.getDocument());
        assertEquals(lista, doc);

    }

    @Test
    public void test03Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        DocumentDao dao = DocumentFactory.create(Document.class);
        doc.setName("Orale");
        doc.setState(false);
        dao.update(doc);
        assertEquals(dao.find(doc.getDocument()), doc);
    }

    @Test
    public void test17Delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        DocumentDao dao = DocumentFactory.create(Document.class);
        doc.setDocument("TT");
        dao.remove(doc);
        assertEquals(dao.find(doc.getDocument()), null);
    }

    @Test
    public void test04FindByDocument() {
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByDocument("CC");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getDocument(), "CC");
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByDescription method, of class RolDaoImpl.
     */
    @Test
    public void test05FindByName() {
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByName("Cedula de ciudadania");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getName(), "Cedula de ciudadania");
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByState method, of class RolDaoImpl.
     */
    @Test
    public void test06FindByState() {
       DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByState(false);
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getState(), false);
        }
        System.out.println("names " + lista);
    }

    /**
     * Test of findByLikeIdRol method, of class RolDaoImpl.
     */
    @Test
    public void test07FindByLikeIdRol() {
        System.out.println("lassssss");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByLikeDocument("%C%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of findByLikeDescription method, of class RolDaoImpl.
     */
    @Test
    public void test08FindByLikeDescription() {
       System.out.println("lassssss");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByLikeName("%e%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan " + lista);
    }

    /**
     * Test of updatePK method, of class RolDaoImpl.
     */
    @Test
    public void test09UpdatePK() {
        DocumentDao dao = DocumentFactory.create(Document.class);
        doc.setDocument("CT");
        int resultado = dao.updatePK("TT", doc.getDocument());
        assertEquals(resultado, 1);
    }
}
