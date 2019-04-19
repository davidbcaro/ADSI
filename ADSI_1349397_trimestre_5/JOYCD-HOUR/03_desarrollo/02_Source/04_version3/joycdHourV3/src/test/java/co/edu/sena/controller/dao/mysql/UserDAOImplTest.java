/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.UserDAO;
import co.edu.sena.controller.factory.UserFactory;
import co.edu.sena.model.jpa.entities.User;
import co.edu.sena.model.jpa.entities.UserPK;
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
 * @author liosalfar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOImplTest {

    private User user;
    private UserPK userpk;

    public UserDAOImplTest() {
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
        user.setEmail("wilder@misena.edu.co");;
        user.setPassword("123456789");
        user.setUserPK(new UserPK("123456789", "CC"));

        userpk = new UserPK("987654321", "CC");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByEmail method, of class UserDAOImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("Prueba insert de user");
        UserDAO dao = UserFactory.create(User.class);
        if (dao.find(user.getUserPK()) == null) {
            dao.insert(user);
        }
        assertEquals(dao.find(user.getUserPK()), user);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de find fase");
        UserDAO dao = UserFactory.create(User.class);
        User userconsulta = (User) dao.find(user.getUserPK());
        assertEquals(userconsulta, user);
        System.out.println(userconsulta);
    }

    @Test
    public void test03update() {
        System.out.println("Update datos");
        UserDAO dao = UserFactory.create(User.class);
        user.setEmail("justo@hotmail.edu.co");
        user.setPassword("justo1900");
        dao.update(user);
        assertEquals(dao.find(user.getUserPK()), user);
    }

    @Test
    public void test04vupdatePrimaryKey() {
        System.out.println("Update primarykey");
        UserDAO dao = UserFactory.create(User.class);
        dao.updatePrimaryKey(userpk, user.getUserPK());
        user.setUserPK(userpk);
        assertEquals(dao.find(userpk), user);

    }

    @Test
    public void test05FindByEmail() {
        System.out.println("Busqueda like email");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByEmail("justo@hotmail.edu.co");
        for (User email : lista) {
            assertEquals(email.getEmail(), "justo@hotmail.edu.co");
        }
        System.out.println(lista);
    }

    @Test
    public void test06FindByDocumenType() {
        System.out.println("Busqueda documenType");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeDocumenType("987654321");
        for (User doc : lista) {
            assertEquals(doc.getUserPK().getDocumentType(), "987654321");
        }
        System.out.println(lista);
    }

    @Test
    public void test07FindByIdentificactionCardNumber() {
        System.out.println("Busqueda identificationCardNumber");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByIdentificactionCardNumber("CC");
        for (User doc : lista) {
            assertEquals(doc.getUserPK().getIdentificationCardNumber(), "CC");
        }
        System.out.println(lista);
    }

    @Test
    public void test08FindByLikeEmail() {
        System.out.println("Busqueda email like");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeEmail("%j%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test09FindByLikeDocumenType() {
        System.out.println("Busqueda like document");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeDocumenType("%9%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test10FindByLikeIdentificationCardNumber() {
        System.out.println("Busqueda identificationCard");
        UserDAO dao = UserFactory.create(User.class);
        List<User> lista = dao.findByLikeIdentificactionCardNumber("%C%");
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test11delete() {
        System.out.println("Prueba del Delete");
        UserDAO dao = UserFactory.create(User.class);
        user.setUserPK(new UserPK("987654321", "CC"));
        dao.remove(user);
        assertEquals(dao.find(user.getUserPK()), null);
    }

}
