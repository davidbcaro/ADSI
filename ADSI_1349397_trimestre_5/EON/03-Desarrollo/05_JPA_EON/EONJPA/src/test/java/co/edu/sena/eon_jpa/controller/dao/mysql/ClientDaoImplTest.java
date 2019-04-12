package co.edu.sena.eon_jpa.controller.dao.mysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.sena.eon_jpa.controller.dao.ClientDao;
import co.edu.sena.eon_jpa.controller.factory.ClientFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.ClientPK;
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
/**
 *
 * @author Liliana Narvaez
 */
public class ClientDaoImplTest {

    private Client c;
    private Client c2;
    private ClientPK cPK;

    public ClientDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        c = new Client();
        c.setClientPK(new ClientPK("1234", "CC"));
        c.setFirstName("perpra");
        c.setSecondName("que le den");
        c.setSecondLastname("elque dno");
        c.setFirstLastname("erpra");

        c2 = new Client();
        c2.setClientPK(new ClientPK("324", "CC"));
        c2.setFirstName("perpra");
        c2.setSecondName("que le den");
        c2.setSecondLastname("elque dno");
        c2.setFirstLastname("erpra");

        cPK = new ClientPK("12345", "CC");

    }

    @After
    public void tearDown() {

    }

    @Test
    public void test1Insert() {
        System.out.println("Test Insert");
        ClientDao dao = ClientFactory.create(Client.class);
        if (dao.find(c.getClientPK()) == null) {
            dao.insert(c);
        }
        assertEquals(dao.find(c.getClientPK()), c);

    }

    @Test
    public void test2find() {

        System.out.println("prueba de role metodo find por llave primaria");
        ClientDao dao = ClientFactory.create(Client.class);
        Client clientConsulted = (Client) dao.find(c.getClientPK());
        assertEquals(clientConsulted, c);

    }

    @Test
    public void test3update() {
        System.out.println("Prueba de Role metodo update por llave primaria");
        ClientDao dao = ClientFactory.create(Client.class);
        c.setFirstName("pepito");
        dao.update(c);
        assertEquals(dao.find(c.getClientPK()), c);

    }

//     @Test
//    public void test3vUpdatePrimarykey() {
//        ClientDao dao = ClientFactory.create(Client.class);
//        dao.updatePrimaryKey(cPK, c.getClientPK());
//        c.setClientPK(cPK);
//        assertEquals(dao.find(cPK),c);        
//    }
    @Test
    public void test4Delete() {
        System.out.println("prueba de tipo de role metodo delete para la llave");
        ClientDao dao = ClientFactory.create(Client.class);
        c.setClientPK(new ClientPK("12345678", "CC"));
        dao.remove(c);
        assertEquals(dao.find(c.getClientPK()), null);
    }

    @Test
    public void test5FindAll() {
        System.out.println("Prueba de Role metodo findAll");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    @Test
    public void testFindByDocumentNumber() {
        System.out.println("Prueba del metodo findBydocumentnumber del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByDocumentNumber("80013833");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getClientPK().getDocumentNumber(), "80013833");
        }
    }

    @Test
    public void testFindByFirstName() {
        System.out.println("Prueba del metodo findByfirstname del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByFirstName("Hernando");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getFirstName(), "Hernando");
        }
    }

    @Test
    public void testFindBySecondName() {
        System.out.println("Prueba del metodo findBysecndname del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findBysecondName("Enrique");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getSecondName(), "Enrique");
        }
    }

    @Test
    public void testFindByfirstLastname() {
        System.out.println("Prueba del metodo findBysurname del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByFirstLastName("Moreno");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getFirstLastname(), "Moreno");
        }
    }

    @Test
    public void testFindByLikeSecondLastName() {
        System.out.println("Prueba del metodo findBysecondsurname del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeSecondLastName("Moreno");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getSecondLastname(), "Moreno");
        }
    }

    @Test
    public void testFindByIdDocument() {
        System.out.println("Prueba del metodo findByiddocument del dao custome");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByIdDocument("CC");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertEquals(client.getClientPK().getIdDocument(), "CC");
        }
    }

    @Test
    public void testFindByLikeDocumentNumber() {
        System.out.println("Prueba del metodo FindLikedocumentnumber del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeDocumentNumber("1%");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

    @Test
    public void testFindByLikeFirstName() {
        System.out.println("Prueba del metodo FindLikeIdfirst name del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeFirstName("H%");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertTrue(!lista.isEmpty());
        }

    }

    @Test
    public void testFindByLikeFirstLastName() {
        System.out.println("Prueba del metodo FindLikesurname del dao customer");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeFirstLastName("e%");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

    @Test
    public void testFindByLikeIdDocument() {
        System.out.println("Prueba del metodo FindLikeIddocument del dao customer"
                + "");
        ClientDao dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeIdDocument("C%");
        assertTrue(!lista.isEmpty());
        for (Client client : lista) {
            assertTrue(!lista.isEmpty());
        }

    }
}
