package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.SpecialityDAO;
import co.edu.sena.tisdplandao.controller.factory.interfaceDAOfactory.SpecialityDAOFactory;
import co.edu.sena.tisdplandao.controller.factory.mysql.MysqlSpecialityDAOFactory;
import co.edu.sena.tisdplandao.model.dto.SpecialityDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MysqlSpecialityDAOTest {

    private SpecialityDTO specialityDTO;
    private SpecialityDTO specialityDTO2;

    @Before
    public void setUp() throws Exception {

        specialityDTO = new SpecialityDTO();
        specialityDTO.setNameSpeciality("Eepa");
        specialityDTO.setPhoto(null);
        specialityDTO.setStatus(true);

        specialityDTO2 = new SpecialityDTO();
        specialityDTO2.setNameSpeciality("Peter");
        specialityDTO2.setPhoto(null);
        specialityDTO2.setStatus(false);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1insert() {
        System.out.println("The Insert");
        SpecialityDAOFactory factory = new MysqlSpecialityDAOFactory();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.insert(specialityDTO), 1);
    }

    @Test
    public void test2findPk() {
        System.out.println("The Find Primari Key");
        SpecialityDAOFactory factory = new MysqlSpecialityDAOFactory();
        SpecialityDAO dao = factory.create();
        SpecialityDTO find = dao.findPk("Eepa");
        assertEquals(find, specialityDTO);
    }

    @Test
    public void test3findAll() {
        System.out.println("The Find All");
        SpecialityDAOFactory factory = new MysqlSpecialityDAOFactory();
        SpecialityDAO dao = factory.create();
        List<SpecialityDTO> find = (List<SpecialityDTO>) dao.findAll();
        assertTrue(!find.isEmpty());
    }

    @Test
    public void test4update() {
        System.out.println("The Update");
        SpecialityDAOFactory factory = new MysqlSpecialityDAOFactory();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.update(specialityDTO2, "Eepa"),1);
    }

    @Test
    public void test5delete() {
        System.out.println("The Delete");
        SpecialityDAOFactory factory = new MysqlSpecialityDAOFactory();
        SpecialityDAO dao = factory.create();
        assertEquals(dao.delete("Peter"),1);
    }




}