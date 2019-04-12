/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.UserDao;
import co.edu.sena.eon_jpa.controller.factory.UserFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.User;
import co.edu.sena.eon_jpa.model.jpa.entities.UserPK;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 *
 * @author Equipo
 */
public class UserDaoImplTest {
  
    private User u;
    private User u2;
    private UserPK uPK;
    
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
        u = new User();
        u.setUserPK(new UserPK("80013833", "CC"));
        u.setMail("jeacuna522");
        u.setPassword("1234512");
        SimpleDateFormat formatteer = new SimpleDateFormat ("dd-mm-yyyy");
        u.setDateendind(formatteer.parse("11-09-3124"));
        
        uPK = new UserPK("12345", "CC");
       
        
         u2 = new User();
        u2.setUserPK(new UserPK("1234","CC"));
        u2.setMail("jeacuna522");
        u2.setPassword("queleden");
        SimpleDateFormat formattee = new SimpleDateFormat ("dd-mm-yyyy");
        u2.setDateendind(formattee.parse("11-09-3123"));

        
    }
    
    
    
    @After
    public void tearDown() {
        
        
    }
    @Test
    public void test1Insert() {

         UserDao dao = UserFactory.create(User.class);
        dao.insert(u);
        User user = (User) dao.find(u.getUserPK());
        assertEquals(user, u);
    }
     @Test
    public void test2Insert() {

         UserDao dao = UserFactory.create(User.class);
        dao.insert(u2);
        User user = (User) dao.find(u2.getUserPK());
        assertEquals(user, u2);
    }
    
    
     @Test
    public void test2find() {

        System.out.println("prueba de role metodo find por llave primaria");
        UserDao dao = UserFactory.create(User.class);
        User userConsulted = (User) dao.find(u2.getUserPK());
        assertEquals(userConsulted, u2);

    }
    
    @Test
    public void test3update() {
        System.out.println("Prueba de Role metodo update por llave primaria");
        UserDao dao = UserFactory.create(User.class);
        u.setPassword("queleden");
        dao.update(u);
        assertEquals(dao.find(u.getUserPK()), u);
    }
    
// Test Ignorado    
//    @Test
//    public void test3UpdatePrimaryKey() {
//       UserDao dao = UserFactory.create(User.class);
//        dao.updatePrimaryKey(uPK, u2.getUserPK());
//        u2.setUserPK(uPK);
//        assertEquals(dao.find(uPK), u2);
//    
//    }
 
 
    
     @Test
    public void test4Delete() {
        System.out.println("prueba de tipo de role metodo delete para la llave");
        UserDao dao = UserFactory.create(User.class);
        u.getUserPK();
        dao.remove(u);
        assertEquals(dao.find(u.getUserPK()), null);
    }
    
     
  
    @Test
    public void testFindByPassWord() {
        System.out.println("Prueba del metodo findByIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByPassWord("queleden");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertEquals(user.getPassword(), "queleden");
        }    }

    /**
     * Test of findByDocumentNumber method, of class UserDaoImpl.
     */
    @Test
    public void testFindByDocumentNumber() {
       System.out.println("Prueba del metodo findByIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByDocumentNumber("1234");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertEquals(user.getUserPK().getDocumentNumber(), "1234");
        }
    }

    /**
     * Test of findByIdDocument method, of class UserDaoImpl.
     */
    @Test
    public void testFindByIdDocument() {
        System.out.println("Prueba del metodo findByIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByIdDocument("CC");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertEquals(user.getUserPK().getIdDocument(), "CC");
        }
    }
    
    
    @Test
    public void test5FindAll() {
        System.out.println("Prueba de Role metodo findAll");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    /**
     * Test of findByDateEndind method, of class UserDaoImpl.
     */
   // @Test
   // public void testFindByDateEndind() {
   //    System.out.println("Prueba del metodo findByIdRole del dao Role");
   //     UserDao dao = UserFactory.create(User.class);
   //    List<User> lista = dao.findByDateEndind(0000-00-00);
   //     assertTrue(!lista.isEmpty());
   //     for (User user : lista) {
   //         assertEquals(user.getDateEndind(), "0000-00-00");
       
   //     }   
   // }

    /**
     * Test of findByLikeDocumentNumber method, of class UserDaoImpl.
     */
    @Test
    public void testFindByLikeDocumentNumber() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeDocumentNumber("%1234%");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertTrue(!lista.isEmpty());
        }
    }

   //@Test
    //public void testFindByLikeDateEndind() {
      //   System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
        //UserDao dao = UserFactory.create(User.class);
      //  List<User> lista = dao.findByLikeDateEndind("0%");
      //  assertTrue(!lista.isEmpty());
      //  for (User user : lista) {
       //     assertTrue(!lista.isEmpty());
      //  }
   // }

    /**
     * Test of findByLikeMail method, of class UserDaoImpl.
     */
    @Test
    public void testFindByLikeMail() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeMail("j%");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertTrue(!lista.isEmpty());
        }    }

    /**
     * Test of findByLikePassWord method, of class UserDaoImpl.
     */
    @Test
    public void testFindByLikePassWord() {
         System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikePassWord("q%");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertTrue(!lista.isEmpty());
        }    }

    
   
    /**
     * Test of findByLikeIdDocument method, of class UserDaoImpl.
     */
    @Test
    public void testFindByLikeIdDocument() {
       System.out.println("Prueba del metodo FindLikeIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeIdDocument("C%");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertTrue(!lista.isEmpty());
        }
    }
    
     @Test
    public void testFindByMail() {
       System.out.println("Prueba del metodo findByIdRole del dao Role");
        UserDao dao = UserFactory.create(User.class);
        List<User> lista = dao.findByMail("jeacuna522");
        assertTrue(!lista.isEmpty());
        for (User user : lista) {
            assertEquals(user.getMail(), "jeacuna522");
        }
    }

    /**
     * Test of findByLikeDateEnding method, of class UserDaoImpl.
     */
}