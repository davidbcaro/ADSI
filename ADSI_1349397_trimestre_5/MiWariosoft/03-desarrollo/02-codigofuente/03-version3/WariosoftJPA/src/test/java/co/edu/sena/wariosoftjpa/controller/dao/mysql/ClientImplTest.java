/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.ClientFactory;
import co.edu.sena.wariosoftjpa.controller.dao.ClientDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Client;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ClientPK;
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
public class ClientImplTest {

    private Client client;
    private ClientPK clientPK;

    public ClientImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        client = new Client();
        client.setClientPK(new ClientPK("12345654", "C.C"));
        client.setFirstName("juan");
        client.setSecondName("david");
        client.setFirstLastname("murcia");
        client.setSecondLastname("misi");

        clientPK = new ClientPK("345345345", "T.I");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        ClientDAO dao = ClientFactory.create(Client.class);
        dao.insert(client);
        Client clientBaseDatos = (Client) dao.find(client.getClientPK());
        assertEquals(clientBaseDatos, client);
    }

    @Test
    public void test2findpk() {
        ClientDAO dao = ClientFactory.create(Client.class);
        Client cs = (Client) dao.find(client.getClientPK());
        assertEquals(cs, client);
    }

    @Test
    public void test3update() {
       
        ClientDAO dao = ClientFactory.create(Client.class);
        client.setFirstName("julian");
        dao.update(client);
        assertEquals(dao.find(client.getClientPK()), client);
    }

    @Test
    public void test3updatePk() {
        ClientDAO dao = ClientFactory.create(Client.class);
        dao.updatePk(clientPK, client.getClientPK());
        client.setClientPK(clientPK);
        assertEquals(dao.find(clientPK), client);

    }

    @Test
    public void test4Remove() {
        ClientDAO dao = ClientFactory.create(Client.class);
        client.setClientPK(clientPK);
        dao.remove(client);
        assertEquals(dao.find(client.getClientPK()), null);

    }

    /**
     * Test of findByDocumentNumber method, of class ClientImpl.
     */
    @Test
    public void test5FindByDocumentNumber() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByDocumentNumber("12345654");
        for (Client client : lista) {
            assertEquals(client.getClientPK().getDocumentNumber(), "12345654");
        }
    }

    /**
     * Test of findByFirstName method, of class ClientImpl.
     */
    @Test
    public void test6FindByFirstName() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByFirstName("juan");
        for (Client client : lista) {
            assertEquals(client.getFirstName(), "juan");
        }
    }

    /**
     * Test of findBySecondName method, of class ClientImpl.
     */
    @Test
    public void test7FindBySecondName() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findBySecondName("david");
        for (Client client : lista) {
            assertEquals(client.getSecondName(), "david");
        }
    }

    /**
     * Test of findByFirstLastName method, of class ClientImpl.
     */
    @Test
    public void test8FindByFirstLastName() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByFirstLastName("murcia");
        for (Client client : lista) {
            assertEquals(client.getFirstLastname(), "murcia");
        }
    }

    /**
     * Test of findBySecondLastName method, of class ClientImpl.
     */
    @Test
    public void test9FindBySecondLastName() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findBySecondLastName("misi");
        for (Client client : lista) {
            assertEquals(client.getSecondLastname(), "misi");
        }
    }

    /**
     * Test of findByIdDocument method, of class ClientImpl.
     */
    @Test
    public void test10FindByIdDocument() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByIdDocument("CC");
        for (Client client : lista) {
            assertEquals(client.getClientPK().getIdDocument(), "CC");
        }
    }

    /**
     * Test of findByLikeDocumentNumber method, of class ClientImpl.
     */
    @Test
    public void test11FindByLikeDocumentNumber() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeDocumentNumber("80013833");
        for (Client client : lista) {
            assertEquals(client.getClientPK().getDocumentNumber(), "80013833");
        }

    }

    /**
     * Test of findByLikeIdDocument method, of class ClientImpl.
     */
    @Test
    public void test12FindByLikeIdDocument() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        ClientDAO dao = ClientFactory.create(Client.class);
        List<Client> lista = dao.findByLikeIdDocument("C.C");
        for (Client client : lista) {
            assertEquals(client.getClientPK().getIdDocument(), "C.C");
        }
    }

    /**
     * Test of updatePk method, of class ClientImpl.
     */
}
