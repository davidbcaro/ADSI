package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ActivityDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.ActivityDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlActivityDAOFactory;
import co.edu.sena.tisdplandao.model.dto.ActivityDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ActivityPkDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class MysqlActivityDAOTest {

    private ActivityDTO activityDTO;
    private ActivityDTO activityDTO2;
    private ActivityPkDTO primaryKey;
    private ActivityPkDTO primaryKey2;


    @Before
    public void setUp() throws Exception {

        activityDTO = new ActivityDTO();
        activityDTO.setIdActivity("Actividad1");
        activityDTO.setName("Act1");
        activityDTO.setNamePhase("desarrollo");
        activityDTO.setProjectCode("1111");




        activityDTO2 = new ActivityDTO();
        activityDTO2.setIdActivity("Actividad2");
        activityDTO2.setName("Act2");
        activityDTO2.setNamePhase("diseño");
        activityDTO2.setProjectCode("2222");

        primaryKey = new ActivityPkDTO();
        primaryKey.setIdActivity("Actividad1");
        primaryKey.setNamePhase("desarrollo");
        primaryKey.setProjectCode("1111");

        primaryKey2 = new ActivityPkDTO();
        primaryKey2.setIdActivity("Actividad2");
        primaryKey2.setNamePhase("diseño");
        primaryKey2.setProjectCode("2222");



    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Test1insert() {
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao = factory.create();
        assertEquals(dao.insert(activityDTO), 1);
    }

    @Test
    public void Test2findAll() {
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao = factory.create();
        List<ActivityDTO> find = (List<ActivityDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }

    @Test
    public void Test3findPk() {
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao = factory.create();
        ActivityDTO find = dao.findPk(primaryKey);
    }

    @Test
    public void Test4update() {
        System.out.println("The Update");
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao = factory.create();
        assertEquals(dao.update(activityDTO2, primaryKey),1);
    }

    @Test
    public void Test5delete() {
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao = factory.create();
        assertEquals(dao.delete(primaryKey2),1);
    }




}