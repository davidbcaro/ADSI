package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.TrainingLevelFactory;
import co.edu.sena.wariosoftjpa.controller.dao.TrainingLevelDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
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
public class TrainingLevelImplTest {

    private TrainingLevel tl;

    public TrainingLevelImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tl = new TrainingLevel();
        tl.setTrainingLevel("Senior");
        tl.setState(Boolean.TRUE);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("Prueba de metodo insert en TrainingLevel por llavePrimaria");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        if (dao.find(tl.getTrainingLevel()) == null) {
            dao.insert(tl);
        }
        assertEquals(dao.find(tl.getTrainingLevel()), tl);
    }

    @Test
    public void test2Find() {
        System.out.println("Prueba de metodo find en TrainingLevel por llavePrimaria");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        TrainingLevel traininglevelConsulta = (TrainingLevel) dao.find(tl.getTrainingLevel());
        assertEquals(traininglevelConsulta, tl);
    }

    @Test
    public void test3Update() {
        System.out.println("update");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        tl.setTrainingLevel("Junior");
        tl.setState(Boolean.TRUE);
        dao.update(tl);
        assertEquals(dao.find(tl.getTrainingLevel()), tl);
    }

    @Test
    public void test3UpdatePrimaryKey() {
        System.out.println("updatePrimaryKey");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        int resultado = dao.updatePrimaryKey("semijunior", tl.getTrainingLevel());
        assertEquals(resultado, 1);
    }

    @Test
    public void test4Remove() {
        System.out.println("remove");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        tl.setTrainingLevel("semijunior");
        dao.remove(tl);
        assertEquals(dao.find(tl.getTrainingLevel()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("FindAll");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindByTrainingLevel() {
        System.out.println("findByTrainingLevel");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByTrainingLevel("Junior");
        assertTrue(!lista.isEmpty());
        for (TrainingLevel traininglevel : lista) {
            assertEquals(traininglevel.getTrainingLevel(), "Junior");
        }

    }

    @Test
    public void test7FindByState() {
        System.out.println("findByState");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        for (TrainingLevel traininglevel : lista) {
            assertEquals(traininglevel.getState(), true);
        }
    }

    @Test
    public void test8FindByLikeTrainingLevel() {
        System.out.println("findByLikeTrainingLevel");
        TrainingLevelDAO dao = TrainingLevelFactory.create(TrainingLevel.class);
        List<TrainingLevel> lista = dao.findByLikeTrainingLevel("%or%");
        assertTrue(!lista.isEmpty());
    }

}
