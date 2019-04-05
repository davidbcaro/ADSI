/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ActivityDAO;
import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlActivityDAO;
import co.edu.sena.chronooftimedao.controlador.factory.ActivityDAOFactory;
import co.edu.sena.chronooftimedao.controlador.factory.mysql.MysqlActivityDAOFactory;
import co.edu.sena.chronooftimedao.modelo.dto.ActivityDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ActivityPkDTO;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class MysqlActivityDAOTest {
   private ActivityDTO ac1;
   private ActivityDTO ac2;
   private ActivityPkDTO yy1, yy2;
   
    public MysqlActivityDAOTest() {
    }
   
    public void setUp() {
        ac1 = new ActivityDTO();
        ac1.setId_activity(11);
        ac1.setPhase_name_phase("nellpror");
        ac1.setPhase_project_code(12345);
        ac1.setName("Hola que hace");

        ac2 = new ActivityDTO();
        ac2.setId_activity(12);
        ac2.setPhase_name_phase("Yahiko1");
        ac2.setPhase_project_code(8);
        ac2.setName("Nada :V");
        
        yy1 = new ActivityPkDTO();
        yy1.setId_activity(11);
        yy1.setPhase_name_phase("nellpror");
        yy1.setPhase_project_code(12345);

        yy2 = new ActivityPkDTO();
        yy2.setId_activity(13);
        yy2.setPhase_name_phase("asg");
        yy2.setPhase_project_code(1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class MysqlActivityDAO.
     */
    @Test
    public void testInsert() {
       System.out.println("prueba del insert de PhaseDAO");
        ActivityDAOFactory factory = new MysqlActivityDAOFactory();
        ActivityDAO dao2 = factory.create();
        assertEquals(dao2.insert(ac2), 1);
    }

    /**
     * Test of update method, of class MysqlActivityDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ActivityDTO activity = null;
        ActivityPkDTO primaryKey = null;
        MysqlActivityDAO instance = new MysqlActivityDAO();
        int expResult = 0;
        int result = instance.update(activity, primaryKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MysqlActivityDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        ActivityPkDTO primaryKey = null;
        MysqlActivityDAO instance = new MysqlActivityDAO();
        int expResult = 0;
        int result = instance.delete(primaryKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MysqlActivityDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MysqlActivityDAO instance = new MysqlActivityDAO();
        Collection<ActivityDTO> expResult = null;
        Collection<ActivityDTO> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPk method, of class MysqlActivityDAO.
     */
    @Test
    public void testFindPk() {
        System.out.println("findPk");
        ActivityPkDTO primaryKey = null;
        MysqlActivityDAO instance = new MysqlActivityDAO();
        ActivityDTO expResult = null;
        ActivityDTO result = instance.findPk(primaryKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
