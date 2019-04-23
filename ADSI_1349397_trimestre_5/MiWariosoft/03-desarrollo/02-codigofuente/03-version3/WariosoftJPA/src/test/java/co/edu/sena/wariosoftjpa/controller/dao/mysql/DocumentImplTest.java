/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.DocumentFactory;
import co.edu.sena.wariosoftjpa.controller.dao.DocumentDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Document;
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
 * @author WINDOWS 8
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentImplTest {
    private Document document;
    public DocumentImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        document = new Document();
        document.setIdDocument("CC");
        document.setName("cedula ");
        document.setState(Boolean.TRUE); 
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByIdDocument method, of class DocumentImpl.
     */
    @Test
    public void test1Insert() {

        System.out.println("prueba de documento metodo insert");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        if (dao.find(document.getIdDocument()) == null) {
            dao.insert(document);
        }
        assertEquals(dao.find(document.getIdDocument()), document);
    }
    
    
    
    
    @Test
    public void test2update() {
        System.out.println("Prueba de documento metodo update por llave primaria");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        document.setState(Boolean.FALSE);
        dao.update(document);
        assertEquals(dao.find(document.getIdDocument()), document);
        
        

    
}
 @Test
    public void test3vUpdatePk() {
        DocumentDAO dao = DocumentFactory.create(Document.class);
        int resultado = dao.updatePk("Otra", document.getIdDocument());
        assertEquals(resultado, 1);
    }
    
@Test
    public void test4Delete() {
        System.out.println("prueba de tipo de Documento metodo delete para la llave");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        document.setIdDocument("Otra");
        dao.remove(document);
        assertEquals(dao.find(document.getIdDocument()), null);
    }

 @Test
    public void test5FindAll() {
        System.out.println("Prueba de Documento metodo findAll");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    
     @Test
    public void test6findByIdDocument() {
        System.out.println("Prueba del metodo findByIdDocument del dao documento");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByIdDocument("C.C");
        assertTrue(!lista.isEmpty());
        for (Document document : lista) {
            assertEquals(document.getIdDocument(), "C.C");
        }
    }
    @Test
    public void test7findByName() {
       System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         DocumentDAO dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByName("cedula");
        for (Document document : lista) {
            assertEquals(document.getName(), "cedula");
        }
    }

 @Test
    public void test8findByState() {
        System.out.println("Prueba del metodo findByState del dao document");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (Document document : lista) {
            assertEquals(document.getState(), true);
        }
    }
    
       @Test
    public void test9FindLikeIdDocument() {
        System.out.println("Prueba del metodo FindLikeIdDocument del dao Documento");
        DocumentDAO dao = DocumentFactory.create(Document.class);
        List<Document> lista = dao.findByLikeIdDocument("P");
        assertTrue(!lista.isEmpty());
        for (Document document : lista) {
            assertTrue(!lista.isEmpty());
        }

    }
   
    }
    
    

