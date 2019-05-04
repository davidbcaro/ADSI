package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.RoleDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.RoleDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlRoleDAOFactory;
import co.edu.sena.tisdplandao.model.dto.RoleDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlRoleDAOTest {
    private RoleDTO role;
    private RoleDTO role2;

    @Before
    public void setUp() throws Exception {
        role = new RoleDTO();
        role.setIdRol("Aprendiz");
        role.setDescription("Es un aprendiz");
        role.setStatus(true);

        role2 = new RoleDTO();
        role2.setIdRol("Instructor");
        role2.setDescription("Es un instructor");
        role2.setStatus(true);
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("The Insert");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.insert(role), 1);
    }

    @Test
    public void test2findPk() {
        System.out.println("The Find Prymary Jey");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        RoleDTO find = dao.findPk("Aprendiz");
        assertEquals(find, role);
    }

    @Test
    public void test3findAll() {

        System.out.println("The Find All");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        List<RoleDTO> find = (List<RoleDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }

    @Test
    public void test4update() {
        System.out.println("The Update");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.update(role2, "Aprendiz"),1);
    }

    @Test
    public void test5delete() {
        System.out.println("The Delete");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.delete("Instructor"),1);
    }




}