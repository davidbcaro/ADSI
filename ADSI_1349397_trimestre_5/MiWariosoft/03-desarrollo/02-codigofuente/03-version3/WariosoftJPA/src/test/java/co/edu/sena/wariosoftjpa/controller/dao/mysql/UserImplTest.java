/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.UserFactory;
import co.edu.sena.wariosoftjpa.controller.dao.UserDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.User;
import co.edu.sena.wariosoftjpa.model.jpa.entities.UserPK;
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
 * @author WINDOWS 8
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserImplTest {
     private User user;
    private UserPK userPK;
    
    public UserImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        user = new User();
        
        user.setUserPK( new UserPK ("C.C","80013833"));
        user.setEmail("cristian@gmail.com");
        user.setPassword("2001");
        user.setDateTerminate("30/11/2017");
        
        userPK = new UserPK("T.I","800133");
        
        
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void test1Insert() {
        UserDAO dao = UserFactory.create(User.class);
        dao.insert(user);
        User userBaseDatos = (User) dao.find(user.getUserPK());
        assertEquals(userBaseDatos, user);
    }
        
        
    @Test
    public void test2findpk() {
        UserDAO dao = UserFactory.create(User.class);
        User cs = (User) dao.find(user.getUserPK());
        assertEquals(cs, user);
    }
     @Test
    public void test3update() {
       
        UserDAO dao = UserFactory.create(User.class);
        user.setEmail("julian@hotmail");
        dao.update(user);
        assertEquals(dao.find(user.getUserPK()), user);
    }
     @Test
    public void test3updatePk() {
        UserDAO dao = UserFactory.create(User.class);
        dao.updatePk(userPK,user.getUserPK());
        user.setUserPK(userPK);
        assertEquals(dao.find(userPK), user);

    }
    @Test
    public void test4Remove() {
        UserDAO dao = UserFactory.create(User.class);
        user.setUserPK(userPK);
        dao.remove(user);
        assertEquals(dao.find(user.getUserPK()), null);

    }

    /**
     * Test of findByEmail method, of class UserImpl.
     */
    @Test
    public void test5FindByEmail() {
       System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByEmail("cristian@gmail.com");
        for (User user : lista) {
            assertEquals(user.getEmail(), "cristian@gmail.com");
        }
    }

    /**
     * Test of findByPassword method, of class UserImpl.
     */
    @Test
    public void test6FindByPassword() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByPassword("2001");
        for (User user : lista) {
            assertEquals(user.getPassword(), "2001");
        }
    }

    /**
     * Test of findByDateTerminate method, of class UserImpl.
     */
    @Test
    public void test7FindByDateTerminate() {
         System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByDateTerminate("30/11/2017");
        for (User user : lista) {
            assertEquals(user.getDateTerminate(), "30/11/2017");
        }
    }

    /**
     * Test of findByIdDocument method, of class UserImpl.
     */
    @Test
    public void test8FindByIdDocument() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByIdDocument("C.C");
        for (User user : lista) {
            assertEquals(user.getUserPK().getIdDocument(), "C.C");
        }
    }

    /**
     * Test of findByDocumentNumber method, of class UserImpl.
     */
    @Test
    public void test9FindByDocumentNumber() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByDocumentNumber("80013833");
        for (User user : lista) {
            assertEquals(user.getUserPK().getDocumentNumber(), "80013833");
        }
    }

    /**
     * Test of findByLikeIdDocument method, of class UserImpl.
     */
    @Test
    public void test10FindByLikeIdDocument() {
       
      System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeIdDocument("C.C");
        for (User user : lista) {
            assertEquals(user.getUserPK().getIdDocument(), "C.C");
        }
    }

    /**
     * Test of findByLikeDocumentNumber method, of class UserImpl.
     */
    @Test
    public void test11FindByLikeDocumentNumber() {
         System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeDocumentNumber("80013833");
        for (User user : lista) {
            assertEquals(user.getUserPK().getDocumentNumber(), "80013833");
        }
    }

    /**
     * Test of updatePk method, of class UserImpl.
     */
   
    
}
