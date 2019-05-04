package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.FormationLevelDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.FormationLevelDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlFormationLevelDAOFactory;
import co.edu.sena.tisdplandao.model.dto.FormationLevelDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class MysqlFormationLevelDAOTest {
private FormationLevelDTO formationLevelDTO;
    private FormationLevelDTO formationLevelDTO2;

    @Before
    public void setUp() throws Exception {
        formationLevelDTO = new FormationLevelDTO();
        formationLevelDTO.setLevelformation("Tecnico");
        formationLevelDTO.setStatus(true);

        formationLevelDTO2 = new FormationLevelDTO();
        formationLevelDTO2.setLevelformation("Tecnlogo");
        formationLevelDTO2.setStatus(true);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Test1insert() {
        FormationLevelDAOFactory factory =  new MysqlFormationLevelDAOFactory();
        FormationLevelDAO dao = new MysqlFormationLevelDAO();
        assertEquals(dao.insert(formationLevelDTO),1);
    }

    @Test
    public void Test2findPk() {
            FormationLevelDAOFactory factory = new MysqlFormationLevelDAOFactory();
            FormationLevelDAO dao = factory.create();
            dao.findPk("Tecnico");





    }
    @Test
    public void Test3findAll() {
        FormationLevelDAOFactory factory = new MysqlFormationLevelDAOFactory();
        FormationLevelDAO dao = factory.create();
        List<FormationLevelDTO> find = (List<FormationLevelDTO>) dao.findAll();
        assertTrue(!find.isEmpty());

    }



    @Test
    public void Test4update() {
        FormationLevelDAOFactory factory = new MysqlFormationLevelDAOFactory();
        FormationLevelDAO dao = factory.create();
        assertEquals(dao.update(formationLevelDTO2, "Tecnico"),1);
    }

    @Test
    public void Test5delete() {
        FormationLevelDAOFactory factory = new MysqlFormationLevelDAOFactory();
        FormationLevelDAO dao = factory.create();
        assertEquals(dao.delete("Tecnlogo"),1);
    }




}