/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.CustomerDAO;
import co.edu.sena.controller.factory.CustomerFactory;
import co.edu.sena.model.jpa.entities.Customer;
import co.edu.sena.model.jpa.entities.CustomerPK;
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
 * @author Usser
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDAOImplTest {
    private Customer customer;
    private CustomerPK customerpk;
    
    public CustomerDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customer = new Customer();
        customer.setFirstName("pedro");     
        customer.setSecondName("lionel");
        customer.setFirstLastName("gomez");
        customer.setSecondLastName("ramirez");
        customer.setCustomerPK(new CustomerPK("222222222","CC"));
 
        customerpk = new CustomerPK("111111111","CC");
    }
    
     @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de customer");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        if (dao.find(customer.getCustomerPK()) == null) {
            dao.insert(customer);
        }
        assertEquals(dao.find(customer.getCustomerPK()), customer);
    }
    
    @Test
    public void test2Find() {
        System.out.println("Prueba de find customer");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        Customer customerconsulta = (Customer) dao.find(customer.getCustomerPK());
        assertEquals(customerconsulta, customer);
    }
    
    @Test
    public void test3update() {
        System.out.println("Prueba de update de customer");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        customer.setFirstName("juan");
        customer.setSecondName("pedro");
        customer.setFirstLastName("perez");
        customer.setSecondLastName("lopez");
        customer.setPhoto(null);
        dao.update(customer);
        assertEquals(dao.find(customer.getCustomerPK()), customer);
    }
    
    @Test
    public void test4updatePrimaryKey() {
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        dao.updatePrimaryKey(customerpk, customer.getCustomerPK());
        customer.setCustomerPK(customerpk);
        assertEquals(dao.find(customerpk), customer);
    }
    
     @Test
    public void test5FindAll() {
        System.out.println("prueba del metodo findall");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6findByDocumentType() {
        System.out.println("prueba de  metodo findByDocumentType ");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByDocumentType("111111111");
        for (Customer customer : lista) {
            assertEquals(customer.getCustomerPK().getDocumentType(), "111111111");
        }
    }

    @Test
    public void test7findByFirstName() {
        System.out.println("prueba de  metodo findByDocumentType ");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByFirstName("alber");
        for (Customer customer : lista) {
            assertEquals(customer.getFirstName(), "alber");
        }
    }
    
    @Test
    public void test8findBySecondName (){
        System.out.println("prueba de  metodo findBySecondName ");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findBySecondName("wey");
        for (Customer customer : lista) {
            assertEquals(customer.getFirstName(), "wey");
        }
    }
    
    @Test
    public void test9findByFirstLastName (){
        System.out.println("prueba de  metodo findByFirstLastName ");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByFirstLastName("qwe");
        for (Customer customer : lista) {
            assertEquals(customer.getFirstName(), "qwe");
        }
    }
    
    @Test
    public void test10findBySecondLastName (){
        System.out.println("prueba de  metodo BySecondLastName ");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findBySecondLastName("qwer");
        for (Customer customer : lista) {
            assertEquals(customer.getFirstName(), "qwer");
        }
    }
    
    @Test
    public void test11findByLikeDocumentType () {
       CustomerDAO dao = CustomerFactory.create(Customer.class);
       List<Customer> lista = dao.findByLikeDocumentType("%1%");
       assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test12findByLikeFirstName () {
       CustomerDAO dao = CustomerFactory.create(Customer.class);
       List<Customer> lista = dao.findByLikeFirstName("%u%");
       assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test13findByLikeSecondName () {
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByLikeSecondName("%r%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test14findByLikeFirstLastName() {
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByLikeFirstLastName("m%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test15findByLikeSecondLastName() {
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByLikeSecondLastName("m%");
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test16findByLikeIdentificationCardNumber() {
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByLikeIdentificationCardNumber("CC%");
        assertTrue(!lista.isEmpty());
    }    
     @Test
    public void test17Delete() {
        System.out.println("Prueba del Delete");
        CustomerDAO dao = CustomerFactory.create(Customer.class);
        customer.setCustomerPK(new CustomerPK("111111111","CC"));
        dao.remove(customer);
        assertEquals(dao.find(customer.getCustomerPK()), null);
}
}