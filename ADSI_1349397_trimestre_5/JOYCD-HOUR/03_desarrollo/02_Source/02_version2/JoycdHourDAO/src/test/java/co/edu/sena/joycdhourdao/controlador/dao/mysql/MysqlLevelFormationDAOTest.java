/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;


import co.edu.sena.joycd.modelo.DTO.LevelFormationDTO;
import co.edu.sena.joycdhourdao.controlador.dao.LevelFormationDAO;
import co.edu.sena.joycdhourdao.controlador.factory.LevelFormationDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlLevelFormationDAOFactory;
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

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlLevelFormationDAOTest {

    private LevelFormationDTO project;
    private LevelFormationDTO project2;
    private LevelFormationDTO key;

    @Before
    public void setUp() {
        project = new LevelFormationDTO();
        project.setLevelFormation("123");
        project.setStatus(Boolean.TRUE);

        project2 = new LevelFormationDTO();
        project2.setLevelFormation("54321");
        project2.setStatus(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1insert() {
        System.out.println("prueba de insert de LevelFormationDAO");
        LevelFormationDAOFactory factory = new MysqlLevelFormationDAOFactory();
        LevelFormationDAO dao = factory.create();
        assertEquals(dao.insert(project), 1);

    }

    @Test
    public void test2FindPk() {
        System.out.println("prueba del busqueda llave primaria de LevelFormationDAo");
        LevelFormationDAOFactory factory = new MysqlLevelFormationDAOFactory();
        LevelFormationDAO dao = factory.create();
        LevelFormationDTO consulta = dao.findPk("123");
        assertEquals(consulta, project);

    }
     @Test
    public void test3Update() {
        System.out.println("prueba de update de LevelFormationDAO");
       LevelFormationDAOFactory factory = new MysqlLevelFormationDAOFactory();
        LevelFormationDAO dao = factory.create();
        assertEquals(dao.update(project2, "123"), 1);
    }

    @Test
    public void test4FindAll() {
        System.out.println("findAll");
        LevelFormationDAOFactory factory = new MysqlLevelFormationDAOFactory();
       LevelFormationDAO dao = factory.create();
        List<LevelFormationDTO> consulta = (List<LevelFormationDTO>) dao.findAll();
        System.out.println(consulta);
        assertTrue(!consulta.isEmpty());

    }
    @Test
    public void test5Delete() {
        System.out.println("prueba de update de LevelFormationDao");
       LevelFormationDAOFactory factory = new MysqlLevelFormationDAOFactory();
      LevelFormationDAO dao = factory.create();
        assertEquals(dao.delete("54321"), 1);
    }

}
