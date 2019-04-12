/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.modelo.dto.DocumentDTO;
import co.edu.sena.eondao.controller.dao.DocumentDAO;
import co.edu.sena.eondao.controller.factory.DocumentDAOFactory;
import co.edu.sena.eondao.controller.factory.mysql.MysqlDocumentDAOFactory;


import java.util.List;
import org.junit.After;
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
public class MysqlDocumentDAOTest {

    private DocumentDTO documento;
    private DocumentDTO documento2;

    public MysqlDocumentDAOTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        documento = new DocumentDTO();
        documento.setIdDocumento("CC2");
        documento.setName("Cedula de ciudadania3");
        documento.setStatus(Boolean.TRUE);

        documento2 = new DocumentDTO();
        documento2.setIdDocumento("CC3");
        documento2.setName("Cedula de ciudadania2");
        documento2.setStatus(Boolean.TRUE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        System.out.println("Insert");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.insert(documento),1);
    }

    @Test
    public void test2FindPk() {
        System.out.println("FindPk");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        DocumentDTO resultado = dao.findPk("CC2");
        assertEquals(resultado, documento);
    }

    @Test
    public void test3Update() {
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.update(documento2, "CC2"),1);
    }

    @Test
    public void test4Delete() {
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.delete("CC3"), 1);
    }

    @Test
    public void test5FindAll() {
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        List<DocumentDTO> lista = (List<DocumentDTO>) dao.findAll();
        assertTrue(!lista.isEmpty());
    }

}
