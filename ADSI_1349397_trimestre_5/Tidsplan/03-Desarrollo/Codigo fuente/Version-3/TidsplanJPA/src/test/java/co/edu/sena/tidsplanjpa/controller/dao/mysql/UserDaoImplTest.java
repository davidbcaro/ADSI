/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.UserDao;
import co.edu.sena.tidsplanjpa.controller.factory.UserFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.User;
import co.edu.sena.tidsplanjpa.model.jpa.entities.UserPK;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author MIHOGAR
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    private User us;
    private UserPK uspk;
    

    public UserDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        us = new User();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        us.setUserPK(new UserPK("CC", "21488946"));
        us.setMail("jmrubiano02@misena.edu.co");
        us.setPassword("3829889292");
        us.setEndDate(format.parse("14-02-2007"));
       
        uspk = new UserPK();
        uspk.setDocument("CC");
        uspk.setDocumentNumber("21488946");

     

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByMail method, of class UserDaoImpl.
     */
    @Test
    public void test01Insert() {
      System.out.println("Prueba de insert");
        UserDao dao = UserFactory.create(User.class);
        if (dao.find(us.getUserPK()) == null) {
            dao.insert(us);
        }
        assertEquals(dao.find(us.getUserPK()), us);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de  find");
        UserDao dao = UserFactory.create(User.class);
        User userConsulted = (User) dao.find(us.getUserPK());
        assertEquals(userConsulted, us);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de  Update");
        UserDao dao = UserFactory.create(User.class);
        us.setPassword("3248892");
        dao.update(us);
        assertEquals(dao.find(us.getUserPK()), us);
    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("prueba de update por llave primaria");
        UserDao dao = UserFactory.create(User.class);
        int resultado = dao.updatePrimaryKey(uspk, us.getUserPK());
        assertEquals(resultado, 1);
    }

    @Test
    public void test05delete() {
        System.out.println("prueba de  delete");
        UserDao dao = UserFactory.create(User.class);
        us.setUserPK(uspk);
        dao.remove(us);
        assertEquals(dao.find(us.getUserPK()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("prueba de  findAll");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    public void test07FindByMail() {
        System.out.println("Prueba de FindByMail");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByMail("jmrubiano02@misena.edu.co");
        for (User user : lista) {
            assertEquals(user.getMail(), "jmrubiano02@misena.edu.co");
        }
    }

    /**
     * Test of findByLikeMail method, of class UserDaoImpl.
     */
    @Test
    public void test08FindByLikeMail() {
        System.out.println("Prueba de  findByLikeMail");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByLikeMail("%o%");
        assertTrue(!list.isEmpty());
        for (User user : list) {
            System.out.println(user);
        }

    }

    /**
     * Test of findByPassword method, of class UserDaoImpl.
     */
    @Test
    public void test09FindByPassword() {
        System.out.println("Prueba de FindByPassword");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByPassword("123456789");
        for (User user : lista) {
            assertEquals(user.getPassword(), "123456789");
        }
    }

    /**
     * Test of findByLikePassword method, of class UserDaoImpl.
     */
    @Test
    public void test10FindByLikePassword() {
        System.out.println("Prueba de  findByLikePassword");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByLikePassword("%4%");
        assertTrue(!list.isEmpty());
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Test of findByEndDate method, of class UserDaoImpl.
     */
    @Test
    public void test11FindByEndDate() throws ParseException{
        System.out.println("Prueba de FindByEndDate");
        UserDao dao = UserFactory.create(User.class);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date  dates = format.parse("12-14-2007");
        List<User> lista = dao.findByEndDate(dates);
        for (User user : lista) {
            assertEquals(user.getEndDate(), "12-14-2007");
        }
    }

    /**
     * Test of findByDocumentNumber method, of class UserDaoImpl.
     */
    @Test
    public void test12FindByDocumentNumber() {
        System.out.println("prueba de  FindByDocumentNumber");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByDocumentNumber("80013833");
        assertFalse(list.isEmpty());
        for (User user : list) {
            assertEquals(user.getUserPK().getDocumentNumber(), "80013833");
        }
       
    }

    /**
     * Test of findByLikeDocumentNumber method, of class UserDaoImpl.
     */
    @Test
    public void test13FindByLikeDocumentNumber() {
        System.out.println("prueba de  FindByLikeDocumentNumber");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByLikeDocumentNumber("%3%");
        assertFalse(list.isEmpty());
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Test of findByDocument method, of class UserDaoImpl.
     */
    @Test
    public void test14FindByDocument() {
        System.out.println("prueba de  FindByDocument");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByDocument("CC");
        assertFalse(list.isEmpty());
        for (User user : list) {
            assertEquals(user.getUserPK().getDocument(), "CC");
        }
    }

    /**
     * Test of findByLikeDocument method, of class UserDaoImpl.
     */
    @Test
    public void test15FindByLikeDocument() {
        System.out.println("prueba de  FindByLikeDocument");
        UserDao dao = UserFactory.create(User.class);
        List<User> list = dao.findByLikeDocument("%C%");
        assertFalse(list.isEmpty());
        for (User user : list) {
            System.out.println(user);
        }
    }

   
}
