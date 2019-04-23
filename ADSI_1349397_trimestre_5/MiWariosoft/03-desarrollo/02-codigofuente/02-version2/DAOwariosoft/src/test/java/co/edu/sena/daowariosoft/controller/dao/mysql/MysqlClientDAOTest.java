/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.ClientDAO;
import co.edu.sena.daowariosoft.controller.factory.ClientDAOFactory;
import co.edu.sena.daowariosoft.controller.factory.mysql.MysqlClientDAOFactory;
import co.edu.sena.daowariosoft.model.dto.ClientDTO;
import co.edu.sena.daowariosoft.model.dto.ClientPkDTO;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Brayan
 */
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlClientDAOTest {
 
        private ClientDTO client;
        private ClientDTO client2;
        private ClientPkDTO llave;
        private ClientPkDTO llave2;

        @Before
        public void setUp() throws Exception {
            client = new ClientDTO();
            client.setDocumentNumber("123");
            client.setFirstName("Carlos");
            client.setSecondName("Jose");
            client.setFirstLastname("Fino");
            client.setSecondLastname("Fino");
            client.setIdDocument("ap");

            client2 = new ClientDTO();
            client2.setDocumentNumber("123");
            client2.setFirstName("Santiago");
            client2.setSecondName("pepe");
            client2.setFirstLastname("Romero");
            client2.setSecondLastname("Angulo");
            client2.setIdDocument("ap");

            llave = new ClientPkDTO();
            llave.setDocumentNumber("123");
            llave.setIdDocument("ap");

            llave2 = new ClientPkDTO();
            llave2.setDocumentNumber("123");
            llave2.setIdDocument("ap");

        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void testInsert() {
        System.out.println("prueba del insert de clienteDAO");
        ClientDAOFactory factory = new MysqlClientDAOFactory();
        ClientDAO dao = factory.create();
        assertEquals(dao.insert(client), 1);

        }

        @Test
        public void testFindPk() {
            System.out.println("prueba del búsqueda llave primaria de clienteDAo");
            ClientDAOFactory factory = new MysqlClientDAOFactory();
            ClientDAO dao = factory.create();
            ClientDTO consulta = dao.findPk(llave);
            assertEquals(consulta, client);
        }

        @Test
        public void testUpdate() {
        System.out.println("update");
        ClientDAOFactory factory = new MysqlClientDAOFactory();
        ClientDAO dao = factory.create();
        assertEquals(dao.update(client2,llave),1);
        }

        @Test
        public void testDelete() {
            System.out.println("prueba del delete de clienteDAo");
            ClientDAOFactory factory = new MysqlClientDAOFactory();
            ClientDAO dao = factory.create();
            assertEquals(dao.delete(client), 1);
        }

        @Test
        public void test5FindAll() {
            System.out.println("prueba del select * de clienteDAo");
            ClientDAOFactory factory = new MysqlClientDAOFactory();
            ClientDAO dao = factory.create();
            List<ClientDTO> consulta = (List<ClientDTO>) dao.findAll();
            assertTrue(!consulta.isEmpty());
        }

    }

   
 
   

