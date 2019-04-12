/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;


import co.edu.sena.eondao.controller.dao.ProjectDAO;
import co.edu.sena.eondao.controller.factory.ProjectDAOFactory;
import co.edu.sena.eondao.controller.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.eondao.modelo.dto.ProjectDTO;
import java.util.List;

import org.junit.After;
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
public class MysqlProjectDAOTest {

    private ProjectDTO project;
    private ProjectDTO project2;

    public MysqlProjectDAOTest() {

    }

    @Before
    public void setUp() {
        project = new ProjectDTO();
        project.setCode("13");
        project.setName("Prueba");
        project.setState(Boolean.TRUE);

        project2 = new ProjectDTO();
        project2.setCode("134");
        project2.setName("señor");
        project2.setState(Boolean.TRUE);

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of insert method, of class MysqlProjectDAO.
     */
    @Test
    public void test1Insert() {
        System.out.println("Insert");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.insert(project2),1);
    }

    @Test
    public void test3Update() {
        System.out.println("Update");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.update(project, "134"), 1);
    }

    @Test
    public void test5Delete() {
        System.out.println("Delete");
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.delete("13"),1);
    }

    @Test
    public void test4FindAll() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        List<ProjectDTO> lista = (List<ProjectDTO>) dao.findAll();
        assertTrue(!lista.isEmpty());

    }

    /**
     * Test of findPK method, of class MysqlProjectDAO.
     */
    @Test
    public void test2FindPK() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        ProjectDTO resultado = dao.findPK("134");
        assertEquals(resultado, project2);

    }

}
