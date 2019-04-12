/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.RoleDao;
import co.edu.sena.eon_jpa.controller.factory.RoleFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Role;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleDaolmplTest {

      Role r;

      public RoleDaolmplTest() {
      }

      @BeforeClass
      public static void setUpClass() {
      }

      @AfterClass
      public static void tearDownClass() {
      }

      @Before
      public void setUp() {

            r = new Role();
            r.setIdRole("nuevoRole");
            r.setDescription("ya tu sabes ");
            r.setStatus(Boolean.TRUE);

      }

      @After
      public void tearDown() {
      }

      @Test
      public void test1Insert() {
            System.out.println("prueba de tipo de documento metodo insert");
            RoleDao dao = RoleFactory.create(Role.class);
            if (dao.find(r.getIdRole()) == null) {
                  dao.insert(r);
            }
            assertEquals(dao.find(r.getIdRole()), r);
      }

      @Test
      public void test2find() {
            System.out.println("prueba de tipo de documento metodo find por llave primaria");
            RoleDao dao = RoleFactory.create(Role.class);
            Role idRoleconsultado = (Role) dao.find(r.getIdRole());
            assertEquals(idRoleconsultado, r);
      }

      @Test
      public void test3update() {
            System.out.println("prueba de tipo de documento metodo update po llave primaria");
            RoleDao dao = RoleFactory.create(Role.class);
            r.setDescription("no no se");
            r.setStatus(Boolean.FALSE);
            dao.update(r);
            assertEquals(dao.find(r.getIdRole()), r);
      }

      @Test
      public void test3vUpdatePrimaryKey() {
            RoleDao dao = RoleFactory.create(Role.class);
            int resultado = dao.updatePrimaryKey("uctor", r.getIdRole());
            assertEquals(resultado, 1);

      }

      @Test
      public void test4Delete() {
            System.out.println("Test Delete");
            RoleDao dao = RoleFactory.create(Role.class);
            r.setIdRole("uctor");
            dao.remove(r);
            assertEquals(dao.find(r.getIdRole()), null);

      }

      @Test
      public void test5FindAll() {
            System.out.println("prueba metodo findall");
            RoleDao dao = RoleFactory.create(Role.class);
            List<Role> lista = dao.findAll();
            assertTrue(!lista.isEmpty());
      }

      @Test
      public void test6FindDescripcion() {
            System.out.println("prueba de metodo findDescripcion del dao");
            RoleDao dao = RoleFactory.create(Role.class);
            List<Role> lista = dao.findByDescription("no no se");
            for (Role r : lista) {
                  assertEquals(r.getDescription(), "no no se");
            }
      }

      @Test
      public void test6FindIdRole() {
            System.out.println("prueba de metodo findDescripcion del dao");
            RoleDao dao = RoleFactory.create(Role.class);
            List<Role> lista = dao.findByIdRole("Lider del Programa");
            for (Role r : lista) {
                  assertEquals(r.getIdRole(), "Lider del Programa");
            }
      }

      @Test
      public void test6Findstatus() {
            System.out.println("prueba de metodo findDescripcion del dao");
            RoleDao dao = RoleFactory.create(Role.class);
            List<Role> lista = dao.findByStatus(true);
            for (Role r : lista) {
                  assertEquals(r.getStatus(), true);
            }
      }

      @Test
      public void test6FindBylikeIdRole() {
            System.out.println("prueba del metodo findDescripcion del dao ");
            RoleDao dao = RoleFactory.create(Role.class);
            List<Role> lista = dao.findBylikeIdRole("A%");
            assertTrue(!lista.isEmpty());

      }
}
