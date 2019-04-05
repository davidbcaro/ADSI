/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;


import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlLevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.dao.LevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.factory.LevelTrainingDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.LevelTrainingDTO;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author 1349397
 */
public class MysqlLevelTrainingDAOTest {
    
    private LevelTrainingDTO ltd, lt;

  
    
    @Before
    public void setUp() throws Exception {
        ltd= new LevelTrainingDTO();
        ltd.setCode("Hola");
        ltd.setState(true);
        
        lt= new LevelTrainingDTO();
        lt.setCode("Yahiko1");
        lt.setState(false);
        
    }
    
    @After
    public void tearDown() throws Exception {
    }
 
   

  
    @Test
    public void testInsert() {
        LevelTrainingDAOFactory levelTrainingDAO= new MysqlLevelTrainingDAOFactory();
        LevelTrainingDAO dao= levelTrainingDAO.create();
        assertEquals(dao.insert(ltd),1);
    }

    
    @Test
    public void testUpdate() {
      LevelTrainingDAOFactory levelTrainingDAO= new MysqlLevelTrainingDAOFactory();
        LevelTrainingDAO dao= levelTrainingDAO.create();
        assertEquals(dao.update(lt, "Yahiko1"), 1);
    }

    
    @Test
    public void testDelete() {
     LevelTrainingDAOFactory factory = new MysqlLevelTrainingDAOFactory();
        LevelTrainingDAO dao = factory.create();
        assertEquals(dao.delete("que hace"),1);
    }

    
    @Test
    public void testFindAll() {
        LevelTrainingDAOFactory factory = new MysqlLevelTrainingDAOFactory();
        LevelTrainingDAO dao = factory.create();
        List<LevelTrainingDTO> lista = (List<LevelTrainingDTO>)dao.FindAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void testFindPk() {
      LevelTrainingDAOFactory factory = new MysqlLevelTrainingDAOFactory();
        LevelTrainingDAO dao = factory.create();
        LevelTrainingDTO respuesta =dao.findPk(ltd);
        assertEquals(respuesta,ltd);
    }
    
}
