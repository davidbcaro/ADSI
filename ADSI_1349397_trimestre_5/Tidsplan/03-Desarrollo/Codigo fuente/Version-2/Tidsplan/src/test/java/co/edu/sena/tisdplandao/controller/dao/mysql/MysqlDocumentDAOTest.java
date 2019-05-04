package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.DocumentDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.DocumentDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlDocumentDAOFactory;
import co.edu.sena.tisdplandao.model.dto.DocumentDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlDocumentDAOTest {

    private DocumentDTO documentDTO;
    private DocumentDTO documentDTO2;
    private DocumentDTO documentDTO3;
    private DocumentDTO documentDTO4;

    @Before
    public void setUp() throws Exception {

        documentDTO = new DocumentDTO();
        documentDTO.setIdDocument("1000363633");
        documentDTO.setTypeDocument("TI");
        documentDTO.setStatus(true);

        documentDTO2 = new DocumentDTO();
        documentDTO2.setIdDocument("1000364392");
        documentDTO2.setTypeDocument("CC");
        documentDTO2.setStatus(false);

        documentDTO3 = new DocumentDTO();
        documentDTO3.setIdDocument("1111");
        documentDTO3.setTypeDocument("PAS");
        documentDTO3.setStatus(true);

        documentDTO4 = new DocumentDTO();
        documentDTO4.setIdDocument("111");
        documentDTO4.setTypeDocument("POS");
        documentDTO4.setStatus(false);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("The Insert");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.insert(documentDTO), 1);
        dao.insert(documentDTO3);
        dao.insert(documentDTO4);

    }

    @Test
    public void test2findPk() {
        System.out.println("The Find Prymary Jey");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        DocumentDTO find = dao.findPk("1000363633");
        assertEquals(find, documentDTO);
    }

    @Test
    public void test3findAll() {
        System.out.println("The Find All");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        List<DocumentDTO> find = (List<DocumentDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }

    @Test
    public void test4update() {
        System.out.println("The Update");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.update(documentDTO2, "1000363633"),1);
    }

    @Test
    public void test5delete() {
        System.out.println("The Delete");
        DocumentDAOFactory factory = new MysqlDocumentDAOFactory();
        DocumentDAO dao = factory.create();
        assertEquals(dao.delete("1000364392"),1);
    }



}