package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ProjectDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlProjectDAOFactory;
import co.edu.sena.tisdplandao.model.dto.ProjectDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MysqlProjectDAOTest {
    private ProjectDTO projectDTO;
    private ProjectDTO projectDTO2;
    private ProjectDTO projectDTO3;
    private ProjectDTO projectDTO4;
    private ProjectDTO projectDTO5;
    private ProjectDTO projectDTO6;



    @Before
    public void setUp() throws Exception {
        projectDTO = new ProjectDTO();
        projectDTO.setCode("123");
        projectDTO.setName("asd");
        projectDTO.setStatus(true);

        projectDTO2 = new ProjectDTO();
        projectDTO2.setCode("321");
        projectDTO2.setName("dsa");
        projectDTO2.setStatus(false);

        projectDTO3 = new ProjectDTO();
        projectDTO3.setCode("111");
        projectDTO3.setName("Proyecto1");
        projectDTO3.setStatus(true);

        projectDTO4 = new ProjectDTO();
        projectDTO4.setCode("1111");
        projectDTO4.setName("Proyecto3");
        projectDTO4.setStatus(true);

        projectDTO5 = new ProjectDTO();
        projectDTO5.setCode("222");
        projectDTO5.setName("Proyecto2");
        projectDTO5.setStatus(true);

        projectDTO6 = new ProjectDTO();
        projectDTO6.setCode("2222");
        projectDTO6.setName("Proyecto4");
        projectDTO6.setStatus(true);




    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {


        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.insert(projectDTO), 1);
        dao.insert(projectDTO3);
        dao.insert(projectDTO4);
        dao.insert(projectDTO5);
        dao.insert(projectDTO6);

    }

    @Test
    public void test2findPk() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        ProjectDTO find = dao.findPk("123");
        assertEquals(find, projectDTO);

    }

    @Test
    public void test3findAll() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        List<ProjectDTO> find = (List<ProjectDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }


    @Test
    public void test4update() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.update(projectDTO2, "123"),1);
    }

    @Test
    public void test5delete() {
        ProjectDAOFactory factory = new MysqlProjectDAOFactory();
        ProjectDAO dao = factory.create();
        assertEquals(dao.delete("321"),1);

    }

}