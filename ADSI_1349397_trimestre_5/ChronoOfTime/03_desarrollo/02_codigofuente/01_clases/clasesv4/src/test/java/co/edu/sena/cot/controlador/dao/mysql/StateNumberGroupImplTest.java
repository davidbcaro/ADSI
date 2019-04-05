/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.StateNumberGroupDao;
import co.edu.sena.cot.controlador.factory.mysql.StateNumberGroupFactory;
import co.edu.sena.cot.modelo.dto.StateNumberGroup;
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
public class StateNumberGroupImplTest {
    
    private StateNumberGroup stateGroup;
    
    public StateNumberGroupImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        stateGroup = new StateNumberGroup();
        stateGroup.setState(false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByState method, of class StateNumberGroupImpl.
     */
    
    @Test
    public void test1Insert() {
        
        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        if (dao.find(stateGroup.getState()) == null) {
            dao.insert(stateGroup);
        } 
        assertEquals(dao.find(stateGroup.getState()), stateGroup);
    }  
    
        @Test
    public void test2find() {
        System.out.println("prueba de tipo de documento metodo find por llave primaria");
        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        StateNumberGroup stateGroup2 = (StateNumberGroup) dao.find(stateGroup.getState());
        assertEquals(stateGroup2, stateGroup);
    }
    
//        @Test
//    public void test4UpdatePrimaryKey(){
//        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
//        stateGroup.setState(false);
//        int resultado = dao.updatePrimaryKey(true, stateGroup.getState());
//        assertEquals(resultado, 1);
//    
//    }
    
         @Test
    public void test8delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        stateGroup.setState(false);
        dao.remove(stateGroup);
        assertEquals(dao.find(stateGroup.getState()), null);

    }
    
     @Test
    public void test6FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        List<StateNumberGroup> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    
    @Test
    public void testFindByState() {
        System.out.println("las");
        StateNumberGroupDao dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        List<StateNumberGroup> lista = dao.findByState(true);
        for (StateNumberGroup state : lista) {
            assertEquals(state.getState(), true);
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of updatePrimaryKey method, of class StateNumberGroupImpl.
     */
    
    
}
