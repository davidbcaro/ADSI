package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.CustomerDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.CustomerDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlCustomerDAOFactory;
import co.edu.sena.tisdplandao.model.dto.CustomerDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.CustomerPkDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MysqlCustomerDAOTest {

    private CustomerDTO customerDTO;
    private CustomerDTO customerDTO2;
    private CustomerPkDTO key;
    private CustomerPkDTO key2;

    @Before
    public void setUp() throws Exception {

        customerDTO = new CustomerDTO();
        customerDTO.setDocument("PAS");
        customerDTO.setDocumentNumber("1111");
        customerDTO.setFirtsName("Eeee");
        customerDTO.setSecondName("Pa");
        customerDTO.setSurname("Pe");
        customerDTO.setSecondSurname("Ter");
        customerDTO.setPhoto(null);

        customerDTO2 = new CustomerDTO();
        customerDTO2.setDocument("POS");
        customerDTO2.setDocumentNumber("111");
        customerDTO2.setFirtsName("Se");
        customerDTO2.setSecondName("Gu");
        customerDTO2.setSurname("Nd");
        customerDTO2.setSecondSurname("O");
        customerDTO2.setPhoto(null);

        key = new CustomerPkDTO();
        key.setDocument("PAS");
        key.setDocumentNumber("12345");

        key2 = new CustomerPkDTO();
        key2.setDocument("POS");
        key2.setDocumentNumber("54321");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("The Insert");
        CustomerDAOFactory factory = new MysqlCustomerDAOFactory();
        CustomerDAO dao = factory.create();
        assertEquals(dao.insert(customerDTO), 1);
    }

    @Test
    public void test2findPk() {
        System.out.println("The Find Primary Key");
        CustomerDAOFactory factory = new MysqlCustomerDAOFactory();
        CustomerDAO dao = factory.create();
        CustomerDTO find = dao.findPk(key);
        assertEquals(find, customerDTO);
    }

    @Test
    public void test3findAll() {
        System.out.println("The Find All");
        CustomerDAOFactory factory = new MysqlCustomerDAOFactory();
        CustomerDAO dao = factory.create();
        List<CustomerDTO> find = (List<CustomerDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }

    @Test
    public void test4update() {
        System.out.println("The Update");
        CustomerDAOFactory factory = new MysqlCustomerDAOFactory();
        CustomerDAO dao = factory.create();
        assertEquals(dao.update(customerDTO2, key),1);
    }

    @Test
    public void test5delete() {
        System.out.println("The Delete");
        CustomerDAOFactory factory = new MysqlCustomerDAOFactory();
        CustomerDAO dao = factory.create();
        assertEquals(dao.delete(key2),1);
    }


}