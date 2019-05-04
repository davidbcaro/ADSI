package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectPhaseDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ProjectPhaseDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlProjectPhaseDAOFactory;
import co.edu.sena.tisdplandao.model.dto.ProjectPhaseDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ProjectPhasePkDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MysqlProjectPhaseDAOTest {

    private ProjectPhaseDTO projectPhaseDTO;
    private ProjectPhaseDTO projectPhaseDTO2;
    private ProjectPhaseDTO projectPhaseDTO3;
    private ProjectPhaseDTO projectPhaseDTO4;
    private ProjectPhasePkDTO primaryKey;
    private ProjectPhasePkDTO primaryKey2;

    @Before
    public void setUp() throws Exception {
        projectPhaseDTO = new ProjectPhaseDTO();
        projectPhaseDTO.setNamePhase("diseño");
        projectPhaseDTO.setStatus(true);
        projectPhaseDTO.setProjectCode("111");

        projectPhaseDTO2 = new ProjectPhaseDTO();
        projectPhaseDTO2.setNamePhase("desarrollo");
        projectPhaseDTO2.setStatus(true);
        projectPhaseDTO2.setProjectCode("222");

        projectPhaseDTO3 = new ProjectPhaseDTO();
        projectPhaseDTO3.setNamePhase("desarrollo");
        projectPhaseDTO3.setStatus(true);
        projectPhaseDTO3.setProjectCode("1111");

        projectPhaseDTO4 = new ProjectPhaseDTO();
        projectPhaseDTO4.setNamePhase("diseño");
        projectPhaseDTO4.setStatus(true);
        projectPhaseDTO4.setProjectCode("2222");




        primaryKey2 = new ProjectPhasePkDTO();
        primaryKey2.setNamePhase("diseño");
        primaryKey2.setProjectCode("111");

        primaryKey = new ProjectPhasePkDTO();
        primaryKey.setNamePhase("desarrollo");
        primaryKey.setProjectCode("222");






    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        ProjectPhaseDAOFactory factory = new MysqlProjectPhaseDAOFactory();
        ProjectPhaseDAO dao = factory.create();
        assertEquals(dao.insert(projectPhaseDTO), 1);
        dao.insert(projectPhaseDTO3);
        dao.insert(projectPhaseDTO4);
    }
    @Test
    public void test2findPk() {
        ProjectPhaseDAOFactory factory = new MysqlProjectPhaseDAOFactory();
        ProjectPhaseDAO dao = factory.create();
        ProjectPhaseDTO find = dao.findPk(primaryKey2);
        assertEquals(find, projectPhaseDTO);
    }

    @Test
    public void test3findAll() {
        ProjectPhaseDAOFactory factory = new MysqlProjectPhaseDAOFactory();
        ProjectPhaseDAO dao = factory.create();
        List<ProjectPhaseDTO> find = (List<ProjectPhaseDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }
    @Test
    public void test4update() {
        ProjectPhaseDAOFactory factory = new MysqlProjectPhaseDAOFactory();
        ProjectPhaseDAO dao = factory.create();
        assertEquals(dao.update(projectPhaseDTO2, primaryKey2),1);
    }

    @Test
    public void test5delete() {
        ProjectPhaseDAOFactory factory = new MysqlProjectPhaseDAOFactory();
        ProjectPhaseDAO dao = factory.create();
        assertEquals(dao.delete(primaryKey),1);
    }

}