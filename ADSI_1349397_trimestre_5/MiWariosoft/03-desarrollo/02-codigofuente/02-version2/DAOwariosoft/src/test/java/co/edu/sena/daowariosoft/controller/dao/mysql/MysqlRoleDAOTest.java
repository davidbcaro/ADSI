package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.factory.mysql.MysqlRoleDAOFactory;
import co.edu.sena.daowariosoft.controller.dao.RoleDAO;
import co.edu.sena.daowariosoft.controller.factory.RoleDAOFactory;
import co.edu.sena.daowariosoft.model.dto.RoleDTO;
import java.util.Collection;
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

public class MysqlRoleDAOTest {

    private RoleDTO role;
    private RoleDTO role2;
    private RoleDTO llave;

    @Before
    public void setUp() {
        role = new RoleDTO();
        role.setIdRole("Sebastian");
        role.setDescription("Rol del usuario");
        role.setState(true);

        role2 = new RoleDTO();
        role2.setIdRole("Barth");
        role2.setDescription("Persona Amarilla");
        role2.setState(false);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba del insert del RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.insert(role), 1);
    }

    @Test
    public void test2FindPk() {
    System.out.println("finpk");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        dao.findPk("sebastian");
    }
    @Test
    public void test3FindAll() {
        System.out.println("findAll");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        List<RoleDTO> consulta = (List<RoleDTO>) dao.findAll();
        assertTrue(!consulta.isEmpty());

    }

    @Test
    public void test4Update() {
        System.out.println("Prueba de la actulizacion de datos para RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.update(role2, "Sebastian"), 1);
    }

    @Test
    public void test5Delete() {
        System.out.println("delete");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.delete("Barth"), 1);
    }

    

}
