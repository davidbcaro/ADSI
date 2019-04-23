/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.StateNumberGroupFactory;
import co.edu.sena.wariosoftjpa.controller.dao.StateNumberGroupDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StateNumberGroupImplTest {
    
        private StateNumberGroup st;
    
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
        st = new StateNumberGroup();
        st.setNameState("activeishon");
        st.setState(true);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameState method, of class StateNumberGroupImpl.
     */
   
     @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de StateNumberGroup metodo insert");
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        if (dao.find(st.getNameState()) == null) {
            dao.insert(st);
        } 
        assertEquals(dao.find(st.getNameState()), st);
    }
    
    
    @Test
    public void test2find() {
        System.out.println("prueba de StateNumberGroup metodo find por llave primaria");
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        StateNumberGroup stateNumberGroupConsultado = (StateNumberGroup) dao.find(st.getNameState());
        assertEquals(stateNumberGroupConsultado, st);
    }
    
    
     @Test
    public void test3update() {
        System.out.println("prueba de StateNumberGroup metodo update po llave primaria");
        StateNumberGroupDAO dao =   StateNumberGroupFactory.create(StateNumberGroup.class);
        st.setState(Boolean.FALSE);
        dao.update(st);
        assertEquals(dao.find(st.getNameState()), st);
    }
    
    @Test
    public void test3updatePrimaryKey(){
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        int resultado= dao.updatePk("JJJJ", st.getNameState());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        st.setNameState("JJJJ");
        dao.remove(st);
        assertEquals(dao.find(st.getNameState()), null);

    }

      @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
       StateNumberGroupDAO dao =  StateNumberGroupFactory.create( StateNumberGroup.class);
        List< StateNumberGroup> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void test6FindByNameState() {
       
       System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        List<StateNumberGroup> lista = dao.findByNameState("activeishon");
     
        for (StateNumberGroup stateNumberGroup : lista) {
            assertEquals(stateNumberGroup.getNameState(), "activeishon");
        }
    }

    /**
     * Test of findByState method, of class StateNumberGroupImpl.
     */
    @Test
    public void test7FindByState() {
        System.out.println("findByState");
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        List<StateNumberGroup> lista = dao.findByState(true);
        assertTrue(!lista.isEmpty());
        
        for (StateNumberGroup stateNumberGroup : lista) {
            assertEquals(stateNumberGroup.getState() , true);
        }
    }
    
     @Test
    public void testFindByLikeNameState() {
        StateNumberGroupDAO dao = StateNumberGroupFactory.create(StateNumberGroup.class);
        List<StateNumberGroup> lista = dao.findByLikeNameState("a%");
        assertTrue(!lista.isEmpty());
    }
        
        
    }

    /**
     * Test of updatePrimaryKey method, of class StateNumberGroupImpl.
     */
 
    

