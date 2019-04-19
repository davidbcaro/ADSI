/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;


import co.edu.sena.joycdhourdao.controlador.dao.RoleDAO;
import co.edu.sena.joycdhourdao.controlador.factory.RoleDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlRoleDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.RoleDTO;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlRoleDAOTest {

    private RoleDTO role;
    private RoleDTO role2;
    private RoleDTO key;

    @Before
    public void setUp() throws Exception {
        role = new RoleDTO();
        role.setIdrol("12");
        role.setDescription("la");
        role.setStatus(Boolean.TRUE);
        
        
        role2 = new RoleDTO();
        role2.setIdrol("123");
        role2.setDescription("hola");
        role2.setStatus(Boolean.TRUE);
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("prueba de insert de RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.insert(role), 1);
        
    }
    
    @Test
    public void test2FindPk() {
        System.out.println("prueba del búsqueda llave primaria de RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        RoleDTO consulta = dao.findPk("12");
        assertEquals(consulta, role);

    }

    @Test
    public void test3Update() {
        System.out.println("prueba de update de RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.update(role2, "12"), 1);
    }

    @Test
    public void test4FindAll() {
        System.out.println("findAll");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        List<RoleDTO> consulta = (List<RoleDTO>) dao.findAll();
        System.out.println(consulta);
        assertTrue(!consulta.isEmpty());

    }

    @Test
    public void test5Delete() {
        System.out.println("prueba de update de RoleDAO");
        RoleDAOFactory factory = new MysqlRoleDAOFactory();
        RoleDAO dao = factory.create();
        assertEquals(dao.delete("123"), 1);
    }

   
}
