/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.LevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.dao.WorkingDayDAO;
import co.edu.sena.chronooftimedao.controlador.factory.LevelTrainingDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.WorkingDayDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.LevelTrainingDTO;
import co.edu.sena.chronooftimedao.modelo.dto.WorkingDayDTO;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1349397
 */
public class MysqlWorkingDayDAOTest {
    
    public MysqlWorkingDayDAOTest() {
    }
    
   private WorkingDayDTO wdd, wdd2, wd;
    
    @Before
    public void setUp() {
        
        wdd= new WorkingDayDTO();
        wdd.setInitials("F");
        wdd.setName("Feni");
        wdd.setDescription("Third Best deswaifu");
        
        wd =new WorkingDayDTO();
        wd.setInitials("REMpro");
        wd.setName("Ram");
        wd.setDescription("second beest waifu");
        
        
        
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlWorkingDayDAO.
     */
    @Test
    public void testInsert() {
        WorkingDayDAOFactory WorkingDayDAO= new MysqlWorkingDayDAOFactory();
        WorkingDayDAO dao2= WorkingDayDAO.create();
        assertEquals(dao2.insert(wdd),1);
        
    }

    @Test
    public void testUpdate() {
        WorkingDayDAOFactory factory = new MysqlWorkingDayDAOFactory();
        WorkingDayDAO dao = factory.create();
        assertEquals(dao.update(wd, "F"),1);
    }

   
    @Test
    public void testDelete() {
        WorkingDayDAOFactory factory = new MysqlWorkingDayDAOFactory();
        WorkingDayDAO dao = factory.create();
        assertEquals(dao.delete("REMpro"),1);
    }

    @Test
    public void testFindAll() {
        WorkingDayDAOFactory factory = new MysqlWorkingDayDAOFactory();
        WorkingDayDAO dao = factory.create();
        List<WorkingDayDTO> lista = (List<WorkingDayDTO>)dao.FindAll();
        System.out.println(lista);
        assertTrue(!lista.isEmpty());
    }


    @Test
    public void testFindPk() {
        WorkingDayDAOFactory factory = new MysqlWorkingDayDAOFactory();
        WorkingDayDAO dao = factory.create();
        WorkingDayDTO respuesta =dao.findPk(wd);
        assertEquals(respuesta,wd);
    }
    
}
