package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.CustomerDao;
import co.edu.sena.tidsplanjpa.controller.factory.CustomerFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Customer;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerPK;
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
public class CustomerImplTest {

    private Customer cr;
    private CustomerPK crpk;
    private CustomerPK cr2;

    public CustomerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cr = new Customer();
        cr.setCustomerPK(new CustomerPK("CC", "34545"));
        cr.setFirstName("Michi");
        cr.setSecondName("En");
        cr.setSurname("Su");
        cr.setSecondSurname("Ba");
        cr.setPhoto(null);

        crpk = new CustomerPK();
        crpk.setDocument("CE");
        crpk.setDocumentNumber("2098348923");


    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de  insert");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        if (dao.find(cr.getCustomerPK()) == null) {
            dao.insert(cr);
        }
        assertEquals(dao.find(cr.getCustomerPK()), cr);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de  find");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        Customer cutomerConsulted = (Customer) dao.find(cr.getCustomerPK());
        assertEquals(cutomerConsulted, cr);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de  update");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        cr.setFirstName("micho");
        dao.update(cr);
        assertEquals(dao.find(cr.getCustomerPK()), cr);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de  update por llave primaria");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        int resultado = dao.updatePrimaryKey(crpk, cr.getCustomerPK());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05delete() {
        System.out.println("prueba de Fase de Proyecto metodo delete");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        cr.setCustomerPK(crpk);
        dao.remove(cr);
        assertEquals(dao.find(cr.getCustomerPK()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("prueba de find all");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByDocumentNumber() {
        System.out.println("prueba de  FindByDocumentNumber");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByDocumentNumber("14796314");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
            assertEquals(customer.getCustomerPK().getDocumentNumber(), "14796314");
        }
    }

    @Test
    public void test08FindByLikeDocumentNumber() {
        System.out.println("prueba de  FindByLikeDocumentNumber");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeDocumentNumber("%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test09FindByFirstName() {
        System.out.println("Prueba de Find By");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> lista = dao.findByFirstName("Wilder");
        assertTrue(!lista.isEmpty());
        for (Customer customer : lista) {
            assertEquals(customer.getFirstName(), "Wilder");
        }
    }

    @Test
    public void test10FindByLikeFirstName() {
        System.out.println("prueba de  FindByLikeFirstName");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeFirstName("%i%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test11FindBySecondName() {
        System.out.println("prueba de FindBySecondName");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findBySecondName("Efrain");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            assertEquals(customer.getSecondName(), "Efrain");
        }
    }

    @Test
    public void test12FindByLikeSecondName() {
        System.out.println("prueba de  FindByLikeSecondName");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeSecondName("%n%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test13FindBySurname() {
        System.out.println("prueba de FindBySurname");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findBySurname("Meza");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            assertEquals(customer.getSurname(), "Meza");
        }
    }

    @Test
    public void test14FindByLikeSurname() {
        System.out.println("prueba de  FindByLikeSurname");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeSurname("%e%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test15FindBySecondSurname() {
        System.out.println("prueba de FindBySecondSurname");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findBySecondSurname("Mena");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            assertEquals(customer.getSecondSurname(), "Mena");
        }
    }

    @Test
    public void test16FindByLikeSecondSurname() {
        System.out.println("prueba de  FindByLikeSecondSurname");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeSecondName("%a%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    public void test17FindByDocument() {
        System.out.println("prueba de  FindByDocument");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByDocument("CC");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            assertEquals(customer.getCustomerPK().getDocument(), "CC");
        }
    }

    @Test
    public void test18FindByLikeDocument() {
        System.out.println("prueba de  FindByLikeDocument");
        CustomerDao dao = CustomerFactory.create(Customer.class);
        List<Customer> list = dao.findByLikeDocument("%C%");
        assertFalse(list.isEmpty());
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

}
