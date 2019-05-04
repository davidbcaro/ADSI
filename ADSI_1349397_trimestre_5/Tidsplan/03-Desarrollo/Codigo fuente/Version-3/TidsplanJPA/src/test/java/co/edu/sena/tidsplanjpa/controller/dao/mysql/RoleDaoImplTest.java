/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.sena.tidsplanjpa.controller.dao.mysql;


import co.edu.sena.tidsplanjpa.controller.dao.RoleDao;
import co.edu.sena.tidsplanjpa.controller.factory.RoleFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Role;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleDaoImplTest {
    
   private Role ro;

   
    public RoleDaoImplTest() {
    }

    @Before
    public void setUp() {
        ro = new Role();
        ro.setIdRol("Prueba1");
        ro.setDescription("Rol");
        ro.setStatus(Boolean.TRUE);
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de insert");
        RoleDao dao = RoleFactory.create(Role.class);
        if (dao.find(ro.getIdRol()) == null) {
            dao.insert(ro);
        }
        assertEquals(dao.find(ro.getIdRol()), ro);
    }
    
    @Test
    public void test02find() {
        System.out.println("Prueba de llave primaria");
        RoleDao dao = RoleFactory.create(Role.class);
        Role r = (Role) dao.find(ro.getIdRol());
        assertEquals(r, ro);
    }
    
    @Test
    public void test03update() {
        System.out.println("Prueba update");
        RoleDao dao = RoleFactory.create(Role.class);
        ro.setDescription("rol de Instructor");
        ro.setStatus(Boolean.TRUE);
        dao.update(ro);
        assertEquals(dao.find(ro.getIdRol()) , ro);
    }
    
    @Test
    public void test04UpdatePrimaryKey(){
        System.out.println("Prueba update primary key");
        RoleDao dao = RoleFactory.create(Role.class);
        int resultado = dao.updatePrimaryKey("POP", ro.getIdRol());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test05delete() {
        System.out.println("prueba delete");
        RoleDao dao = RoleFactory.create(Role.class);
        ro.setIdRol("POP");
        dao.remove(ro);
        assertEquals(dao.find(ro.getIdRol()), null);

    }
      @Test
    public void test06FindAll() {
        System.out.println("Prueba de findAll");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> list = dao.findAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    public void test07FindByLikeIdRol() {
        System.out.println("Prueba de  findByLikeIdRole");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByLikeIdRol("%d%");
        for (Role role : lista) {
            System.out.println(role);
        }
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test08FindByIdRol() {
        System.out.println("Prueba de FindByIdRole");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByIdRol("Administrador");
        for (Role role : lista) {
            assertEquals(role.getIdRol(), "Administrador");
        }
    }

    @Test
    public void test09FindByLikeDescription() {
        System.out.println("Prueba de  FindByLikeDescription");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByLikeDescription("%ro%");
        for (Role role : lista) {
            System.out.println(role);
        }
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test10FindByDescription() {
        System.out.println("Prueba de FindByDescription");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByDescription("rol de administrador");
        for (Role role : lista) {
            assertEquals(role.getDescription(), "rol de administrador");
        }
    }
    
     @Test
    public void test11FindByStatus() {
        System.out.println("Prueba de  FindByStatus");
        RoleDao dao = RoleFactory.create(Role.class);
        List<Role> lista = dao.findByStatus(true);
        for (Role role : lista) {
            assertEquals(role.getStatus(), true);
        }
    }

    
}
