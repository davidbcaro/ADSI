/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.StateGroupDao;
import co.edu.sena.tidsplanjpa.controller.factory.StateGroupFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.StateGroup;
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
public class StateGroupDaoImplTest {

    StateGroup sg;

    public StateGroupDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sg = new StateGroup();
        sg.setNameState("Prueba");
        sg.setStatus(true);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de estado de grupo metodo insert");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        if (dao.find(sg.getNameState()) == null) {
            dao.insert(sg);

        }
        assertEquals(dao.find(sg.getNameState()), sg);
    }

    @Test
    public void test02find() {
        System.out.println("Prueba de estado de grupo metodo Find");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        StateGroup stateGroupConsulted = (StateGroup) dao.find(sg.getNameState());
        assertEquals(stateGroupConsulted, sg);
    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de estado de grupo metodo Update");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        sg.setStatus(false);
        dao.update(sg);
        assertEquals(dao.find(sg.getNameState()), sg);

    }

    @Test
    public void test04UpdatePrimaryKey() { 
        System.out.println("Prueba de estado de grupo metodo UpdatePrimaryKey");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        int result = dao.updatePrimaryKey("Prueba22", sg.getNameState());
        assertEquals(result, 1);
    }
    

    @Test
    public void test05Delete() {
        System.out.println("Prueba de estado de grupo metodo Delete");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        sg.setNameState("Prueba22");
        dao.remove(sg);
        assertEquals(dao.find(sg.getNameState()), null);
    }

    
    @Test
    public void test06FindAll() {
        System.out.println("Prueba de estado de grupo metodo FindAll");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        List<StateGroup> list = dao.findAll();
        assertTrue(!list.isEmpty());
        for (StateGroup stateGroup : list) {
            System.out.println(stateGroup);
        }

    }

    @Test
    public void test07FindByLikeNameState() {
        System.out.println("Prueba de estado de grupo metodo findByLikeNameState");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        List<StateGroup> list = dao.findByLikeNameState("%o%");
        assertTrue(!list.isEmpty());
        for (StateGroup stateGroup : list) {
            System.out.println(stateGroup);
        }

    }

    @Test
    public void test08FindByNameState() {
        System.out.println("Prueba de estado de grupo metodo findByNameState");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        List<StateGroup> list = dao.findByNameState("Terminada");
        assertTrue(!list.isEmpty());
        for (StateGroup stateGroup : list) {
            assertEquals(stateGroup.getNameState(), "Terminada");
        }

    }
    
    @Test
    public void test09FindByStatus() {
        System.out.println("Prueba de find by status");
        StateGroupDao dao = StateGroupFactory.create(StateGroup.class);
        List<StateGroup> list = dao.findByStatus(Boolean.FALSE);
        for (StateGroup stateGroup : list) {
            System.out.println(stateGroup);
            assertEquals(stateGroup.getStatus(), Boolean.FALSE);
        }
      

    }

    
}



