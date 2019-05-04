/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.FormationLevelDao;
import co.edu.sena.tidsplanjpa.controller.factory.FormationLevelFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel;
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
public class FormationLevelDaoImplTest {

    FormationLevel fl;

    public FormationLevelDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fl = new FormationLevel();
        fl.setLevelFormation("Especializado");
        fl.setStatus(false);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Nivel de formacion metodo insert");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        if (dao.find(fl.getLevelFormation()) == null) {
            dao.insert(fl);

        }
        assertEquals(dao.find(fl.getLevelFormation()), fl);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de Nivel de formacion metodo Find");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        FormationLevel formationLevelConsulted = (FormationLevel) dao.find(fl.getLevelFormation());
        assertEquals(formationLevelConsulted, fl);

    }

    @Test
    public void test03Update() {
        System.out.println("Prueba de Nivel de formacion metodo Update");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        fl.setStatus(true);
        dao.update(fl);
        assertEquals(dao.find(fl.getLevelFormation()), fl);

    }

    @Test
    public void test04UpdatePrimaryKey() {
        System.out.println("Prueba de Nivel de formacion metodo UpdatePrimaryKey");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        int result = dao.updatePrimaryKey("Especial", fl.getLevelFormation());
        assertEquals(result, 1);
    }
    
    @Test 
    public void test05Delete(){
        System.out.println("Prueba de Nivel de formacion metodo Delete");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        fl.setLevelFormation("Especial");
        dao.remove(fl);
        assertEquals(dao.find(fl.getLevelFormation()), null);
    }

    @Test
    public void test06FindAll() {
        System.out.println("Prueba de Nivel de formacion metodo FindaAll");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        List<FormationLevel> list = dao.findAll();
        assertTrue(!list.isEmpty());
        for (FormationLevel formationLevel : list) {
            System.out.println(formationLevel);
        }
        

    }

    @Test
    public void test07FindByLikeLevelFormation() {
        System.out.println("Prueba de Nivel de formacion metodo FindByLikeLevelFormation");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        List<FormationLevel> lista = dao.findByLikeLevelFormation("%o%");
        assertTrue(!lista.isEmpty());
        for (FormationLevel formationLevel : lista) {
            System.out.println(formationLevel);
        }
        
    }

    
    @Test
    public void test08FindByLevelFormation() {
        System.out.println("Prueba de Nivel de formacion metodo findByLevelFormation");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        List<FormationLevel> list = dao.findByLevelFormation("tecnologo");
        assertTrue(!list.isEmpty());
        for (FormationLevel formationLevel : list) {
            System.out.println(formationLevel);
            assertEquals(formationLevel.getLevelFormation(), "tecnologo");
        }
       
    }

   
    @Test
    public void test09FindByStatus() {
        System.out.println("Prueba de Nivel de formacion metodo findByStatus");
        FormationLevelDao dao = FormationLevelFactory.create(FormationLevel.class);
        List<FormationLevel> list = dao.findByStatus(true);
        assertTrue(!list.isEmpty());  
        for (FormationLevel formationLevel : list) {
            assertEquals(formationLevel.getStatus(), true);
        }
    }
}
