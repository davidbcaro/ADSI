/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.WorkingDayDao;
import co.edu.sena.cot.controlador.factory.mysql.WorkingDayFactory;
import co.edu.sena.cot.modelo.dto.WorkingDay;
import java.util.List;
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
public class WorkingDayImplTest {
    
    private WorkingDay word;
    
    public WorkingDayImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        word = new WorkingDay();
        word.setInitials("T");
        word.setName("Tarde");
        word.setDescription("Todos tarde");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        if (dao.find(word.getInitials()) == null) {
            dao.insert(word);
        } 
        assertEquals(dao.find(word.getInitials()), word);
    }
    
//    @Test
//    public void test2find() {
//        System.out.println("prueba de tipo de documento metodo find por llave primaria");
//        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
//        WorkingDay wd = (WorkingDay) dao.find(word.getInitials());
//        assertEquals(wd, word);
//    }
    
    @Test
    public void test3update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        word.setName("NTrade");
        word.setDescription("Nadie tarde");
        dao.update(word);
        assertEquals(dao.find(word.getInitials()), word);
    }
    
//         @Test
//    public void test4UpdatePrimaryKey(){
//        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
//        word.setInitials("T");
        //String resultado = dao.updatePrimaryKey("F", word.getInitials());
        //assertEquals(resultado, 1);
    
//    }
    
     @Test
    public void test5delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        word.setInitials("T");
        dao.remove(word);
        assertEquals(dao.find(word.getInitials()), null);

    }
    
         @Test
    public void test6FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByInitials method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByInitials() {
         System.out.println("las");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByInitials("D");
        for (WorkingDay word2 : lista) {
            assertEquals(word2.getInitials(), "D");
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of findByName method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByName() {
        System.out.println("las");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByName("Diurno");
        for (WorkingDay word2 : lista) {
            assertEquals(word2.getName(), "Diurno");
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of findByDescription method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByDescription() {
        System.out.println("las");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByDescription("Nadie tarde");
        for (WorkingDay word2 : lista) {
            assertEquals(word2.getDescription(), "Nadie tarde");
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of findByLikeInitials method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByLikeInitials() {
        System.out.println("lassssss");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeInitials("%M%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeName method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByLikeName() {
        System.out.println("lassssss");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeName("%d%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeDescription method, of class WorkingDayImpl.
     */
    @Test
    public void testFindByLikeDescription() {
        System.out.println("lassssss");
        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
        List<WorkingDay> lista = dao.findByLikeDescription("%a%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of updatePrimaryKey method, of class WorkingDayImpl.
     */
//    @Test
//    public void testUpdatePrimaryKey() {
//        WorkingDayDao dao = WorkingDayFactory.create(WorkingDay.class);
//        word.setInitials("T");
//       int resultado = dao.updatePrimaryKey("F", word.getInitials());
//        assertEquals(resultado,1 );
//    }
    
}
