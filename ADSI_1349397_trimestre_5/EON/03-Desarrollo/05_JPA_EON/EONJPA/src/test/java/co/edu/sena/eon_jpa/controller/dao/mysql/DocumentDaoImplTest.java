/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.DocumentDao;
import co.edu.sena.eon_jpa.controller.factory.DocumentFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Document;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentDaoImplTest {

    Document d;
    Document d2;

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
        d = new Document();
        d.setIdDocument("nuevo cc");
        d.setName("selome ");
        d.setStatus(Boolean.TRUE);

        d2 = new Document();
        d2.setIdDocument("222131");
        d2.setName("ti");
        d2.setStatus(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void test1Insert() {
//        System.out.println("prueba de tipo de documento metodo insert");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        if (dao.find(d.getIdDocument()) == null) {
//            dao.insert(d);
//        }
//        assertEquals(dao.find(d.getIdDocument()), d);
//    }
//
//    @Test
//    public void test2find() {
//        System.out.println("prueba de tipo de documento metodo find por llave primaria");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        Document idDocumentconsultado = (Document) dao.find(d.getIdDocument());
//        assertEquals(idDocumentconsultado, d);
//    }
//
//    @Test
//    public void test3update() {
//        System.out.println("prueba de tipo de documento metodo update po llave primaria");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        d.setName("Prueba");
//        d.setStatus(true);
//        dao.update(d);
//        assertEquals(dao.find(d.getIdDocument()), d);
//    }
//    
//    @Test
//    public void test3vUpdatePrimaryKey() {
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        int resultado= dao.updatePrimaryKey("Update cc", d.getIdDocument());
//        assertEquals(resultado, 1);
//    }
//
//    
//    @Test
//    public void test4Remove() {
//        System.out.println("prueba de tipo de documento metodo delete para la llave");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        d.setIdDocument("Update cc");
//        dao.remove(d);
//        assertEquals(dao.find(d.getIdDocument()), null);
//
//    }
//   
//    @Test
//    public void test5FindAll() {
//        System.out.println("prueba metodo findall");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findAll();
//        assertTrue(!lista.isEmpty());
//    }
//
//    @Test
//    public void test6FindBylikeidDocument() {
//        System.out.println("prueba del metodo findDescripcion del dao ");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findBylikeidDocument("DN%");
//        assertTrue(!lista.isEmpty());
//    }
//
//    @Test
//    public void test7FindBylikename() {
//        System.out.println("prueba del metodo findDescripcion del dao ");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findBylikename("Ced%");
//        assertTrue(!lista.isEmpty());
//
//    }
//
//    @Test
//    public void test8FindBystatus() {
//
//        System.out.println("prueba de metodo findDescripcion del dao");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findBystatus(true);
//        for (Document d : lista) {
//            assertEquals(d.getStatus(), true);
//        }
//    }
//
//    @Test
//    public void test9FindByidDocument() {
//     System.out.println("prueba de metodo findDescripcion del dao");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findByidDocument("Lider del Programa");
//        
//        for (Document d : lista) {
//            assertEquals(d.getIdDocument(), "Lider del Programa");
//        }
//    }
//
//    @Test
//    public void test10FindByname() {
//        System.out.println("prueba de metodo findDescripcion del dao");
//        DocumentDao dao = DocumentFactory.create(Document.class);
//        List<Document> lista = dao.findBylikename("Cedula de Ciudadania");
//        for (Document d : lista) {
//            assertEquals(d.getName(), "Cedula de Ciudadania");
//        }
//    }
//
//    
//        
        
        
    
     


}
