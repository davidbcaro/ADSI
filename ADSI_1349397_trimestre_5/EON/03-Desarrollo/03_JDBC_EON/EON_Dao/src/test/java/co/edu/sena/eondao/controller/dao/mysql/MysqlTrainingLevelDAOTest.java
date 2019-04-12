/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.factory.mysql.MysqlTrainingLevelDAOFactory;
import co.edu.sena.eondao.modelo.dto.TrainingLevelDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import co.edu.sena.eondao.controller.dao.TrainingLevelDAO;
import co.edu.sena.eondao.controller.factory.TrainingLevelDAOFactory;

/**
 *
 * @author LUISBERNARDO
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlTrainingLevelDAOTest {
    private TrainingLevelDTO training;
    private TrainingLevelDTO training2;
    
    public MysqlTrainingLevelDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        training = new TrainingLevelDTO();
        training.setTraining_Level("Tecnica");
        training.setState(Boolean.TRUE);
        
        training2 = new TrainingLevelDTO();
        training2.setTraining_Level("Tecnico");
        training2.setState(Boolean.TRUE);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlTraining_LevelDAO.
     */
    @Test
    public void test1Insert() {
        System.out.println("Insert");
        TrainingLevelDAOFactory factory = new MysqlTrainingLevelDAOFactory();
        TrainingLevelDAO dao = factory.create();
        assertEquals(dao.insert(training),1);    
    }

    /**
     * Test of update method, of class MysqlTraining_LevelDAO.
     */
    @Test
    public void test3Update() {
        TrainingLevelDAOFactory factory = new MysqlTrainingLevelDAOFactory();
        TrainingLevelDAO dao = factory.create();
        assertEquals(dao.update(training2, "Tecnica"),1);
    }

    /**
     * Test of delete method, of class MysqlTraining_LevelDAO.
     */
    @Test
    public void test5Delete() {
        TrainingLevelDAOFactory factory = new MysqlTrainingLevelDAOFactory();
        TrainingLevelDAO dao = factory.create();
        assertEquals(dao.delete("Tecnico"), 1);
    }

    /**
     * Test of findAll method, of class MysqlTraining_LevelDAO.
     */
    @Test
    public void test4FindAll() {
        TrainingLevelDAOFactory factory = new MysqlTrainingLevelDAOFactory();
        TrainingLevelDAO dao = factory.create();
        List<TrainingLevelDTO> lista = (List<TrainingLevelDTO>)dao.findAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findPk method, of class MysqlTraining_LevelDAO.
     */
    @Test
    public void test2FindPk() {
        TrainingLevelDAOFactory factory = new MysqlTrainingLevelDAOFactory();
        TrainingLevelDAO dao = factory.create();
        TrainingLevelDTO respuesta =dao.findPk("Tecnica");
        assertEquals(respuesta, training);
    }
    
}
