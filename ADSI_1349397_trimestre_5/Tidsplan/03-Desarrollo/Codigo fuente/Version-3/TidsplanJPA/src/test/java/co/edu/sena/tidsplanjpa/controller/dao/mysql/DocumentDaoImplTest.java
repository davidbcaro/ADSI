/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.DocumentDao;
import co.edu.sena.tidsplanjpa.controller.factory.DocumentFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Document;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentDaoImplTest {

    private Document d;

    public DocumentDaoImplTest() {
    }

    @Before
    public void setUp() {
        d = new Document();
        d.setIdDocument("TT");
        d.setTypeDocument("Tarjeta Trasmilenio");
        d.setStatus(Boolean.TRUE);
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        DocumentDao dao = DocumentFactory.create(Document.class);
        if (dao.find(d.getIdDocument()) == null) {
            dao.insert(d);
        }
        assertEquals(dao.find(d.getIdDocument()), d);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba find");
        DocumentDao dao = DocumentFactory.create(Document.class);
        Document dc = (Document) dao.find(d.getIdDocument());
        assertEquals(dc, d);
    }

    @Test
    public void test03update() {
        System.out.println("Prueba update");
        DocumentDao dao = DocumentFactory.create(Document.class);
        d.setStatus(Boolean.FALSE);
        dao.update(d);
        assertEquals(dao.find(d.getIdDocument()), d);
    }

    @Test
    public void test04UpdatePrimaryKey() { 
        System.out.println("Prueba update primary key");
        DocumentDao dao = DocumentFactory.create(Document.class);
        int result = dao.updatePrimaryKey("TO", d.getIdDocument());
        assertEquals(result, 1);
    }

    @Test
    public void test05FindByLikeIdDocument() {
        System.out.println("Prueba de Find Like");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByLikeIdDocument("%C%");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            System.out.println(doc);

        }

    }

    @Test
    public void test06FindByLikeTypeDocument() {
        System.out.println("Prueba de Find Like");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByLikeTypeDocument("%ide%");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            System.out.println(doc);

        }

    }

    @Test
    public void test07FindByIdDocument() {
        System.out.println("Prueba de Find By");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByIdDocument("CC");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getIdDocument(), "CC");
        }
    }

    @Test
    public void test08FindByTypeDocument() {
        System.out.println("Prueba de Find By");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByTypeDocument("Pasaporte");
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getTypeDocument(), "Pasaporte");
        }
    }

    @Test
    public void test09FindByStatus() {
        System.out.println("Prueba de Find By");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (Document doc : lista) {
            assertEquals(doc.getStatus(), true);
        }
    }

    @Test
    public void test10Delete() {
        System.out.println("Prueba de delete");
        DocumentDao dao = DocumentFactory.create(Document.class);
        d.setIdDocument("TO");
        dao.remove(d);
        assertEquals(dao.find(d.getIdDocument()), null);

    }
    
    @Test
    public void test11FindAll() {
        System.out.println("Prueba de metodo FindAll");
        DocumentDao dao = DocumentFactory.create(Document.class);
        List<Document> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

}
